package sample;

public enum UIHandler {


    BUTTON_ACCEPT_TEAMR("BUTTON_ARMR","Ok","Settings","SCENE2","ROOT4",215,260),
    BUTTON_ACCEPT_TEMAB("BUTTON_ARMB","Ok","Settings","SCENE2","ROOT3",215,260),
    BUTTON_START("BUTTON","Start","Settings","SCENE2","ROOT1",215,200),
    BUTTON_BLUE("BUTTON","Blue team","Blue team","SCENE3","ROOT2",215,130),
    BUTTON_RED("BUTTON","Red team","Red team","SCENE4","ROOT2",215,200),
    BUTTON_START_SYM("BUTTON_SYM","Start symulation","Symulation","","ROOT2",215,270);



    public String getType() {
        return type;
    }

    public String getBtntext() {
        return btntext;
    }

    public String getText() {
        return text;
    }

    public String getScene() {
        return scene;
    }

    public double getLayoutx() {
        return layoutx;
    }

    public double getLayouty() {
        return layouty;
    }

    public String getRoot() {
        return root;
    }

    private final String type ;
    private final String btntext;
    private final String text;
    private final String scene;
    private final String root;
    private final double layoutx;
    private final double layouty;


    UIHandler(String type, String btntext, String text, String scene, String root, double layoutx, double layouty){

        this.type=type;
        this.btntext=btntext;
        this.text=text;
        this.scene=scene;
        this.root=root;
        this.layoutx=layoutx;
        this.layouty=layouty;
    }

}
