package FalldownPackage;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Pan the view to follow a particular body.
 */
public class Tracker implements StepListener {

    private WorldView view;

    private Body body;

    public Tracker(WorldView view, Body body) {
        this.view = view;
        this.body = body;

    }

    public void preStep(StepEvent e) {
    }

    public void postStep(StepEvent e) {
        //to only follow the ball on the Y axis.
        float y = body.getPosition().y;
        float x = view.getCentre().x;
        view.setCentre(new Vec2(x, y));

       //view.setCentre(new Vec2(body.getPosition()));
        //follow the ball
    }

}
