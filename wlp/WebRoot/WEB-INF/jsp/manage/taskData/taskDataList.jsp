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
<title>数据任务_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript" src="${context}/js/WdatePicker.js"></script>
<script type="text/javascript">
	 $(function() {
		$("#table1").children("tbody").eq(1).children("tr").each(function(index) {

			//修改任务类型
			<c:forEach items="${taskTypes}" var="item" varStatus="status">
				if ($(this).children("td").eq(1).text() == "${item.typeId}") {
					$(this).children("td").eq(1).text("${item.typeName}");
				}
			</c:forEach>

			//修改访问资源
			var tableName = $(this).children("td").eq(4).text();//定义资源库
			<c:forEach items="${resAll}" var="item" varStatus="status">
				if (tableName == "${item.resTblName}") {
						tableName = "${item.resName}";
				}
			</c:forEach>
			$(this).children("td").eq(4).html(tableName);
			
			//修改完成度
			var tableName = "";//定义资源库
			<c:forEach items="${completionList}" var="item" varStatus="status">
				if (index == "${status.index}") {
					$(this).children("td").eq(8).html("${item}"+"%"); 
					return;
				}
			</c:forEach>
		});
		
		//选择页数的跳转
		var options = '';
		for(var i=0;i<"${pageTaskData.totalPageCount}"*1;i++){
			if((i+1) == "${pageTaskData.currentPageNo}"){
				options += '<option selected="selected" value="javascript:mySubmit('+(i+1)+')">'+(i+1)+'</option>';
			}else{
				options += '<option value="javascript:mySubmit('+(i+1)+')">'+(i+1)+'</option>';
			}
		}
		$("#currentPageNoSelect").html(options);
	});
	function mySubmit(pageNo){
		document.getElementById("pageNo").value = pageNo;
		document.select.submit();
	}
	
	function downloadLog(){
		$("#downLoadForm").submit();
	}
	 
