package sample.SetTypes;

public enum WeaponTypes {

    DAGGER("Viking", "Dagger", 3.0, 0.2),
    AXE("Viking", "Axe", 5.0, 0.0),
    SPEAR("Mongols", "Spear", 5.5, -0.3),
    SHORT_SWORD("Mongols", "Short sword", 4.0, -0.1),
    SWORD("Teutonic knight", "Sword", 6.0, -0.5),
    LONGSWORD("Teutonic knight", "Longword", 10.0, -1.0),
    BOW("Samurai", "Bow", 6.0, -0.4),
    TACHI("Samurai", "Tachi", 5.0, 0.1);

    private final String warrior;
    private final String weapon;
    private final double attack;
    private final double attackSpeed;

    WeaponTypes(String warrior, String weapon, double attack, double attackSpeed){
        this.warrior = warrior;
        this.weapon = weapon;
        this.attack = attack;
        this.attackSpeed = attackSpeed;
    }

    public String getWarrior() {
        return this.warrior;
    }

    public String getWeapon() {
        return this.weapon;
    }

    public double getAttack() {
        return this.attack;
    }

    public double getAttackSpeed() {
        return this.attackSpeed;
    }

}
