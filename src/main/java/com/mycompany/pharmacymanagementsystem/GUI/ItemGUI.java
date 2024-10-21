/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.pharmacymanagementsystem.GUI;
import com.mycompany.pharmacymanagementsystem.Model.*;
import com.mycompany.pharmacymanagementsystem.DAO.*;
import jaco.mp3.player.MP3Player;
import java.time.format.DateTimeParseException;
import javax.swing.*;
import java.awt.*;
import java.util.List; // Importing java.util.List
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.sound.sampled.*;
import java.io.*;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author maryamwaleed
 */
public class ItemGUI extends javax.swing.JFrame {
    /**
     * Creates new form ItemGUI
     */
    public ItemGUI() {
        initComponents();
        populateComboBox();
        getContentPane().setBackground(Color.decode("#FFFFFF")); 

    }
    public static final String addAudio = "Add.mp3";
    MP3Player mp3Add = new MP3Player(new File(addAudio));
    
    public static final String updateAudio = "Update.mp3";
    MP3Player mp3Update = new MP3Player(new File(updateAudio));
    
    public static final String deleteAudio = "Delete.mp3";
    MP3Player mp3Delete = new MP3Player(new File(deleteAudio));
    
    public static final String failedAudio = "Failed.mp3";
    MP3Player mp3Failed= new MP3Player(new File(failedAudio));
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLblTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jCbSupplier = new javax.swing.JComboBox<>();
        jTfQty = new javax.swing.JTextField();
        jTfPrice = new javax.swing.JTextField();
        jTfID = new javax.swing.JTextField();
        jTfName = new javax.swing.JTextField();
        jTfDesc = new javax.swing.JTextField();
        jTfDate = new javax.swing.JTextField();
        jRbMed = new javax.swing.JRadioButton();
        jRbDevice = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jBtnAdd = new javax.swing.JButton();
        jBtnUpdate = new javax.swing.JButton();
        jBtnShowAll = new javax.swing.JButton();
        jBtnDelete = new javax.swing.JButton();
        jLblStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(930, 690));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(213, 217, 224));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLblTitle.setFont(new java.awt.Font("Big Caslon", 0, 18)); // NOI18N
        jLblTitle.setText("Item Form");

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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, -1, -1));

        jPanel2.setBackground(new java.awt.Color(213, 217, 224));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel1.setText("Item ID:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel2.setText("Item Name:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel3.setText("Category:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel4.setText("Description:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel5.setText("Expiry Date:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel6.setText("Quantity In Stock");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel7.setText("Price");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel8.setText("Supplier");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, -1, -1));

        jCbSupplier.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jCbSupplier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(jCbSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, 201, -1));

        jTfQty.setText(" ");
        jPanel2.add(jTfQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 155, -1));

        jTfPrice.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jTfPrice.setText(" ");
        jPanel2.add(jTfPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 201, -1));

        jTfID.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jTfID.setText(" ");
        jPanel2.add(jTfID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 272, -1));

        jTfName.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jTfName.setText(" ");
        jPanel2.add(jTfName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 270, -1));

        jTfDesc.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jTfDesc.setText(" ");
        jPanel2.add(jTfDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 272, -1));

        jTfDate.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jTfDate.setText("YYYY-MM-DD");
        jPanel2.add(jTfDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 189, -1));

        jRbMed.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jRbMed.setText("Medcine");
        jPanel2.add(jRbMed, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, -1, -1));

        jRbDevice.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jRbDevice.setText("Device");
        jPanel2.add(jRbDevice, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 760, 220));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 560, 380));

        jPanel3.setBackground(new java.awt.Color(213, 217, 224));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jBtnAdd.setBackground(new java.awt.Color(166, 201, 218));
        jBtnAdd.setFont(new java.awt.Font("Didot", 1, 14)); // NOI18N
        jBtnAdd.setText("Add");
        jBtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAddActionPerformed(evt);
            }
        });

        jBtnUpdate.setBackground(new java.awt.Color(166, 201, 218));
        jBtnUpdate.setFont(new java.awt.Font("Didot", 1, 14)); // NOI18N
        jBtnUpdate.setText("Update");
        jBtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnUpdateActionPerformed(evt);
            }
        });

        jBtnShowAll.setBackground(new java.awt.Color(166, 201, 218));
        jBtnShowAll.setFont(new java.awt.Font("Didot", 1, 14)); // NOI18N
        jBtnShowAll.setText("Show All");
        jBtnShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnShowAllActionPerformed(evt);
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

        jLblStatus.setBackground(new java.awt.Color(213, 217, 224));
        jLblStatus.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLblStatus.setText("Status: ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBtnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnShowAll, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jBtnAdd)
                .addGap(18, 18, 18)
                .addComponent(jBtnUpdate)
                .addGap(18, 18, 18)
                .addComponent(jBtnDelete)
                .addGap(18, 18, 18)
                .addComponent(jBtnShowAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 190, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAddActionPerformed
    int qty = 0; 
    double price = 0;

    String id = jTfID.getText().trim();
    String name = jTfName.getText().trim();
    String desc = jTfDesc.getText().trim();
    String expirydate = jTfDate.getText().trim();
    String qtyText = jTfQty.getText().trim();
    String priceText = jTfPrice.getText().trim();
    String selecetedSup = (String) jCbSupplier.getSelectedItem();

    char category; 
    if (jRbMed.isSelected()) {
        category = 'M'; // Assigning char 'M'
    } else if (jRbDevice.isSelected()) {
        category = 'D'; // Assigning char 'D'
    } else {
        jLblStatus.setText("Please select a category!");
        return;
    }
    
    if (id.isEmpty() || name.isEmpty() || qtyText.isEmpty() || priceText.isEmpty() || desc.isEmpty()) {
        jLblStatus.setText("Please enter data!");
        return;
    }
 
    try {
        qty = Integer.parseInt(qtyText);
    } catch (NumberFormatException e) {
        jLblStatus.setText("Error while converting to integer. Make sure to enter numbers");
        return;
    }    
    
    try {
        price = Double.parseDouble(priceText);
    } catch (NumberFormatException e) {
        jLblStatus.setText("Error while converting to double. Make sure to enter numbers");
        return;
    }  

    if (selecetedSup.equals("--Select Supplier--")) {
        jLblStatus.setText("Please select a Supplier!");
        return;
    }
    
    // Parse the expiry date string to a LocalDate object
    LocalDate expiryDate = null;
   if (!expirydate.isEmpty()) {
    try {
        expiryDate = LocalDate.parse(expirydate);
    } catch (DateTimeParseException e) {
        jLblStatus.setText("Please enter a valid date in the format YYYY-MM-DD");
        return;
    }
}
    ItemDAO itemDAO = new ItemDAO();
    try {
        if (itemDAO.findItemById(id) != null) {
            jLblStatus.setText("ID exists in the DB!");
            return;
        }
        
        SupplierDAO supplierDAO = new SupplierDAO();
        Supplier s1 = supplierDAO.findSupplierById(selecetedSup);
        
        // Add a new item
        int insertStatus = itemDAO.addNewItem(id, name,category, desc,expiryDate, qty, price, selecetedSup);

        // Provide feedback to the user based on the insertion status
        if (insertStatus > 0) {
            // Display a success message
            jLblStatus.setText("Item " + id + " has been successfully added!");
            mp3Add.play();
            
        

        } else {
            // Display a message indicating that the insertion failed
            jLblStatus.setText("Failed to add item " + id);
            mp3Failed.play();
        
        }
    } catch (SQLException e) {
        jLblStatus.setText(e.getMessage());
    }
     
    }//GEN-LAST:event_jBtnAddActionPerformed

    private void jBtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnUpdateActionPerformed
     int qty = 0; 
    double price = 0;

    String id = jTfID.getText().trim();
    String name = jTfName.getText().trim();
    String desc = jTfDesc.getText().trim();
    String expirydate = jTfDate.getText().trim();
    String qtyText = jTfQty.getText().trim();
    String priceText = jTfPrice.getText().trim();
    String selecetedSup = (String) jCbSupplier.getSelectedItem();

    char category; 
    if (jRbMed.isSelected()) {
        category = 'M'; // Assigning char 'M'
    } else if (jRbDevice.isSelected()) {
        category = 'D'; // Assigning char 'D'
    } else {
        jLblStatus.setText("Please select a category!");
        return;
    }
    
    if (id.isEmpty() || name.isEmpty() || qtyText.isEmpty() || priceText.isEmpty() || desc.isEmpty()) {
        jLblStatus.setText("Please enter data!");
        return;
    }
 
    try {
        qty = Integer.parseInt(qtyText);
    } catch (NumberFormatException e) {
        jLblStatus.setText("Error while converting to integer. Make sure to enter numbers");
        return;
    }    
    
    try {
        price = Double.parseDouble(priceText);
    } catch (NumberFormatException e) {
        jLblStatus.setText("Error while converting to double. Make sure to enter numbers");
        return;
    }  

    if (selecetedSup.equals("--Select Supplier--")) {
        jLblStatus.setText("Please select a Supplier!");
        return;
    }
    
    // Parse the expiry date string to a LocalDate object
    LocalDate expiryDate = null;
    try {
        expiryDate = LocalDate.parse(expirydate);
    } catch (DateTimeParseException e) {
        jLblStatus.setText("Please enter a date in the format YYYY-MM-DD");
        return;
    }
    
    ItemDAO itemDAO = new ItemDAO();
    try {
        if (itemDAO.findItemById(id) == null) {
            jLblStatus.setText("ID doesnt exists IN the DB!");
            return;
        }
        
        SupplierDAO supplierDAO = new SupplierDAO();
        Supplier s1 = supplierDAO.findSupplierById(selecetedSup);
        
        // update existing new item
        int updateStatus = itemDAO.updateItem(id, name,category, desc,expiryDate, qty, price, selecetedSup);

        // Provide feedback to the user based on the insertion status
        if (updateStatus > 0) {
           // playSound("update.wav");
            // Display a success message
            jLblStatus.setText("Item " + id + " has been successfully updated!");
            mp3Update.play();
        } else {
            // Display a message indicating that the insertion failed
            jLblStatus.setText("Failed to updated item " + id);
            mp3Failed.play();

        }
    } catch (SQLException e) {
        jLblStatus.setText(e.getMessage());
    }
    }//GEN-LAST:event_jBtnUpdateActionPerformed

    private void jBtnShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnShowAllActionPerformed
        // TODO add your handling code here:
        loadAllItems();
    }//GEN-LAST:event_jBtnShowAllActionPerformed

    private void jBtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDeleteActionPerformed
        // TODO add your handling code here:
                // TODO add your handling code here:
        String ID=jTfID.getText().trim();
        //check if course code is empty
        if(ID.isEmpty()){
            jLblStatus.setText("Enter the code of the Item to delete!");
            return;
        }
        ItemDAO itemDAO=new ItemDAO();
        int status=-1;
        try{
            if(itemDAO.findItemById(ID)==null){
                jLblStatus.setText("Item does not exist in the DB!");
                return;

            }
            status=itemDAO.deleteItem(ID);
        }
        catch (SQLException e){
            jLblStatus.setText(e.getMessage());
        }
        if(status==1){
            mp3Delete.play();
            jLblStatus.setText("Item "+ID+" is deleted!");
         
        }
        else{
            mp3Failed.play();
            jLblStatus.setText("Error while deleting "+ID+" Item!");
        }
        
    }//GEN-LAST:event_jBtnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(ItemGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ItemGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ItemGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ItemGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ItemGUI().setVisible(true);
            }
        });
    }

