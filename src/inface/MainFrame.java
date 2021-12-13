
package inface;

import codes.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


public class MainFrame extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public  MainFrame() {
        initComponents();
        conn = DBconnect.connect();
        tableload();
    }

    public void tableload(){
        
        try {
            
            String sql = "SELECT IndexNumber AS Index_Number, name AS Name, age AS Age, grade AS Grade FROM student";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    public void tabledata(){
        
        int r = jTable1.getSelectedRow();
        
        String indexNum = jTable1.getValueAt(r, 0).toString();
        String name = jTable1.getValueAt(r, 1).toString();
        String age = jTable1.getValueAt(r, 2).toString();
        String grade = jTable1.getValueAt(r, 3).toString();
        
        lblId.setText(indexNum);
        txtName.setText(name);
        txtAge.setText(age);
        comboboxGrade.setSelectedItem(grade);
        
        
    }
    
    public void search(){
        
        String scrch = txtSearch.getText();
        
        try {
            String sql = "SELECT * FROM student WHERE name LIKE '%"+scrch+"%' OR indexNumber LIKE '%"+scrch+"%' ";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
            
        }
        
        
    }
    
    public void update(){
        
        String id = lblId.getText();
        String name = txtName.getText();
        String age = txtAge.getText();
        String grade = comboboxGrade.getSelectedItem().toString();
        
        try {
            
            String sql = "UPDATE student SET name = '"+name+"' , age = '"+age+"' , grade = '"+grade+"' WHERE indexNumber = '"+id+"'  ";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Successfully Updated ");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
    
    }
    
    public void clear(){
    
          txtSearch.setText("");
          lblId.setText("ID");
          txtName.setText("");
          txtAge.setText("");
          comboboxGrade.setSelectedIndex(0);
    
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        comboboxGrade = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        jPanel3.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 19, 330, 31));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 390, 70));

        jPanel4.setBackground(new java.awt.Color(102, 255, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Age");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 100, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Grade");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 100, 30));

        txtAge.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jPanel4.add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 210, 30));

        comboboxGrade.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        comboboxGrade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13" }));
        jPanel4.add(comboboxGrade, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 120, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Name");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 100, 30));

        txtName.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jPanel4.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 210, 30));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 390, 230));

        jPanel5.setBackground(new java.awt.Color(0, 255, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnInsert.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });
        jPanel5.add(btnInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 35, 100, 40));

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel5.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 35, 100, 40));

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel5.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 115, 100, 40));

        btnClear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel5.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 115, 100, 40));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setText("Exit");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 175, 100, 40));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 390, 230));

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblId.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblId.setText("ID");
        jPanel6.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 110, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Index Number");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 140, 40));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 390, 70));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 670));

        jTable1.setBackground(new java.awt.Color(153, 153, 255));
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 530, 670));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 670));

        setSize(new java.awt.Dimension(1007, 716));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        String name;
        int age;
        int grade;
        
        name = txtName.getText();
        age = Integer.parseInt(txtAge.getText());
        grade = Integer.parseInt(comboboxGrade.getSelectedItem().toString());
        
        try {
            
            String sql = "INSERT INTO Student (name, age, grade) VALUES ('"+name+"' , '"+age+"' , '"+grade+"')";
            pst = conn.prepareStatement(sql);
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Insert successfully ");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        tableload();
        
        txtName.setText("");
        txtAge.setText("");
        
        
    }//GEN-LAST:event_btnInsertActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        tabledata();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        tabledata();
    }//GEN-LAST:event_jTable1KeyReleased

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        search();
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
       update();
       tableload();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        
        String id = lblId.getText();
        
        if(!id.equals("ID")){
            
            int check = JOptionPane.showConfirmDialog(null, "Do yo want to delete selected data?");
            
            if(check==0){
                try {
                    String sql = "DELETE FROM student WHERE indexNumber = '"+id+"'";
                    pst = conn.prepareStatement(sql);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Deleted");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Operation Failed!");
                }
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Please select one row");
        }
        
        tableload();
        clear();
        
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clear();
        tableload();
    }//GEN-LAST:event_btnClearActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> comboboxGrade;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblId;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
