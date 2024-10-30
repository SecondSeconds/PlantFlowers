package com.TianYaNing.BasicGameSample.ui;

import com.TianYaNing.BasicGameSample.Config;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class ShopScene extends SubScene {
    private AnchorPane pane=new AnchorPane();
    double height = FXGL.getAppHeight();
    double width =FXGL.getAppWidth();
    double paneHeight=640;
    double paneWidth=720;
    double NodeWidth=paneWidth/2-40;
    double NodeHeight=80;
    public ShopScene(){
        Button CloseButton =new Button("close");
        CloseButton.setOnAction(event -> {
            FXGL.getSceneService().popSubScene();
        });
        CloseButton.setLayoutX(NodeWidth);
        CloseButton.setLayoutY(320);
        pane.getChildren().add(CloseButton);
        addFlowerBuy(Config.PANSY_KEY,Config.PANSY_SEED_PRICE,0);
        addFlowerBuy(Config.Daisy_KEY,Config.DAISY_SEED_PRICE,1);
        addFlowerBuy(Config.Calla_KEY,Config.Calla_SEED_PRICE,2);
        addFlowerSell(Config.PANSY_Flower,Config.PANSY_FLOWER_PRICE,0);
        addFlowerSell(Config.Daisy_Flower,Config.DAISY_FLOWER_PRICE,1);
        addFlowerSell(Config.Calla_Flower,Config.Calla_FLOWER_PRICE,2);
        pane.setMaxSize(paneWidth,paneHeight);
        pane.setStyle("-fx-background-color:white");
        StackPane centerPane =new StackPane(pane);
        centerPane.setPrefSize(width,height);
        centerPane.setStyle("-fx-background-color:#0007");
        getContentRoot().getChildren().add(centerPane);
    }
    private void addFlowerBuy(String name,String price,double number){
        Button button=new Button("Buy "+name);
        button.setOnAction(event -> {
            int SeedNumber= FXGL.geti(name)+1;
            FXGL.set(name,SeedNumber);
            int goldNumber=FXGL.geti(Config.GOLD_KEY)-FXGL.geti(price);
            if(goldNumber>=0){
                FXGL.set(Config.GOLD_KEY,goldNumber);
            }else {
                FXGL.getSceneService().pushSubScene(new ErrorScene());
            }
        });
        button.setLayoutX(NodeWidth);
        button.setLayoutY(NodeHeight+(number-1)*60+30);
        pane.getChildren().add(button);
    }
    private void addFlowerSell(String name,String price,double number){
        Button button=new Button("Sell "+name);
        button.setOnAction(event -> {
            int FlowerNumber= FXGL.geti(name)-1;
            if(FlowerNumber>=0){
                FXGL.set(name,FlowerNumber);
            }else {
                FXGL.getSceneService().pushSubScene(new ErrorScene());
            }

            int goldNumber=FXGL.geti(Config.GOLD_KEY)+FXGL.geti(price);
            FXGL.set(Config.GOLD_KEY,goldNumber);
        });
        button.setLayoutX(NodeWidth);
        button.setLayoutY(NodeHeight+(number-1)*60);
        pane.getChildren().add(button);
    }
}
