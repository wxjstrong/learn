package com.wxj.IM.service.impl;




import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxj.IM.dao.LoginAndResignDao;
import com.wxj.IM.service.LoginAndResginServer;
@Service
public class LoginAndResignServerImpl  implements LoginAndResginServer{
   
	@Autowired
    LoginAndResignDao LRDao;
    
	public int login(Map map) {
		int res=LRDao.login(map);
		return res;
	}
    public int add(Map map){
    	int res=LRDao.add(map);
    	return res;
    }
    
    public int checkAccount(String account){
    	int res=LRDao.checkAccount(account);
    	return res;
    }
}
