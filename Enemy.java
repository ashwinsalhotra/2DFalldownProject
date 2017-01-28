package FalldownPackage;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;
import city.cs.engine.StepListener;
import city.cs.engine.World;

/**
 *
 * Enemy class
 */
public abstract class Enemy extends DynamicBody {

    private double x, y;
    private Falldown game;
    private static final Shape shape = new BoxShape(0.35f, 0.35f);
    private static int points;

    public Enemy(World world) {
        super(world, shape);
        setImage(new BodyImage("data/goomba.png", 0.95f));
    }

    public void subtractPoint() {
        Enemy.points--;
        System.out.println("Points = " + points);
    }
}
