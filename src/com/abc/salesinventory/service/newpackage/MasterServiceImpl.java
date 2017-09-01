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
import com.abc.salesinventory.util.HibernateUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.prefs.Preferences;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Manuri
 */
public class MasterServiceImpl implements MasterService {

    @Override
    public String saveOrUpdateCustomer(Customer customer) throws HibernateException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(customer);
        session.getTransaction().commit();
        session.close();
        return customer.getId();
    }

    @Override
    public String saveMessage(Message message) throws HibernateException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(message);
        session.getTransaction().commit();
        session.close();
        return message.getId();
    }

    @Override
    public void removeCustomer(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(customer);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Customer getCustomer(String customerId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from Customer c where c.id='" + customerId + "' ";
        Query q = session.createQuery(hql);
        List<Customer> resultList = q.list();
        session.getTransaction().commit();
        session.close();
        if (resultList != null && resultList.size() == 1) {
            return resultList.get(0);
        }
        return null;
    }

    @Override
    public Set<Customer> getAllCustomers() {
        Set<Customer> customers = new HashSet<Customer>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from Customer";
        Query q = session.createQuery(hql);
        List<Customer> resultList = q.list();
        session.getTransaction().commit();
        session.close();
        if (resultList != null && resultList.size() > 0) {
            customers.addAll(resultList);
        }
        return customers;
    }

    //SUPPLIER
    @Override
    public String saveOrUpdateSupplier(Supplier supplier) throws HibernateException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(supplier);
        session.getTransaction().commit();
        session.close();
        return supplier.getId();
    }

    @Override
    public void removeSupplier(Supplier supplier) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(supplier);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Supplier getSupplierByMobile(String mobile) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from Supplier s where s.mobile like '%" + mobile.substring(2, mobile.length()) + "' ";
        Query q = session.createQuery(hql);
        List<Supplier> resultList = q.list();
        session.getTransaction().commit();
        session.close();
        if (resultList != null && resultList.size() == 1) {
            return resultList.get(0);
        }
        return null;
    }

    @Override
    public Supplier getSupplier(String supplierId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from Supplier s where s.id='" + supplierId + "' ";
        Query q = session.createQuery(hql);
        List<Supplier> resultList = q.list();
        session.getTransaction().commit();
        session.close();
        if (resultList != null && resultList.size() == 1) {
            return resultList.get(0);
        }
        return null;
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        List<Supplier> suppliers = new ArrayList<Supplier>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from Supplier order by name";
        Query q = session.createQuery(hql);
        List<Supplier> resultList = q.list();
        session.getTransaction().commit();
        session.close();
        if (resultList != null && resultList.size() > 0) {
            suppliers.addAll(resultList);
        }
        return suppliers;
    }

    //Product
    @Override
    public String saveOrUpdateProduct(Product product) throws HibernateException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(product);
        session.getTransaction().commit();
        session.close();
        return product.getProductCode();
    }

    @Override
    public void removeProduct(Product product) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(product);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Product getProduct(String productCode) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from Product p where p.productCode='" + productCode + "' ";
        Query q = session.createQuery(hql);
        List<Product> resultList = q.list();
        session.getTransaction().commit();
        session.close();
        if (resultList != null && resultList.size() == 1) {
            return resultList.get(0);
        }
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<Product>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from Product order by productName";
        Query q = session.createQuery(hql);
        List<Product> resultList = q.list();
        session.getTransaction().commit();
        session.close();
        if (resultList != null && resultList.size() > 0) {
            products.addAll(resultList);
        }
        return products;
    }

    //
    @Override
    public String getPreference(String key) {
        Preferences prefs = Preferences.userRoot().node(this.getClass().getName());
        return prefs.get(key, "");
    }

    @Override
    public void setPreference(String key, String value) {
        Preferences prefs = Preferences.userRoot().node(this.getClass().getName());
        prefs.put(key, value);
    }

    //Stock
    @Override
    public String saveOrUpdateStock(Stock stock) throws HibernateException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(stock);
        session.getTransaction().commit();
        session.close();
        return stock.getStockId();
    }

    @Override
    public void removeStock(Stock stock) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(stock);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Stock getStock(String stockId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from Stock s where s.stockId='" + stockId + "' ";
        Query q = session.createQuery(hql);
        List<Stock> resultList = q.list();
        session.getTransaction().commit();
        session.close();
        if (resultList != null && resultList.size() == 1) {
            return resultList.get(0);
        }
        return null;
    }

    @Override
    public Set<Stock> getAllStocks() {
        Set<Stock> stocks = new HashSet<Stock>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from Stock";
        Query q = session.createQuery(hql);
        List<Stock> resultList = q.list();
        session.getTransaction().commit();
        session.close();
        if (resultList != null && resultList.size() > 0) {
            stocks.addAll(resultList);
        }
        return stocks;
    }

    //Transaction
    @Override
    public Transaction getTransactions(String transactionId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from Transaction t where t.transactionId='" + transactionId + "' ";
        Query q = session.createQuery(hql);
        List<Transaction> resultList = q.list();
        session.getTransaction().commit();
        session.close();
        if (resultList != null && resultList.size() == 1) {
            return resultList.get(0);
        }
        return null;
    }

    @Override
    public Set<Transaction> getAllTransactions() {
        Set<Transaction> transactions = new HashSet<Transaction>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from Transaction";
        Query q = session.createQuery(hql);
        List<Transaction> resultList = q.list();
        session.getTransaction().commit();
        session.close();
        if (resultList != null && resultList.size() > 0) {
            transactions.addAll(resultList);
        }
        return transactions;
    }

    public Set<Transaction> getAllPurchaseTransactions() {
        Set<Transaction> transactions = new HashSet<Transaction>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from Transaction t where t.transactionType = 'PURCHASE'";
        Query q = session.createQuery(hql);
        List<Transaction> resultList = q.list();

        for (Transaction transaction : resultList) {
            Hibernate.initialize(transaction.getSupplier());
        }

        session.getTransaction().commit();
        session.close();
        if (resultList != null && resultList.size() > 0) {
            transactions.addAll(resultList);
        }
        return transactions;
    }

    public Set<Transaction> getAllSalesTransactions() {
        Set<Transaction> transactions = new HashSet<Transaction>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from Transaction t where t.transactionType = 'SALES'";
        Query q = session.createQuery(hql);
        List<Transaction> resultList = q.list();

        for (Transaction transaction : resultList) {
            Hibernate.initialize(transaction.getCustomer());
        }

        session.getTransaction().commit();
        session.close();
        if (resultList != null && resultList.size() > 0) {
            transactions.addAll(resultList);
        }
        return transactions;
    }

}
