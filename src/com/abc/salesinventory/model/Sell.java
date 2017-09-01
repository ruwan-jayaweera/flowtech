/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abc.salesinventory.model;

import java.util.Date;

/**
 *
 * @author DAS
 */
public class Sell {
    private int id;
    private String sellDate;
    private double totalPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSellDate() {
        return sellDate;
    }

    public void setSellDate(String sellDate) {
        this.sellDate = sellDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }


}
