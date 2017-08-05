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
	$(function() {
		if("${type}"=="add"){
			$("#addOrUpdate1").text("增加");
			$("#addOrUpdate2").text("增加类别");
		}else{
			$("#addOrUpdate1").text("修改");
			$("#addOrUpdate2").text("修改类别");
		}
		
		
		 
	});  
	function toCategory(wf_categoryCode){
		/* if("${type}" == "update"){
			 var a = "${categoryCodeNOW}";
			 wf_categoryCode = a.substring(0,a.length-4);
		}
		alert(wf_categoryCode); */
		window.location.href = "${context}/manage/categoryManage/toCategory.html?categoryCode="+wf_categoryCode;
	}
	function update(){
		//判断是否合法
		var wf_categoryName = $("#wf_categoryName").val();
		var wf_searchStrategy = $("#wf_searchStrategy").val();
		var wf_ifShow = "";
		if(wf_categoryName.trim() == ""){
			alert("请输入分类名称");
			return;
		}
		
		wf_ifShow = $("input:radio:checked").val();
		if("${type}" == "add"){
			 //后台增加
			 $.post("${context}/manage/categoryManage/add.html", {wf_categoryCode:"${categoryCodeNOW}",wf_categoryName:wf_categoryName,wf_searchStrategy:wf_searchStrategy,wf_ifShow:wf_ifShow}, 
					 function(data) {
					 //window.location.href = "${context}/manage/categoryManage/toCategory.html?categoryCode="+"${categoryCodeNOW}";
					toCategory('${categoryCodeNOW}');
			 }, "text");
		}else if("${type}" == "update"){
			//后台修改
			 $.post("${context}/manage/categoryManage/update.html", {wf_categoryCode:"${category.wf_categoryCode}",wf_categoryName:wf_categoryName,wf_searchStrategy:wf_searchStrategy,wf_ifShow:wf_ifShow}, 
					 function(data) {
				 toCategory('${categoryCodeNOW}');
			 }, "text");
		}
	}
	
</script>
</head>
<body>
	<!-- 引入头部 -->
	<div class="YJ2016_HTRote">
		<a href="javascript:void(0)" onclick="toCategory('0000')">首页</a>&nbsp;&nbsp;&gt;&nbsp;&nbsp; 
		<c:forEach var="item" items="${supCateList}">
			<a href="javascript:void(0)" onclick="toCategory('${item.wf_categoryCode}')">${item.wf_categoryName}</a>&nbsp;&nbsp;&gt;&nbsp;&nbsp;
		</c:forEach>
		<span id="addOrUpdate1">增加</span>
	</div>
	<div class="YJ2016_HTmain YJ2016_clearfix ">
		<!-- 左侧菜单引入 -->
		<div class="con" align="center"  style="float: left;margin-left: 4%;margin-bottom: 4%">
			<div class="HTnd1" style="display: inline-block;" style="margin-right: 100%;">
            	<span class="setTit" id="addOrUpdate2">新增类别</span>
                <div class="HTnd_gdmod">
                	<p><span>分类名：</span><input  type="text" name="wf_categoryName" id="wf_categoryName" value="${category.wf_categoryName}" style="width:60%;"/><strong>*</strong></p>
                	<p><span>检索式：</span><textarea  rows="5" name="wf_searchStrategy" id="wf_searchStrategy" style="width:60%;">${category.wf_searchStrategy}</textarea><strong>*</strong></p>
                    <p><span>帮助：</span>wf_title:标题;wf_author:作者;wf_abstract:摘要;wf_keyword:关键字;wf_year:年份;<br>
                    	AND&nbsp;表示'与'运算;
										&nbsp;&nbsp;OR&nbsp;表示'或'运算;
										&nbsp;NOT&nbsp;表示'非'(不包含)运算;<br>
										 3个运算符必须大写</p>
                    <p><span style="width:20%;margin-left: 1%">是否显示：</span><span style="width:65%">&nbsp;</span></p>
                    		<input type="radio" name = "wf_isShow" value="1" <c:if test="${category.wf_ifShow==1}">checked="true"</c:if>>显示&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    		<input type="radio" name = "wf_isShow" value="0" <c:if test="${category.wf_ifShow!=1}">checked="true"</c:if>>隐藏	
                    <span class="mod_btn" style="text-align: center">
                    	<a href="javascript:update();">完成</a>
                    	<a href="javascript:void(0);" onclick="toCategory('${categoryCodeNOW}')">返回</a>
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