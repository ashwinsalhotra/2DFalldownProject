package FalldownPackage;

import city.cs.engine.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter {

    private WorldView view;
    private Shape ballShape;
    private BoxShape ball;

    public MouseHandler(WorldView view) {
        this.ballShape = new CircleShape(2.15f);
        this.view = view;
    }

    /**
     * Create a new Falldown ball at the current mouse position.
     *
     * @param e event object containing the mouse position
     */
    public void mousePressed(MouseEvent e) {
        DynamicBody ball = new DynamicBody(view.getWorld(), ballShape);
        ball.setPosition(view.viewToWorld(e.getPoint()));
    }
}
