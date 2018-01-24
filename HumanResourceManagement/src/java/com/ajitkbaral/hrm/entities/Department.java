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
public class Department {
    private Integer deptId;
    private String name;
    private String type;
    private String description;

    public Department() {
    }

    public Department(Integer deptId, String name, String type, String description) {
        this.deptId = deptId;
        this.name = name;
        this.type = type;
        this.description = description;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Department{" + "deptId=" + deptId + ", name=" + name + ", type=" + type + ", description=" + description + '}';
    }
    
    
}
