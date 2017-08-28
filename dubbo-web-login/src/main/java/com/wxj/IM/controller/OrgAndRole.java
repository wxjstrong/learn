package com.wxj.IM.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSON;
import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.testng.log4testng.Logger;

import com.wxj.IM.service.OrgAndRoleService;

@Controller
@RequestMapping("/ORGandRole")
@SuppressWarnings("rawtypes")

public class OrgAndRole {

	Logger logger=Logger.getLogger(OrgAndRole.class);
	
	@Autowired
	OrgAndRoleService orgRoleService; 
	@RequestMapping("/showOrg.do")
	@ResponseBody
	public JSON getOrgAndRole(String id){
		
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
				
		list=orgRoleService.getOrgAndRole();
		JSON list1=JSONArray.fromObject(list);
		System.out.println(list1);
		return list1;
	}

}
