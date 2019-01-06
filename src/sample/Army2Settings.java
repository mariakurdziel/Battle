package sample;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

public class Army2Settings {

    public Group root = new Group();
    public Stage primaryStage = new Stage();
    public Army army = new Army();
    boolean army_ready=false;

    public void addMenupanel2() {

        MenuItem menuItem1 = new MenuItem("Sztylet (wiking)");
        MenuItem menuItem2 = new MenuItem("Topór (wiking)");
        MenuItem menuItem3 = new MenuItem("Dzida (Mongoł)");
        MenuItem menuItem4 = new MenuItem("Krótki miecz (Mongoł)");
        MenuItem menuItem5 = new MenuItem("Miecz jednoręczny (Krzyżak)");
        MenuItem menuItem6 = new MenuItem("Miecz dwuręczny (Krzyżak)");
        MenuItem menuItem7 = new MenuItem("Łuk (Samuraj)");
        MenuItem menuItem8 = new MenuItem("Tachi (Samuraj)");

        MenuButton menuButton = new MenuButton("Weapon", null, menuItem1, menuItem2, menuItem3, menuItem4, menuItem5, menuItem6, menuItem7, menuItem8);

        menuItem1.setOnAction(event -> {
            army.Weapon = "Sztylet";
            army.attack += 3;
            army.speed_of_attack += 0.2;
            army_ready=true;
        });

        menuItem2.setOnAction(event -> {
            army.Weapon = "Topór";
            army.attack += 5;
            army.speed_of_attack += 0.0;
            army_ready=true;
        });
        menuItem3.setOnAction(event -> {
            army.Weapon = "Dzida";
            army.attack += 5.5;
            army.speed_of_attack -= 0.3;
            army_ready=true;
        });
        menuItem4.setOnAction(event -> {
            army.Weapon = "Krótki miecz";
            army.attack += 4;
            army.speed_of_attack -= 0.1;
            army_ready=true;
        });
        menuItem5.setOnAction(event -> {
            army.Weapon = "Miecz jednoręczny";
            army.attack += 6;
            army.speed_of_attack -= 0.5;
            army_ready=true;
        });
        menuItem6.setOnAction(event -> {
            army.Weapon = "Miecz dwuręczny";
            army.attack += 10;
            army.speed_of_attack -= 0.1;
            army_ready=true;
        });
        menuItem7.setOnAction(event -> {
            army.Weapon = "Łuk";
            army.attack += 6;
            army.speed_of_attack -= 0.4;
            army_ready=true;
        });
        menuItem8.setOnAction(event -> {
            army.Weapon = "Tachi";
            army.attack += 5;
            army.speed_of_attack += 0.1;
            army_ready=true;
        });


        HBox hbox = new HBox(menuButton);
        hbox.setLayoutX(45);
        hbox.setLayoutY(190);

        root.getChildren().addAll(hbox);
    }

