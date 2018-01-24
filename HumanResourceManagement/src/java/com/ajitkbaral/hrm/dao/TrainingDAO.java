/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajitkbaral.hrm.dao;

import com.ajitkbaral.hrm.entities.Training;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Ajit Kumar Baral
 */
public interface TrainingDAO {
    public int insert(Training t) throws ClassNotFoundException, SQLException;
    public int update(Training t, int id) throws ClassNotFoundException, SQLException;
    public List<Training> showAll() throws ClassNotFoundException, SQLException;
    public int delete(int id) throws ClassNotFoundException, SQLException ;
    public Training searchByid(int id) throws ClassNotFoundException, SQLException;
    public List<Training> searchByAny(String param) throws ClassNotFoundException, SQLException;
    public Training searchByidWithDepartment(int id) throws ClassNotFoundException, SQLException;
    public List<Training> showAllWithDepartment() throws ClassNotFoundException, SQLException;
    public List<Training> showAllWithDepartment(int limit) throws ClassNotFoundException, SQLException;
    public List<Training> searchByDeptId(int deptId) throws ClassNotFoundException, SQLException;
}
