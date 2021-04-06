<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="jquery/discuss/selectPost.js" charset="gb2312"></script>
    <title>My JSP 'reContent_select.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="jquery/discuss/jquery.js" charset="utf-8"></script>
	<script type="text/javascript"  charset="utf-8"  src="ueditor/utf8-jsp/ueditor.config.js"></script> <!-- udeditor配置文件  -->
<script type="text/javascript"  charset="utf-8"  src="ueditor/utf8-jsp/ueditor.all.min.js"></script> <!--udeditor核心文件 -->  
<script type="text/javascript"  charset="utf-8"  src="ueditor/utf8-jsp/lang/zh-cn/zh-cn.js"></script> <!-- udeditor语言文件 -->
	
  </head>
  
  <body>
  <form action="resourceContentList">
  <h3>${resource.resource_title}</h3><br/>
  ${resource.user_id}<br/>
  <textarea name="resource_content" id="resource_content" cols="50" rows="20" value="${resource.resource_content}">${resource.resource_content}</textarea>
	<fmt:formatDate value="${resource.resource_create_date}" pattern="yyyy-MM-dd" />
	<br/>

	<c:if test="${likeFlag}">
		<button name="likeBtn" type="button" value="${likeFlag}"> 已点赞 ${resource.resource_like_num}</button>
	</c:if>
	<c:if test="${likeFlag}">
		<button name="likeBtn" type="button" value="${likeFlag}"> 👍 ${resource.resource_like_num}</button>
	</c:if>

	<c:if test="${disLikeFlag}">
		<button name="disLikeBtn" type="button" value="${disLikeFlag}"> &nbsp; 👎 &nbsp;</button>
	</c:if>

	<br/>
	<br/>
	<!-- 评论区显示 -->
	<c:forEach items="${listContent}" var="ResourceContent">
		    <br/><br/>
			${ResourceContent.resource_reply} <fmt:formatDate value="${ResourceContent.resource_updatedate}" pattern="yyyy-MM-dd"/> 
			
		    <c:forEach items="${content.replyContents}" var="childContent">
				<br/>
				&nbsp;&nbsp;&nbsp;&nbsp;${childContent.resource_reply} <fmt:formatDate value="${childContent.resource_updatedate}" pattern="yyyy-MM-dd"/>
			</c:forEach>
	</c:forEach>
	<br/>
	<form action="addReply" id="replyForm">
		<input type="hidden" id="resource_id" name="resource_id" value="${resource.resource_id}" />
		<tr>
			<td>{ResourceContent.resource_reply}</td>
		</tr>
		<tr>
				 <td><textarea name="resource_reply" id="myEditor"></textarea>
		       	<script type="text/javascript">
		           UE.getEditor('myEditor');
		       </script>
			</td>
		</tr>
		
	</form>
	</form>
  </body>
</html>
