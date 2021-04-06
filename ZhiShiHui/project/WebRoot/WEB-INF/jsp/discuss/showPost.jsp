<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showPost2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="jquery/discuss/index.js"></script>
	<style type="text/css">
		#toptit a{
			text-decoration:none;
			color:#0367ad;
			font-size:18px;
			margin-bottom:30px;
		}
		#toptit a:hover{
			color:black;
		}
		#topselect a{
			text-decoration:none;
			color:black;
		}
		#topselect a:hover{
			text-decoration:none;
			color:#0367ad;
		}
		#butt{
			background:#0367ad;
			color:white;
			border:1px white;
			border-radius:5px;
		}
	</style>
  </head>
  <body>
    <div id="toptit">
    	<a href="selectStudySpace" target="_parent">学习空间</a>
    	><a href="selectHomepage">${sessionScope.studySpace.space_name}</a>
    	>讨论区
    	
    </div>
    <div id="topselect">
  		<a href="selectPost" target="mainFrame">全部</a>
   		<a href="selectPost?post_ifrefined=2" target="mainFrame">精选</a>
   		<a href="selectPost?selectCollection=true" target="mainFrame">收藏</a>
   		<input type="button" value="新建资源贴" onclick="javascript:createPost()" id="butt">
	</div>
   <br/>
   <iframe id="mainFrame" name="mainFrame" src="selectPost"  width="1200" height="800" ></iframe>
   
  </body>
</html>
