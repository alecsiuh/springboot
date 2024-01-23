package com.example.programming_project.controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class LoginController {
    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @GetMapping("/register")
    public ModelAndView register() {
        var mav = new ModelAndView();
        mav.setViewName("register");
        return mav;
    }
}
