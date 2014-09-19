package pwrtriangle;

import java.awt.event.*;
import javax.swing.*;

/**
 * Main panel for the Power Triangle Solver
 *
 * This panel is the main component in the root frame of the application. This
 * panel contains sub-panels to choose the computational mode and enter
 * parameters and display results.
 */
public class Panel extends Box implements ActionListener {

    static private final String PQ_ACTION = "PQ";
    static private final String PPF_ACTION = "PPF";
    static private final String QPF_ACTION = "QPF";

    /**
     * Default Constructor
     */
    public Panel() {

        super(BoxLayout.Y_AXIS);

        Box topRow = Box.createHorizontalBox();

        topRow.add(buildModePanel(this));
        topRow.setAlignmentX(LEFT_ALIGNMENT);

        add(topRow);
    }

    /**
     * Handle the actions associated with this panel
     * @param e Action event data
     */
    @Override
    public void actionPerformed(ActionEvent e) {
    }

    /**
     * Build a sub-panel to hold the mode selection components
     * @param listener listener to handle actions
     * @return new mode panel
     */
    private Box buildModePanel(ActionListener listener) {

        Box panel = Box.createVerticalBox();

        panel.setBorder(BorderFactory.createTitledBorder("Mode"));

        JRadioButton pqButton = new JRadioButton("P/Q");
        JRadioButton ppfButton = new JRadioButton("P/PF");
        JRadioButton qpfButton = new JRadioButton("Q/PF");

        pqButton.setActionCommand(PQ_ACTION);
        ppfButton.setActionCommand(PPF_ACTION);
        qpfButton.setActionCommand(QPF_ACTION);

        panel.add(pqButton);
        panel.add(ppfButton);
        panel.add(qpfButton);

        pqButton.addActionListener(listener);
        ppfButton.addActionListener(listener);
        qpfButton.addActionListener(listener);

        ButtonGroup group = new ButtonGroup();
        group.add(pqButton);
        group.add(ppfButton);
        group.add(qpfButton);

        pqButton.setSelected(true); // initialize to PQ mode

        return panel;
    }

}
