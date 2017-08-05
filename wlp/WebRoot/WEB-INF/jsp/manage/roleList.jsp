<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
    String context = request.getContextPath();
    request.setAttribute("context",context);
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>角色列表</title>
<link type="text/css" rel="stylesheet" href="${context}/css/FldList.css" />
</head>
<body style="margin-left:40px">
	<%-- <a href="${context}/manage/addRole.html" class="listBtn">添加角色</a> --%>
	<table border="1">
		<tbody>
		<tr class="tit">
			<td>序号</td>
			<td>角色名称</td>
			
			<td>描述</td>
			
			<td>授权</td>
			
		</tr>
		<c:forEach var="role" items="${listRoles}">    
		<tr>
			<td>${role.id}</td>
			
			<td>${role.name}</td>
			<td>${role.roleDesc}</td>
		
			
			<td><a href="${context}/manage/role-${role.id}.html">授权</a></td>
			
		</tr>
		</c:forEach> 
		</tbody>
	</table>

</body>
</html>