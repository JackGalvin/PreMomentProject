package sample;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class HBoxForce {

    public static HBox extendHBox(double plankLength, double pivotPosition){
        HBox force1tablet = new HBox(10);
        TextField magInput = new TextField("Magnitude");
        CheckBox ACW = new CheckBox("Anticlockwise?");
        Slider angle = new Slider(); angle.setMin(0); angle.setMax(180); angle.setValue(90);
        Slider position = new Slider(); position.setMin(0-(plankLength/2)); position.setMax(plankLength/2); position.setValue(0);

        Button submitForce = new Button("submit force");
        submitForce.setOnAction(a -> { //a is the same as e
            Force f = new Force(Integer.parseInt(magInput.getText()),ACW.isSelected(),angle.getValue(),position.getValue(),pivotPosition);
            //System.out.println("Magnitude = " + f.getMagnitude()); //testing (WORKING!!)
            //System.out.println("ACW? = " + f.isAntiClockWise());
            //System.out.println("Angle = " + f.getAngle());
            //System.out.println("Position = " + f.getPosition());
            //System.out.println("Distance from Pivot = " + f.getDistanceFromPivot());
            //System.out.println("Moment = " + f.getMoment());
        });

        force1tablet.getChildren().addAll(magInput,ACW,angle,position,submitForce);
        return force1tablet;
    }




}
