//package sample;
//
//import javafx.scene.Group;
//import javafx.scene.effect.DropShadow;
//import javafx.scene.layout.HBox;
//import javafx.scene.paint.Color;
//import javafx.scene.text.Font;
//import javafx.scene.text.FontWeight;
//import javafx.scene.text.Text;
//import javafx.scene.text.TextAlignment;
//import java.util.Random;
//import javafx.scene.control.MenuButton;
//import javafx.scene.control.MenuItem;
//
//
//public class TeamRed {
//
//    public Group root = new Group();
//    public Army army = new Army();
//    boolean isReady = false;
//
//
//    public void addMenupanel2() {
//
//        MenuItem menuItem1 = new MenuItem("Sztylet (wiking)");
//        MenuItem menuItem2 = new MenuItem("Topór (wiking)");
//        MenuItem menuItem3 = new MenuItem("Dzida (Mongoł)");
//        MenuItem menuItem4 = new MenuItem("Krótki miecz (Mongoł)");
//        MenuItem menuItem5 = new MenuItem("Miecz jednoręczny (Krzyżak)");
//        MenuItem menuItem6 = new MenuItem("Miecz dwuręczny (Krzyżak)");
//        MenuItem menuItem7 = new MenuItem("Łuk (Samuraj)");
//        MenuItem menuItem8 = new MenuItem("Tachi (Samuraj)");
//
//        MenuButton menuButton = new MenuButton("weapon", null, menuItem1, menuItem2,
//                menuItem3, menuItem4, menuItem5, menuItem6, menuItem7, menuItem8);
//
//        menuItem1.setOnAction(event -> {
//            army.weapon = "Sztylet";
//            army.attackStats += 3;
//            army.attackSpeedStats += 0.2;
//            isReady=true;
//        });
//
//        menuItem2.setOnAction(event -> {
//            army.weapon = "Topór";
//            army.attackStats += 5;
//            army.attackSpeedStats += 0.0;
//            isReady=true;
//        });
//        menuItem3.setOnAction(event -> {
//            army.weapon = "Dzida";
//            army.attackStats += 5.5;
//            army.attackSpeedStats -= 0.3;
//            isReady=true;
//        });
//        menuItem4.setOnAction(event -> {
//            army.weapon = "Krótki miecz";
//            army.attackStats += 4;
//            army.attackSpeedStats -= 0.1;
//            isReady=true;
//        });
//        menuItem5.setOnAction(event -> {
//            army.weapon = "Miecz jednoręczny";
//            army.attackStats += 6;
//            army.attackSpeedStats -= 0.5;
//            isReady=true;
//        });
//        menuItem6.setOnAction(event -> {
//            army.weapon = "Miecz dwuręczny";
//            army.attackStats += 10;
//            army.attackSpeedStats -= 0.1;
//            isReady=true;
//        });
//        menuItem7.setOnAction(event -> {
//            army.weapon = "Łuk";
//            army.attackStats += 6;
//            army.attackSpeedStats -= 0.4;
//            isReady=true;
//        });
//        menuItem8.setOnAction(event -> {
//            army.weapon = "Tachi";
//            army.attackStats += 5;
//            army.attackSpeedStats += 0.1;
//            isReady=true;
//
//        });
//
//        HBox hbox = new HBox(menuButton);
//        hbox.setLayoutX(45);
//        hbox.setLayoutY(190);
//
//        root.getChildren().addAll(hbox);
//    }
//
//    public void addMenupanel1() {
//
//        MenuItem menuItem1 = new MenuItem("Wiking - skórzane, lekkie");
//        MenuItem menuItem2 = new MenuItem("Wiking - skórzane ciężkie");
//        MenuItem menuItem3 = new MenuItem("Mongoł - materiałowe lekkie");
//        MenuItem menuItem4 = new MenuItem("Mongoł - skórzano-materiałowe");
//        MenuItem menuItem5 = new MenuItem("Krzyżak - żelazne lekkie");
//        MenuItem menuItem6 = new MenuItem("Krzyżak - żelazne ciężkie");
//        MenuItem menuItem7 = new MenuItem("Samuraj - Dou");
//        MenuItem menuItem8 = new MenuItem("Samuraj - Yoroi");
//
//
//        MenuButton menuButton = new MenuButton("Warrios+armature", null, menuItem1, menuItem2, menuItem3, menuItem4, menuItem5, menuItem6, menuItem7, menuItem8);
//
//        menuItem1.setOnAction(event -> {
//            army.warrior = "Wiking";
//            army.armature = "skórzane, lekkie";
//            army.hp = 120;
//            army.agilityStats = 0.14;
//            army.attackSpeedStats = 2.2;
//            Random r1 = new Random();
//            army.attackStats = r1.nextInt(10) + 1;
//            Random r2 = new Random();
//            army.armorStats = r2.nextInt(10) + 1;
//            army.armorStats+= 1;
//
//        });
//        menuItem2.setOnAction(event -> {
//            army.warrior = "Wiking";
//            army.armature = "skórzane, ciężkie";
//            army.hp = 120;
//            army.agilityStats = 0.13;
//            army.attackSpeedStats = 2.2;
//            Random r1 = new Random();
//            army.attackStats = r1.nextInt(10) + 1;
//            Random r2 = new Random();
//            army.armorStats = r2.nextInt(10) + 1;
//            army.armorStats+= 1.5;
//        });
//        menuItem3.setOnAction(event -> {
//            army.warrior = "Mongoł";
//            army.armature = "materiałowe, lekkie";
//            army.hp = 130;
//            army.agilityStats = 0.12;
//            army.attackSpeedStats = 2.1;
//            Random r1 = new Random();
//            army.attackStats = r1.nextInt(10) + 1;
//            Random r2 = new Random();
//            army.armorStats = r2.nextInt(10) + 1;
//            army.armorStats+=0.5;
//        });
//        menuItem4.setOnAction(event -> {
//            army.warrior = "Mongoł";
//            army.armature = "skórzano-materiałowe";
//            army.hp = 130;
//            army.agilityStats = 0.11;
//            army.attackSpeedStats = 2.1;
//            Random r1 = new Random();
//            army.attackStats = r1.nextInt(10) + 1;
//            Random r2 = new Random();
//            army.armorStats = r2.nextInt(10) + 1;
//            army.armorStats+=1;
//        });
//        menuItem5.setOnAction(event -> {
//            army.warrior = "Krzyżak";
//            army.armature = "żelazne, lekkie";
//            army.hp = 150;
//            army.agilityStats = 0.02;
//            army.attackSpeedStats = 2;
//            Random r1 = new Random();
//            army.attackStats = r1.nextInt(10) + 1;
//            Random r2 = new Random();
//            army.armorStats = r2.nextInt(10) + 1;
//            army.armorStats+= 3;
//        });
//        menuItem6.setOnAction(event -> {
//            army.warrior = "Krzyżak";
//            army.armature = "żelazne, ciężkie";
//            army.hp = 150;
//            army.agilityStats = 0.09;
//            army.attackSpeedStats = 2;
//            Random r1 = new Random();
//            army.attackStats = r1.nextInt(10) + 1;
//            Random r2 = new Random();
//            army.armorStats = r2.nextInt(10) + 1;
//            army.armorStats+= 5;
//        });
//        menuItem7.setOnAction(event -> {
//            army.warrior = "Samuraj";
//            army.armature = "Dou";
//            army.hp = 100;
//            army.agilityStats = 0.1;
//            army.attackSpeedStats = 2.4;
//            Random r1 = new Random();
//            army.attackStats = r1.nextInt(10) + 1;
//            Random r2 = new Random();
//            army.armorStats = r2.nextInt(10) + 1;
//            army.armorStats+= 2;
//        });
//        menuItem8.setOnAction(event -> {
//            army.warrior = "Samuraj";
//            army.armature = "Yoroi";
//            army.hp = 100;
//            army.agilityStats = 0.08;
//            army.attackSpeedStats = 2.4;
//            Random r1 = new Random();
//            army.attackStats = r1.nextInt(10) + 1;
//            Random r2 = new Random();
//            army.armorStats = r2.nextInt(10) + 1;
//            army.armorStats+= 3;
//        });
//
//        HBox hbox = new HBox(menuButton);
//        hbox.setLayoutX(45);
//        hbox.setLayoutY(140);
//
//        root.getChildren().addAll(hbox);
//    }
//
//
//    public Army setArmy(Army x){
//
//        if(isReady){
//            x=army;
//        }
//
//        return x;
//    }
//
//    public void addText() {
//
//        DropShadow ds = new DropShadow();
//        ds.setOffsetY(3.0f);
//        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
//        Text t = new Text("Army 1 settings:");
//        t.setEffect(ds);
//        t.setCache(true);
//        t.setX(145);
//        t.setY(60);
//        t.setFill(Color.RED);
//        t.setFont(Font.font(null, FontWeight.BOLD, 32));
//
//        Text t1 = new Text("(Defensive)");
//        t1.setX(230);
//        t1.setY(100);
//        t1.setFont(Font.font(16));
//
//
//        t.setTextAlignment(TextAlignment.CENTER);
//        root.getChildren().addAll(t, t1);
//    }
//
//    public Group createScene(Group root) {
//
//        this.root = root;
//        addMenupanel1();
//        addMenupanel2();
//        addText();
//        //primaryStage.setScene(new Scene(root, 600, 400));
//        //primaryStage.show();
//
//        return root;
//    }
//}
//
//
//
