
package FalldownPackage;

import javax.swing.JLabel;

// label class to add controls at the top.

public class Label extends JLabel {

    public Label() {
        setLabelText();
    }

    private void setLabelText() {
        setText("Welcome to Falldown! "
                + "                                                            "
                + "                                                            "
                + "LeftClick for HelpingBall  ←RollLeft  ↑Jump  →RollRight");
    }
}
