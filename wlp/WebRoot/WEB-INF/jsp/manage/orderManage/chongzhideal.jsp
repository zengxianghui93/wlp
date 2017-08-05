<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%
	String context = request.getContextPath();
	request.setAttribute("context", context);
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IP权限管理_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script src="${context}/js/jquery.artDialog.source.js" type="text/javascript"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript">
function txtonfocus(jine) {
    if (jine.value == '0') {
    	jine.value = '';
    }
}
function txtonblur(jine) {
    if (jine.value == '') {
    	jine.value = '0';
    }
}
</script>
<script>
function checkjine() {
	if (document.chongzhi.jine.value == "") {
		alert("请输入金额");
		document.chongzhi.jine.focus();
		return false;
	}
	//以字母或数字开头，跟上@,   /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/
	var expr = /^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/;
	var re = new RegExp(expr)
	if (!re.test(document.chongzhi.jine.value)) {
		alert("输入的金额格式有误！");
		document.chongzhi.jine.focus();
		return false;
	}
}
	function checkform() { 
		if(checkjine()==false){ return false };
	 	return true;     
	}
</script>
</head>
<body>
	<!-- 引入头部 -->
	<div class="YJ2016_HTRote">
		<a href="javascript:void(0)" onclick="toCategory('0000')">首页</a>&nbsp;&nbsp;&gt;&nbsp;&nbsp; 
		<span id="addOrUpdate1">充值</span>
	</div>
	<div class="YJ2016_HTmain YJ2016_clearfix ">
		<!-- 左侧菜单引入 -->
		<div class="con" align="center"  style="float: left;margin-left: 4%;margin-bottom: 4%">
			<div class="HTnd1" style="display: inline-block;" align="center" >
			  <form name="chongzhi" action="${context}/manage/account.html" method="post">
            	<span class="setTit" id="addOrUpdate2">账户充值</span>
                <div class="HTnd_gdmod" align="center">
                	<p><span style="width: 100px;margin-left:-40px" >用户名：</span><input  type="text" name="name" id="wf_categoryName" value="${account.user_name}" style="width:60%;" readonly/></p>
                    <p><span style="width: 100px;margin-left:-40px" >余额：</span><input  type="text" name="yue" id="wf_searchStrategy" value="${account.wf_balance}" style="width:60%;" readonly/></p>
                	<p><span style="width: 100px;margin-left:-40px" >充值金额：</span><input  type="text" name="jine" id="wf_searchStrategy" onfocus="txtonfocus(this)" onblur="txtonblur(this)" style="width:60%;" value='0'/></p>
                   <div align="center">
                    <span class="mod_btn1"> <a
							href="javascript:document:chongzhi.submit();" onclick=" return checkform()" class="creat">充值</a>
							<a href="javascript:void(0);" onclick="history.go(-1)">返回</a>
						</span>
						</div>
                </div>
                <input type="hidden" id="id" name="id" value="${account.id}">
                 </form>
            </div>
    </div>
    </div>
	<!--con-->
	<!--YJ2016_HTmain-->
</body>
</html>