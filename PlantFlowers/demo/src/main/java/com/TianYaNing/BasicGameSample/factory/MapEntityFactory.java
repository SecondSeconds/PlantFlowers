package com.TianYaNing.BasicGameSample.factory;

import com.TianYaNing.BasicGameSample.component.GrowComponent;
import com.TianYaNing.BasicGameSample.component.IdentityComponent;
import com.TianYaNing.BasicGameSample.component.MoveComponent;
import com.TianYaNing.BasicGameSample.component.PlantComponent;
import com.TianYaNing.BasicGameSample.constant.EntityGroup;
import com.almasb.fxgl.app.scene.Viewport;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.texture.Texture;
import javafx.geometry.Point2D;

public class MapEntityFactory implements EntityFactory {
    @Spawns("Bag")
    public Entity newBag(SpawnData data){
        Entity Bag=FXGL
                .entityBuilder(data)
                .build();
        Bag.setOpacity(1);
        return Bag;
    }
    @Spawns("Land")
    public Entity newLand(SpawnData data) {
        Entity Land = FXGL
                .entityBuilder(data)
                .with(new PlantComponent())
                .bbox(new HitBox(new Point2D(0, 0) , BoundingShape.circle(40)))
                .collidable()
                .build();
        Land.setType(EntityGroup.Land);
        return Land;
    }
    @Spawns("BoyPlayer")
    public Entity newPlayer(SpawnData data) {
        Texture texture=FXGL.texture("player.PNG",70,70);
        Entity entity = FXGL.entityBuilder().view(texture)
                .with(new MoveComponent()).with(new IdentityComponent())
                .bbox(new HitBox(new Point2D(0,0),BoundingShape.circle(12)))
                .collidable()
                .build();
        entity.setType(EntityGroup.BoyPLAYER);
        entity.translateX(200);
        entity.translateY(200);
//        Viewport viewport = FXGL.getGameScene().getViewport();
//        viewport.setBounds(-10000,-10000,250 *70,10000);
//        viewport.bindToEntity(entity, FXGL.getAppWidth() / 2, FXGL.getAppHeight() / 2);
//        viewport.setLazy(true);
        return entity;
    }
    @Spawns("WildPansy")
    public Entity newWildPansy(SpawnData data){
        String url1="wild pansy 2.png";
        String url2="wild pansy 3.png";
        String url3="wild pansy 4.png";
        String url4="wild pansy 5.png";
        final int growCircle1 =5;
        final int growCircle2 =5;
        final int growCircle3 =5;
        final int growCircle4 =5;
        Texture texture =FXGL.texture("wild pansy 1.png",40,40);
        Entity entity=FXGL.entityBuilder()
                .at(new Point2D(data.get("x"),data.get("y")))
                .view(texture).with(new GrowComponent(url1,growCircle1,url2,growCircle2,url3,growCircle3,url4,growCircle4))
                .build();
        entity.setType(EntityGroup.Pansy);
        return entity;
    }
    @Spawns("Daisy")
    public Entity newDaisy(SpawnData data){
        String url1="Daisy 2.png";
        String url2="Daisy 3.png";
        String url3="Daisy 4.png";
        String url4="Daisy 5.png";
        final int growCircle1 =5;
        final int growCircle2 =5;
        final int growCircle3 =5;
        final int growCircle4 =5;
        Texture texture =FXGL.texture("Daisy 1.png",40,40);
        Entity entity=FXGL.entityBuilder()
                .view(texture)
                .at(new Point2D(data.get("x"),data.get("y")))
                .with(new GrowComponent(url1,growCircle1,url2,growCircle2,url3,growCircle3,url4,growCircle4))
                .build();
        entity.setType(EntityGroup.Daisy);
        return entity;
    }
    @Spawns("Calla")
    public Entity newCalla(SpawnData data){
        String url1="Calla lily 2.png";
        String url2="Calla lily 3.png";
        String url3="Calla lily 4.png";

        final int growCircle1 =6;
        final int growCircle2 =5;
        final int growCircle3 =5;
        Texture texture =FXGL.texture("Calla lily 1.png",40,40);
        Entity entity=FXGL.entityBuilder()
                .view(texture)
                .at(new Point2D(data.get("x"),data.get("y")))
                .with(new GrowComponent(url1,growCircle1,url2,growCircle2,url3,growCircle3))
                .build();
        entity.setType(EntityGroup.Calla);
        return entity;
    }

}
