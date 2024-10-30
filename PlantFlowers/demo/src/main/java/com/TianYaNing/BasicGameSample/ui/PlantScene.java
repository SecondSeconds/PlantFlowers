package com.TianYaNing.BasicGameSample.ui;

import com.TianYaNing.BasicGameSample.Config;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.scene.SubScene;
import com.almasb.fxgl.ui.FontType;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PlantScene extends SubScene {
    private double PlantX;
    private double PlantY;
    public PlantScene(double PositionX,double PositionY){
        PlantX=PositionX+50;
        PlantY=PositionY+50;
        double height=480;
        double width=640;
        Text PansyText=FXGL.getUIFactoryService().newText(FXGL.getip(Config.PANSY_KEY).asString());
        Text DaisyText=FXGL.getUIFactoryService().newText(FXGL.getip(Config.Daisy_KEY).asString());
        Text CallaText=FXGL.getUIFactoryService().newText(FXGL.getip(Config.Calla_KEY).asString());
        Label PansyLabel = new Label("Pansy seed number:"+PansyText.getText());
        Label DaisyLabel = new Label("Daisy seed number:"+DaisyText.getText());
        Label CallaLabel = new Label("Calla lily seed number:"+CallaText.getText());
        Button button = new Button("Close");
        button.setOnAction(event->{
            FXGL.getSceneService().popSubScene();
        });
        Button DaisyButton =new Button("PlantDaisy");
        DaisyButton.setOnAction(event -> {
            FXGL.getGameWorld().spawn("Daisy",new SpawnData().put("x",PlantX).put("y",PlantY));
            int number=FXGL.geti(Config.Daisy_KEY)-1;
            if(number>=0){
                FXGL.set(Config.Daisy_KEY,number);
                DaisyLabel.setText("Daisy seed number:"+FXGL.getUIFactoryService().newText(FXGL.getip(Config.Daisy_KEY).asString()).getText());
            }else{
                FXGL.getSceneService().pushSubScene(new ErrorScene());
            }

        });
        Button PansyButton =new Button("PlantPansy");
        PansyButton.setOnAction(event -> {
            FXGL.getGameWorld().spawn("WildPansy",new SpawnData().put("x",PlantX).put("y",PlantY));
            int number=FXGL.geti(Config.PANSY_KEY)-1;
            if(number>0){
                FXGL.set(Config.PANSY_KEY,number);
                PansyLabel.setText("Pansy seed number:"+FXGL.getUIFactoryService().newText(FXGL.getip(Config.PANSY_KEY).asString()).getText());
            }else{
                FXGL.getSceneService().pushSubScene(new ErrorScene());
            }
        });
        Button CallaButton =new Button("PlantCalla lily");
        CallaButton.setOnAction(event -> {
                    FXGL.getGameWorld().spawn("Calla", new SpawnData().put("x", PlantX).put("y", PlantY));
                    int number = FXGL.geti(Config.Calla_KEY) - 1;
                    if (number > 0) {
                        FXGL.set(Config.Calla_KEY, number);
                        CallaLabel.setText("Calla lily seed number:" + FXGL.getUIFactoryService().newText(FXGL.getip(Config.Calla_KEY).asString()).getText());
                    } else {
                        FXGL.getSceneService().pushSubScene(new ErrorScene());
                    }
        });

        PansyLabel.setLayoutX(width/2-50);
        PansyLabel.setLayoutY(80);
        PansyButton.setLayoutX(width/2-50);
        PansyButton.setLayoutY(120);
        DaisyLabel.setLayoutX(width/2-50);
        DaisyLabel.setLayoutY(160);
        DaisyButton.setLayoutX(width/2-50);
        DaisyButton.setLayoutY(200);
        CallaLabel.setLayoutX(width/2-50);
        CallaLabel.setLayoutY(240);
        CallaButton.setLayoutX(width/2-50);
        CallaButton.setLayoutY(280);
        button.setLayoutX(width/2-50);
        button.setLayoutY(320);
        AnchorPane centerPane=new AnchorPane(PansyLabel,PansyButton,DaisyLabel,DaisyButton,CallaLabel,CallaButton,button);
        centerPane.setMaxSize(width,height);
        centerPane.setStyle("-fx-background-color:white");
        StackPane pane=new StackPane(centerPane);
        pane.setPrefSize(FXGL.getAppWidth(),FXGL.getAppHeight());
        pane.setStyle("-fx-background-color:#0007");
        getContentRoot().getChildren().add(pane);
    }

}
