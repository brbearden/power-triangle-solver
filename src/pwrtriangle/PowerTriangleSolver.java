package pwrtriangle;

import javax.swing.*;

/**
 * @brief Entry point class
 *
 * This class is the entry to the Power Triangle Solver application.
 */
public class PowerTriangleSolver {

    /**
     * @brief Create and show the main GUI frame.
     */
    private static void createAndShowGui() {

        JFrame frame = new JFrame("Power Triangle Solver");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Panel panel = new Panel();
        frame.getContentPane().add(panel);

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * @brief Application entry point.
     * @param args the command line arguments (unused)
     */
    public static void main(String[] args) {

        // Schedule job for the event dispatching thread
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        createAndShowGui();
                    }
                }
        );
    }

}
