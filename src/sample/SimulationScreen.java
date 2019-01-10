package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import sample.SetTypes.ArmyTypes;

public class SimulationScreen extends Application {


    public Group rootx = new Group();
    Stage stage = new Stage();
    Army armyBlue;
    Army armyRed;
    PredictingFight predictions = new PredictingFight();

    public void setArmyBlue(Army armyBlue) {
        this.armyBlue = armyBlue;
    }

    public void setArmyRed(Army armyRed) {
        this.armyRed = armyRed;
    }

    public String setLanchesterEquation(Army armyBlue, Army armyRed){
        int whoWins = predictions.lanchesterEquation(armyBlue,armyRed);
        if(whoWins == 1) return armyBlue.getWarrior();
        else if(whoWins == 0) return "Draw";
        else if(whoWins == -1) return armyRed.getWarrior();
        else return null;
    }

    public String setAttribute(TextHandler text){
        Army x;
        if(text.getType().equals("B"))
            x = armyBlue;
        else
            x = armyRed;

        if(text.getAttribute().equals("Number"))
            return String.valueOf((x.getNumber()));
        else if (text.getAttribute().equals("Warrior"))
            return x.getWarrior();
        else if (text.getAttribute().equals("Armor"))
            return x.getArmor();
        else if (text.getAttribute().equals("Weapon"))
            return x.getWeapon();
        else if (text.getAttribute().equals("Morale"))
            return String.valueOf((x.getMorale()));
        else if (text.getAttribute().equals("HealthPoints"))
            return String.valueOf((x.getHealthPoints()));
        else if (text.getAttribute().equals("Agility"))
            return String.valueOf((x.getAgility())).substring(0,3);
        else if (text.getAttribute().equals("Atak"))
            return String.valueOf((x.getAttack())).substring(0,3);
        else if (text.getAttribute().equals("Speed"))
            return String.valueOf((x.getAttackSpeed())).substring(0,3);
        else if (text.getAttribute().equals("ArmorStats"))
            return String.valueOf((x.getArmorStats())).substring(0,3);
        else if (text.getAttribute().equals("WhoWon"))
            return String.valueOf(setLanchesterEquation(armyBlue,armyRed));
        else
            return null;
    }

    private void drawShape(GraphicsContext gc) {

        gc.setFill(Color.BLUE);
        gc.fillRect(950, 120, 25, 25);

        gc.setFill(Color.RED);
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
        rootx.getChildren().addAll(t);
    }

    public void addInfos(){
        for (TextHandler text : TextHandler.values()){

            Text t = new Text(text.getText() + setAttribute(text));
            t.setX(text.getLayoutX());
            t.setY(text.getLayoutY());
            t.setFont(Font.font(text.getFont()));
            rootx.getChildren().addAll(t);
        }

        Canvas canvas = new Canvas(1200, 800);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShape(gc);
        rootx.getChildren().add(canvas);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void printArmyBlue(){
        int distanceX=0, distanceY=0;
        int widthX=6, widthY=6;
        int radius =5;
        HBox shapesRootBlue = new HBox();
        for (int i=0; i < armyBlue.getNumber(); i++) {
            Circle c1 = new Circle(100+distanceX, 200+distanceY, radius);
            c1.setStroke(Color.BLUE);
            c1.setFill(Color.BLUE);
            c1.setStrokeWidth(1);
            distanceX += widthX;
            if(i%10==0){
                distanceY += widthY;
            }
            shapesRootBlue.getChildren().add(c1);
        }
        // Set Spacing of the HBox
        shapesRootBlue.setSpacing(5);
        Scene shapesScene = new Scene(shapesRootBlue);
        stage.setScene(shapesScene);
        stage.show();
    }

    public void printArmyRed(){
        int distanceX=0, distanceY=0;
        int widthX=6, widthY=6;
        int radius =5;
        HBox shapesRootRed = new HBox();
        for (int i=0; i < armyRed.getNumber(); i++) {
            Circle c1 = new Circle(100+distanceX, 500-distanceY, radius);
            c1.setStroke(Color.RED);
            c1.setFill(Color.RED);
            c1.setStrokeWidth(1);
            distanceX += widthX;
            if(i%10==0){
                distanceY += widthY;
            }
            shapesRootRed.getChildren().add(c1);
        }
        // Set Spacing of the HBox
        shapesRootRed.setSpacing(5);
        Scene shapesScene = new Scene(shapesRootRed);
        stage.setScene(shapesScene);
        stage.show();
    }

    public void update() {
        printArmyRed();
        printArmyBlue();
        // TODO
        // TODO CZY ZABILES KOGOS
        // TODO PODZIEL NA GRUPKI ARMIE
        // TODO DLA KAZDEJ GRUPKI SZANSA NA UNIKNIECIE ATAKU
        // TODO ANIMACJA
        // TODO POWTORZ CO 0.5 SEKUNDY
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
      //  while(predictions.whoWon != 1 || predictions.whoWon != 1) { // ava.lang.IllegalArgumentException: Group@1bb34940[styleClass=root]is already set as root of another scene
                // zmienic to tak zeby bylo w petli jakos, moze co 0.5 sekundy czy cos?
            rootx.getChildren().clear();
            //update();
            addTitle(); // TODO GDZIES TUTAJ WRZUC UPDATE
            addInfos();
            update();
            final Scene scene = new Scene(rootx, 1200, 800);
            stage.setScene(scene);
            stage.setTitle("Simulation");
            stage.show();
      //  }
    }

}


