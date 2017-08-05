<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% 
    String context = request.getContextPath();
    request.setAttribute("context",context);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看数据库的待审核数据</title>
<link type="text/css" rel="stylesheet" href="${context}/css/FldList.css" />
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>

</head>
<body>
	<!-- <div class="YJ2016_HTRote">
		<a href="#">首页</a>&nbsp;&nbsp;&gt;&nbsp;&nbsp;<span>数据加工</span>
	</div> -->
	<div class="YJ2016_HTmain YJ2016_clearfix ">
		<!-- 左侧功能菜单引入 -->
		<div class="con">
			<div style="margin-top: 20px; margin-bottom: 20px; float: right">
				<a href="javascript:history.go('-1')" class="ResBack"
					style="display: inline-block; width: 120px; height: 35px; text-align: center; line-height: 35px; margin-right: 10px; color: #fff; background: #5cb819;">返回</a>
				<%-- <c:if test="${resInfo.resFlow==1}"><td><a href="${context}/DBM/auditPageData-${ResId}.html" class="ResAdd">待审核数据</a></td></c:if> --%>
			</div>
			<div class="leftmenu-zhao"
				style="width: 100%; margin-top: 70px; overflow: auto;">
				<table border="1">
					<tr class="tit">
						<td style="background: #3575b5; color: #fff">序号</td>
						<c:forEach var="fld" items="${lstFld}">
							<c:if test="${fld.getFldList()==1}">
								<td style="background: #3575b5; color: #fff">${fld.getFldDesc()}</td>
							</c:if>
						</c:forEach>
						<td style="background: #3575b5; color: #fff">操作</td>
					</tr>
					<c:forEach var="datamap" items="${dataList}">
						<tr>
							<td>${datamap.get("id")}</td>
							<c:forEach var="fld" items="${lstFld}">
								<c:if test="${fld.getFldList()==1}">
									<td>${datamap.get(fld.getFldName())}</td>
								</c:if>
							</c:forEach>
							<td><a
								href="${context}/DBM/EditData-${ResId}-${datamap.get("id")}.html">审核</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="Page">
				${page.get("resName")} 待审核数据 共${page.get("totalRows")}条数据 <a
					href="${context}/DBM/PageData-${ResId}.html?currentPage=1&numPerPage=10">首页</a>
				<a
					href="${context}/DBM/PageData-${ResId}.html?currentPage=${page.get("
					nextPage")}&numPerPage=10">下一页</a> <a
					href="${context}/DBM/PageData-${ResId}.html?currentPage=${page.get("
					prePage")}&numPerPage=10">上一页</a> <a
					href="${context}/DBM/PageData-${ResId}.html?currentPage=${page.get("
					totalPage")}&numPerPage=10">末页</a>
			</div>
		</div>
	</div>
</body>
</html>