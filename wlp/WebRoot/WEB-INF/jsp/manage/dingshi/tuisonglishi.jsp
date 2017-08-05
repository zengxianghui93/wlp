<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	String context = request.getContextPath();
	request.setAttribute("context", context);
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>推送管理_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript" src="${context}/js/WdatePicker.js"></script>
</head>
<body>
	<!-- 引入头部 -->
	<%-- <jsp:include page="../include/top.jsp"></jsp:include> --%>
	<%-- <div class="YJ2016_HTRote">
		<a href="${context}/DBM/resourceManage.html">首页</a>&nbsp;&nbsp;&gt;&nbsp;&nbsp;<span>资源管理</span>
	</div> --%>
	<div class="YJ2016_HTmain YJ2016_clearfix ">
		<!-- 左侧菜单引入 -->
		<%-- <jsp:include page="../include/leftMenu.jsp"></jsp:include> --%>
		<div class="con userCon" style="float: left;margin-left: 10px;">
		<form name="form" action="${context}/manage/onesleect.html" method="post">
			<div class="search userSearch" style="width:100%">
				<div class="userDate">
				</div>
				<div style="text-align: center;">
				</div>
			</div>
			</form>
			<div class="userbtn">
			     <a href="${context}/manage/dingshiinserts.html" class="useradd"
					style="width: 70px;">添加任务</a>
				 <a href="${context}/manage/dingshiview.html" class="userfresh">刷新</a>
			</div>
			<table class="userTable" style="margin-top: 20px;">
				<tr class="cTitle">
					<td style="width: 5%;">序号</td>
					<td style="width: 5%;">推送内容</td>
					<td style="width: 10%;">推送邮箱</td>
					<td style="width: 10%;">修改</td>
					<td style="width: 10%;">删除</td>
				</tr>
				<c:forEach var="user" items="${pagedNews.result}" varStatus="status">
					<tr>
						<td>${(pagedNews.currentPageNo-1)*10+status.index+1}</td>
						<td>${user.wf_search}</td>
						<td>${user.wf_email}</td>
						<td><a href="${context}/manage/dingshiupdatepo-${user.id}.html" style="color:#3575b5;">修改</a></td>
					    <td><a href="${context }/manage/dingshidelete-${user.id}.html"
							onClick="return confirm('确实想删除吗？')" style="color:red;">删除</a></td>
					</tr>
				</c:forEach>
			</table>
			<div class="notePage">
				<div class="page">
					共<span>${pagedNews.totalCount}</span>条记录&nbsp;&nbsp; <span>${pagedNews.currentPageNo}/${pagedNews.totalPageCount}</span>页

					<c:if test="${pagedNews.currentPageNo <=1}">首页</c:if>
					<c:if test="${pagedNews.currentPageNo >1 }">
						<a href="${context}/manage/dingshiview.html?pageNo=1"
							style="margin-right: 5px;">首页</a>
					</c:if>

					<c:if test="${!pagedNews.hasPreviousPage}">上一页</c:if>
					<c:if test="${pagedNews.hasPreviousPage}">
						<a
							href="${context}/manage/dingshiview.html?pageNo=${pagedNews.currentPageNo -1 }"
							style="margin-right: 5px;">上一页</a>
					</c:if>

					<c:if test="${!pagedNews.hasNextPage}">下一页</c:if>
					<c:if test="${pagedNews.hasNextPage}">
						<a
							href="${context}/manage/dingshiview.html?pageNo=${pagedNews.currentPageNo +1 }"
							style="margin-right: 5px;">下一页</a>
					</c:if>

					<c:if test="${pagedNews.currentPageNo >= pagedNews.totalPageCount}">尾页</c:if>
					<c:if test="${pagedNews.currentPageNo < pagedNews.totalPageCount}">
						<a
							href="${context}/manage/dingshiview.html?pageNo=${pagedNews.totalPageCount }"
							style="margin-right: 5px;">尾页</a>
					</c:if>

					第 <select
						onchange="self.location.href= options[selectedIndex].value">
						<option
							value="${context}/manage/dingshiview.html?pageNo=${pagedNews.currentPageNo}.html">${pagedNews.currentPageNo}</option>
						<c:if
							test="${pagedNews.currentPageNo+1 <= pagedNews.totalPageCount}">
							<option
								value="${context}/manage/dingshiview.html?pageNo=${pagedNews.currentPageNo+1}">${pagedNews.currentPageNo+1}</option>
						</c:if>
						<c:if
							test="${pagedNews.currentPageNo+2 <= pagedNews.totalPageCount}">
							<option
								value="${context}/manage/dingshiview.html?pageNo=${pagedNews.currentPageNo+2}">${pagedNews.currentPageNo+2}</option>
						</c:if>
						<c:if
							test="${pagedNews.currentPageNo+3 <= pagedNews.totalPageCount}">
							<option
								value="${context}/manage/dingshiview.html?pageNo=${pagedNews.currentPageNo+3}">${pagedNews.currentPageNo+3}</option>
						</c:if>
						<c:if
							test="${pagedNews.currentPageNo+4 <= pagedNews.totalPageCount}">
							<option
								value="${context}/manage/dingshiview.html?pageNo=${pagedNews.currentPageNo+4}">${pagedNews.currentPageNo+4}</option>
						</c:if>
					</select>页
				</div>
			</div>


		</div>
		<!--con-->
	</div>
	<!--YJ2016_HTmain-->
</body>
</html>