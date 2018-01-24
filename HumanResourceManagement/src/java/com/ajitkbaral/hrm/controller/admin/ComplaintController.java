/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajitkbaral.hrm.controller.admin;

import com.ajitkbaral.hrm.dao.ComplaintDAO;
import com.ajitkbaral.hrm.dao.impl.ComplaintDAOImpl;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Ajit Kumar Baral
 */
@Controller
@RequestMapping("/admin/complaint")
public class ComplaintController {
    
    private ComplaintDAO complaintDAO = new ComplaintDAOImpl();
    
    @RequestMapping(method = RequestMethod.GET)
    public String complaint(Model map) throws ClassNotFoundException, SQLException {
        map.addAttribute("title", "Complaints");
        map.addAttribute("complaints", complaintDAO.showAllWithEmployee());
        return "complaint";
    }
}
