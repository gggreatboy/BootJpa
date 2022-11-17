package com.example.demo.controller;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.User;
import com.example.demo.entity.MultiFileDomain;
import com.example.demo.entity.NativePlace;
import com.example.demo.service.NpandUserService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class RegisterController {
    @Autowired
    NpandUserService userService;
	
	/**
     * 注册界面
     * @return
     */
    @RequestMapping("/register")
    public String register(Model model){
    	User usernew=new User();
        model.addAttribute("usernew", usernew);
        List <NativePlace> allNativePlace=userService.findAll();
        model.addAttribute("allNativePlace",allNativePlace);
    	return "register";
    }

    /**
     * 判断是否成功注册
     * @param request
     * @return
     */
    @RequestMapping("/doregister")
    public String register(HttpServletRequest request,@ModelAttribute User usernew,Model model,BindingResult rs,@ModelAttribute MultiFileDomain multiFileDomain){  	
    	String name = usernew.getUsername();
        String password = usernew.getUserpwd();
        String password2 = request.getParameter("password2");
        String nativeplace= request.getParameter("np");
        String favor=usernew.getFavor();
        String desc=usernew.getDescribe();
        String gender=usernew.getGender();
        String realpath =request.getServletContext().getRealPath("/userpic/"); //文件放到哪个目录下
        File targetDir = new File(realpath);
		if(!targetDir.exists()) {
			targetDir.mkdirs();
		}
		MultipartFile file = multiFileDomain.getMyfile();

		String fileName = file.getOriginalFilename();
		log.info(fileName);
		
		String[] split = fileName.split("\\.",2);

		String newfilename=name+"."+split[1];
		log.info(newfilename);
		log.info(realpath);
		File targetFile = new File(realpath,newfilename);
		try {
			file.transferTo(targetFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 保存文件
		finally{
			targetFile=null;
		}
		
        log.info(name);
        log.info(nativeplace);
        log.info(favor);
        log.info(desc);
        log.info(gender);
        List<User> userList =  userService.findUserByUsername(name,"id");
        if(userList.size() == 0 && password.equals(password2)){
            User user = new User();
            NativePlace nativeplac=userService.findNativePlaceByNativeplace(nativeplace);
            
            user.setNativeplace(nativeplac);
            user.setDescribe(desc);
            user.setFavor(favor);
            user.setGender(gender);
            user.setUsername(name);
            user.setUserpwd(password);
            user.setPicname(newfilename);
            userService.saveUser(user);
            model.addAttribute("regname", name);

            return "login";
        }else{
            return "redirect:register";
        }
        
    }
	
}
