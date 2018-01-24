/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajitkbaral.hrm.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Ajit Kumar Baral
 */
@Controller
@RequestMapping("signout")
public class SignOutController {
    @RequestMapping(method =RequestMethod.GET)
    public String signout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:login";
    }
}
