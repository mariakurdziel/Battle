package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class SimulationScreen extends Application {


    public Group root = new Group();
    Stage stage = new Stage();
    Army armyBlue;
    Army armyRed;

    public void setArmyBlue(Army armyBlue) {
        this.armyBlue = armyBlue;
    }

    public void setArmyRed(Army armyRed) {
        this.armyRed = armyRed;
    }

    private void drawShape1(GraphicsContext gc) {
        gc.setFill(Color.RED);

        gc.fillRect(950, 120, 25, 25);

    }
    private void drawShape2(GraphicsContext gc) {
        gc.setFill(Color.YELLOW);

        gc.fillRect(950, 400, 25, 25);

    }

    public void addTitle(){
        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

        Text t = new Text("Battle Simulation");
        t.setEffect(ds);
        t.setCache(true);
        t.setX(450);
        t.setY(70);
        t.setFill(Color.BLUE);
        t.setFont(Font.font(null, FontWeight.BOLD, 32));

        t.setTextAlignment(TextAlignment.CENTER);
        root.getChildren().addAll(t);
    }

    public void addInfos(){
        Text t1 = new Text("Army 1: " + armyBlue.getNumber());
        Text t2 = new Text("Wojownik: "+ armyBlue.getWarrior());
        t1.setX(1000);
        t1.setY(140);
        t2.setX(950);
        t2.setY(180);
        t1.setFont(Font.font(16));
        t2.setFont(Font.font(16));
        Text t3 = new Text("Uzbrojenie: "+ armyBlue.getArmor()); // UZYWAC GETOW I SETOW A NIE INFORMACJI PRYWATNYCH!
        t3.setX(950);
        t3.setY(200);
        t3.setFont(Font.font(16));
        Text t4 = new Text("Broń: "+ armyBlue.getWeapon());
        t4.setX(950);
        t4.setY(220);
        t4.setFont(Font.font(16));
        Text t5 = new Text("Morale: "+ armyBlue.getMorale());
        t5.setX(950);
        t5.setY(240);
        t5.setFont(Font.font(16));
        Text t6 = new Text("Życia: "+ armyBlue.getHealthPoints());
        t6.setX(950);
        t6.setY(260);
        t6.setFont(Font.font(16));
        Text t7 = new Text("Zwinność: "+ armyBlue.getAgility());
        t7.setX(950);
        t7.setY(280);
        t7.setFont(Font.font(16));
        Text t8 = new Text("Atak: "+ armyBlue.getAttack());
        t8.setX(950);
        t8.setY(300);
        t8.setFont(Font.font(16));
        Text t9= new Text("Szybkość ataku: "+ armyBlue.getAttackSpeed());
        t9.setX(950);
        t9.setY(320);
        t9.setFont(Font.font(16));
        Text t10= new Text("Zbroja: "+ armyBlue.getArmorStats());
        t10.setX(950);
        t10.setY(340);
        t10.setFont(Font.font(16));
        root.getChildren().addAll(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10);
        Text n1 = new Text("Army 2: " + armyRed.getNumber());
        n1.setX(1000);
        n1.setY(420);
        n1.setFont(Font.font(16));
        Text n2 = new Text("Wojownik: "+ armyRed.getWarrior());
        n2.setX(950);
        n2.setY(460);
        n2.setFont(Font.font(16));
        Text n3 = new Text("Uzbrojenie: "+ armyRed.getArmor());
        n3.setX(950);
        n3.setY(480);
        n3.setFont(Font.font(16));
        Text n4 = new Text("Broń: "+ armyRed.getWeapon());
        n4.setX(950);
        n4.setY(500);
        n4.setFont(Font.font(16));
        Text n5 = new Text("Morale: "+ armyRed.getMorale());
        n5.setX(950);
        n5.setY(520);
        n5.setFont(Font.font(16));
        Text n6 = new Text("Życia: "+ armyRed.getHealthPoints());
        n6.setX(950);
        n6.setY(540);
        n6.setFont(Font.font(16));
        Text n7 = new Text("Zwinność: "+ armyRed.getAgility());
        n7.setX(950);
        n7.setY(560);
        n7.setFont(Font.font(16));
        Text n8 = new Text("Atak: "+ armyRed.getAttack());
        n8.setX(950);
        n8.setY(580);
        n8.setFont(Font.font(16));
        Text n9= new Text("Szybkość ataku: "+ armyRed.getAttackSpeed());
        n9.setX(950);
        n9.setY(600);
        n9.setFont(Font.font(16));
        Text n10= new Text("Zbroja: "+ armyRed.getArmorStats());
        n10.setX(950);
        n10.setY(620);
        n10.setFont(Font.font(16));
        root.getChildren().addAll(n1,n2,n3,n4,n5,n6,n7,n8,n9,n10);
        Canvas canvas = new Canvas(1200, 800);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShape1(gc);
        drawShape2(gc);
        root.getChildren().add(canvas);
    }
    public static void main(String[] args) {

        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        addTitle();
        addInfos();
        final Scene scene = new Scene(root, 1200, 800);
        stage.setScene(scene);
        stage.setTitle("Simulation");
        stage.show();
    }

}


