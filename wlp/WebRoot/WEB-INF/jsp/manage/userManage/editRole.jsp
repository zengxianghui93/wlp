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
<link rel="stylesheet" type="text/css" href="${context}/css/mainHT.css">
<link type="text/css" rel="stylesheet" href="${context}/css/zhuanti1.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript" src="${context}/js/WdatePicker.js"></script>
</head>
<body>
	<div class="YJ2016_HTmain YJ2016_clearfix ">
		<div class="con userCon">
			<div align="center" style="font-size: 25px;">
				<br />
				<h1>角色信息修改</h1>
				<br />
			</div>
			<form action="editRoleC.html" method="post">
				<table class="HDZJ2016ht_TB1" style="width: 70%">
					<tr style="display: none">
						<td class="td1">id:</td>
						<td><input type="hidden" name="roleId"
							value="${roleInfo.roleId}" /></td>
					</tr>
					<tr>
						<td class="td1">角色名称:</td>
						<td><input type="text" name="roleName" class="input1"
							value="${roleInfo.roleName}" /></td>
					</tr>
					<tr>
						<td class="td1">角色描述:</td>
						<td><input type="text" id="roleDesc" name="roleDesc" class="input1"
							value="${roleInfo.roleDesc}"></td>
					</tr>
				</table>
				<div style="text-align: center;height: 50px;margin-top: 10px;">
					<input class="HDZJ2016ht_button2" type="submit" value="确认" /> <input
						class="HDZJ2016ht_button2" type="button" onClick="history.go(-1)"
						value="取消" />
				</div>
			</form>
		</div>
		<!--con-->
	</div>
	<!--YJ2016_HTmain-->
</body>
</html>