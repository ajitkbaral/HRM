/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajitkbaral.hrm.controller.emp;

import com.ajitkbaral.hrm.dao.DepartmentDAO;
import com.ajitkbaral.hrm.dao.impl.DepartmentDAOImpl;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Ajit Kumar Baral
 */
@Controller
@RequestMapping("emp/department")
public class EmpDepartmentController {
    DepartmentDAO departmentDAO = new DepartmentDAOImpl();
    
    @RequestMapping(method = RequestMethod.GET)
    public String department(Model map, HttpServletRequest request) throws ClassNotFoundException, SQLException {
        map.addAttribute("title", "Department");
        map.addAttribute("departments", departmentDAO.showAll());
        return "emp/department";
    }
}
