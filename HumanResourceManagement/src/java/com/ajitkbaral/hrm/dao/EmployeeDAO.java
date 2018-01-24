/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajitkbaral.hrm.dao;

import com.ajitkbaral.hrm.entities.Employee;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Ajit Kumar Baral
 */
public interface EmployeeDAO {
    public int insert(Employee e) throws ClassNotFoundException, SQLException;
    public int update(Employee e, int id) throws ClassNotFoundException, SQLException;
    public List<Employee> showAll() throws ClassNotFoundException, SQLException;
    public int delete(int id) throws ClassNotFoundException, SQLException ;
    public Employee searchByid(int id) throws ClassNotFoundException, SQLException;
    public List<Employee> searchByAny(String param) throws ClassNotFoundException, SQLException;
    public List<Employee> showAllWithDepartment() throws ClassNotFoundException, SQLException;
    public Employee searchByidWithDepartment(int id) throws ClassNotFoundException, SQLException;
    public List<Employee> showAllWithDepartment(int limit) throws ClassNotFoundException, SQLException;
    public List<Employee> showAllByDepartmentId(int departmentId) throws ClassNotFoundException, SQLException;
    public List<Employee> showByName(String name) throws ClassNotFoundException, SQLException ;
    public List<Employee> showAllByNameAndDepartmentId(String name, int departmentId) throws ClassNotFoundException, SQLException;
    public Employee getEmployeeWithPosition(String position, int deptId) throws ClassNotFoundException, SQLException;
    public List<Employee> searchByDepartmentId(int deptId) throws ClassNotFoundException, SQLException;
}
