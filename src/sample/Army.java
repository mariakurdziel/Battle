package sample;

import java.util.List;

public class Army {

    private String warrior;
    private String armor;
    private String weapon;
    private double healthPoints;
    private double agility;
    private double attackSpeed;
    private double attack;
    private double armorStats;
    private int number;
    private List<Squads> squads;

    Army(String warrior, String armor, String weapon, double healthPoints, double agility,
         double attackSpeed, int number, List<Squads> squads){
        this.warrior = warrior;
        this.armor = armor;
        this.weapon = weapon;
        this.healthPoints = healthPoints;
        this.agility = agility;
        this.attackSpeed = attackSpeed;
        this.number = number;
        this.squads = squads;
    }

    public String getWarrior() {
        return this.warrior;
    }

    public void setWarrior(String warrior) {
        this.warrior = warrior;
    }

    public String getArmor() {
        return armor;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Squads> getSquads() {
        return squads;
    }

    public void setSquads(List<Squads> squads) {
        this.squads = squads;
    }

}
