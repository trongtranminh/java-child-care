/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddUser.java
 *
 * Created on Jun 30, 2009, 12:40:26 PM
 */
package User;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Nobitawin
 */
public class editUser extends javax.swing.JDialog {

    private String userCode;
    private String name;
    private String account;
    private int isFullControl;
    private String sConn = null;

    /** Creates new form AddUser */
    public editUser(java.awt.Frame parent, boolean modal, String name, String account, int isFullControl, String userCode, String sConn) {
        super(parent, modal);
        initComponents();
        txtName.setText(name);
        if (isFullControl == 1) {
            cbIsFullControl.setSelected(true);
        }
        this.userCode = userCode;
        this.account = account;
        this.name = name;
        this.isFullControl = isFullControl;
        this.sConn = sConn;
    }

    private Boolean checkTextField() {
        if (txtName.getText().trim().equalsIgnoreCase("")) {
            ImageIcon icon = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showConfirmDialog(this, "Name User can't be blank !", "Error", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
            return false;
        }

        return true;
    }

    private void updateEvent(String tableName) {
        int reset;
        if (rdPassword.isSelected()) {
            reset = 1;
        } else {
            reset = 0;
        }

        if (cbIsFullControl.isSelected()) {
            isFullControl = 1;
        } else {
            isFullControl = 0;
        }

        ImageIcon icon = new ImageIcon(getClass().getResource("/images/quest.png"));
        int choice = JOptionPane.showConfirmDialog(this, "Are you sure?", "Edit User", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
        if (choice == JOptionPane.YES_OPTION) {
            try {
                new BusinessUser(tableName, sConn).updateUser(tableName, txtName.getText().trim(), account, isFullControl, userCode, reset);
                if(reset==1){
                    JOptionPane.showMessageDialog(this, "New Password: " + account);
                }
            } catch (SQLException ex) {
                Logger.getLogger(editUser.class.getName()).log(Level.SEVERE, null, ex);
            }
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

        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        cbIsFullControl = new javax.swing.JCheckBox();
        btnUpdate = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        rdPassword = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit User");
        setResizable(false);

        jLabel1.setText("Name :");

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        cbIsFullControl.setText("IsFullControl");

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reset.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close2.png"))); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        rdPassword.setText("Reset Password");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(37, 37, 37)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1)
                    .add(layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(btnUpdate)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(btnReset)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(btnClose))
                            .add(layout.createSequentialGroup()
                                .add(71, 71, 71)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, txtName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                        .add(rdPassword)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 12, Short.MAX_VALUE)
                                        .add(cbIsFullControl)))))))
                .add(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(txtName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(rdPassword)
                    .add(cbIsFullControl))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnUpdate)
                    .add(btnReset)
                    .add(btnClose))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-379)/2, (screenSize.height-135)/2, 379, 135);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_txtNameActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        txtName.setText("");
        cbIsFullControl.setSelected(false);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if (checkTextField()) {
            updateEvent("tbl_User");
            dispose();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JCheckBox cbIsFullControl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton rdPassword;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}