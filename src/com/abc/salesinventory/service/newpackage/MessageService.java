/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abc.salesinventory.service.newpackage;

import com.abc.salesinventory.model.newpackage.Message;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;

/**
 *
 * @author Manuri
 */
public interface MessageService {
    
    public List<Message> getSupplierNameWithMessage();
    
}
