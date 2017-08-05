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
<title>推送管理_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<link rel="stylesheet" type="text/css" href="${context}/css/mainHT.css">
<link type="text/css" rel="stylesheet" href="${context}/css/zhuanti1.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript" src="${context}/js/WdatePicker.js"></script>
<script>
function checkemail() {
	if (document.form1.wf_email.value == "") {
		alert("请输入邮箱！");
		document.form1.wf_email.focus();
		return false;
	}
	//以字母或数字开头，跟上@,   
	var expr = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/;
	var re = new RegExp(expr)
	if (!re.test(document.form1.wf_email.value)) {
		alert("输入的邮箱格式有误！");
		document.form1.wf_email.focus();
		return false;
	}
}
function checksearch() {
	if (document.form1.wf_search.value == "") {
		alert("请输入推送内容！");
		document.form1.wf_search.focus();
		return false;
	}
}
	function checkform() { 
		if(checkemail()==false){ return false };
		if(checksearch()==false){ return false };
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
    <div class="con userCon">
			<div align="center" style="font-size: 25px;">
				<br />
				<h1>添加定时任务</h1>
				<br />
			</div>
					<form name="form1"
						action="${context}/manage/dingshiinsert.html"
						method="get" enctype="multipart/form-data">
						<table class="HDZJ2016ht_TB1" style="width: 70%">
						<tr>
						<td class="td1" style="line-height: 38px;font-size: 15px;">请选择推送用户:</td>
						<td><select name="wf_email">
							    <c:forEach var="status" items="${user}" >
								  <option value="${status.email}">${status.userName}</option>
							    </c:forEach>
						</select></td>
						</tr>
						<tr>
							<td class="td1" style="line-height: 38px;font-size: 15px;">推送内容:</td>
						    <td><input type="text" id="wf_search" name="wf_search"
							class="input1" /></td>
						</tr>
						</table>
						<div style="text-align: center;margin-bottom: 10px;margin-top: 10px;">
					    <input class="HDZJ2016ht_button2" type="submit" value="确认" /> 
					    <input class="HDZJ2016ht_button2" type="button" onClick="history.go(-1)"
						value="取消" />
			        	</div>
						
					</form>
				</div>
			</div>
		</div>
	</div>
	<!--con-->
	<!--YJ2016_HTmain-->
</body>
</html>