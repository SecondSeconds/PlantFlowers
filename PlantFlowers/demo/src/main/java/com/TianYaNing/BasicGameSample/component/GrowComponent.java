package com.TianYaNing.BasicGameSample.component;

import com.TianYaNing.BasicGameSample.ui.HarvestScene;
import com.TianYaNing.BasicGameSample.ui.PlantScene;
import com.almasb.fxgl.core.util.LazyValue;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.entity.components.ViewComponent;
import com.almasb.fxgl.texture.Texture;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGLForKtKt.*;

public class GrowComponent extends Component {
    private int growthCircle1=5;
    private int growthCircle2=5;
    private int growthCircle3=5;
    private int growthCircle4=5;
    String url1;
    String url2;
    String url3;
    String url4;
    private Entity harvestEntity;
    private EventHandler<MouseEvent> harvestEvent;
    private LazyValue<HarvestScene> harvestSceneLazyValue =new LazyValue<>(()->{
        return new HarvestScene(entity);
    });

    @Override
    public void onAdded() {
        harvestEvent=new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                FXGL.getSceneService().pushSubScene(harvestSceneLazyValue.get());
            }
        };
        ImageView imageView =new ImageView("assets/ui/ripe.png");
        Texture texture=new Texture(imageView.getImage());
        harvestEntity= FXGL.entityBuilder(new SpawnData(entity.getX()+5,entity.getY()-30))
                .view(texture).opacity(0)
                .scale(0.5,0.5)
                .build();
        harvestEntity.getViewComponent().addOnClickHandler(harvestEvent);
        FXGL.getGameWorld().addEntity(harvestEntity);
    }
    //生长周期为二的植物
    public GrowComponent(String url1, int growthCircle1, String url2, int growthCircle2) {
        this.url1=url1;
        this.growthCircle1=growthCircle1;
        this.url2=url2;
        this.growthCircle2=growthCircle2;
        getGameTimer().runOnceAfter(()->{
            grow1();
        },Duration.seconds(this.growthCircle1));
        getGameTimer().runOnceAfter(()->{
            grow2();
            harvest();
        },Duration.seconds(this.growthCircle1+this.growthCircle2));
    }

    //生长周期为三的植物
    public GrowComponent(String url1, int growthCircle1, String url2, int growthCircle2, String url3, int growthCircle3) {
        this.url1=url1;
        this.growthCircle1=growthCircle1;
        this.url2=url2;
        this.growthCircle2=growthCircle2;
        this.url3=url3;
        this.growthCircle3=growthCircle3;
        getGameTimer().runOnceAfter(()->{
            grow1();
        },Duration.seconds(this.growthCircle1));
        getGameTimer().runOnceAfter(()->{
            grow2();
        },Duration.seconds(this.growthCircle1+this.growthCircle2));
        getGameTimer().runOnceAfter(()->{
            grow3();
            harvest();
        },Duration.seconds(this.growthCircle1+this.growthCircle2+this.growthCircle3));
    }

    //生长周期为四的植物
    public GrowComponent(String url1, int growthCircle1, String url2, int growthCircle2, String url3, int growthCircle3, String url4, int growthCircle4) {
        this.url1=url1;
        this.growthCircle1=growthCircle1;
        this.url2=url2;
        this.growthCircle2=growthCircle2;
        this.url3=url3;
        this.growthCircle3=growthCircle3;
        this.url4=url4;
        this.growthCircle4=growthCircle4;
        getGameTimer().runOnceAfter(()->{
            grow1();
        },Duration.seconds(this.growthCircle1));
        getGameTimer().runOnceAfter(()->{
            grow2();
        },Duration.seconds(this.growthCircle1+this.growthCircle2));
        getGameTimer().runOnceAfter(()->{
            grow3();
        },Duration.seconds(this.growthCircle1+this.growthCircle2+this.growthCircle3));
        getGameTimer().runOnceAfter(()->{
            grow4();
            harvest();
        },Duration.seconds(this.growthCircle1+this.growthCircle2+this.growthCircle3+this.growthCircle4));

    }

    public void grow1(){
        ViewComponent vc=entity.getViewComponent();
        Texture node=(Texture) vc.getChildren().get(0);
        node.dispose();
        vc.clearChildren();
        vc.addChild(texture(this.url1));
    }
    public void grow2(){
        ViewComponent vc=entity.getViewComponent();
        Texture node=(Texture) vc.getChildren().get(0);
        node.dispose();
        vc.clearChildren();
        vc.addChild(texture(this.url2));
    }
    public void grow3(){
        ViewComponent vc=entity.getViewComponent();
        Texture node=(Texture) vc.getChildren().get(0);
        node.dispose();
        vc.clearChildren();
        vc.addChild(texture(this.url3));
    }
    public void grow4(){
        ViewComponent vc=entity.getViewComponent();
        Texture node=(Texture) vc.getChildren().get(0);
        node.dispose();
        vc.clearChildren();
        vc.addChild(texture(this.url4));
    }
    //收获实体
//    public void buildHarvest(){
//        harvestEvent=new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                FXGL.getSceneService().pushSubScene(harvestSceneLazyValue.get());
//            }
//        };
//        ImageView imageView =new ImageView("assets/ui/ripe.png");
//        Texture texture=new Texture(imageView.getImage());
//        harvestEntity= FXGL.entityBuilder(new SpawnData(entity.getX(),entity.getY()))
//                .view(texture).opacity(0)
//                .scale(0.5,0.5)
//                .build();
//        harvestEntity.getViewComponent().addOnClickHandler(harvestEvent);
//        FXGL.getGameWorld().addEntity(harvestEntity);
//    }
    //显示可以收获
    public void harvest(){
        harvestEntity.setOpacity(1);

    }
    //收货后一同移除收获实体
    public void afterHarvest(){
        harvestEntity.removeFromWorld();
    }
}