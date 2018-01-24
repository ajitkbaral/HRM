/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajitkbaral.hrm.dao.impl;

import com.ajitkbaral.hrm.dao.UserDAO;
import com.ajitkbaral.hrm.entities.Department;
import com.ajitkbaral.hrm.entities.Employee;
import com.ajitkbaral.hrm.entities.User;
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
public class UserDAOImpl implements UserDAO {

    private DBConnection connection;

    public UserDAOImpl() {
        try {
            connection = new DBConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int insert(User e) throws SQLException {
        connection.open();
        String sql = "INSERT INTO user (username, password, emp_id, role_id) VALUES";
        sql += "('" + e.getUsername() + "','" + e.getPassword() + "'," + e.getEmpId()+ "," + e.getRoleId()+ ")";
        int insert = connection.executeUpdate(sql);
        connection.close();
        return insert;
    }

    @Override
    public int update(User e, int id) throws ClassNotFoundException, SQLException {
        connection.open();
        String sql = "UPDATE user SET username='" + e.getUsername() + "',password='" + e.getPassword() + "', emp_id=" + e.getEmpId()+ ",role_id=" + e.getRoleId()+ " WHERE user_id=" + id;
        int update = connection.executeUpdate(sql);
        connection.close();
        return update;
    }

    @Override
    public List<User> showAll() throws ClassNotFoundException, SQLException {
        connection.open();
        List<User> userList = new ArrayList<User>();
        String sql = "SELECT * FROM user";
        ResultSet rs = connection.executeQuery(sql);
        while (rs.next()) {
            User user = new User();
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmpId(rs.getInt("emp_id"));
            user.setRoleId(rs.getInt("role_id"));
            userList.add(user);
        }
        connection.close();
        return userList;
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        connection.open();
        String sql = "DELETE FROM user WHERE id=" + id;
        int delete = connection.executeUpdate(sql);
        connection.close();
        return delete;
    }

    @Override
    public User searchByid(int id) throws ClassNotFoundException, SQLException {
        connection.open();
        User user = null;
        String sql = "SELECT * FROM user WHERE id=" + id;
        ResultSet rs = connection.executeQuery(sql);
        while (rs.next()) {
            user = new User();
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmpId(rs.getInt("emp_id"));
            user.setRoleId(rs.getInt("role_id"));
        }
        connection.close();
        return user;
    }

    @Override
    public User searchByUsernameAndPassword(String username, String password) throws ClassNotFoundException, SQLException {
        connection.open();
        User user = null;
        String sql = "SELECT u.user_id, u.username, u.password, u.emp_id, u.role_id, e.name, e.address, e.email, e.gender, e.position, e.salary, d.dept_id, d.name as dept_name FROM user u INNER JOIN employee e ON u.emp_id = e.emp_id INNER JOIN department d ON d.dept_id = e.dept_id WHERE u.username = '"+username+"' AND u.password = '"+password+"'";
        ResultSet rs = connection.executeQuery(sql);
        while (rs.next()) {
            user = new User();
            Employee employee = new Employee();
            user.setUserId(rs.getInt("user_id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmpId(rs.getInt("emp_id"));
            employee.setName(rs.getString("name"));
            employee.setEmail(rs.getString("email"));
            employee.setAddress(rs.getString("address"));
            employee.setGender(rs.getString("gender"));
            employee.setPosition(rs.getString("position"));
            employee.setSalary(rs.getDouble("salary"));
            employee.setDeptId(rs.getInt("dept_id"));
            Department department = new Department();
            department.setName(rs.getString("dept_name"));
            employee.setDepartment(department);
            user.setEmployee(employee);
            user.setRoleId(rs.getInt("role_id"));
        }
        connection.close();
        return user;
    }
    
    @Override
    public Boolean checkUserName(String username) throws ClassNotFoundException, SQLException {
        int count = 1;
        connection.open();
        String sql = "SELECT COUNT(username) FROM user WHERE username= '" + username + "'";
        ResultSet rs = connection.executeQuery(sql);
        if (rs.next()) {
            count = rs.getInt("COUNT(username)");
        }
        connection.close();
        if (count == 1) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<User> searchByAny(String param) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
