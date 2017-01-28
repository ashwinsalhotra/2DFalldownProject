package FalldownPackage;

import city.cs.engine.*;
import java.awt.Color;
import org.jbox2d.common.Vec2;

/**
 * Level 1 of the game
 */
public class Level1 extends GameLevel {

    private final static int NUM_POINTS = 10;  //number of points needed to be collected to advance to the next level
    private static final Color platformColour = new Color(55, 155, 255);

    /**
     * Populate the world.
     *
     * @param game
     */
    @Override
    public void populate(Falldown game) {
        super.populate(game);

        { // Ground
            Shape shape = new BoxShape(18f, 0.6f);
            Body ground = new StaticBody(this, shape);
            ground.setPosition(new Vec2(0, 0));
            ground.setFillColor(platformColour);
            // walls
            Shape leftWallShape = new BoxShape(0.2f, 15f, new Vec2(-16f, 15f));
            Fixture leftWall = new SolidFixture(ground, leftWallShape);
            Shape rightWallShape = new BoxShape(0.2f, 15f, new Vec2(16f, 15f));
            Fixture rightWall = new SolidFixture(ground, rightWallShape);
        }
        { // make a platform loop on left
            Shape shape = new BoxShape(8f, 0.2f);
            Body platform;
            for (int i = 1; i < 5; i++) {
                platform = new StaticBody(this, shape);
                platform.setPosition(new Vec2(-9.5f, i * 5f));
                platform.setFillColor(platformColour);

            } // make a platform loop on right
            for (int i = 1; i < 5; i++) {
                platform = new StaticBody(this, shape);
                platform.setPosition(new Vec2(13.5f, i * 6f));
                platform.setFillColor(platformColour);
            }
        }

        { // Make enemies
            for (int i = 1; i < 11; i++) {
                Body goomba = new Enemy(this) {
                };
                goomba.setPosition(new Vec2(i * 3f - 16.5f, 1));
            }
        }

        {  //to make points on the different platforms
            for (int i = 0; i < 4; i++) {
                Body point1 = new Point(this) {
                };
                point1.setPosition(new Vec2(i * 2 + 9f, 10f));
                point1.addCollisionListener(new BallCollision(getActor()));
            }
            {
                for (int i = 0; i < 3; i++) {
                    Body point2 = new Point(this) {
                    };
                    point2.setPosition(new Vec2(i * 3 + 9f, 15f));
                    point2.addCollisionListener(new BallCollision(getActor()));
                }
            }
            {
                for (int i = 0; i < 2; i++) {
                    Body point3 = new Point(this) {
                    };
                    point3.setPosition(new Vec2(i * 4 + 10f, 20f));
                    point3.addCollisionListener(new BallCollision(getActor()));
                }
            }
            {
                for (int i = 0; i < 1; i++) {
                    Body point4 = new Point(this) {
                    };
                    point4.setPosition(new Vec2(i * 4 - 10f, 25f));
                    point4.addCollisionListener(new BallCollision(getActor()));
                }
            }
        }
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(-9.5f, 7.5f);

    }

    @Override
    public Vec2 portalPosition() {
        return new Vec2(11f, 25.5f);
    }

    @Override
    public boolean isCompleted() {
        return getActor().getPoints() == NUM_POINTS;
    }
}
