package com.TianYaNing.BasicGameSample.ui;

import com.TianYaNing.BasicGameSample.Config;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Text;


public class IdentityScene extends SubScene {
    public IdentityScene(){
        double height = FXGL.getAppHeight();
        double width =FXGL.getAppWidth();
        double paneHeight=480;
        double paneWidth=640;
        Button CloseButton =new Button("close");
        Text goldText=FXGL.getUIFactoryService().newText(FXGL.getip(Config.GOLD_KEY).asString());
        Label goldLabel =new Label("gold number:"+goldText.getText());
        CloseButton.setOnAction(event -> {
            FXGL.getSceneService().popSubScene();
        });
        CloseButton.setLayoutX(paneWidth/2-40);
        CloseButton.setLayoutY(320);
        goldLabel.setLayoutX(paneWidth/2-40);
        goldLabel.setLayoutY(80);
        AnchorPane pane = new AnchorPane(CloseButton,goldLabel);
        pane.setMaxSize(paneWidth,paneHeight);
        pane.setStyle("-fx-background-color:white");
       StackPane centerPane =new StackPane(pane);
       centerPane.setPrefSize(width,height);
       centerPane.setStyle("-fx-background-color:#0007");
       getContentRoot().getChildren().add(centerPane);
    }
}
