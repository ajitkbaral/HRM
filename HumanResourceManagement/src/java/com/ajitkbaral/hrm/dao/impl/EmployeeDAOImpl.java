/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajitkbaral.hrm.dao.impl;

import com.ajitkbaral.hrm.dao.EmployeeDAO;
import com.ajitkbaral.hrm.entities.Department;
import com.ajitkbaral.hrm.entities.Employee;
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
public class EmployeeDAOImpl implements EmployeeDAO{
    
    private DBConnection connection;

    public EmployeeDAOImpl(){
        try {
            connection = new DBConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmployeeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public int insert(Employee e) throws SQLException {
        connection.open();
        String sql = "INSERT INTO employee (name, email, address, gender, position, salary, dept_id) VALUES";
        sql+="('"+e.getName()+"','"+e.getEmail()+"','"+e.getAddress()+"','"+e.getGender()+"','"+e.getPosition()+"',"+e.getSalary()+","+e.getDeptId()+")";
        int insert = connection.executeUpdate(sql);
        connection.close();
        return insert;   
    }

    @Override
    public int update(Employee e, int id) throws ClassNotFoundException, SQLException {
        connection.open();
        String sql="UPDATE employee SET name='"+e.getName()+"',email='"+e.getEmail()+"', address='"+e.getAddress()+"',gender='"+e.getGender()+"',position='"+e.getPosition()+"',salary="+e.getSalary()+", dept_id="+e.getDeptId()+" WHERE emp_id = "+id;
        int update = connection.executeUpdate(sql);
        connection.close();
        return update;
    }

    @Override
    public List<Employee> showAll() throws ClassNotFoundException, SQLException {
        connection.open();
        List<Employee> employeeList = new ArrayList<Employee>();
        String sql="SELECT * FROM employee ORDER BY position";
        ResultSet rs = connection.executeQuery(sql);
        while(rs.next()){
            Employee employee = new Employee();
            employee.setEmpId(rs.getInt("emp_id"));
            employee.setName(rs.getString("name"));
            employee.setAddress(rs.getString("address"));
            employee.setEmail(rs.getString("email"));
            employee.setGender(rs.getString("gender"));
            employee.setPosition(rs.getString("position"));
            employee.setSalary(rs.getDouble("salary"));
            employee.setDeptId(rs.getInt("dept_id"));
            employeeList.add(employee);
        }
        connection.close();
        return employeeList;
    }
    
    @Override
    public List<Employee> showAllWithDepartment() throws ClassNotFoundException, SQLException {
        connection.open();
        List<Employee> employeeList = new ArrayList<Employee>();
        String sql="SELECT e.emp_id, e.name as emp_name, e.email, e.address, e.gender, e.position, e.salary, e.dept_id, d.name as dept_name FROM employee e INNER JOIN department d ON e.dept_id = d.dept_id ORDER BY e.position";
        ResultSet rs = connection.executeQuery(sql);
        while(rs.next()){
            Employee employee = new Employee();
            employee.setEmpId(rs.getInt("emp_id"));
            employee.setName(rs.getString("emp_name"));
            employee.setAddress(rs.getString("address"));
            employee.setEmail(rs.getString("email"));
            employee.setGender(rs.getString("gender"));
            employee.setPosition(rs.getString("position"));
            employee.setSalary(rs.getDouble("salary"));
            employee.setDeptId(rs.getInt("dept_id"));
            Department department = new Department();
            department.setName(rs.getString("dept_name"));
            employee.setDepartment(department);
            employeeList.add(employee);
        }
        connection.close();
        return employeeList;
    }
    
    @Override
    public List<Employee> showAllWithDepartment(int limit) throws ClassNotFoundException, SQLException {
        connection.open();
        List<Employee> employeeList = new ArrayList<Employee>();
        String sql="SELECT e.emp_id, e.name as emp_name, e.email, e.address, e.gender, e.position, e.salary, e.dept_id, d.name as dept_name FROM employee e INNER JOIN department d ON e.dept_id = d.dept_id ORDER BY e.emp_id DESC LIMIT "+limit;
        ResultSet rs = connection.executeQuery(sql);
        while(rs.next()){
            Employee employee = new Employee();
            employee.setEmpId(rs.getInt("emp_id"));
            employee.setName(rs.getString("emp_name"));
            employee.setAddress(rs.getString("address"));
            employee.setEmail(rs.getString("email"));
            employee.setGender(rs.getString("gender"));
            employee.setPosition(rs.getString("position"));
            employee.setSalary(rs.getDouble("salary"));
            employee.setDeptId(rs.getInt("dept_id"));
            Department department = new Department();
            department.setName(rs.getString("dept_name"));
            employee.setDepartment(department);
            employeeList.add(employee);
        }
        connection.close();
        return employeeList;
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        connection.open();
        String sql="DELETE FROM employee WHERE emp_id="+id;
        int delete = connection.executeUpdate(sql);
        connection.close();
        return delete;
    }

    @Override
    public Employee searchByid(int id) throws ClassNotFoundException, SQLException {
        connection.open();
        Employee employee = null;
        String sql="SELECT * FROM employee WHERE emp_id="+id;
        ResultSet rs = connection.executeQuery(sql);
        while(rs.next()){
            employee = new Employee();
            employee.setEmpId(rs.getInt("emp_id"));
            employee.setName(rs.getString("name"));
            employee.setAddress(rs.getString("address"));
            employee.setEmail(rs.getString("email"));
            employee.setGender(rs.getString("gender"));
            employee.setPosition(rs.getString("position"));
            employee.setSalary(rs.getDouble("salary"));
            employee.setDeptId(rs.getInt("dept_id"));
        }
        connection.close();
        return employee;
    }
    
    @Override
    public Employee searchByidWithDepartment(int id) throws ClassNotFoundException, SQLException {
        connection.open();
        Employee employee = null;
        String sql="SELECT e.emp_id, e.name as emp_name, e.email, e.address, e.gender, e.position, e.salary, e.dept_id, d.name as dept_name FROM employee e INNER JOIN department d ON e.dept_id = d.dept_id WHERE e.emp_id="+id;
        ResultSet rs = connection.executeQuery(sql);
        while(rs.next()){
            employee = new Employee();
            employee.setEmpId(rs.getInt("emp_id"));
            employee.setName(rs.getString("emp_name"));
            employee.setAddress(rs.getString("address"));
            employee.setEmail(rs.getString("email"));
            employee.setGender(rs.getString("gender"));
            employee.setPosition(rs.getString("position"));
            employee.setSalary(rs.getDouble("salary"));
            employee.setDeptId(rs.getInt("dept_id"));
            Department department = new Department();
            department.setName(rs.getString("dept_name"));
            employee.setDepartment(department);
        }
        connection.close();
        return employee;
    }
    
    
    @Override
    public List<Employee> showAllByDepartmentId(int departmentId) throws ClassNotFoundException, SQLException {
        connection.open();
        List<Employee> employeeList = new ArrayList<Employee>();
        String sql="SELECT e.emp_id, e.name as emp_name, e.email, e.address, e.gender, e.position, e.salary, e.dept_id, d.name as dept_name FROM employee e INNER JOIN department d ON e.dept_id = d.dept_id WHERE d.dept_id = "+departmentId+" ORDER BY e.position";
        ResultSet rs = connection.executeQuery(sql);
        while(rs.next()){
            Employee employee = new Employee();
            employee.setEmpId(rs.getInt("emp_id"));
            employee.setName(rs.getString("emp_name"));
            employee.setAddress(rs.getString("address"));
            employee.setEmail(rs.getString("email"));
            employee.setGender(rs.getString("gender"));
            employee.setPosition(rs.getString("position"));
            employee.setSalary(rs.getDouble("salary"));
            employee.setDeptId(rs.getInt("dept_id"));
            Department department = new Department();
            department.setName(rs.getString("dept_name"));
            employee.setDepartment(department);
            employeeList.add(employee);
        }
        connection.close();
        return employeeList;
    }
    
    
    @Override
    public List<Employee> showByName(String name) throws ClassNotFoundException, SQLException {
        connection.open();
        List<Employee> employeeList = new ArrayList<Employee>();
        String sql="SELECT e.emp_id, e.name as emp_name, e.email, e.address, e.gender, e.position, e.salary, e.dept_id, d.name as dept_name FROM employee e INNER JOIN department d ON e.dept_id = d.dept_id WHERE e.name LIKE '%"+name+"%'"+" ORDER BY e.position";
        ResultSet rs = connection.executeQuery(sql);
        while(rs.next()){
            Employee employee = new Employee();
            employee.setEmpId(rs.getInt("emp_id"));
            employee.setName(rs.getString("emp_name"));
            employee.setAddress(rs.getString("address"));
            employee.setEmail(rs.getString("email"));
            employee.setGender(rs.getString("gender"));
            employee.setPosition(rs.getString("position"));
            employee.setSalary(rs.getDouble("salary"));
            employee.setDeptId(rs.getInt("dept_id"));
            Department department = new Department();
            department.setName(rs.getString("dept_name"));
            employee.setDepartment(department);
            employeeList.add(employee);
        }
        connection.close();
        return employeeList;
    }
    
    
    @Override
    public List<Employee> showAllByNameAndDepartmentId(String name, int departmentId) throws ClassNotFoundException, SQLException {
        connection.open();
        List<Employee> employeeList = new ArrayList<Employee>();
        String sql="SELECT e.emp_id, e.name as emp_name, e.email, e.address, e.gender, e.position, e.salary, e.dept_id, d.name as dept_name FROM employee e INNER JOIN department d ON e.dept_id = d.dept_id WHERE e.name LIKE '%"+name+"%' AND d.dept_id="+departmentId+" ORDER BY e.position";
        ResultSet rs = connection.executeQuery(sql);
        while(rs.next()){
            Employee employee = new Employee();
            employee.setEmpId(rs.getInt("emp_id"));
            employee.setName(rs.getString("emp_name"));
            employee.setAddress(rs.getString("address"));
            employee.setEmail(rs.getString("email"));
            employee.setGender(rs.getString("gender"));
            employee.setPosition(rs.getString("position"));
            employee.setSalary(rs.getDouble("salary"));
            employee.setDeptId(rs.getInt("dept_id"));
            Department department = new Department();
            department.setName(rs.getString("dept_name"));
            employee.setDepartment(department);
            employeeList.add(employee);
        }
        connection.close();
        return employeeList;
    }
    

    @Override
    public Employee getEmployeeWithPosition(String position, int deptId) throws ClassNotFoundException, SQLException {
        connection.open();
        Employee employee = null;
        String sql="SELECT * FROM employee WHERE dept_id="+deptId+" AND position='"+position+"'";
        ResultSet rs = connection.executeQuery(sql);
        while(rs.next()){
            employee = new Employee();
            employee.setEmpId(rs.getInt("emp_id"));
            employee.setName(rs.getString("name"));
            employee.setAddress(rs.getString("address"));
            employee.setEmail(rs.getString("email"));
            employee.setGender(rs.getString("gender"));
            employee.setPosition(rs.getString("position"));
            employee.setSalary(rs.getDouble("salary"));
            employee.setDeptId(rs.getInt("dept_id"));
        }
        connection.close();
        return employee;
    }
    
    

    @Override
    public List<Employee> searchByDepartmentId(int deptId) throws ClassNotFoundException, SQLException {
        connection.open();
        List<Employee> employeeList = new ArrayList<Employee>();
        String sql="SELECT name, email, position FROM employee WHERE dept_id = "+deptId+" ORDER BY emp_id DESC";
        ResultSet rs = connection.executeQuery(sql);
        while(rs.next()){
            Employee employee = new Employee();
            employee.setName(rs.getString("name"));
            employee.setEmail(rs.getString("email"));
            employee.setPosition(rs.getString("position"));
            employeeList.add(employee);
        }
        connection.close();
        return employeeList;
    }

    @Override
    public List<Employee> searchByAny(String param) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
