package FalldownPackage;

import city.cs.engine.*;
import javax.swing.JLabel;

//Listener for collision with portal.  When the actor collides with a door,
public class PortalListener extends JLabel implements CollisionListener {

    private Falldown game;

    public PortalListener(Falldown game) {
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        Actor ball = game.getActor();
        if (e.getOtherBody() == ball && game.isCurrentLevelCompleted()) {
            setText("dfsfa " + game.isCurrentLevelCompleted());
            System.out.println("Going to next level...");
            game.goNextLevel();
        }
    }
}
