<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
	<head>
	   
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
			
		<script src="https://cdn.ckeditor.com/4.14.0/standard/ckeditor.js"></script>
			
		<link rel="stylesheet" href="css/discuss/createPost.css" type="text/css"></link>	
		
	<style type="text/css">
		#contents{
			margin-top:30px;
			margin-left:50px;
			position:relative;
		}
		#mark{
			color:red;
		}
		#title input{
			width:300px;
			height:30px;
			border-radius:5px;
			border:1px solid #cdcdcd;
		}
		#all h2{
			padding-bottom:20px;
		}
		#all h4{
			margin-top:15px;
			padding-bottom:10px;
			color:#0d0d0d;
		}
		#butt{
			background:#0367ad;
			color:white;
			border:1px;
			height:40px;
			width:80px;
			margin-top:50px;
		}
	</style>
	</head>

	<body>
	<div id="contents">
		<div id="all">
			<form:form action="postInsert2" commandName="inPost" method="post">
				<div class="head">
					<h2> 
						发起话题 
					</h2>
				</div>
				<div class="title" id="title">

					<h4>
						<span id="mark">*</span>话题标题
					</h4>
					<form:input path="post_title" />
					<form:errors path="post_title" cssStyle="color:red" />
				</div>
				
				<div class="content">
					<h4>
						<span id="mark">*</span>话题内容
					</h4>
					<textarea name="post_content"></textarea>
					<script>
                        CKEDITOR.replace('post_content');
               		  </script>
				</div>

				<div class="reminder">
					<h4>
						特别提醒
					</h4>
					<form:select path="post_reminder">
					</form:select>
				</div>
				<div class="label">
					<h4>
						添加标签
					</h4>
					<div class="lab-1">
						<span class="lab_title">已选标签</span>
						<ul id="ul1" class="selected"></ul>
						<form:input path="post_label" style="display:none"/>
						<input id="post_labels" name="post_labels" style="display:none"/>
						<input type="button" id="input" value="最多选择5个标签" readonly>
					</div>
					
					<div class="lab-2">
						<span class="lab_title">标签库</span>
						<ul id="ul2" class="none">
							<li class="none-li">
								技术博客
							</li>
							<li class="none-li">
								疑惑
							</li>
							<li class="none-li">
								经验
							</li>
							<li class="none-li">
								代码
							</li>
							<li class="none-li">
								技术贴
							</li>
							<li class="none-li">
								error
							</li>
							<li class="none-li">
								需求分析
							</li>
							<li class="none-li">
								数据库
							</li>
							<li class="none-li">
								课件
							</li>
							<li class="none-li">
								便签维护
							</li>
						</ul>
					</div>
				</div>
				<script type="text/javascript"  src="jquery/discuss/createPost.js" charset="gb2312"></script>	
				
				<br/>
				<div class="button" >
					<input type="submit" value="发布话题帖" id="butt">
					<input type="reset" value="取消" id="butt">
				</div>
			</form:form>
		</div>
	</div>
	</body>


</html>
