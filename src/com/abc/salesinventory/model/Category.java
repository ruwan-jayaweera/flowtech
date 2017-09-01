/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.salesinventory.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DAS
 */
public class Category {

    private String name;
    private List<String> units= new ArrayList<String>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getUnits() {
        return units;
    }

    public void addUnits(String unit) {
        this.units.add(unit);
    }

    public void removeUnits(String unit) {
        this.units.remove(unit);
    }
}
