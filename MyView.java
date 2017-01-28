package FalldownPackage;

import city.cs.engine.UserView;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

class MyView extends UserView { //class to make my own view inc. score, view etc..

    Actor ball;
    private int highscore = -1;

    public MyView(GameLevel world, Actor ball, int width, int height) {
        super(world, width, height);
        this.ball = ball;

    }

//Background setter
    @Override
    public void paintBackground(Graphics2D g) {
        //To include a background for all the levels.
        ImageIcon icon;
        icon = new ImageIcon("data/background.jpeg");
        g.drawImage(icon.getImage(), 0, 0, this);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        //Below is to add a signature by me
        Font orig = g.getFont();
        g.setFont(orig.deriveFont(40f)); //type of font
        g.setColor(Color.yellow);
        g.setFont(orig);
        g.drawString("Created by Ashwin Salhotra", 515, 430);
        g.drawString("©CityUniversityGames", 530, 450);
        //Below to add the Points in the view at the top
        g.setColor(Color.red);
        Font font = new Font("Serif", Font.PLAIN, 18); // to add a font
        g.setFont(font);
        g.drawString("Points: " + ball.getPoints(), 45, 30);
    }
}
