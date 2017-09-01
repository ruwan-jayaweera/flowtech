/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abc.salesinventory.service;

import com.abc.salesinventory.model.newpackage.Stock;
import com.abc.salesinventory.model.*;
import java.util.List;

/**
 *
 * @author DAS
 */
public interface StockService {

    public Stock findById(int id);
    public boolean save(Stock inStock);
    public Stock update(Stock inStock);
    public boolean deleteById(int id);
    public List<Stock> findByItem(Item inItem);
    public List<Stock> findByExpDate(String inExpDate);
    public List<Stock> findAll();
    public List<String> findBestStockQueries(int item_no, double reqQty, int... ids);
}
