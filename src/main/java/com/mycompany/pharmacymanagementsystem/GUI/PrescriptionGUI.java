/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package com.mycompany.pharmacymanagementsystem.GUI;
import com.mycompany.pharmacymanagementsystem.Model.*;
import com.mycompany.pharmacymanagementsystem.DAO.*;
import javax.swing.table.DefaultTableModel;
import com.mycompany.pharmacymanagementsystem.Exeption.ValidateException;



import java.awt.Color;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;

/**
 *
 * @author maryamwaleed
 */
public class PrescriptionGUI extends javax.swing.JFrame {

    /**
     * Creates new form PrescriptionGUI
     */
    public PrescriptionGUI() {
        initComponents();
        getContentPane().setBackground(Color.decode("#FFFFFF")); 

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTfID = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jBtnFIND = new javax.swing.JButton();
        jBtnDelete = new javax.swing.JButton();
        jLblStatus = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(213, 217, 224));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel6.setText("Prescription ID");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, -1, -1));

        jTfID.setText(" ");
        jPanel2.add(jTfID, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 280, -1));

        jPanel3.setBackground(new java.awt.Color(213, 217, 224));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jBtnFIND.setBackground(new java.awt.Color(166, 201, 218));
        jBtnFIND.setFont(new java.awt.Font("Didot", 1, 14)); // NOI18N
        jBtnFIND.setText("Search");
        jBtnFIND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnFINDActionPerformed(evt);
            }
        });

        jBtnDelete.setBackground(new java.awt.Color(166, 201, 218));
        jBtnDelete.setFont(new java.awt.Font("Didot", 1, 14)); // NOI18N
        jBtnDelete.setText("Delete");
        jBtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDeleteActionPerformed(evt);
            }
        });

        jLblStatus.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLblStatus.setText("Status: ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jBtnDelete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnFIND, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jBtnFIND)
                .addGap(18, 18, 18)
                .addComponent(jBtnDelete)
                .addGap(39, 39, 39)
                .addComponent(jLblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(213, 217, 224));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLblTitle.setFont(new java.awt.Font("Big Caslon", 0, 18)); // NOI18N
        jLblTitle.setText("Prescriptions Form");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(158, Short.MAX_VALUE)
                .addComponent(jLblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setBackground(new java.awt.Color(213, 217, 224));
        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(148, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addContainerGap(177, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDeleteActionPerformed

             // TODO add your handling code here:
                // TODO add your handling code here:
        int ID = Integer.parseInt(jTfID.getText().trim());
        //check if course code is empty
          try{
            if (ID <= 0){
                throw new ValidateException("Please enter data!!!");
            }
        } catch(ValidateException e){
            jLblStatus.setText(e.toString());
            return;
            //System.out.println(e.toString());
        }

        PrescriptionDAO prescriptionDAO=new PrescriptionDAO();
        int status=-1;
        try{
            if(prescriptionDAO.findPrescriptionById(ID)==null){
                jLblStatus.setText("Item does not exist in the DB!");
                return;

            }
            status=prescriptionDAO.deletePrescriptionById(ID);
        }
        catch (SQLException e){
            jLblStatus.setText(e.getMessage());
        }
        if(status==1){
            jLblStatus.setText("Prescription "+ID+" is deleted!");
           // loadAllCourses();
        }
        else{
            jLblStatus.setText("Error while deleting "+ID+" Prescription!");
        }
    }//GEN-LAST:event_jBtnDeleteActionPerformed

    private void jBtnFINDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFINDActionPerformed
    // Get the prescription ID entered by the user
       try {
        // Get the prescription ID entered by the user
        int prescriptionID = Integer.parseInt(jTfID.getText().trim());
        
        // Load prescription details into the JTable
        loadPrescriptionDetails(prescriptionID);
    } catch (NumberFormatException e) {
        jLblStatus.setText("Invalid prescription ID. Please enter a valid number.");
    }
    
    }//GEN-LAST:event_jBtnFINDActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrescriptionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrescriptionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrescriptionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrescriptionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrescriptionGUI().setVisible(true);
            }
        });
    }
    private final void loadPrescriptionDetails(int prescriptionID) {
    PrescriptionDAO prescriptionDAO = new PrescriptionDAO();
    try {
        // Retrieve prescription details with associated items
        List<List<Object>> prescriptionItems = prescriptionDAO.findItemsByPrescriptionId(prescriptionID);
        if (!prescriptionItems.isEmpty()) {
            // Create a DefaultTableModel to populate the JTable
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Prescription ID");
            model.addColumn("Item ID");

            // Add rows for each item in the prescription
            for (List<Object> pair : prescriptionItems) {
                model.addRow(pair.toArray());
            }

            // Set the table model
            jTable1.setModel(model);
        } else {
            // Prescription not found
            jLblStatus.setText("Prescription not found!");
            System.err.println("Prescription not found!");
        }
    } catch (SQLException e) {
        // Handle SQL exceptions
        jLblStatus.setText("Database Error! " + e.getMessage());
        System.err.println("Error: " + e.getMessage());
    }
}

   

 


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnDelete;
    private javax.swing.JButton jBtnFIND;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLblStatus;
    private javax.swing.JLabel jLblTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTfID;
    // End of variables declaration//GEN-END:variables
}
