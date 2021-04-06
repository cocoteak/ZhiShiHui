<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Welcome to ZSH2.0 LOGIN PAGE</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
  </head>
  <style type="text/css">
  body{
 	 position:relative;
 	 background-image:url(images/login/loginbg.jpg);
  	font-family:"微软雅黑";
  }
  div{
  	clear:both;
  }
  #contnet{
  	position:absolute;
  	left:60%;
  	top:150px;
  	background:rgba(0,0,0,0.3);
  }
  #img{
  	position:absolute;
  	left:20%;
  	top:100px;
  	color:white;
  }
  #img p{
  	margin-left:15%;
  	width:600px;
  	font-size:28px;
  	font-weight:bold;
  }
  #img p span{
  	font-size:14px;
  }
  #choice{
  	position:absolute;
  	left:60%;
  	top:150px;
  }
 
 #chlice ul{
 	clear:both;
 }
 #choice ul li{
 	width:180px;
 	height:50px;
 	line-height:50px;
 	font-weight:bold;
 	font-size:18px;
 	text-align:center;
 	list-style-type:none;
 	float:left;
 	display:block;
  	background:rgba(10,180,180,0.3);
 }
 #choice a{
 	display:block;
 	color:#fffff;
 }
 #choice a:hover{
 	background:rgba(0,0,0,0.3);
 	color:#fffff;
 }
 #log{
  	position:absolute;
  	left:62.7%;
  	top:215px;
 	width:360px;
 	font-size:18px;
  	background:rgba(255,255,255,0.5);
  	color:#fffff;
  }
 #log table{
 	padding-left:40px;
 	font-size:18px;
 	padding-top:20px;
 }
 #log table tr td{
 	height:40px;
 	line-height:40px;
 	margin:15px;
 }
 #reg{
 	position:absolute;
  	left:62.7%;
  	top:215px;
 	width:360px;
  	display:none;
  	background:rgba(255,255,255,0.5);
  	color:#fffff;
 }
 #reg table{
 	padding-left:40px;
 	padding-top:20px;
 	font-size:18px;
 }
 #reg table tr td{
 	height:40px;
 	line-height:40px;
 	margin:15px;
 }
 input{
 	margin-left:10px;
 	border:1px;
 	height:24px;
 	border-radius:5px;
 	background:#fffff;
 	border:1px;
 }
#butt{
 	height:30px;
 	width:150px;
 	line-height:30px;
 	border-radius:0px;
 	font-weight:bold;
 	background:rgba(255,255,255,0.8);
 }
  </style>
  
  <body>
  <div id="img">
  	<img src="images/login/log.png" width="110px">
  	<br/>
  	<p>
  		Welcome to ZSH project!<br/>
  		<span>
  		欢迎，请登录或注册！
  		</span>
  	</p>
  </div>
  <div id="content">
  	<div id="choice">
  		<ul>
  			<li id="denglu" onclick="denglu()">
  				<a style="color:white">登录</a>
  			</li>
  			<li id="zhuce" onclick="zhuce()">
  				<a style="color:white">注册</a>
  			</li>
  		</ul>
  	</div>
    <div id="log">
    	<form:form action="loginon" method="post" name="logi" modelAttribute="logg">
    		<table>
    			<tr>
    				<td> 
    					手机号
    				</td>
    				<td>
    					<input type="text" id="user_phone" name="user_phone"/>	
    				</td>
    			</tr>
    			<tr>
    				<td>
    					密码
    				</td>
    				<td>
    					<input type="password" id="user_pwd" name="user_pwd"/>	
    				</td>
    			</tr>
    			<tr>
    				<td>
    					验证码
    				</td>
    				<td>
    					<input type="text" name="checkcode" id="checkCode"  style="margin-top:20px;margin-left:10px;margin-bottom:5px;"/>
    					<div class="code2">
			              <!-- 验证码 -->
				             <a href="javascript:;" >
				             <img id="captchaImage" src="getCode.do"/>
				             </a>
				             <script>
				             // 更换验证码
					         $('#captchaImage').click(function() {
					                 $('#captchaImage').attr("src", "getCode?timestamp=" + (new Date()).valueOf());
					         }); 
				             </script>
			        	</div>
    				</td>
    			</tr>
    			
    			<tr>
    				<td colspan="2" style="text-align:center">
    					<input type="submit" value="登录" onclick="return logi()" id="butt"/>	
    				</td>
    			</tr>
    			
    			<tr>
    				<td id="texts" colspan="2">
   						 <font color="red">${requestScope.msg}</font>
   					</td>
    			</tr>
    		</table>
    	</form:form>
    </div>
    

    <div id="reg">
    	<form:form action="register" method="post" name="regist" modelAttribute="regg">
    		<table>
    			<tr>
    				<td> 
    					昵称
    				</td>
    				<td>
    					<input type="text" id="register_user_name" name="register_user_name"/>	
    				</td>
    			</tr>
    			
    			<tr>
    				<td> 
    					手机号
    				</td>
    				<td>
    					<input type="text" id="register_user_phone" name="register_user_phone"/>	
    				</td>
    			</tr>
    			
    			<tr>
    				<td>
    					密码
    				</td>
    				<td>
    					<input type="password" id="register_user_pwd" name="register_user_pwd"/>	
    				</td>
    			</tr>
    			<tr>
    				<td colspan="2" style="text-align:center" >
    					<input type="submit" value="注册" onclick="return regist()" id="butt"/>	
    				</td>
    			</tr>
    			
    			<tr>
    				<td id="texts" colspan="2">
   						 <font color="red">${requestScope.msg}</font>
   					</td>
    			</tr>
    		</table>
    	</form:form>
    	
    	
    	
    	
    	
     </div>
      <!-- js设置登录注册功能界面隐藏 -->
      <script type="text/javascript">
      	function denglu(){
      		var denglu=document.getElementById("log")
      		var zhuce=document.getElementById("reg")
      		denglu.style.display='block';
      		zhuce.style.display='none';
      	}
      	function zhuce(){
      		var denglu=document.getElementById("log")
      		var zhuce=document.getElementById("reg")
      		denglu.style.display='none';
      		zhuce.style.display='block';
      	}
      </script>
      
   </div>
  </body>
</html>

