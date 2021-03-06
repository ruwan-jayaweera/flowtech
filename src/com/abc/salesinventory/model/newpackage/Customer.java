package com.abc.salesinventory.model.newpackage;
// Generated Aug 11, 2014 2:22:10 PM by Hibernate Tools 3.6.0



/**
 * Customer generated by hbm2java
 */
public class Customer  implements java.io.Serializable {


     private String id;
     private String name;
     private String mobile;
     private String home;
     private String office;
     private String email;
     private String address;

    public Customer() {
    }

	
    public Customer(String id) {
        this.id = id;
    }
    public Customer(String id, String name, String mobile, String home, String office, String email, String address) {
       this.id = id;
       this.name = name;
       this.mobile = mobile;
       this.home = home;
       this.office = office;
       this.email = email;
       this.address = address;
    }
   
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getHome() {
        return this.home;
    }
    
    public void setHome(String home) {
        this.home = home;
    }
    public String getOffice() {
        return this.office;
    }
    
    public void setOffice(String office) {
        this.office = office;
    }

    @Override
    public String toString() {
        return "" + name;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }




}


