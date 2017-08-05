<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	String context = request.getContextPath();
	request.setAttribute("context", context);
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>科技查新_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript" src="${context}/js/WdatePicker.js"></script>
</head>
<body>
	<!-- 引入头部 -->
	<%-- <jsp:include page="../include/top.jsp"></jsp:include> --%>
<%-- 	<div class="YJ2016_HTRote">
		<a href="${context}/DBM/resourceManage.html">首页</a>&nbsp;&nbsp;&gt;&nbsp;&nbsp;<span>订单管理</span>
	</div> --%>
	<div class="YJ2016_HTmain YJ2016_clearfix ">
		<!-- 左侧菜单引入 -->
		<%-- <jsp:include page="../include/leftMenu.jsp"></jsp:include> --%>
		<div class="con orderCon">
		<form name="select" action="${context}/manage/selectonlines.html" method="post" >
			<div class="search orderSearch">
				<div class="os_left">
					<p>
						<span>用户名：</span><input type="text" name="name" class="osTxt1" value="${kjcxname}" />
					</p>
				</div>
				<div class="os_right">
					<p>
						<span>查新状态：</span> <select name="zhuantai">
						        <c:if test="${zhangtai==0}"> 
								 <option selected="selected" value="0">请选择</option>
								</c:if>
								<c:if test="${zhangtai!=0}"> 
								 <option value="0">请选择</option>
								</c:if>
							    <c:forEach var="status" items="${status}" >
								<c:if test="${status.id==zhangtai}"> 
								 <option selected="selected" value="${status.id}">${status.wf_kjcxstatus}</option>
								</c:if>
								<c:if test="${status.id!=zhangtai}">
								 <option value="${status.id}">${status.wf_kjcxstatus}</option>
								</c:if>
							    </c:forEach>
						</select>
					</p>
				</div>
				<div style="text-align: center;">
					<a href="javascript:document:select.submit();" class="osBtn">搜索</a>
				</div>
			</div>
			</form>
			
			<table class="OrderTable">
				<tr class="cTitle">
					<td class="ct1">用户名</td>
					<td class="ct2">项目名称</td>
					<td class="ct3">机构名称</td>
					<td class="ct4">联系人</td>
					<td class="ct4">查新范围</td>
					<td class="ct5">服务状态</td>
					<td class="ct6">处理订单</td>
					<td class="ct6">删除订单</td>
				</tr>
				<c:forEach var="kjcx" items="${pagedNews.result}">
					<tr>
						<td class="ct1">${kjcx.username}</td>
						<td class="ct2">${kjcx.wf_projectname}</td>
						<td class="ct3">${kjcx.wf_institution}</td>
						<td class="ct4">${kjcx.wf_contact}</td>
						<td class="ct4">${kjcx.wf_searchscope}</td>
						<td class="ct5"><c:if test="${kjcx.wf_kjcxstatus ==1||kjcx.wf_kjcxstatus ==null}">提交</c:if>
							            <c:if test="${kjcx.wf_kjcxstatus ==2}">已接收</c:if> 
							            <c:if test="${kjcx.wf_kjcxstatus ==3}">退回修改</c:if>
							            <c:if test="${kjcx.wf_kjcxstatus ==4}">开始查新</c:if> 
							            <c:if test="${kjcx.wf_kjcxstatus ==5}">完成初稿</c:if>
							            <c:if test="${kjcx.wf_kjcxstatus ==6}">查新完成</c:if> 
							            <c:if test="${kjcx.wf_kjcxstatus ==7}">邮寄报告</c:if>
							            <c:if test="${kjcx.wf_kjcxstatus ==8}">结束</c:if> 
						</td>
						<td class="ct6"><a href="${context}/manage/onlinedetail-${kjcx.id}.html">修改</a></td>
						<td class="ct6"><a href="${context}/manage/onlinedelete-${kjcx.id}.html" onClick="return confirm('确实想删除吗？')">删除</a></td>
					</tr>
				</c:forEach>
			</table>

			<div class="notePage">
				<div class="page">
					共<span>${pagedNews.totalCount}</span>条记录&nbsp;&nbsp; <span>${pagedNews.currentPageNo}/${pagedNews.totalPageCount}</span>页

					<c:if test="${pagedNews.currentPageNo <=1}">首页</c:if>
					<c:if test="${pagedNews.currentPageNo >1 }">
						<a href="${context}/manage/selectonlineaa-${kjcxname}-${zhangtai}.html?pageNo=1"
							style="margin-right: 5px;">首页</a>
					</c:if>

					<c:if test="${!pagedNews.hasPreviousPage}">上一页</c:if>
					<c:if test="${pagedNews.hasPreviousPage}">
						<a
							href="${context}/manage/selectonlineaa-${kjcxname}-${zhangtai}.html?pageNo=${pagedNews.currentPageNo -1 }"
							style="margin-right: 5px;">上一页</a>
					</c:if>

					<c:if test="${!pagedNews.hasNextPage}">下一页</c:if>
					<c:if test="${pagedNews.hasNextPage}">
						<a
							href="${context}/manage/selectonlineaa-${kjcxname}-${zhangtai}.html?pageNo=${pagedNews.currentPageNo +1 }"
							style="margin-right: 5px;">下一页</a>
					</c:if>

					<c:if test="${pagedNews.currentPageNo >= pagedNews.totalPageCount}">尾页</c:if>
					<c:if test="${pagedNews.currentPageNo < pagedNews.totalPageCount}">
						<a
							href="${context}/manage/selectonlineaa-${kjcxname}-${zhangtai}.html?pageNo=${pagedNews.totalPageCount }"
							style="margin-right: 5px;">尾页</a>
					</c:if>
					第 <select
						onchange="self.location.href= options[selectedIndex].value">
						<option
							value="${context}/manage/selectonlineaa-${kjcxname}-${zhangtai}?pageNo=${pagedNews.currentPageNo}.html">${pagedNews.currentPageNo}</option>
						<c:if
							test="${pagedNews.currentPageNo+1 <= pagedNews.totalPageCount}">
							<option
								value="${context}/manage/selectonlineaa-${kjcxname}-${zhangtai}.html?pageNo=${pagedNews.currentPageNo+1}">${pagedNews.currentPageNo+1}</option>
						</c:if>
						<c:if
							test="${pagedNews.currentPageNo+2 <= pagedNews.totalPageCount}">
							<option
								value="${context}/manage/selectonlineaa-${kjcxname}-${zhangtai}.html?pageNo=${pagedNews.currentPageNo+2}">${pagedNews.currentPageNo+2}</option>
						</c:if>
						<c:if
							test="${pagedNews.currentPageNo+3 <= pagedNews.totalPageCount}">
							<option
								value="${context}/manage/selectonlineaa-${kjcxname}-${zhangtai}.html?pageNo=${pagedNews.currentPageNo+3}">${pagedNews.currentPageNo+3}</option>
						</c:if>
						<c:if
							test="${pagedNews.currentPageNo+4 <= pagedNews.totalPageCount}">
							<option
								value="${context}/manage/selectonlineaa-${kjcxname}-${zhangtai}.html?pageNo=${pagedNews.currentPageNo+4}">${pagedNews.currentPageNo+4}</option>
						</c:if>
					</select>页
				</div>
			</div>
		</div>
		<!--con-->
	</div>
	<!--YJ2016_HTmain-->
	<%-- <jsp:include page="../include/bottom.jsp"></jsp:include> --%>
</body>
</html>