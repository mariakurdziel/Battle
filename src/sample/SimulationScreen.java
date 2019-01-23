package sample;

import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Bounds;
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
import javafx.util.Duration;
import javafx.util.Pair;
import sample.SetTypes.ArmyTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SimulationScreen extends Application {


    public Group rootx = new Group();
    Stage stage = new Stage();
    Army armyBlue;
    Army armyRed;
    PredictingFight predictions = new PredictingFight();
    int populationBlueStart;
    int populationRedStart;
    double enemyLayoutY;
    public List<Pair<Double,Double>> redLayouts =new ArrayList<Pair<Double,Double>>();
    public List<Pair<Double,Double>> blueLayouts =new ArrayList<Pair<Double,Double>>();

    public void setArmyBlue(Army armyBlue) {
        this.armyBlue = armyBlue;
        populationBlueStart = armyBlue.getNumber();
    }

    public void setArmyRed(Army armyRed) {
        this.armyRed = armyRed;
        populationRedStart = armyRed.getNumber();
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
        else if (text.getAttribute().equals("HealthPoints"))
            return String.valueOf((x.getHealthPoints()));
        else if (text.getAttribute().equals("Squads"))
            return String.valueOf((x.getSquads().size()));
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
        int x = 100;
        int y = 200;
        int widthY = 15;
        double radius = 5.0;

        for (int i = 0; i < armyBlue.getSquads().size(); i++) {
            armyBlue.getSquads().get(i).setX(armyBlue.getSquads().get(i).getX() + (x*i + 10));
            armyBlue.getSquads().get(i).setY(armyBlue.getSquads().get(i).getY() + y);

            if((i % 30)==0 && i != 0){
                x = 100;
                y = y + widthY;
            }

            Circle c1 = new Circle(x, y, radius);
            x += widthY;
            c1.setStroke(Color.WHITE);
            c1.setFill(Color.WHITE);
            c1.setStrokeWidth(1);
            rootx.getChildren().add(c1);

        }


    }

    public void printArmyRed(){
        int x = 100;
        int y = 600;
        int widthY = 15;
        double radius = 5.0;

        for (int i = 0; i < armyRed.getSquads().size(); i++) {
            armyRed.getSquads().get(i).setX(armyRed.getSquads().get(i).getX() + (x*i + 10));
            armyRed.getSquads().get(i).setY(armyRed.getSquads().get(i).getY() + y);

            if((i % 30)==0 && i != 0){
                x = 100;
                y = y + widthY;
            }

            /*Circle c1 = new Circle(x, y, radius);
            x += widthY;
            c1.setStroke(Color.RED);
            c1.setFill(Color.RED);
            c1.setStrokeWidth(1);
            rootx.getChildren().add(c1);*/
        }
    }

    public void attack(){
        PredictingFight x= new PredictingFight();
        for(int i=0; i<redLayouts.size();i++){
            for(int j=0; j<blueLayouts.size();j++)
            {
                //System.out.println(redLayouts.get(j).getKey());
                //System.out.println(blueLayouts.get(j).getKey());
                if(redLayouts.get(i).getKey()==blueLayouts.get(j).getKey() && redLayouts.get(i).getValue()-blueLayouts.get(j).getValue()<20)
                {
                    if(x.lanchesterEquation(armyBlue,armyRed)==1) {
                        Circle c1 = new Circle(redLayouts.get(j).getKey(), redLayouts.get(i).getValue(), 6.0);
                        c1.setFill(Color.BLACK);
                        c1.setFill(Color.WHITE);
                    }
                    else{
                    Circle c1 = new Circle(blueLayouts.get(j).getKey(), blueLayouts.get(j).getValue(), 6.0);
                    c1.setFill(Color.BLACK);
                    c1.setFill(Color.WHITE);

                }

                }


            }
        }
    }

    public void moveArmyRed(double speed){

        int x = 100;
        int y = 600;
        double k=0;
        double var=0;
        int widthY = 15;
        double radius=5.0;
        for (int i = 0; i < armyRed.getSquads().size(); i++) {


            if((i % 30)==0 && i != 0){
                x = 100;
                y = y + widthY;
                k+=7;
            }

            if(i%30==2)
                var=10;

            Circle c1 = new Circle(x, y, 5.0);
            c1.setStroke(Color.RED);
            c1.setFill(Color.RED);
            c1.setStrokeWidth(1);
            rootx.getChildren().add(c1);
            Bounds bounds = rootx.getBoundsInLocal();
            redLayouts.add(new Pair<Double, Double>((double) x, bounds.getMaxY()/2-(5*c1.getRadius()/2)+k+var+5+(widthY+10)*Math.round(armyBlue.getSquads().size()/30)));
            x+=widthY;
            System.out.println(Double.toString(x));
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(speed), new KeyValue((c1.centerYProperty()), bounds.getMaxY()/2-(5*c1.getRadius()/2)+k+5+(widthY+10)*Math.round(armyBlue.getSquads().size()/30))));
            timeline.setCycleCount(1);
            timeline.play();



        }

    }

    public void moveArmyBlue(double speed){

        int x = 100;
        int y = 200;
        int widthY = 15;
        for (int i = 0; i < armyBlue.getSquads().size(); i++) {

            if((i % 30)==0 && i != 0){
                x = 100;
                y = y + widthY;
            }



            Circle c1 = new Circle(x, y, 5.0);
            x += widthY;
            c1.setStroke(Color.BLUE);
            c1.setFill(Color.BLUE);
            c1.setStrokeWidth(1);
            rootx.getChildren().add(c1);
            Bounds bounds = rootx.getBoundsInLocal();
            System.out.println(Double.toString(x));
            blueLayouts.add(new Pair<Double, Double>((double) x,bounds.getMaxY()-5*c1.getRadius()/2));
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), new KeyValue(c1.layoutYProperty(), (bounds.getMaxY()/2-5*c1.getRadius()/2))));
            timeline.setCycleCount(1);
            timeline.play();

        }
    }


    public void start() {
        printArmyBlue();
        printArmyRed();
        moveArmyBlue(armyBlue.getAttackSpeed());
        moveArmyRed(armyRed.getAttackSpeed());
        attack();

        for (int i = 0; i < armyRed.getSquads().size(); i++) {
            System.out.println("Czerwoni, oddzial: " + i + ", populacja: " + armyRed.getSquads().get(i).getPopulation()
                    + ", zycie: " + armyRed.getSquads().get(i).getHealth()
                    + ", moje polozenie: " + armyRed.getSquads().get(i).getX()
                    + ", " + armyRed.getSquads().get(i).getY());
        }
        for (int i = 0; i < armyBlue.getSquads().size(); i++) {
            System.out.println("Niebiescy, oddzial: " + i + ", populacja: " + armyBlue.getSquads().get(i).getPopulation()
                    + ", zycie: " + armyBlue.getSquads().get(i).getHealth()
                    + ", moje polozenie: " + armyBlue.getSquads().get(i).getX()
                    + ", " + armyBlue.getSquads().get(i).getY());


        }

    }

    public void update() {

            predictions.lanchesterEquation(armyBlue, armyRed);
            for (int i = 0; i < armyRed.getSquads().size(); i++) {
                System.out.println("Czerwoni, oddzial: " + i + ", populacja: " + armyRed.getSquads().get(i).getPopulation()
                        + ", zycie: " + armyRed.getSquads().get(i).getHealth()
                        + ", morale: " + armyRed.getSquads().get(i).getMorale()
                        + ", moje polozenie: " + armyRed.getSquads().get(i).getX()
                        + ", " + armyRed.getSquads().get(i).getY()
                        + ", wybrany wrog polozenie: " + armyRed.getSquads().get(i).getAttackedSquad().getX()
                        + ", " + armyRed.getSquads().get(i).getAttackedSquad().getY());
            }
            for (int i = 0; i < armyBlue.getSquads().size(); i++) {
                System.out.println("Niebiescy, oddzial: " + i + ", populacja: " + armyBlue.getSquads().get(i).getPopulation()
                        + ", zycie: " + armyBlue.getSquads().get(i).getHealth()
                        + ", morale: " + armyBlue.getSquads().get(i).getMorale()
                        + ", moje polozenie: " + armyBlue.getSquads().get(i).getX()
                        + ", " + armyBlue.getSquads().get(i).getY()
                        + ", wybrany wrog polozenie: " + armyBlue.getSquads().get(i).getAttackedSquad().getX()
                        + ", " + armyBlue.getSquads().get(i).getAttackedSquad().getY());
            }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

            final Scene scene = new Scene(rootx, 1200, 800);
            start();
            while(!predictions.isTheEnd()) {
                System.out.println("--------");
                System.out.println(predictions.whosWinning());
                System.out.println("-----------------------------");
                update();

            }
            addTitle();
            addInfos();
            stage.setScene(scene);
            stage.setTitle("Simulation");
            stage.show();}

}


