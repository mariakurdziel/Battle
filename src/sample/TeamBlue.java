package sample;

import javafx.scene.Group;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import sample.SetTypes.WeaponTypes;
import sample.SetTypes.ArmorTypes;


public class TeamBlue {

    public Group root = new Group();
    public Army armyBlue;
    boolean isReady = false;

    public void addWarriorPanel() {

        MenuButton warriorButton = new MenuButton("Warrior", null, null);
        for (Army armies : Army.values()) {
            MenuItem newItem = new MenuItem(armies.getWarrior());
            warriorButton.getItems().add(newItem);
        }

        HBox hbox = new HBox(warriorButton);
        hbox.setLayoutX(45);
        hbox.setLayoutY(190);
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
            blue = armyBlue;
        }
        return blue;
    }

    public Group createScene(Group root) {

        this.root = root;
        addWarriorPanel();
        return root;
    }
}
