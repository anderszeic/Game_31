package gameClasses.UI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class EzPopup extends Popup {
    public EzPopup(Stage stage) {
        Rectangle rect = new Rectangle();
        rect.setHeight(100);
        rect.setWidth(500);
        rect.setFill(Color.WHITE);
        rect.setStroke(Color.BLACK);
        Button okButton = new Button();
        okButton.setText("ok");

        Popup p = this;

        okButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                p.hide();
            }
        });
        StackPane stack = new StackPane();
        VBox vbox = new VBox(
                new Text("End of deck reached, shuffled discard deck and continuing with it"),
                okButton);
        vbox.setAlignment(Pos.CENTER);
        stack.getChildren().addAll(rect, vbox);
        this.getContent().add(stack);
    }

}
