package sample;

public enum Army {

    VIKING("Viking", 120.0, 0.15, 2.2),
    MONGOLS("Mongols",130,0.12, 2.1),
    TEUTONIC("Teutonic Knights", 150.0, 0.1, 2.0),
    SAMURAI("Samurai", 100, 0.13, 2.4);

    private String warrior;
    private String armor;
    private String weapon;
    private double healthPoints;
    private double agility;
    private double attackSpeed;
    private double attack;
    private double armorStats;
    private double morale;


    Army(String warrior, double healthPoints, double agility, double attackSpeed){
        this.warrior = warrior;
        this.healthPoints = healthPoints;
        this.agility = agility;
        this.attackSpeed = attackSpeed;
    }

    public String getWarrior() {
        return this.warrior;
    }


    public void setWarrior(String warrior) {
        this.warrior = warrior;
    }

    public double getHealthPoints() {
        return this.healthPoints;
    }

    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
    }

    public double getAgility() {
        return this.agility;
    }

    public void setAgility(double agility) {
        this.agility = agility;
    }

    public double getAttackSpeed() {
        return this.attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public double getAttack() {
        return this.attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public double getArmorStats() {
        return this.armorStats;
    }

    public void setArmorStats(double armorStats) {
        this.armorStats = armorStats;
    }

    public double getMorale() {
        return this.morale;
    }

    public void setMorale(double morale) {
        this.morale = morale;
    }

}
