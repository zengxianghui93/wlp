<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
    String context = request.getContextPath();
    request.setAttribute("context",context);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>用户登录_湿地公园</title>

<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<link type="text/css" rel="stylesheet" href="${context}/css/login.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/index.js"></script>
<script type="text/javascript">
      document.onkeydown=function(event){
            var e = event || window.event || arguments.callee.caller.arguments[0];
             if(e && e.keyCode==13){ // enter 键
                 //要做的事情
                // alert(document.getElementById("form1").action);
            	document.getElementById("form1").submit();
            }
        }; 
</script>
<script type="text/javascript">
var codes ; //在全局 定义验证码
$(function(){
codes = new Array();
var codeLength = 4;//验证码的长度
var checkCode = document.getElementById("Code");

var selectChar = new Array(2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z');

for(var i=0;i<codeLength;i++) {
   var charIndex = Math.floor(Math.random()*32);
   codes +=selectChar[charIndex];
}
if(codes.length != codeLength){
   createCode();
}
checkCode.value = codes;
});
function createCode(){ 
	codes = new Array();
	var codeLength = 4;//验证码的长度
	var checkCode = document.getElementById("Code");

	var selectChar = new Array(2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z');

	for(var i=0;i<codeLength;i++) {
	   var charIndex = Math.floor(Math.random()*32);
	   codes +=selectChar[charIndex];
	}
	if(codes.length != codeLength){
	   createCode();
	}
	checkCode.value = codes;
	}
function checkcheckCode() { 
	if (document.form1.checkCodes.value == "") {
		alert("请输入图形验证码！");
		document.form1.checkCodes.focus();
		return false;
	}
	var inputCode = document.getElementById("checkCodes").value.toUpperCase();
	if(inputCode == codes ){
	   return true;
	}
	else {
	   alert("验证码输入错误！");
	   return false;
	}
}
	function checkform() { 
		if(checkcheckCode()==false){ return false };
	 	return true;     
	}

function goLogin(){
	$('#form1').submit();
	//javascript:document.form1.submit()
}
</script>
</head>

<body>
	<div class="YJ2016_HTHeader">
		<div class="header">
			<div class="logo">
				<a href="index.jsp"><img height="84" src="${context}/images/logo.png"></a>
			</div>
			<%-- <div class="fn">
					<span>如果您还没有账号</span>
					<a href="${context}/register.jsp">请注册</a>
					<a href="${context}/index.html">首页</a>
			</div> --%>
		</div>
	</div>

	<div class="YJ2016_NewLogin YJ2016_clearfix">
		
		<div class="login_left">
			<c:if test="${!empty errorMsg}">
				<div id="error " style="color:red">${errorMsg}</div>
			</c:if>
			<form name="form1" id="form1" action="${context}/login/doLogin.html" method="post">
			<table>
				<c:if test="${name==null}">
				<tr>
					<td><input type="text" name="userName" id="userName" class="in_ID" value="请输入用户名" onfocus="if(value==defaultValue){value='';$(this).css('color','#333333')}" onblur="if(!value){value=defaultValue;$(this).css('color','#AAAAAA')}" /></td>
				</tr>
				</c:if>
				<c:if test="${name!=null}">
				<tr>
					<td><input type="text" name="userName" id="userName" class="in_ID" value="${name}" onfocus="if(value==defaultValue){value='';$(this).css('color','#333333')}" onblur="if(!value){value=defaultValue;$(this).css('color','#AAAAAA')}" /></td>
				</tr>
				</c:if>
				<tr>
					<td><input type="password" class="in_Pwd" name="password" value="请输入密码" onfocus="if(value==defaultValue){value='';$(this).css('color','#333333');$(this).attr('type','password');}" onblur="if(!value){value=defaultValue;$(this).css('color','#AAAAAA');$(this).attr('type','text');}"/></td>
				</tr>
				<c:if test="${logincount>3}">
				<tr>
		            <td><input type="text" class="in_ID" style="width: 100px;" id="checkCodes" value="请输入验证码" onfocus="if(value==defaultValue){value='';$(this).css('color','#333333')}" onblur="if(!value){value=defaultValue;$(this).css('color','#AAAAAA')}" />
		            <input type="button" id="Code" class="code" style="width:100px" onClick="createCode()" /> <a href="#" onClick="createCode()">看不清楚</a>
		            </td>
	            </tr>
	            </c:if>
				<%-- <tr>
					<td style="text-align: right;margin: 20px 0;"><a href="${context}/login/zhaohuimima.html">忘记密码？</a></td>
				</tr> --%>
				<c:if test="${logincount<=3||logincount==null}">
				<tr>
					<td class="td2"><a class="a_login" href="#" onclick="goLogin()">登录</a></td>
				</tr>
				</c:if>
				<c:if test="${logincount>3}">
				<tr>
				<td class="td2"><input id="submit" class="a_login" type="submit" onclick="return checkform()" value="登录">
				</td>
				</tr>
				</c:if>
			</table>
			</form>
		</div>
		
		<div class="login_right">
			<div class="tt">用户登录</div>
		</div>
	</div>


	<div class="YJ2016_footerWrap">
		<div class="footer">
			<div class="ftLeft">
				<!--################  2017-03-03  ####################-->        	
				<a href="${context}/index.html">首页</a><span>|</span><a href="${context}/abount/topabount-1.html">关于我们</a>
				<br><a href="http://www.miibeian.gov.cn/">京ICP备11022607号-7</a>
			</div>
			<div class="ftRight">
				Copyright © 1997- 冶金工业信息标准研究院 All Rights Reserved
				<br>客户服务热线：010-65250592&nbsp;&nbsp;&nbsp;咨询服务热线：010-65265341，010-65251353
			</div>
		</div>
	</div>
</body>

</html>
