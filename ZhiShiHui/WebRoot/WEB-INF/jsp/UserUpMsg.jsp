<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改</title>
    
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
  body{
  	width:100%;
  }
  #content{
  	width:100%;
  	position:relative;
  	text-align:center;
  }
  table{
  	margin:0 auto;
  	padding-top:50px;
  }
  table tr td{
  	padding:10px;
  }
  table #headimg{
  	height:120px;
  	line-height:120px;
  }
  #headimg img{
  	height:100px;
  	line-height:100px;
  	border-radius:100%;
  }
  #sel{
  	margin:0;
  	height:10px;
  	line-height:10px;
  	position:absolute;
  	top:17%;
  	left:58%;
  }
  #butt{
  		width:80px;
  		height:30px;
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
  	text-align:center;
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
  	<div id="back" style="text-align:left;">
  		<span>
  			<a href="index"><img src="images/ZhuImg/goback.png"/>返回主页面</a>
  		</span>
  	</div>
    <form action="updateUser">
    	<table>
    		<tr id="headimg">
    			<td> 
    				头像&nbsp&nbsp&nbsp&nbsp 
    				<input type="hidden" name="user_picture" value="${list.user_picture}"/>
    				<img src="images/login/1.jpg"/>
    				<div id="sel">
    					<p><input type="button" value="选择图片"/></p>
    					<p>仅支持jpg、jpeg、png格式类型的图片。</p>
    					<p>图片大小限制最大为2MB。</p>
    				</div>
    				
     			</td>	
    		</tr>
    		<tr>
    			<td>
				    <hr style="height:2px;width:200px;border:none;border-top:1px solid #c0c0c0;" />
    				
    			</td>
    		</tr>
    		<tr>
    			<td>
    				用户名
    				<input type="text" name="user_name" value="${list.user_name}"/>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				密码
    				<input type="text" name="user_pwd" value="${list.user_pwd}"/>
    			</td>
    		</tr>
    		
    		<tr>
    			<td>
    				邮箱
    				<input type="text" name="user_email" value="${list.user_email }"/>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				首页
    				<input type="text" name="user_homepage" value="${list.user_homepage}"/>
    			</td>	
    		</tr>
    		<tr style="text-align:center;">
    			<td id="subs" colspan="2">
    				<input type="submit" value="提交" id="butt" style="color:white;"/>
    				<input type="reset" value="清除" id="butt" style="color:white;"/>
    			</td>
    		</tr>
    		
    		
    		
    		
    		
    		
    	</table>
    </form>
    </div>
  </body>
</html>
