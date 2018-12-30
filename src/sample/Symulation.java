package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.awt.*;
import javafx.scene.input.MouseEvent;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;


public class Symulation extends Application {

    public Group root=new Group();

    public void addTitle(){
        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

        Text t = new Text("Battle Simulation");
        t.setEffect(ds);
        t.setCache(true);
        t.setX(140);
        t.setY(70);
        t.setFill(Color.RED);
        t.setFont(Font.font(null, FontWeight.BOLD, 32));

        t.setTextAlignment(TextAlignment.CENTER);
        root.getChildren().addAll(t);

     }

    public void addButton(){

        Button button = new Button("Start");

        DropShadow shadow = new DropShadow();
        //Adding the shadow when the mouse cursor is on

        button.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        button.setEffect(shadow);
                    }
                });

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        button.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        button.setEffect(null);
                    }
                });
        button.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        button.setEffect(null);
                    }
                });

        button.setLayoutX(215);
        button.setLayoutY(200);
        button.setPrefSize(170,40);


        root.getChildren().addAll(button);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        Scene scene = new Scene(root, 600,400);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Battle Simulation");
        addTitle();
        addButton();
        primaryStage.show();

    }

    public static void main(String[] args) {

        launch(args);

    }
}
