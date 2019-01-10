package sample;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Main extends Application {

    Stage stage=new Stage();
    Army armyBlue;
    Army armyRed;

    boolean ready = false;

    public void btnset(Button btn, String title, double x, double y){
        btn.setText(title);
        btn.setLayoutX(x);
        btn.setLayoutY(y);
        btn.setPrefSize(170,40);
    }

    public static void main(String[] args) {
        launch(args);
    }

        @Override
        public void start(final Stage stage) throws Exception {

            Group root1 = new Group();
            Group root2 = new Group();
            Group root3 = new Group();
            Group root4 = new Group();

            new Simulation().createScene(root1);
            new Options().createScene(root2);

            Teams teamBlue = new Teams();
            Teams teamRed = new Teams();
            teamBlue.createScene(root3);
            teamRed.createScene(root4);
            PredictingFight predictions = new PredictingFight();
            SimulationScreen sym = new SimulationScreen();


            final Scene scene1 = new Scene(root1, 600, 400);
            final Scene scene2 = new Scene(root2, 600, 400);
            final Scene scene3 = new Scene(root3, 600,  400);
            final Scene scene4 = new Scene(root4, 600,  400);


            stage.setScene(scene1);
            stage.setTitle("Simulation");

            Button button1 = new Button();
            btnset(button1,"Start",215,200);
            button1.setOnAction(event -> {
                stage.setScene(scene2);
                stage.setTitle("Settings");
            });
            root1.getChildren().addAll(button1);

            Button button2 = new Button();
            btnset(button2,"Blue team",215,130);
            button2.setOnAction(
                    event -> {
                        stage.setScene(scene3);
                        stage.setTitle("Blue team");
                    });
            root2.getChildren().addAll(button2);

            Button button3 = new Button();
            btnset(button3,"Red team",215,200);
            button3.setOnAction(
                    event -> {
                        stage.setScene(scene4);
                        stage.setTitle("Red team");
                    });
            root2.getChildren().addAll(button3);

            Button button4 = new Button();
            btnset(button4,"OK",215,260);
            button4.setOnAction(
                    event ->{
                          stage.setScene(scene2);
                          stage.setTitle("Settings");
                          armyBlue = teamBlue.setArmy(armyBlue);
                          sym.setArmyBlue(armyBlue);
            });
            root3.getChildren().addAll(button4);

            Button button5 = new Button();
            btnset(button5,"OK",215,260);
            button5.setOnAction(
                    event ->{
                        stage.setScene(scene2);
                        stage.setTitle("Settings");
                        armyRed = teamRed.setArmy(armyRed);
                        sym.setArmyRed(armyRed);
                    });
            root4.getChildren().addAll(button5);

            Button button6 = new Button();
            btnset(button6,"Start Simulation",215,270);
            button6.setOnAction(event -> {
                try {
                    int temp = predictions.lanchesterEquation(armyBlue, armyRed);
                    System.out.println(temp);
                    sym.start(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            root2.getChildren().addAll(button6);

            stage.show();

        }
    }

