package FalldownPackage;

import city.cs.engine.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import org.jbox2d.common.Vec2;

/**
 * Key handler to control a body.
 */
public class Controller extends KeyAdapter {

    private static final float ROLLING_SPEED = 17.5f;
    private static final float JUMPING_SPEED = 10f;

    private DynamicBody body;
    private World world;
    private Roller rollLeft;
    private Roller rollRight;
    private Roller currentRoller;

    public Controller(DynamicBody body) {
        this.body = body;
        this.world = body.getWorld();
        this.rollLeft = new Roller(body, -ROLLING_SPEED);
        this.rollRight = new Roller(body, ROLLING_SPEED);

    }

    /**
     * Handle key press events for walking and jumping.
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);

        } else if (code == KeyEvent.VK_UP) { // UP Arrow key = jump
            Vec2 v = body.getLinearVelocity();
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                body.setLinearVelocity(new Vec2(v.x, JUMPING_SPEED));
            }

        }
        if (code == KeyEvent.VK_LEFT) {
            // LEFT ARROW = roll left
            world.addStepListener(rollLeft);
        }
        if (code == KeyEvent.VK_RIGHT) {
            // RIGHT ARROW = roll right
            world.addStepListener(rollRight);
        }
    }

    /**
     * Handle key release events (stop rolling).
     *
     * @param e
     */
    //@Override
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            world.removeStepListener(rollRight);
        } else if (code == KeyEvent.VK_RIGHT) {
            world.removeStepListener(rollLeft);
        }
    }

    public void setBody(DynamicBody body) {
        if (currentRoller != null) {
            world.removeStepListener(currentRoller);
            currentRoller = null;
        }
        this.body = body;
        this.world = body.getWorld();
        rollLeft.setBody(body);
        rollRight.setBody(body);
    }

    /**
     * Set the walker, unless already walking
     */
    private void setRoller(Roller w) {
        if (currentRoller == null) {
            currentRoller = w;
            world.addStepListener(currentRoller);
        }
    }

    /**
     * Clear the walker, if this is the one in effect.
     */
    private void clearRoller(Roller w) {
        if (currentRoller == w) {
            world.removeStepListener(currentRoller);
            currentRoller = null;
        }
    }
}
