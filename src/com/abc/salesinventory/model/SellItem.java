/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.salesinventory.model;

/**
 *
 * @author Thushara
 */
public class SellItem extends Item{
    private double qty;
    private double price;

    public double getPrice() {
        return price;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
        this.price = qty*getUnitPrice();
    }
    
}
