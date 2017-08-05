<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%
	String context = request.getContextPath();
	request.setAttribute("context", context);
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>关于我们</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript" src="${context}/js/WdatePicker.js"></script>
</head>
<body>
	<!-- 引入头部 -->
	<%-- <div class="YJ2016_HTRote">
		<a href="${context}/DBM/resourceManage.html">首页</a>&nbsp;&nbsp;&gt;&nbsp;&nbsp;<span>IP权限管理</span>
	</div> --%>
	<div class="YJ2016_HTmain YJ2016_clearfix ">
		<!-- 左侧菜单引入 -->
		<div class="con" align="center" style="left; margin-left: 4%">
			<div class="HTnd1" style="width:950px; display: inline-block;"
				style="margin-right: 100%;">
				<c:if test="${abouts.id==1}">
				<span class="setTit">关于我们</span>
				</c:if>
				<c:if test="${abouts.id==2}">
				<span class="setTit">加入metalinfo</span>
				</c:if>
				<c:if test="${abouts.id==3}">
				<span class="setTit">专利分析</span>
				</c:if>
				<c:if test="${abouts.id==4}">
				<span class="setTit">情报服务</span>
				</c:if>
				<c:if test="${abouts.id==5}">
				<span class="setTit">会议组织</span>
				</c:if>
				<c:if test="${abouts.id==6}">
				<span class="setTit">客户服务</span>
				</c:if>
				<c:if test="${abouts.id==7}">
				<span class="setTit">网址导航</span>
				</c:if>
				<div class="HTnd_gdmod">
					<form name="form1"
						action="${context}/abount/updateabount-${abouts.id}.html"
						method="post" enctype="multipart/form-data">
					<h4 style="text-align: center; color: red">
						<c:if test="${!empty errorMsg}">
							<div id="error " style="color: red">${errorMsg}</div>
						</c:if>
					</h4>

		<div class="YJ2016_UserMain_form">
			<table class="form_tb1">
				<tr>
					<td class="td1">内容：</td>
					<td><textarea name="wf_about" class="ckeditor textarea1">${abouts.wf_about}</textarea>
						</td>
				</tr>
				<tr>
					<td class="td2" colspan="2">
						<input class="btn1" type="submit" onclick=" return checkform()" name="submit"	value="保存" />
					    <input class="btn1" type="button" onclick="history.go('-1')" name="submit"	value="返回" />
					</td>
				</tr>
			</table>
		</div>
               <input type="hidden" name ="eid" value="${id}"/>
				</form>
				</div>
			</div>
		</div>
	</div>
	<!--con-->
	<!--YJ2016_HTmain-->
</body>
</html>