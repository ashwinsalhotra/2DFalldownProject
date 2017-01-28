package FalldownPackage;

import city.cs.engine.*;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Actor extends DynamicBody {

    private static CircleShape ball = new CircleShape(0.35f);
    private static int points = 0;

    public Actor(World world) {
        super(world, ball);
        SolidFixture f1 = new SolidFixture(this, ball);
        f1.setDensity(200);
        f1.setFriction(200);
        setFillColor(Color.MAGENTA);
        setImage(new BodyImage("data/ball.png", 0.75f));
        setFixedRotation(false);
        //begin level with sound everytime.
        InputStream in;
        try {
            in = new FileInputStream(new File("data/oo.wav"));
            AudioStream audios = new AudioStream(in);
            AudioPlayer.player.start(audios);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public int getPoints() {
        return points;
    }

    public void addPoint() {//for the ball to collect points
        Actor.points++;
        System.out.println("Points = " + points);
        InputStream in;
        try {
            in = new FileInputStream(new File("data/collide.wav"));
            AudioStream audios = new AudioStream(in);
            AudioPlayer.player.start(audios);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void subtractPoint() {//for the ball to subtract points when collided
        Actor.points--;
        System.out.println("Points = " + points);
    }
}
