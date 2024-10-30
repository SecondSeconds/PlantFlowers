package com.TianYaNing.BasicGameSample.handler;

import com.TianYaNing.BasicGameSample.component.PlantComponent;
import com.TianYaNing.BasicGameSample.constant.EntityGroup;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.CollisionHandler;

public class PlayerLandCollisionHandler extends CollisionHandler {

    public PlayerLandCollisionHandler() {
        super(EntityGroup.BoyPLAYER,EntityGroup.Land);
    }

    @Override
    protected void onCollisionBegin(Entity player, Entity land) {
        land.getComponent(PlantComponent.class).play();
    }

    @Override
    protected void onCollisionEnd(Entity player, Entity land) {
        land.getComponent(PlantComponent.class).stop();

    }
}
