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
public class StockServiceImpl implements StockService {

    private Database db = new Database();
    private ItemService itemService = new ItemServiceImpl();

    public Stock findById(int id) {
        Stock foundStock = null;
        try {
            ResultSet rst = db.getdata("Select * from stock where stock_ID=" + id);

            while (rst.next()) {
                foundStock = new Stock();

//                foundStock.setId(rst.getInt("stock_ID"));
//                foundStock.setItem(itemService.findById(rst.getInt("item_No")));
//                foundStock.setQty(rst.getDouble("qty"));
//                foundStock.setExpiryDate(rst.getString("expiry_date"));
            }
        } catch (Exception e) {
            Logger.getLogger(StockServiceImpl.class.getName()).error(e);
        }
        return foundStock;
    }

    public boolean save(Stock inStock) {
        try {
//            db.putdata("Insert into stock (item_No,qty,expiry_date) values (" + inStock.getItem().getId() + "," + inStock.getQty() + ",'" + inStock.getExpiryDate() + "')");
            return true;
        } catch (Exception e) {
            Logger.getLogger(StockServiceImpl.class.getName()).error(e);
        }
        return false;
    }

    public Stock update(Stock inStock) {
        Stock updatedStock = null;
//        int id = inStock.getId();
//        int itemId = inStock.getItem().getId();
//        double qty = inStock.getQty();
//        String expdate = inStock.getExpiryDate();
        try {
//            db.putdata("Update stock set item_No=" + itemId + ", qty=" + qty + ",expiry_date='" + expdate + "' where stock_ID=" + id);
//            updatedStock = findById(id);
        } catch (Exception ex) {
            Logger.getLogger(StockServiceImpl.class.getName()).error(ex);
        }

        return updatedStock;
    }

    public boolean deleteById(int id) {
        return false;
    }

    public List<Stock> findByItem(Item inItem) {
        List<Stock> foundStocks = new ArrayList<Stock>();
        try {
            ResultSet rst = db.getdata("Select * from stock where item_No=" + inItem.getId());

            while (rst.next()) {
                Stock foundStock = new Stock();
//                foundStock.setId(rst.getInt("stock_ID"));
//                foundStock.setItem(itemService.findById(rst.getInt("item_No")));
//                foundStock.setQty(rst.getDouble("qty"));
//                foundStock.setExpiryDate(rst.getString("expiry_date"));

                foundStocks.add(foundStock);
            }
        } catch (Exception e) {
            Logger.getLogger(StockServiceImpl.class.getName()).error(e);
        }
        return foundStocks;
    }

    public List<Stock> findByExpDate(String inExpDate) {
        List<Stock> foundStocks = new ArrayList<Stock>();
        try {
            ResultSet rst = db.getdata("Select * from stock where expiry_date=" + inExpDate);

            while (rst.next()) {
                Stock foundStock = new Stock();
//                foundStock.setId(rst.getInt("stock_ID"));
//                foundStock.setItem(itemService.findById(rst.getInt("item_No")));
//                foundStock.setQty(rst.getDouble("qty"));
//                foundStock.setExpiryDate(rst.getString("expiry_date"));

                foundStocks.add(foundStock);
            }
        } catch (Exception e) {
            Logger.getLogger(StockServiceImpl.class.getName()).error(e);
        }
        return foundStocks;
    }

    public List<Stock> findAll() {
        List<Stock> foundStocks = new ArrayList<Stock>();
        try {
            ResultSet rst = db.getdata("Select * from stock");

            while (rst.next()) {
                Stock foundStock = new Stock();
//                foundStock.setId(rst.getInt("stock_ID"));
//                foundStock.setItem(itemService.findById(rst.getInt("item_No")));
//                foundStock.setQty(rst.getDouble("qty"));
//                foundStock.setExpiryDate(rst.getString("expiry_date"));

                foundStocks.add(foundStock);
            }
        } catch (Exception e) {
            Logger.getLogger(StockServiceImpl.class.getName()).error(e);
        }
        return foundStocks;
    }

    public List<String> findBestStockQueries(int item_no, double reqQty, int... ids) {

        double newReqQty = 0;
        if (reqQty > 0) {
            List<String> bestStockQuries = new ArrayList<String>();
            try {
                String idString = "0";
                for (int i = 0; i < ids.length; i++) {
                    idString = ids[i] + "," + idString;
//                    if (i != (ids.length - 1)) {
//                        idString = idString + ",";
//                    }
                }
                ResultSet rst = db.getdata("Select qty,stock_ID,min(`a`.added_date) from (Select * from stock where qty>0 AND item_No=" + item_no + " AND stock_ID NOT in (" + idString + ")) as `a`");

                while (rst.next()) {
                    String stringStockId = rst.getString("stock_ID");
                    if (stringStockId != null) {
                        int stockId = Integer.parseInt(stringStockId);
                        double avlbleQty = rst.getDouble("qty");
                        if (reqQty > avlbleQty) {
                            newReqQty = reqQty - avlbleQty;
                            int newlength = 1;
                            if (ids != null) {
                                newlength = ids.length + newlength;
                            }
                            int[] newIds = new int[newlength];
                            newIds[0] = stockId;
                            for (int i = 1; i < newlength; i++) {
                                newIds[i] = ids[i - 1];
                            }
                            bestStockQuries = findBestStockQueries(item_no, newReqQty, newIds);
                        }
                        if (bestStockQuries != null){
                            bestStockQuries.add("Update stock set qty=" + (avlbleQty - (reqQty-newReqQty)) + " where stock_ID=" + stockId);
                        } else {
                            return null;
                        }
                    } else {
                        return null;
                    }
                }
            } catch (Exception e) {
                Logger.getLogger(StockServiceImpl.class.getName()).error(e);
            }
            return bestStockQuries;
        } else {
            return null;
        }
    }
}
