/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.salesinventory.service;


import com.abc.salesinventory.model.newpackage.Stock;
import com.abc.salesinventory.util.Database;
import com.abc.salesinventory.model.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author DAS
 */
public class SellServiceImpl implements SellService {

    private Database db = new Database();
    StockService stockService = new StockServiceImpl();

    public Sell findById(int id) {
        Sell foundSell = null;
        try {
            ResultSet rst = db.getdata("Select * from sell where sell_ID=" + id);

            while (rst.next()) {
                foundSell = new Sell();

                foundSell.setId(rst.getInt("sell_ID"));
                foundSell.setSellDate(rst.getString("date"));
                foundSell.setTotalPrice(rst.getDouble("total_price"));
            }
        } catch (Exception e) {
            Logger.getLogger(SellServiceImpl.class.getName()).error(e);
        }
        return foundSell;
    }

    public boolean save(Sell inSell, List<SellItem> sellItems) {
        try {
            List<String> SQLstmts = new ArrayList<String>();
            SQLstmts.add("Insert into sell (sell_ID,total_price) values ("+ inSell.getId() + "," + inSell.getTotalPrice() + ")");
            for (SellItem sellItem: sellItems) {
                List<String> foundBestStockQueries = stockService.findBestStockQueries(sellItem.getId(), sellItem.getQty());
                if (foundBestStockQueries != null) {
                    SQLstmts.addAll(foundBestStockQueries);
                    SQLstmts.add("Insert into sold_stock (sell_ID,item_No,qty,price) values (" + inSell.getId() + "," + sellItem.getId() + "," + sellItem.getQty() + "," + sellItem.getPrice() + ")");
                } else {
                    throw new Exception("No enough Stocks");
                }
            }
            db.putdata(SQLstmts);
            return true;
        } catch (Exception e) {
            Logger.getLogger(SellServiceImpl.class.getName()).error(e);
        }
        return false;
    }

    public Sell update(Sell inSell) {
        Sell updatedSell = null;
        int id = inSell.getId();
        double totalPrice = inSell.getTotalPrice();
        try {
            db.putdata("Update stock set total_price=" + totalPrice + " where sell_ID=" + id);
            updatedSell = findById(id);
        } catch (Exception ex) {
            Logger.getLogger(SellServiceImpl.class.getName()).error(ex);
        }

        return updatedSell;
    }

    public boolean deleteById(int id) {
        return false;
    }

    public List<Sell> findByStock(Stock inStock) {
        List<Sell> foundSells = new ArrayList<Sell>();
        try {
            ResultSet rst = db.getdata("Select * from sell where stock_ID=" + inStock.getStockId());

            while (rst.next()) {
                Sell foundSell = new Sell();
                foundSell.setId(rst.getInt("sell_ID"));
                foundSell.setSellDate(rst.getString("date"));
                foundSell.setTotalPrice(rst.getDouble("total_price"));

                foundSells.add(foundSell);
            }
        } catch (Exception e) {
            Logger.getLogger(SellServiceImpl.class.getName()).error(e);
        }
        return foundSells;
    }

    @Override
    public List<Sell> findByDate(String inSellDate) {
        List<Sell> foundSells = new ArrayList<Sell>();
        try {
            ResultSet rst = db.getdata("Select * from sell where date=" + inSellDate);

            while (rst.next()) {
                Sell foundSell = new Sell();
                foundSell.setId(rst.getInt("sell_ID"));
                foundSell.setSellDate(rst.getString("date"));
                foundSell.setTotalPrice(rst.getDouble("total_price"));

                foundSells.add(foundSell);
            }
        } catch (Exception e) {
            Logger.getLogger(SellServiceImpl.class.getName()).error(e);
        }
        return foundSells;
    }

    public List<Sell> findAll() {
        List<Sell> foundSells = new ArrayList<Sell>();
        try {
            ResultSet rst = db.getdata("Select * from sell");

            while (rst.next()) {
                Sell foundSell = new Sell();
                foundSell.setId(rst.getInt("sell_ID"));
                foundSell.setSellDate(rst.getString("date"));
                foundSell.setTotalPrice(rst.getDouble("total_price"));

                foundSells.add(foundSell);
            }
        } catch (Exception e) {
            Logger.getLogger(SellServiceImpl.class.getName()).error(e);
        }
        return foundSells;
    }

    public int sellId() {
        int sellId = 0;

        try {
            Database db = new Database();

            ResultSet rst = db.getdata("Select max(sell_ID) from sell");

            while (rst.next()) {

                sellId = rst.getInt("max(sell_ID)");

            }
        } catch (Exception e) {
        }
        return sellId + 1;

    }
}
