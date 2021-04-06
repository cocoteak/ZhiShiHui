<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
      <!-- 评论模块 
 <div id="remark">
  <!-- 若有评论 -->
   <!--<c:forEach items="${contentList}" var="content" end="0">
     <c:if test="${content.devotion_id==requestScope.contribute.devotion_id}">-->
    <!-- 显示评论 -->
   <!-- <ul id="ul1">
   <li name="devotion_content">
   ${content.devotion_content}
   </li>
    </c:if>
   </ul>
   -->
  <!-- 若没有评论
   <c:if test="${content.devotion_id!=requestScope.contribute.devotion_id}" > 
     <p class="discuss">没有评论数据</p>     
   </c:if>
   </c:forEach>
  
 </div>

<div id="system">
   <form name="devotion_id" action="addRemark1" method="post"> 
     <!-- 传用户id 
     <c:forEach items="${userList}" var="user" >
       <c:if test="${user.user_id==requestScope.contribute.devotion_id}">
     <input type="hidden" name="user_id" value="${user.user_id }"/>
       <td align="center">
        ${user.user_name }评论：
         </td>
         </c:if>
     </c:forEach>--> 
  </body>
</html>
