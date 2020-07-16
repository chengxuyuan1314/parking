package com.jlyk.controller;

import com.jlyk.domain.User;
import com.jlyk.service.AuthorityService;
import com.jlyk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityService authorityService;


    @ResponseBody
    @RequestMapping("/findAllUser")
    public List<User> findAllUser(){

        return userService.findAllUser();

    }

    @RequestMapping("/insertUser")
    public ModelAndView insertUser(User user){
        ModelAndView modelAndView = new ModelAndView();

        userService.insertUser(user);
        int idByUsername = userService.findIdByUsername(user.getUsername());
        authorityService.insertAuthority(idByUsername);
        modelAndView.addObject("msg","注册成功，请登录");
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @ResponseBody
    @RequestMapping("/checkUsername")
    public String checkUsername(String username){

        User user = userService.findByUsername(username);

        if (user==null){
            return "该账号可用";
        }


        return "该账号已被使用";


    }
    @RequestMapping("/recharge")
    public ModelAndView recharge(int uid,int money ,int addMoney,HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        userService.updateMoneyByID(uid,money+addMoney);
        User user = userService.findByID(uid);
        session.setAttribute("user",user);
        modelAndView.setViewName("index");
        return modelAndView;
    }


    @RequestMapping("/updateUser")
    public ModelAndView updateUser(User user, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        userService.updateUserByUsername(user);
        User user1 = userService.findByUsername(user.getUsername());
        session.setAttribute("user",user1);
        modelAndView.setViewName("index");
        return modelAndView;

    }



    @RequestMapping("/loginUser")
    public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password ,HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.findByUsernameAndPassword(username, password);
        if (user==null){
            modelAndView.addObject("msg","账号密码错误");
            modelAndView.setViewName("login");
        }else{
            session.setAttribute("user",user);
            modelAndView.setViewName("index");
        }
        return modelAndView;

    }

}
