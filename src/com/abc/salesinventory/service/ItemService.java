/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abc.salesinventory.service;

import com.abc.salesinventory.model.*;
import java.util.List;

/**
 *
 * @author DAS
 */
public interface ItemService {

    public Item findById(int id);
    public SellItem findOneByCode(String itemCode); 
    public boolean save(Item inItem);
    public Item update(Item inItem);
    public boolean deleteById(int id);
    public List<Item> findByCode(String itemCode);
    public List<Item> findByBrandName(String inBrandName);
    public List<Item> findByCategory(String inCategory);
    public List<Item> findBySupplier(String inSupplier);
    public List<Item> findAll();
    public double getAvalilableQtyFromDB(int itemId);
    public SellItem parseSellItem(Item item);
}
