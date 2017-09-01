/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.salesinventory.util;

import com.abc.salesinventory.service.newpackage.MasterService;
import com.abc.salesinventory.service.newpackage.MasterServiceImpl;
import com.abc.salesinventory.ui.newpackage.MainScreen;
import com.abc.salesinventory.ui.newpackage.Preferences;
import com.abc.salesinventory.ui.newpackage.PreferencesFrame;
import java.io.FileInputStream;
import java.util.Properties;
import javax.imageio.spi.ServiceRegistry;
import org.hibernate.HibernateException;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Manuri
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;
    static MasterService masterService = new MasterServiceImpl();
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.

            java.util.Properties properties = new Properties();
            properties.put("hibernate.connection.username", (String) masterService.getPreference(MasterService.PREF_DATABASE_USER));
            properties.put("hibernate.connection.password", (String) masterService.getPreference(MasterService.PREF_DATABASE_PASSWORD));

            Configuration configuration = new Configuration();

            configuration.configure("hibernate.cfg.xml").addProperties(properties);
            
            Database.con();

            sessionFactory = configuration.buildSessionFactory();

        } catch (Exception ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            new PreferencesFrame().setVisible(true);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
