<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查看个人信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <style type="text/css">
  	#content{
  		width:100%;
  	}
  	table{
  		width:30%;
  		height:50%;
  		text-align:center;
  		margin-top:30px;
  		margin-left:30%;
  	}
  	table tr td{
  		height:50px;
  	}
  	table #headimg{
  		height:200px;
  		line-height:200px;
  	}
  	#headimg img{
  		height:100px;
  		border-radius:100%;
  	}
  	#butt{
  		width:200px;
  		height:45px;
  		font-size:18px;
  		font-weight:bold;
  		border:1px;
  		background-color:#0367ad;
  		color:#fffff;
  	}
 #back a{
  	text-decoration:none;
  	color:#cdcdcd;
  	height:30px;
  	line-height:30px;
  	inline-height:30px;
  }
  #back img{
  	height:30px;
  }
  #back a:hover{
  	color:#0367ad;
  }
  </style>
  <body>
  <div id="content">
  	<div id="back">
  		<span>
  			<a href="index"><img src="images/ZhuImg/goback.png"/>返回主页面</a>
  		</span>
  	</div>
  	<form action="UserUpdate">
  	
    <table>
    	<tr id="headimg">
    		<td>头像</td>
    		<td>${user.user_picture }
    			<img src="images/login/1.jpg"/>
    			
    		</td>
    			
    	</tr>
    	<tr>
    		<td>
    			 <hr style="height:2px;width:300px;border:none;border-top:1px solid #c0c0c0;" />
    		</td>
    	</tr>
    	<tr>
    		<td>用户名</td>
    		<td>${user.user_name }</td>	
    	</tr>
    	<tr>
    		<td>电话</td>
    		<td>${user.user_phone }</td>	
    	</tr>
    	<tr>
    		<td>邮箱</td>
    		<td>${user.user_email }</td>	
    	</tr>
    	<tr>
    		<td>职位</td>
    		<td>${user.user_job }</td>	
    	</tr>
    	<tr>
    		<td>部门</td>
    		<td>${user.user_dept }</td>	
    	</tr>
    	<tr>
    		<td>首页</td>
    		<td>${user.user_homepage }</td>	
    	</tr>
    	<tr style="text-align:center;">
    		<td colspan="2">
    			<input type="submit" value="修改个人信息" id="butt" style="color:white;"/>
    		</td>
    	</tr>
    </table>
    </form>
    </div>
  </body>
</html>
