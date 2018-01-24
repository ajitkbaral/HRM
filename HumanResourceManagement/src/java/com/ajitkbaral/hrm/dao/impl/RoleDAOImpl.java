/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajitkbaral.hrm.dao.impl;

import com.ajitkbaral.hrm.dao.RoleDAO;
import com.ajitkbaral.hrm.entities.Role;
import com.ajitkbaral.hrm.util.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ajit Kumar Baral
 */
public class RoleDAOImpl implements RoleDAO{
    
    private DBConnection connection;
    
    public RoleDAOImpl(){
        try {
            connection = new DBConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RoleDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int insert(Role t) throws ClassNotFoundException, SQLException {
        connection.open();
        String sql = "INSERT INTO role (role_name description) VALUES";
        sql+="('"+t.getRoleName()+"','"+t.getDescription()+"')";
        int insert = connection.executeUpdate(sql);
        connection.close();
        return insert;
    }

    @Override
    public int update(Role t, int id) throws ClassNotFoundException, SQLException {
        connection.open();
        String sql="UPDATE role SET role_name='"+t.getRoleName()+"', description='"+t.getDescription()+"' WHERE role_id = "+id;
        int update = connection.executeUpdate(sql);
        connection.close();
        return update;
    }

    @Override
    public List<Role> showAll() throws ClassNotFoundException, SQLException {
        connection.open();
        List<Role> roleList = new ArrayList<Role>();
        String sql="SELECT * FROM role";
        ResultSet rs = connection.executeQuery(sql);
        while(rs.next()){
            Role role = new Role();
            role.setRoleId(rs.getInt("role_id"));
            role.setRoleName(rs.getString("role_name"));
            role.setDescription(rs.getString("description"));
            roleList.add(role);
        }
        connection.close();
        return roleList;
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Role searchByid(int id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Role> searchByAny(String param) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
