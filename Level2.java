package FalldownPackage;

import city.cs.engine.*;
import java.awt.Color;
import org.jbox2d.common.Vec2;

/**
 * Level 2 of the game
 */
public class Level2 extends GameLevel {

    private final static int NUM_POINTS = 20;
    private static final Color platformColour = new Color(155, 55, 55);

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
            for (int i = 1; i < 4; i++) {
                platform = new StaticBody(this, shape);
                platform.setPosition(new Vec2(i * -1f - 9.5f, i * 5f + 0.5f));
                platform.setFillColor(platformColour);
                platform.setAngleDegrees(20);
            } // make a platform loop on right
            for (int i = 1; i < 5; i++) {
                platform = new StaticBody(this, shape);
                platform.setPosition(new Vec2(i * +1f + 13.5f, i * 4f + 5));
                platform.setFillColor(platformColour);
            }
        }

        { // Make FakePoints
            for (int i = 1; i < 4; i++) {
                Body fakePoints = new FakePoints(this) {
                };
                fakePoints.setPosition(new Vec2(i * 2 - 15, 15));
            }
        }

        { // Make enemies
            for (int i = 1; i < 11; i++) {
                Body goomba = new Enemy(this) {
                };
                goomba.setPosition(new Vec2(i * 3f - 16.5f, 1));
            }
        }

        {
            { //ball pickup points 
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
        return new Vec2(-9.5f, 8.5f);
    }

    @Override
    public Vec2 portalPosition() {
        return new Vec2(10f, 25.5f);
    }

    @Override
    public boolean isCompleted() {
        return getActor().getPoints() == NUM_POINTS;
    }
}
