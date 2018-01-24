/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajitkbaral.hrm.dao;

import com.ajitkbaral.hrm.entities.Role;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Ajit Kumar Baral
 */
public interface RoleDAO {
    public int insert(Role t) throws ClassNotFoundException, SQLException;
    public int update(Role t, int id) throws ClassNotFoundException, SQLException;
    public List<Role> showAll() throws ClassNotFoundException, SQLException;
    public int delete(int id) throws ClassNotFoundException, SQLException ;
    public Role searchByid(int id) throws ClassNotFoundException, SQLException;
    public List<Role> searchByAny(String param) throws ClassNotFoundException, SQLException;
}
