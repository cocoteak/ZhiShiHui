<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>页面框架</title>
    
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
	width:100%;
	background-color:white;
	height:70px;
	box-shadow: 4px 4px 1px	LightGrey;
}
#nav_log{
	float:left;
}
#nav_left{
	 float:left;
	 height:70px;
	 line-height:70px;
	 font-size:18px;	 
}
#nav_left ul{
	list-style-type:none;
	font-weight:bold;
}
#nav_left ul li {
	float:left;
	width:100px;
	text-align:center;
}
#nav_left ul a:hover{
	color:black;	
}
#nav_left ul a{
	color:gray;
	text-decoration:none;
}
.active{
	font-weight:bolder;
	color:DarkBlue;
	border-bottom:4px solid DarkBlue;
}
#nav_middle{
	margin-left:200;
	height:70px;
	text-align:center;	
	padding-top:10px;
	float:left;
}
#nav_right{
	 float:right;
	 height:70px;
	 line-height:70px;
	 font-size:16px;	
	 margin-right:40px;	
}
#mesg_list{
	width:120px;
}
#content{
	width:95%;	
	margin:20 auto;
}
#content #iframe_content{
	width:100%;
	height:100%;	
}
</style>
<script type="text/javascript">
window.onload = function(){//利用选项卡的知识+框架的知识
		var nav_left = document.getElementById('nav_left');
		var li = nav_left.getElementsByTagName('li');		
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
		document.getElementById("select_studySpace").dispatchEvent(e);
}
</script>
  </head> 
  <body>
  	<div id="nav">  
  		<div id="nav_log">
  			<a href="selectStudySpace" target="iframe_content"><img src="images/ZhuImg/zsh_log.png" alt="这是一个log"/></a> 
  		</div>		
  		<div id="nav_left">    		 	
  		  <ul>  		  
 		 	<a href="selectCommunity" target="iframeContent"><li>社区</li></a>
  			<a href="selectStudySpace" target="iframeContent" id="select_studySpace"><li class="active">学习空间</li></a>
 			<a href="selectFeedback" target="iframeContent"><li>我的群组</li></a>  					
	 	  </ul>	 	  
  		</div>  		
  		<div id="nav_middle">
  		   <form class="navbar-form navbar-left" role="search">
        	<div class="input-group">
               <input type="text" class="form-control" placeholder="搜索资源或话题">
               <span class="input-group-btn">
                   <button class="btn btn-default" type="button">搜索</button>
               </span>
            </div>
   		  </form>
  		</div>
  		<div id="nav_right">
  			 <button type="button" class="btn btn-default btn-lg">意见反馈</button>  	       
    	 <div class="btn-group">
    		<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
    			<img src="images/ZhuImg/zsh_mesg.png" width="25px" height="30px" class="img-circle">
    			<span class="badge">3</span>
        		<span class="caret"></span>
    		</button>
    		<ul class="dropdown-menu" role="menu">        	
        	<li><a href="#"><span class="badge pull-right">1</span>回复我的</a></li>
        	<li><a href="#"><span class="badge pull-right">1</span>收到的赞</a></li>        		
        	<li><a href="#"><span class="badge pull-right">1</span>系统通知</a></li>        	   
       	    </ul>
    	 </div> 
    	 <div class="btn-group">
    		<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
    			<img src="images/ZhuImg/GXT_pink.jpg" width="40px" height="35px"class="img-circle">
        		<span class="caret"></span>
    		</button>
    		<ul class="dropdown-menu" role="menu">
        		<li><a href="#">用户名</a></li>
        		<li class="divider"></li>
        		<li><a href="#">我的动态</a></li>
        		<li><a href="#">我的收藏</a></li>        		
        		<li><a href="UserMsg">个人中心</a></li>
        		<li class="divider"></li>
        		<li><a href="#">我的问卷</a></li>
        		<li class="divider"></li>
        		<li><a href="rlogin">退出系统</a></li>    
       		</ul>
    	</div>                	
  	   </div> 
  	 </div>   
  	<div id="content">
  		<iframe name="iframeContent" id="iframe_content" scrolling="yes"></iframe>  	  	
  	</div>
  </body>
</html>
