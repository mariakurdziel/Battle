package sample;


public class PredictingFight {

    private double firePowerBlue;
    private double numberBlue;
    private double firePowerRed;
    private double numberRed;
    private double solution;

    public int lanchesterEquation(Army blue, Army red) {
        numberBlue = blue.getNumber();
        numberRed = red.getNumber();
        firePowerBlue = (blue.getAttack()+blue.getMorale()) * (blue.getAttackSpeed()+(blue.getMorale()*0.1)) +
                        (blue.getArmorStats()+blue.getMorale())*(blue.getAgility()+(blue.getMorale()*0.1));
        firePowerRed = (red.getAttack()+red.getMorale()) * (red.getAttackSpeed()+(red.getMorale()*0.1)) +
                         (red.getArmorStats()+red.getMorale())*(red.getAgility()+(red.getMorale()*0.1));

        solution = firePowerBlue * numberBlue * numberBlue - firePowerRed * numberRed * numberRed;

        if(solution > 0) return 1;          // blue won
        else if (solution == 0) return 0;   // draw
        else return -1;                     // red won

    }


}
