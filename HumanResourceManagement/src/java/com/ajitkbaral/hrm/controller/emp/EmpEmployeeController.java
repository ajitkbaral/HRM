/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajitkbaral.hrm.controller.emp;

import com.ajitkbaral.hrm.dao.DepartmentDAO;
import com.ajitkbaral.hrm.dao.EmployeeDAO;
import com.ajitkbaral.hrm.dao.impl.DepartmentDAOImpl;
import com.ajitkbaral.hrm.dao.impl.EmployeeDAOImpl;
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
@RequestMapping("emp/employee")
public class EmpEmployeeController {
    
    EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @RequestMapping(method = RequestMethod.GET)
    public String employee(Model map, HttpServletRequest request) throws ClassNotFoundException, SQLException {
        map.addAttribute("title", "List of Employees");
        if (request.getParameter("name") != null && request.getParameter("dept_id") != null) {
            if (!request.getParameter("name").isEmpty() && !request.getParameter("dept_id").isEmpty()) {
                String name = request.getParameter("name");
                try {
                    int departmentId = Integer.parseInt(request.getParameter("dept_id"));

                    System.out.println(name + departmentId);
                    map.addAttribute("employees", employeeDAO.showAllByNameAndDepartmentId(name, departmentId));
                } catch (NumberFormatException exp) {
                    map.addAttribute("employees", employeeDAO.showAllWithDepartment());
                    exp.printStackTrace();
                }
            } else {
                map.addAttribute("employees", employeeDAO.showAllWithDepartment());
            }
        } else if (request.getParameter("name") != null) {
            if (!request.getParameter("name").isEmpty()) {
                map.addAttribute("employees", employeeDAO.showByName(request.getParameter("name")));
            }
        } else if (request.getParameter("dept_id") != null) {
            if (!request.getParameter("dept_id").isEmpty()) {
                try {
                    int departmentId = Integer.parseInt(request.getParameter("dept_id"));
                    map.addAttribute("employees", employeeDAO.showAllByDepartmentId(departmentId));
                } catch (NumberFormatException exp) {
                    map.addAttribute("employees", employeeDAO.showAllWithDepartment());
                    exp.printStackTrace();
                }
            }
        } else {
            map.addAttribute("employees", employeeDAO.showAllWithDepartment());
        }

        return "emp/employee";
    }
    
}
