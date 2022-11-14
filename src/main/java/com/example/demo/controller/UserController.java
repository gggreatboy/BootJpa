package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.User;
import com.example.demo.entity.NativePlace;
import com.example.demo.service.NpandUserService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class UserController {

    @Autowired
    NpandUserService userService;

    /**
     * 登录界面
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 判断能否成功登录
     * @param request
     * @return
     */
    @RequestMapping("/dologin")
    public String login(HttpServletRequest request,Model model){
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        log.info(name,password);
        User user = userService.findUserByusernameAnduserpwd(name, password);
        if(user != null){
            return "usermain";
        }else{
            return "login";
        }
    }

    /**
     * 注册界面
     * @return
     */
    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    /**
     * 判断是否成功注册
     * @param request
     * @return
     */
    @RequestMapping("/doregister")
    public String register(HttpServletRequest request){
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String nativeplace= request.getParameter("nativeplace");
        log.info(name,password,nativeplace);
        List<User> userList =  userService.findUserByusername(name);
        if(userList.size() == 0 && password.equals(password2)){
            User user = new User();
            userService.insertausertoplace(nativeplace);
            user.setUsername(name);
            user.setUserpwd(password);
            
            userService.saveUser(user);
            return "login";
        }else{
            return "register";
        }
    }
}
