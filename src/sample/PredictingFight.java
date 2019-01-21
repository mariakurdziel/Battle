package sample;


import sample.SetTypes.ArmorTypes;

import java.util.Random;

public class PredictingFight {

    private double firePowerBlue;
    private double numberBlue;
    private double firePowerRed;
    private double numberRed;
    private double solution;
    public double blueHealth;
    public double redHealth;
    public int whoWon = 0;

    public int lanchesterEquation(Army blue, Army red) {
        changingMorale(blue, red);
        summaryHealth(blue, red);
        killingEnemy(blue, red);
        numberBlue = blue.getNumber();
        numberRed = red.getNumber();
        firePowerBlue = (blue.getAttack()+blue.getMorale()) * (blue.getAttackSpeed()+(blue.getMorale()*0.1)) +
                        (blueHealth + blue.getArmorStats()+blue.getMorale())*(blue.getAgility()+(blue.getMorale()*0.1));
        firePowerRed = (red.getAttack()+red.getMorale()) * (red.getAttackSpeed()+(red.getMorale()*0.1)) +
                         (redHealth + red.getArmorStats()+red.getMorale())*(red.getAgility()+(red.getMorale()*0.1));

        solution = firePowerBlue * numberBlue * numberBlue - firePowerRed * numberRed * numberRed;

        if(solution > 0) return 1;          // blue won
        else if (solution == 0) return 0;   // draw
        else return -1;                     // red won

    }

    public void changingMorale(Army blue, Army red){

        if ( blue.getNumber() / red.getNumber() >= 2.5) { solution = 1; whoWon = 1; }
        else if ( blue.getNumber() / red.getNumber() >= 2) { red.setMorale(red.getMorale() - 0.5); blue.setMorale(red.getMorale() + 0.5); }
        else if ( blue.getNumber() / red.getNumber() > 1.5) {red.setMorale(red.getMorale() - 0.2);blue.setMorale(red.getMorale() + 0.2); }
        else if ( blue.getNumber() / red.getNumber() == 1) { red.setMorale(red.getMorale() + 0.0);blue.setMorale(red.getMorale() + 0.0); }
        else if ( blue.getNumber() / red.getNumber() < 0.6) { red.setMorale(red.getMorale() + 0.2);blue.setMorale(red.getMorale() - 0.2); }
        else if ( blue.getNumber() / red.getNumber() <= 0.5) {red.setMorale(red.getMorale() + 0.5);blue.setMorale(red.getMorale() - 0.5); }
        else if ( blue.getNumber() / red.getNumber() <= 0.4) { solution = -1; whoWon = -1; }
    }

    public void summaryHealth(Army blue, Army red){
        blueHealth = blue.getHealthPoints() * blue.getNumber();
        redHealth = red.getHealthPoints() * red.getNumber();
    }

    public void killingEnemy(Army blue, Army red){
            Random randBlue = new Random();
            Random randRed = new Random();
            int blueChance = randBlue.nextInt(100);
            int redChance = randRed.nextInt(100);

              if(redChance > red.getAgility()){
                  double dmg = (blue.getAttack() * blue.getAttackSpeed()) - red.getArmorStats();
                  redHealth -= dmg;
                  if(redHealth <= 0) whoWon = 1;
                  else red.setHealthPoints(red.getHealthPoints() - dmg);
              }

              if(blueChance > blue.getAgility()){
                  double dmg = (red.getAttack() * red.getAttackSpeed()) - red.getArmorStats();
                  blueHealth -= dmg;
                  if(blueHealth <= 0) whoWon = -1;
                  else blue.setHealthPoints(blue.getHealthPoints() - dmg);
              }
    }

}
