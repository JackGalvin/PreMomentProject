package sample;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class HBoxForce {

    public static HBox extendHBox(){
        HBox force1tablet = new HBox(10);
        TextField magInput = new TextField("Magnitude");
        CheckBox ACW = new CheckBox("Anticlockwise?");
        Slider angle = new Slider(); angle.setMin(0); angle.setMax(180); angle.setValue(90);
        int plankLength = 24;
        Slider position = new Slider(); position.setMin(0-(plankLength/2)); position.setMax(plankLength/2); position.setValue(0);

        Button submitForce = new Button("submit force");
        submitForce.setOnAction(a -> { //a is the same as e
            Force f1 = new Force(Integer.parseInt(magInput.getText()),ACW.isSelected(),angle.getValue(),position.getValue());
            System.out.println("action or function to create force");
        });

        force1tablet.getChildren().addAll(magInput,ACW,angle,position,submitForce);
        //copied up til here from Main
        return force1tablet;
    }




}
