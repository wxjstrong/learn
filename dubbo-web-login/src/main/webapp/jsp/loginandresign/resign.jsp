<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>注册页面</title>
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
		<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/jquery-1.9.0.js" ></script>
		<style>
			* {
				margin: 0;
			}
			
			body {
				height: 100%;
			}
			
			#iframe1 {
				margin-left: 200px;
				margin-right: 200px;
				margin-top: 0px;
				margin-bottom: 0;
				padding-top: 20px;
				padding-left: 200px;
				height: 85%;
				border: solid 1px darkgray;
				border-top: hidden;
				border-bottom: hidden;
				background-color: darkgray;
			}
			div nav{
			   width:100%;
	           height: 10%;
			}
	        div img{
	        width:100%;
	        height: 10%;
	        }
	        .form-group{
	        margin:10px;
	        }
	        span{
	         color:red;
	        }
	       
		</style>
		<script type="text/javascript">
          
          
		 function checkAccount(){
		 var account=$("#resign_account").val();
		 console.log(account);
		 //alert("您输入的用户名为"+account);
		  $.ajax({
		   	type:"get",
		   	url:"../../loginAndResign/checkAccount.do",
		   	async:true,
		   	data:{"account":account},
		   	success: function(data){
		   	  if(data==1){
		   	  $("#account_msg").html("*用户名已经被注册，请重新输入");
		   	  }
		   	  else{
		   		$("#account_msg").html("非常棒的用户名");  
		   	  }
		   	  
		   	},
		   	error:function(){
		   		//alert("服务器故障，请稍后再试");
		   	}
		   })
		 
		 }
		/*目前国内手机号码号段：
		移动号段：139 138 137 136 135 134 147 150 151 152 157 158 159 178 182 183 184 187 188
		联通号段：130 131 132 155 156 185 186 145 176
		电信号段：133 153 177 173 180 181 189
		虚拟运营商号段：170 171
		13开头全部有
		145 147两个
		151 152 153 155 156 157 158 159差154
		170 171 177 178 
		180 181 182 183 184 185 186 187 189都有 
		
		/^0?(13[0-9]|14[57]|15[12356789]|17[0178]|18[0-9])[0-9]{8}$/.test(phone);
		
		*/
		function checkPhone(){
		var phoneNum=$("#resign_phone").val;
		if(!/^0?(13[0-9]|14[57]|15[12356789]|17[0178]|18[0-9])[0-9]{8}$/.test(phoneNum)){
		$("#phone_msg").html("*请您输入正确的11位手机号码")
		
		}
		}
		//验证身份证号码
		function checkIdCard(){
		  var IdCard=$("#resign_IdCard").val();
		  if(!/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{4}$/.test(IdCard)){
		  $("#IdCard_msg").html("*身份证信息错误，请您重新输入")
		  
		  }
		
		
		}
		
		
		</script>
		
	</head>

	<body>
	     <div>
	     <p>导航栏位置、待开发</p>
	     </div>
		 <div>
		     <img src="../../img/xinhua.jpg"  class="img-responsive" alt="新华财经潮流最前线"/>
		 </div>
		<div id="iframe1">
		   
			<form id="resign_form" action="../../loginAndResign/resign.do" method="get" class="form-horizontal">
				<div>
				    <input type="hidden" name="id" value="">
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label"><span>*</span>账号</label>
					<label ><input id="resign_account" type="text" name="userName" value="" onblur="checkAccount()"></label>
					<lable ><span id="account_msg"></span></lable>
				</div>
				<div class="form-group">
					<lable class="col-sm-2 control-label"><span>*</span>密码</lable>
					<label><input id="resign_password" type="password" name="password" value="" onblur="checkPW()"/></label>
					<lable ><span id="password_msg"></span></lable>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label"><span>*</span>确认密码</label>
					<label><input id="confirm_password" type="password" name="confirmPassword" value="" onblur="checkPWagain()"/></label>
					<lable ><span id="PWconfirm_msg"></span></lable>
				</div>
				<div class="form-group">
				  <label class="col-sm-2 control-label">昵称</label>
				  <lable><input type="text" name="nickName" value=""/></lable>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">性别</label>
					<lable><input type="radio" name="gender" value="1" />男</lable>
					<label><input type="radio" name="gender" value="0" />女</label>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label"><span>*</span>二代身份证号</label>
					<label><input id="resign_IdCard" type="text" name="IDCard" value="" onblur="checkIdCard()"/></label>
					<lable><span id="IdCard_msg"></span></lable>
				</div>
				<div class="form-group">
					<lable class="col-sm-2 control-label">联系电话</lable>
					<label><input id="resign_phone"type="tel" name="phonenum" value="" onblur="checkPhone()"/></label>
					<lable><span id="phone_msg"></span></lable>
				</div>
				<div class="form-group">
					<lable class="col-sm-2 control-label">电子邮箱</lable>
					<label><input id="resign_eMailphone"type="eMail" name="eMail" value="" /></label>
					<lable><span id="phone_msg"></span></lable>
				</div>
				<div class="form-group">
					<lable class="col-sm-2 control-label">通讯地址</lable>
					<label><input type="text" name="address" value=""/></label>
				</div>
				<div class="form-group">
					<lable class="col-sm-2 control-label">出生日期</lable>
					<label><input type="text" name="borthday" value=""/></label>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">
					<input type="submit"  value="注册" />
					</label>
				</div>
		
				
			</form>
			   <div>
				  <p>带*的为必填项</p>
				</div>
		</div>
	</body>

</html>
