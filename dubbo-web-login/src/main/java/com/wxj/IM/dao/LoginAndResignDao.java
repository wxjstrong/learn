package com.wxj.IM.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;


public interface LoginAndResignDao {
   public int login(Map map);
   public int add(Map map);
   public int checkAccount(String account);
}
