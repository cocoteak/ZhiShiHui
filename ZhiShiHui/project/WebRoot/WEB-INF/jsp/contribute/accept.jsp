<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>已接受</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script type="text/javaScript">
   function change(page){
    
    document.getElementById("pageNow").value=page;//得到page页面的value值
    document.getElementById("form1").submit();
   }


 </script>
 <style type="text/css">
  *{
  margin: 0;
  padding: 0;
 }
  #allaccept{
     text-decoration:none;
	 border:1px solid #d3d1d1;
	 width:1000px;
	 height:500px;
	 float:left;
	 margin-left:40px;
       }
.tab0{
    text-decoration:none;
	 text-align:left;
	 width:1000px;
     line-height:10px;
	 border:1px solid #d3d1d1;
    }
  </style>
  <body>
     <div id="allaccept">
       <form action="selectContributeWithParam1" method="post" id="form1">
       <table class="tab0" cellspacing="12px;" > <input type="hidden" name="pageNow" id="pageNow" value="1"/></td> 
        <c:forEach items="${contributeList}" var="contribute">
               <tr>
              <td> <a href="lookDevotionView?id=${contribute.resource_id}" target="_top">${contribute.resource_title}</a></td>
             <td align="right"><fmt:formatDate value="${contribute.devotion_createdate}" pattern="yyyy年MM月dd日"></fmt:formatDate></td>
 
             </tr>
             
             <tr>
             <td>${contribute.user.user_name}</td>  
           </tr>
           </c:forEach>     
        </table>
        
        </form>
    

      
      <table width="600px" border="0">
    <tr height="30">
     <td  align="center"><a href="javascript:change(1)">首页</a></td>
     <td  align="center">当前页数${pm.pageNow}</td>
     <td  align="center"><c:if test="${pm.hasPre}"><a href="javascript:change(${pm.pageNow-1})">上一页</a></c:if></td>
     <td  align="center"><c:if test="${pm.hasNext}"><a href="javascript:change(${pm.pageNow+1})">下一页</a></c:if></td>
     <td  align="center"><a href="javascript:change(${pm.totalPage})">尾页</a></td>
     <td  align="center">共${pm.totalPage}页记录</td>
    </tr>
    </table>
      
     </div>
  </body>
</html>
