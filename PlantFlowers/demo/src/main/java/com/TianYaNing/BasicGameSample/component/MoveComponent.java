package com.TianYaNing.BasicGameSample.component;

import com.almasb.fxgl.core.math.Vec2;
import com.almasb.fxgl.entity.component.Component;

public class MoveComponent extends Component {
    private double SpeedX=0d;
    private double SpeedY=0d;
    private double MaxSpeed =4d;

    @Override
    public void onUpdate(double tpf) {
        if (SpeedX != 0d) {
            Vec2 dir = Vec2.fromAngle(entity.getRotation() - 360)
                    .mulLocal(SpeedX);
            entity.translate(dir);
        }
        if (SpeedY != 0d) {
            Vec2 dir = Vec2.fromAngle(entity.getRotation() - 90)
                    .mulLocal(SpeedY);
            entity.translate(dir);
        }
    }
    public void up() {
        SpeedY = MaxSpeed;
    }
    public void left() {
        SpeedX = -MaxSpeed;
    }
    public void right() {
        SpeedX = MaxSpeed;
    }
    public void down(){
        SpeedY = -MaxSpeed;
    }
    public void stop() {
        SpeedX = 0d;
        SpeedY = 0d;
    }
}
