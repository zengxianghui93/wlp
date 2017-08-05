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
<title>报告模板管理_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script src="${context}/js/jquery.artDialog.source.js" type="text/javascript"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript">
if("${errorMessage2}"!=""){
	alert("${errorMessage2}");
};
$(function(){
	var flag = $("#flag").val();
	<c:forEach items="${typeList}" var="item" varStatus="status">
		if (flag == "${item.typeId}") {
			flag = "${item.name}"
			$("#flag").val(flag);
		}
	</c:forEach>
	
	if("${article.flag}"=='1'){
		$("#handTime").hide();
		$("#falgCon1").hide();
	}else{
		$("#articleSub").hide();
		$("#subForm").hide();
	}
});


function findTypeFlag(value){
	if(value=="1"){
		$("#falgCon1").show();
		$("#falgCon").hide();
	}else{
		$("#falgCon").show();
		$("#falgCon1").hide(); 
	}
}

function returnList(){
	window.location.href="${context}/manage/ArticleTrans/ToArticleTrans.html?pageNo=${pageNo}&typeFlag=${typeFlag}";
}

function submitForm(){
	if(!checkForm()){
		return false;
	};
	document.form1.submit();
}

function checkForm(){
	if($("#handFlag").val()=="0"){
		if($("#falgCon").val().length==0){
			alert("请上传文件");
			return false;
		};
	}
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
		<div class="con" align="center"  style="float: left;margin-left: 4%">
			<div class="HTnd1" style="display: inline-block;" style="margin-right: 100%;">
            	<span class="setTit">原文传递订单处理</span>
                <div class="HTnd_gdmod">
                <form name="form1" action="${context}/manage/ArticleTrans/handArticleTrans.html"
					method="post" enctype="multipart/form-data">
               		<p><span style="margin-left: -5%;width:20%">订单编号：</span><input type="text" readonly="readonly"  value="${article.orderNumber}" /><input type="hidden" value="${article.orderNumber}" name="orderNumber"/></p>
               		<p><span style="margin-left: -5%;width:20%">提交时间：</span><input type="text" readonly="readonly"  value="${fn:substring(article.subTime, 0, 19)}"/></p>
                	<p><span style="margin-left: -5%;width:20%">数据库：</span><input type="text" readonly="readonly"  value="${res[0][1]}"/></p>
                	<p><span style="margin-left: -5%;width:20%">刊名：</span><input type="text" readonly="readonly" value="${article.articlJournal}"/></p>
                	<p><span style="margin-left: -5%;width:20%">文章标题：</span><input  type="text" readonly="readonly" value="${article.articlTittle}" /></p>
                	<p><span style="margin-left: -5%;width:20%">文章作者：</span><input  type="text" readonly="readonly" value="${article.articlAuthor}" /></p>
                	<p><span style="margin-left: -5%;width:20%">文章摘要：</span><textarea  cols="57" rows="5" readonly="readonly">${article.articlAbstract}</textarea></p>
                	<p><span style="margin-left: -5%;width:20%">金额(元)：</span><input  type="text" readonly="readonly" value="${article.articlBalance}" /></p>
                	<p><span style="margin-left: -5%;width:20%">用户名：</span><input  type="text" readonly="readonly"  value="${article.userName}" /></p>
                	<p><span style="margin-left: -5%;width:20%">用户邮箱：</span><input  type="text" readonly="readonly" value="${article.userEmail}" /></p>
                	<p><span style="margin-left: -5%;width:20%">用户电话：</span><input  type="text" readonly="readonly" value="${article.userPhone}" /></p>
                	<p><span style="margin-left: -5%;width:20%">处理状态：</span><input id="flag"  type="text" readonly="readonly" value="${article.flag}"/></p>
                	<p id="handTime" ><span style="margin-left: -5%;width:20%">处理时间：</span><input  type="text" readonly="readonly" value="${fn:substring(article.handTime, 0, 19)}"/></p>
                	<p id="articleSub"><span style="margin-left: -5%;width:20%"><select onchange="findTypeFlag(options[selectedIndex].value)" name="handFlag" id="handFlag"><option value="0">上传原文</option><option value="1">无原文</option></select>：</span>
                		<input name="articleFile" type="file" id="falgCon"/><input readonly="readonly" value="无原文，全额退款" type="text" id="falgCon1"/></p>
                	<span class="mod_btn" style="text-align: center">
                		<a href="javascript:void(0);" id="subForm" onclick="submitForm()">提交</a>
                    	<a href="javascript:returnList();">返回</a>
                    </span>
                    </form>
                </div>
            </div>
    </div>
    </div>
	<!--con-->
	<!--YJ2016_HTmain-->
</body>
</html>