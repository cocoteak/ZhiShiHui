<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>社区</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!-- BootStrap核心CSS文件 -->
	<link rel="stylesheet" type="text/css" href="BootStrap 3.3.5/css/bootstrap.min.css">
	<!-- jQuery文件 务必在引入bootstrap.min.js 之前引入 -->
	<script type="text/javascript" src="BootStrap 3.3.5/js/jquery-3.3.1.min.js"></script>
	<!-- BootStrap核心JavaScript文件 -->
	<script type="text/javascript" src="BootStrap 3.3.5/js/bootstrap.min.js"></script>
	
</head>
<body>
社区
</body>
</html>
