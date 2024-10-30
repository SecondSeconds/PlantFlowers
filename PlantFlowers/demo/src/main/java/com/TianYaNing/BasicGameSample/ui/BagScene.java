package com.TianYaNing.BasicGameSample.ui;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class BagScene extends SubScene {
    private AnchorPane pane=new AnchorPane();
    double height = FXGL.getAppHeight();
    double width =FXGL.getAppWidth();
    double paneHeight=480;
    double paneWidth=640;
    double NodeWidth=paneWidth/2-40;
    double NodeHeight=80;
    public BagScene(){
        Button CloseButton =new Button("close");
        CloseButton.setOnAction(event -> {
            FXGL.getSceneService().popSubScene();
        });
        CloseButton.setLayoutX(NodeWidth);
        CloseButton.setLayoutY(320);
        pane.getChildren().add(CloseButton);
        pane.setMaxSize(paneWidth,paneHeight);
        pane.setStyle("-fx-background-color:white");
        addFlowerInformation("Pansy",1);
        addFlowerInformation("Daisy",2);
        addFlowerInformation("Calla",3);
        StackPane centerPane =new StackPane(pane);
        centerPane.setPrefSize(width,height);
        centerPane.setStyle("-fx-background-color:#0007");
        getContentRoot().getChildren().add(centerPane);
    }
    private void addFlowerInformation(String name,double number){
        Button button=new Button(name);
        button.setOnAction(event -> {
            FXGL.getSceneService().pushSubScene(new InformationScene(name));
        });
        button.setLayoutX(NodeWidth);
        button.setLayoutY(NodeHeight+(number-1)*40);
        pane.getChildren().add(button);
    }
}
