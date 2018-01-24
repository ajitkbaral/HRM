/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajitkbaral.hrm.controller.admin;

import com.ajitkbaral.hrm.dao.DepartmentDAO;
import com.ajitkbaral.hrm.dao.EmployeeDAO;
import com.ajitkbaral.hrm.dao.EmployeeDAO;
import com.ajitkbaral.hrm.dao.impl.DepartmentDAOImpl;
import com.ajitkbaral.hrm.dao.impl.EmployeeDAOImpl;
import com.ajitkbaral.hrm.dao.impl.EmployeeDAOImpl;
import com.ajitkbaral.hrm.entities.Employee;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Ajit Kumar Baral
 */
@Controller
@RequestMapping("admin/employee")
public class EmployeeController {

    DepartmentDAO departmentDAO = new DepartmentDAOImpl();
    EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @RequestMapping(method = RequestMethod.GET)
    public String employee(Model map, HttpServletRequest request) throws ClassNotFoundException, SQLException {
        map.addAttribute("title", "Employee");
        map.addAttribute("departments", departmentDAO.showAll());
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

        return "employee";
    }

    @RequestMapping(value = "delete={id}", method = RequestMethod.GET)
    public String employeetDelete(@PathVariable(value = "id") int id, Model map) throws ClassNotFoundException, SQLException {
        employeeDAO.delete(id);
        return "redirect:?delete=success";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String employeeUpdate(@PathVariable(value = "id") int id, Model map) throws ClassNotFoundException, SQLException {
        map.addAttribute("title", "Update Employee");
        map.addAttribute("employee", employeeDAO.searchByidWithDepartment(id));
        map.addAttribute("departments", departmentDAO.showAll());
        return "editEmployee";
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String employeeInsert(HttpServletRequest request) throws ClassNotFoundException, SQLException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        String position = request.getParameter("position");
        double salary = Double.parseDouble(request.getParameter("salary"));
        int deptId = Integer.parseInt(request.getParameter("dept_id"));
        Employee employee = new Employee();
        employee.setName(name);
        employee.setAddress(address);
        employee.setEmail(email);
        employee.setGender(gender);
        employee.setPosition(position);
        employee.setSalary(salary);
        employee.setDeptId(deptId);
        if (position.equals("Head Of Department")) {
            Employee departmentHead = employeeDAO.getEmployeeWithPosition(position, deptId);
            if (departmentHead != null) {
                departmentHead.setPosition("Staff");
                employeeDAO.update(departmentHead, departmentHead.getEmpId());
            }
        }
        employeeDAO.insert(employee);
        return "redirect:?insert=success";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    public String employeeInsert(@PathVariable(value = "id") int id, HttpServletRequest request) throws ClassNotFoundException, SQLException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        String position = request.getParameter("position");
        double salary = Double.parseDouble(request.getParameter("salary"));
        int deptId = Integer.parseInt(request.getParameter("dept_id"));
        Employee employee = new Employee();
        employee.setEmpId(id);
        employee.setName(name);
        employee.setAddress(address);
        employee.setEmail(email);
        employee.setGender(gender);
        employee.setPosition(position);
        employee.setSalary(salary);
        employee.setDeptId(deptId);
        if (position.equals("Head Of Department")) {
            Employee departmentHead = employeeDAO.getEmployeeWithPosition(position, deptId);
            if (departmentHead != null) {
                departmentHead.setPosition("Staff");
                employeeDAO.update(departmentHead, departmentHead.getEmpId());
            }
        }
        employeeDAO.update(employee, id);
        return "redirect:/admin/employee/" + id + "?update=success";
    }
}
