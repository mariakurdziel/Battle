package sample;

public enum TextHandler {

    TEXT_B1("B","Number","Army 1: ",1000,140,16),
    TEXT_B2("B","Warrior","Wojownik: ",950,180,16),
    TEXT_B3("B","Armor","Uzbrojenie: ",950,200,16),
    TEXT_B4("B","Weapon","Broń: ",950,220,16),
    TEXT_B5("B","Morale","Ilosc druzyn: ",950,240,16),
    TEXT_B6("B","HealthPoints","Życia: ",950,260,16),
    TEXT_B7("B","Agility","Zwinność: ",950,280,16),
    TEXT_B8("B","Atak","Atak: ",950,300,16),
    TEXT_B9("B","Speed","Szybkość ataku: ",950,320,16),
    TEXT_B10("B","ArmorStats","Zbroja: ",950,340,16),
    TEXT_R1("R","Number","Army 1: ",1000,420,16),
    TEXT_R2("R","Warrior","Wojownik: ",950,460,16),
    TEXT_R3("R","Armor","Uzbrojenie: ",950,480,16),
    TEXT_R4("R","Weapon","Broń: ",950,500,16),
    TEXT_R5("R","Morale","Morale: ",950,520,16),
    TEXT_R6("R","HealthPoints","Życia: ",950,540,16),
    TEXT_R7("R","Agility","Zwinność: ",950,560,16),
    TEXT_R8("R","Atak","Atak: ",950,580,16),
    TEXT_R9("R","Speed","Szybkość ataku: ",950,600,16),
    TEXT_R10("R","ArmorStats","Zbroja: ",950,620,16),
    TEXT_WIN("W","WhoWon" ,"Current winner: ", 950, 660, 16);

    private String type;
    private String attribute;
    private String text;
    private double layoutX;
    private double layoutY;
    private double font;

    TextHandler(String type, String attribute, String text, double layoutX, double layoutY, double font){
        this.type=type;
        this.attribute=attribute;
        this.text=text;
        this.layoutX=layoutX;
        this.layoutY=layoutY;
        this.font=font;
    }

    public String getType() {
        return type;
    }

    public String getAttribute() {
        return attribute;
    }

    public String getText() {
        return text;
    }

    public double getLayoutX() {
        return layoutX;
    }

    public double getLayoutY() {
        return layoutY;
    }

    public double getFont() {
        return font;
    }

}
