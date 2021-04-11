package sample;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.sql.SQLOutput;

public class Main extends Application {

    float plankLength = 100; //glitch where plank position doesnt change but only in step pivot settings
    double pivotPosition = 0;

    HBox pivotConfig = new HBox();

    public static void main(String[] args) { launch(args);}

    private Slider createPivotPositionSlider(float plankLength){
        this.plankLength = plankLength;
        Slider pivotPositionSlider = new Slider();
        pivotPositionSlider.setMin(0-(plankLength/2));
        pivotPositionSlider.setMax(plankLength/2);
        pivotPositionSlider.setValue(0);
        return pivotPositionSlider;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("TestMoments"); //stage = window scene = inside layout = what you use to make your scene

        //Menu Plane s1
        BorderPane MomentLayout = new BorderPane();
        VBox MomentConfig = new VBox(10);
        MomentConfig.setStyle("-fx-background-color: #92e3df;");
        Label MomentMenuTitle = new Label("Config Menu");
        MomentMenuTitle.setFont(new Font("Arial", 20));

        //force stuff s3
        VBox forceConfig = new VBox(10);
        //force creator
        Button createForce = new Button("add new Force");
        createForce.setOnAction(e -> {forceConfig.getChildren().add(HBoxForce.extendHBox(plankLength,pivotPosition));});

        //Pivot setting s2 //could put in a function OR put in s1's set on action command sequence
        Slider pivotPositionSlider = new Slider(); //used for moment calculations
        Button submitPivot = new Button("Submit");
        submitPivot.setOnAction(e -> {
            pivotPosition = pivotPositionSlider.getValue();
            MomentConfig.getChildren().remove(pivotConfig);
            Label pivotValue = new Label("Pivot at: " + pivotPosition);
            MomentConfig.getChildren().addAll(pivotValue,createForce,forceConfig);
        });

        //Plank settings s1
        HBox plankConfig = new HBox();
        Label labelPlank = new Label("Plank Length");
        TextField sizeOfPlank = new TextField("Plank Length");
        Button submitPlank = new Button("Submit");
        submitPlank.setOnAction(e -> {
            plankLength = Float.parseFloat(sizeOfPlank.getText());
            MomentConfig.getChildren().remove(plankConfig);
            //HBox pivotConfig = new HBox();
            Label plankValue = new Label("Plank length = " + plankLength);
            pivotPositionSlider.setMin(0-(plankLength/2)); //here to use the new values not the old ones
            pivotPositionSlider.setMax(plankLength/2);
            pivotPositionSlider.setValue(0);
            pivotConfig.getChildren().addAll(pivotPositionSlider,submitPivot);
            MomentConfig.getChildren().addAll(plankValue,pivotConfig);
        });
        plankConfig.getChildren().addAll(labelPlank,sizeOfPlank,submitPlank);




        MomentConfig.getChildren().addAll(MomentMenuTitle,plankConfig); //pivotPosition,createForce,forceConfig
        MomentLayout.setRight(MomentConfig);
        Scene scene1 = new Scene(MomentLayout, 1600, 900);
        primaryStage.setScene(scene1);
        primaryStage.show();
        //nextScene.setOnAction(e -> {primaryStage.setScene(scene2);}); //primaryStage is the parent. set scene"function that changes scene to", (scene2) //remember how to change scenes
    }

}
