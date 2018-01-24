/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajitkbaral.hrm.controller.emp;

import com.ajitkbaral.hrm.dao.DepartmentDAO;
import com.ajitkbaral.hrm.dao.TrainingDAO;
import com.ajitkbaral.hrm.dao.impl.DepartmentDAOImpl;
import com.ajitkbaral.hrm.dao.impl.TrainingDAOImpl;
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
@RequestMapping("emp/training")
public class EmpTrainingController {
    
    TrainingDAO trainingDAO = new TrainingDAOImpl();

    @RequestMapping(method = RequestMethod.GET)
    public String training(Model map) throws ClassNotFoundException, SQLException {
        map.addAttribute("title", "All Training");
        map.addAttribute("trainings", trainingDAO.showAllWithDepartment());
        return "emp/training";
    }
}
