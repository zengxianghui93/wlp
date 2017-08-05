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
function checkwf_datetmies() {
	if (document.form1.wf_datetmies.value == "") {
		alert("请输入实际完成日期");
		document.form1.wf_datetmies.focus();
		return false;
	}
}
	function checkform() { 
		if(checkwf_datetmies()==false){ return false };
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
				<span class="setTit">建议查看</span>
				<div class="HTnd_gdmod">
					<form name="form1"
						action="${context}/manage/ideatupdate.html"
						method="post" enctype="multipart/form-data">
					<h4 style="text-align: center; color: red">
						<c:if test="${!empty errorMsg}">
							<div id="error " style="color: red">${errorMsg}</div>
						</c:if>
					</h4>

		<div class="YJ2016_UserMain_form">
			<table class="form_tb1">
				<tr>
					<td class="td1">建议人：</td>
					<td><input  type="text" name="username" readonly="readonly" value="${idea.username}" /></td>
				</tr>
				<tr>
					<td class="td1">建议类型：</td>
					<td><input  type="text" name="wf_ideaType" readonly="readonly" value="<c:if test="${idea.wf_ideaType == 1}">体验问题</c:if>
                    <c:if test="${idea.wf_ideaType == 2}">数据问题</c:if>
                    <c:if test="${idea.wf_ideaType == 3}">改进意见</c:if>" /></td>
				</tr>
				<tr>
					<td class="td1">建议内容：</td>
					<td><textarea readonly="readonly" name="wf_ideaContent">${idea.wf_ideaContent}</textarea></td>
				</tr>
				<tr>
					<td class="td1">建议回复：</td>
					<td><textarea name="wf_by2">${idea.wf_by2}</textarea>
						</td>
				</tr>
				<tr>
					<td class="td2" colspan="2">
						<input class="btn1" type="submit" name="submit"	value="保存" />
					</td>
				</tr>
			</table>
		</div>
               <input type="hidden" name ="id" value="${idea.f_id}"/>
				</form>
				</div>
			</div>
		</div>
	</div>
	<!--con-->
	<!--YJ2016_HTmain-->
</body>
</html>