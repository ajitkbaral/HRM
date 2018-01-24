/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajitkbaral.hrm.controller.emp;

import com.ajitkbaral.hrm.dao.EmployeeDAO;
import com.ajitkbaral.hrm.dao.UserDAO;
import com.ajitkbaral.hrm.dao.impl.EmployeeDAOImpl;
import com.ajitkbaral.hrm.dao.impl.UserDAOImpl;
import com.ajitkbaral.hrm.entities.Employee;
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
@RequestMapping("emp/settings")
public class EmpSettingsController {
    UserDAO userDAO = new UserDAOImpl();
    EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @RequestMapping(method = RequestMethod.GET)
    public String settings(Model map) {
        map.addAttribute("title", "Settings");
        return "emp/settings";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String settingsUpdate(HttpServletRequest request) throws ClassNotFoundException, SQLException {
        User user = (User) request.getSession().getAttribute("user");
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        Employee employee = user.getEmployee();
        employee.setName(name);
        employee.setEmail(email);
        if (username.equals(user.getUsername())) {
            if (!password.isEmpty()) {

                user.setPassword(password);
            }
            employeeDAO.update(employee, user.getEmpId());
            userDAO.update(user, user.getUserId());
            return "redirect:/emp/settings?update=success";
        } else if (!userDAO.checkUserName(username)) {
            user.setUsername(username);
            if (!password.isEmpty()) {

                user.setPassword(password);
            }
            employeeDAO.update(employee, user.getEmpId());
            userDAO.update(user, user.getUserId());
            return "redirect:/emp/settings?update=success";
        } else {
            return "redirect:/emp/settings?update=false&message=Username already exists. Please choose another username.";
        }

    }
}
