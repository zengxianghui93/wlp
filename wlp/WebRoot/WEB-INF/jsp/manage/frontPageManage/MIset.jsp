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
<title>情报系统显示设置_前台页面管理</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript" src="${context}/js/WdatePicker.js"></script>
<style type="text/css">
.leftmenu-zhao {
	border: 1px solid #ccc;
	height: 660px;
	width: 98%;
	overflow: scroll;
	overflow-x: hidden;
}
</style>
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
		<div class="con">
			<div class="leftmenu-zhao" style="margin-top: 20px;">
				<table class="userTable" style="margin-left: 2px;width:99%;">
					<tr class="cTitle">
						<td class="ct1">细览页</td>
						<td>右侧相关是否显示</td>
					</tr>
					<tr>
						<td>相关情报</td>
						<td><input type="checkbox"></td>
					</tr>
					<tr>
						<td>相关专题</td>
						<td><input type="checkbox"></td>
					</tr>
					<tr>
						<td>相关产品</td>
						<td><input type="checkbox"></td>
					</tr>
					<tr>
						<td>相关数据</td>
						<td><input type="checkbox"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="button"
							style="width: 120px; height: 35px; text-align: center; line-height: 35px; background: #3575b5; color: #fff; margin-top: 20px;"
							value="保存" /> <input type="button"
							style="width: 120px; height: 35px; text-align: center; line-height: 35px; background: #3575b5; color: #fff; margin-top: 20px;"
							value="取消" /></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<!-- 引入底部 -->
	<%-- <jsp:include page="../include/bottom.jsp"></jsp:include> --%>
</body>
</html>