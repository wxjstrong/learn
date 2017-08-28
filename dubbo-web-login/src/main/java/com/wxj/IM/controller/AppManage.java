package com.wxj.IM.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wxj.IM.common.util.httputils.AppManageUtil;
import com.wxj.IM.entity.AppEntity;

@Controller
@RequestMapping("/appManage")

public class AppManage {
   /*
    * 创建应用
    */
	@RequestMapping(value="/appAdd.do")
	@ResponseBody
    public String addApp(AppEntity appEntity) throws Exception{
    	System.out.println("123");
    	String result=AppManageUtil.createApp(appEntity);
    	System.out.println(result);
    	/*
    	 * 此处待完善，新建应用的同时应该设置其可见性，在页面需要增加openToAll和staffIds、unitIds来设置可见性
    	 * 并调用设置应用接口可见性接口
    	 * Boolean openToAll=appEntity.getOpenToAll();
    	 * 
    	 * 
    	 */
    	
    	
    	
    	return result;
    }
   
    
    /*
     * 获取所有应用列表
     */
	@RequestMapping("/getAllApp.do")
	@ResponseBody
	public String getAllApp() throws IOException{
		String result=AppManageUtil.getAllAppInfo();
		System.out.println(result);
		return result;
	}
	
	
	/*
	 * 根据paasId获取信息
	 */
	@RequestMapping("/getApp.do")
	@ResponseBody
	public String getApp(String paasId) throws IOException{
		String result=AppManageUtil.getAppInfo(paasId);
		
		System.out.println(result);
		return result;
	}
	
	/*
	 * 根据paasId获取应用可见性
	 */
	
	@RequestMapping("/getSubscriber.do")
	@ResponseBody
	public String getSubscriber(String paasId) throws IOException{
		String result=AppManageUtil.getSubscriber(paasId);
		System.out.println(result);
		return result;
	}

	/*
	 * 设置应用可见性
	 */
	@RequestMapping("/setSubscriber.do")
	@ResponseBody
	public String setSubscriber(String paasId,String openToAll,String staffIds,String unitIds) throws IOException{
		String result="";
		result=AppManageUtil.setSubscriber(paasId,openToAll,staffIds,unitIds);
		return result;
	}
	
	/*
	 * 更新应用
	 */
	@RequestMapping(value="/updateApp.do")
	@ResponseBody
	public String updateApp(AppEntity appEntity,HttpServletRequest request) throws IOException{
		System.out.println(appEntity.getPaasName());
		String result="";
		result=AppManageUtil.updateApp(appEntity);
		
		return result;
	}

	/*
	 * 删除应用
	 */
	@RequestMapping("deleteApp.do")
	@ResponseBody
	public String deleteApp(String paasId) throws IOException{
		String result="";
		result=AppManageUtil.deleteApp(paasId);
		
		return result;
	}
}
    
