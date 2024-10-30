package com.TianYaNing.BasicGameSample.ui;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.scene.SubScene;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class SelectIdentityScene extends SubScene {
    private String Boy ="Boy";
    private String Girl="Girl";

    private int BoySign=0;
    private int GirlSign=0;
    private final ImageView girlPlayer=new ImageView();
    private final ImageView boyPlayer=new ImageView();
    public SelectIdentityScene(){
        double width = FXGL.getAppWidth()/4d;
        double height = FXGL.getAppHeight()/4d;
        ToggleButton BoyButton = new ToggleButton(Boy);
        ToggleButton GirlButton = new ToggleButton(Girl);
        ToggleGroup toggleGroup=new ToggleGroup();
        BoyButton.setToggleGroup(toggleGroup);
        GirlButton.setToggleGroup(toggleGroup);
        toggleGroup.selectedToggleProperty().addListener(observable -> {
            ToggleButton btn = (ToggleButton) toggleGroup.getSelectedToggle();
            String result= btn.getText();
            if (result.equals(Boy)){
                BoySign=1;
            }else if(result.equals(Girl)){
                GirlSign=1;
            }
        });
        StackPane IdentityPane =new StackPane(BoyButton,GirlButton);
        IdentityPane.setMaxHeight(height);
        IdentityPane.setMaxWidth(width);
        getContentRoot().getChildren().add(IdentityPane);
    }
}
