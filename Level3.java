package FalldownPackage;

import city.cs.engine.*;
import java.awt.Color;
import org.jbox2d.common.Vec2;

/**
 * Level 2 of the game
 */
public class Level3 extends GameLevel {

    private final static int NUM_POINTS = 30;
    private static final Color platformColour = new Color(55, 155, 55);

    /**
     * Populate the world.
     *
     * @param game
     */
    @Override
    public void populate(Falldown game) {
        super.populate(game);

        {
            Shape shape = new BoxShape(18f, 0.6f);
            Body ground = new StaticBody(this, shape);
            ground.setPosition(new Vec2(0, 0));
            ground.setFillColor(platformColour);

            Shape leftWallShape = new BoxShape(0.2f, 20f, new Vec2(-16f, 20f));
            Fixture leftWall = new SolidFixture(ground, leftWallShape);
            Shape rightWallShape = new BoxShape(0.2f, 20f, new Vec2(16f, 20f));
            Fixture rightWall = new SolidFixture(ground, rightWallShape);
        }

        {
            Shape shape = new BoxShape(8f, 0.2f);
            Body platform;
            for (int i = 1; i < 2; i++) {
                platform = new StaticBody(this, shape);
                platform.setPosition(new Vec2(-9.5f, 8 + i * 6f));
                platform.setFillColor(platformColour);
            }
            for (int i = 1; i < 5; i++) {
                platform = new StaticBody(this, shape);
                platform.setPosition(new Vec2(13.5f, i * 4f));
                platform.setFillColor(platformColour);
            }
        }
        {
            Shape shape = new BoxShape(4.5f, 0.2f);
            Body platform = new StaticBody(this, shape);
            platform.setPosition(new Vec2(2f, 11f));
            platform.setFillColor(platformColour);
            platform.setAngleDegrees(-37.5f);

        }
        { // Make enemies
            for (int i = 1; i < 11; i++) {
                Body goomba = new Enemy(this) {
                };
                goomba.setPosition(new Vec2(i * 3f - 16.5f, 1));
            }
        }
        {
            {
                for (int i = 0; i < 4; i++) {
                    Body point1 = new Point(this) {
                    };
                    point1.setPosition(new Vec2(i * 2 + 9f, 10f));
                    point1.addCollisionListener(new BallCollision(getActor()));
                }
                for (int i = 0; i < 3; i++) {
                    Body point2 = new Point(this) {
                    };
                    point2.setPosition(new Vec2(i * 3 + 9f, 15f));
                    point2.addCollisionListener(new BallCollision(getActor()));
                }
                for (int i = 0; i < 2; i++) {
                    Body point3 = new Point(this) {
                    };
                    point3.setPosition(new Vec2(i * 4 + 10f, 20f));
                    point3.addCollisionListener(new BallCollision(getActor()));
                }
                for (int i = 0; i < 1; i++) {
                    Body point4 = new Point(this) {
                    };
                    point4.setPosition(new Vec2(i * 4 - 10f, 25f));
                    point4.addCollisionListener(new BallCollision(getActor()));
                }
            }
        }
    }

    /**
     *
     * @return
     */
    @Override
    public Vec2 startPosition() {
        return new Vec2(-9.5f, 16);
    }

    @Override
    public Vec2 portalPosition() {
        return new Vec2(10f, 35.5f);
    }

    @Override
    public boolean isCompleted() {
        return getActor().getPoints() == NUM_POINTS;
    }
}
