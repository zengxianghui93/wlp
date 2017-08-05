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
<title>积分规则管理_冶金信息网后台</title>
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
function checkregister() {
	if (document.form1.wf_register.value == "") {
		alert("注册积分不得为空！");
		document.form1.wf_register.focus();
		return false;
	}
	var expr = /^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/;
	var re = new RegExp(expr)
	if (!re.test(document.form1.wf_register.value)) {
		alert("输入的注册积分格式有误！");
		document.form1.wf_register.focus();
		return false;
	}
}
function checkvalidation() {
	if (document.form1.wf_validation.value == "") {
		alert("手机验证积分不得为空！");
		document.form1.wf_validation.focus();
		return false;
	}
	var expr = /^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/;
	var re = new RegExp(expr)
	if (!re.test(document.form1.wf_validation.value)) {
		alert("输入的手机验证积分格式有误！");
		document.form1.wf_validation.focus();
		return false;
	}
}
function checklogin() {
	if (document.form1.wf_login.value == "") {
		alert("登陆积分不得为空！");
		document.form1.wf_login.focus();
		return false;
	}
	var expr = /^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/;
	var re = new RegExp(expr)
	if (!re.test(document.form1.wf_login.value)) {
		alert("输入的登陆积分格式有误！");
		document.form1.wf_login.focus();
		return false;
	}
}
function checklogins() {
	if (document.form1.wf_logins.value == "") {
		alert("连续登陆积分不得为空！");
		document.form1.wf_logins.focus();
		return false;
	}
	var expr = /^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/;
	var re = new RegExp(expr)
	if (!re.test(document.form1.wf_logins.value)) {
		alert("输入的连续登陆积分有误！");
		document.form1.wf_logins.focus();
		return false;
	}
}
function checkliterature() {
	if (document.form1.wf_literature.value == "") {
		alert("文献上传积分不得为空！");
		document.form1.wf_literature.focus();
		return false;
	}
	var expr = /^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/;
	var re = new RegExp(expr)
	if (!re.test(document.form1.wf_literature.value)) {
		alert("输入的文献上传积分有误！");
		document.form1.wf_literature.focus();
		return false;
	}
}
function checkcash() {
	if (document.form1.wf_cash.value == "") {
		alert("现金抵扣积分不得为空！");
		document.form1.wf_cash.focus();
		return false;
	}
	var expr = /^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/;
	var re = new RegExp(expr)
	if (!re.test(document.form1.wf_cash.value)) {
		alert("输入的现金抵扣积分有误！");
		document.form1.wf_cash.focus();
		return false;
	}
}
	function checkform() { 
		if(checkregister()==false){ return false };
		if(checkvalidation()==false){ return false };
		if(checklogin()==false){ return false };
		if(checklogins()==false){ return false };
		if(checkliterature()==false){ return false };
		if(checkcash()==false){ return false };
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
				<span class="setTit">积分规则管理</span>
				<div class="HTnd_gdmod">
					<form name="form1"
						action="${context}/manage/Integralmentupdate.html"
						method="get">
						<p>
							<span style="margin-left: -5%; width: 20%">注册积分：</span><input
								style="width: 200px;" type="text" name="wf_register" value="${Integralment.wf_register}" />
						</p>
						<p>
							<span style="margin-left: -5%; width: 20%">手机验证积分：</span><input
								style="width: 200px;" type="text" name="wf_validation" value="${Integralment.wf_validation}" />
						</p>
						<p>
							<span style="margin-left: -5%; width: 20%">每日登陆积分：</span><input
								style="width: 200px;" type="text" name="wf_login" value="${Integralment.wf_login}" />
						</p>
						<p>
							<span style="margin-left: -5%; width: 20%">连续登陆奖励积分：</span><input
								style="width: 200px;" type="text" name="wf_logins" value="${Integralment.wf_logins}" />
						</p>
						<p>
							<span style="margin-left: -5%; width: 20%">上传文献积分：</span><input
								style="width: 200px;" type="text" name="wf_literature" value="${Integralment.wf_literature}" />
						</p>
					    <p>
							<span style="margin-left: -5%; width: 20%">现金抵扣：</span><input
								style="width: 160px;" type="text" name="wf_cash" value="${Integralment.wf_cash}" />=1(元)
						</p>
						<span class="mod_btn" style="text-align: center"> <a
							href="javascript:document:form1.submit();" onclick=" return checkform()">修改</a>
							<a href="javascript:void(0);">返回</a>
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