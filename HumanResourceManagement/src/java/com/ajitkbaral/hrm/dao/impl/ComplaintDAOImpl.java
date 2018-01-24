/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajitkbaral.hrm.dao.impl;

import com.ajitkbaral.hrm.dao.ComplaintDAO;
import com.ajitkbaral.hrm.entities.Complaint;
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
public class ComplaintDAOImpl implements ComplaintDAO {

    private DBConnection connection;

    public ComplaintDAOImpl() {
        try {
            connection = new DBConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComplaintDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int insert(Complaint t) throws ClassNotFoundException, SQLException {
        connection.open();
        String sql = "INSERT INTO complaint (by_emp_id, to_emp_id, description) VALUES";
        sql += "(" + t.getByEmpId() + "," + t.getToEmpId()+ ",'" + t.getDescription() + "')";
        int insert = connection.executeUpdate(sql);
        connection.close();
        return insert;
    }

    @Override
    public int update(Complaint t, int id) throws ClassNotFoundException, SQLException {
        connection.open();
        String sql="UPDATE complaint SET by_emp_id="+t.getByEmpId()+", to_emp_id="+t.getToEmpId()+",description='"+t.getDescription()+"' WHERE complaint_id = "+id;
        int update = connection.executeUpdate(sql);
        connection.close();
        return update;
    }

    @Override
    public List<Complaint> showAll() throws ClassNotFoundException, SQLException {
         connection.open();
        List<Complaint> complaintList = new ArrayList<Complaint>();
        String sql="SELECT * FROM complaint";
        ResultSet rs = connection.executeQuery(sql);
        while(rs.next()){
            Complaint complaint = new Complaint();
            complaint.setComplaintId(rs.getInt("complaint_id"));
            complaint.setByEmpId(rs.getInt("by_emp_id"));
            complaint.setToEmpId(rs.getInt("to_emp_id"));
            complaint.setDescription(rs.getString("description"));
            complaintList.add(complaint);
        }
        connection.close();
        return complaintList;
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Complaint searchByid(int id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public List<Complaint> showAllWithEmployee() throws ClassNotFoundException, SQLException {
        connection.open();
        List<Complaint> complaintList = new ArrayList<Complaint>();
        String sql="SELECT c.complaint_id, c.description, e_by.emp_id as eById, e_by.name as eByName, e_to.emp_id as eToId, e_to.name as eToName FROM complaint c INNER JOIN employee e_by ON c.by_emp_id = e_by.emp_id INNER JOIN employee e_to ON c.to_emp_id = e_to.emp_id ORDER BY c.complaint_id DESC";
        ResultSet rs = connection.executeQuery(sql);
        while(rs.next()){
            Complaint complaint = new Complaint();
            complaint.setComplaintId(rs.getInt("complaint_id"));
            complaint.setByEmpId(rs.getInt("eById"));
            complaint.setToEmpId(rs.getInt("eToId"));
            complaint.setDescription(rs.getString("description"));
            Employee byEmployee = new Employee();
            byEmployee.setName(rs.getString("eByName"));
            Employee toEmployee = new Employee();
            toEmployee.setName(rs.getString("eToName"));
            complaint.setByEmployee(byEmployee);
            complaint.setToEmployee(toEmployee);
            complaintList.add(complaint);
        }
        connection.close();
        return complaintList;
    }

    @Override
    public List<Complaint> searchByAny(String param) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
