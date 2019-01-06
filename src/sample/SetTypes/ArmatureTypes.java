package sample.SetTypes;

public enum ArmatureTypes{

    LIGHT_LEATHER("Viking", "Light Leather", 1.0, -0.01),
    HEAVY_LEATHER("Viking", "Heavy Leather", 1.5, -0.02),
    LIGHT_CLOTHING("Mongols", "Light Clothing", 0.5, -0.0),
    LEATHER_CLOTHING("Mongols", "Leather Clothing", 1.0, -0.01),
    LIGHT_IRON("Teutonic knight", "Light Iron", 3.0, -0.08),
    HEAVY_IRON("Teutonic knight", "Heavy Iron", 5.0, -0.1),
    DOU("Samurai", "Dou", 2.0, -0.03),
    YOROI("Samurai", "Yoroi", 3.0, -0.05);

    private final String warrior;
    private final String armature;
    private final double armor;
    private final double agility;

    ArmatureTypes(String warrior, String armature, double armor, double agility){
        this.warrior = warrior;
        this.armature = armature;
        this.armor = armor;
        this.agility = agility;
    }

    public String getWarrior() {
        return this.warrior;
    }

    public String getArmature() {
        return this.armature;
    }

    public double getArmor() {
        return this.armor;
    }

    public double getAgility() {
        return this.agility;
    }

}


