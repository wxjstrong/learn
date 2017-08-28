<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>股票搜索</title>
     <link rel="stylesheet" href="../js/bootstrap-3.0.0/css/bootstrap-theme.css" />
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
		<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../js/bootstrap-3.0.0/js/bootstrap.js"></script>
      <style type="text/css"> 
		
			/*让主区域的范围为整个屏幕*/
			html, body, #mainBlock{
				width: 100%;
				height: 100%;
			    background-image:url(../../img/bg1.png);
			    color:red;
			}
			/*搜索框区*/
		   #formdiv{
 				width: 100%;
 				height: 100%;
 			
 			}
 			
 	
 			/*查询结果展示区框架*/
 			#resShow {
 			 margin-top:10%;
 			 border:solid 1px green;
 		     width: 100%;
 			 height: 65%;

 			}
			/*查询结果具体展示区*/
			#queryRes{
			
				width: 80%;
 			    height: 100%;
				margin-left:10%;
				border:solid 1px black;
			}
			/*搜索框的样式*/
			
			
			#searchBox{
				width:800px;
				height:100px;

				position: absolute;
				left:50%;
                top:5%;
				margin-left: -400px;
				
			}
			
			#normalSearchBox input{
				width: 600px;
			} 
 			
 			#exactSearchBox input{
 				width: 298px;
 			}
 			#tabButton button{
 				border: none;
 				margin-top: 10px;
 				height: 30px;
 				width: 100px;
 				margin-left: 0;
 			
 			}
 			/*让表格内容居中*/
 			td{
 			  text-align:center;
 			}
 			/*分页区*/
 			#getBypage{
 			top:80%;
 			width:80%;
 			margin-left:10%;

 			border:solid 1px red;
 			}
 			
 			#getBypage ul{
 			 float:right;
 			 margin-top:0;
 			}
 			
 			/*展示当前页起始行和结束行行数样式*/
 			#startRow,#lastRow{
 			width:20px;
 			height:20px;
 			}
 			/*分页的样式*/
 			.pagination-sm > li {
               display: inline;
             }
 			
 			 .pagination-sm > li > input {
                position: relative;
              
                float: left;
                padding: 6px 12px;
                line-height: 1.428571429;
                
                 text-decoration: none;
                 background-color: #ffffff;
                 border: 1px solid #dddddd;
                 margin-left: -1px;
                } 
                
             .pagination-sm > li > a {
                position: relative;
                float: left;
                padding: 6px 12px;
                line-height: 1.428571429;
                 text-decoration: none;
                 background-color: #ffffff;
                 border: 1px solid #dddddd;
                 margin-left: -1px;
                } 
		</style>
		<script type="text/javascript" >
		
			$(function(){

/********************************搜索框操作************************************/				
				$("#exactSearchBox").css("display","none");
			    //切换模糊查询和精确查询
			    $("#exactButton").click(function(){
					
					$("#normalSearchBox").css("display","none");
					$("#exactSearchBox").css("display","block");
					$("#searchForm [name=keyWords]").val("") ;//清空普通查询的值
		
				});
				$("#normalButton").click(function(){
					$("#normalSearchBox").css("display","block");
					$("#exactSearchBox").css("display","none");
					var name     = $("#exactSearch_name").val("");//清空精确查询的name值
					var code     = $("#exactSearch_code").val("");//清空精确查询的code值
				});
				
				//使用ajax发起请求
				$("#normalSearchButton").click(function(){
					var keyWords = $("#searchForm [name=keyWords]").val();
					var name     = $("#exactSearch_name").val();
					var code     = $("#exactSearch_code").val();
					var myUrl    = "../../FinancialPdManage/getByPage.do";
					var pageSize=parseInt($("#pageSelect option:selected").val());
					var pageNum  = 1;
					getByPage("post",myUrl,keyWords,name,code,pageNum,pageSize);
			
				});
				
				
				
				$("#exactSearchButton").click(function(){
					var keyWords = $("#searchForm [name=keyWords]").val();
					var name     = $("#exactSearch_name").val();
					var code     = $("#exactSearch_code").val();
					var myUrl    = "../../FinancialPdManage/getByPage.do";
					var pageSize = parseInt($("#pageSelect option:selected").val());
					var pageNum  = 1;
					
					getByPage("post",myUrl,keyWords,name,code,pageNum,pageSize);
				});    //点击查询事件结束
				
				
				
			 	//获取点击页数
				$("#showPage").on("click","input",function(){
					var pageNum=parseInt($(this).val());
					var pageSize=parseInt($("#pageSelect option:selected").val());
					$("#pageNum").val(pageNum);
					alert($("#pageNum").attr("value"));
					//先假设为一般查询，后逐步完善
					//$("#normalSearchButton").click();
					var keyWords = $("#searchForm [name=keyWords]").val();
					var name     = $("#exactSearch_name").val();
					var code     = $("#exactSearch_code").val();
					
					var myUrl    = "../../FinancialPdManage/getByPage.do";
					getByPage("post",myUrl,keyWords,name,code,pageNum,pageSize);
				});
				
				
			});//jq结束
