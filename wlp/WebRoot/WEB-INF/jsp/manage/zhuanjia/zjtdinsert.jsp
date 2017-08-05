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
<title>专家团队管理_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript" src="${context}/js/WdatePicker.js"></script>
<script>

function checkwf_unit() {
	if (document.form1.specialistteam.value == "") {
		alert("专家团队不能为空！");
		document.form1.specialistteam.focus();
		return false;
	}
}
	function checkform() { 
		if(checkwf_unit()==false){ return false };
	 	return true;     
	}
</script>
</head>
<body>
	<!-- 引入头部 -->
	<%-- <div class="YJ2016_HTRote">
		<a href="${context}/DBM/resourceManage.html">首页</a>&nbsp;&nbsp;&gt;&nbsp;&nbsp;<span>IP权限管理</span>
	</div> --%>
	<div class="YJ2016_HTmain YJ2016_clearfix ">
		<!-- 左侧菜单引入 -->
		<div class="con" align="center" style="float: left; margin-left: 4%">
			<div class="HTnd1" style="display: inline-block;"
				style="margin-right: 100%;">
				<span class="setTit">专家团队添加</span>
				<div class="HTnd_gdmod">
					<form name="form1"
						action="${context}/manage/zjtdinsert.html"
						method="post" enctype="multipart/form-data">
					<h4 style="text-align: center; color: red">
						<c:if test="${!empty errorMsg}">
							<div id="error " style="color: red">${errorMsg}</div>
						</c:if>
					</h4>

		<div class="YJ2016_UserMain_form">
		<table class="form_tb1">
				<tr>
					<td class="td1" colspan="2">已存在的专家团队：</td>
				</tr>
				<c:forEach var="item1" items="${specialistteamstatus}" varStatus="st">
				<tr>
					<td class="td1">${item1.specialistteam}</td><td class="td1"><a href="${context}/manage/zjtddelete-${item1.id}.html" onClick="return confirm('确实想删除吗？')">删除</a></td>
				</tr>
				</c:forEach>
			</table>
			<table class="form_tb1">
				<tr>
					<td class="td1">专家团队名称：</td>
					<td><input  type="text" name="specialistteam" /></td>
				</tr>
				<tr>
					<td class="td2" colspan="2">
						<input class="btn1" type="submit" name="submit" onclick=" return checkform()" value="保存" />
						<input class="btn1" type="button" onclick="history.go('-1')" value="返回" />
					</td>
				</tr>
			</table>
		</div>
               <input type="hidden" name ="id" value="${specialistTeam.f_id}"/>
				</form>
				</div>
			</div>
		</div>
	</div>
	<!--con-->
	<!--YJ2016_HTmain-->
</body>
</html>