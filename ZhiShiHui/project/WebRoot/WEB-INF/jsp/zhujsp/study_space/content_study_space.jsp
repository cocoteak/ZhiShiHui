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
    
    <title>学习空间</title>
    
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
#search{
	width:90%;
	height:50px;
	margin:20px auto;
	font-size:16px;
	border-top:1px solid gainsboro;
}
#search_left ul{
	list-style-type:none;
}
#search_left ul li{
	width:100px;
	float:left;
	line-height:55px;
	text-align:center;
	
}
#search_left ul a:hover{
	color:black;	
}
.active{
	font-weight:bolder;
	color:black;
	border-bottom:2px solid black;
}
#search_left ul a{
	color:gray;
	text-decoration:none;
}
.clear{
	clear:both;	
	border-top:1px solid gainsboro;
}
#search_left  #spanBtn{
	float:right;
	margin-right:20px;
}
#search_middle{
	float:right;	
	margin-top:7px;
	margin-right:35px;
}
#search_right{	
	margin-top:7px;
	margin-right:5px;
	float:right;	
}
#show_space_data{
	width:90%;
	margin:0px auto;
	margin-top:30px;
}
#show_space_data #iframe_main{
	width:100%;	
	height:100%;
}
</style>

<script type="text/javascript">
	window.onload = function(){//利用选项卡的知识+框架的知识
		var top = document.getElementById('search');
		var li = top.getElementsByTagName('li');		
		for(var i = 0 ;i < li.length; i++){
			li[i].index = i; //li[0].index = 0
			li[i].onclick = function(){
				for(var i = 0;i< li.length;i++){
					li[i].className = '';	//循环遍历去掉class样式					
				}
				//当去掉所有class样式之后，再向当前对象添加class样式
				li[this.index].className = 'active';									
			}			
		}
		var e = document.createEvent("MouseEvents");
			e.initEvent("click", true, true);	
			document.getElementById("recommend_space").dispatchEvent(e);
	}
	function autoSubmitChoose(){
		var chooseValue = document.getElementById('choose').value;
		var autoClick_choose = document.getElementById('autoClick_choose');		
		if(chooseValue !=null){
			autoClick_choose.href = 'byChoose?choose='+chooseValue;
			alert(chooseValue);
		}else{
			autoClick_choose.href = 'byChoose?choose= ';
		}			
		var e = document.createEvent("MouseEvents");
			e.initEvent("click", true, true);
			document.getElementById("autoClick_choose").dispatchEvent(e);
	}
</script>
  </head>
  <body>
  	<div id="nav">
  		<a href="selectStudySpace"  style="text-decoration:none;color:black;" target="iframeContent"><span style="font-weight:bolder;font-size:20px;padding-left:10px;">学习空间</span></a>
  	</div>
  	<div id="search">	
  	  <div id="search_left">  	  		
  		<ul>
  			<a href="byType?type=recommend" id="recommend_space" target="content_study_space_main"><li class="active">推荐空间</li></a>
  			<a href="byType?type=see" id="see_space" target="content_study_space_main"><li>查看空间</li></a>
  			<a href="byType?type=collect" id="collect_space" target="content_study_space_main"><li>收藏空间</li></a>
  			<a href="byType?type=my" id="my_space" target="content_study_space_main"><li>我的空间</li></a>
  		</ul>  		   			 		
  	  </div> 
  	  <div id="search_right">
			<span id="spanBtn"><a href="createStudySpace?userId=1"><button type="button" class="btn btn-info">新建学习空间</button></a></span>	  
  	  </div>
  	  <div id="search_middle">
  	  	<form role="form">  	  			 	
   		  	 <div class="form-group" style="width:200px;">   
   		  	 	<a href="#" target="content_study_space_main" id="autoClick_choose"></a>	  		  	 	 
  	  				<select class="form-control" id="choose" onchange="autoSubmitChoose()">
  	  					<option value="recent_update" <c:if test="${sessionScope.choose=='recent_update'}">selected</c:if>>最近更新</option>
  	  					<option value="recent_create" <c:if test="${sessionScope.choose=='recent_create'}">selected</c:if>>最近创建</option>
  	  					<option value="most_collect" <c:if test="${sessionScope.choose=='most_collect'}">selected</c:if>>最多收藏</option>	
  	  					<option value="earliest_create" <c:if test="${sessionScope.choose=='earliest_create'}">selected</c:if>>最早创建</option>	
  	  					<option value="earliest_update" <c:if test="${sessionScope.choose=='earliest_update'}">selected</c:if>>最早更新</option>  	  					
					</select>					
			</div>
		</form>
	  </div>	   	 	
  	  <div class="clear"></div>  	 
	</div>
  	<div id="show_space_data"> 	
  		<iframe name="content_study_space_main" id="iframe_main" scrolling="yes"></iframe>  		
  	</div>  
  </body>
</html>

