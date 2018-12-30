package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.awt.*;

import static java.awt.Color.RED;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Symulation x =new Symulation();
        x.start(primaryStage);
    }


    public static void main(String[] args) {
        launch(args);

    }
}
