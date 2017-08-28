package com.wxj.IM.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.testng.log4testng.Logger;

import com.wxj.IM.service.LoginAndResginServer;

@Controller
@RequestMapping("/loginAndResign")
@SuppressWarnings("unchecked")
public class LoginAndResign {
	@Autowired
	LoginAndResginServer LRServer;
	
  Logger logger=Logger.getLogger(LoginAndResign.class);
	@RequestMapping("/login.do")
	public String login(String account,String password){
		logger.info("---------进入登陆模块----------");
	
		@SuppressWarnings("rawtypes")
		Map map=new HashMap();
		map.put("account", account);
		map.put("password", password);
		
		int res=LRServer.login(map);
		if(res==0){
			return "login";
		}else{
			return"success";
		}
	}
	
	@RequestMapping("/resign.do")
	@SuppressWarnings("rawtypes")
	public String login(HttpServletRequest req,HttpServletResponse resp){
		System.out.println("123");
		logger.info("---------进入注册模块-----------");
	   String account =req.getParameter("account");
	   String pw=req.getParameter("password");
	   String nickName=req.getParameter("nickName");
	   String gender  =req.getParameter("gender");
	   String idCard  =req.getParameter("idCard");
	   String tel     =req.getParameter("tel");
	   String address =req.getParameter("address");
	   
	   //对原始密码进行加密使用MD5加密
	  String password=DigestUtils.md5DigestAsHex(pw.getBytes());
	   
	   //为每位注册人员分配一个id
	   String id=UUID.randomUUID().toString();
	   //记录注册时间
	   
	   
	  Date date =new Date();
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	  String resignTime= formatter.format(date);
	   
	   
	  
	   Map map=new HashMap();
	   map.put("id", id);
	   map.put("account", account);
	   map.put("password", password);
	   map.put("nickName", nickName);
	   map.put("gender", gender);
	   map.put("idCard", idCard);
	   map.put("tel", tel);
	   map.put("account", account);
	   map.put("address", address);
	   map.put("resignTime", resignTime);
	   //在数据库中添加用户信息
	   LRServer.add(map);
	   
		return "resignSuccess";
	}
	
/******************注册时检查*************************/
	/**********检查用户名是否被占用****************/
	@RequestMapping("/checkAccount.do")
	@ResponseBody
	public int checkAccount(String account){
		int res=LRServer.checkAccount(account);
		return res;
		
		
	}
	

}
