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
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'selectResource.jsp' starting page</title>
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
    <h3>学习空间>软件开发奥里给>资源区</h3><br/>
    <div class="content">
			<form action="selectResource" method="post" id="form1" style="text-align: center;">
				<input type="hidden" id="resource_ifrefined" name="resource_ifrefined" value="${paramResource.resource_if_refined}" />
				<input type="hidden" id="pageNow" name="pageNow" value="1" />
				<input type="hidden" id="totalPage" value="${totalPage}" />
				<!-- 条件查询-->	
				按资源名：
				<input name="resource_title" placeholder="请输入资源名关键字" /><br/>
	  			按作者：
				<input name="user_id" /><br/>
				按标签：
				<input name="resource_label"/><br/>
	
				<input type="submit" value="查询">
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
							<fmt:formatDate value="${resource.resource_create_date}" pattern="yyyy-MM-dd" />
						</th>
					</tr>
				</c:forEach>
			</table>

			<table style="margin: 0 auto;">
				<tr>
					<c:if test="${ps.hasFirst}">
						<td>
							<a href="javascript:toPage(1)">首页</a>
						</td>
					</c:if>

					<c:if test="${ps.hasPre}">
						<td>
							<a href="javascript:toPage(${pageNow-1})">上一页</a>
						</td>
					</c:if>

					<c:if test="${ps.hasNext}">
						<td>
							<a href="javascript:toPage(${pageNow+1})">下一页</a>
						</td>
					</c:if>

					<c:if test="${ps.hasLast}">
						<td>
							<a href="javascript:toPage(${totalPage})">末页</a>
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

<script type="text/javascript">
	// 资源跳转到指定的页
	function toPage(pageNo){
		window.location.href="selectResource?pageNow="+pageNo;
	}
</script>
