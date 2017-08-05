<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% 
    String context = request.getContextPath();
    request.setAttribute("context",context);
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript" src="${context}/js/WdatePicker.js"></script>
<script type="text/javascript">
function checkPassword(){
	//验证密码   
	if(document.form1.password.value == ""){     
		alert("请输入密码");     
		document.form1.password.focus();     
		return false;     
	}
	var patrn1=/^(\w){6,20}$/;
	if(!patrn1.test(document.form1.password.value)){
		alert("密码只能输入6-20个字母和数字。");
		document.form1.password.focus();
		return false;
	}
}
</script>
</head>
<body>
    <!-- 引入头部 -->
   <%--  <jsp:include page="../include/top.jsp"></jsp:include> --%>
   <%--  <div class="YJ2016_HTRote">
    	<a href="${context}/DBM/resourceManage.html">首页</a>&nbsp;&nbsp;&gt;&nbsp;&nbsp;<span>资源管理</span>
    </div> --%>
    <div class="YJ2016_HTmain YJ2016_clearfix ">
    <%-- 	<jsp:include page="../include/leftMenu.jsp"></jsp:include> --%>
        <h1>修改密码</h1>
        <div class="con userCon">
      <form name="form1" action="updatePwd-${user.userId}.html" method="post" onsubmit="javascript:checkPassword()">
			<h4>修改用户${user.userName}的密码</h4>
			<input style="display:none" name="userId" value="${user.userId}"/></td>
			<table class="HDZJ2016ht_TB1" style="width: 50%">
				<tr><td width="20%">新密码:</td><td><input class="input1" type="text" name="password"/></td></tr>
			</table>
			<input type="submit" value="保存"/>
			<input type="button" value="取消" onclick="history.go('-1')"/>
		</form>
        </div><!--con-->
    </div><!--YJ2016_HTmain-->
</body>
</html>