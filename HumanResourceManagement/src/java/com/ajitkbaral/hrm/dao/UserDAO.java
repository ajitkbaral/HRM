/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajitkbaral.hrm.dao;

import com.ajitkbaral.hrm.entities.User;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Ajit Kumar Baral
 */
public interface UserDAO {
    public int insert(User t) throws ClassNotFoundException, SQLException;
    public int update(User t, int id) throws ClassNotFoundException, SQLException;
    public List<User> showAll() throws ClassNotFoundException, SQLException;
    public int delete(int id) throws ClassNotFoundException, SQLException ;
    public User searchByUsernameAndPassword(String username, String password) throws ClassNotFoundException, SQLException;
    public User searchByid(int id) throws ClassNotFoundException, SQLException;
    public List<User> searchByAny(String param) throws ClassNotFoundException, SQLException;
    public Boolean checkUserName(String username) throws ClassNotFoundException, SQLException ;
}
