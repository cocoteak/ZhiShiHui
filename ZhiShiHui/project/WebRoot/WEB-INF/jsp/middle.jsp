<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>选项卡</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
li{
  list-style: none;
 }
 /*选项卡效果*/
 /*设置一个居中的大盒子*/
 /*给选项设置样式*/

 ul{
  width: 1000px;
  height: 43px;
  position: relative;
   margin-top:0px;
 }
  li{
  width: 80px;
  height: 40px;
  float: left;
  font-size:14px;
  color:#000;
  line-height: 48px;
  text-align: center;
  border-right:1px solid #f5f5f5 ;
 }  
 li input{
  display:none;
 }
 li label{
  display:block;
  width: 80px;
  height: 40px;
 }
  li input:checked+label{
  font-weight:bold;
 }
 /*加入点击弹出卡片效果*/
  li input:checked+label{
  display:block;
 }
 .a1{
  width:100%;
  height:50px;
  line-height:50px;
  margin-top:-40px;
  border-top:1px solid #d3d1d1;
  border-bottom:1px solid #d3d1d1;
  color:#d3d1d1;
  /*border:1px solid #d3d1d1;*/
  }
a{
	text-decoration:none;
	color:#000;}
 a:hover{
	color:#39F;}
</style>
  </head>
  
  <body>
   <!-- 选项卡开始 -->

 <ul>
  <li>
   <input type="radio" name="nav1" id="a1">
   <label for="a1"><a href="no" target="main">待解决</a></label>
             
  </li>

  <li>
   <input type="radio" name="nav1" id="a2">
   <label for="a2"><a href="selectContributeWithParam1?pageNow=1" target="main">已接受</a></label>
               
  </li>

  <li>
   <input type="radio" name="nav1" id="a3">
   <label for="a3"><a href="notyet" target="main">未接受</a></label>
                
  </li>
<li>
   <input type="radio" name="nav1" id="a4">
   <label for="a4"><a href="selectContributeWithParam1?pageNow=1" target="main">全部</a></label>
  </li>
 </ul>
  </body>
</html>
