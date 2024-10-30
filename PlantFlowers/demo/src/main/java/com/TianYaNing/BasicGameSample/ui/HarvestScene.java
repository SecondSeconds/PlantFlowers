package com.TianYaNing.BasicGameSample.ui;

import com.TianYaNing.BasicGameSample.Config;
import com.TianYaNing.BasicGameSample.component.GrowComponent;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class HarvestScene extends SubScene {
    private AnchorPane pane=new AnchorPane();
    double height = FXGL.getAppHeight();
    double width =FXGL.getAppWidth();
    double paneHeight=480;
    double paneWidth=640;
    double NodeWidth=paneWidth/2-40;
    double NodeHeight=80;
    String name;
    public HarvestScene(Entity entity){
        this.name=entity.getType().toString();
        Button harvestButton=new Button("harvest");
        harvestButton.setOnAction(event ->{
            entity.removeFromWorld();
            entity.getComponent(GrowComponent.class).afterHarvest();
            int number;
            switch (this.name){
                case "Pansy":
                    number=FXGL.geti(Config.PANSY_Flower)+1;
                    FXGL.set(Config.PANSY_Flower,number);
                    break;
                case "Daisy":
                    number=FXGL.geti(Config.Daisy_Flower)+1;
                    FXGL.set(Config.Daisy_Flower,number);
                    break;
                case "Calla":
                    number=FXGL.geti(Config.Calla_Flower)+1;
                    FXGL.set(Config.Calla_Flower,number);
                default:
                    break;
            }
        });
        harvestButton.setLayoutX(201);
        harvestButton.setLayoutY(30);
        Button closeButton=new Button("Close");
        closeButton.setOnAction(event -> {
            FXGL.getSceneService().popSubScene();
        });
        closeButton.setLayoutX(201);
        closeButton.setLayoutY(90);
        pane.getChildren().add(closeButton);
        pane.getChildren().add(harvestButton);
        pane.setMaxSize(paneWidth,paneHeight);
        pane.setStyle("-fx-background-color:white");
        StackPane centerPane =new StackPane(pane);
        centerPane.setPrefSize(width,height);
        centerPane.setStyle("-fx-background-color:#0007");
        getContentRoot().getChildren().add(centerPane);

    }
}
