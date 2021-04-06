<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>贡献区</title>
<style type="text/css">
  hr{
	  color:#d3d1d1;
	  margin:0px;
	  padding:0px;
      width:1000px;
      text-align:left;
      margin-left:40px;
	 }
  #poem{
	width:1000px;
    margin-left:50px;
    margin-top:10px;
    color:#000;
    font-family:宋体; 
   }
 *{
  margin: 0;
  padding: 0;
 }


.aa{
	text-decoration:none;
	color:#000;}
 a:hover{
	color:#39F;}

 #human{
	  width:1000px;
	  border-bottom:1px solid #d3d1d1;
	  margin-left:40px;
	  padding:5px;}
 #title{
	  width:1000px;
	  border:1px solid #d3d1d1;
	  margin-left:40px;
	  padding:5px;
	}

  .owner{
	  margin-top:12px;
	  margin-left:40px;
	  padding-left:10px;
	  width:1000px;
	  height:20px;
	  line-height:30px;
	  background-color:#FAFAFA;
	  border:1px solid #d3d1d1;
	  font-size:12px;
	  height:30px;
	  }
  #content{
	  width:1000px;
	  height:200px;
	  border:1px solid #d3d1d1;
	  border-top-color:#FFF;
	  margin-left:40px;
	  padding:10px;
	  
  }
 
    textarea{
    margin-top:12px;
    border:0;
  	background-color:transparent;
  	/*scrollbar-arrow-color:yellow;
  	scrollbar-base-color:lightsalmon;
  	overflow: hidden;*/
	width:1000px;
  	color: #666464;
  	height: auto;
   
  
  }
  p{
  color: #666464;
  }
   .discuss{
	    margin-top:12px;
	    margin-left:40px;
	    padding-left:10px;
	    width:1000px;
        height:50px;
        line-height:50px;
        border-top:1px solid #d3d1d1;
        border-bottom:1px solid #d3d1d1;
        color:#d3d1d1;
		text-align:center;
   }
   #system{
	    margin-top:12px;
	    margin-left:40px;
		width:1000px;
		height:100px;
		border:1px solid #d3d1d1;
	   }
	 .button{
	 margin-top:50px;

	 }
  #remark{
     margin-top:12px;
     border:1px solid #d3d1d1;
     margin-left:40px;
     width:1000px;
	 height:100px;
  }
  #remark p{
   margin:10px;
   max-width:100%;
  }
	
</style>
<!--  <link herf="ueditor/utf8-jsp/themes/default/css/ueditor.css" type="text/css" rel="stylesheet">-->
<script type="text/javascript"  src="jquery/jquery.js"></script>
<script type="text/javascript"  charset="utf-8"  src="ueditor/utf8-jsp/ueditor.config.js"></script> <!-- udeditor配置文件  -->
<script type="text/javascript"  charset="utf-8"  src="ueditor/utf8-jsp/ueditor.all.min.js"></script> <!--udeditor核心文件 -->  
<script type="text/javascript"  charset="utf-8"  src="ueditor/utf8-jsp/lang/zh-cn/zh-cn.js"></script> <!-- udeditor语言文件 -->

</head>
<body>
<div id="poem"><h4> <a href="#" class="aa">学习空间 > <a href="#" class="aa">软件开发奥利给 </a> > 贡献区 >地址</h4></div>
<br/>
  <hr/> 
