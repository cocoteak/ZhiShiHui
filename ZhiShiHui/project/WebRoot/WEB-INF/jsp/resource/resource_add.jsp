<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'createResource.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="jquery/discuss/jquery.js" charset="utf-8"></script>
	<script type="text/javascript"  charset="utf-8"  src="ueditor/utf8-jsp/ueditor.config.js"></script> <!-- udeditor配置文件  -->
<script type="text/javascript"  charset="utf-8"  src="ueditor/utf8-jsp/ueditor.all.min.js"></script> <!--udeditor核心文件 -->  
<script type="text/javascript"  charset="utf-8"  src="ueditor/utf8-jsp/lang/zh-cn/zh-cn.js"></script> <!-- udeditor语言文件 -->
	
 <script type="text/javascript">
	$("input[type='checkbox']").change(function() {
    	if (this.checked) {
	    	$("#lable_selected").val("123123123");
	  	}
    });
</script>
<script type="text/javascript">
$(function(){
	$("input[type='checkbox']").change(function() {
		var text = $("#lable_selected").text();
    	if (this.checked) {
    		if(text == '') {
    		  text = this.val();
    		} else {
    			text = text + "," + this.val();
    		}
	    	$("#lable_selected").html(text);
	  	}
    });
	
})
	
</script>

  </head>
  <body>
    <h3><br></h3><h3>发布资源</h3>
		<form action="insert" id="form">
		
		 <table>
			 <tr>
				<td>标题：</td>
				<td><input name="resource_title" type="text" placeholder="请输入标题"/></td>
			</tr>
			<tr>
				<td>资源描述：</td>
				<td><input name="resource_describe" type="text" placeholder="请输入资源描述"/></td>
			</tr>
		  <tr>
		  	
		      <textarea name="resource_content" id="myEditor"></textarea>
		       <script type="text/javascript">
		           UE.getEditor('myEditor');
		       </script>
		      
		  </tr>
		  <tr>
		  
		  	<td><span id="lable_selected" name="lable_selected"></span></td>
		  </tr>
		  <tr>
		  	<td><span>标签库：</span></td>
		  	<td>
				<input type="checkbox" name="resource_label" value="技术博客" >技术博客
				<input type="checkbox" name="resource_label" value="疑惑" >疑惑
				<input type="checkbox" name="resource_label" value="经验" >经验
				<input type="checkbox" name="resource_label" value="代码" >代码
				<input type="checkbox" name="resource_label" value="技术贴" >技术贴
				<input type="checkbox" name="resource_label" value="error" >error
				<input type="checkbox" name="resource_label" value="需求分析" >需求分析
				<input type="checkbox" name="resource_label" value="数据库" >数据库
				<input type="checkbox" name="resource_label" value="课件" >课件
		  	</td>
		  </tr>
		  <tr>
		  	<td><span>资源分类：</span></td>
		  	<td>
		  		<input name="resourceType" type="radio" value="1">核心资源
				<input name="resourceType" type="radio" value="2">精品资源
		  	</td>
		  </tr>
		  <tr>
		  	<td>
		  	<input type="submit" value="添加"/>		
		  	</td>
		  	<td>
		  	<input type="reset" value="取消"/>
		  	</td>
		  </tr>
		 </table>
		 
		</div>
	</form>
  </body>
</html>
