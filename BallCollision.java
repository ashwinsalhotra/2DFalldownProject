package FalldownPackage;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * BallCollision listener that allows the ball to collect points.
 */
public class BallCollision implements CollisionListener {

    private Actor ball;

    public BallCollision(Actor ball) {
        this.ball = ball;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == ball) {
            ball.addPoint();
            e.getReceivingBody().destroy();
        }
    }
}
