package gameClasses.UI;

import java.util.function.Function;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class EzButton extends Button {

    public EzButton(Function<ActionEvent, Void> onClickFunction, String text) {
        this.setText(text);

        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onClickFunction.apply(event);
            }
        });
    }

    public EzButton(Function<ActionEvent, Void> onClickFunction, String text, int sizeX, int sizeY) {
        this.setText(text);
        this.setPrefSize(sizeX, sizeY);

        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onClickFunction.apply(event);
            }
        });
    }
}
