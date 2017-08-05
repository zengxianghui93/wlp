<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%	String context = request.getContextPath();
    request.setAttribute("context",context);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="${context }/css/mainHT.css">
	<title>Insert title here</title>
</head>
<body class="HDZJ2016ht_body2">
<div align="center">
	<div style="width: 70%; margin: 0 auto">
		<c:if test="${!empty errorMsg}">
		   <div  class="HDZJ2016ht_h2">${errorMsg}</div>
		</c:if>
	</div>
	<h3>用户列表</h3>
	<table class="HDZJ2016ht_TB1" style="width: 40%">
		<tr>
			<td width="10%" style="text-align: center">用户名</td>
			<td width="30%" style="text-align: center">操作</td>
		</tr>
		<c:forEach var="user" items="${userList}">
		<tr>
			<td>${user.userName }</td>
			<td style="text-align: center">
				<a class="a1" href="${context }/manage/editUser-${user.userId}.html">编辑</a>
				<a class="a2" href="${context }/manage/delUser-${user.userId}.html" onClick="return confirm('确实想删除吗？')" >删除</a>
			    <a class="a3" href="${context }/manage/authority/roleOfUser-${user.userId}.html">编辑用户角色</a>
			</td>
		</tr>
		</c:forEach>
	</table>

</div>
${requestScop.users }

</body>
</html>