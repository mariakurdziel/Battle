package sample;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Main extends Application {

    Stage stage=new Stage();
    Army army1;
 //   Army army2;
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
            TeamBlue arm1 = new TeamBlue();
            arm1.createScene(root3);

            SimulationScreen sym = new SimulationScreen();


            final Scene scene1 = new Scene(root1, 600, 400);
            final Scene scene2 = new Scene(root2, 600, 400);
            final Scene scene3 = new Scene(root3, 600,  400);
         //   final Scene scene4 = new Scene(root4, 600,  400);


            stage.setScene(scene1);
            stage.setTitle("Simulation");

            Button button1 = new Button();
            btnset(button1,"Start",215,200);
            button1.setOnAction(event -> {
                stage.setScene(scene2);
                stage.setTitle("Settings");
            });
            root1.getChildren().addAll(button1);

            Button button2= new Button();
            btnset(button2,"Army1",215,130);

            button2.setOnAction(
                    event -> {
                        stage.setScene(scene3);
                        stage.setTitle("Army 1");
                    });
            root2.getChildren().addAll(button2);

            Button button4 = new Button();
            btnset(button4,"OK",215,260);
            button4.setOnAction(
                    event ->{
                          stage.setScene(scene2);
                          stage.setTitle("Settings");
                          army1 = arm1.setArmy(army1);
                          sym.setArmy1(army1);
            });
            root3.getChildren().addAll(button4);

         //   javafx.scene.control.Button button5= new javafx.scene.control.Button();
         //   btnset(button5,"OK",215,260);
        //    button5.setOnAction(event -> { stage.setScene(scene2);stage.setTitle("Settings");army2=arm2.setArmy(army2); sym.setArmy2(army2); });
        //    root4.getChildren().addAll(button5);

            Button button6 = new Button();
            btnset(button6,"Start Simulation",215,270);
            button6.setOnAction(event -> {
                try {
                    sym.start(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            root2.getChildren().addAll(button6);

            stage.show();

        }
    }

