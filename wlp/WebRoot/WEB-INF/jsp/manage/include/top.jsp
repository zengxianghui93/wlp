<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript" src="${context}/js/WdatePicker.js"></script>

<div class="YJ2016_HTHeader">
	<div class="header">
		<div class="logo">
			<img src="${context}/images/logo.png" height="84" />
		</div>
		<div class="fn">
			<c:if test="${!empty USER_CONTEXT.userName}">
				<span>${USER_CONTEXT.userName},欢迎您登录!</span>
				<%-- <a target="_top" href="${context}/index.jsp" class="enter">前台页面入口</a> --%>
				<a target="_top" href="${context}/login/doLogout.html" class="quit">退出登录</a>
			</c:if>
			<c:if test="${empty USER_CONTEXT.userName}">
				<span><a href="${context}/login.jsp">登录</a></span>
				<%-- <a href="${context}/index.jsp" class="enter">前台页面入口</a> --%>
			</c:if>
		</div>
	</div>
</div>
