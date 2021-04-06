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
<script type="text/javaScript">
   function change(page){
    
    document.getElementById("pageNow").value=page;//得到page页面的value值
    document.getElementById("form1").submit();
   }
   function change1(){
   document.getElementById("pageNow").value=document.getElementById("ye").value;
   document.getElementById("form1").submit();
   }


 </script>
<style type="text/css">
  hr{
	  margin:0px;
	  padding:0px;
      width:1000px;
      text-align:left;
      margin-left:40px;}
  #poem{
    margin-left:50px;
    margin-top:10px;
    color:#000;
    font-family:宋体; 
   }
 *{
  margin: 0;
  padding: 0;
 }
 li{
  list-style: none;
 }
 /*选项卡效果*/
 /*设置一个居中的大盒子*/
 /*给选项设置样式*/

 ul{
  width: 1000px;
  height: 43px;
  margin:50px;
  position: relative;
   margin-top:0px;
 }
  li{
  width: 80px;
  height: 40px;
  float: left;
  font-size:14px;
  color:#000;
  line-height: 48px;
  text-align: center;
  border-right:1px solid #f5f5f5 ;
 }  
 li input{
  display:none;
 }
 li label{
  display:block;
  width: 80px;
  height: 40px;
 }
  li input:checked+label{
  font-weight:bold;
 }
 /*给导航下面弹出卡片的样式*/
  li div{
  margin: 0;
  padding: 0;
  width: 1000px;
  height: 300px;
  position:absolute;
  left: 0;
  top: 105px;
  line-height: 300px;
  font-size: 16px;
  display:none;
 }
 /*加入点击弹出卡片效果*/
  li input:checked+label+div{
  display:block;
 }
 .a1{
  width:100%;
  height:50px;
  line-height:50px;
  margin-top:-40px;
  border-top:1px solid #d3d1d1;
  border-bottom:1px solid #d3d1d1;
  color:#d3d1d1;
  /*border:1px solid #d3d1d1;*/
  }
.box2{
   width:1000px;
   height:60px;
   line-height:60px;
   margin-left:40px;
   margin-top:-40px;
   background:#666;
   border-top:1px solid #d3d1d1;
   border-bottom:1px solid #d3d1d1;}
.aa{
	text-decoration:none;
	color:#000;}
 a:hover{
	color:#39F;}
#allinfo{
     text-decoration:none;
	 margin-top:-40px;
	 border:1px solid #d3d1d1;
	 width:1000px;
	 height:500px;
	 float:left;
       }
.tab1{
    text-decoration:none;
	 text-align:left;
	 width:1000px;
     line-height:10px;
	 border:1px solid #d3d1d1;
    }
 #allaccept{
     text-decoration:none;
	 margin-top:-40px;
	 border:1px solid #d3d1d1;
	 width:1000px;
	 height:500px;
	 float:left;
       }
.tab0{
    text-decoration:none;
	 text-align:left;
	 width:1000px;
     line-height:10px;
	 border:1px solid #d3d1d1;
    }

</style>

</head>
<body>
<div id="poem"><h4> <a href="#" class="aa">学习空间 > <a href="#" class="aa">软件开发奥利给 </a> > 贡献区</h4></div>
<br/>
  <hr/> 
<!-- 选项卡开始 -->

 <ul>
  <li>
   <input type="radio" name="nav1" id="a1">
   <label for="a1">待解决</label>
             <div>
                   <p class="a1">暂无数据</p>
               </div>
  </li>

  <li>
   <input type="radio" name="nav1" id="a2">
   <label for="a2">已接受</label>
                <div id="allaccept">
              <form id="form1">
       <table class="tab0" cellspacing="12px;" >
        <c:forEach items="${contributeList}" var="contribute">
              <tr>
              <a href="lookDevotionView?id=${contribute.devotion_id}"> ${contribute.resource.resource_title}</a> 
             <td>${contribute.resource.resource_title}</td> 
             <td align="center"><fmt:formatDate value="${contribute.devotion_createdate}" pattern="yyyy年MM月dd日"></fmt:formatDate></td>
             </tr>
             <tr>
             <td>${contribute.user.user_name}</td>  
           </tr>
           </c:forEach>     
        </table>
       </form>
     </div>
  </li>

  <li>
   <input type="radio" name="nav1" id="a3">
   <label for="a3">未接受</label>
                <div>
                  <p class="a1">暂无数据</p>
               </div>

  </li>
<li>
   <input type="radio" name="nav1" id="a4">
   <label for="a4">全部</label>
   <div id="allinfo">
   <form action="selectContributeWithParam1" method="post" id="form1">
       <table class="tab1" cellspacing="12px;" >
        <c:forEach items="${contributeList}" var="contribute">
              <tr>
             <td> <a href="lookDevotionView?id=${contribute.devotion_id}"> ${contribute.resource.resource_title}</a> 
             <input type="hidden" name="pageNow" id="pageNow" value="1"/></td> 
             <td align="center"><fmt:formatDate value="${contribute.devotion_createdate}" pattern="yyyy年MM月dd日"></fmt:formatDate></td>
             </tr>
             <tr>
             <td>${contribute.user.user_name}</td>  
           </tr>
           </c:forEach>     
        </table>
        
        </form>
    <p >
       <span  align="center"><a href="javascript:change(1)">首页</a></span>
       <span align="center">当前页数${pm1.pageNow}</span>
       <span  align="center"><c:if test="${pm1.hasPre}"><a href="javascript:change(${pm1.pageNow-1})">上一页</a></c:if></span>
       <span  align="center"><c:if  test="${pm1.hasNext}"><a href="javascript:change(${pm1.pageNow+1})">下一页</a></c:if></span>
       <span  align="center"><a href="javascript:change(${pm1.totalPage})">尾页</a></span>
       <span  align="center">共${pm1.totalPage}页记录</span>
      </p>
       
     </div>
 
 
 
  </li>

 </ul>
  <!-- <div class="box2">
 hhh
   </div>
    -->   
</body>
</html>

