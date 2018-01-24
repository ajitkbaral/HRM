/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajitkbaral.hrm.entities;

/**
 *
 * @author Ajit Kumar Baral
 */
public class Complaint {
    private Integer complaintId;
    private int byEmpId;
    private int toEmpId;
    private String description;
    private Employee byEmployee;
    private Employee toEmployee;

    public Complaint() {
    }

    public Integer getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Integer complaintId) {
        this.complaintId = complaintId;
    }

    public int getByEmpId() {
        return byEmpId;
    }

    public void setByEmpId(int byEmpId) {
        this.byEmpId = byEmpId;
    }

    public int getToEmpId() {
        return toEmpId;
    }

    public void setToEmpId(int toEmpId) {
        this.toEmpId = toEmpId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getByEmployee() {
        return byEmployee;
    }

    public void setByEmployee(Employee byEmployee) {
        this.byEmployee = byEmployee;
    }

    public Employee getToEmployee() {
        return toEmployee;
    }

    public void setToEmployee(Employee toEmployee) {
        this.toEmployee = toEmployee;
    }

    
    
    @Override
    public String toString() {
        return "Complaint{" + "complaintId=" + complaintId + ", byEmpId=" + byEmpId + ", toEmpId=" + toEmpId + ", description=" + description + '}';
    }
    
}
