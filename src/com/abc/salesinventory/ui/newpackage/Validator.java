/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.salesinventory.ui.newpackage;

/**
 *
 * @author Manuri
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private Pattern patternCusId;
    private Matcher matcherCusId;
    private Pattern patternPhone;
    private Matcher matcherPhone;
    private Pattern patternEmail;
    private Matcher matcherEmail;
    private Pattern patternSupId;
    private Matcher matcherSupId;

private static final String CustomerId = "[C][0-9][0-9][0-9][0-9][0-9]";
private static final String Phone = "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]";
private static final String Email = "(\\w[-._\\w]*\\w@\\w[-._\\w]*\\w\\.\\w{2,3})";
private static final String SupplierId = "[S][0-9][0-9][0-9][0-9][0-9]";
    

    public Validator() {
        patternCusId = Pattern.compile(CustomerId);
        patternPhone = Pattern.compile(Phone);
        patternEmail = Pattern.compile(Email);
        patternSupId = Pattern.compile(SupplierId);
    }

    /**
     * Validate hex with regular expression
     *
     * @param hex hex for validation
     * @return true valid hex, false invalid hex
     */
    public boolean validateCustomerId(final String hex) {

        matcherCusId = patternCusId.matcher(hex);
        return matcherCusId.matches();

    }

    public boolean validatePhoneNumber(final String hex) {
        matcherPhone = patternPhone.matcher(hex);
        return matcherPhone.matches();
    }

    public boolean validEmail(final String hex) {
        matcherEmail = patternEmail.matcher(hex);
        return matcherEmail.matches();
    }

    public boolean validateSupplierId(final String hex) {

        matcherSupId = patternSupId.matcher(hex);
        return matcherSupId.matches();
    }
    

}
