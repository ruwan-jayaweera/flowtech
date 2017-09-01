/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abc.salesinventory.ui.newpackage;

import com.abc.salesinventory.model.newpackage.Supplier;
import com.abc.salesinventory.service.newpackage.MasterService;
import com.abc.salesinventory.service.newpackage.MasterServiceImpl;
import com.abc.salesinventory.util.HibernateUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Manuri
 */
public class SearchSupplier extends javax.swing.JInternalFrame {

     MasterService masterService = new MasterServiceImpl();
     private JDesktopPane jDesktopPane;
    /**
     * Creates new form SearchSupplier
     */
    public SearchSupplier() {
        initComponents();
        txtSupplierName.requestFocus();
         search();
    }
private static String QUERY_BASED_ON_NAME = "from Supplier s where s.name like '";
    private static String QUERY_BASED_ON_MOBILE = "from Supplier s where s.mobile like '";
    private static String QUERY_ALL = "from Supplier";
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
     private void searchSupplier(String hql) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery(hql);
            List resultList = q.list();
            displayResult(resultList);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }
     
      private void displayResult(List resultList) {

        Vector<String> tableHeaders = new Vector<String>();
        tableHeaders.add("Supplier ID");
        tableHeaders.add("Name");
        tableHeaders.add("Address");
        tableHeaders.add("Mobile");
        tableHeaders.add("Home");
        tableHeaders.add("Office");
        tableHeaders.add("Email");

        Vector tableData = new Vector();
        for (Object o : resultList) {

            Supplier supplier = (Supplier) o;
            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(supplier.getId());
            oneRow.add(supplier.getName());
            oneRow.add(supplier.getAddress());
            oneRow.add(supplier.getMobile());
            oneRow.add(supplier.getHome());
            oneRow.add(supplier.getOffice());
            oneRow.add(supplier.getEmail());
            tableData.add(oneRow);
        }
        resultTable.setModel(new DefaultTableModel(tableData, tableHeaders));
        

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSupplierName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMobileNumber = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        btnEditSupplier = new javax.swing.JButton();
        btnDeleteSupplier = new javax.swing.JButton();

        setClosable(true);
        setTitle("Search Supplier");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Supplier Search");

        jLabel2.setText("Supplier Name");

        txtSupplierName.setColumns(10);

        jLabel3.setText("Mobile Number");

        txtMobileNumber.setColumns(10);

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Supplier ID", "Name", "Address", "Mobile", "Home", "Office", "Email"
            }
        ));
        jScrollPane1.setViewportView(resultTable);

        btnEditSupplier.setText("Edit");
        btnEditSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditSupplierActionPerformed(evt);
            }
        });

        btnDeleteSupplier.setText("Delete");
        btnDeleteSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSupplierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(243, 243, 243))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel3)
                                .addGap(28, 28, 28)
                                .addComponent(txtMobileNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(btnEditSupplier)
                        .addGap(115, 115, 115)
                        .addComponent(btnDeleteSupplier)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtMobileNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditSupplier)
                    .addComponent(btnDeleteSupplier))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        search();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnDeleteSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSupplierActionPerformed
        int row = resultTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) resultTable.getModel();
        Vector dataModel = model.getDataVector();
        Supplier supplier = new Supplier();
        Iterator it = dataModel.iterator();
        int x = 0;
        while (it.hasNext()) {
            Vector vector = (Vector) it.next();
            if (x == row) {
                supplier.setId((String) vector.get(0));
                break;
            }
            x++;
        }
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Would You Like to Delete this selected Supplier?", "Warning", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            masterService.removeSupplier(supplier);
            search();
            JOptionPane.showMessageDialog(null, "Selected Supplier ID is Deleted !", "Delete Customer Details", 2);
        }
    }//GEN-LAST:event_btnDeleteSupplierActionPerformed

    private void btnEditSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditSupplierActionPerformed
        int row = resultTable.getSelectedRow();
        if(row==-1){
            return;
        }
        DefaultTableModel model = (DefaultTableModel) resultTable.getModel();
        Vector dataModel = model.getDataVector();
        Supplier supplier = new Supplier();
        Iterator it = dataModel.iterator();
        int x = 0;
        while (it.hasNext()) {
            Vector vector = (Vector) it.next();
            if (x == row) {
                supplier.setId((String) vector.get(0));
                supplier.setName((String) vector.get(1));
                supplier.setAddress((String) vector.get(2));
                supplier.setMobile((String) vector.get(3));
                supplier.setHome((String) vector.get(4));
                supplier.setOffice((String) vector.get(5));
                supplier.setEmail((String) vector.get(6));
                break;
            }
            x++;
        }
        EditSupplier es = new EditSupplier(supplier);
        getjDesktopPane().add(es);
        es.setVisible(true);
    }//GEN-LAST:event_btnEditSupplierActionPerformed
 public void search() {
        if (!txtSupplierName.getText().trim().equals("") && txtMobileNumber.getText().trim().equals("")) {
            searchSupplier(QUERY_BASED_ON_NAME + txtSupplierName.getText() + "%'");
        } else if (txtSupplierName.getText().trim().equals("") && !txtMobileNumber.getText().trim().equals("")) {
            searchSupplier(QUERY_BASED_ON_MOBILE + txtMobileNumber.getText() + "%'");
        } else if (!txtSupplierName.getText().trim().equals("") && !txtMobileNumber.getText().trim().equals("")) {
            searchSupplier("from Supplier a where a.name like '" + txtSupplierName.getText().trim() + "%' and a.mobile like '" + txtMobileNumber.getText().trim() + "%'");
        } else if (txtSupplierName.getText().trim().equals("") && txtMobileNumber.getText().trim().equals("")) {
            searchSupplier(QUERY_ALL);
        }
    }
 
     
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
            java.util.logging.Logger.getLogger(SearchSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchSupplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteSupplier;
    private javax.swing.JButton btnEditSupplier;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable resultTable;
    private javax.swing.JTextField txtMobileNumber;
    private javax.swing.JTextField txtSupplierName;
    // End of variables declaration//GEN-END:variables

    public JDesktopPane getjDesktopPane() {
        return jDesktopPane;
    }

    public void setjDesktopPane(JDesktopPane jDesktopPane) {
        this.jDesktopPane = jDesktopPane;
    }
}
