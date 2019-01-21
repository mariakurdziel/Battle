package sample;


import sample.SetTypes.ArmorTypes;

import java.util.Random;

public class PredictingFight {

    private double firePowerBlue;
    private double numberBlue;
    private double firePowerRed;
    private double numberRed;
    public double solution;
    public double blueHealth;
    public double redHealth;
    public int whoWon;

    public void updateInfo(Army blue, Army red){
        for (Squads sqd : blue.getSquads()) {
            for(Squads sqdr : red.getSquads()) {
                changingMorale(sqd, sqdr);
                summaryHealth(sqd, sqdr);
                killingEnemy(sqd, sqdr);
            }
        }
    }
    
    public int lanchesterEquation(Army blue, Army red) {
        
        updateInfo(blue, red);
        numberBlue = blue.getNumber();
        numberRed = red.getNumber();
        firePowerBlue = (blue.getAttack()) * (blue.getAttackSpeed()) +
                        (blueHealth + blue.getArmorStats())*(blue.getAgility());
        firePowerRed = (red.getAttack()) * (red.getAttackSpeed()) +
                         (redHealth + red.getArmorStats())*(red.getAgility());

        solution = firePowerBlue * numberBlue * numberBlue - firePowerRed * numberRed * numberRed;

        if(solution > 0) return 1;          // blue won
        else if (solution == 0) return 0;   // draw
        else return -1;                     // red won

    }

    public void changingMorale(Squads blue, Squads red){

        if ( blue.getPopulation() / red.getPopulation() >= 2.5) { solution = 1; whoWon = 1; }
        else if ( blue.getPopulation() / red.getPopulation() >= 2) { red.setMorale(red.getMorale() - 0.5); blue.setMorale(red.getMorale() + 0.5); }
        else if ( blue.getPopulation() / red.getPopulation() > 1.5) {red.setMorale(red.getMorale() - 0.2);blue.setMorale(red.getMorale() + 0.2); }
        else if ( blue.getPopulation() / red.getPopulation() == 1) { red.setMorale(red.getMorale() + 0.0);blue.setMorale(red.getMorale() + 0.0); }
        else if ( blue.getPopulation() / red.getPopulation() < 0.6) { red.setMorale(red.getMorale() + 0.2);blue.setMorale(red.getMorale() - 0.2); }
        else if ( blue.getPopulation() / red.getPopulation() <= 0.5) {red.setMorale(red.getMorale() + 0.5);blue.setMorale(red.getMorale() - 0.5); }
        else if ( blue.getPopulation() / red.getPopulation() <= 0.4) { solution = -1; whoWon = -1; }
    }

    public void summaryHealth(Squads blue, Squads red){
        redHealth = red.getHealth() * red.getPopulation();
        blueHealth = blue.getHealth() * blue.getPopulation();
    }

    public void killingEnemy(Squads blue, Squads red){
            Random randBlue = new Random();
            int blueChance = randBlue.nextInt(100);

        for (int i = 0; i < blue.getPopulation(); i++) {
            if (blueChance > blue.getAgility()) {
                double dmg = (red.getAttack() * red.getAttackSpeed()) - blue.getArmorStats();
                blueHealth -= dmg;
                blue.setHealth(blue.getHealth() - dmg);
            }
            if (blueHealth <= 0) { whoWon = 1; }
        }
    }

    public void BresenhamFinding(Squads red, Squads blue){
        int x1 = red.getX();
        int y1 = red.getY();
        int x2 = blue.getX();
        int y2 = blue.getY();

        // zmienne pomocnicze
        int d, dx, dy, ai, bi, xi, yi;
        int x = x1, y = y1;
        // ustalenie kierunku rysowania
        if (x1 < x2)
        {
            xi = 1;
            dx = x2 - x1;
        }
        else
        {
            xi = -1;
            dx = x1 - x2;
        }
        // ustalenie kierunku rysowania
        if (y1 < y2)
        {
            yi = 1;
            dy = y2 - y1;
        }
        else
        {
            yi = -1;
            dy = y1 - y2;
        }
        // pierwszy piksel
        // oś wiodąca OX
        if (dx > dy)
        {
            ai = (dy - dx) * 2;
            bi = dy * 2;
            d = bi - dx;
            // pętla po kolejnych x
            while (x != x2)
            {
                // test współczynnika
                if (d >= 0)
                {
                    red.setX(x + xi);
                    red.setY(y + yi);
                    d += ai;
                }
                else
                {
                    d += bi;
                    red.setX(x + xi);
                }
            }
        }
        // oś wiodąca OY
        else
        {
            ai = ( dx - dy ) * 2;
            bi = dx * 2;
            d = bi - dy;
            // pętla po kolejnych y
            while (red.getY() != y2)
            {
                // test współczynnika
                if (d >= 0)
                {
                    red.setX(x + xi);
                    red.setY(y + yi);
                    d += ai;
                }
                else
                {
                    d += bi;
                    red.setY(y + yi);
                }
            }
        }

    }

}
