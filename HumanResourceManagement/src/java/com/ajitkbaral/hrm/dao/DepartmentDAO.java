/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajitkbaral.hrm.dao;

import com.ajitkbaral.hrm.entities.Department;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Ajit Kumar Baral
 */
public interface DepartmentDAO {
    public int insert(Department d) throws ClassNotFoundException, SQLException;
    public int update(Department d, int id) throws ClassNotFoundException, SQLException;
    public List<Department> showAll() throws ClassNotFoundException, SQLException;
    public int delete(int id) throws ClassNotFoundException, SQLException ;
    public Department searchByid(int id) throws ClassNotFoundException, SQLException;
    public List<Department> searchByAny(String param) throws ClassNotFoundException, SQLException;
    public List<Department> showAll(int limit) throws ClassNotFoundException, SQLException;
}
