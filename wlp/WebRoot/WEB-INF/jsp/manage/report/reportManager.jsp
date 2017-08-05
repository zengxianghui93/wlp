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
//后台修改
function update(){
	var countTime = 0;
	var countLanguage = 0;
	var countAuthor = 0;
	var countDatabase = 0;
	var countOrg = 0;
	var countSerial = 0;
	var numLimit = $("#numLimit").val();
	if($("#countTime").is(":checked")){
		countTime = 1;
	};
	if($("#countLanguage").is(":checked")){
		countLanguage = 1;
	};
	if($("#countAuthor").is(":checked")){
		countAuthor = 1;
	};
	if($("#countDatabase").is(":checked")){
		countDatabase = 1;
	};
	if($("#countOrg").is(":checked")){
		countOrg = 1;
	};
	if($("#countSerial").is(":checked")){
		countSerial = 1;
	};
	
	var test = /^\d+$/;
	if(!test.test(numLimit)){
		alert("请输入正确数字");
		return;
	}
	
	$.post("${context}/manage/report/update.html", {id:"${report.id}",context:$("#context").val(),countTime:countTime,countLanguage:countLanguage,countAuthor:countAuthor,
		countDatabase:countDatabase,countOrg:countOrg,countSerial:countSerial,numLimit:numLimit}, 
			 function(data) {
		 		alert("修改完成!");
	}, "text"); 
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
            	<span class="setTit">修改检索报告模板</span>
                <div class="HTnd_gdmod">
					
					                
                	<p><span style="width: 18%;">相关说明：</span><textarea cols="1" rows="10" id="context" style="width:60%;">${report.context}</textarea><strong>*</strong></p>
                	<p><span style="width: 30%;hidth:200px;margin-left: 11px">统计内容：</span><span style="width:65%;"><strong>"√"表示选中</strong></span></p>
                	<span id="quanxian"></span>
                	<input  type="checkbox" id="countTime" <c:if test="${report.countTime==1}">checked="true"</c:if> />时间统计
                	<input  type="checkbox" id="countLanguage" <c:if test="${report.countLanguage==1}">checked="true"</c:if> style="margin-left: 10%" />语种统计<br>
                	<input  type="checkbox" id="countAuthor" style="margin-left: 2%" <c:if test="${report.countAuthor==1}">checked="true"</c:if>/>作者统计
                	<input  type="checkbox" id="countDatabase" style="margin-left: 10%" value="1" <c:if test="${report.countDatabase==1}">checked="true"</c:if>/>数据库统计<br>
                	<input  type="checkbox" id="countOrg" <c:if test="${report.countOrg==1}">checked="true"</c:if>/>机构统计
                	<input  type="checkbox" id="countSerial" <c:if test="${report.countSerial==1}">checked="true"</c:if> style="margin-left: 10%"/>期刊统计<br>
                    <p><span style="margin-left: -5%;width:20%">检索结果显示数量：</span><input  type="text" id="numLimit" value="${report.numLimit}" style="width:60%;margin-left: 3%"/><strong>*</strong></p>
                	<span class="mod_btn" style="text-align: center">
                    	<a href="javascript:update();">完成</a>
                    	<input type="hidden" id="types" name="types">
                    </span>
                </div>
            </div>
    </div>
    </div>
	<!--con-->
	<!--YJ2016_HTmain-->
</body>
</html>