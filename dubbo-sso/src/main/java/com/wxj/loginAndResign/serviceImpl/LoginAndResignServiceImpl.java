package com.wxj.loginAndResign.serviceImpl;

import java.util.HashMap;
import java.util.Map;

<<<<<<< master
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.wxj.common.util.SHAEncrypt;
import com.wxj.loginAndResign.dao.LARDao;
=======
import org.springframework.stereotype.Service;

>>>>>>> local
import com.wxj.loginAndResign.entity.User;
import com.wxj.loginAndResign.service.LoginAndResignService;
@Service
public class LoginAndResignServiceImpl implements LoginAndResignService{

<<<<<<< master
	@Autowired
	LARDao dao;
	
	
	
	public String resign(User user) {
		String res="";
		//业务层需要处理用户密码加密,暂时使用原始密码直接使用SHA加密
		String password = user.getPassword();
		SHAEncrypt sha = new SHAEncrypt();
		String pwd = sha.getSha256String(password);
		user.setPassword(pwd);
		int affectNum = dao.add(user);
		
		if(affectNum!=0){
			 res="注册成功！";
		}else{
			res="注册失败！";
		}
		return res;
=======
	@Override
	public String resign(User user) {
		
		Map map = new HashMap();
		
		
		
		
		
		
		return "";
		
		
>>>>>>> local
	}

	

}
