/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.salesinventory.service;

import com.abc.salesinventory.model.*;
import com.abc.salesinventory.util.Database;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author DAS
 */
public class ItemServiceImpl implements ItemService {

    private Database db = new Database();

    public Item findById(int id) {
        Item foundItem = null;
        try {
            ResultSet rst = db.getdata("Select * from item where item_no=" + id);

            while (rst.next()) {
                foundItem = new Item();
                foundItem.setId(rst.getInt("item_no"));
                foundItem.setItemCode(rst.getString("item_code"));
                foundItem.setBrandName(rst.getString("brand_name"));
                foundItem.setSupplier(rst.getString("supplier"));
                foundItem.setCategory(rst.getString("category"));
                foundItem.setUnitPrice(rst.getDouble("unit_price"));
                foundItem.setReorderLevel(rst.getDouble("reorder_level"));
                foundItem.setUnit(rst.getString("unit"));
            }
        } catch (Exception e) {
            Logger.getLogger(ItemServiceImpl.class.getName()).error(e);
        }
        return foundItem;
    }

    public SellItem findOneByCode(String itemCode) {
        SellItem foundItem = null;
        try {
            ResultSet rst = db.getdata("Select * from item where item_code='" + itemCode + "'");

            while (rst.next()) {
                foundItem = new SellItem();
                foundItem.setId(rst.getInt("item_no"));
                foundItem.setItemCode(rst.getString("item_code"));
                foundItem.setBrandName(rst.getString("brand_name"));
                foundItem.setSupplier(rst.getString("supplier"));
                foundItem.setCategory(rst.getString("category"));
                foundItem.setUnitPrice(rst.getDouble("unit_price"));
                foundItem.setReorderLevel(rst.getDouble("reorder_level"));
                foundItem.setUnit(rst.getString("unit"));
            }
        } catch (Exception e) {
            Logger.getLogger(ItemServiceImpl.class.getName()).error(e);
        }
        return foundItem;
    }

    public boolean save(Item inItem) {
        try {
            db.putdata("Insert into item (item_code,brand_name,supplier,category,unit_price,reorder_level,unit) values ('" + inItem.getItemCode() + "','" + inItem.getBrandName() + "','" + inItem.getSupplier() + "','" + inItem.getCategory() + "'," + inItem.getUnitPrice() + "," + inItem.getReorderLevel() + ",'" + inItem.getUnit() + "')");
            return true;
        } catch (Exception e) {
            Logger.getLogger(ItemServiceImpl.class.getName()).error(e);
        }
        return false;
    }

    public Item update(Item inItem) {
        Item updatedItem = null;
        int id = inItem.getId();
        String brandName = inItem.getBrandName();
        String supplier = inItem.getSupplier();
        String category = inItem.getCategory();
        double unitPrice = inItem.getUnitPrice();
        double reorderLevel = inItem.getReorderLevel();
        String unit = inItem.getUnit();
        try {
            db.putdata("Update item set brand_name='" + brandName + "', supplier='" + supplier + "',category='" + category + "',unit_price=" + unitPrice + ",reorder_level=" + reorderLevel + ",unit=" + unit + " where item_no=" + id);
            updatedItem = findById(id);
        } catch (Exception ex) {
            Logger.getLogger(ItemServiceImpl.class.getName()).error(ex);
        }

        return updatedItem;
    }

    public boolean deleteById(int id) {
        return false;
    }

    public List<Item> findByCode(String itemCode) {
        List<Item> foundItems = new ArrayList<Item>();
        try {
            ResultSet rst = db.getdata("Select * from item where item_code LIKE '%" + itemCode + "%'");

            while (rst.next()) {
                Item foundItem = new Item();
                foundItem.setId(rst.getInt("item_no"));
                foundItem.setItemCode(rst.getString("item_code"));
                foundItem.setBrandName(rst.getString("brand_name"));
                foundItem.setSupplier(rst.getString("supplier"));
                foundItem.setCategory(rst.getString("category"));
                foundItem.setUnitPrice(rst.getDouble("unit_price"));
                foundItem.setReorderLevel(rst.getDouble("reorder_level"));
                foundItem.setUnit(rst.getString("unit"));

                foundItems.add(foundItem);
            }
        } catch (Exception e) {
            Logger.getLogger(ItemServiceImpl.class.getName()).error(e);
        }
        return foundItems;
    }

