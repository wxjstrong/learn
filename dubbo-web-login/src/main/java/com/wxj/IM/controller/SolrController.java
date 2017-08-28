package com.wxj.IM.controller;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrResponse;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.util.NamedList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.testng.log4testng.Logger;

import com.wxj.IM.common.util.solrUtil.SolrUtil;

@Controller
@RequestMapping("/FinancialPdManage")
public class SolrController {

	Logger logger=Logger.getLogger(SolrController.class);
	String url="http://127.0.0.1:8080/solr";
	
	/*
	 * solr普通查询的分页查询,需要参数当前页数currentPage，每页行数pageRow
	 */
	@RequestMapping("/getByPage.do")
	@ResponseBody
	public JSONObject getByPageCommon( String keyWords,String name,String code,int pageNum, int pageSize) throws IOException, SolrServerException{
	JSONObject json =SolrUtil.getByPage(keyWords, name,code,pageNum, pageSize);
	return json;
	}
	
	
}
