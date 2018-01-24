/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajitkbaral.hrm.controller.emp;

import com.ajitkbaral.hrm.dao.EmployeeDAO;
import com.ajitkbaral.hrm.dao.TrainingDAO;
import com.ajitkbaral.hrm.dao.impl.EmployeeDAOImpl;
import com.ajitkbaral.hrm.dao.impl.TrainingDAOImpl;
import com.ajitkbaral.hrm.entities.User;
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
@RequestMapping("/emp/dashboard")
public class EmpDashboardController {
    
    private TrainingDAO trainingDAO = new TrainingDAOImpl();
    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();
    
    @RequestMapping(method = RequestMethod.GET)
    public String dashboard(Model map, HttpServletRequest request) throws ClassNotFoundException, SQLException {
        User user = (User) request.getSession().getAttribute("user");
        int deptId = user.getEmployee().getDeptId();
        map.addAttribute("title", "Dashboard");
        map.addAttribute("trainings", trainingDAO.searchByDeptId(deptId));
        map.addAttribute("employees", employeeDAO.searchByDepartmentId(deptId));
        return "emp/dashboard";
    }
}
