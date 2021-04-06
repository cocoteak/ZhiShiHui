<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>未接受</title>
    
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
  *{
  margin: 0;
  padding: 0;
 }
  .a1 p{
   margin-left:40px;
   border-top:1px solid #d3d1d1;
   border-bottom:1px solid #d3d1d1;
   color:#d3d1d1;
   text-align:center;
    line-height:50px;
  }
  </style>
  <body>
   <div class="a1">
        <p >暂无数据</p>
               </div>
  </body>
</html>
