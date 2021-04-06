<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTf-8">
<title>创建学习空间</title>
	<!-- BootStrap核心CSS文件 -->
	<link rel="stylesheet" type="text/css" href="BootStrap 3.3.5/css/bootstrap.min.css">
	<!-- jQuery文件 务必在引入bootstrap.min.js 之前引入 -->
	<script type="text/javascript" src="BootStrap 3.3.5/js/jquery-3.3.1.min.js"></script>
	<!-- BootStrap核心JavaScript文件 -->
	<script type="text/javascript" src="BootStrap 3.3.5/js/bootstrap.min.js"></script>
	
	<!-- 导入BootStrap-fileinput插件 -->
	<script type="text/javascript" src="bootstrap-fileinput-master/js/fileinput.min.js"></script>	
	<script type="text/javascript" src="bootstrap-fileinput-master/js/locales/zh.js"></script>
	<link rel="stylesheet" type="text/css" href="bootstrap-fileinput-master/css/fileinput.min.css">
	
	
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
#content{
	width:90%;	
	margin:20px auto;	
	border-top:1px solid gainsboro;
}
#content_describe{
	width:20%;	
	float:left;
}
#content_create{
	margin-top:40px;
	padding-left:20px;
	padding-right:20px;
	margin-left:10px;
	width:79%;
	height:420px;
	float:left;	
	border:1px solid gray;
	box-shadow: 4px 4px 4px	LightGrey;
}
#spaceNameTips{	
	display:none;
	font-size:12px;
}
</style>
<script type="text/javascript">
function vilidateSpaceName(){
	var spaceName = document.getElementById('space_name');	
	var spaceNameTips = document.getElementById('spaceNameTips');	
	alert(spaceName.value);
	if(spaceName.value == ""){
		spaceNameTips.style.display = "block";		
		spaceNameTips.style.color = "red";
		spaceName.style.border="1px solid red";		
	}else{
		spaceNameTips.style.display = "none";		
		spaceName.style.border="1px solid Gainsboro";		
	}	
}
</script>
</head>
<body>
	<div id="nav">
  		<a href="selectStudySpace" style="text-decoration:none;color:black;" target="iframeContent"><span style="font-weight:bolder;font-size:16px;">学习空间</span></a>
  		<span style="color:threedface;">&nbsp;&nbsp;&gt;&nbsp;&nbsp;</span>
  		<span style="font-size:14px;color:gray;">新建学习空间</span> 							
  	</div>
  	<div id="content">
  		<div id="content_describe">
  			<p><h2>新建学习空间</h2></p>  			
  			<span>学习空间可以用于存放学习资料、心得体会，讨论问题等。</span>
  		</div>
  		<div id="content_create">
  		  <form action="AddStudySpace" role="form" method="post">
  			<div class="form-group" style="margin-top:20px;">
    		  <label for="spaceNameLabel"><span style="color:red;">*&nbsp;</span>空间名</label>
    		  <input type="text" class="form-control" id="space_name" name="space_name" placeholder="请输入空间名" onblur="vilidateSpaceName()" value="">
    		  <span id="spaceNameTips">空间名不能为空</span>
  			</div>
  			<div class="form-group">
   			  <label for="spaceDescribe">空间描述</label>
    		  <textarea class="form-control" rows="2" id="space_describe" name="space_describe">请简单的描述一下您新建的空间</textarea>
 			</div>
 		   <div id="content_img">  	
 		   	 <p style="font-weight:bold;">空间封面</p>
 		   	 <input type="hidden" name="space_picture" value="GXT_pink.jpg">						 			 
			 <img src="images/ZhuImg/GXT_pink.jpg" width="70px" height="70px" class="img-circle">&nbsp;&nbsp;
			 <img src="images/ZhuImg/GXT_pink.jpg" width="70px" height="70px" class="img-rounded">	
			 <div style="float:right;margin-right:570px;">				
			 	<button type="button" class="btn btn-default">选取图片</button>
			 	<button type="button" class="btn btn-default">重置</button>
			 	<br/>
			 	<span>仅支持.jpg .jpeg .png 格式的图片类型。<br/>图片允许的最大大小为2MB。</span>
			 </div>	
			 <div style="margin-top:40px;">	
				<button type="submit" class="btn btn-primary">新建空间</button>&nbsp;&nbsp;
  		   		<button type="reset" class="btn btn-default">取消</button>	
  		   	 </div>
  		   </div>  		   
  		  </form>  		  
  		</div>  		
  	</div>
</body>
</html>