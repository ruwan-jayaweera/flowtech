/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.salesinventory.service.newpackage;

import com.abc.salesinventory.model.newpackage.Stock;
import com.abc.salesinventory.model.newpackage.Transaction;
//import com.abc.salesinventory.model.newpackage.Message;
import com.abc.salesinventory.util.HibernateUtil;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Manuri
 */
public class InventoryServiceImpl implements InventoryService {

    @Override
    public List<Object> getReorderStock() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createSQLQuery(
                "SELECT s.product_code, SUM(s.quantity) as 'qty', p.product_name,p.reorder_level FROM flowtech.stock s\n"
                + "join flowtech.product p on s.product_code=p.product_code\n"
                + "group by s.product_code, p.product_name, p.reorder_level\n"
                + "having qty < (select p.reorder_level from product p where p.product_code=s.product_code)");

        List<Object> resultList = query.list();
        session.getTransaction().commit();
        session.close();
        if (resultList != null && resultList.size() > 0) {
            return resultList;
        }
        return null;
    }

    @Override
    public List<Object> getReorderStockWithSupplier() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createSQLQuery(
                "SELECT s.product_code, p.product_name, p.unit, sup.id, sup.name, "
                        + "sup.mobile, p.reorder_level,SUM(s.quantity) as 'qty', p.standard_reorder_level FROM flowtech.stock s "
                        + "join flowtech.product p on s.product_code=p.product_code "
                        + "join flowtech.supplier sup on sup.id=s.supplier_id "
                        + "group by s.product_code, p.product_name, p.reorder_level, p.standard_reorder_level "
                        + "having qty < (select p.reorder_level from product p where p.product_code=s.product_code)");

        List<Object> resultList = query.list();
        session.getTransaction().commit();
        session.close();
        if (resultList != null && resultList.size() > 0) {
            return resultList;
        }
        return null;
    }

    @Override
    public List<Stock> getStockByProduct(String productCode) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from Stock s where s.product.productCode='" + productCode + "' order by expDate desc";
        Query q = session.createQuery(hql);
        List<Stock> resultList = q.list();

        for (Stock stock : resultList) {
            Hibernate.initialize(stock.getSupplier());
            Hibernate.initialize(stock.getProduct());
        }
        session.getTransaction().commit();
        session.close();
        if (resultList != null && resultList.size() > 0) {
            return resultList;
        }
        return null;
    }

    @Override
    public String saveStock(Stock stock) throws HibernateException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(stock);
        session.getTransaction().commit();
        session.close();
        return stock.getStockId();
    }

    @Override
    public String saveTransaction(Transaction transaction) throws HibernateException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(transaction);
        session.getTransaction().commit();
        session.close();
        return transaction.getTransactionId();
    }

    @Override
    public Transaction getTransaction(String transactionId) {
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
    
    
//    @Override
//    public List<Object> getSupplierNameWithMessage() {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//
//        Query query = session.createSQLQuery(
//                "SELECT m.supplier_id, s.name, m.message, m.msg_date, m.message_type, m.contact_number\n" +
//"FROM flowtec.message m join flowtech.supplier s on m.supplier_id=s.id");
//
//        List<Object> resultList = query.list();
//        session.getTransaction().commit();
//        session.close();
//        if (resultList != null && resultList.size() > 0) {
//            return resultList;
//        }
//        return null;
//    }

}
