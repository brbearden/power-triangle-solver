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

    static private final int NUM_MODES = 3;
    static private final int PQ_MODE = 0;
    static private final int PPF_MODE = 1;
    static private final int QPF_MODE = 2;
    
    private final String[] MODES;
    private final String[] OP1_LABELS;
    private final String[] OP1_UNITS;
    private final String[] OP2_LABELS;
    private final String[] OP2_UNITS;
    private final String[] RESULT_LABELS;
    private final String[] RESULT_UNITS;

    
    private JComboBox mode;
    private JTextField operandOne;
    private JTextField operandTwo;
    private JLabel result;
    
    private JLabel operandOneLabel;
    private JLabel operandOneUnits;
    private JLabel operandTwoLabel;
    private JLabel operandTwoUnits;
    private JLabel resultLabel;
    private JLabel resultUnits;

    /**
     * Default Constructor
     */
    public Panel() {

        super(BoxLayout.Y_AXIS);
        
        MODES = new String[]{"PQ", "PPF", "QPF"};
        OP1_LABELS = new String[]{"Active Power", "Active Power", "Reactive Power"};
        OP1_UNITS = new String[]{"W", "W", "VAr"};
        OP2_LABELS = new String[]{"Reactive Power", "Power Factor", "Power Factor"};
        OP2_UNITS = new String[]{"VAr", "", ""};
        RESULT_LABELS = new String[]{"Power Factor", "Reactive Power", "Active Power"};
        RESULT_UNITS = new String[]{"", "VAr", "W"};

        mode = new JComboBox(MODES);
        mode.addActionListener(this);
        mode.setSelectedIndex(PQ_MODE);
        add(mode);
        
        Box opOneRow = Box.createHorizontalBox();
        
        operandOne = new JTextField("0");
        operandOne.addActionListener(this);
        
        opOneRow.add(operandOneLabel);
        opOneRow.add(operandOne);
        opOneRow.add(operandOneUnits);
        add(opOneRow);

        Box opTwoRow = Box.createHorizontalBox();
        
        operandTwo = new JTextField("0");
        operandTwo.addActionListener(this);
        
        opTwoRow.add(operandTwoLabel);
        opTwoRow.add(operandTwo);
        opTwoRow.add(operandTwoUnits);
        add(opTwoRow);
        
        Box resultRow = Box.createHorizontalBox();
        result = new JLabel("0");

    }

    /**
     * Handle the actions associated with this panel
     * @param e Action event data
     */
    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
