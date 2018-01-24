/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajitkbaral.hrm.controller.admin;

import com.ajitkbaral.hrm.dao.DepartmentDAO;
import com.ajitkbaral.hrm.dao.TrainingDAO;
import com.ajitkbaral.hrm.dao.impl.DepartmentDAOImpl;
import com.ajitkbaral.hrm.dao.impl.TrainingDAOImpl;
import com.ajitkbaral.hrm.entities.Department;
import com.ajitkbaral.hrm.entities.Training;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@RequestMapping("admin/training")
public class TrainingController {

    DepartmentDAO departmentDAO = new DepartmentDAOImpl();
    TrainingDAO trainingDAO = new TrainingDAOImpl();

    @RequestMapping(method = RequestMethod.GET)
    public String training(Model map) throws ClassNotFoundException, SQLException {
        map.addAttribute("title", "Training");
        map.addAttribute("trainings", trainingDAO.showAllWithDepartment());
        map.addAttribute("departments", departmentDAO.showAll());
        return "training";
    }

    @RequestMapping(value = "delete={id}", method = RequestMethod.GET)
    public String trainingDelete(@PathVariable(value = "id") int id, Model map) throws ClassNotFoundException, SQLException {
        trainingDAO.delete(id);
        return "redirect:?delete=success";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String trainingUpdate(@PathVariable(value = "id") int id, Model map) throws ClassNotFoundException, SQLException {
        map.addAttribute("title", "Update Training");
        map.addAttribute("training", trainingDAO.searchByidWithDepartment(id));
        map.addAttribute("departments", departmentDAO.showAll());
        return "editTraining";
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String trainingInsert(HttpServletRequest request) throws ClassNotFoundException, SQLException {
        String type = request.getParameter("type");
        String description = request.getParameter("description");
        String startDateString = request.getParameter("start_date");
        String endDateString = request.getParameter("end_date");
        Training training = new Training();
        DateFormat dateForamtter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = dateForamtter.parse(startDateString);
            Date endDate = dateForamtter.parse(endDateString);
            java.sql.Date startDateSQL = new java.sql.Date(startDate.getTime());
            java.sql.Date endDateSQL = new java.sql.Date(endDate.getTime());
            training.setStartDate(startDateSQL);
            training.setEndDate(endDateSQL);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int deptId = Integer.parseInt(request.getParameter("dept_id"));
        training.setDeptId(deptId);
        training.setType(type);
        training.setDescription(description);
        trainingDAO.insert(training);
        return "redirect:?insert=success";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    public String trainingUpdate(@PathVariable(value = "id") int id, HttpServletRequest request) throws ClassNotFoundException, SQLException {
        String type = request.getParameter("type");
        String description = request.getParameter("description");
        String startDateString = request.getParameter("start_date");
        String endDateString = request.getParameter("end_date");
        System.out.println(startDateString + endDateString);
        Training training = new Training();
        DateFormat dateForamtter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = dateForamtter.parse(startDateString);
            Date endDate = dateForamtter.parse(endDateString);
            java.sql.Date startDateSQL = new java.sql.Date(startDate.getTime());
            java.sql.Date endDateSQL = new java.sql.Date(endDate.getTime());
            training.setStartDate(startDateSQL);
            training.setEndDate(endDateSQL);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int deptId = Integer.parseInt(request.getParameter("dept_id"));
        training.setDeptId(deptId);
        training.setType(type);
        training.setDescription(description);
        trainingDAO.update(training, id);
        return "redirect:/admin/training/" + id + "?update=success";
    }
}
