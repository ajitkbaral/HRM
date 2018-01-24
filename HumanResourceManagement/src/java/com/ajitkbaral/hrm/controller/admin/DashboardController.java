/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajitkbaral.hrm.controller.admin;

import com.ajitkbaral.hrm.dao.DepartmentDAO;
import com.ajitkbaral.hrm.dao.EmployeeDAO;
import com.ajitkbaral.hrm.dao.TrainingDAO;
import com.ajitkbaral.hrm.dao.impl.DepartmentDAOImpl;
import com.ajitkbaral.hrm.dao.impl.EmployeeDAOImpl;
import com.ajitkbaral.hrm.dao.impl.TrainingDAOImpl;
import java.lang.management.ManagementFactory;
import java.sql.SQLException;
import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Ajit Kumar Baral
 */
@Controller
@RequestMapping("admin/dashboard")
public class DashboardController {

    final int limit = 5;

    DepartmentDAO departmentDAO = new DepartmentDAOImpl();
    EmployeeDAO employeeDAO = new EmployeeDAOImpl();
    TrainingDAO trainingDAO = new TrainingDAOImpl();

    @RequestMapping(method = RequestMethod.GET)
    public String dashboard(Model map) throws ClassNotFoundException, SQLException, Exception {
        map.addAttribute("title", "Dashboard");
        map.addAttribute("traffic", getProcessCpuLoad());
        map.addAttribute("trainings", trainingDAO.showAll().size());
        map.addAttribute("departments", departmentDAO.showAll().size());
        map.addAttribute("employees", employeeDAO.showAll().size());
        map.addAttribute("recentTrainings", trainingDAO.showAllWithDepartment(limit));
        map.addAttribute("recentEmployees", employeeDAO.showAllWithDepartment(limit));
        map.addAttribute("recentDepartments", departmentDAO.showAll(limit));
        return "dashboard";
    }

    public static double getProcessCpuLoad() throws Exception {

        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = ObjectName.getInstance("java.lang:type=OperatingSystem");
        AttributeList list = mbs.getAttributes(name, new String[]{"ProcessCpuLoad"});

        if (list.isEmpty()) {
            return Double.NaN;
        }

        Attribute att = (Attribute) list.get(0);
        Double value = (Double) att.getValue();

        // usually takes a couple of seconds before we get real values
        if (value == -1.0) {
            return Double.NaN;
        }
        // returns a percentage value with 1 decimal point precision
        return ((int) (value * 1000) / 10.0);
    }
}
