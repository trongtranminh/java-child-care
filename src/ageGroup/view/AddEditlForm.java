package ageGroup.view;

import ageGroup.valuesObject.AgeGroupVO;
import javax.swing.JOptionPane;
import ageGroup.business.AgeGroupManager;

/**
 *
 * @author DThanh
 */
public class AddEditlForm extends javax.swing.JDialog {

    /** Creates new form DetailForm */
    public AddEditlForm(java.awt.Frame parent, boolean modal, String header, AgeGroupVO ageGroupVO, String _connect) {
        super(parent, modal);

        connect = _connect;
        this.ageGroupVO = ageGroupVO;

        ageManager = new AgeGroupManager(connect);

        initComponents();
        this.setTitle(header);
        lblHeader.setText(header);

        if (this.lblHeader.getText().equals("Add new age group")) {
            btnApply.setText("Add");
        } else if (this.lblHeader.getText().equals("Edit age group")) {
            btnApply.setText("Edit");
            txtCharge.setText(ageGroupVO.getCharges().toString());
            txtChildAge.setText(ageGroupVO.getChildAge());
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeader = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblChildAgeGroup = new javax.swing.JLabel();
        txtChildAge = new javax.swing.JTextField();
        lblCharge = new javax.swing.JLabel();
        txtCharge = new javax.swing.JTextField();
        btnApply = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        getContentPane().setLayout(new java.awt.FlowLayout());

        lblHeader.setFont(new java.awt.Font("Tahoma", 0, 18));
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setPreferredSize(new java.awt.Dimension(450, 50));
        getContentPane().add(lblHeader);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Details Age group"));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 100));

        lblChildAgeGroup.setText("Child age group:");
        lblChildAgeGroup.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanel1.add(lblChildAgeGroup);

        txtChildAge.setPreferredSize(new java.awt.Dimension(130, 20));
        jPanel1.add(txtChildAge);

        lblCharge.setText("Charges as per the group:");
        lblCharge.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanel1.add(lblCharge);

        txtCharge.setPreferredSize(new java.awt.Dimension(130, 20));
        jPanel1.add(txtCharge);

        getContentPane().add(jPanel1);

        btnApply.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnApply.setText("Add");
        btnApply.setPreferredSize(new java.awt.Dimension(100, 23));
        btnApply.setSelected(true);
        btnApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyActionPerformed(evt);
            }
        });
        getContentPane().add(btnApply);

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reset.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.setPreferredSize(new java.awt.Dimension(100, 23));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        getContentPane().add(btnReset);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close2.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setPreferredSize(new java.awt.Dimension(100, 23));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-500)/2, (screenSize.height-306)/2, 500, 306);
    }// </editor-fold>//GEN-END:initComponents

    /** 
     * This method is called while user click on button Reset
     */
    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        if (this.lblHeader.getText().equals("Add new age group")) {
            txtCharge.setText("");
            txtChildAge.setText("");
        } else if (this.lblHeader.getText().equals("Edit age group")) {
            txtCharge.setText(ageGroupVO.getCharges().toString());
            txtChildAge.setText(ageGroupVO.getChildAge());
        }
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(this, "Are you exit?", "Exit",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (choice == JOptionPane.YES_OPTION) {
            this.setVisible(false);
        }
}//GEN-LAST:event_btnCancelActionPerformed

    private void btnApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyActionPerformed
        // TODO add your handling code here:
        if (this.lblHeader.getText().equals("Add new age group")) {
            addAgeGroup();
        } else if (this.lblHeader.getText().equals("Edit age group")) {
            editAgeGroup();
        }

    }//GEN-LAST:event_btnApplyActionPerformed

    private void editAgeGroup() {
        boolean flag = true;
        String message = " Enter the following details(s) correctly: \n";

        if (txtChildAge.getText().equals("")) {
            flag = false;
            message += "Child age group \n";
        }

        if (txtCharge.getText().equals("")) {
            flag = false;
            message += "Charges as per the group \n";
        } else if (!validateNumber(txtCharge.getText())) {
            flag = false;
            message += "Enter number textfeild Charge as per the group";
        }

        if (flag) {
            int choice = JOptionPane.showConfirmDialog(this, "Are you sure edit " +
                    "age group?", "Are you sure?", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                Double doubleCharge = Double.parseDouble(txtCharge.getText());
                ageGroupVO = new AgeGroupVO(ageGroupVO.getAgeCode(), txtChildAge.getText(), doubleCharge);
                ageManager.updateData(ageGroupVO);
                this.setVisible(false);
            } else {
                return;
            }
        } else {
            JOptionPane.showConfirmDialog(this, message, "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void addAgeGroup() {
        boolean flag = true;
        String message = " Enter the following details(s) correctly: \n";

        if (txtChildAge.getText().equals("")) {
            flag = false;
            message += "Child age group \n";
        }

        if (txtCharge.getText().equals("")) {
            flag = false;
            message += "Charges as per the group \n";
        } else if (!validateNumber(txtCharge.getText())) {
            flag = false;
            message += "Enter number textfeild Charge as per the group";
        }

        if (flag) {
            int choice = JOptionPane.showConfirmDialog(this, "Are you sure add " +
                    "new age group?", "Are you sure?", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                Double doubleCharge = Double.parseDouble(txtCharge.getText());
                ageGroupVO = new AgeGroupVO(txtChildAge.getText(), doubleCharge);
                ageManager.insetData(ageGroupVO);
                this.setVisible(false);
            } else {
                return;
            }
        } else {
            JOptionPane.showConfirmDialog(this, message, "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private static Boolean validateNumber(String strNumber) {
        try {
            Double.parseDouble(strNumber);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApply;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnReset;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCharge;
    private javax.swing.JLabel lblChildAgeGroup;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JTextField txtCharge;
    private javax.swing.JTextField txtChildAge;
    // End of variables declaration//GEN-END:variables
    private AgeGroupVO ageGroupVO;
    private AgeGroupManager ageManager;
    private static String connect;
}