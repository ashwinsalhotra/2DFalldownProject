package FalldownPackage;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Container;

/**
 * @author Ashwin Salhotra
 */
public class Falldown {

    // The World in which the bodies move and interact.
    private GameLevel world;
    private int level;
    private Actor ball;
    private Controller controller;
    //My own personilsed view
    MyView view;

    // To initialise the game
    public Falldown() {

        // make the world
        level = 1;
        world = new Level1();
        world.populate(this);

        //Background view from MyView class.
        view = new MyView(world, (Actor) world.getActor(), 640, 480);
        // uncomment this to draw a 1-metre grid over the view
        //view.setGridResolution(1);
        // add this to the view, so coordinates are relative to the view
        view.addMouseListener(new MouseHandler(view));
        // display the view in a frame
        JFrame frame = new JFrame("Falldown!");
        //Create a interface to display info at the top
        Label Label = new Label();
        frame.add(Label, BorderLayout.NORTH);
        // create a control panel on the left
        Container control = new ControlPanel();
        frame.add(control, BorderLayout.WEST);

        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // get keyboard focus
        frame.requestFocus();
        // enable keyboard keys to controll ball
        controller = new Controller(world.getActor());
        frame.addKeyListener(controller);
        // uncomment this to make a debugging view
        // JFrame debugView = new DebugViewer(world, 640, 480);
        //to track the ball
        world.addStepListener(new Tracker(view, world.getActor()));
        // start!
        world.start();
    }

    /**
     * The actor in the current level.
     */
    public Actor getActor() {
        return world.getActor();
    }

    /**
     * Is the current level of the game finished?
     */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }

    /**
     * Advance to the next level of the game.
     */
    public void goNextLevel() {
        world.setPaused(true);
        level++;
        if (level == 2) {
            // get a new world
            world = new Level2();
            // fill it with bodies
            world.populate(this);
            world.addStepListener(new Tracker(view, world.getActor()));
            // switch the keyboard control to the new actor
            controller.setBody(world.getActor());
            // show the new world in the view
            view.setWorld(world);
            world.start();
        } else if (level == 3) {
            level++;
            world = new Level3();
            world.populate(this);
            world.addStepListener(new Tracker(view, world.getActor()));
            controller.setBody(world.getActor());
            view.setWorld(world);
            world.start();
        } else {
            System.exit(0);
        }
    }

    public void gamePaused() {// pause game
        world.isPaused();
    }

    /**
     * UnPause the game
     */
    public void gameUnPause() {
        ball.getPosition();
    }

    // to run the game. 
    public static void main(String[] args) {
        new Falldown();
    }
}
