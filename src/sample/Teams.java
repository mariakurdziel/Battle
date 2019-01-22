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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Teams {

    public List squads = new ArrayList();
    public Group root = new Group();
    public Army army = new Army("","","", 0,0,0,0, squads);
    boolean isReady = false;
    MenuButton warriorButton = new MenuButton("Warrior", null, null);
    MenuButton armorButton = new MenuButton("Armor", null, null);
    MenuButton weaponButton = new MenuButton("Weapon", null, null);
    Button addingNumberButton = new Button("Add number");
    Button addingSquadsButton = new Button("Divide into squads");
    TextField numberField = new TextField();
    TextField squadsField = new TextField();

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
                                                warriorButton.setText(types.getWarrior());
                                            }
                                        }
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
                                for (ArmorTypes types : ArmorTypes.values()) { // TODO mozliwa optymalizacja? MALO WAZNE
                                    if(types.getWarrior() == army.getWarrior()){
                                        if(types.getArmor() == army.getArmor()) {
                                            army.setArmorStats(types.getArmorStats());
                                            army.setAgility(army.getAgility() + types.getAgility());
                                            armorButton.setText(types.getArmor());
                                        }
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
                MenuItem newItem = new MenuItem(weapons.getWeapon()); // TODO narazie mozesz wybrac zbroje samuraja do wikinga, nie powinno tak byc
                weaponButton.getItems().add(newItem);                 // TODO DODAC HANDLER ZEBY WYWALALO "EJ NIE MOZESZ TEGO WYBRAC" CZY COS
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
                                for (WeaponTypes types : WeaponTypes.values()) {
                                    if(types.getWarrior() == army.getWarrior() && types.getWeapon() == army.getWeapon()){
                                        army.setAttack(types.getAttack());
                                        army.setAttackSpeed(army.getAttackSpeed() + types.getAttackSpeed());
                                        weaponButton.setText(types.getWeapon());
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
        hbox.setLayoutY(120);       // TODO POZMIENIAC WSZEDZIE TE HARDKODOWANE INFORMACJE NA TE Z ENUMA MARII
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
                    event -> army.setNumber(Integer.parseInt(numberField.getText()))
            );} catch (Exception e){
            System.out.println("ERROR: Number incorrect.");
        }
    }


    public void addSquadPanel() {
        HBox hbox = new HBox(squadsField);
        hbox.setLayoutX(340);
        hbox.setLayoutY(200);       // TODO POZMIENIAC WSZEDZIE TE HARDKODOWANE INFORMACJE NA TE Z ENUMA MARII
        HBox hboxbutton = new HBox(addingSquadsButton);
        hboxbutton.setLayoutX(400);
        hboxbutton.setLayoutY(240);
        root.getChildren().addAll(hbox);
        root.getChildren().addAll(hboxbutton);
        pickSquadNumber();
    }

//    public int howManySquads(int get){
//        int result;
//
//
//
//        return result;
//    }

    public void pickSquadNumber(){
        try {
            addingSquadsButton.setOnAction(
                    event -> {
                        int howMuch = Integer.parseInt(squadsField.getText());
                        if(howMuch > army.getNumber()) { System.out.println("Zla wartosc"); } // zmienic jakos
                        else {
                            for (int i = 0; i < howMuch; i++) {
                                if(army.getNumber() % howMuch != 0) {
                                    Squads sqd = new Squads(10, 10, army.getNumber() / howMuch,
                                            army.getNumber() * army.getHealthPoints() / howMuch);
                                }
                                Squads sqd = new Squads(10, 10, army.getNumber() / howMuch,
                                        army.getNumber() * army.getHealthPoints() / howMuch);
                                sqd.setAgility(army.getAgility());
                                sqd.setAttack(army.getAttack());
                                sqd.setArmorStats(army.getArmorStats());
                                sqd.setAttackSpeed(army.getAttackSpeed());
                                squads.add(sqd);
                                army.setSquads(squads);
                            }
                        }
                    }
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
        addSquadPanel();
        return root;
    }
}