    public List<Item> findByBrandName(String inBrandName) {
        List<Item> foundItems = new ArrayList<Item>();
        try {
            ResultSet rst = db.getdata("Select * from item where brand_name LIKE '%" + inBrandName + "%'");

            while (rst.next()) {
                Item foundItem = new Item();
                foundItem.setId(rst.getInt("item_no"));
                foundItem.setItemCode(rst.getString("item_code"));
                foundItem.setBrandName(rst.getString("brand_name"));
                foundItem.setSupplier(rst.getString("supplier"));
                foundItem.setCategory(rst.getString("category"));
                foundItem.setUnitPrice(rst.getDouble("unit_price"));
                foundItem.setReorderLevel(rst.getDouble("reorder_level"));
                foundItem.setUnit(rst.getString("unit"));

                foundItems.add(foundItem);
            }
        } catch (Exception e) {
            Logger.getLogger(ItemServiceImpl.class.getName()).error(e);
        }
        return foundItems;
    }

    public List<Item> findBySupplier(String inSupplier) {
        List<Item> foundItems = new ArrayList<Item>();
        try {
            ResultSet rst = db.getdata("Select * from item where supplier LIKE '%" + inSupplier + "%'");

            while (rst.next()) {
                Item foundItem = new Item();
                foundItem.setId(rst.getInt("item_no"));
                foundItem.setItemCode(rst.getString("item_code"));
                foundItem.setBrandName(rst.getString("brand_name"));
                foundItem.setSupplier(rst.getString("supplier"));
                foundItem.setCategory(rst.getString("category"));
                foundItem.setUnitPrice(rst.getDouble("unit_price"));
                foundItem.setReorderLevel(rst.getDouble("reorder_level"));
                foundItem.setUnit(rst.getString("unit"));

                foundItems.add(foundItem);
            }
        } catch (Exception e) {
            Logger.getLogger(ItemServiceImpl.class.getName()).error(e);
        }
        return foundItems;
    }

    public List<Item> findByCategory(String inCategory) {
        List<Item> foundItems = new ArrayList<Item>();
        try {
            ResultSet rst = db.getdata("Select * from item where category LIKE '%" + inCategory + "%'");

            while (rst.next()) {
                Item foundItem = new Item();
                foundItem.setId(rst.getInt("item_no"));
                foundItem.setItemCode(rst.getString("item_code"));
                foundItem.setBrandName(rst.getString("brand_name"));
                foundItem.setSupplier(rst.getString("supplier"));
                foundItem.setCategory(rst.getString("category"));
                foundItem.setUnitPrice(rst.getDouble("unit_price"));
                foundItem.setReorderLevel(rst.getDouble("reorder_level"));
                foundItem.setUnit(rst.getString("unit"));

                foundItems.add(foundItem);
            }
        } catch (Exception e) {
            Logger.getLogger(ItemServiceImpl.class.getName()).error(e);
        }
        return foundItems;
    }

    public List<Item> findAll() {
        List<Item> foundItems = new ArrayList<Item>();
        try {
            ResultSet rst = db.getdata("Select * from item");

            while (rst.next()) {
                Item foundItem = new Item();
                foundItem.setId(rst.getInt("item_no"));
                foundItem.setItemCode(rst.getString("item_code"));
                foundItem.setBrandName(rst.getString("brand_name"));
                foundItem.setSupplier(rst.getString("supplier"));
                foundItem.setCategory(rst.getString("category"));
                foundItem.setUnitPrice(rst.getDouble("unit_price"));
                foundItem.setReorderLevel(rst.getDouble("reorder_level"));
                foundItem.setUnit(rst.getString("unit"));

                foundItems.add(foundItem);
            }
        } catch (Exception e) {
            Logger.getLogger(ItemServiceImpl.class.getName()).error(e);
        }
        return foundItems;
    }

    public double getAvalilableQtyFromDB(int itemId) {
        double availableQty = 0;
        try {
            ResultSet rst = db.getdata("Select a.sumqty  from (Select item_No,sum(qty) as sumqty from stock group by item_No) as a  where a.item_No=" + itemId);

            while (rst.next()) {
                availableQty = rst.getDouble("sumqty");
            }
        } catch (Exception e) {
            Logger.getLogger(ItemServiceImpl.class.getName()).error(e);
        }

        return availableQty;
    }

    public SellItem parseSellItem(Item item) {
        SellItem sellItem = new SellItem();
        sellItem.setId(item.getId());
        sellItem.setItemCode(item.getItemCode());
        sellItem.setBrandName(item.getBrandName());
        sellItem.setCategory(item.getCategory());
        sellItem.setSupplier(item.getSupplier());
        sellItem.setReorderLevel(item.getReorderLevel());
        sellItem.setUnit(item.getUnit());
        sellItem.setUnitPrice(item.getUnitPrice());
        sellItem.setQty(0);
        return sellItem;
    }
}
