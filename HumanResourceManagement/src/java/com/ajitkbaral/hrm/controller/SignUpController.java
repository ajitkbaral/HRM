/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajitkbaral.hrm.controller;

import com.ajitkbaral.hrm.dao.EmployeeDAO;
import com.ajitkbaral.hrm.dao.RoleDAO;
import com.ajitkbaral.hrm.dao.UserDAO;
import com.ajitkbaral.hrm.dao.impl.EmployeeDAOImpl;
import com.ajitkbaral.hrm.dao.impl.RoleDAOImpl;
import com.ajitkbaral.hrm.dao.impl.UserDAOImpl;
import com.ajitkbaral.hrm.entities.Employee;
import com.ajitkbaral.hrm.entities.User;
import com.ajitkbaral.hrm.enums.UserRole;
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
@RequestMapping("signup")
public class SignUpController {

    private UserDAO userDAO = new UserDAOImpl();
    private RoleDAO roleDAO = new RoleDAOImpl();
    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @RequestMapping(method = RequestMethod.GET)
    public String signUp(Model map) throws ClassNotFoundException, SQLException {
        map.addAttribute("roles", roleDAO.showAll());
        return "signup";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String signUp(HttpServletRequest request) throws ClassNotFoundException, SQLException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int empId = Integer.parseInt(request.getParameter("emp_id"));
        User user = new User();
        if (!userDAO.checkUserName(username)) {
            Employee employee = employeeDAO.searchByidWithDepartment(empId);
            if (employee != null) {
                user.setUsername(username);
                user.setPassword(password);
                user.setEmpId(empId);
                String departmentName = employee.getDepartment().getName().toLowerCase();
                if (departmentName.contains("human resource") || departmentName.contains("hr")) {
                    user.setRoleId(UserRole.getRoleId(UserRole.HR));
                } else {
                    user.setRoleId(UserRole.getRoleId(UserRole.EMP));
                }
                userDAO.insert(user);
                return "redirect:/login?signup=success";
            } else {
                return "redirect:/signup?status=false&title=Employee ID doesnot exist!&message=Please enter correct Employee ID.";
            }
        } else {
            return "redirect:/signup?status=false&title=Username already exists!&message=Username already exists. Please choose another username.";
        }
    }
}