/******************************分页查询部分***************************************/				
				//获取总页数
				function getPageCount(recordNum, pageRow){
				if(recordNum%pageRow==0){
					pageCount=recordNum/pageRow;
				}else{
					pageCount=Math.floor(recordNum/pageRow)+1;
				}
				return pageCount;
				}
				
				//封装分页查询的ajax请求
				function getByPage(method,myUrl,keyWords,name,code,pageNum,pageSize){
					$.ajax({
						async:true,
		        	      type:method,
		        	      url:myUrl,
		        	      dataType:"json",
		        	      data:{"keyWords":keyWords,"name":name,"code":code,"pageNum":pageNum,"pageSize":pageSize},
		        	      success:function(data){
		        	    	 // alert("展示成功");
		        	    	 console.log(data);
		        	    	  obj=data;
		        	    	  var str="";  
		        	    	  var strForPage=" <li><a href=\"#\">首页</a></li><li><a href=\"'javascript:indexpage(-1);'\">上一页</a></li>";
		        	    	  var recordNum=data.count;
		        	    	  
		        	    	  //展示数据
		        	    	  for(var i=0;i<data.docs.length;i++){
		        	    		  str=str+"<tr><td>"+data.docs[i].code+"</td><td>"+data.docs[i].name+"</td></tr>";
		        	    	  }
		        	    	  //展示分页
		        	    	 var page = getPageCount(recordNum,pageSize);
		        	    	  $("#startRow").val((pageNum-1)*pageSize+1);
		        	    	  $("#lastRow").val(pageNum*pageSize);
		        	    	  
		        	    	  
		        	    	  for(var j=0;j<page;j++){
		                    	 strForPage+="<li><input type=\"button\" name=\'clickPageNum\' value=\""+(j+1)+"\" />";
		                     }
		                     strForPage+=" <li><a href=\"#\">下一页</a></li><li><a href=\"#\">尾页</a></li>"

		                      $("#queryRes table ").html(str);
		                      $("#showPage").html(strForPage);
		        	      },
		        		error:function(){
		        			alert("数据加载失败");
		        			}
						
					});
				}
				
				
				
	
		</script>
	</head>
	<body>
	<div id="mainBlock">
	  <div id="formdiv">
       <form  id="searchForm">
		<div id="searchBox" >
			<div id="tabButton" >
				<button  type="button">股票</button><input type="hidden" name="stock" value="stock"/>
				<button  type="button">基金</button><input type="hidden" name="fund" value="fund"/>
			</div>
			<div id="normalSearchBox"  style="display:block;" >
		        <input  id="normalSearch" type="text" name="keyWords" value="" placeholder="编码、名称 编码只能输入准确编码查询" />
		        
		        <input type="hidden" id="pageNum" name="pageNum" value=""/>
		        
		        <button  type="button" id="normalSearchButton">search</button>
		        <button  type="button" id="exactButton" >exact search</button>
		    </div>
		    <div id="exactSearchBox">
		        <input type="text" id="exactSearch_code" name="code" value="" placeholder="股票编号"/>
		        <input type="text" id="exactSearch_name" name="name" value="" placeholder="股票名称"/>
		        <button  type="button" id="exactSearchButton">search</button>
		        <button  type="button" id="normalButton">back</button>
		    </div>
		  </div>
		  <div id="resShow">
		  <div id="queryRes"  class="table-responsive">
		    <table class="table table-hover" align="center">
		      
		    </table>
		  </div>
		</div>
		 <!--  分页部分开始 -->
		  <div id="getBypage">
		  <div>
		     <ul id="showPage" class="pagination-sm">
             </ul>
            </div>
            <div>
              <lable>数据显示第
              <input id="startRow" type="text" name="startRow" value="" readOnly="readonly"> 条到第
              <input id="lastRow" type="text" name="lastRow" value="" readOnly="readonly"> 条,每页</lable>
              <select id="pageSelect" name="pageSize" >
               <option value="5">5</option>
               <option value="10" selected = "selected">10</option>
               <option value="15">15</option>
               <option value="20">20</option>
              </select>
              <lable>行</lable>
            </div>
		</div>
		 </form>
		</div>
		
		
	 </div>
	 </body> 
</html>
