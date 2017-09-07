package com.wxj.loginAndResign.dao;

import java.util.Map;
import org.springframework.stereotype.Repository;

import com.wxj.loginAndResign.entity.User;

@Repository
public interface LARDao {

	int add(User user);

}
