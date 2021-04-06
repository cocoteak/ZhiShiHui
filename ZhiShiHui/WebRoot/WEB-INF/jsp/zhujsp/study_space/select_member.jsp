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
    
    <title>成员</title>
    
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
	color:#0367ad;
}
#nav hr{
	color:gainsboro;
}
#spacename{
	color:#0367ad;
	color:black;
	font-weight:bolder;
	font-size:23px;
}
a:hover{
	text-decoration:none;
}
#memberTop{
	width:90%;
	height:60px;
	padding-left:10px;
	margin:20px auto;	
}
#memberTeam{
	width:90%;
	height:60px;
	padding-left:10px;
	margin:20px auto;	
}
</style>
	
  </head>
  
  <body>
  <div id="nav">
		<div style="border-bottom:1px solid WhiteSmoke;padding-bottom:10px;">
			<a href="selectStudySpace" style="text-decoration:none;color:black;" target="iframeContent"><span style="font-weight:bolder;font-size:18px;">学习空间</span></a>
  			<span style="color:#0367ad;">&nbsp;&nbsp;&gt;&nbsp;&nbsp;</span>
  			<a href="selectHomepage" target="study_space_index_main" id="spacename"><span >${sessionScope.studySpace.space_name}</span></a>	
  			<span style="color:#0367ad;">&nbsp;&nbsp;&gt;&nbsp;&nbsp;</span>
  			<span style="color:gray">成员</span>	
		</div>	
  	</div>
  	<div id="memberTop">
  		<p style="font-weight:bolder;font-size:24px;">空间成员</p>  	
  		<p>用户可以通过空间主页或参与贡献、发表话题贴的方式加入公开的空间。</p>		  		
  	</div>  	
  	<div id="memberTeam">
  		<div class="panel panel-default">
   			<div class="panel-heading">
        		<h3 class="panel-title">
           			<span style="font-size:16px;font-weight:bolder;">${sessionScope.studySpace.space_name}</span>
           			<span style="color:gray">&nbsp;的成员&nbsp;</span>	
           			<span class="badge">${sessionScope.spaceMemberCount}</span>
      			</h3>
      			<div style="float:right;margin-top:-35px;">
      				<form class="navbar-form navbar-left" role="search" action="selectMember" method="post">
        				<div class="input-group">
              			  <input type="text" class="form-control" placeholder="根据名称搜索" name="memberName" value="${memberName}">
              		 		 <span class="input-group-btn">
                  	  			<button class="btn btn-default" type="submit" style="background-color:WhiteSmoke;">搜索</button>
               		  		</span>
            			</div>
   		  			</form>
   		  		</div>
   			</div>
   		<c:choose>
   			<c:when test="${empty sessionScope.memberList}">
   				<div class="panel-body" style="text-align:center;color:gray;">  
   					<span>暂无数据</span>
   				</div> 
   			</c:when>   				
   		<c:otherwise>
    		<div class="panel-body">   
    		  <table class="table table-striped"> 			
    			<c:forEach items="${sessionScope.memberList}" var="memberlist">
    				<tr>
    					<td width="85%">    						
    						<div style="float:left;padding-right:20px;">
    							<img src="upload_images/${memberlist.user.user_picture}" class="img-circle" height="45px" width="45px">
    						</div>
    						<div>
    							<a href="#" target="iframeContent">
    								<span style="font-weight:bolder;font-size:16px;">${memberlist.user.user_name}</span>    								
    							</a>
    							<c:if test="${memberlist.space_member_status==2}">
    								<span class="label label-info" style="font-size:14px;font-weight:normal;">你自己</span>
    							</c:if>
    							<br/>
    							<span>加入于：<fmt:formatDate value="${memberlist.space_member_createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
    						</div>    							
    					
    					</td>
    					<td width="15%">
    						<div>
    							<c:if test="${memberlist.space_member_status==0}">
    								<div style="margin-top:10px;">
    									<span class="label label-default" style="font-size:16px;font-weight:normal;background-color:LightGrey;">成员</span>
    								</div>
    							</c:if>   
    							<c:if test="${memberlist.space_member_status==1}">
    								<div style="margin-top:10px;">
    									<span class="label label-default" style="font-size:16px;font-weight:normal;background-color:LightGrey;">管理者</span>
    								</div>
    							</c:if>   
    							<c:if test="${memberlist.space_member_status==2}">
    								<div style="margin-top:10px;">
    									<span class="label label-default" style="font-size:16px;font-weight:normal;background-color:LightGrey;">创建者</span>
    								</div>
    							</c:if>   
    						</div>  					
    					</td>
    				</tr>	
        		</c:forEach>
        	</table>
    	  </div>
      </c:otherwise>
   	</c:choose>
		</div>	
  	</div>  				
  </body>
</html>
