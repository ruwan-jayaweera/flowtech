/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.salesinventory.util;

import com.abc.salesinventory.service.newpackage.MasterService;
import com.abc.salesinventory.service.newpackage.MasterServiceImpl;
import com.abc.salesinventory.ui.newpackage.Preferences;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Manuri
 */
public class Database {

    static int option = -1;
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/flowtech";
    static MasterService masterService = new MasterServiceImpl();
    static String user = (String) masterService.getPreference(MasterService.PREF_DATABASE_USER);
    static String password = (String) masterService.getPreference(MasterService.PREF_DATABASE_PASSWORD);

    public static Connection con() throws SQLException {
        Connection con1 = null;
        try {
        Class.forName(driver);
            con1 = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            Preferences preferences = new Preferences();
            preferences.setVisible(true);
            throw ex;
        }

        return con1;
    }

    public ResultSet getdata(String sql) throws Exception {
        try {
            Statement st = Database.con().createStatement();
            ResultSet rset = st.executeQuery(sql);
            return rset;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data NOT found!!", "Error", 1);
            System.out.println(e);
            return null;
        }
    }

    public void putdata(String sql) throws Exception {
        try {
            PreparedStatement ps = Database.con().prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Your data NOT saved successfully! : " + e.getMessage(), "Error", 2);
        }
    }

    public void putdata(List<String> sqlList) throws Exception {
        try {
            Connection con = Database.con();
            Statement stmt = con.createStatement();
            con.setAutoCommit(false);
            for (Iterator<String> it = sqlList.iterator(); it.hasNext();) {
                String SQLstmt = it.next();
                stmt.addBatch(SQLstmt);
            }
            int[] count = stmt.executeBatch();
            con.commit();
            JOptionPane.showMessageDialog(null, "Your request processed successfully!!", "Save - Success", 1);
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Your request NOT processed successfully!!", "Save - Error", 0);
        }
    }
}
