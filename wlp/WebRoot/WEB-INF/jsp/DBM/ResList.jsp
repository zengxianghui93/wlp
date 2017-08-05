<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% 
    String context = request.getContextPath();
    request.setAttribute("context",context);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理资源库</title>
<link type="text/css" rel="stylesheet" href="${context}/css/FldList.css" />
</head>
<body>
	<a href="${context}/DBM/addResPage.html" class="listBtn">添加资源库</a>
	<table border="1">
		<tbody>
			<tr class="tit">
				<td>资源库名称</td>
				<!-- <td>物理表名	</td> -->
				<td>描述</td>
				<td>创建时间</td>
				<td>采编流程</td>
				<!-- <td>编辑属性</td> -->
				<td>维护数据</td>
				<!-- <td>维护字段</td> -->
			</tr>
			<c:forEach var="res" items="${lstRes}">
				<tr <c:if test="${res.resId==23}">style="display:none;"</c:if>>
					<td>${res.resName}</td>
					<%-- <td>${res.resTblName}</td> --%>
					<td>${res.resDesc}</td>
					<td>${res.resDate}</td>
					<td><c:if test="${res.resFlow==1}">
					需要审核
				</c:if> <c:if test="${res.resFlow==0}">
					直接发布
				</c:if></td>
					<%-- <td><a href="${res.resId}">编辑属性</a></td> --%>
					<td><a href="${context}/DBM/searchData-${res.resId}.html">维护数据</a></td>
					<%-- <td><a href="${context}/DBM/listResFld-${res.resId}.html">维护字段</a></td> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>