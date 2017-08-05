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
<title>短信密钥管理_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script>
	$(function() {
		var aa = $("#aa").val();
		if (aa == 1||aa=='1') {
			// 显示隐藏
			alert("修改成功");
		}
	});
</script>
<script>
function checkUid() {
	if (document.form1.Uid.value == "") {
		alert("UID不得为空！");
		document.form1.Uid.focus();
		return false;
	}
}
function checkKEY() {
	if (document.form1.Key.value == "") {
		alert("KEY不得为空！");
		document.form1.Key.focus();
		return false;
	}
}
	function checkform() { 
		if(checkUid()==false){ return false };
		if(checkKEY()==false){ return false };
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
				<span class="setTit">短信密钥管理</span>
				<div class="HTnd_gdmod">
					<form name="form1"
						action="${context}/manage/updatethekey.html"
						method="get">
						<p>
							<span style="margin-left: -5%; width: 20%">UID：</span><input
								style="width: 200px;" type="text" name="Uid" value="${Thekey.wf_uid}" />
						</p>
						<p>
							<span style="margin-left: -5%; width: 20%">KEY：</span><input
								style="width: 200px;" type="text" name="Key" value="${Thekey.wf_key}" />
						</p>
						<span class="mod_btn" style="text-align: center"> <a
							href="javascript:document:form1.submit();" onclick=" return checkform()">修改</a>
							<a href="javascript:void(0);"  onclick="history.go(-1)">返回</a>
						</span>
						<input type="hidden" name="aa" id="aa" value="${aa}" />
					</form>
				</div>
			</div>
		</div>
	</div>
	<!--con-->
	<!--YJ2016_HTmain-->
</body>
</html>