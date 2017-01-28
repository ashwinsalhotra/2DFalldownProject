package FalldownPackage;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Shows name dialog
 */
public class NameDialog extends JPanel {

    private JLabel nameLabel;
    private JTextField nameField;
    private JButton nameButton;
    public static String name;

    /**
     * Initialise components
     */
    public NameDialog() {
        initComponents();
    }

    private void initComponents() {
        setPreferredSize(new java.awt.Dimension(200, 55));

        nameLabel = new JLabel();
        nameLabel.setText("Please enter your name: ");
        this.add(nameLabel, BorderLayout.NORTH);

        nameField = new JTextField(10);
        this.add(nameField, BorderLayout.AFTER_LINE_ENDS);

        nameButton = new JButton();
        this.add(nameButton, BorderLayout.AFTER_LINE_ENDS);
        nameButton.setText("OK");
        nameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameButtonActionPerformed(evt);
            }
        });
        nameButton.setFocusable(false);

    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Name Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        NameDialog newContentPane = new NameDialog();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    private void nameButtonActionPerformed(java.awt.event.ActionEvent evt) {
        name = nameField.getText();
        System.out.println(name);
        setVisible(false);
    }

    public String getName() {
        return name;
    }

    public String setName() {
        name = name;
        return name;
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
