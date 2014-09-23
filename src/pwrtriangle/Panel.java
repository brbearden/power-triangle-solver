package pwrtriangle;

import java.awt.event.*;
import javax.swing.*;

/**
 * Main panel for the Power Triangle Solver
 *
 * This panel is the main component in the root frame of the application. The
 * user uses this panel to set the computation mode and enter inputs. The
 * results are then displayed on this panel as well.
 */
public class Panel extends Box implements ActionListener {

    static private final int PQ_MODE = 0;
    static private final int PPF_MODE = 1;
    static private final int QPF_MODE = 2;

    static private final String OP1_CMD = "op1";
    static private final String OP2_CMD = "op2";

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
     *
     * This panel is a
     */
    public Panel() {

        super(BoxLayout.Y_AXIS);

        // Initialize label strings
        MODES = new String[]{"PQ", "PPF", "QPF"};
        OP1_LABELS = new String[]{"Active Power", "Active Power", "Reactive Power"};
        OP1_UNITS = new String[]{"W", "W", "VAr"};
        OP2_LABELS = new String[]{"Reactive Power", "Power Factor", "Power Factor"};
        OP2_UNITS = new String[]{"VAr", "", ""};
        RESULT_LABELS = new String[]{"Power Factor", "Reactive Power", "Active Power"};
        RESULT_UNITS = new String[]{"", "VAr", "W"};

        // Create mode selection
        mode = new JComboBox(MODES);
        mode.setSelectedIndex(PQ_MODE);
        mode.addActionListener(this);

        operandOneLabel = new JLabel("");
        operandOne = new JTextField("0");
        operandOne.setActionCommand(OP1_CMD);
        operandOne.addActionListener(this);
        operandOneUnits = new JLabel("");

        Box opOneRow = Box.createHorizontalBox();
        opOneRow.add(operandOneLabel);
        opOneRow.add(operandOne);
        opOneRow.add(operandOneUnits);

        operandTwoLabel = new JLabel("");
        operandTwo = new JTextField("0");
        operandTwo.setActionCommand(OP2_CMD);
        operandTwo.addActionListener(this);
        operandTwoUnits = new JLabel("");

        Box opTwoRow = Box.createHorizontalBox();
        opTwoRow.add(operandTwoLabel);
        opTwoRow.add(operandTwo);
        opTwoRow.add(operandTwoUnits);

        resultLabel = new JLabel("");
        result = new JLabel("0");
        resultUnits = new JLabel("");

        Box resultRow = Box.createHorizontalBox();
        resultRow.add(resultLabel);
        resultRow.add(result);
        resultRow.add(resultUnits);

        add(mode);
        add(opOneRow);
        add(opTwoRow);
        add(resultRow);

        updatePanelMode(mode.getSelectedIndex());
    }

    /**
     * Handle the actions associated with this panel.
     * @param e Action event data
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals(mode.getActionCommand()))
            updatePanelMode(mode.getSelectedIndex());
        else if(e.getActionCommand().equals(OP1_CMD) || e.getActionCommand().equals(OP2_CMD))
            calculateResult(mode.getSelectedIndex());
    }

    /**
     * Update panel in response to mode changes.
     * @param newMode new computational mode
     */
    private void updatePanelMode(int newMode) {

        // Update mode labels if mode is valid
        if((newMode < MODES.length) && (newMode >= 0)) {

            operandOneLabel.setText(OP1_LABELS[newMode]);
            operandOneUnits.setText(OP1_UNITS[newMode]);

            operandTwoLabel.setText(OP2_LABELS[newMode]);
            operandTwoUnits.setText(OP2_UNITS[newMode]);

            resultLabel.setText(RESULT_LABELS[newMode]);
            resultUnits.setText(RESULT_UNITS[newMode]);
        }

        // Clear contents
        operandOne.setText("0");
        operandTwo.setText("0");
        result.setText("0");
    }

    /**
     * Calculate new computationResult and update the computationResult field.
     * @param mode computational mode
     */
    private void calculateResult(int mode) {

        double computationResult = 0;
        double op1 = Double.parseDouble(operandOne.getText());
        double op2 = Double.parseDouble(operandTwo.getText());

        if(mode == PQ_MODE) {
            computationResult = Solver.solveForPf(op1, op2);
        } else if(mode == PPF_MODE) {
            computationResult = Solver.solveForQ(op1, op2);
        } else if(mode == QPF_MODE) {
            computationResult = Solver.solveForP(op1, op2);
        }

        this.result.setText(String.valueOf(computationResult));
    }

}
