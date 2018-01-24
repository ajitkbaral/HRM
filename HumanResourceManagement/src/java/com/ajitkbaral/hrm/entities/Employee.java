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
public class Employee {
    private Integer empId;
    private String name;
    private String email;
    private String address;
    private String gender;
    private String position;
    private int deptId;
    private Department department;
    private double salary;

    public Employee() {
    }

    public Employee(Integer empId, String name, String email, String address, String gender, String position, int deptId, Department department, double salary) {
        this.empId = empId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.position = position;
        this.deptId = deptId;
        this.department = department;
        this.salary = salary;
    }

    

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "empId=" + empId + ", name=" + name + ", email=" + email + ", address=" + address + ", gender=" + gender + ", position=" + position + ", deptId=" + deptId + ", department=" + department + ", salary=" + salary + '}';
    }
    
    
    
    
    

    
    
}
