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
    
    <title>My JSP 'resource_main.jsp' starting page</title>
    
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
    <h4>精品区</h4>
    <table border="1" style="margin: 0 auto;" width="600">
				<tr>
					<th>资源名</th>
					<th>作者</th>
					<th>所属空间</th>
					<th>更新时间</th>
				</tr>
				<c:forEach items="${listResource}" var="resource">
					<tr>
						<th>
							<a href="resource_">${resource.resource_title}&nsbp;${resource.resource_ifrefined}&nsbp;${resource.resource_ifmain}&nsbp;${resource.resource_label}</a>
						</th>
						<th>
							${resource.user.user_name}
						</th>
						<th>
							软件开发奥里给
						</th>
						<th>
							<c:forEach items="${updateList}" var="time" >
							<!--帖子未被回复-->
									<fmt:formatDate value="${resource.resource_createtime}"
										pattern="yyyy-MM-dd" />
							</c:forEach>
						</th>
					</tr>
				</c:forEach>
			</table>

			<table style="margin: 0 auto;">
				<tr>
					<c:if test="${isHasFirst}">
						<td>
							<a href="javascript:change(1)">首页</a>
						</td>
					</c:if>

					<c:if test="${isHasPre}">
						<td>
							<a href="javascript:change(${pageNow-1})">上一页</a>
						</td>
					</c:if>

					<c:if test="${isHasNext}">
						<td>
							<a href="javascript:change(${pageNow+1})">下一页</a>
						</td>
					</c:if>

					<c:if test="${isHasLast}">
						<td>
							<a href="javascript:change(${totalPage})">末页</a>
						</td>
					</c:if>
				</tr>

				<tr>
					<td colspan="5">
						<c:forEach begin="1" end="${totalPage}" var="i">
							<a href="javascript:change(${i})">${i} </a>
						</c:forEach>
					</td>
				</tr>
			</table>
  </body>
</html>
