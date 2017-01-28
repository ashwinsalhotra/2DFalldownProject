package FalldownPackage;

import city.cs.engine.*;

// When the actor collides with the portal, it'll go to the next level.
public class Portal extends StaticBody {

    private static final Shape shape = new PolygonShape(
            0.001f, -0.364f, 0.343f, -0.124f, 0.196f, 0.201f, -0.128f, 0.291f,
            -0.364f, 0.079f, -0.288f, -0.159f, 0.001f, -0.364f);

    /**
     * Initialise a new portal.
     *
     * @param world The world.
     */
    public Portal(World world) {
        super(world, new BoxShape(0.5f, 0.4f));
        setImage(new BodyImage("data/portal.jpeg", 2.5f));
    }
}
