package com.wxj.loginAndResign.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wxj.loginAndResign.entity.User;
import com.wxj.loginAndResign.service.LoginAndResignService;


@Controller
@RequestMapping("/loginAndResign")
public class LARController {
  @Autowired
  LoginAndResignService service;
	
	/*********************************注册相关部分*******************************************/
  /*
   * 注册方法
   */
	@RequestMapping("/resign.do")
	@ResponseBody
	public void resign(User user,HttpServletResponse resp) throws IOException{
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		String message;
    	message = service.resign(user);
		//return message;
    	//resp.getWriter().print(message);//两个都可以
    	resp.getWriter().write(message);
	}
	
	/*
	 * 注册时检查用户名是否已经存在
	 */
	@RequestMapping("/checkExist.do")
	@ResponseBody
	public String checkExist(String userName){
		String res = "";
		res = service.checkExist(userName);
		return res;
	}
	
	/*
	 * 身份信息是否被占用
	 */
	
	/*
	 * 邮箱是否已经被占用
	 */
	
	/*********************************登录相关部分*********************************************/
	
	/*
	 * 用户登录
	 * 
	 * 暂时不考虑验证码部分
	 */
	@RequestMapping("/login")
	public void login(String userName,String password,HttpServletResponse resp) throws IOException{
		//调用登录方法
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		String res = "";
		res = service.login(userName,password);
		
		resp.getWriter().write(res);
		
		
		
	}
	
	
	
	
	
	
}
