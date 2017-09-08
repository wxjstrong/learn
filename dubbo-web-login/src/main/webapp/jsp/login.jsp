<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
		<meta charset="utf-8" />
		
		<script type="text/javascript" src="js/jquery-1.9.0.js" ></script>
		<link rel="stylesheet" href="js/bootstrap-3.0.0/css/bootstrap-theme.css" />
		<script type="text/javascript" src="js/bootstrap-3.0.0/js/bootstrap.js" ></script>
		<script type="text/javascript" src="js/bootstrap-3.0.0/js/bootstrap.min.js" ></script>
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	   <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	   <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<title>登录界面</title>
		<style>
			*{
				margin: 0;
			}
			body{
			 background-image:url(../img/bg2.jpg) ;
			}
			#login_block{
				border: solid 1px red;
				width: 500px;
				height: 300px;
				position: absolute;
				top:50%;
				left: 50%;
				margin-left:-250px;
				margin-top: -150px;
				
				text-align: center;
				
				}
				#header{
				background-color:black;
				color:white;
				
				}
				#login_btn{
				 background-color:black;
				 color:white;
				}
		</style>
	</head>
	<body>
		<div id="login_block" class="form-group">
			<div class="form-group" >
            <div id="header" class="form-group" >
            <label>登录</label>
            
            </div>
			<form role="form" id="login_form" action="../../loginAndResign/checkExist.do" method="get">
				
				<div class="form-group">
					<label>账号</label>
					<input type="text" name="account" palceholder="邮箱/手机号/用户名"/>
				</div>
				<div class="form-group">
					<label>密码</label>
					<input type="password" name="password" value=""/>
				</div>
				<div class="form-group">
					<lable>验证码</lable>
					<input type="text"  name="checknum" value=""/>
				</div>
				<div id="login_btn">
					<input class="btn btn-primary btn-lg btn-block" type="submit" name="login" value="登录" />
				</div>
			</form>
			</div>
			<div  class="form-group">
				<ul>
				   <li><a href="forgetPwd.jsp"><span>忘记密码</span></a><i></i></li>
				   <li><a href="resign.jsp"><span>免费注册</span></a></li>
				</ul>
			</div>
			
		</div>
		
	</body>
</html>