<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询学习空间</title>
	<!-- BootStrap核心CSS文件 -->
	<link rel="stylesheet" type="text/css" href="BootStrap 3.3.5/css/bootstrap.min.css">
	<!-- jQuery文件 务必在引入bootstrap.min.js 之前引入 -->
	<script type="text/javascript" src="BootStrap 3.3.5/js/jquery-3.3.1.min.js"></script>
	<!-- BootStrap核心JavaScript文件 -->
	<script type="text/javascript" src="BootStrap 3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<div style="height:1200px;width:100%;">
<c:choose>
  <c:when test="${empty sessionScope.studySpaceList}">
	<div>
		<span style="color:gray;text-align:center;">暂无数据</span>
		<hr/>
	</div>
  </c:when>
  <c:otherwise>
	<div>
  		<table border="1" class="table table-striped">
  		 <c:forEach items="${sessionScope.studySpaceList}" var="studySpacelist">
  			<tr height="55px">
  				<td width="89%">
  					<div style="padding-left:5px;float:left;">
  						<!-- <img src="images/ZhuImg/GXT_pink.jpg" width="40px" height="40px" class="img-circle"> -->
  						<img src="upload_images/${studySpacelist.space_picture}" width="40px" height="40px" class="img-circle">&nbsp;&nbsp;  
  					</div>
  					<div style="float:left;">  						
  						<c:choose>
  							<c:when test="${studySpacelist.space_top==1}">
  								<span class="label label-danger">置顶</span>&nbsp;  																													
  								<a href="studySpaceIndex?space_id=${studySpacelist.space_id}"  target="iframeContent" style="color:black;font-weight:bolder;" target="main">${studySpacelist.space_name}</a>&nbsp;&nbsp;
  						    </c:when>
  							<c:otherwise> 
  								<a href="studySpaceIndex?space_id=${studySpacelist.space_id}"  target="iframeContent" style="color:black;font-weight:bolder;" target="main">${studySpacelist.space_name}</a>&nbsp;&nbsp;
  							</c:otherwise>  								
  						</c:choose>	  												
  						<span style="color:gray;">
  							<a href="#" target="iframeContent"><span style="color:gray;">-&nbsp;${studySpacelist.userName}-&nbsp;</span></a>
  							创建于：<fmt:formatDate value="${studySpacelist.space_createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>					
  						</span>
  						<div style="height:25px;line-height:25px;">  							
  							<span>${studySpacelist.space_describe}</span>		
  						</div>	
  					</div>
  				</td>
  				<td width="11%">
  					<div>
  						<img src="images/ZhuImg/space_laud.png" alt="点赞" class="img-circle" width="16px" height="16px"/>&nbsp;${studySpacelist.space_laudCount}&nbsp;
  						<img src="images/ZhuImg/space_collect.png" alt="收藏" class="img-circle"  width="16px" height="16px"/>&nbsp;${studySpacelist.space_collectCount}&nbsp;
  						<c:choose>
  							<c:when test="${studySpacelist.space_status==1}">  								
  								<img src="images/ZhuImg/space_public.png" alt="公开" class="img-circle"  width="16px" height="16px"/>
  						    </c:when>
  							<c:otherwise>
  								<img src="images/ZhuImg/space_lock.png" alt="私有" class="img-circle"  width="16px" height="16px"/>
  							</c:otherwise>  								
  						</c:choose>	  					
  						<br/>
  						更新于：<fmt:formatDate value="${studySpacelist.space_updatetime}" pattern="yyyy-MM-dd HH:mm:ss"/>
  					</div>
  				</td>
  			</tr>  			
  		 </c:forEach> 
  		</table>
  	  </div>
	</c:otherwise>  								
</c:choose>	
  	</div>   	
</body>
</html>