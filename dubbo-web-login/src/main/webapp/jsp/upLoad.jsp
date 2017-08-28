<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    	<meta charset="utf-8" />
        <title>新华财经聊天社区软件管理</title>
        <script type="text/javascript" src="js/jquery-3.2.1.js" ></script>
        <style type="text/css">
        	*{
        		margin: 0;
        		padding: 0;
                background-color: steelblue;
        	}
        	div{
        	
        		width:600px;
        		height:400px;
        		position: absolute;
        		top:50%;
        		left: 50%;
        		margin-left: -300px;
        		margin-top: -200px;
        	
        	}
      table{
      	width:600px;
      }
       input .chosefile{
       	
        	border:solid 1px black ;
        	width:600px;
        }
     td:nth-child(1){
     	border: solid 1px black;
     }
        </style>
    </head>
    <body>
    	<div id="out_div" >
    		<form  action="../file/upload.do"  method="post" enctype="multipart/form-data" >
    		<table >
    			<tr>
    				<td><input type="file"  name="file" id="chosefile" value="" /></td>
    				<td><input type="button" name="submitfile" id="submitfile" value="上  传" /></td>
    			</tr>
    		</table>

    		</form>	
    			<script  type="text/javascript">
    				function checkFile(){
    					//js判断文件是否选择上传文件
    				    var file=document.getElementById("file").value;
    				    if(file==""||null==file){
    				    	alert("未选择上传文件");
    				        return false;
    				    }
    				    document.getElementById("formSubmit").submit();
    				}
    				
    			</script>
    	</div>
 	</body>
</html>
