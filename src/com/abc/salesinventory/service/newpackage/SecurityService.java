/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.salesinventory.service.newpackage;

import com.abc.salesinventory.model.newpackage.Permission;
import com.abc.salesinventory.model.newpackage.Role;
import com.abc.salesinventory.model.newpackage.User;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;

/**
 *
 * @author Manuri
 */
public interface SecurityService {
    
    public boolean hasPermission(String permissionCode, String userId);
    
    public String getPasswordHash(String plainTextPassword);
    
    public boolean isPasswordCorrect(String plainTextPassword, String userId);
    
    public String saveOrUpdateUser(User user) throws HibernateException;
    
    public void removeUser(User user);
    
    public User getUser(String userId);
    
    public User getUserByUserName(String userName);
    
    public Set<User> getAllUsers();

    public Role getRole(String roleId);

    public Set<Role> getAllRoles();

    public String saveOrUpdateRole(Role role) throws HibernateException;

    public void removeRole(Role role);

    public Role getRoleByName(String roleName);

    public Permission getPermission(String permissionId);

    public Set<Permission> getAllPermissions();

    public String saveOrUpdatePermission(Permission permission) throws HibernateException;

    public void removePermission(Permission permission);

    public Permission getPermissionByName(String permissionName);
    
    public List<Permission> getPermissionsByRole(String roleId);

}
