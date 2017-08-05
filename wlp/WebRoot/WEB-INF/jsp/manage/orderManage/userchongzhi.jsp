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
<title>用户管理_冶金信息网后台</title>
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
			<div align="center" style="font-size: 25px;">
						<br /><h2>账户金额变动记录</h2><br/>
					</div>
			<table class="userTable" style="margin-top: 20px;">
				<tr class="cTitle">
					<td style="width: 5%;">序号</td>
					<td style="width: 5%;">用户名</td>
					<td style="width: 15%;">时间</td>
					<td style="width: 5%;">金额变动</td>
					<td style="width: 10%;">说明</td>
					<!-- <td style="width: 10%;">删除</td> -->
				</tr>
				<c:forEach var="user" items="${pagedNews.result}" varStatus="status">
					<tr>
						<td>${(pagedNews.currentPageNo-1)*10+status.index+1}</td>
						<td>${user.username}</td>
						<td>${user.createTime}</td>
						<td>${user.wf_balances}</td>
						<td>${user.wf_instructions}</td>
						<%-- <td><a href="${context }/manage/recorddelete-${user.id}-${user.userId}.html"
							onClick="return confirm('确实想删除吗？')" style="color:red;">删除</a></td> --%>
					</tr>
				</c:forEach>
			</table>
			<div class="notePage">
				<div class="page">
					共<span>${pagedNews.totalCount}</span>条记录&nbsp;&nbsp; <span>${pagedNews.currentPageNo}/${pagedNews.totalPageCount}</span>页

					<c:if test="${pagedNews.currentPageNo <=1}">首页</c:if>
					<c:if test="${pagedNews.currentPageNo >1 }">
						<a href="${context}/manage/record-${user.userId}.html?pageNo=1"
							style="margin-right: 5px;">首页</a>
					</c:if>

					<c:if test="${!pagedNews.hasPreviousPage}">上一页</c:if>
					<c:if test="${pagedNews.hasPreviousPage}">
						<a
							href="${context}/manage/record-${user.userId}.html?pageNo=${pagedNews.currentPageNo -1 }"
							style="margin-right: 5px;">上一页</a>
					</c:if>

					<c:if test="${!pagedNews.hasNextPage}">下一页</c:if>
					<c:if test="${pagedNews.hasNextPage}">
						<a
							href="${context}/manage/record-${user.userId}.html?pageNo=${pagedNews.currentPageNo +1 }"
							style="margin-right: 5px;">下一页</a>
					</c:if>

					<c:if test="${pagedNews.currentPageNo >= pagedNews.totalPageCount}">尾页</c:if>
					<c:if test="${pagedNews.currentPageNo < pagedNews.totalPageCount}">
						<a
							href="${context}/manage/record-${user.userId}.html?pageNo=${pagedNews.totalPageCount }"
							style="margin-right: 5px;">尾页</a>
					</c:if>

					第 <select
						onchange="self.location.href= options[selectedIndex].value">
						<option
							value="${context}/manage/record-${user.userId}.html?pageNo=${pagedNews.currentPageNo}.html">${pagedNews.currentPageNo}</option>
						<c:if
							test="${pagedNews.currentPageNo+1 <= pagedNews.totalPageCount}">
							<option
								value="${context}/manage/record-${user.userId}.html?pageNo=${pagedNews.currentPageNo+1}">${pagedNews.currentPageNo+1}</option>
						</c:if>
						<c:if
							test="${pagedNews.currentPageNo+2 <= pagedNews.totalPageCount}">
							<option
								value="${context}/manage/record-${user.userId}.html?pageNo=${pagedNews.currentPageNo+2}">${pagedNews.currentPageNo+2}</option>
						</c:if>
						<c:if
							test="${pagedNews.currentPageNo+3 <= pagedNews.totalPageCount}">
							<option
								value="${context}/manage/record-${user.userId}.html?pageNo=${pagedNews.currentPageNo+3}">${pagedNews.currentPageNo+3}</option>
						</c:if>
						<c:if
							test="${pagedNews.currentPageNo+4 <= pagedNews.totalPageCount}">
							<option
								value="${context}/manage/record-${user.userId}.html?pageNo=${pagedNews.currentPageNo+4}">${pagedNews.currentPageNo+4}</option>
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