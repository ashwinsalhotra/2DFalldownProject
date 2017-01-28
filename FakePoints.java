package FalldownPackage;

import city.cs.engine.BodyImage;
import city.cs.engine.CircleShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;
import city.cs.engine.World;
import java.awt.Color;

/**
 *
 * A class with fake points to confuse the player
 */
public abstract class FakePoints extends DynamicBody {

    private static final Shape shape = new CircleShape(0.35f);

    public FakePoints(World world) {
        super(world, shape);
        setFillColor(Color.yellow);
        setImage(new BodyImage("data/star.jpeg", 0.75f));
    }
}
