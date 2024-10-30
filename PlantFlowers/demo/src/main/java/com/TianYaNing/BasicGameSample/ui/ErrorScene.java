package com.TianYaNing.BasicGameSample.ui;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class ErrorScene extends SubScene {
    private AnchorPane pane=new AnchorPane();
    double height = FXGL.getAppHeight();
    double width =FXGL.getAppWidth();
    double paneHeight=640;
    double paneWidth=720;
    double NodeWidth=paneWidth/2-40;
    double NodeHeight=80;
    Text text=new Text("Error!");
    public ErrorScene(){

        Button CloseButton =new Button("close");
        CloseButton.setOnAction(event -> {
            FXGL.getSceneService().popSubScene();
        });
        CloseButton.setLayoutX(NodeWidth);
        CloseButton.setLayoutY(320);
        Label label=new Label();
        label.setText(text.getText());
        label.setLayoutX(NodeWidth);
        label.setLayoutY(NodeHeight+80);
        pane.getChildren().add(label);
        pane.getChildren().add(CloseButton);
        pane.setMaxSize(paneWidth,paneHeight);
        pane.setStyle("-fx-background-color:white");
        StackPane centerPane =new StackPane(pane);
        centerPane.setPrefSize(width,height);
        centerPane.setStyle("-fx-background-color:#0007");
        getContentRoot().getChildren().add(centerPane);
    }
}
