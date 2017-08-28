<%@page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>


<!DOCTYPE>
<html>
    <head>
        <title>JSP Page</title>
        <link rel="stylesheet" href="../../js/bootstrap-3.0.0/css/bootstrap-theme.css" />
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
		<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../../js/bootstrap-3.0.0/js/bootstrap.js"></script>
        <style type="text/css">
            html body{
               background-image:url(../../../img/bg1.png);
            }
 
            #app_plist li{
             padding: 50px;
             float:left;
             list-style-type: none;
              color: white;
             } 
             
             ul li img {display:block}
             
             ul li span {
             display:block;
             text-align:center;
             
             }
        
        </style>
        <script type="text/javascript" >
        var obj;
        $(function(){
        	
        	$.ajax({
        		  async:true,
        	      type:"post",
        	      url:"../../../appManage/getAllApp.do",
        	      dataType:"json",
        	      data:"{}",
        	      success:function(data){
        	    	 // alert("展示成功");
        	    	 console.log(data);
        	    	  obj=data;
        	    	  var str="";
                      for(var i=0;i<data.result.length-1;i++){
        	    	   str=str+"<li><img src='"+data.result[i].appIconUrl+"\' class='img-rounded' width='80px' height='80px'/><span>"+data.result[i].paasName+"</span><input type=hidden name=paasId   value="+data.result[i].paasId+"></li>";
        	    	  }
                      $("#app_plist ul").html(str);
        	      },
        		error:function(){
        			alert("数据加载失败");
        			}
        	       });
        	
        	 $("#app_plist ul").on("click","li","input",function(){
          		
          		$(this).siblings().find("input").removeClass("check");
          		$(this).siblings().css("backgroundColor","");
          		$(this).find("input").toggleClass("check");
          		if($(this).find("input").hasClass("check")){
          			$(this).css("backgroundColor","grey");
          		}else{
          			
          			$(this).css("backgroundColor","");
          		}
          		
          	});
        	
        	/*为每个应用图标添加一个双击修改事件*/
        	//$("#app_plist ul").bind("dblclick",function(){
                 //    alert("触发了双击事件");
        		   // alert( paasId.toString());
                  //   $("#app_update").click();
           //  });
        	
              //点击删除按钮
              $("#app_delete").click(function(){
            	  //判断是否有被选中的选项
            	  
            	    var paasId= $(".check").val();
            	     // alert(check);
            	   if(paasId==""||paasId==undefined){
            		   return alert("请选择一项"); 
             		  }
             	  else{
             		  //确认框选择
             		  if(confirm("是否确定删除？")==true){
             			//发送ajax请求进行删除
             			  alert(123);
             			$.ajax({
             				async:true,
             				url:"../../../appManage/deleteApp.do",
             				type:"post",
             				data:{"paasId":paasId},
             				dataType:"json",
             				
             				success:function(data){
             					if(data.result==1){
             						alert("删除成功");
             						}
             					else{
             						alert("删除失败");
             					}
             					
             				},
             				error:function(){
             					alert("请求失败");
             				},
             					
             			});//ajax结束
             		  }//if结束
             	  }
            	   
            	 // alert("the val is"+$(".check").val());
              });//点击按钮删除结束
              
                //点击修改按钮进行修改
                $("#app_update").click(function(){
                	//判断是否有被选中的选项
               	    var paasId= $(".check").val();
                	if(paasId==""||paasId==undefined){
              		    alert("请选择一项"); 
              		    return false;
               		  }
                	else{
                		 $.ajax({
                			async:true,
                			type:"post",
                		    url:"../../../appManage/getApp.do",
                		    data:{"paasId":paasId},
                		    dataType:"json",
                		    
                		    success:function(data){
                		    	//alert(data.result.paasId);
                		    	$("#updateModal input[name='paasId']").val(data.result.paasId);
                		    	$("#updateModal input[name='paasName']").val(data.result.paasName);
                		    	$("#updateModal input[name='appRootPath']").val(data.result.appRootPath);
                		    	$("#updateModal input[name='appIconUrl']").val(data.result.appIconUrl);
                		    	$("#updateModal input[name='description']").val(data.result.description);
                		    	$("#updateModal select[name='appType']").val(data.result.appType);
                		    	$("#updateModal select[name='appOpenMode']").val(data.result.appOpenMode);
                		    	$("#updateModal select[name='layout_pc']").val(data.result.layout_pc);
                		    	$("#updateModal select[name='layout_mac']").val(data.result.layout_mac);
                		    	$("#updateModal select[name='layout_mobile']").val(data.result.layout_mobile);
                		    	
                		    },
                		    error:function(){
                		    	alert("获取数据失败");
                		    },
                		    
                		}); 
                		}
     
                	
                });
              
	
        });

       /*  $(window).load(function(){
            //要执行的方法体
        	
        }); */
       
        </script>
    </head>
    <body>

    	<div id="app_manage">
    			<div id="app_operate">
    				<button id="app_add"    class="btn btn-primary btn-lg" data-toggle="modal" data-target="#addModal" type="button" name="appadd" value="">新增应用</button>
    				<button id="app_update" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#updateModal" type="button" name="appupdate" value="">修改应用</button>
    				<button id="app_delete" class="btn btn-primary btn-lg"  type="button" name="appdelete" value="">删除应用</button>
    			</div>
    			<div id="app_plist">
    				<ul>
    				
    				</ul>
    			</div>
    			
    	</div>
    	
         <!--新增  模态框（Modal） -->
       <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel" aria-hidden="true">
        <div class="modal-dialog">
        <div class="modal-content">
            <form action="../../../appManage/appAdd.do"  class="form-horizontal" method="post"  accept-charset="utf-8" >
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">应用新增</h4>
               
            </div>
          
            <div class="modal-body">
            <div class="form-group">
              <label class="col-sm-2 control-label">应用  I D</label>
              <div  class="col-sm-10">
            	<input  class=" form-control" type="text" name="paasId" value="" required="required"/>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-2 control-label">应用名称</label>
              <div  class="col-sm-10">
            	<input  class=" form-control" type="text" name="paasName" value="" required="required"/>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-2 control-label">应用链接</label>
              <div  class="col-sm-10">
            	<input  class=" form-control" type="text" name="appRootPath" value="" required="required" placeholder="如:app.demo.com或http://app.demo.com/app1/,也可为ip"/>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-2 control-label">图标链接</label>
              <div  class="col-sm-10">
            	<input  class=" form-control" type="text" name="appIconUrl" value="" required="required"/>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-2 control-label">应用描述</label>
              <div  class="col-sm-10">
            	<input  class=" form-control" type="text" name="description" value="" required="required"/>
              </div>
            </div>  
            <div class="form-group">
            	<label class="col-sm-2 control-label">应用类型</label> 
            	<div class="col-sm-10">
            	<select  id="layout-pc" class="form-control input-lg-3" name="appType" value="">
            	                  <option value="">应用类型(16:企业应用,4:会话应用)</option>
            	                  <option value="16">16</option>
            	                  <option value="4">4</option>
            	</select> 
            	</div>               
              </div> 
             <div class="form-group">
            	<label class="col-sm-2 control-label">打开方式</label> 
            	<div class="col-sm-10">
            	<select  id="layout-pc" class="form-control input-lg-3" name="appOpenMode" value="">
            	                  <option value="">0:内置浏览器打开且不带认证信息,1:内置浏览器打开且带认证信息,2:外部浏览器打开且不带认证信息,3:外部浏览器打开且带认证信息),默认是1;2 和3 仅对企业应用有效且layout_pc=4</option>
            	                  <option value="0">0</option>
            	                  <option value="1">1</option>
            	                  <option value="2">2</option>
            	                  <option value="3">3</option>
            	</select> 
            	</div>               
              </div>       
             <div class="form-group">
            	<label class="col-sm-2 control-label">电脑布局</label> 
            	<div class="col-sm-10">
            	<select  id="layout-pc" class="form-control input-lg-3" name="layout_pc" value="">
            	                  <option value="">4右下角显示,2窗口上方工具栏,默认0,不显示</option>
            	                  <option value="0">0</option>
            	                  <option value="1">1</option>
            	                  <option value="4">4</option>
            	</select> 
            	</div>               
              </div> 
              <div class="form-group">
            	<label class="col-sm-2 control-label">mac布局</label>
            	<div class="col-sm-10">
            	<select  id="layout-mac" class="form-control input-lg-3" name="layout_mac" value="">
            	                  <option value="">4右下角显示,2窗口上方工具栏,默认0,不显示</option>
            	                  <option value="0">0</option>
            	                  <option value="1">1</option>
            	                  <option value="4">4</option>
            	</select>
            	</div>
              </div>
              <div class="form-group">
            	<label class="col-sm-2 control-label">手机布局</label>
            	<div class="col-sm-10">
            	<select  id="layout-group" class="form-control input-lg-3" name="layout_mobile" value="">
            	                  <option value="">4右下角显示,默认4,0 不显示</option>
            	                  <option value="0">0</option>
            	                  <option value="1">1</option>
            	                  <option value="4">4</option>
            	</select>
              </div>
              </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="submit" class="btn btn-primary">提交</button>
            </div>
            </form>
        </div><!-- /.modal-content -->
        </div><!-- /.modal -->
       </div>
      <!-- 应用修改     模态框（Modal） -->
       <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="updateModalLabel" aria-hidden="true">
        <div class="modal-dialog">
        <div class="modal-content">
            <form action="../../../appManage/updateApp.do"  class="form-horizontal" role="form" mothed="post" >
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">应用修改</h4>
               
            </div>
          
            <div class="modal-body">
            <div class="form-group">
              <label class="col-sm-2 control-label">应用  I D</label>
              <div  class="col-sm-10">
            	<input id="update_paasId" class=" form-control" type="text" name="paasId" value="" required="required"/>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-2 control-label">应用名称</label>
              <div  class="col-sm-10">
            	<input  class=" form-control" type="text" name="paasName" value="" required="required"/>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-2 control-label">应用链接</label>
              <div  class="col-sm-10">
            	<input  class=" form-control" type="text" name="appRootPath" value="" required="required" placeholder="如:app.demo.com或http://app.demo.com/app1/,也可为ip"/>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-2 control-label">图标链接</label>
              <div  class="col-sm-10">
            	<input  class=" form-control" type="text" name="appIconUrl" value="" required="required"/>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-2 control-label">应用描述</label>
              <div  class="col-sm-10">
            	<input  class=" form-control" type="text" name="description" value="" required="required"/>
              </div>
            </div>
            <div class="form-group">
            	<label class="col-sm-2 control-label">应用类型</label> 
            	<div class="col-sm-10">
            	<select  id="layout-pc" class="form-control input-lg-3" name="appType" value="">
            	                  <option value="">应用类型(16:企业应用,4:会话应用)</option>
            	                   <option value="16">16</option>
            	                  <option value="4">4</option>
            	</select> 
            	</div>               
              </div> 
             <div class="form-group">
            	<label class="col-sm-2 control-label">打开方式</label> 
            	<div class="col-sm-10">
            	<select  id="layout-pc" class="form-control input-lg-3" name="appOpenMode" value="">
            	                  <option value="">0:内置浏览器打开且不带认证信息,1:内置浏览器打开且带认证信息,2:外部浏览器打开且不带认证信息,3:外部浏览器打开且带认证信息),默认是1;2 和3 仅对企业应用有效且layout_pc=4</option>
            	                  <option value="0">0</option>
            	                  <option value="1">1</option>
            	                  <option value="2">2</option>
            	                  <option value="3">3</option>
            	</select> 
            	</div>               
              </div>
            <div class="form-group">
            	<label class="col-sm-2 control-label">电脑布局</label> 
            	<div class="col-sm-10">
            	<select  id="layout-pc" class="form-control input-lg-3" name="layout_pc" value="">
            	                  <option value="">4右下角显示,2窗口上方工具栏,默认0,不显示</option>
            	                  <option value="0">0</option>
            	                  <option value="1">1</option>
            	                  <option value="4">4</option>
            	</select> 
            	</div>               
              </div> 
              <div class="form-group">
            	<label class="col-sm-2 control-label">mac布局</label>
            	<div class="col-sm-10">
            	<select  id="layout-mac" class="form-control input-lg-3" name="layout_mac" value="">
            	                  <option value="">4右下角显示,2窗口上方工具栏,默认0,不显示</option>
            	                  <option value="0">0</option>
            	                  <option value="1">1</option>
            	                  <option value="4">4</option>
            	</select>
            	</div>
              </div>
              <div class="form-group">
            	<label class="col-sm-2 control-label">手机布局</label>
            	<div class="col-sm-10">
            	<select  id="layout-group" class="form-control input-lg-3" name="layout_mobile" value="">
            	                  <option value="">4右下角显示,默认4,0 不显示</option>
            	                  <option value="0">0</option>
            	                  <option value="1">1</option>
            	                  <option value="4">4</option>
            	</select>
              </div>
              </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="submit" class="btn btn-primary">提交</button>
            </div>
            </form>
        </div><!-- /.modal-content -->
        </div><!-- /.modal -->
       </div>
    
    
    
    
    </body>
</html> 