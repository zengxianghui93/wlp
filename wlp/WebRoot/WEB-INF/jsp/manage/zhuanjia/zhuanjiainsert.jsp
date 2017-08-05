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
function checkjine() {
	if (document.form1.wf_photo.value == "") {
		alert("照片不能为空！");
		document.form1.wf_photo.focus();
		return false;
	}
}
function checkwf_name() {
	if (document.form1.wf_name.value == "") {
		alert("姓名不能为空！");
		document.form1.wf_name.focus();
		return false;
	}
}
function checkwf_by1() {
	if (document.form1.wf_by1.value == "") {
		alert("职称不能为空！");
		document.form1.wf_by1.focus();
		return false;
	}
}

function checkwf_unit() {
	if (document.form1.wf_unit.value == "") {
		alert("单位不能为空！");
		document.form1.wf_unit.focus();
		return false;
	}
}
function checkwf_abstract() {
	if ($("cke_wf_abstract").val()== "") {
		alert("简介不能为空！");
		document.form1.cke_wf_abstract.focus();
		return false;
	}
}
	function checkform() { 
		if(checkjine()==false){ return false };
		if(checkwf_name()==false){ return false };
		if(checkpaixu()==false){ return false };
		if(checkwf_by1()==false){ return false };
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
				<span class="setTit">专家添加</span>
				<div class="HTnd_gdmod">
					<form name="form1"
						action="${context}/manage/specialistinsert.html"
						method="post" enctype="multipart/form-data">
					<h4 style="text-align: center; color: red">
						<c:if test="${!empty errorMsg}">
							<div id="error " style="color: red">${errorMsg}</div>
						</c:if>
					</h4>

		<div class="YJ2016_UserMain_form">
			<table class="form_tb1">
				<tr>
					<td class="td1">专家照片：</td>
					<td class="YJ2016_clearfix">
						<input class="input1" type="file" name="wf_photo" />
					</td>
				</tr>
				<tr>
					<td class="td1">专家姓名：</td>
					<td><input  type="text" name="wf_name" /></td>
				</tr>
				<tr>
					<td class="td1">专家性别：</td>
					<td><input  type="radio" name="wf_sex" checked="checked" value="1"/>男
					    <input  type="radio" name="wf_sex" value="2"/>女
					</td>
				</tr>
				<tr>
					<td class="td1">专家职称：</td>
					<td><input  type="text" name="wf_by1" /></td>
				</tr>
				<tr>
					<td class="td1">专家单位：</td>
					<td><input type="text" name="wf_unit"/></td>
				</tr>
				<tr>
					<td class="td1">专家团队：</td>
					<td><input type="checkbox" name="wf_by2" value="1"/>第一届<input type="checkbox" name="wf_by2" value="2"/>第二届<input type="checkbox" name="wf_by2" value="3"/>第三届
						</td>
				</tr>
				<tr>
					<td class="td1">专家简介：</td>
					<td><textarea name="wf_abstract" class="ckeditor textarea1"></textarea>
						</td>
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