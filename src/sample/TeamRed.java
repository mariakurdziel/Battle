package sample;

import javafx.scene.Group;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import sample.SetTypes.WeaponTypes;
import sample.SetTypes.ArmorTypes;


public class TeamRed {

    public Group root = new Group();
    String x;
    public Army armyRed= Army.VIKING; //random initialization to make it work
    boolean isReady = false;
    MenuButton warriorButton = new MenuButton("Warrior", null, null);

    public void addWarriorPanel() {

        for (Army armies : Army.values()) {
            MenuItem newItem = new MenuItem(armies.getWarrior());
            warriorButton.getItems().add(newItem);
        }

        HBox hbox = new HBox(warriorButton);
        hbox.setLayoutX(120);
        hbox.setLayoutY(150);
        root.getChildren().addAll(hbox);
        pickWarrior();
    }

    public void pickWarrior(){

        warriorButton.getItems().forEach(
                menuItem -> {
                    menuItem.setOnAction(
                            event -> {

                                armyRed.setWarrior(menuItem.getText());

                                //armyBlue.setHealthPoints();
                                //   armyBlue.setAgility();
                                // armyBlue.setAttackSpeed();
                                armyRed.setArmorStats(0);
                                armyRed.setMorale(1);
                                armyRed.setAttack(0);
                                isReady = true;
                                addArmorPanel();
                            }
                    );
                });

    }


    public void addArmorPanel() {
        MenuButton armorButton = new MenuButton("Armor", null, null);
        try {

            for (ArmorTypes armors : ArmorTypes.values()) {
                if (armors.getWarrior().equals(armyRed.getWarrior())) {
                    MenuItem newItem = new MenuItem(armors.getArmor());
                    armorButton.getItems().add(newItem);
                }
            }
        } catch(NullPointerException e){
            armorButton.getItems().add(new MenuItem("Pick a warrior"));
        }

        HBox hbox = new HBox(armorButton);
        hbox.setLayoutX(260);
        hbox.setLayoutY(150);
        root.getChildren().addAll(hbox);
        addWeaponPanel();
    }

    public void addWeaponPanel() {
        MenuButton weaponButton = new MenuButton("Weapon", null, null);
        try {
            for (WeaponTypes weapons : WeaponTypes.values()) {
                if (weapons.getWarrior().equals(armyRed.getWarrior())) {
                    MenuItem newItem = new MenuItem(weapons.getWeapon());
                    weaponButton.getItems().add(newItem);
                }
            }
        } catch(NullPointerException e){
            weaponButton.getItems().add(new MenuItem("Pick a warrior"));
        }

        HBox hbox = new HBox(weaponButton);
        hbox.setLayoutX(390);
        hbox.setLayoutY(150);
        root.getChildren().addAll(hbox);
    }


    public void addText() {

        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
        Text t = new Text("Army 2 settings:");
        t.setEffect(ds);
        t.setCache(true);
        t.setX(145);
        t.setY(65);
        t.setFill(Color.RED);
        t.setFont(Font.font(null, FontWeight.BOLD, 32));


        t.setTextAlignment(TextAlignment.CENTER);
        root.getChildren().addAll(t);
    }


    public Army setArmy(Army red){

        if(isReady) {
            red = armyRed;
        }
        return red;
    }

    public Group createScene(Group root) {

        this.root = root;
        addText();
        addWarriorPanel();
        addArmorPanel();
        addWeaponPanel();
        return root;
    }
}
