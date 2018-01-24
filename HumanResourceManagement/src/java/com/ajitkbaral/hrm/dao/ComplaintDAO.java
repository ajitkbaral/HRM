/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajitkbaral.hrm.dao;

import com.ajitkbaral.hrm.entities.Complaint;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Ajit Kumar Baral
 */
public interface ComplaintDAO {
    public int insert(Complaint t) throws ClassNotFoundException, SQLException;
    public int update(Complaint t, int id) throws ClassNotFoundException, SQLException;
    public List<Complaint> showAll() throws ClassNotFoundException, SQLException;
    public int delete(int id) throws ClassNotFoundException, SQLException ;
    public Complaint searchByid(int id) throws ClassNotFoundException, SQLException;
    public List<Complaint> searchByAny(String param) throws ClassNotFoundException, SQLException;
    public List<Complaint> showAllWithEmployee() throws ClassNotFoundException, SQLException;
}
