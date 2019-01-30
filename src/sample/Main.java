package sample;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.util.HashMap;

public class Main extends Application {

    Army armyBlue;
    Army armyRed;

    Group root1 = new Group();
    Group root2 = new Group();
    Group root3 = new Group();
    Group root4 = new Group();

    final Scene scene1 = new Scene(root1, 600, 400);
    final Scene scene2 = new Scene(root2, 600, 400);
    final Scene scene3 = new Scene(root3, 600,  400);
    final Scene scene4 = new Scene(root4, 600,  400);

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

        HashMap roots = new HashMap();
        roots.put("ROOT1",root1);
        roots.put("ROOT2",root2);
        roots.put("ROOT3",root3);
        roots.put("ROOT4",root4);

        HashMap scenes = new HashMap();
        scenes.put("SCENE1",scene1);
        scenes.put("SCENE2",scene2);
        scenes.put("SCENE3",scene3);
        scenes.put("SCENE4",scene4);

        new Simulation().createScene(root1);
        new Options().createScene(root2);
        Teams teamBlue = new Teams();
        Teams teamRed = new Teams();
        teamBlue.createScene(root3);
        teamRed.createScene(root4);
        SimulationScreen sym = new SimulationScreen();
        stage.setScene(scene1);
        stage.setTitle("Simulation");

        for (UIHandler buttons : UIHandler.values()){

            Button button = new Button();

            btnset(button,buttons.getBtntext(),buttons.getLayoutx(),buttons.getLayouty());
            button.setOnAction(event -> {
                if(buttons.getScene()!="")
                    stage.setScene((Scene) scenes.get(buttons.getScene()));
                stage.setTitle(buttons.getText());

                if(buttons.getType().equals("BUTTON_ARMB"))
                {
                    armyBlue = teamBlue.setArmy(armyBlue);
                    sym.setArmyBlue(armyBlue);
                }
                else if (buttons.getType().equals("BUTTON_ARMR"))
                {
                    armyRed = teamRed.setArmy(armyRed);
                    sym.setArmyRed(armyRed);
                }
                else if(buttons.getType().equals("BUTTON_SYM"))
                    try {
                        sym.start(stage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            });

            Group rooty= (Group) roots.get(buttons.getRoot());
            rooty.getChildren().addAll(button);
        }
        stage.show();
    }
}


