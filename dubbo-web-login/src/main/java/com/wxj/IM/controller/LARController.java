package com.wxj.IM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wxj.loginAndResign.entity.User;
import com.wxj.loginAndResign.service.LoginAndResignService;

@Controller
@RequestMapping("/loginAndResign")
public class LARController {
      @Autowired 
      LoginAndResignService service;
      @RequestMapping("/resign.do")

      public String resign(User user){
    	 
    	  String message="";
    	  message= service.resign(user);
    	  return message;
      }
}
