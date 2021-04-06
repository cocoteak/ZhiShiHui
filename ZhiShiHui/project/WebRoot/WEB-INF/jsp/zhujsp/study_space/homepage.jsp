<%@ page language="java" import="java.util.*,com.zhuzsh.domain.*" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主页面</title>
    
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
	
<style type="text/css">
*{
	margin:0px;
	padding:0px;
}
#nav{
	width:90%;
	height:20px;
	margin:20px auto;	
}	
#nav a:hover span{
	color:#66CCFF;
}
#nav hr{
	color:gainsboro;
}
#describe{
	width:40%;
	height:180px;	
	left:70px;
	top:70px;	
	position:relative;
}
#describe #space_img{
	padding-left:20px;	
}
#space_describe{	
	padding-left:40px;
	padding-top:10px;
}
#collectAndLaud{
	width:45%;
	height:100px;	
	left:640px;
	top:-60px;
	position:relative;
}
#ManaTeam{
	width:90%;
	height:60px;
	margin:20px auto;	
	top:-40px;	
	position:relative;
}
.ManaImg{
	width:100px;	
	text-align:center;
	box-shadow: 2px 2px 2px	LightCyan;
	float:left;
}
#latelyResource{
	width:44%;
	height:400px;
	left:70px;
	top:50px;
	position:relative;
}
#activeTopic{
	width:45%;
	height:400px;
	left:700px;
	top:-350px;
	position:relative;
}
</style>
</head>  
  <body>
	<div id="nav">
		<div style="border-bottom:1px solid WhiteSmoke;padding-bottom:10px;">
			<a href="selectStudySpace" style="text-decoration:none;color:black;" target="iframeContent"><span style="font-weight:bolder;font-size:18px;">学习空间</span></a>
  			<span style="color:threedface;">&nbsp;&nbsp;&gt;&nbsp;&nbsp;</span>
  			<span style="color:gray">${sessionScope.studySpace.space_name}</span>	
		</div>  				
  		<c:if test="${sessionScope.studySpace.space_status==0}">
  			<div class="alert alert-warning alert-dismissable">
  				<button type="button" class="close" data-dismiss="alert" aria-hidden="true" height="10px">&times;</button>
					当前空间为私有空间，非空间成员用户无法访问也不会出现在搜索结果中。可以在空间设置中申请公开空间。
			</div>			
		</c:if>	
  	</div>
  	<div id="describe">
  		<div id="space_img">
  			<img src="upload_images/${sessionScope.studySpace.space_picture}" width="120px" height="120px" class="img-rounded">&nbsp;&nbsp;&nbsp;&nbsp;
  			<span style="font-weight:bolder;">${sessionScope.studySpace.space_name}</span>&nbsp;&nbsp; 		
  			<c:choose>
  				<c:when test="${sessionScope.studySpace.space_status==1}">  								
  					<img src="images/ZhuImg/space_public.png" alt="公开" class="img-circle"  width="16px" height="16px"/>
  				</c:when>
  				<c:otherwise>
  					<img src="images/ZhuImg/space_lock.png" alt="私有" class="img-circle"  width="16px" height="16px"/>
  				</c:otherwise>  								
  			</c:choose>	  			
  		</div>  		
  		<div id="space_describe">
  			<p>${sessionScope.studySpace.space_describe}</p>
  		</div>
  	</div>  	
  	<div id="collectAndLaud">
  		<!-- 假设当前登录的用户user_id=1 -->  	
  		<!-- 如果当前用户不是此空间的创建者，那么把当前用户从成员表中删除 -->
  		<c:choose>
  			<c:when test="${sessionScope.studySpace.user_id==1}">  								
  				<a href="#"><button  type="button" class="btn btn-default" disabled>退出空间</button></a>
  			</c:when>
  			<c:otherwise>  				
  				<a href="#" target="study_space_index_main">
  					<button type="button" class="btn btn-default">退出空间</button>
   				</a>
  			</c:otherwise>  								
  		</c:choose>  	
  		<!-- 点赞 -->	
  		<button type="button" class="btn btn-default">点赞</button>
  		<!-- 收藏 --> 
  		<button type="button" class="btn btn-default">收藏</button> 		
  	</div>   
  	<div id="ManaTeam">
  		<div class="panel panel-default">
   			<div class="panel-heading">
        		<h3 class="panel-title">
           			管理团队
      			</h3>
   			</div>
    		<div class="panel-body">
    			<!-- ne 表示不相等 -->
    			<c:forEach items="${sessionScope.spaceManaTeamList}" var="spaceManaTeamlist">
    				<c:if test="${spaceManaTeamlist.space_member_status gt 0}">
        				<div class="ManaImg">
        					<span>${spaceManaTeamlist.userPicture}</span>
        					<img src="upload_images/${spaceManaTeamlist.user.user_picture}" width="60px" height="60px" class="img-circle">
        					<br/>
        					<span>${spaceManaTeamlist.user.user_name}</span>        			
        				</div>
        			</c:if>
        		</c:forEach>
    		</div>
		</div>	
  	</div>
  	<div id="latelyResource">
  		<div class="panel panel-default">
   			<div class="panel-heading">
        		<h3 class="panel-title">
           			最新资源
      			</h3>
   			</div>
    		<div class="panel-body">
    			最新资源
    		</div>
		</div>	
  	</div>
  	<div id="activeTopic">
  		<div class="panel panel-default">
   			<div class="panel-heading">
        		<h3 class="panel-title">
           			活跃话题
      			</h3>
   			</div>
    		<div class="panel-body">
    			活跃话题
    		</div>
		</div>	
  	</div>
 </body>
</html>
