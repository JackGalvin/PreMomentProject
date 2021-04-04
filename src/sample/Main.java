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

    int forceCounter = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("TestMoments"); //stage = window scene = inside layout = what you use to make your scene

        BorderPane MomentLayout = new BorderPane();
        VBox MomentConfig = new VBox(10);
        MomentConfig.setStyle("-fx-background-color: #92e3df;");

        Label MomentMenuTitle = new Label("Config Menu");
        MomentMenuTitle.setFont(new Font("Arial", 20));

        TextField sizeofPlank = new TextField("Plank Length");
        Slider pivotPosition = new Slider(); //used for moment calculations

        HBox Force1 = new HBox(10);
        HBox Force2 = new HBox(10);
        HBox Force3 = new HBox(10);
        HBox Force4 = new HBox(10);
        HBox Force5 = new HBox(10);
        HBox Force6 = new HBox(10);

        //VBox forceConfig = new VBox(10);
        //addfoce button in moment config
        //add new HBOX's to force config

        Button createForce = new Button("add new Force");
        createForce.setOnAction(e -> {

            if (forceCounter == 0){
                HBox force1tablet = HBoxForce.extendHBox();
                Force1.getChildren().add(force1tablet);
                Force1.getChildren().remove(createForce); //technically could add create node because child can only have one parent
                //HBox Force2 = new HBox(10);
                Force2.getChildren().add(createForce);
                MomentConfig.getChildren().addAll(Force2);
                forceCounter++;
            } else if (forceCounter == 1){
                HBox force1tablet = HBoxForce.extendHBox();
                Force2.getChildren().add(force1tablet);
                Force2.getChildren().remove(createForce); //technically could add create node because child can only have one parent
                //HBox Force3 = new HBox(10);
                Force3.getChildren().add(createForce);
                MomentConfig.getChildren().addAll(Force3);
                forceCounter++;
            } else if (forceCounter == 2){
                HBox force1tablet = HBoxForce.extendHBox();
                Force3.getChildren().add(force1tablet);
                Force3.getChildren().remove(createForce); //technically could add create node because child can only have one parent
                // HBox Force4 = new HBox(10);
                Force4.getChildren().add(createForce);
                MomentConfig.getChildren().addAll(Force4);
                forceCounter++;
            } else if (forceCounter == 3){
                HBox force1tablet = HBoxForce.extendHBox();
                Force4.getChildren().add(force1tablet);
                Force4.getChildren().remove(createForce); //technically could add create node because child can only have one parent
                Force5.getChildren().add(createForce);
                MomentConfig.getChildren().addAll(Force5);
                forceCounter++;
            } else if (forceCounter == 4){
                HBox force1tablet = HBoxForce.extendHBox();
                Force5.getChildren().add(force1tablet);
                Force5.getChildren().remove(createForce); //technically could add create node because child can only have one parent
                // HBox Force4 = new HBox(10);
                Force6.getChildren().add(createForce);
                MomentConfig.getChildren().addAll(Force6);
                forceCounter++;
            } else if (forceCounter == 5){
                HBox force1tablet = HBoxForce.extendHBox();
                Force6.getChildren().add(force1tablet);
                Force6.getChildren().remove(createForce); //technically could add create node because child can only have one parent
                forceCounter++;
            } else {
                System.out.println("How are you seeing this?");
            }

        });

        Force1.getChildren().add(createForce);
        MomentConfig.getChildren().addAll(MomentMenuTitle,sizeofPlank,pivotPosition,Force1);
        MomentLayout.setRight(MomentConfig);
        Scene scene1 = new Scene(MomentLayout, 1600, 900);
        primaryStage.setScene(scene1);
        primaryStage.show();
        //nextScene.setOnAction(e -> {primaryStage.setScene(scene2);}); //primaryStage is the parent. set scene"function that changes scene to", (scene2) //remember how to change scenes

    }

}
