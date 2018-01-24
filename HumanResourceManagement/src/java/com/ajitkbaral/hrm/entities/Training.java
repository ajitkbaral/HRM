/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajitkbaral.hrm.entities;

import java.util.Date;

/**
 *
 * @author Ajit Kumar Baral
 */
public class Training {
    private Integer traId;
    private String type;
    private String description;
    private Date startDate;
    private Date endDate;
    private int deptId;
    private Department department;

    public Training() {
    }

    public Training(Integer traId, String type, String description, Date startDate, Date endDate) {
        this.traId = traId;
        this.type = type;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getTraId() {
        return traId;
    }

    public void setTraId(Integer traId) {
        this.traId = traId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    
    

    @Override
    public String toString() {
        return "Training{" + "traId=" + traId + ", type=" + type + ", description=" + description + ", startDate=" + startDate + ", endDate=" + endDate + '}';
    }
    
    
}
