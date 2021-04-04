package sample;

import javafx.scene.text.Font;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class AlertBox {

    public static void display(String title, String message){
        Stage alertStage = new Stage(); //creating stage
        alertStage.initModality(Modality.APPLICATION_MODAL); //basically makes it so you can't click out of the tab till a task is done
        alertStage.setTitle(title);

        HBox alertLayout = new HBox(30); //layout of scene

        Label alertMessage = new Label(message);//same as argument passed in for message
        alertMessage.setFont(new Font("Arial", 24));
        Button alertCloseBtn = new Button("Ok");
        alertCloseBtn.setOnAction(e -> {alertStage.close();});

        alertLayout.getChildren().addAll(alertMessage,alertCloseBtn); //adding children to parent scene
        Scene alertScene = new Scene(alertLayout); //giving stage layout, width and height.
        alertStage.setScene(alertScene);
        alertStage.showAndWait(); //shows the stage, window has to be closed of complete before user can do any other action.

    }


}
