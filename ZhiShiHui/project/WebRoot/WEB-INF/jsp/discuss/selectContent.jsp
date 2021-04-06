<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<script type="text/javascript" src="jquery/discuss/selectContent.js" charset="gb2312"></script>
		<link rel="stylesheet" href="css/discuss/selectContent.css">

		<link rel="stylesheet" href="layui/css/layui.css">
		<script src="layui/layui.js"></script>
		
		<script src="https://cdn.ckeditor.com/4.14.0/standard/ckeditor.js"></script>
	</head>

	<body>
		<div class="content">
			<form action="selectContent?post_id=${postFirst.post_id}" method="post" id="form1" style="text-align: center;">
				<input type="hidden" id="pageNow" name="pageNow" value="1" />
				<input type="hidden" id="totalPage" value="${totalPage}" />
			</form>

			<table border="1" style="margin: 0 auto;" width="600">
				<tr>
					<th>
						post_id
					</th>
					<th>
						title
					</th>
					<th>
						content
					</th>
					<th>
					    ifrefined
					</th>
					<th>
						label
					</th>
					<th>
						likenum
					</th>
					<th>
						dislikenum
					</th>
					<th>
						user
					</th>
					<th>
						createtime
					</th>
					<th>
						是否收藏
					</th>
                    <th>
                   		 编辑
                    </th>
                    <th>
  					              删除
                    </th>
				</tr>

				<tr>
					<th>
						${postFirst.post_id}
					</th>
					<th>
						${postFirst.post_title}
					</th>
					<th>
						${postFirst.post_content}
					</th>
					<th>
					    <c:if test="${postFirst.post_ifrefined==1}">
					      <a onclick="javascript:changeIfrefined(${postFirst.post_id},${pageNow},${postFirst.post_ifrefined})">设为精华帖</a>
					    </c:if>
					    <c:if test="${postFirst.post_ifrefined==2}">
					      <a onclick="javascript:changeIfrefined(${postFirst.post_id},${pageNow},${postFirst.post_ifrefined})">取消精华帖子</a>
					    </c:if>
					</th>
					<th>
						${postFirst.post_label}
					</th>
					<th>
					<c:choose>
					 <c:when test="${likeFlag}">  
					    	<a  href="javascript:changeLike(${postFirst.post_id},${pageNow})">已点赞${like}</a>
					   </c:when>
					   <c:otherwise> 
					         <a  href="javascript:changeLike(${postFirst.post_id},${pageNow})">未点赞${like}</a> 
					   </c:otherwise>
			        </c:choose>
					</th>
					<th>
					   <c:choose>
						<c:when test="${dislikeFlag}">  
					    	<a  href="javascript:changeDislike(${postFirst.post_id},${pageNow})">已踩${dislike}</a>
					   </c:when>
					   <c:otherwise> 
					         <a  href="javascript:changeDislike(${postFirst.post_id},${pageNow})">未踩${dislike}</a> 
					   </c:otherwise>
					   </c:choose>
					</th>
					<th>
						${postFirst.user.user_name}
					</th>
					<th>
						<fmt:formatDate value="${postFirst.post_createtime}" pattern="yyyy-MM-dd HH:mm:ss" />
					</th>
					<th>
					
					<c:choose>
					   <c:when test="${collectionFlag}">  
					    	<a  href="javascript:changeCollection(${postFirst.post_id},${pageNow})">已收藏</a>
					   </c:when>
					   <c:otherwise> 
					        <a  href="javascript:changeCollection(${postFirst.post_id},${pageNow})">未收藏</a> 
					   </c:otherwise>
					</c:choose>	
					</th>
					<th>
						<c:if test="${postFirst.user.user_id== sessionScope.user.user_id}">
							<a onclick="javascript:editorPost(${postFirst.post_id})">编辑</a>
						</c:if>
					</th>
					<th>
						<c:if test="${postFirst.user.user_id== sessionScope.user.user_id}">
							<a onclick="javascript:deletePost(${postFirst.post_id})">删除</a>
						</c:if>
					</th>
				</tr>
			</table>

			<table border="1" style="margin: 0 auto;" width="600">
				<tr>
					<th>
						content_recordnum
					</th>
					<th>
						user
					</th>
					<th>
						content_reply
					</th>
					<th>
						content_likenum
					</th>
					<th>
						content_dislikenum
					</th>
					<th>
						content_updatetime
					</th>
					<th>
					    reply_user_id
					</th>
					<th>
						reply
					</th>
				</tr>
               <c:choose>
					<c:when test="${empty listContent}">
						<hr />
						暂无回复记录
					    <hr />
					</c:when>
				<c:otherwise>
				<c:forEach items="${listContent}" var="var">
					<c:forEach items="${allContentList}" var="content" >
					    <!--  楼层比对取出    普通回复    和   楼中楼    -->
						<c:if test="${var.content_recordnum==content.content_recordnum}">
						<tr>
							<th>
								${content.content_recordnum}
							</th>
							<th>
								${content.user.user_name}
							</th>
							<th>
								${content.content_reply}
							</th>
							<th>
							  <c:forEach items="${likeMap}" var="likeMap" >
							 	<c:if test="${likeMap.key==content.content_id}">
									<c:choose>
									 <c:when test="${likeMap.value.contentFlage}">  
									    	<a  href="javascript:changeContentLike(${postFirst.post_id},${content.content_id},${pageNow})">已点赞${likeMap.value.contentCount}</a>
									   </c:when>
									   <c:otherwise> 
									         <a  href="javascript:changeContentLike(${postFirst.post_id},${content.content_id},${pageNow})">未点赞${likeMap.value.contentCount}</a> 
									   </c:otherwise>
							        </c:choose>
							        </c:if>
							  </c:forEach>
							</th>
							<th>
							<c:forEach items="${dislikeMap}" var="dislikeMap" >
							 <c:if test="${dislikeMap.key==content.content_id}">
							   <c:choose>
								 <c:when test="${dislikeMap.value.contentFlage}">   
							    	<a  href="javascript:changeContentDislike(${postFirst.post_id},${content.content_id},${pageNow})">已踩${dislikeMap.value.contentCount}</a>
							   </c:when>
							   <c:otherwise> 
							         <a  href="javascript:changeContentDislike(${postFirst.post_id},${content.content_id},${pageNow})">未踩${dislikeMap.value.contentCount}</a> 
							   </c:otherwise>
							   </c:choose>
							   </c:if>
							  </c:forEach>
							</th>
							<th>
								<fmt:formatDate value="${content.content_updatetime}"
									pattern="yyyy-MM-dd HH:mm:ss" />
							</th>
							<th>
							<c:forEach items="${reply_user}" var="reply_user">
								<c:if test="${content.reply_user_id==reply_user.user_id}">
							                 	对${reply_user.user_name}说
								</c:if>	
							</c:forEach>
							</th>
							
							<th>
								<form:form action="insertContent" commandName="inContent" method="post" id="form2">
									<input type="hidden" id="post_id" name="post_id" value="${postFirst.post_id}" />
									<input type="hidden" id="pageNow" name="pageNow" value="${pageNow}" />
									<input type="hidden" id="content_recordnum" name="content_recordnum" value="${content.content_recordnum}" />
									<input type="hidden" id="reply_user_id" name="reply_user_id" value="${content.user.user_id}" />
									<a onclick="displayOrHidden(${content.content_id})">回复</a>
									<div id="reply${content.content_id}"  style="display: none">
										<textarea name="content_reply${content.content_id}" id="content_reply${content.content_id}"></textarea>
                						<script> 
                       					  var editor=CKEDITOR.replace('content_reply'+${content.content_id});
                       					 	function relyContent(){
	                                        var content =editor.document.getBody().getHtml();
											window.location.href="insertContent?post_id="+${postFirst.post_id}+"&pageNow="+${pageNow}+"&content_recordnum="+${content.content_recordnum}+"&reply_user_id="+${content.user.user_id}+"&content_replys="+content;
											}
               		   					</script>
										<input type="submit"  value="发布话题帖" onclick="relyContent()"/>
										</div>
								</form:form>
							</th>
						</tr>
						</c:if>
					</c:forEach>
			 </c:forEach>
			 </c:otherwise>
			 </c:choose>
			</table>

			<table style="margin: 0 auto;">
				<tr>
					<c:if test="${isHasFirst}">
						<td>
							<a href="javascript:change(1)">首页</a>
						</td>
					</c:if>

					<c:if test="${isHasPre}">
						<td>
							<a href="javascript:change(${pageNow-1})">上一页</a>
						</td>
					</c:if>

					<c:if test="${isHasNext}">
						<td>
							<a href="javascript:change(${pageNow+1})">下一页</a>
						</td>
					</c:if>

					<c:if test="${isHasLast}">
						<td>
							<a href="javascript:change(${totalPage})">末页</a>
						</td>
					</c:if>
				</tr>

				<tr>
					<td colspan="5">
						<c:forEach begin="1" end="${totalPage}" var="i">
							<a href="javascript:change(${i})">${i} </a>
						</c:forEach>
					</td>
				</tr>
			</table>
		</div>

		<div>
			<form:form action="insertContent" commandName="inContent" method="post" style="text-align: center;" id="form2">
				<input type="hidden" id="post_id" name="post_id" value="${postFirst.post_id}" />
				<input type="hidden" id="pageNow" name="pageNow" value="${pageNow}" />
				<div>
					 	<textarea name="content_reply${content.content_id}" id="content_reply${content.content_id}"></textarea>
                			<script> 
                       		 var editor1 =CKEDITOR.replace('content_reply');
                       	     var content_replys=document.getElementById("content_replys");
                       		 function newReordContent(){
	                                var content =editor.document.getBody().getHtml();
								    content_replys.value=content;
									document.getElementById("form3").submit();
								}
               		   					</script>
					<input type="submit"  value="发布话题帖" onclick="newReordContent()"/>
			</form:form>
		</div>


	</body>
</html>
