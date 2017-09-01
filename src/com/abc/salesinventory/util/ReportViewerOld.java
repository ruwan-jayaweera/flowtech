/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.salesinventory.util;

import com.abc.salesinventory.service.newpackage.MasterService;
import com.abc.salesinventory.service.newpackage.MasterServiceImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import javax.swing.*;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Manuri
 */
public class ReportViewerOld {

    private static String reportPath = null;
    MasterService masterService = new MasterServiceImpl();

    public ReportViewerOld(String fileName) {
        this(fileName, null);
    }

    public ReportViewerOld(String fileName, HashMap params) {
        if (reportPath == null) {
            String tempPath = (String) masterService.getPreference(MasterService.PREF_REPORT_LOCATION);

            if (tempPath == null || tempPath.equals("")) {
                JOptionPane.showMessageDialog(null, "Error in generating Reports !! Report path needs to be set through preferences", "Error", 0);
                return;
            } else {
                reportPath = tempPath;
            }
        }

        try {
            Connection con = Database.con();

            InputStream stream = new FileInputStream(new File(reportPath + fileName));
            JasperDesign jasperDesign = JRXmlLoader.load(stream);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con);
            JasperViewer.viewReport(jasperPrint, false);
            JRViewer jr = new JRViewer(jasperPrint);

        } catch (JRException jre) {
            jre.printStackTrace();
            System.out.println("ERROR: " + jre.getMessage());
            JOptionPane.showMessageDialog(null, "Error in generating Reports !!" + jre.getMessage(), "Error", 0);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in generating Reports !!" + e.getMessage(), "Error", 0);
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
