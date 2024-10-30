package com.TianYaNing.BasicGameSample;

import com.TianYaNing.BasicGameSample.component.MoveComponent;
import com.TianYaNing.BasicGameSample.constant.EntityGroup;
import com.TianYaNing.BasicGameSample.factory.MapEntityFactory;
import com.TianYaNing.BasicGameSample.handler.PlayerLandCollisionHandler;
import com.TianYaNing.BasicGameSample.ui.BagScene;
import com.TianYaNing.BasicGameSample.ui.IdentityScene;
import com.TianYaNing.BasicGameSample.ui.ShopScene;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.input.UserAction;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;


import static com.almasb.fxgl.dsl.FXGL.*;

import java.util.List;
import java.util.Map;

public class BasicGameSample extends GameApplication {
    @Override
    protected void initGame() {
        FXGL.getGameWorld().addEntityFactory(new MapEntityFactory());
        setLevel();
        setLand();
        FXGL.getGameWorld().spawn("BoyPlayer");

    }
    @Override
    protected void onPreInit() {
        loopBGM("森林狂想曲.mp3");
    }
    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put(Config.GOLD_KEY,100);
        vars.put(Config.FPS_KEY,0);
        vars.put(Config.PANSY_KEY,5);
        vars.put(Config.Daisy_KEY,5);
        vars.put(Config.Calla_KEY,5);
        vars.put(Config.PANSY_Flower,0);
        vars.put(Config.Daisy_Flower,0);
        vars.put(Config.Calla_Flower,0);
        vars.put(Config.PANSY_FLOWER_PRICE,5);
        vars.put(Config.DAISY_FLOWER_PRICE,4);
        vars.put(Config.Calla_FLOWER_PRICE,5);
        vars.put(Config.PANSY_SEED_PRICE,3);
        vars.put(Config.DAISY_SEED_PRICE,3);
        vars.put(Config.Calla_SEED_PRICE,2);
    }

    @Override
    protected void initInput() {
        FXGL.getInput().addAction(new UserAction("up") {
            @Override
            protected void onAction() {
                super.onAction();
            }

            @Override
            protected void onActionBegin() {
                List<Entity> entitiesByType = FXGL.getGameWorld().getEntitiesByType(EntityGroup.BoyPLAYER);
                entitiesByType.get(0).getComponent(MoveComponent.class).up();
            }

            @Override
            protected void onActionEnd() {
                List<Entity> entitiesByType = FXGL.getGameWorld().getEntitiesByType(EntityGroup.BoyPLAYER);
                entitiesByType.get(0).getComponent(MoveComponent.class).stop();
            }
        }, KeyCode.W);
        FXGL.getInput().addAction(new UserAction("down") {
            @Override
            protected void onAction() {
                super.onAction();
            }

            @Override
            protected void onActionEnd() {
                List<Entity> entitiesByType = FXGL.getGameWorld().getEntitiesByType(EntityGroup.BoyPLAYER);
                entitiesByType.get(0).getComponent(MoveComponent.class).stop();
            }

            @Override
            protected void onActionBegin() {
                List<Entity> entitiesByType = FXGL.getGameWorld().getEntitiesByType(EntityGroup.BoyPLAYER);
                entitiesByType.get(0).getComponent(MoveComponent.class).down();
            }
        },KeyCode.S);
        FXGL.getInput().addAction(new UserAction("left") {
            @Override
            protected void onAction() {
                super.onAction();
            }

            @Override
            protected void onActionBegin() {
                List<Entity> entitiesByType = FXGL.getGameWorld().getEntitiesByType(EntityGroup.BoyPLAYER);
                entitiesByType.get(0).getComponent(MoveComponent.class).left();
            }

            @Override
            protected void onActionEnd() {
                List<Entity> entitiesByType = FXGL.getGameWorld().getEntitiesByType(EntityGroup.BoyPLAYER);
                entitiesByType.get(0).getComponent(MoveComponent.class).stop();
            }
        },KeyCode.A);
        FXGL.getInput().addAction(new UserAction("right") {
            @Override
            protected void onAction() {
                super.onAction();
            }

            @Override
            protected void onActionBegin() {
                List<Entity> entitiesByType = FXGL.getGameWorld().getEntitiesByType(EntityGroup.BoyPLAYER);
                entitiesByType.get(0).getComponent(MoveComponent.class).right();
            }

            @Override
            protected void onActionEnd() {
                List<Entity> entitiesByType = FXGL.getGameWorld().getEntitiesByType(EntityGroup.BoyPLAYER);
                entitiesByType.get(0).getComponent(MoveComponent.class).stop();
            }
        },KeyCode.D);

    }

    @Override
    protected void initSettings(GameSettings gameSettings) {
        gameSettings.setTitle("Basic Game Sample");
        gameSettings.setHeight(Config.APPHeight);
        gameSettings.setWidth(Config.APPWidth);
        gameSettings.setVersion("0.1");
//        gameSettings.setIntroEnabled(true);
//        gameSettings.setMainMenuEnabled(true);
//        gameSettings.setCloseConfirmation(true);
//
    }


    @Override
    protected void initUI() {
        String BagUrl="assets/ui/bag.png";
        double BagX= Config.UIWidth;
        double BagY=Config.UIHeight;
        String IdentityUrl="assets/ui/Identity-ui.png";
        double IdentityX=Config.UIWidth;
        double IdentityY=Config.UIHeight+Config.UIDistance;
        String BgmUrl="assets/ui/bgm.png";
        double BgmX=Config.UIWidth;
        double BgmY=Config.UIHeight+Config.UIDistance*2;
        String ShopUrl="assets/ui/shop.png";
        double ShopX=Config.UIWidth;
        double ShopY=Config.UIHeight+Config.UIDistance*3;
        Rectangle BagRec=addUI(BagUrl,BagX,BagY);
        Rectangle IdentityRec=addUI(IdentityUrl,IdentityX,IdentityY);
        Rectangle ShopRec=addUI(ShopUrl,ShopX,ShopY);
        BagRec.setOnMouseClicked(event->{
            FXGL.getSceneService().pushSubScene(new BagScene());
        });
        IdentityRec.setOnMouseClicked(event->{
            FXGL.getSceneService().pushSubScene(new IdentityScene());
        });
        ShopRec.setOnMouseClicked(event->{
            FXGL.getSceneService().pushSubScene(new ShopScene());
        });
        addUI(BgmUrl,BgmX,BgmY);


//        Text goldText=FXGL.getUIFactoryService().newText(FXGL.getip(Config.GOLD_KEY).asString());
//        goldText.setTranslateX(Config.UIWidth);
//        goldText.setTranslateY(Config.UIHeight+Config.UIDistance*2);
//        FXGL.addUINode(goldText);
    }

    //加载地图的方法
    private void setLevel() {
        FXGL.getGameWorld().getEntitiesCopy().forEach(t -> t.removeFromWorld());
         FXGL.setLevelFromMap("tmx/地图3.tmx");
    }

    @Override
    protected void initPhysics() {
        FXGL.getPhysicsWorld().addCollisionHandler(new PlayerLandCollisionHandler());
    }



    public static void main(String[] args) {
        launch(args);
    }
    private void setLand(){
        for(int i = 0; i<=Config.LandXNumber; i++){
            for(int j=0;j<=Config.LandYNumber;j++)
            FXGL.getGameWorld().spawn("Land",new SpawnData(new Point2D(i*90,j*80)));
        }
    }
    private Rectangle addUI(String url,double x,double y){
        Image image =new Image(url);
        Rectangle rectangle=new Rectangle(50,50);
        rectangle.setFill(new ImagePattern(image));
        FXGL.addUINode(rectangle,x,y);
        return rectangle;
    }
}
