<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'top.jsp' starting page</title>
    
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
  hr{
	  margin:0px;
	  padding:0px;
      width:1000px;
      text-align:left;
      margin-left:60px;}
  #poem{
    margin-left:60px;
    margin-top:10px;
    color:#000;
    font-family:宋体; 
   }
 *{
  margin: 0;
  padding: 0;
  
 }
 .aa{
	text-decoration:none;
	color:#000;}
 a:hover{
	color:#39F;}
 </style>
  <body>
    <div id="poem"><h4> <a href="#" class="aa">学习空间 > <a href="#" class="aa">软件开发奥利给 </a> >
    </div>
    <br/>
  <hr/> 
  </body>
</html>
