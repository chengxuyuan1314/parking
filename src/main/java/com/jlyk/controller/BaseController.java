package com.jlyk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class BaseController {

    @RequestMapping("/index")
    public String toIndex(){
        return "index";
    }

    @RequestMapping("/register")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("/updateCar")
    public String  toUpdateCar() {

        return "updateCar";

    }
    @RequestMapping("/login")
    public String  toLogin() {
        return "login";
    }
    @RequestMapping("/quitLogin")
    public String quitLogin(HttpSession session){
        session.removeAttribute("user");
        return "index";
    }

}
