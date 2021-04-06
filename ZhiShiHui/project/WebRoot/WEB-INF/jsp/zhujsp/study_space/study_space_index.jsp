<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>社区</title>
    
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

	<!-- BootStrap插件样式 -->
	<link rel="stylesheet" type="text/css" href="BootStrap 3.3.5/css/style.css">
	
<style type="text/css">
#right_main{
	width:100%;
}
#right_main #iframe_main{
	width:100%;
	height:700px;
}
</style>	
<script type="text/javascript">	

window.onload = function(){
	
	//自动触发欢迎页面
	var e = document.createEvent("MouseEvents");
	e.initEvent("click", true, true);	
	document.getElementById("welcome").dispatchEvent(e);
}
	$(document).ready(function () {
	  var trigger = $('.hamburger'),
		  overlay = $('.overlay'),
		 isClosed = false;
	  
	  //自动显示侧边栏
	  $('#wrapper').toggleClass('toggled');	  
	  
		trigger.click(function () {
		  hamburger_cross();      
		});

		function hamburger_cross() {
		  if (isClosed == true) {          
			overlay.hide();
			trigger.removeClass('is-open');
			trigger.addClass('is-closed');
			isClosed = false;
		  } else {   
			overlay.show();
			trigger.removeClass('is-closed');
			trigger.addClass('is-open');
			isClosed = true;
		  }
	  }
	  
	  $('[data-toggle="offcanvas"]').click(function () {
			$('#wrapper').toggleClass('toggled');
	  });  
	});
</script>
</head>
<body>

<div id="wrapper">	
	<!-- 侧边栏 -->
	<nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
		<ul class="nav sidebar-nav">
			<li class="sidebar-brand">
				<a href="welcomeToMyStudySpace" id="welcome" target="study_space_index_main" ><img src="upload_images/${sessionScope.studySpace.space_picture}" height="50px" width="50px" class="img-circle"  alt="头像"></a>			
			</li>
			<li>
				<a href="" id="homepage" target="study_space_index_main"><i class="fa fa-fw fa-home"></i><img src="images/ZhuImg/zsh_homepage.png" alt="主页" height="24px" width="24px"  class="img-circle">&nbsp;&nbsp;主页</a>
			</li>
			<li>
				<a href="main" target="study_space_index_main">
					<i class="fa fa-fw fa-folder"></i>
					<img src="images/ZhuImg/zsh_resource.png" alt="资源" height="24px" width="24px" class="img-circle">&nbsp;&nbsp;资源区
					<span class="badge pull-right">5</span>
				</a>
			</li>
			<li>
				<a href="showPost" target="study_space_index_main">
					<i class="fa fa-fw fa-file-o"></i> 
					<img src="images/ZhuImg/zsh_discuss.png" alt="讨论" height="24px" width="24px" class="img-circle">&nbsp;&nbsp;讨论区
					<span class="badge pull-right">5</span>
			    </a>
			</li>
			<li>
				<a href="whole" target="study_space_index_main">
					<i class="fa fa-fw fa-cog"></i>
					<img src="images/ZhuImg/zsh_devotion.png" alt="贡献" height="24px" width="24px" class="img-circle"> &nbsp;贡献区
					<span class="badge pull-right">5</span>
				</a>
			</li>			
			<li>
				<a href="selectAllMember" target="study_space_index_main">
					<i class="fa fa-fw fa-bank"></i> 
					<img src="images/ZhuImg/zsh_member.png" alt="成员" height="24px" width="24px" class="img-circle">&nbsp;&nbsp;成员
				</a>
			</li>
			<li>
				<a href="https://www.jqhtml.com" target="study_space_index_main">
					<i class="fa fa-fw fa-dropbox"></i>
					<img src="images/ZhuImg/zsh_set.png" alt="设置" height="24px" width="24px" class="img-circle">&nbsp;&nbsp;设置					
				</a>
			</li>
		</ul>
	</nav>	
	<!-- Page Content -->
	<div id="page-content-wrapper">
	  <button type="button" class="hamburger is-closed animated fadeInLeft" id="fold_button" data-toggle="offcanvas">
		<span class="hamb-top"></span>
		<span class="hamb-middle"></span>
		<span class="hamb-bottom"></span>
	  </button>		 
	  <div id="right_main">
  			<iframe name="study_space_index_main" id="iframe_main" scrolling="yes"></iframe>
	  </div>				
	</div>	
</div>
</body>
</html>
