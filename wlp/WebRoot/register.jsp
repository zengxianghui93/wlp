<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String basePath = request.getContextPath();
	request.setAttribute("basePath", basePath);
%>

<%
	String context = request.getContextPath();
	request.setAttribute("context", context);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>用户注册_冶金信息网</title>
<link rel="stylesheet" type="text/css" href="${basePath}/css/mainHT.css">
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<link type="text/css" rel="stylesheet" href="${context}/css/login.css" />
<%-- <link type="text/css" rel="stylesheet" href="${basePath}/css/zhuanti1.css" /> --%>
<script type="text/javascript" src="${basePath}/js/jquery-1.11.1.min.js"></script>

<style type="text/css">
.code{
background-image:url(111.jpg);
font-family:Arial,宋体;
font-style:italic;
color:green;
border:0;
padding:2px 3px;
letter-spacing:3px;
font-weight:bolder;
}
.unchanged {
border:0;
}
</style>
<!-- <script>
	var InterValObj; //timer变量，控制时间  
	var count = 60; //间隔函数，1秒执行  
	var curCount;//当前剩余秒数  
	var code = ""; //验证码  
	var codeLength = 6;//验证码长度  
	function sendMessage() {
		curCount = count;
		var phone = $("#phones").val();//手机号码      
		if (phone != "") {
			//产生验证码  
			for (var i = 0; i < codeLength; i++) {
				code += parseInt(Math.random() * 9).toString();
			}
			alert(code);
			//设置button效果，开始计时  
			$("#btnSendCode").attr("disabled", "true");
			$("#btnSendCode").val("请在" + curCount + "秒内输入验证码");
			InterValObj = window.setInterval(SetRemainTime, 1000); //启动计时器，1秒执行一次  
			//向后台发送处理数据   
			$.ajax({
				type : "POST",
				dataType : 'json',
				url : "${context}/login/yanzheng.html",
				data : {
					phone : phone,
					code : code
				},
				success : function(data) {
					$("#code").val(data);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					/* alert("error"); */
				},
			});
		} else {
			alert("手机号码不能为空！");
		}
	}
	//timer处理函数  
	function SetRemainTime() {
		if (curCount == 0) {
			window.clearInterval(InterValObj);//停止计时器  
			$("#btnSendCode").removeAttr("disabled");//启用按钮  
			$("#btnSendCode").val("重新发送验证码");
			code = ""; //清除验证码。如果不清除，过时间后，输入收到的验证码依然有效      
		} else {
			curCount--;
			$("#btnSendCode").val("请在" + curCount + "秒内输入验证码");
		}
	}
	/*----------------短信验证代码完--------------------*/
</script> -->

