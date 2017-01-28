package FalldownPackage;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

 //Class to make the ball roll at a given speed. 
public class Roller implements StepListener {

    private DynamicBody body;
    private float speed;

    /**
     * Create a roller for the given ball.
     *
     * @param body the body to be made to ball
     * @param speed the speed at which it is to ball
     */
    Roller(DynamicBody body, float speed) {
        this.body = body;
        this.speed = speed;
    }

    /**
     * This method is called before each physics step, and sets the horizontal
     * component of the body velocity to the required speed.
     *
     * @param e description of the step
     */
    @Override
    public void preStep(StepEvent e) {
        Vec2 v = body.getLinearVelocity();
        body.setLinearVelocity(new Vec2(speed, v.y));
    }

    /**
     * This method is called after each physics step. There is nothing to do
     * here.
     *
     * @param e description of the step
     */
    @Override
    public void postStep(StepEvent e) {
    }

    void setBody(DynamicBody body) {
        this.body = body;
    }
}
