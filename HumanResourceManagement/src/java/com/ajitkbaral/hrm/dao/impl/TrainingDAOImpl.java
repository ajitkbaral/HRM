/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajitkbaral.hrm.dao.impl;

import com.ajitkbaral.hrm.dao.TrainingDAO;
import com.ajitkbaral.hrm.entities.Department;
import com.ajitkbaral.hrm.entities.Training;
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
public class TrainingDAOImpl implements TrainingDAO{
    
    private DBConnection connection;

    public TrainingDAOImpl(){
        try {
            connection = new DBConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TrainingDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public int insert(Training e) throws SQLException {
        connection.open();
        String sql = "INSERT INTO training (type, description, start_date, end_date, dept_id) VALUES";
        sql+="('"+e.getType()+"','"+e.getDescription()+"','"+e.getStartDate()+"','"+e.getEndDate()+"','"+e.getDeptId()+"')";
        int insert = connection.executeUpdate(sql);
        connection.close();
        return insert;
                
    }

    @Override
    public int update(Training e, int id) throws ClassNotFoundException, SQLException {
        connection.open();
        String sql="UPDATE training SET type='"+e.getType()+"',description='"+e.getDescription()+"', start_date='"+e.getStartDate()+"',end_date='"+e.getEndDate()+"', dept_id="+e.getDeptId()+" WHERE tra_id = "+id;
        int update = connection.executeUpdate(sql);
        connection.close();
        return update;
    }

    @Override
    public List<Training> showAll() throws ClassNotFoundException, SQLException {
        connection.open();
        List<Training> trainingList = new ArrayList<Training>();
        String sql="SELECT * FROM training";
        ResultSet rs = connection.executeQuery(sql);
        while(rs.next()){
            Training training = new Training();
            training.setTraId(rs.getInt("tra_id"));
            training.setType(rs.getString("type"));
            training.setDescription(rs.getString("description"));
            training.setStartDate(rs.getDate("start_date"));
            training.setEndDate(rs.getDate("end_date"));
            training.setDeptId(rs.getInt("dept_id"));
            trainingList.add(training);
        }
        connection.close();
        return trainingList;
    }
    
    @Override
    public List<Training> showAllWithDepartment() throws ClassNotFoundException, SQLException {
        connection.open();
        List<Training> trainingList = new ArrayList<Training>();
        String sql="SELECT t.tra_id, t.type, t.description, t.start_date, t.end_date, t.dept_id, d.name as dept_name FROM training t INNER JOIN department d ON t.dept_id = d.dept_id";
        ResultSet rs = connection.executeQuery(sql);
        while(rs.next()){
            Training training = new Training();
            training.setTraId(rs.getInt("tra_id"));
            training.setType(rs.getString("type"));
            training.setDescription(rs.getString("description"));
            training.setStartDate(rs.getDate("start_date"));
            training.setEndDate(rs.getDate("end_date"));
            training.setDeptId(rs.getInt("dept_id"));
            Department department = new Department();
            department.setName(rs.getString("dept_name"));
            training.setDepartment(department);
            trainingList.add(training);
        }
        connection.close();
        return trainingList;
    }
    
    @Override
    public List<Training> showAllWithDepartment(int limit) throws ClassNotFoundException, SQLException {
        connection.open();
        List<Training> trainingList = new ArrayList<Training>();
        String sql="SELECT t.tra_id, t.type, t.description, t.start_date, t.end_date, t.dept_id, d.name as dept_name FROM training t INNER JOIN department d ON t.dept_id = d.dept_id ORDER BY t.tra_id DESC LIMIT "+limit;
        ResultSet rs = connection.executeQuery(sql);
        while(rs.next()){
            Training training = new Training();
            training.setTraId(rs.getInt("tra_id"));
            training.setType(rs.getString("type"));
            training.setDescription(rs.getString("description"));
            training.setStartDate(rs.getDate("start_date"));
            training.setEndDate(rs.getDate("end_date"));
            training.setDeptId(rs.getInt("dept_id"));
            Department department = new Department();
            department.setName(rs.getString("dept_name"));
            training.setDepartment(department);
            trainingList.add(training);
        }
        connection.close();
        return trainingList;
    }
    
    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        connection.open();
        String sql="DELETE FROM training WHERE tra_id="+id;
        int delete = connection.executeUpdate(sql);
        connection.close();
        return delete;
    }

    @Override
    public Training searchByid(int id) throws ClassNotFoundException, SQLException {
        connection.open();
        Training training = null;
        String sql="SELECT * FROM training WHERE tra_id="+id;
        ResultSet rs = connection.executeQuery(sql);
        while(rs.next()){
            training = new Training();
            training.setTraId(rs.getInt("tra_id"));
            training.setType(rs.getString("type"));
            training.setDescription(rs.getString("description"));
            training.setStartDate(rs.getDate("start_date"));
            training.setEndDate(rs.getDate("end_date"));
            training.setDeptId(rs.getInt("dept_id"));
        }
        connection.close();
        return training;
    }
    
    @Override
    public Training searchByidWithDepartment(int id) throws ClassNotFoundException, SQLException {
        connection.open();
        Training training = null;
        String sql="SELECT t.tra_id, t.type, t.description, t.start_date, t.end_date, t.dept_id, d.name as dept_name FROM training t INNER JOIN department d ON t.dept_id = d.dept_id WHERE t.tra_id="+id;
        ResultSet rs = connection.executeQuery(sql);
        while(rs.next()){
            training = new Training();
            training.setTraId(rs.getInt("tra_id"));
            training.setType(rs.getString("type"));
            training.setDescription(rs.getString("description"));
            training.setStartDate(rs.getDate("start_date"));
            training.setEndDate(rs.getDate("end_date"));
            training.setDeptId(rs.getInt("dept_id"));
            Department department = new Department();
            department.setName(rs.getString("dept_name"));
            training.setDepartment(department);
        }
        connection.close();
        return training;
    }
    

    @Override
    public List<Training> searchByDeptId(int deptId) throws ClassNotFoundException, SQLException {
        connection.open();
        List<Training> trainingList = new ArrayList<Training>();
        String sql="SELECT * FROM training WHERE dept_id = "+deptId+" ORDER BY tra_id DESC";
        ResultSet rs = connection.executeQuery(sql);
        while(rs.next()){
            Training training = new Training();
            training.setTraId(rs.getInt("tra_id"));
            training.setType(rs.getString("type"));
            training.setDescription(rs.getString("description"));
            training.setStartDate(rs.getDate("start_date"));
            training.setEndDate(rs.getDate("end_date"));
            training.setDeptId(rs.getInt("dept_id"));
//            Department department = new Department();
//            department.setName(rs.getString("dept_name"));
//            training.setDepartment(department);
            trainingList.add(training);
        }
        connection.close();
        return trainingList;
    }

    @Override
    public List<Training> searchByAny(String param) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
