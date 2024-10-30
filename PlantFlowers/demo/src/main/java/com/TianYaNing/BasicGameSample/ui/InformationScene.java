package com.TianYaNing.BasicGameSample.ui;

import com.TianYaNing.BasicGameSample.Config;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.scene.SubScene;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class InformationScene extends SubScene {
    double height = FXGL.getAppHeight();
    double width =FXGL.getAppWidth();
    double paneHeight=480;
    double paneWidth=640;
    double NodeWidth=paneWidth/2-40;
    double NodeHeight=80;
    AnchorPane pane=new AnchorPane();

    Text PansyText=new Text("It is more cold-resistant," +
            "\nlikes coolness, and likes sunlight");
    Text PansyFlowerNumberText=FXGL.getUIFactoryService().newText(FXGL.getip(Config.PANSY_Flower).asString());
    Text PansySeedNumberText=FXGL.getUIFactoryService().newText(FXGL.getip(Config.PANSY_KEY).asString());
    Text DaisyFlowerNumberText=FXGL.getUIFactoryService().newText(FXGL.getip(Config.Daisy_Flower).asString());
    Text DaisySeedNumberText=FXGL.getUIFactoryService().newText(FXGL.getip(Config.Daisy_KEY).asString());
    Text DaisyText=new Text("Hardy, suitable for cold climates");
    Text CallaText=new Text("Prefers moist, fertile soil");
    Text CallaFlowerNumberText=FXGL.getUIFactoryService().newText(FXGL.getip(Config.Calla_Flower).asString());
    Text CallaSeedNumberText=FXGL.getUIFactoryService().newText(FXGL.getip(Config.Calla_KEY).asString());
    public InformationScene(String name){
        Label label=new Label();
        Label FlowerLabel=new Label();
        switch (name){
            case "Pansy":
                label.setText(PansyText.getText());
                FlowerLabel.setText("Pansy seed number:"+PansySeedNumberText.getText()+"\nPansy flower number:"+PansyFlowerNumberText.getText());
                pane.setStyle("-fx-background-color:MediumPurple");
                break;
            case "Daisy":
                label.setText(DaisyText.getText());
                FlowerLabel.setText("Daisy seed number:"+DaisySeedNumberText.getText()+"\nDaisy flower number:"+DaisyFlowerNumberText.getText());
                pane.setStyle("-fx-background-color:pink");
                break;
            case "Calla":
                label.setText(CallaText.getText());
                FlowerLabel.setText("Calla lily seed number:"+CallaSeedNumberText.getText()+"\nCalla lily flower number:"+CallaFlowerNumberText.getText());
                pane.setStyle("-fx-background-color:#cde6c7");
                break;
            default:
                label.setText("Error");
        }
        label.setLayoutX(NodeWidth);
        label.setLayoutY(NodeHeight);
        FlowerLabel.setLayoutX(NodeWidth);
        FlowerLabel.setLayoutY(NodeHeight+40);
        pane.getChildren().add(FlowerLabel);
        pane.getChildren().add(label);
        Button CloseButton =new Button("close");
        CloseButton.setOnAction(event -> {
            FXGL.getSceneService().popSubScene();
        });
        CloseButton.setLayoutX(NodeWidth);
        CloseButton.setLayoutY(320);
        pane.getChildren().add(CloseButton);
        pane.setMaxSize(paneWidth,paneHeight);
        StackPane centerPane =new StackPane(pane);
        centerPane.setPrefSize(width,height);
        centerPane.setStyle("-fx-background-color:#0007");
        getContentRoot().getChildren().add(centerPane);
    }


}
