package com.TianYaNing.BasicGameSample.component;

import com.TianYaNing.BasicGameSample.ui.PlantScene;
import com.almasb.fxgl.core.util.LazyValue;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.texture.Texture;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class PlantComponent extends Component {
    private Entity PlantEntity;
    private EventHandler<MouseEvent> PlantHandler;
    String name;

    private LazyValue<PlantScene> plantSceneLazyValue =new LazyValue<>(()->{
        return new PlantScene(entity.getX(),entity.getY());
    });
    @Override
    public void onAdded() {
        this.name=entity.getType().toString();
        PlantHandler=event->{
            FXGL.getSceneService().pushSubScene(plantSceneLazyValue.get());
        };
        ImageView imageView =new ImageView("assets/ui/Planting.png");
        Texture texture=new Texture(imageView.getImage());
        PlantEntity= FXGL.entityBuilder(new SpawnData(entity.getX(),entity.getY()))
                .view(texture).opacity(0)
                .scale(0.5,0.5)
                .build();
        FXGL.getGameWorld().addEntity(PlantEntity);
    }

    public void play(){
        PlantEntity.setOpacity(1);
        PlantEntity.getViewComponent().addOnClickHandler(PlantHandler);
    }
    public void stop(){
        PlantEntity.setOpacity(0);
        PlantEntity.getViewComponent().removeOnClickHandler(PlantHandler);
    }
}
