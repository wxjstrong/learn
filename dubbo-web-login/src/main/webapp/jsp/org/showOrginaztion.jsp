<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>组织机构管理</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="/IM/jsp/zTree/api/apiCss/common.css">
    <link rel="stylesheet" href="/IM/jsp/zTree/api/apiCss/zTreeStyleForApi.css">
		<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
		<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="/IM/jsp/js/jquery-1.9.0.js"></script>
		<script type="text/javascript" src="/IM/jsp/zTree/api/apiCss/jquery.ztree.core-3.5.js"></script>
		<script type="text/javascript">
	 	var ztree;
		
			var setting={
				data:{
					simpleData:{
						enable:true,
			            idKey:"id",
			            pIdKey:"pId",
			            rootId:0
					}
				},
				view:{
					showIcon:true,//是否显示图标
					showLine:true,//是否显示节点间连线
					expandSpeed: "fast"//展开速度
				},
				async:{
					enable:true,
					contentType: "application/json",
					url:"../../ORGandRole/showOrg.do",
					type:"get",
					autoParam:["id","deptName"],
					dataType:"text"
				},
				callback:{
					
					asynSuccess: zTreeOnAsyncSuccess,
					asyncError:function(){
						alert("数据加载失败");
					},
				},
				
				edit:{
					enable:true,
					showRemoveBtn:true,
					showRenameBtn:true
				}
				
			};
			
			function zTreeOnAsyncSuccess(even,treeId,treeNode,msg){
				alert(msg);	
				
				}
			
			$(document).ready(function(){
				$.fn.zTree.init($("#tree"),setting);
			});
	
		</script>
  </head>
    
  <body>
      <div>
         <ul id="tree" class="ztree"></ul>
      </div>
  </body>
</html>