<script type="text/javascript">
var codes ; //在全局 定义验证码
$(function(){
codes = new Array();
var codeLength = 4;//验证码的长度
var checkCode = document.getElementById("Code");
checkCode.value = "";

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
	checkCode.value = "";

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
	function checkUsername() {
		//验证用户名是否为空
		var username = document.form1.userName.value;
		if (username == "") {
			alert("请输入用户名");
			document.form1.userName.focus();
			return false;
		}
		var patrn = /^([a-z]|[A-Z]|[0-9]){6,16}$/;
		var reg = new RegExp(patrn)
		if (!reg.test(username)) {
			alert("用户名只能是数字或字母，且长度不低于6位");
			document.form1.userName.focus();
			return false;
		}
	}
	function checkEmail() {
		//验证邮箱
		if (document.form1.email.value == "") {
			alert("请输入您的E-MAIL地址");
			document.form1.email.focus();
			return (false);
		}
		//以字母或数字开头，跟上@,   /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/
		var expr = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,5}$/;
		var re = new RegExp(expr);
		if (!re.test(document.form1.email.value)) {
			alert("输入的邮箱格式有误！");
			document.form1.email.focus();
			return false;
		}
	}
	function checkPassword() {
		//验证密码   
		if (document.form1.password.value == "") {
			alert("请输入密码");
			document.form1.password.focus();
			return false;
		}
		var patrn1 = /^([a-z]|[A-Z]|[0-9]){6,16}$/;
		var patrn2 = /^\d{3,}|[a-zA-Z]{3,}$/;
		if (!patrn1.test(document.form1.password.value)) {
			alert("密码只能是数字或字母，且长度不低于6位");
			document.form1.password.focus();
			if (!patrn2.test(document.form1.password.value)) {
				alert("密码不能连续出现！");
				document.form1.password.focus();
				return false;
			}
		}
		
	}
	function checkPasswordAgain() {
		//验证重复密码 
		if (document.form1.password.value != document.form1.again.value) {
			alert("重复密码与密码不一致！");
			document.form1.again.focus();
			return false;
		}
	}
	function checkePhones() {
		if (document.form1.phone.value == "") {
			alert("请输入您的联系方式");
			document.form1.phone.focus();
			return false;
		}
		var isPhone = /^([0-9]{3,4}-)?[0-9]{7,8}$/;
		var isMob = /^1[0-9]{10}$/;
		var value = document.form1.phones.value.trim();
		if (!isPhone.test(value) && !isMob.test(value)) {
			alert("联系方式格式错误。");
			document.form1.phones.focus();
			return false;
		}
	}
	function checkcheckCode() {
		if (document.form1.checkCode.value == "") {
			alert("请输入手机验证码！");
			document.form1.checkCode.focus();
			return false;
		}
	}
	function checkcheckCodes() { 
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
			if(checkUsername()==false){ return false };
			if(checkPassword()==false){ return false };
			if(checkPasswordAgain()==false){ return false };
			if(checkEmail()==false){ return false };
			if(checkcheckCodes()==false){ return false };
			if(checkePhones()==false){ return false };
			if(checkcheckCode()==false){ return false };
			if(document.form1.isBroker.value==1){
				if(checkRealname()==false){ return false};
				if(checkePhones()==false){ return false};
			}
		 	return true;     
		}
	function checkRealname() {
		if (document.form1.realName.value == "") {
			alert("请输入您的真实姓名");
			document.form1.realName.focus();
			return false;
		}
		var reg = /^[\u4e00-\u9fa5\s\·]{2,7}$/;
		if (!reg.test(document.form1.realName.value)) {
			alert("真实姓名只能是汉字");
			document.form1.realName.focus();
			return false;
		}
	}
	function function1() {
		$(".hidden").show();
	}
	function function2() {
		$(".hidden").hide();
	}
</script>
</head>
<body>

	<div class="YJ2016_HTHeader">
		<div class="header">
			<div class="logo">
				<a href="index.jsp"><img height="84" src="${context}/images/logo.png"></a>
			</div>
			<div class="fn">
				<span>如果您已有账号</span>
				<a href="${context}/login.jsp">请登录</a>
				<a href="${context}/index.html">首页</a>
			</div>
		</div>
	</div>


	<div class="YJ2016_NewLogin YJ2016_clearfix">		
		<div class="login_left login_left2">			
			<form name="form1" action="<c:url value="/register.html" />" method="post" enctype="multipart/form-data">
			<c:if test="${!empty errorMsg}">
				<div id="error " style="color:red">${errorMsg}</div>
			</c:if>
			<input type="hidden" name="code" id="code"></input>
			<table>
				<tr>
					<td class="td1">用户名：</td>
					<td><input id="NAME" type="text" name="userName" /><span class="red">*</span>
						<div class="ps">用户名至少6位，只能是数字或字母</div>
					</td>
				</tr>
				<tr>
					<td class="td1">密 码：</td>
					<td><input type="password" name="password" /><span class="red">*</span>
						<div class="ps">密码至少6位，只能是数字或字母</div>
					</td>
				</tr>
				<tr>
					<td class="td1">密码确认：</td>
					<td><input type="password" name="again"><span class="red">*</span>
						<div class="ps">重复密码与密码必须一致</div>
					</td>
				</tr>
				<tr>
					<td class="td1">电子邮箱：</td>
					<td><input id="EMAIL" type="text"  name="email" /><span class="red">*</span>
						<div class="ps">邮箱会用于激活此账号，请慎重填写</div>
					</td>
				</tr>
				<tr>
					<td class="td1">性别：</td>
					<td>
						<label><input type="radio" name="userSex" checked="checked" value="1" />男</label>
						<label><input type="radio" name="userSex" value="0" />女</label>
					</td>
				</tr>
				<tr>
					<td class="td1">是否填写完整信息：</td>
					<td>
						<label><input onclick="function1()" type="radio"name="isBroker" value="1" />是</label>
						<label><input onclick="function2()" type="radio" name="isBroker" checked="checked" value="0" />否</label>
					</td>
				</tr>
				<tr class="hidden" style="display: none">
					<td class="td1">上传头像：</td>
					<td><input type="file" name="photo" /></td>
				</tr>
				<tr class="hidden" style="display:none">
					<td class="td1">真实姓名：</td>
					<td><input type="text" name="name"/></td>
				</tr>
				<tr class="hidden" style="display: none">
					<td class="td1">所属部门：</td>
					<td><input type="text" name="department" /></td>
				</tr>
				<tr class="hidden" style="display: none">
					<td class="td1">所属集团：</td>
					<td><input type="text" name="groups" /></td>
				</tr>
				<tr class="hidden" style="display: none">
					<td class="td1">工作单位：</td>
					<td><input type="text" name="enterprisename" /></td>
				</tr>
				<tr class="hidden" style="display: none">
					<td class="td1">出生日期：</td>
					<td><input type="text" name="birthday" /></td>
				</tr>
				<tr class="hidden" style="display: none">
					<td class="td1">职称：</td>
					<td><input type="text" name="duty" /></td>
				</tr>
				<tr class="hidden" style="display: none">
					<td class="td1">职务：</td>
					<td><input type="text" name="professional" /></td>
				</tr>
				<tr class="hidden" style="display: none">
					<td class="td1">行业：</td>
					<td><input type="text" name="industry" /></td>
				</tr>
				<tr class="hidden" style="display: none">
					<td class="td1">学历：</td>
					<td><input type="text" name="education" /></td>
				</tr>
				<tr class="hidden" style="display: none">
					<td class="td1">地址：</td>
					<td><input type="text" name="user_address" /></td>
				</tr>
				<!-- <tr>
					<td class="td1">手机号码</td>
					<td><input type="text" id="phone" name="phone" /></td>
				</tr>
				<tr>
					<td class="td1">验证码</td>
					<td><input type="text" id="checkCode" name="checkCode" size="6" />
						<input id="btnSendCode" type="button" value="发送验证码"
						onclick="sendMessage()" />
						</td>
				</tr> -->
				<tr>
					<td class="td1">请输入验证码：</td>
		            <td><input type="text" id="checkCodes" name="checkCodes" style="width:100px" />
		            <input type="button" id="Code" value="" class="code" style="width:100px" onClick="createCode()" /> <a href="#" onClick="createCode()">看不清楚</a>
		            </td>
	            </tr>
				<tr>
					<td class="td2" colspan="2">
						<input id="submit" class="btn1" type="submit"	onclick=" return checkform()" value="注册">
						<input class="btn2" type="reset" value="重置">
					</td>
				</tr>
			</table>
			</form>
		</div>
		
		<div class="login_right">
			<div class="tt">用户注册</div>
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
