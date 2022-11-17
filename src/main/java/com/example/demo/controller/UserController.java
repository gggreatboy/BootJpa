package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.demo.entity.User;

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
    public String login(Model model){
    	String regname=(String) model.getAttribute("regname");
    	if(null==regname) {
    		User user=new User();
    		user.setUsername("2020b34039");
    		model.addAttribute("user", user);}
    	else {
    		User user=new User();
            user.setUsername(regname);
            model.addAttribute("user", user);	
    	}
    	
    	return "login";
    }

    /**
     * 判断能否成功登录
     * @param request
     * @return
     */
    @RequestMapping("/dologin")
    public String login(@ModelAttribute User user,Model model,HttpSession session){

    	String name = user.getUsername();
        String password = user.getUserpwd();

        log.info(name);
        User user1 = userService.findUserByusernameAnduserpwd(name, password);
        if(user1 != null){
        	session.setAttribute("usernamenow",user1.getUsername());
        	return "forward:/findAllUser";
        }else{
        	model.addAttribute("usernameerror",name);
        	
            return "login";
        }
    }
    
    @RequestMapping("/findAllUser")
    public String findAllUser(Integer page,Model model,HttpSession session) {
    	String usernamenow=(String) session.getAttribute("usernamenow");
    	log.info(usernamenow);
    	return userService.findAllUserByPage(page,model);
    	
    	
    }

    
}
