/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajitkbaral.hrm.controller.emp;

import com.ajitkbaral.hrm.dao.ComplaintDAO;
import com.ajitkbaral.hrm.dao.EmployeeDAO;
import com.ajitkbaral.hrm.dao.impl.ComplaintDAOImpl;
import com.ajitkbaral.hrm.dao.impl.EmployeeDAOImpl;
import com.ajitkbaral.hrm.entities.Complaint;
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
@RequestMapping("/emp/complaint")
public class EmpComplaintController {

    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();
    private ComplaintDAO complaintDAO = new ComplaintDAOImpl();

    @RequestMapping(method = RequestMethod.GET)
    public String complaint(Model map, HttpServletRequest request) throws ClassNotFoundException, SQLException {
        try {
            int employeeId = Integer.parseInt(request.getParameter("emp_id"));
            map.addAttribute("employee", employeeDAO.searchByid(employeeId));
            return "emp/complaint";
        } catch (NumberFormatException nfe) {
            return "redirect:/emp/dashboard";
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public String complaintPost(Model map, HttpServletRequest request) throws ClassNotFoundException, SQLException {
        int toEmpId = Integer.parseInt(request.getParameter("to_emp_id"));
        User user = (User) request.getSession().getAttribute("user");
        int byEmpId = user.getEmpId();
        String description = request.getParameter("description");
        Complaint complaint = new Complaint();
        complaint.setByEmpId(byEmpId);
        complaint.setToEmpId(toEmpId);
        complaint.setDescription(description);
        complaintDAO.insert(complaint);
        return "redirect:complaint?emp_id="+toEmpId+"&insert=success";
    }
}
