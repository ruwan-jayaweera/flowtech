/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.salesinventory.service.newpackage;

import com.abc.salesinventory.model.newpackage.Customer;
import com.abc.salesinventory.model.newpackage.Message;
import com.abc.salesinventory.model.newpackage.Supplier;
import com.abc.salesinventory.model.newpackage.Product;
import com.abc.salesinventory.model.newpackage.Stock;
import com.abc.salesinventory.model.newpackage.Transaction;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;

/**
 *
 * @author Manuri
 */
public interface MasterService {

    public static String PREF_REPORT_LOCATION = "REPORT_LOC";

    public static String PREF_DATABASE_USER = "DB_USER";

    public static String PREF_DATABASE_PASSWORD = "DB_PASSWORD";

    public String getPreference(String key);

    public void setPreference(String key, String value);

    //Customer
    public Customer getCustomer(String customerId);

    public Set<Customer> getAllCustomers();

    public String saveOrUpdateCustomer(Customer customer) throws HibernateException;

    public void removeCustomer(Customer customer);

    //Supplier
    public Supplier getSupplier(String supplierId);

    public List<Supplier> getAllSuppliers();

    public String saveOrUpdateSupplier(Supplier supplier) throws HibernateException;

    public void removeSupplier(Supplier supplier);
    
    public Supplier getSupplierByMobile(String mobile);

    //Product
    public Product getProduct(String productCode);

    public List<Product> getAllProducts();

    public String saveOrUpdateProduct(Product product) throws HibernateException;

    public void removeProduct(Product product);

    //Stock
    public Stock getStock(String stockId);

    public Set<Stock> getAllStocks();

    public String saveOrUpdateStock(Stock stock) throws HibernateException;

    public void removeStock(Stock stock);

//Transaction
    public Transaction getTransactions(String transactionId);

    public Set<Transaction> getAllTransactions();

    public Set<Transaction> getAllPurchaseTransactions();

    public Set<Transaction> getAllSalesTransactions();
    
    public String saveMessage(Message message) throws HibernateException;
}
