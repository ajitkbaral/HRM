/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajitkbaral.hrm.controller;

import com.ajitkbaral.hrm.dao.UserDAO;
import com.ajitkbaral.hrm.dao.impl.UserDAOImpl;
import com.ajitkbaral.hrm.entities.User;
import com.ajitkbaral.hrm.enums.UserRole;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Ajit Kumar Baral
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    UserDAO userDAO;

    public LoginController() throws ClassNotFoundException, SQLException {
        this.userDAO = new UserDAOImpl();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String loginToDashboard(HttpServletRequest request) throws ClassNotFoundException, SQLException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userDAO.searchByUsernameAndPassword(username, password);
        if (user == null) {
            return "redirect:/login?success=false";
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            if (user.getRoleId() == UserRole.getRoleId(UserRole.HR)) {
                return "redirect:/admin/dashboard";
            }else {
                return "redirect:/emp/dashboard";
            }
        }
    }

}
