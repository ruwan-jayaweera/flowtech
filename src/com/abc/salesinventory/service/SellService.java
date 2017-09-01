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
public interface SellService {

    public Sell findById(int id);
    public boolean save(Sell inSell, List<SellItem> sellItems);
    public Sell update(Sell inSell);
    public boolean deleteById(int id);
    public List<Sell> findByStock(Stock inStock);
    public List<Sell> findByDate(String inSellDate);
    public List<Sell> findAll();
    public int sellId();
}