</script>
</head>
<body>
	<!-- 引入头部 -->
	<%-- <div class="YJ2016_HTRote">
		<a href="${context}/DBM/resourceManage.html">首页</a>&nbsp;&nbsp;&gt;&nbsp;&nbsp;<span>日志管理</span>
	</div> --%>
	<div class="YJ2016_HTmain YJ2016_clearfix ">
		<!-- 左侧菜单引入 -->
		<div class="con" style="float: left;margin-left: 10px;">
				<form name="select" action="${context}/manage/taskData/taskDataList.html" method="post">
					<input type="hidden" value="" name="pageNo" id="pageNo"/>
					<div class="search orderSearch">
						<div class="userDate">
							<span style="margin-right: 25px;width:45%;margin-left: 20px;">
								<span>任务类型：</span>
								<select name="taskType" style="width:220px">
									<option value="">所有类型</option>
									<c:forEach items="${taskTypes}" var="item" varStatus="status">
										<c:if test="${item.typeId == taskData.taskType}"><option value="${item.typeId}" selected="selected">${item.typeName}</option></c:if>
										<c:if test="${item.typeId != taskData.taskType}"><option value="${item.typeId}">${item.typeName}</option></c:if>
									</c:forEach> 
								</select>
							</span>
							<span style="margin-right: 25px;width:45%;">
								<span>任务名：</span>
								<input style="width:200px;" type="text" name="taskName" value="${taskData.taskName}" style="width:220px">
							</span>
							<span style="margin-right: 25px;width:45%;margin-left: 20px;margin-top: 10px;">
								<span>资源库：</span>
								<select name="taskTableName" style="width:220px">
									<option value="">所有</option>
									<c:forEach items="${resAll}" var="item" varStatus="status">
										<c:if test="${item.resTblName == taskData.taskTableName}"><option value="${item.resTblName}" selected="selected">${item.resName}</option></c:if>
										<c:if test="${item.resTblName != taskData.taskTableName}"><option value="${item.resTblName}">${item.resName}</option></c:if>
									</c:forEach> 
								</select>
							</span>
							<span style="margin-right: 25px;width:45%;">
								<span>用户名：</span>
								<input style="width:200px;" type="text" name="taskUserName" value="${taskData.taskUserName}" style="width:220px">
							</span>
							<span style="margin-right: 25px;width:45%;margin-left: 20px;margin-top: 10px;">
								<span>开始日期：</span>
								<input style="width:200px;margin-left: 1px;"value = '<fmt:formatDate  value="${taskData.handBeginTime}" pattern="yyyy-MM-dd"/>' class="Wdate" type="text" name="handBeginTime1" onClick="WdatePicker()">
							</span>
							<span style="margin-right: 25px;width:45%;">
								<span>结束日期：</span>
								<input style="width:200px;" class="Wdate" value="<fmt:formatDate  value="${taskData.handEndTime}" pattern="yyyy-MM-dd"/>" type="text" name="handEndTime1" onClick="WdatePicker()">
							</span>
							<!-- <span style="margin-right: 25px;width:45%;margin-left: 20px; margin-top: 20px">
								<span>日期区间：</span>
								<input style="width:100px;" class="Wdate" type="text" name="Startdate" onClick="WdatePicker()">
								<b>~</b>
								<input class="Wdate" style="width:100px;" name="enddate" type="text" onClick="WdatePicker()">
							</span> -->
						</div></form>
						<div style="text-align: left;margin-top: 10px;margin-bottom: 10px;width:60%;float: right;">
							<a href="javascript:void(0)" class="usBtn" onclick="mySubmit(1)" style="text-align: center">搜索</a>
						</div>
				</div>
				 <div class="userbtn">
	            	<a href = "${context}/manage/taskData/taskDataListAdd.html" type="button" class="addBtn1" style="width: 100px" onclick="downLoad()">添加任务</a>
				</div>
			<table id="table1" style="text-align: center;margin-top: 10px;">
				<tbody>
					<tr class="cTitle">
						<td width="3%">序号</td>
						<td width="5%">任务类型</td>
						<td width="6%">任务名称</td>
						<td width="8%">任务描述</td>
						<td width="8%">资源库</td>
						<td width="10%">处理人</td>
						<td width="6%">文章范围(id)</td>
						<td width="10%">处理时间区间</td>
						<td width="10%">完成度</td>
						<td width="10%">操作</td>
					</tr>
				</tbody>
				<c:forEach var="item" items="${pageTaskData.result}" varStatus="status">
					<tr>
						<td >${(pageTaskData.currentPageNo-1)*10+status.index+1}</td>
						<td  style="width: 130px; white-space: pre-wrap;">${item.taskType}</td>
						<td >${item.taskName}</td>
						<td title="${item.taskDesc}">
							<c:if test = "${item.taskDesc.length() <= 10}">${item.taskDesc}</c:if>
							<c:if test = "${item.taskDesc.length() > 10}">${fn:substring(item.taskDesc, 0, 6)}..</c:if>
						</td>
						<td >${item.taskTableName}</td>
						<td >${item.taskUserName}</td>
						<c:if test="${item.taskWay=='1'||item.taskWay==null}"><td >${item.resBegin}&nbsp;至&nbsp;${item.resEnd}</td></c:if>
						<c:if test="${item.taskWay=='2'}"><td >${item.taskResNums}篇</td></c:if>
						<td ><fmt:formatDate value="${item.handBeginTime}" type="date" dateStyle="default"/>&nbsp;至&nbsp;<fmt:formatDate value="${item.handEndTime}" type="date" dateStyle="default"/></td>
						<%-- <td title="${item.logResTitle}">
							<c:if test = "${item.logResTitle.length() <= 6}">${item.logResTitle}</c:if>
							<c:if test = "${item.logResTitle.length() > 6}">${fn:substring(item.logResTitle, 0, 6)}..</c:if>
						</td> --%>
						<td></td>
						<td><a href="${context}/manage/taskData/toUpdateTaskData.html?id=${item.id}">修改</a>&nbsp;|&nbsp;<a href="${context}/manage/taskData/delTaskData.html?id=${item.id}" onclick="return confirm('是否删除此任务？')">删除</a></td>
					</tr>
				</c:forEach>
			</table>
			<div class="notePage">
				<div class="page">
					共<span>${pageTaskData.totalCount}</span>条记录&nbsp;&nbsp; <span>${pageTaskData.currentPageNo}/${pageTaskData.totalPageCount}</span>页

					<c:if test="${pageTaskData.currentPageNo <=1}">首页</c:if>
					<c:if test="${pageTaskData.currentPageNo >1 }">
						<a href="javascript:void(0)" onclick="mySubmit(1)" style="margin-right: 5px;">首页</a>
					</c:if>

					<c:if test="${!pageTaskData.hasPreviousPage}">上一页</c:if>
					<c:if test="${pageTaskData.hasPreviousPage}">
						<a	href="javascript:void(0)" onclick="mySubmit(${pageTaskData.currentPageNo -1 })"
							style="margin-right: 5px;">上一页</a>
					</c:if>

					<c:if test="${!pageTaskData.hasNextPage}">下一页</c:if>
					<c:if test="${pageTaskData.hasNextPage}">
						<a	href="javascript:void(0)" onclick="mySubmit(${pageTaskData.currentPageNo +1 })"
							style="margin-right: 5px;">下一页</a>
					</c:if>

					<c:if test="${pageTaskData.currentPageNo >= pageTaskData.totalPageCount}">尾页</c:if>
					<c:if test="${pageTaskData.currentPageNo < pageTaskData.totalPageCount}">
						<a	href="javascript:void(0)" onclick="mySubmit(${pageTaskData.totalPageCount })"
							style="margin-right: 5px;">尾页</a>
					</c:if>

					第 <select id="currentPageNoSelect"
						onchange="self.location.href= options[selectedIndex].value">
					</select>页
				</div>
			</div>
		</div>
	</div>
	<!--con-->
	<!--YJ2016_HTmain-->
</body>
</html>