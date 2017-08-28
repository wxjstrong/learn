package com.wxj.IM.common.util.solrUtil;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

public class SolrUtil {

	//初始化基础链接
	
	private final static String baseUrl="http://127.0.0.1:8080/";
	
	//可以选择用或者不用
	public static HttpSolrClient getClient(String coreName){
		HttpSolrClient client =null;
		client=new HttpSolrClient(baseUrl+coreName);
		client.setConnectionTimeout(5000);//设置solr的链接超时时间
		client.setSoTimeout(5000);//设置solr的查询超时时间
        client.setAllowCompression(false);//设置solr是否可压缩
        client.setMaxRetries(1);//solr最大连接数
        client.setFollowRedirects(true);//设置此类是否应该自动执行http重定向
		return client;
	}
	/************************************************查询部分***************************************************/
	/*
	 * solr查询所有
	 */
   public static SolrDocumentList querySolr(String coreName) throws SolrServerException, IOException{
	   HttpSolrClient client = new HttpSolrClient(baseUrl+coreName);
	  SolrQuery param=new SolrQuery();	 
	  param.set("q","*:*");
	  param.setHighlight(true);//设置高亮
	  param.setStart(0);//从零开始，从第几条数据开始
	  param.setRows(10);//设置每页几行，应该从配置文件中读取最好
	  
	  param.setSort("id", SolrQuery.ORDER.desc);//设置排序方式

	  	QueryResponse response=null;
		response = client.query(param);
		
	   SolrDocumentList res= response.getResults();
	  
	  return res;
	  
   }
   
   
   
   
  /*****************************************新增**************************************************/ 
  
   /*
    * 把键值对的map对象添加到索引
    */
   
   public static void addDoc(String coreName,Map<String,Object> map) throws SolrServerException, IOException{
	   HttpSolrClient client= SolrUtil.getClient(coreName);
	   SolrInputDocument doc=new SolrInputDocument();
	   if(null!=map &&!map.isEmpty()){
		 //遍历map，把相应的key和value添加到SolrInputDocument里
		   for(String key:map.keySet()){  
			  doc.addField(key, map.get(key));
		   }
		   
	   }
	   
	   client.add(doc);
	   client.commit(false, false);
   }
  
   /*
    * 新增单个对象
    * @throws SolrServerException 
    * @throws IOException
    */
   public static void addBean(String coreName,Object object) throws IOException, SolrServerException{
	  HttpSolrClient client= SolrUtil.getClient(coreName);
	  client.addBean(object) ;
	  client.commit(false, false);
   }
   /*
    * 新增多个对象(集合)到索引
    */
   public static <E> void addBeans(String coreName,List<E>lists) throws SolrServerException, IOException{
	   HttpSolrClient client= SolrUtil.getClient(coreName);
	   client.addBeans(lists);
	   client.commit(false, false);  
   }
   
   
   /*******************************************删除 ***********************************************/
   /*
    * 根据Id删除对象
    */
   public static void deleteById(String coreName,String id) throws SolrServerException, IOException{
	   HttpSolrClient client= SolrUtil.getClient(coreName);
	   client.deleteById(id);
	   client.commit(false, false);
   }
   
   
   /*
    * 根据查询删除
    */
   public static void deleteByQuery(String coreName,String query) throws SolrServerException, IOException{
	   HttpSolrClient client= SolrUtil.getClient(coreName);
	   client.deleteByQuery(query);
	   client.commit(false, false);
   }
   /*
    * 删除所有
    */
   public static void deleteAll(String coreName) throws SolrServerException, IOException{
	   HttpSolrClient client= SolrUtil.getClient(coreName);
	   client.deleteByQuery("*:*");
	   client.commit(false, false);
   }
   
   /*
    * solr分页查询工具类
    */
   
   public static JSONObject getByPage(String keyWords,String name,String code,int pageNum,int pageSize) throws SolrServerException, IOException{
	   
	    String url="http://127.0.0.1:8080/solr/stock";
		HttpSolrClient client=new HttpSolrClient(url);
		String q="";
		//判断是精确查询还是普通查询
		if(keyWords!=null){//普通查询
			 q="searchF:"+keyWords; //拼接查询条件//String q="name:"+keyWords+"OR code:"+keyWords;
		}
		else{
			//判断两个参数都不为空
			if(name!=null && !("".equals(name))  && code!=null && !("".equals(code))){
				 q="code:"+code+"OR name:"+name ;
			}
			else if(name==null||"".equals(name) && code!=null && !("".equals(code))){//判断其中name为空
				q="code:"+ code;
			}
			else if(code==null||"".equals(code) && name!=null && !("".equals(name))){//判断其中code为空
				q="name:"+ name;
			}
			
		}
		
		JSONObject json = new JSONObject();
		
		SolrQuery param=new SolrQuery();
		param.set("q", q);	
		int startRow=(pageNum-1)*pageSize;//计算请求页开始行数
		param.setStart(startRow);//设置请求页开始行数
		param.setRows(pageSize);
		
		SolrDocumentList docs=client.query(param).getResults();
		long count = docs.getNumFound();
	
		System.out.println( docs.getNumFound());
		//查询结果转换成Jsonarr格式
		JSONArray jsonArray = new JSONArray();
		for(SolrDocument doc :docs){
			jsonArray.add(doc);
			}
		
		System.out.println(jsonArray);
	   
		//把JSONArray加入到JSONObject
		
	     json.put("docs", jsonArray);
		 json.put("count", count);
		 System.out.println(json);
        client.close();

		  return json;
	   
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}
