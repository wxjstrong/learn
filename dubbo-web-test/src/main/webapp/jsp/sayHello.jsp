<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>welcome</title>
  </head>
  
  <body>
    <div>
       <form action="../testDubbo/sayHello.do" mothed="post">
           <label>请输入您的姓名：</label>
           <input type="text" name="userName" value=""/>
           <input type="submit"  value="提交"/>
       </form>    
    </div>
  </body>
</html>
