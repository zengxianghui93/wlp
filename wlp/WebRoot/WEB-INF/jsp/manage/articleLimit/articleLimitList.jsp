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
<title>原文次数限制_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script src="${context}/js/jquery.artDialog.source.js" type="text/javascript"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript">
	function updateRes(id,num1){
		var balTest = /^[0-9]+$/;
		if(num1==''){
			num1='0';
		}
		var num=prompt("修改后次数：",num1);
		if(num==null){
			return;
		}
		if(!balTest.test(num)){
			alert("请输入正确数字");
		}else{
			 //后台修改
			 $.post("${context}/manage/articleLimit/update.html", {id:id,num:num},
					 function(data) {
				 if(data=="error"){
					 alert("修改失败");
				 }else{
					 window.location.href =  "${context}/manage/articleLimit/list.html";
				 }
			 }, "text");
		};
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
		<div class="con" style="float: left;margin-left: 1%;margin-top: 5%">
        	<div class="HTc1">
        	原文限制管理：
			<table id="table1" style="text-align: center;margin-top: 10px;">
				<tbody style="width: 200px;">
					<tr class="cTitle">
						<td class="ct1">序号</td>
						<td class="ct1">说明</td>
						<td class="ct2">次数</td>
						<td class="ct2">修改</td>
					</tr>
				</tbody>
				<c:forEach var="item" items="${articleLimits}" varStatus="status">
					<tr>
						<td class="ct1" style="width:10%">${status.index+1}</td>
						<td class="ct1" style="width:15%">${item.articleDesc}</td>
						<td class="ct2" style="width:15%"><c:if test="${item.articleNum==''}">0</c:if>
							<c:if test="${item.articleNum!=''}">${item.articleNum}</c:if>
							</td>
						<td class="ct3" style="width:15%"><a href="#" onclick="updateRes('${item.id}','${item.articleNum}')">修改</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
    </div>
	</div>
	<!--con-->
	<!--YJ2016_HTmain-->
</body>
</html>