    public void addMenupanel1() {

        MenuItem menuItem1 = new MenuItem("Wiking - skórzane, lekkie");
        MenuItem menuItem2 = new MenuItem("Wiking - skórzane ciężkie");
        MenuItem menuItem3 = new MenuItem("Mongoł - materiałowe lekkie");
        MenuItem menuItem4 = new MenuItem("Mongoł - skórzano-materiałowe");
        MenuItem menuItem5 = new MenuItem("Krzyżak - żelazne lekkie");
        MenuItem menuItem6 = new MenuItem("Krzyżak - żelazne ciężkie");
        MenuItem menuItem7 = new MenuItem("Samuraj - Dou");
        MenuItem menuItem8 = new MenuItem("Samuraj - Yoroi");


        MenuButton menuButton = new MenuButton("Warrios+Armature", null, menuItem1, menuItem2, menuItem3, menuItem4, menuItem5, menuItem6, menuItem7, menuItem8);

        menuItem1.setOnAction(event -> {
            army.Warrior = "Wiking";
            army.Armature = "skórzane, lekkie";
            army.hp = 120;
            army.agility = 0.14;
            army.speed_of_attack = 2.2;
            Random r1 = new Random();
            army.attack = r1.nextInt(10) + 1;
            Random r2 = new Random();
            army.armor = r2.nextInt(10) + 1;
            army.armor+= 1;

        });
        menuItem2.setOnAction(event -> {
            army.Warrior = "Wiking";
            army.Armature = "skórzane, ciężkie";
            army.hp = 120;
            army.agility = 0.13;
            army.speed_of_attack = 2.2;
            Random r1 = new Random();
            army.attack = r1.nextInt(10) + 1;
            Random r2 = new Random();
            army.armor = r2.nextInt(10) + 1;
            army.armor+= 1.5;
        });
        menuItem3.setOnAction(event -> {
            army.Warrior = "Mongoł";
            army.Armature = "materiałowe, lekkie";
            army.hp = 130;
            army.agility = 0.12;
            army.speed_of_attack = 2.1;
            Random r1 = new Random();
            army.attack = r1.nextInt(10) + 1;
            Random r2 = new Random();
            army.armor = r2.nextInt(10) + 1;
            army.armor+=0.5;
        });
        menuItem4.setOnAction(event -> {
            army.Warrior = "Mongoł";
            army.Armature = "skórzano-materiałowe";
            army.hp = 130;
            army.agility = 0.11;
            army.speed_of_attack = 2.1;
            Random r1 = new Random();
            army.attack = r1.nextInt(10) + 1;
            Random r2 = new Random();
            army.armor = r2.nextInt(10) + 1;
            army.armor+=1;
        });
        menuItem5.setOnAction(event -> {
            army.Warrior = "Krzyżak";
            army.Armature = "żelazne, lekkie";
            army.hp = 150;
            army.agility = 0.02;
            army.speed_of_attack = 2;
            Random r1 = new Random();
            army.attack = r1.nextInt(10) + 1;
            Random r2 = new Random();
            army.armor = r2.nextInt(10) + 1;
            army.armor+= 3;
        });
        menuItem6.setOnAction(event -> {
            army.Warrior = "Krzyżak";
            army.Armature = "żelazne, ciężkie";
            army.hp = 150;
            army.agility = 0.09;
            army.speed_of_attack = 2;
            Random r1 = new Random();
            army.attack = r1.nextInt(10) + 1;
            Random r2 = new Random();
            army.armor = r2.nextInt(10) + 1;
            army.armor+= 5;
        });
        menuItem7.setOnAction(event -> {
            army.Warrior = "Samuraj";
            army.Armature = "Dou";
            army.hp = 100;
            army.agility = 0.1;
            army.speed_of_attack = 2.4;
            Random r1 = new Random();
            army.attack = r1.nextInt(10) + 1;
            Random r2 = new Random();
            army.armor = r2.nextInt(10) + 1;
            army.armor+= 2;
        });
        menuItem8.setOnAction(event -> {
            army.Warrior = "Samuraj";
            army.Armature = "Yoroi";
            army.hp = 100;
            army.agility = 0.08;
            army.speed_of_attack = 2.4;
            Random r1 = new Random();
            army.attack = r1.nextInt(10) + 1;
            Random r2 = new Random();
            army.armor = r2.nextInt(10) + 1;
            army.armor+= 3;
        });
        HBox hbox = new HBox(menuButton);
        hbox.setLayoutX(45);
        hbox.setLayoutY(140);

        root.getChildren().addAll(hbox);
    }


    public Army setArmy(Army x){

        if(army_ready){
            x=army;
        }

        return x;
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

    public Group createScene(Group root) {

        this.root = root;
        addMenupanel1();
        addMenupanel2();
        addText();
        //primaryStage.setScene(new Scene(root, 600, 400));
        //primaryStage.show();

        return root;
    }
}
