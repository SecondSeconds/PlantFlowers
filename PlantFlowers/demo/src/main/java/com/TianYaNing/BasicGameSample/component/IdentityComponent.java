package com.TianYaNing.BasicGameSample.component;

import com.TianYaNing.BasicGameSample.ui.IdentityScene;
import com.almasb.fxgl.core.util.LazyValue;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class IdentityComponent extends Component {
    private LazyValue<IdentityScene> IdentitySceneLazyValue=new LazyValue<>(()->{
            return new IdentityScene();
    });
    private EventHandler<MouseEvent> IdentityHandler;
    @Override
    public void onAdded() {
        IdentityHandler=new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                FXGL.getSceneService().pushSubScene(IdentitySceneLazyValue.get());
            }
        };
        entity.getViewComponent().addOnClickHandler(IdentityHandler);
    }

}
