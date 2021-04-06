<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<script type="text/javascript">
	// 资源跳转到指定的页
	function toPage(pageNo, resourceType){
	   if(resourceType == 1) {
	   		window.location.href="main?pageNow="+pageNo+" &resource_if_main="+1;
	   } else if(resourceType == 2) {
	   		window.location.href="main?pageNow="+pageNo+" &resource_if_refined="+1;
	   } else {
	   	    window.location.href="main?pageNow="+pageNo;
	   
	   }
	}
</script>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'main.jsp' starting page</title>
    
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
   
   		<a href="main">全部</a>
		<a href="main?resource_if_main=1">核心区</a>
		<a href="main?resource_if_refined=1">精品区</a>
		<a href="selectResource">查找资源</a>
		<a href="insertResource">发布资源</a>
  		<h3>学习空间&gt;软件开发奥里给&gt;资源区</h3><br/>
	    <div class="content">
				<form action="selectResource" method="post" id="form1" style="text-align: center;">
					<input type="hidden" id="resourceType" name="resourceType" value="${resourceType}" />
					<input type="hidden" id="pageNow" name="pageNow" value="1" />
					<input type="hidden" id="totalPage" value="${totalPage}" />
				</form>
	
				<table border="1" style="margin: 0 auto;" width="600">
					<tr>
						<th>
							资源名
						</th>
						<th>
							作者
						</th>
						<th>
							所属空间
						</th>
						<th>
							更新时间
						</th>
					</tr>
	
					<c:forEach items="${listResource}" var="resource">
						<tr>
							<th>
								<a href="resourceContentList?resourceId=${resource.resource_id}">${resource.resource_title}[${resource.resource_label}]</a>
							</th>
							<th>
								${resource.user_id}
							</th>
							<th>
								软件开发奥里给
							</th>
							<th>
								<fmt:formatDate value="${resource.resource_create_date}" pattern="yyyy-MM-dd HH:mm:ss" />
							</th>
							<th><a href="deleteResourceById?resource_id=${resource.resource_id}">删除</a></th>
						</tr>
					</c:forEach>
				</table>
	
				<table style="margin: 0 auto;">
					<tr>
						<c:if test="${ps.hasFirst}">
							<td>
								<a href="javascript:toPage(1, ${resourceType})">首页</a>
							</td>
						</c:if>
						<c:if test="${ps.hasPre}">
							<td>
								<a href="javascript:toPage(${ps.pageNow-1}, ${resourceType})">上一页</a>
							</td>
						</c:if>
						<td>当前页：${ps.pageNow }</td>
						<c:if test="${ps.hasNext}">
							<td>
								<a href="javascript:toPage(${ps.pageNow+1}, ${resourceType})">下一页</a>
							</td>
						</c:if>
						<c:if test="${ps.hasLast}">
							<td>
								<a href="javascript:toPage(${ps.totalPage}, ${resourceType})">末页</a>
							</td>
						</c:if>
						<td colspan="5">
							总页数:${ps.totalPage}
						</td>
						<td colspan="5">
							资源总数:${ps.totalSize}
						</td>
					</tr>
				</table>
			</div>
  </body>
  </html>
  

