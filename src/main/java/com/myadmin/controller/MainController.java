package com.myadmin.controller;

import com.myadmin.dto.Marker;
import com.myadmin.service.MarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    MarkerService markerService;

    @RequestMapping("/")
    public String main(Model model) throws Exception {
        return "index";
    }
    @RequestMapping("/logins")
    public String logins(Model model){
        model.addAttribute("center", "login");
        return "index";
    }
    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("center", "register");
        return "index";
    }
    @RequestMapping("/mapTest")
    public String mapTest(Model model){
        model.addAttribute("center", "mapTest");
        return "index";
    }
}
