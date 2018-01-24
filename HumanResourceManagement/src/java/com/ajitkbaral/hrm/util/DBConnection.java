/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajitkbaral.hrm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Ajit Kumar Baral
 */
public class DBConnection {
    private Connection conn;
    
    public DBConnection() throws ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        
    }
    
    public int executeUpdate(String sql) throws SQLException
    {
        Statement stmt = conn.createStatement();
        return stmt.executeUpdate(sql);
    }
    
    public ResultSet executeQuery(String sql) throws SQLException{
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }
    
    public void close() throws SQLException{
        conn.close();
    }
    
    public void open() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost/hrm","root","");
    }
    
}
