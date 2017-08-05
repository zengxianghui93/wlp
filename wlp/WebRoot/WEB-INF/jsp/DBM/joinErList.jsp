<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	String context = request.getContextPath();
	request.setAttribute("context", context);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看数据库的数据</title>
</head>
<body>
	<table>
		<tr>
			<td><a href="javascript:history.go('-1')">返回</a></td>
			<td><fmt:formatDate pattern="yyyy-MM-dd" value="${meetmap.time}" />&nbsp;&nbsp;${meetmap.name}&nbsp;&nbsp;参会人员</td>
		</tr>
	</table>
	<table border="1">
		<tr>
			<td>序号</td>
			<td>姓名</td>
			<td>联系方式</td>
			<td>邮箱</td>
			<td>单位名称</td>
		</tr>
		<c:forEach var="datamap" items="${pagination.resultList}">
			<tr>
				<td>${datamap.id}</td>
				<td>${datamap.joinname}</td>
				<td>${datamap.phone}</td>
				<td>${datamap.email}</td>
				<td>${datamap.company}</td>
			</tr>
		</c:forEach>
	</table>
	共${pagination.totalRows}条数据
	<a href="${context}/DBM/meetjoin-${meetid}.html?pageNo=1">首页</a>
	<a
		href="${context}/DBM/meetjoin-${meetid}.html?pageNo=${pagination.currentPage-1}">上一页</a>
	<a
		href="${context}/DBM/meetjoin-${meetid}.html?pageNo=${pagination.currentPage+1}">下一页</a>
	<a
		href="${context}/DBM/meetjoin-${meetid}.html?pageNo=${pagination.totalPages}">末页</a>
</body>