package sample;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import sample.SetTypes.ArmyTypes;
import sample.SetTypes.WeaponTypes;
import sample.SetTypes.ArmorTypes;


public class Teams {

    public Group root = new Group();
    public Army army = new Army("","","", 0,0,0,0);
    boolean isReady = false;
    MenuButton warriorButton = new MenuButton("Warrior", null, null);
    MenuButton armorButton = new MenuButton("Armor", null, null);
    MenuButton weaponButton = new MenuButton("Weapon", null, null);
    Button addingNumberButton = new Button("Add");
    TextField numberField = new TextField();

    public void addWarriorPanel() {

        for (ArmyTypes armies : ArmyTypes.values()) {
            MenuItem newItem = new MenuItem(armies.getWarrior());
            warriorButton.getItems().add(newItem);
        }

        HBox hbox = new HBox(warriorButton);
        hbox.setLayoutX(40);
        hbox.setLayoutY(120);
        root.getChildren().addAll(hbox);
        pickWarrior();
    }

    public void pickWarrior(){
            try {
            warriorButton.getItems().forEach(
                    menuItem -> menuItem.setOnAction(
                            event -> {
                                army.setWarrior(menuItem.getText());
                                        for (ArmyTypes types : ArmyTypes.values()) {
                                            if(types.getWarrior() == army.getWarrior()){
                                                army.setHealthPoints(types.getHealthPoints());
                                                army.setAgility(types.getAgility());
                                                army.setAttackSpeed(types.getAttackSpeed());
                                            }
                                        }
                                army.setMorale(1);
                                isReady = true;
                            }
                    ));
            } catch (Exception e){
                System.out.println("ERROR: Warrior picking incorrect.");
            }
    }


    public void addArmorPanel() {
        try {
            for (ArmorTypes armors : ArmorTypes.values()) {
                    MenuItem newItem = new MenuItem(armors.getArmor());
                    armorButton.getItems().add(newItem);
            }
        } catch(NullPointerException e){
                armorButton.getItems().add(new MenuItem("Pick a warrior"));
        }

        HBox hbox = new HBox(armorButton);

        // wrzucic informacje o aktualnie wybranym wojowniku po prawej!
        // w jakiegos cos, metode moze czy zmienne stale WGL CALY INTERFEJS!!!
        // BEZ HARDKODOWANIA
        hbox.setLayoutX(140);
        hbox.setLayoutY(120);
        root.getChildren().addAll(hbox);
        pickArmor();
    }

    public void pickArmor(){
        try {
            armorButton.getItems().forEach(
                    menuItem -> menuItem.setOnAction(
                            event -> {
                                army.setArmor(menuItem.getText());
                                for (ArmorTypes types : ArmorTypes.values()) { // mozliwa optymalizacja?
                                    if(types.getWarrior() == army.getWarrior() && types.getArmor() == army.getArmor()){
                                        army.setArmorStats(types.getArmorStats());
                                        army.setAgility(army.getAgility() + types.getAgility());
                                    }
                                }
                            }
                    ));
        } catch (Exception e){
            System.out.println("ERROR: Armor picking incorrect.");
        }
    }

    public void addWeaponPanel() {
        try {
            for (WeaponTypes weapons : WeaponTypes.values()) {
                MenuItem newItem = new MenuItem(weapons.getWeapon()); // narazie mozesz wybrac zbroje samuraja do wikinga, nie powinno tak byc
                weaponButton.getItems().add(newItem);
            }
        } catch(NullPointerException e){
            weaponButton.getItems().add(new MenuItem("Pick a warrior"));
        }

        HBox hbox = new HBox(weaponButton);
        hbox.setLayoutX(240);
        hbox.setLayoutY(120);
        root.getChildren().addAll(hbox);
        pickWeapon();
    }

    public void pickWeapon(){
        try {
            weaponButton.getItems().forEach(
                    menuItem -> menuItem.setOnAction(
                            event -> {
                                army.setWeapon(menuItem.getText());
                                for (WeaponTypes types : WeaponTypes.values()) { // mozliwa optymalizacja?
                                    if(types.getWarrior() == army.getWarrior() && types.getWeapon() == army.getWeapon()){
                                        army.setAttack(types.getAttack());
                                        army.setAttackSpeed(army.getAttackSpeed() + types.getAttackSpeed());
                                    }
                                }
                            }
                    ));
        } catch (Exception e){
            System.out.println("ERROR: Weapon picking incorrect.");
        }
    }

    public void addNumberPanel() {
        HBox hbox = new HBox(numberField);
        hbox.setLayoutX(340);
        hbox.setLayoutY(120);
        HBox hboxbutton = new HBox(addingNumberButton);
        hboxbutton.setLayoutX(400);
        hboxbutton.setLayoutY(160);
        root.getChildren().addAll(hbox);
        root.getChildren().addAll(hboxbutton);
        pickNumber();
    }

    public void pickNumber(){
        try {
            addingNumberButton.setOnAction(
                    event ->
                            army.setNumber(Integer.parseInt(numberField.getText()))
            );
        } catch (Exception e){
            System.out.println("ERROR: Number incorrect.");
        }
    }


    public void addText() {

        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
        Text t = new Text("Team settings:");
        t.setEffect(ds);
        t.setCache(true);
        t.setX(145);
        t.setY(60);
        t.setFill(Color.RED);
        t.setFont(Font.font(null, FontWeight.BOLD, 32));

        Text t1 = new Text("(Ofensive)");
        t1.setX(230);
        t1.setY(100);
        t1.setFont(Font.font(16));


        t.setTextAlignment(TextAlignment.CENTER);
        root.getChildren().addAll(t, t1);
    }


    public Army setArmy(Army blue){

        if(isReady) {
            blue = army;
        }
        return blue;
    }

    public Group createScene(Group root) {
        this.root = root;
        addWarriorPanel();
        addArmorPanel();
        addWeaponPanel();
        addNumberPanel();
        return root;
    }
}
