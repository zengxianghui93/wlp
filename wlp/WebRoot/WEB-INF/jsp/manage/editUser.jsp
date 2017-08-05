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
<script type="text/javascript">
	function checked() {

		var check2 = isNull("password", "密码不能为空");
		return check2;
	}

	function isNull(eleId, msg) {
		var value = document.getElementById(eleId).value;
		if (value.trim().length == 0) {
			var node = document.createTextNode(msg);
			var span = document.createElement("span");

			span.appendChild(node)
			document.getElementById(eleId).parentNode.appendChild(span);
			return false;
		}

		return true;

	}
</script>
</head>
<body>
	<%-- <div class="YJ2016_HTRote">
		<a href="${context}/DBM/resourceManage.html">首页</a>&nbsp;&nbsp;&gt;&nbsp;&nbsp;<span>资源管理</span>
	</div> --%>
	<div class="YJ2016_HTmain YJ2016_clearfix ">
		<div class="con userCon">
			<div align="center" style="font-size: 25px;">
				<br />
				<h1>用户${user.userName}的详细信息</h1>
				<br />
			</div>
			<div style="font-size: 25px;margin-bottom: 10px;">
				<a href="${context}/manage/editPwd-${user.userId}.html"
					style="margin-left: 25%; color: #1377B3">修改密码</a>
			</div>
			<form action="updateUser.html" method="post">
				<table class="HDZJ2016ht_TB1" style="width: 50%">
					<input type="hidden" name="userId" value="${user.userId}" />
					</td>
					<input type="hidden" name="userName" value="${user.userName}" />
					<tr>
						<td width="20%">账号</td>
						<td>${user.userName}</td>
					</tr>

					<tr>
						<td width="20%">邮箱</td>
						<td><input class="input1" type="text" name="email"
							value="${user.email}" /></td>
					</tr>
					<tr>
						<td width="20%">性别</td>
						<td><label><input type="radio" name="userSex"
								value="1" <c:if test="${user.userSex ==1}">checked</c:if> />男</label>&nbsp;&nbsp;
							<label><input type="radio" name="userSex" value="0"
								<c:if test="${user.userSex ==0}">checked</c:if> />女</label></td>
					</tr>
					<tr>
						<td width="20%">注册时间</td>
						<td><input class="input1" type="text" readonly="readonly"
							value="${user.createTime}" /></td>
					</tr>
					<tr>
						<td width="20%">身份类型</td>
						<td><label><input type="radio" name="userType"
								value="3" <c:if test="${user.userType ==3}">checked</c:if> />超级管理员</label>&nbsp;&nbsp;
							<label><input type="radio" name="userType" value="2"
								<c:if test="${user.userType ==2}">checked</c:if> />内容管理员</label>&nbsp;&nbsp;
							<label><input type="radio" name="userType" value="1"
								<c:if test="${user.userType ==1}">checked</c:if> />技术经纪人</label>&nbsp;&nbsp;
							<label><input type="radio" name="userType" value="0"
								<c:if test="${user.userType ==0}">checked</c:if> />普通用户</label></td>
					</tr>
					<tr>
						<td width="20%">云平台用户类型</td>
						<td>
							<label><input type="radio" name="power" value="4" <c:if test="${user.power ==4}">checked</c:if> />VIP用户</label>&nbsp;&nbsp;
							<label><input type="radio" name="power" value="3" <c:if test="${user.power ==3}">checked</c:if> />VIP试用</label>&nbsp;&nbsp;
							<label><input type="radio" name="power" value="2" <c:if test="${user.power ==2}">checked</c:if> />注册用户</label>&nbsp;&nbsp;
							<label><input type="radio" name="power" value="1" <c:if test="${user.power ==1}">checked</c:if> />游客</label>
						</td>
					</tr>
					<tr>
						<td width="20%">授权开始时间</td>
						<td><input class="input1" type="text" name="authorizeStartTime"
							value='<fmt:formatDate value="${user.authorizeStartTime}" pattern="yyyy-MM-dd HH:mm:ss"/>' onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});"/></td>
					</tr>
					<tr>
						<td width="20%">授权截止时间</td>
						<td><input class="input1" type="text" name="authorizeEndTime"
							value='<fmt:formatDate value="${user.authorizeEndTime}" pattern="yyyy-MM-dd HH:mm:ss"/>'  onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" /></td>
					</tr>

				</table>
				<div style="text-align: center;margin-bottom: 10px;margin-top: 10px;">
					<input type="submit" value="确认"
						style="border: 0; background-color: #1377B3; padding: 7px 25px 9px 25px; font-family: Microsoft YaHei; font-size: 17px; color: #FFFFFF;" />
				</div>
			</form>
		</div>
		<!--con-->
	</div>
	<!--YJ2016_HTmain-->
</body>
</html>