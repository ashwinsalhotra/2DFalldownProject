package FalldownPackage;

import city.cs.engine.*;

import java.awt.Color;

public abstract class Point extends DynamicBody {

    private static final Shape shape = new CircleShape(0.35f);

    public Point(World world) {
        super(world, shape);
        setFillColor(Color.yellow);
        setImage(new BodyImage("data/star.jpeg", 0.75f));
    }
}
