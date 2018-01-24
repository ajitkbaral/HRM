/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajitkbaral.hrm.enums;

/**
 *
 * @author Ajit Kumar Baral
 */
public enum UserRole {
    HR(1), EMP(2); 
    
    int roleId;
    
    UserRole(int roleId) {
        this.roleId = roleId;
    }
    
    public static int getRoleId(UserRole role) {
        switch (role) {
            case HR:
                return 1;
            case EMP:
                return 2;
            default: 
                return 2;
        }
    } 
}
