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
import java.util.Random;


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

    public void writeWarning(String warrior){
        String s1="";
        String s2="";

        for (ArmorTypes types : ArmorTypes.values()) {
            if (types.getWarrior().equals(warrior) && s1.equals(""))
                s1 = types.getArmor();
            else if (types.getWarrior().equals(warrior) && !s1.equals("")) {
                s2 = types.getArmor();
                break;
            }
        }
        Text t = new Text("Wrong armor chosen! "+s1+" or "+s2+" allowed!");
        t.setX(80);
        t.setY(80);
        t.setFill(Color.RED);
        t.setFont(Font.font(10));
        root.getChildren().addAll(t);
    }
    public void writeWarning2(String warrior){
        String s1="";
        String s2="";

        for (WeaponTypes types : WeaponTypes.values()) {
            if (types.getWarrior().equals(warrior) && s1.equals(""))
                s1 = types.getWeapon();
            else if (types.getWarrior().equals(warrior) && !s1.equals("")) {
                s2 = types.getWeapon();
                break;
            }

        }
        Text t = new Text("Wrong weapon chosen! "+s1+" or "+s2+" allowed!");
        t.setX(80);
        t.setY(100);
        t.setFill(Color.RED);
        t.setFont(Font.font(10));
        root.getChildren().addAll(t);
    }


    public void addWarriorPanel() {

        for (ArmyTypes armies : ArmyTypes.values()) {
            MenuItem newItem = new MenuItem(armies.getWarrior());
            warriorButton.getItems().add(newItem);
        }

        HBox hbox = new HBox(warriorButton);
        hbox.setLayoutX(60);
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
        hbox.setLayoutX(250);
        hbox.setLayoutY(120);
        root.getChildren().addAll(hbox);
        pickArmor();
    }

    public void pickArmor(){
        try {
            armorButton.getItems().forEach(
                    menuItem -> menuItem.setOnAction(
                            event -> {
                                boolean flag=false;
                                army.setArmor(menuItem.getText());

                                for (ArmorTypes types : ArmorTypes.values()) { // TODO mozliwa optymalizacja? MALO WAZNE
                                    if(types.getWarrior() == army.getWarrior()){
                                        if(types.getArmor() == army.getArmor()) {
                                            flag=true;
                                            army.setArmorStats(types.getArmorStats());
                                            army.setAgility(army.getAgility() + types.getAgility());
                                            armorButton.setText(types.getArmor());
                                        }
                                    }
                                    if(flag)
                                        break;
                                }
                                if(flag==false)
                                {
                                    writeWarning(army.getWarrior());

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
        hbox.setLayoutX(440);
        hbox.setLayoutY(120);
        root.getChildren().addAll(hbox);
        pickWeapon();
    }

    public void pickWeapon(){
        try {
            weaponButton.getItems().forEach(
                    menuItem -> menuItem.setOnAction(
                            event -> {
                                boolean flag=false;
                                army.setWeapon(menuItem.getText());
                                for (WeaponTypes types : WeaponTypes.values()) {
                                    if(types.getWarrior() == army.getWarrior() && types.getWeapon() == army.getWeapon()){
                                        flag=true;
                                        army.setAttack(types.getAttack());
                                        army.setAttackSpeed(army.getAttackSpeed() + types.getAttackSpeed());
                                        weaponButton.setText(types.getWeapon());
                                    }
                                }
                                if(flag==false) {
                                    writeWarning2(army.getWarrior());
                                }
                            }
                    ));
        } catch (Exception e){
            System.out.println("ERROR: Weapon picking incorrect.");
        }
    }


    public void addNumberPanel() {
        HBox hbox = new HBox(numberField);
        hbox.setLayoutX(100);
        hbox.setLayoutY(190);       // TODO POZMIENIAC WSZEDZIE TE HARDKODOWANE INFORMACJE NA TE Z ENUMA MARII
        HBox hboxbutton = new HBox(addingNumberButton);
        hboxbutton.setLayoutX(140);
        hboxbutton.setLayoutY(230);
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
        hbox.setLayoutX(310);
        hbox.setLayoutY(190);       // TODO POZMIENIAC WSZEDZIE TE HARDKODOWANE INFORMACJE NA TE Z ENUMA MARII
        HBox hboxbutton = new HBox(addingSquadsButton);
        hboxbutton.setLayoutX(325);
        hboxbutton.setLayoutY(230);
        root.getChildren().addAll(hbox);
        root.getChildren().addAll(hboxbutton);
        pickSquadNumber();
    }

    public int assignToSquad(int howMuch){

        Random rand = new Random();
        int n = rand.nextInt(howMuch);
        return n;
    }

    public void pickSquadNumber(){
        try {
            addingSquadsButton.setOnAction(
                    event -> {
                        int howMuch = Integer.parseInt(squadsField.getText());
                        if(howMuch > army.getNumber()) { System.out.println("Zla wartosc"); }
                        else {
                            for (int i = 0; i < howMuch; i++) {
                                Squads sqd = new Squads(10, 10, army.getNumber() / howMuch,
                                        army.getHealthPoints() * (army.getNumber() / howMuch));
                                sqd.setAgility(army.getAgility());
                                sqd.setAttack(army.getAttack());
                                sqd.setArmorStats(army.getArmorStats());
                                sqd.setAttackSpeed(army.getAttackSpeed());
                                squads.add(sqd);
                                army.setSquads(squads);
                            }
                            if(army.getNumber() % howMuch != 0) {
                                int peopleToAssign = army.getNumber() - howMuch*(army.getNumber() / howMuch);
                                for(int i = 0; i < peopleToAssign; i++) {
                                    int n = assignToSquad(howMuch);
                                    army.getSquads().get(n).setPopulation(army.getSquads().get(n).getPopulation() + 1);
                                    army.getSquads().get(n).setHealth(army.getSquads().get(n).getHealth() + army.getHealthPoints());
                                }
                            }
                        }
                    }
            );
        } catch (Exception e){
            System.out.println("ERROR: Number incorrect.");
        }
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
