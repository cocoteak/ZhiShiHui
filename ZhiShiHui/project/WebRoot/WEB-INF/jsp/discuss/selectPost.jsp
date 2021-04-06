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

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<script type="text/javascript" src="jquery/discuss/selectPost.js" charset="gb2312"></script>
		<link rel="stylesheet" href="css/discuss/createPost.css" type="text/css"></link>	
		
		<link rel="stylesheet" href="layui/css/layui.css">
		<script src="layui/layui.js"></script>
	<style type="text/css">
		#content{
			margin:20px;
		}
		#butt{
			background:#0367ad;
			color:white;
			border:1px;
			height:25px;
			width:60px;
		}
		#chaxun input{
			margin:10px;
			text-align:center;
			margin:left;
		}
		#tab{
			margin: 0 auto;
			width:1000px;
			height:60px;
		}
		#tab th{
			border-bottom-style:1px solid #c0c0c0;
			height:60px;
		}
	</style>
	</head>

	<body>
		<div class="content" id="content">
			<form action="selectPost" method="post" id="form1">
				<input type="hidden" id="pageNow" name="pageNow" value="1" />
				<input type="hidden" id="totalPage" value="${totalPage}" />
				<div id="chaxun">
				<c:if test="${allSelect==false}">
					<input type="text" placeholder="请输入关键字" />
					<input type="button" value="查询" onclick="displaySelect()" id="butt">
				</c:if>
				<!-- 条件查询-->
				<c:if test="${sessionScope.allSelect==true}">
					按名称：
					<input name="post_title"  placeholder="请输入帖子名关键字"  value="${paramPost.post_title}"/><br/>
	 			            按作者：
					<input name="user_name"   placeholder="请输入作者名" value="${user_name}"/><br/>
					按标签：	
					<div class="label">
					<h4>
						添加标签
					</h4>
					<div class="lab-1">
						<span class="lab_title">已选标签</span>
						<ul id="ul1" class="selected"></ul>
						<input id="post_label" name="post_label" style="display:none"/>
						<input id="post_labels" name="post_labels" value="${paramPost.post_label}" style="display:${selctLabel}" readonly/>
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
				
					<input type="hidden" id="allSelect" name="allSelect" value="true" />
					<input type="submit" value="查询" id="butt">
				</c:if>	
				
				</div>
			</form>

			<table id="tab">
				<tr>
					<th>
						标题
					</th>
					<th>
						类型
					</th>
					<th>
						标签
					</th>
					<th>
						赞
					</th>
					<th>
						踩
					</th>
					<th>
						回复数
					</th>
					<th>
						发帖人
					</th>
					<th>
						创建时间
					</th>
					<th>
						更新时间
					</th>
				</tr>

				<c:choose>
					<c:when test="${empty listPost}">
						<hr />
						暂无帖子记录
					    <hr />
					</c:when>
					<c:otherwise>
						<c:forEach items="${listPost}" var="posts">
							<tr>
								<th>
									<a onclick="select(${posts.post_id})" target="_blank">${posts.post_title}</a>
									
								</th>
								<th>
								<c:if test="${posts.post_ifrefined==1}">
						               	 普通帖
								</c:if>
								<c:if test="${posts.post_ifrefined==2}">
						                                                  精华帖
								</c:if>

								</th>
								<th>
									${posts.post_label}
								</th>
								<th>	
									<c:forEach items="${likeMap}" var="likeMap">
										<c:if test="${likeMap.key==posts.post_id}">
							       			${likeMap.value}
							    		</c:if>
									</c:forEach>				
								</th>
								<th>
									<c:forEach items="${dislikeMap}" var="dislikeMap">
										<c:if test="${dislikeMap.key==posts.post_id}">
							       			${dislikeMap.value}
							    		</c:if>
									</c:forEach>	
								</th>
								<th>
									<c:forEach items="${updateCount}" var="count">
										<c:if test="${count.key==posts.post_id}">
							       ${count.value}
							    </c:if>
									</c:forEach>
								</th>
								<th>
									${posts.user.user_name}
								</th>
								<th>
								<fmt:formatDate value="${posts.post_createtime}"
												pattern="yyyy-MM-dd HH:mm:ss" />
									
								</th>
								<th>
									<c:forEach items="${updateList}" var="time">
										<!--帖子被回复-->
										<c:if test="${time.post_id==posts.post_id}">
											<fmt:formatDate value="${time.content_updatetime}"
												pattern="yyyy-MM-dd HH:mm:ss" />
										</c:if>
									</c:forEach>
								</th>
							</tr>
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
		<script type="text/javascript"  src="jquery/discuss/createPost.js" charset="gb2312"></script>	
	</body>
</html>
