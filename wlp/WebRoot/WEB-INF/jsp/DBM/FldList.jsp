<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<title>数据加工_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<style type="text/css">
.leftmenu-zhao {
	border: 1px solid #ccc;
	height: 780px;
	width: 765px;
	overflow: scroll;
	overflow-x: hidden;
}
</style>
</head>
<body>
	<!-- 顶部样式引入 -->

	<!-- <div class="YJ2016_HTRote">
    	<a href="#">首页</a>&nbsp;&nbsp;&gt;&nbsp;&nbsp;<span>数据加工</span>
    </div> -->
	<div class="YJ2016_HTmain YJ2016_clearfix ">
		<!-- 左侧功能菜单引入 -->
		<%-- <jsp:include page="../manage/include/leftMenu.jsp"></jsp:include> --%>
		<div class="con leftmenu-zhao" style="overflow-y: hidden;">
			<div class="userbtn">
				<a href="${context}/DBM/addFldPage-${ResId}.html" class="useradd"
					style="width: 70px;">添加数据</a> <a href="javascript:history.go('-1')"
					class="userfresh ResBack"
					style="background: url(../images/hrefRight.png) no-repeat 7px center;">返回</a>
			</div>
			<%-- <div>
        	<span style="display: inline-block;text-align: left;width: 120px;height: 35px;text-align: center;line-height: 35px;background: #3575b5;margin-top: 20px;color: #fff;float:left;" >
        		<a href="${context}/DBM/addFldPage-${ResId}.html" style="color: #fff;">添加新字段</a>
        	</span>
        	<span style="display: inline-block;text-align: right;width: 120px;height: 35px;text-align: center;line-height: 35px;background: #3575b5;float:right;color: #fff;margin-top: 20px;" >	
        		<a href="javascript:history.go('-1')" class="backBtn" style="color: #fff;">返回</a>
        	</span>
        </div>  --%>
			<table border="1" style="margin-top: 20px; width: 99%">
				<tbody>
					<%-- <tr style="height:35px; border-radius:8px;">
			<td colspan="9"> <a href="${context}/DBM/addFldPage-${ResId}.html" class="addBtn">添加新字段</a>
			</td>
			<td colspan="2"><a href="javascript:history.go('-1')" class="backBtn">返回</a>
			</td>
		</tr> --%>
					<tr>
						<td style="width: 20%;">字段名称</td>
						<td style="width: 10%">中文名称</td>
						<td style="width: 8%">类型</td>
						<td style="width: 7%">长度</td>
						<td style="width: 10%">是否可检索</td>
						<td style="width: 7%">可为空</td>
						<td style="width: 10%">列表页显示</td>
						<td style="width: 10%">详细页显示</td>
						<td style="width: 8%">输入方式</td>
						<td style="width: 8%">操作</td>
					</tr>
					<c:forEach var="fld" items="${FldList}">
						<tr>
							<td>${fn:substring(fld.fldName, 0, 12)} <span><br></span>
								<c:if test="${fn:length(fld.fldName) > 12}">${fn:substring(fld.fldName, 12, fn:length(fld.fldName))}</c:if>
							</td>
							<td style="white-space: pre-wrap;">${fld.fldDesc}</td>
							<td>${fld.fldType}</td>
							<td>${fld.fldLength}</td>
							<td><c:if test="${fld.fldSearch==1}">
					是
				</c:if> <c:if test="${fld.fldSearch==0}">
					否
				</c:if></td>
							<td><c:if test="${fld.fldIsNull==1}">
					是
				</c:if> <c:if test="${fld.fldIsNull==0}">
					否
				</c:if></td>
							<td><c:if test="${fld.fldList==1}">
					是
				</c:if> <c:if test="${fld.fldList==0}">
					否
				</c:if></td>
							<td><c:if test="${fld.fldDetail==1}">
					是
				</c:if> <c:if test="${fld.fldDetail==0}">
					否
				</c:if></td>
							<td>${fld.fldInputType}</td>
							<td><a href="${context}/DBM/editFldPage-${fld.fldId}.html">修改</a>
								<span> | </span> <a
								href="${context}/DBM/delFldPage-${fld.fldId}.html">删除</a></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!--con-->
	</div>
	<!--YJ2016_HTmain-->
</body>
</html>