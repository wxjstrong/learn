package com.wxj.loginAndResign.serviceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxj.common.util.SHAEncrypt;
import com.wxj.loginAndResign.dao.LARDao;
import com.wxj.loginAndResign.entity.User;
import com.wxj.loginAndResign.service.LoginAndResignService;

@Service
public class LoginAndResignServiceImpl implements LoginAndResignService{

	@Autowired(required=true)
	LARDao dao;
	
	
	/*
	 * 注册方法
	 */
	@SuppressWarnings("static-access")
	public String resign(User user) {
		String res="";
		
		//给用户添加指定规则的id，暂时使用uuid
		String id=UUID.randomUUID().toString().replace("_", "").replace("-", "");
		user.setId(id);
		
		//业务层需要处理用户密码加密,暂时使用原始密码直接使用SHA加密
		String password = user.getPassword();
		SHAEncrypt sha = new SHAEncrypt();
		String pwd = sha.getSha256String(password);
		user.setPassword(pwd);
		
		//调用dao操作数据库
		int affectNum = dao.add(user);
		
		//处理返回结果
		if(affectNum!=0){
			 res="注册成功！";
		}else{
			res="注册失败！";
		}
		return res;
	}

	/*
	 * 检查是否已经存在用户名
	 */
	public String checkExist(String userName){
		String message="";
		int recode = dao.checkExist(userName);
		if (recode==0){
			message = "用户名可用";
		} else{
			message = "用户名已存在";
		}
		return message;
		
	}
   /******************************登陆部分*************************************/
	/*
	 * 用户登录
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String login(String loginName,String password){
		String message="";
		//加密密码，先去数据库中查询用户信息是否正确
	    String	pwd = SHAEncrypt.getSha256String(password);
	    Map map = new HashMap();
		map.put("loginName",loginName);
		map.put("password",pwd);
		
		int record = dao.checkLogin(map);
		if (record == 1){
			message="登陆成功！";
		}else{
			message ="用户名或密码错误！";
		}
        //TODO
		//把用户信息放入token中
		return message;	
	}
	
	
}
