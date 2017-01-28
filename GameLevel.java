package FalldownPackage;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * A level of the game.
 */
public abstract class GameLevel extends World {

    private Actor ball;

    public Actor getActor() {
        return ball;
    }

    /**
     * Populate the world of this level. Child classes should this method with
     * additional bodies.
     */
    public void populate(Falldown game) {
        ball = new Actor(this);
        ball.setPosition(startPosition());
        Portal portal = new Portal(this);
        portal.setPosition(portalPosition());
        portal.addCollisionListener(new PortalListener(game));
    }

    /**
     * The initial position of the actor.
     */
    public abstract Vec2 startPosition();

    /**
     * The position of the exit door.
     */
    public abstract Vec2 portalPosition();

    /**
     * Is this level complete?
     */
    public abstract boolean isCompleted();
}
