package sample.SetTypes;

public enum ArmorTypes {

    LIGHT_LEATHER("Viking", "Light Leather", 1.0, -0.01),
    HEAVY_LEATHER("Viking", "Heavy Leather", 1.5, -0.02),
    LIGHT_CLOTHING("Mongols", "Light Clothing", 0.5, -0.0),
    LEATHER_CLOTHING("Mongols", "Leather Clothing", 1.0, -0.01),
    LIGHT_IRON("Teutonic knight", "Light Iron", 3.0, -0.08),
    HEAVY_IRON("Teutonic knight", "Heavy Iron", 5.0, -0.1),
    DOU("Samurai", "Dou", 2.0, -0.03),
    YOROI("Samurai", "Yoroi", 3.0, -0.05);

    private final String warrior;
    private final String armor;
    private final double armorStats;
    private final double agility;

    ArmorTypes(String warrior, String armor, double armorStats, double agility){
        this.warrior = warrior;
        this.armor = armor;
        this.armorStats = armorStats;
        this.agility = agility;
    }

    public String getWarrior() {
        return this.warrior;
    }

    public String getArmor() {
        return this.armor;
    }

    public double getArmorStats() {
        return this.armorStats;
    }

    public double getAgility() {
        return this.agility;
    }

}


