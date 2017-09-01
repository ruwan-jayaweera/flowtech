/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.salesinventory.ui.newpackage;

import com.abc.salesinventory.model.newpackage.Customer;
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
public class SearchCustomer extends javax.swing.JInternalFrame {

    MasterService masterService = new MasterServiceImpl();
    private JDesktopPane jDesktopPane;

    /**
     * Creates new form UserSearch
     */
    public SearchCustomer() {
        initComponents();
        txtCustomerName.requestFocus();
        search();
    }
//Query for search customer details
    private static String QUERY_BASED_ON_NAME = "from Customer a where a.name like '";
    private static String QUERY_BASED_ON_MOBILE = "from Customer a where a.mobile like '";
    private static String QUERY_ALL = "from Customer";

//    private void saveUsers() {
//
//        DefaultTableModel model = (DefaultTableModel) resultTable.getModel();
//        Vector dataModel = model.getDataVector();
//        try {
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            session.beginTransaction();
//            Iterator it = dataModel.iterator();
//            while (it.hasNext()) {
//                Vector vector = (Vector) it.next();
//                User user = new User();
//                user.setId(UUID.randomUUID().toString());
//                user.setUserid((String) vector.get(0));
//                user.setFirstName((String) vector.get(1));
//                user.setLastName((String) vector.get(2));
//                user.setEmail((String) vector.get(3));
//                session.save(user);
//            }
//            session.getTransaction().commit();
//        } catch (HibernateException he) {
//            he.printStackTrace();
//        }
//    }
    //
    private void searchCustomer(String hql) {
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
//Display customer details in the table

    private void displayResult(List resultList) {

        Vector<String> tableHeaders = new Vector<String>();
        tableHeaders.add("Customer ID");
        tableHeaders.add("Name");
        tableHeaders.add("Address");
        tableHeaders.add("Mobile");
        tableHeaders.add("Home");
        tableHeaders.add("Office");
        tableHeaders.add("Email");

        Vector tableData = new Vector();
        for (Object o : resultList) {

            Customer customer = (Customer) o;
            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(customer.getId());
            oneRow.add(customer.getName());
            oneRow.add(customer.getAddress());
            oneRow.add(customer.getMobile());
            oneRow.add(customer.getHome());
            oneRow.add(customer.getOffice());
            oneRow.add(customer.getEmail());
            tableData.add(oneRow);
        }
        resultTable.setModel(new DefaultTableModel(tableData, tableHeaders));

    }
//Search customer details

    public void search() {
        //Search by customer name
        if (!txtCustomerName.getText().trim().equals("") && txtMobileNumber.getText().trim().equals("")) {
            searchCustomer(QUERY_BASED_ON_NAME + txtCustomerName.getText() + "%'");
        } //Search by mobile number
        else if (txtCustomerName.getText().trim().equals("") && !txtMobileNumber.getText().trim().equals("")) {
            searchCustomer(QUERY_BASED_ON_MOBILE + txtMobileNumber.getText() + "%'");
        } //search by customer name and mobile number
        else if (!txtCustomerName.getText().trim().equals("") && !txtMobileNumber.getText().trim().equals("")) {
            searchCustomer("from Customer a where a.name like '" + txtCustomerName.getText().trim() + "%' and a.mobile like '" + txtMobileNumber.getText().trim() + "%'");
        } //get all data
        else if (txtCustomerName.getText().trim().equals("") && txtMobileNumber.getText().trim().equals("")) {
            searchCustomer(QUERY_ALL);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCustomerName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMobileNumber = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        btnEditCustomer = new javax.swing.JButton();
        btnDeleteCustomer = new javax.swing.JButton();

        setClosable(true);
        setTitle("Search Customer");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Customer Search");

        jLabel2.setText("Customer Name");

        txtCustomerName.setColumns(10);

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
                "Customer ID", " Name", "Address", "Mobile", "Home", "Office", "Email"
            }
        ));
        jScrollPane1.setViewportView(resultTable);

        btnEditCustomer.setText("Edit");
        btnEditCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditCustomerActionPerformed(evt);
            }
        });

        btnDeleteCustomer.setText("Delete");
        btnDeleteCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(243, 243, 243))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel3)
                                .addGap(28, 28, 28)
                                .addComponent(txtMobileNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(btnEditCustomer)
                        .addGap(115, 115, 115)
                        .addComponent(btnDeleteCustomer)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtMobileNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditCustomer)
                    .addComponent(btnDeleteCustomer))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Search customer details
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        search();
    }

    private void runQueryBasedOnLastName() {
    }//GEN-LAST:event_btnSearchActionPerformed

    //Delete selected customer
    private void btnDeleteCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCustomerActionPerformed
        int row = resultTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) resultTable.getModel();
        Vector dataModel = model.getDataVector();
        Customer customer = new Customer();
        Iterator it = dataModel.iterator();
        int x = 0;
        while (it.hasNext()) {
            Vector vector = (Vector) it.next();
            if (x == row) {
                customer.setId((String) vector.get(0));
                break;
            }
            x++;
        }
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Would You Like to Delete this selected Customer?", "Warning", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            masterService.removeCustomer(customer);
            search();
            JOptionPane.showMessageDialog(null, "Selected Customer ID is Deleted !", "Delete Customer Details", 2);
        }
    }//GEN-LAST:event_btnDeleteCustomerActionPerformed

    //edit customer
    private void btnEditCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditCustomerActionPerformed

        int row = resultTable.getSelectedRow();
        if (row == -1) {
            return;
        }
        DefaultTableModel model = (DefaultTableModel) resultTable.getModel();
        Vector dataModel = model.getDataVector();
        Customer customer = new Customer();
        Iterator it = dataModel.iterator();
        int x = 0;
        while (it.hasNext()) {
            Vector vector = (Vector) it.next();
            if (x == row) {
                customer.setId((String) vector.get(0));
                customer.setName((String) vector.get(1));
                customer.setAddress((String) vector.get(2));
                customer.setMobile((String) vector.get(3));
                customer.setHome((String) vector.get(4));
                customer.setOffice((String) vector.get(5));
                customer.setEmail((String) vector.get(6));
                break;
            }
            x++;
        }

        getjDesktopPane().add(new EditCustomer(customer)).setVisible(true);

    }//GEN-LAST:event_btnEditCustomerActionPerformed

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
            java.util.logging.Logger.getLogger(SearchCustomer.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchCustomer.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchCustomer.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchCustomer.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MDISym sym = new MDISym();
                SearchCustomer sc = new SearchCustomer();
                sc.setjDesktopPane(sym.getjDesktopPane1());
                sym.getjDesktopPane1().add(sc).setVisible(true);
                sym.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteCustomer;
    private javax.swing.JButton btnEditCustomer;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable resultTable;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtMobileNumber;
    // End of variables declaration//GEN-END:variables

    public JDesktopPane getjDesktopPane() {
        return jDesktopPane;
    }

    public void setjDesktopPane(JDesktopPane jDesktopPane) {
        this.jDesktopPane = jDesktopPane;
    }
}
