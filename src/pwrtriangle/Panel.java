/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pwrtriangle;

/**
 *
 * @author bbearden
 */
public class Panel extends javax.swing.JPanel {

    /**
     * Creates new form Panel
     */
    public Panel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mode = new javax.swing.JComboBox();
        operand1 = new javax.swing.JTextField();
        operand2 = new javax.swing.JTextField();
        result = new javax.swing.JTextField();
        opLabel1 = new javax.swing.JLabel();
        opUnit1 = new javax.swing.JLabel();
        opLabel2 = new javax.swing.JLabel();
        opUnit2 = new javax.swing.JLabel();
        resultLabel = new javax.swing.JLabel();
        resultUnit = new javax.swing.JLabel();

        mode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "P/Q", "P/PF", "Q/PF" }));
        mode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modeActionPerformed(evt);
            }
        });

        operand1.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        operand1.setText("0");
        operand1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operand1ActionPerformed(evt);
            }
        });

        operand2.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        operand2.setText("0");
        operand2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operand2ActionPerformed(evt);
            }
        });

        result.setEditable(false);
        result.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        result.setText("0");

        opLabel1.setText("Active Power");

        opUnit1.setText("W");

        opLabel2.setText("Reactive Power");

        opUnit2.setText("VAr");

        resultLabel.setText("Power Factor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opLabel2)
                    .addComponent(opLabel1)
                    .addComponent(resultLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(result, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(operand1)
                    .addComponent(operand2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opUnit1)
                    .addComponent(opUnit2)
                    .addComponent(resultUnit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opLabel1)
                    .addComponent(opUnit1)
                    .addComponent(operand1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(opLabel2)
                    .addComponent(opUnit2)
                    .addComponent(operand2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resultLabel)
                    .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resultUnit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void modeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modeActionPerformed

        String modeStr = (String)mode.getSelectedItem();

        if(modeStr.equals("P/Q"))
            setModePq();
        else if(modeStr.equals("P/PF"))
            setModePpf();
        else if(modeStr.equals("Q/PF"))
            setModeQpf();

        operand1.setText("0");
        operand2.setText("0");
        result.setText("0");
    }//GEN-LAST:event_modeActionPerformed

    private void operand1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operand1ActionPerformed

        calculateResult();

    }//GEN-LAST:event_operand1ActionPerformed

    private void operand2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operand2ActionPerformed

        calculateResult();

    }//GEN-LAST:event_operand2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox mode;
    private javax.swing.JLabel opLabel1;
    private javax.swing.JLabel opLabel2;
    private javax.swing.JLabel opUnit1;
    private javax.swing.JLabel opUnit2;
    private javax.swing.JTextField operand1;
    private javax.swing.JTextField operand2;
    private javax.swing.JTextField result;
    private javax.swing.JLabel resultLabel;
    private javax.swing.JLabel resultUnit;
    // End of variables declaration//GEN-END:variables

    private void setModePq() {

        opLabel1.setText("Active Power");
        opUnit1.setText("W");

        opLabel2.setText("Reactive Power");
        opUnit2.setText("VAr");

        resultLabel.setText("Power Factor");
        resultUnit.setText("");

    }

    private void setModePpf() {

        opLabel1.setText("Active Power");
        opUnit1.setText("W");

        opLabel2.setText("Power Factor");
        opUnit2.setText("");

        resultLabel.setText("Reactive Power");
        resultUnit.setText("VAr");

    }

    private void setModeQpf() {

        opLabel1.setText("Reactive Power");
        opUnit1.setText("VAr");

        opLabel2.setText("Power Factor");
        opUnit2.setText("");

        resultLabel.setText("Active Power");
        resultUnit.setText("W");

    }

    private void calculateResult() {

        String modeStr = (String)mode.getSelectedItem();
        double resultVal = 0;
        double op1 = Double.parseDouble(operand1.getText());
        double op2 = Double.parseDouble(operand2.getText());

        if(modeStr.equals("P/Q")) {
            resultVal = Solver.solveForPf(op1, op2);
        } else if(modeStr.equals("P/PF")) {
            resultVal = Solver.solveForQ(op1, op2);
        } else if(modeStr.equals("Q/PF")) {
            resultVal = Solver.solveForP(op1, op2);
        }

        String resultStr = String.format("%.3f", resultVal);
        result.setText(resultStr);

    }
}
