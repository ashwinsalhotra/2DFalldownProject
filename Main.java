package FalldownPackage;

public class Main {

    public static Falldown game;

    /**
     * MAIN METHOD TO RUN THE GAME
     */
    public static void main(String[] args) {

        NameOption nameOption = new NameOption(); //Create a name option for players
        nameOption.setLocation(500, 300); //Set where the GUI is.
        nameOption.setVisible(true);

        try {
            Thread.currentThread().sleep(10050); //Allow users to read splash screen
        } catch (Exception e) {
        }
        new Falldown(); //Creates new game instance */
    }

}
