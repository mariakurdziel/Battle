package sample;

import javafx.scene.Group;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Options {

    public Group root = new Group();
    public Stage primaryStage = new Stage();

    public void addTitle(){
        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

        Text t = new Text("Settings");
        t.setEffect(ds);
        t.setCache(true);
        t.setX(223);
        t.setY(70);
        t.setFill(Color.RED);
        t.setFont(Font.font(null, FontWeight.BOLD, 32));

        t.setTextAlignment(TextAlignment.CENTER);
        root.getChildren().addAll(t);

    }


public Group createScene(Group root){

     this.root=root;

     addTitle();

    return root;
}
}
