/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajitkbaral.hrm.dao.impl;

import com.ajitkbaral.hrm.dao.DepartmentDAO;
import com.ajitkbaral.hrm.entities.Department;
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
public class DepartmentDAOImpl implements DepartmentDAO{
    
    private DBConnection connection;

    public DepartmentDAOImpl(){
        try {
            connection = new DBConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DepartmentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public int insert(Department e) throws SQLException {
        connection.open();
        String sql = "INSERT INTO department (name, type, description) VALUES";
        sql+="('"+e.getName()+"','"+e.getType()+"','"+e.getDescription()+"')";
        int insert = connection.executeUpdate(sql);
        connection.close();
        return insert;
    }

    @Override
    public int update(Department e, int id) throws ClassNotFoundException, SQLException {
        connection.open();
        String sql="UPDATE department SET name='"+e.getName()+"',type='"+e.getType()+"', description='"+e.getDescription()+"' WHERE dept_id = "+id;
        int update = connection.executeUpdate(sql);
        connection.close();
        return update;
    }

    @Override
    public List<Department> showAll() throws ClassNotFoundException, SQLException {
        connection.open();
        List<Department> departmentList = new ArrayList<Department>();
        String sql="SELECT * FROM department";
        ResultSet rs = connection.executeQuery(sql);
        while(rs.next()){
            Department department = new Department();
            department.setDeptId(rs.getInt("dept_id"));
            department.setName(rs.getString("name"));
            department.setType(rs.getString("type"));
            department.setDescription(rs.getString("description"));
            departmentList.add(department);
        }
        connection.close();
        return departmentList;
    }
    
    @Override
    public List<Department> showAll(int limit) throws ClassNotFoundException, SQLException {
        connection.open();
        List<Department> departmentList = new ArrayList<Department>();
        String sql="SELECT * FROM department ORDER BY dept_id DESC LIMIT "+limit;
        ResultSet rs = connection.executeQuery(sql);
        while(rs.next()){
            Department department = new Department();
            department.setDeptId(rs.getInt("dept_id"));
            department.setName(rs.getString("name"));
            department.setType(rs.getString("type"));
            department.setDescription(rs.getString("description"));
            departmentList.add(department);
        }
        connection.close();
        return departmentList;
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        connection.open();
        String sql="DELETE FROM department WHERE dept_id="+id;
        int delete = connection.executeUpdate(sql);
        connection.close();
        return delete;
    }

    @Override
    public Department searchByid(int id) throws ClassNotFoundException, SQLException {
        connection.open();
        Department department = null;
        String sql="SELECT * FROM department WHERE dept_id="+id;
        ResultSet rs = connection.executeQuery(sql);
        while(rs.next()){
            department = new Department();
            department.setDeptId(rs.getInt("dept_id"));
            department.setName(rs.getString("name"));
            department.setType(rs.getString("type"));
            department.setDescription(rs.getString("description"));
        }
        connection.close();
        return department;
    }

    @Override
    public List<Department> searchByAny(String param) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
