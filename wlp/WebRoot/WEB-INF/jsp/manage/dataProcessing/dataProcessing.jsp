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
<title>数据加工_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
</head>
<body>
    <!-- 引入头部 -->
    <%-- <jsp:include page="../include/top.jsp"></jsp:include> --%>
    <!-- <div class="YJ2016_HTRote">
    	<a href="#">首页</a>&nbsp;&nbsp;&gt;&nbsp;&nbsp;<span>数据加工</span>
    </div> -->
    <div class="YJ2016_HTmain YJ2016_clearfix ">
    	<!-- 左侧菜单引入 -->
    	<%-- <jsp:include page="../include/leftMenu.jsp"></jsp:include> --%>
        <div class="con">
        	<div class="search">
            	<h1><select>
                	<option>资源库名称</option>
                    <option>资源库名称1</option>
                    <option>资源库名称2</option>
                </select>
                <input type="text" />
                <a href="#">检索</a></h1>
            </div>
            <table class="dataTable">
            	<tr class="cTitle">
                	<td class="ct1">资源名称</td>
                    <td class="ct2">采编发流程</td>
                    <td class="ct3">新建</td>
                    <td class="ct4">编辑</td>
                    <td class="ct5">审核</td>
                    <!-- <td class="ct6">签发</td> -->
                    <!-- <td class="ct7">再编辑</td> -->
                    <td class="ct8">权限设置</td>
                </tr>
                <c:forEach var="res" items="${pagedNews.result}">
	                <tr>
	                	<td class="ct1">${res.resName}</td>
	                    <td class="ct2"><a href="#">编辑</a>&nbsp;&nbsp;<span>&#124;</span>&nbsp;&nbsp;<a href="#">审核</a></td>
	                    <td class="ct3"><a href="#">添加</a>&nbsp;&nbsp;<span>&#124;</span>&nbsp;&nbsp;<a href="#">批量导入</a></td>
	                    <td class="ct4">编辑</td>
	                    <td class="ct5">已审核</td>
	                    <!-- <td class="ct6">已签发</td> -->
	                    <!-- <td class="ct7"><a href="#">再次编辑</a></td> -->
	                    <td class="ct8">设置</td>
	                </tr>
                </c:forEach>
            </table>
            <div class="notePage">
				<div class="page">
					共<span>${pagedNews.totalCount}</span>条记录&nbsp;&nbsp; <span>${pagedNews.currentPageNo}/${pagedNews.totalPageCount}</span>页

					<c:if test="${pagedNews.currentPageNo <=1}">首页</c:if>
					<c:if test="${pagedNews.currentPageNo >1 }">
						<a href="${context}/DBM/resourceManage.html?pageNo=1"
							style="margin-right: 5px;">首页</a>
					</c:if>

					<c:if test="${!pagedNews.hasPreviousPage}">上一页</c:if>
					<c:if test="${pagedNews.hasPreviousPage}">
						<a href="${context}/DBM/resourceManage.html?pageNo=${pagedNews.currentPageNo -1 }"
							style="margin-right: 5px;">上一页</a>
					</c:if>

					<c:if test="${!pagedNews.hasNextPage}">下一页</c:if>
					<c:if test="${pagedNews.hasNextPage}">
						<a href="${context}/DBM/resourceManage.html?pageNo=${pagedNews.currentPageNo +1 }"
							style="margin-right: 5px;">下一页</a>
					</c:if>

					<c:if
						test="${pagedNews.currentPageNo >= pagedNews.totalPageCount}">尾页</c:if>
					<c:if test="${pagedNews.currentPageNo < pagedNews.totalPageCount}">
						<a href="${context}/DBM/resourceManage.html?pageNo=${pagedNews.totalPageCount }"
							style="margin-right: 5px;">尾页</a>
					</c:if>
				</div>
			</div>
        </div><!--con-->
    </div><!--YJ2016_HTmain-->
</body>
</html>