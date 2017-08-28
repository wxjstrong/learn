package com.wxj.IM.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxj.IM.dao.OrgAndRoleDao;
import com.wxj.IM.service.OrgAndRoleService;
@Service
@SuppressWarnings("rawtypes")
public class OrgAndRoleServiceImpl implements OrgAndRoleService {

	@Autowired
	OrgAndRoleDao orgAndRoleDao;
	public List<Map<String,Object>> getOrgAndRole() {
		Map map= new HashMap();
		
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		list=orgAndRoleDao.getOrgAndRole();
		System.out.println(list);
		
		
		
		
		return list;
	}

}