<!-- 选项卡开始 -->

 <div id="human">
   <table cellspacing="12">
     <tr><input type="hidden" name="id" value="${requestScope.contribute0.resource_id }"/>
       <td align="center"> 
      <c:choose>   
            <c:when test="${requestScope.contribute0.status==1}">已接受</c:when>
            <c:otherwise>未接受</c:otherwise>
        </c:choose>
     </td>
     
     <c:forEach items="${userList}" var="user" >
       <c:if test="${user.user_id==requestScope.contribute0.resource_id}">
     <input type="hidden" name="user_id" value="${user.user_id }"/>
       <td align="center">
        ${user.user_name }
         </td>
         </c:if>
     </c:forEach>
     
     </tr>
   </table>
 </div>
 <div id="title">
 <table cellspacing="12">
    <tr>
       <td align="left">
       <h2><strong> ${requestScope.contribute0.resource_title}</strong></h2>
         </td>
       
    </tr>
    <tr>
    <td>${requestScope.contribute.resource0_describe }</td>
    </tr>
  
 </table>
 </div>
   <c:choose>   
            <c:when test="${requestScope.contribute0.resource_content!=requestScope.contribute1.resource_content}">
              <p class="owner">&nbsp;&nbsp;提交版本</p>
      <div id="content">
       <td align="left">
       <h3><strong> ${requestScope.contribute0.resource_title}</strong></h3>
         </td>
         <td>${requestScope.contribute0.resource_label}</td>
    
    <textarea name="resource_content"> 
     ${requestScope.contribute0.resource_content}
   </textarea>
      <c:if test="${not empty requestScope.contribute0.resource_describe}">
             <p> 资源描述：
              <br/>
               ${requestScope.contribute0.resource_describe}
              </p> 
       </c:if>
  <c:if test="${not empty requestScope.contribute0.resource_filePath}">
      <p> 附件列表：
              <br/>
              <a href="download?fileName=${requestScope.contribute0.resource_filePath}"> ${requestScope.contribute0.resource_filePath}</a>
              </p> 
  </c:if>
  </div>
  
  <p class="owner">&nbsp;&nbsp;最新版本</p>
  <div id="content">
       <td align="left">
       <h3><strong> ${requestScope.contribute1.resource_title}</strong></h3>
         </td>
         <td>${requestScope.contribute1.resource_label}</td>
    
    <textarea name="resource_content"> 
     ${requestScope.contribute1.resource_content}
   </textarea>
      <c:if test="${not empty requestScope.contribute1.resource_describe}">
             <p> 资源描述：
              <br/>
               ${requestScope.contribute1.resource_describe}
              </p> 
       </c:if>
  <c:if test="${not empty requestScope.contribute1.resource_filePath}">
      <p> 附件列表：
              <br/>
               <a href="download?fileName=${requestScope.contribute1.resource_filePath}"> ${requestScope.contribute1.resource_filePath}</a>
              </p> 
  </c:if>
  </div>
            
            
            </c:when>
 <c:otherwise>
            <p class="owner">&nbsp;&nbsp;提交版本</p>
           <div id="content">
         <td align="left">
         <h3><strong> ${requestScope.contribute0.resource_title}</strong></h3>
         </td>
         <td>${requestScope.contribute0.resource_label}</td>
    
        <textarea name="resource_content"> 
       ${requestScope.contribute0.resource_content}
       </textarea>
       <c:if test="${not empty requestScope.contribute0.resource_describe}">
             <p> 资源描述：
              <br/>
               ${requestScope.contribute0.resource_describe}
              </p> 
        </c:if>
  <c:if test="${not empty requestScope.contribute0.resource_filePath}">
      <p> 附件列表：
              <br/>
                <a href="download?fileName=${requestScope.contribute0.resource_filePath}"> ${requestScope.contribute0.resource_filePath}</a>
              </p> 
  </c:if>
  </div>

        </c:otherwise>
        </c:choose>


  

  
 
<div id="remark">

    <!-- 传贡献id 
    <input type="hidden" name="devotion_id" id="devotion_id" value="${requestScope.contribute.resource_id}"/> 
  
    <!--  <script type="text/plain" id="editor" style="width:1000px;height:120px;"></script>-->
    
    <textarea  name="devotion_content"  id="Ueditor"></textarea>
    <script type="text/javascript">
    //var ue=UE.getEditor('editor');
    UE.getEditor("Ueditor");
    </script>
  <input type="submit" title=""  class="button" name="submit" id="tijiao"  value="发表评论"/ >
   </form>
  
</div>

    
</body>
<!-- ${pageContext.request.contextPath} -->
<script type="text/css" src="jquery/jquery.js"></script>
<script type="text/javascript">
  $(document).ready(function(){
   
      var ue=UE.getEditor('#Ueditor');//拿到富文本编辑器的内容
     // var comment=ue.getContent();
    //  var content={
     //    devotion_content:comment
     // };
     // $.ajax({
     //   type:"POST";
      //  url:"${pageContext.request.contextPath}/addRemark1?id=${contribute.resource_id}",
      //  data:content,
      //  success:function(data){
      //    alert("成功");
      //  },
      //  error:function(e){
      //    alert("出错"+e);
      //  }
        
      })
  })
  
 
</script>
</html>