private final void populateComboBox() {
    try {
        SupplierDAO supplierDAO = new SupplierDAO();
        List<Supplier> sList = supplierDAO.getAllSupplier(); 
        String[] defaultOption = new String[]{"--Select Supplier--"};
        jCbSupplier.setModel(new DefaultComboBoxModel<>(defaultOption));
        for (Supplier s : sList) {
            jCbSupplier.addItem(s.getId());
        }
    } catch (SQLException sqlex) {
        jLblStatus.setText(sqlex.getMessage());
    }
}
      private final void loadAllItems() {
    Vector colNameV = new Vector();
    colNameV.add("Item ID");
    colNameV.add("Item Name");
    colNameV.add("Category");
    colNameV.add("Description");
    colNameV.add("Expiry Date");
    colNameV.add("Quantity In Stock");
    colNameV.add("Price");
    colNameV.add("Supplier");

    //Step 2: set the rows of jtable
    ItemDAO itemDAO = new ItemDAO();
    List<Item> iList = null; // Initialize a list to store item data
    try {
        iList = itemDAO.getAllItems(); // Call get all from the DAO
    } catch (SQLException e) {
        jLblStatus.setText("Database Error! " + e.getMessage());
    }

    Vector rowDataVector = new Vector(); // Initialize a vector to store row data
    // Iterate through each item in the iList
    for (Item i : iList) {
        Vector<Object> cellVector = new Vector<>(); // Initialize cellVector for each item
        cellVector.add(i.getID());
        cellVector.add(i.getName());
        cellVector.add(i.getCategory());
        cellVector.add(i.getDescription());
        cellVector.add(i.getExpiryDate());
        cellVector.add(i.getQtyInStock());
        cellVector.add(i.getPrice());
        cellVector.add(i.getSupplier().getId());
         rowDataVector.add(cellVector);  //creates the vector row, by adding each cell in the row
        }      
        
        //initlize the JTable instance using the row data and column data vectors
        jTable1=new JTable(rowDataVector,colNameV);
        jScrollPane1.setViewportView(jTable1);
}

// Open an input stream  to the audio file.
 public static void playSound(String filename) {
        try {
            // Open an audio input stream.
            URL url = ItemGUI.class.getClassLoader().getResource(filename);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            // Get a sound clip resource.
            Clip clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
   public static void play(String filePath) throws Exception {
    // Get the audio input stream
    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath));
    
    // Get a clip based on the audio format
    Clip clip = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, audioInputStream.getFormat()));
    clip.open(audioInputStream);
    
    // Play the audio
    clip.start();
    
    // Close resources after playback (optional for short clips)
    clip.close();
  }



 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAdd;
    private javax.swing.JButton jBtnDelete;
    private javax.swing.JButton jBtnShowAll;
    private javax.swing.JButton jBtnUpdate;
    private javax.swing.JComboBox<String> jCbSupplier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLblStatus;
    private javax.swing.JLabel jLblTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRbDevice;
    private javax.swing.JRadioButton jRbMed;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTfDate;
    private javax.swing.JTextField jTfDesc;
    private javax.swing.JTextField jTfID;
    private javax.swing.JTextField jTfName;
    private javax.swing.JTextField jTfPrice;
    private javax.swing.JTextField jTfQty;
    // End of variables declaration//GEN-END:variables
}
