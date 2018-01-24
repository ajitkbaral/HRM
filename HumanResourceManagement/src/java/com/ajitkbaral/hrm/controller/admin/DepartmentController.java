/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajitkbaral.hrm.controller.admin;

import com.ajitkbaral.hrm.dao.DepartmentDAO;
import com.ajitkbaral.hrm.dao.impl.DepartmentDAOImpl;
import com.ajitkbaral.hrm.entities.Department;
import java.sql.SQLException;
import java.text.ParseException;
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
@RequestMapping("admin/department")
public class DepartmentController {
    
    DepartmentDAO departmentDAO = new DepartmentDAOImpl();
    
    @RequestMapping(method = RequestMethod.GET)
    public String department(Model map, HttpServletRequest request) throws ClassNotFoundException, SQLException {
        map.addAttribute("title", "Department");
        map.addAttribute("departments", departmentDAO.showAll());
        return "department";
    }
    
    @RequestMapping(value="delete={id}", method = RequestMethod.GET)
    public String departmentDelete(@PathVariable(value = "id")int id, Model map) throws ClassNotFoundException, SQLException {
        departmentDAO.delete(id);
        return "redirect:?delete=success";
    }
    
    @RequestMapping(value="{id}", method = RequestMethod.GET)
    public String departmentUpdate(@PathVariable(value = "id")int id, Model map) throws ClassNotFoundException, SQLException {
        map.addAttribute("title", "Update Department");
        map.addAttribute("department", departmentDAO.searchByid(id));
        return "editDepartment";
    }
    
    @RequestMapping(value="insert", method = RequestMethod.POST)
    public String departmentInsert(HttpServletRequest request) throws ClassNotFoundException, SQLException {
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String description = request.getParameter("description");
        Department department = new Department();
        department.setName(name);
        department.setType(type);
        department.setDescription(description);
        departmentDAO.insert(department);
        return "redirect:?insert=success";
    }
    
    @RequestMapping(value="update/{id}", method = RequestMethod.POST)
    public String departmentInsert(@PathVariable(value = "id") int id, HttpServletRequest request) throws ClassNotFoundException, SQLException {
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String description = request.getParameter("description");
        Department department = new Department();
        department.setDeptId(id);
        department.setName(name);
        department.setType(type);
        department.setDescription(description);
        departmentDAO.update(department, id);
        return "redirect:/admin/department/"+id+"?update=success";
    }
}
