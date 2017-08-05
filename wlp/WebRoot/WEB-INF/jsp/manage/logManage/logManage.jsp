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
<title>日志管理_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript" src="${context}/js/WdatePicker.js"></script>
<script type="text/javascript">
	$(function() {
		$("#table1").children("tbody").eq(1).children("tr").each(function() {

			//修改日志类型
			<c:forEach items="${logTypes}" var="item" varStatus="status">
			if ($(this).children("td").eq(1).text() == "${item.typeId}") {
				$(this).children("td").eq(1).text("${item.name}");
			}
			</c:forEach>

			//修改访问资源
			var tableName = "";//定义资源库
			var strs = new Array(); //定义一数组 
			strs = $(this).children("td").eq(7).text().split(","); //字符分割 
			for (i = 0; i < strs.length; i++) {
				<c:forEach items="${resAll}" var="item" varStatus="status">
					if (strs[i] == "${item.resTblName}") {
						if (tableName != "") {
							tableName += ",<br>${item.resName}"
						} else {
							tableName += "${item.resName}"
						}
					}
				</c:forEach>
			}
			if(tableName != ""){
				$(this).children("td").eq(7).html(tableName);
			}else{
				var res = $(this).children("td").eq(7).text();
				
				for(var i=0;i<res.length;i=i+7){
					if((i+6)>=res.length){
						tableName += res.substring(i,res.length); 
					}else{
						tableName += res.substring(i,i+7)+"<br>"; 
					}
				}
				$(this).children("td").eq(7).html(tableName);
			}
			
			var input = $(this).children("td").eq(5).text();
			var input1 = "";
			for(var i=0;i<input.length;i=i+12){
				if((i+12)>=input.length){
					input1 += input.substring(i,input.length); 
				}else{
					input1 += input.substring(i,i+12)+"<br>"; 
				}
			}
			$(this).children("td").eq(5).html(input1);
			
			
		});
		
		//选择页数的跳转
		var options = '';
		for(var i=0;i<"${pagedLogs.totalPageCount}"*1;i++){
			if((i+1) == "${pagedLogs.currentPageNo}"){
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
				<form name="select" action="${context}/manage/logAllInfo/toLogManage.html" method="post">
					<input type="hidden" value="" name="pageNo" id="pageNo"/>
					<div class="search orderSearch">
						<div class="userDate">
							<span style="margin-right: 25px;width:45%;margin-left: 20px;">
								<span>用户行为：</span>
								<select name="logType" style="width:220px">
									<option value="">所有行为</option>
									<c:forEach items="${logTypes}" var="item" varStatus="status">
										<c:if test="${item.typeId == logType}"><option value="${item.typeId}" selected="selected">${item.name}</option></c:if>
										<c:if test="${item.typeId != logType}"><option value="${item.typeId}">${item.name}</option></c:if>
									</c:forEach>
								</select>
							</span>
							<span style="margin-right: 25px;width:45%;">
								<span>用户名：</span>
								<input style="width:200px;" type="text" name="userName" value="${userName}" style="width:220px">
							</span>
							<span style="margin-right: 25px;width:45%;margin-left: 20px;margin-top: 10px;">
								<span>开始日期：</span>
								<input style="width:200px;margin-left: 1px;" value="${startTime}" class="Wdate" type="text" name="startTime" onClick="WdatePicker()">
							</span>
							<span style="margin-right: 25px;width:45%;">
								<span>结束日期：</span>
								<input style="width:200px;" class="Wdate" value="${endTime}" type="text" name="endTime" onClick="WdatePicker()">
							</span>
							<!-- <span style="margin-right: 25px;width:45%;margin-left: 20px; margin-top: 20px">
								<span>日期区间：</span>
								<input style="width:100px;" class="Wdate" type="text" name="Startdate" onClick="WdatePicker()">
								<b>~</b>
								<input class="Wdate" style="width:100px;" name="enddate" type="text" onClick="WdatePicker()">
							</span> -->
						</div></form>
						<form name="downLoadForm" id="downLoadForm" action="${context}/manage/logAllInfo/downloadLogManage.html" method="post">
				<input type="hidden" name="logType" value = "${logType}"/>
				<input type="hidden" name="userName" value = "${userName}"/>
				<input type="hidden" name="startTime" value = "${startTime}"/>
				<input type="hidden" name="endTime" value = "${endTime}"/>
				<div style="margin-left: 25px;margin-top: 10px;width:20%;float: left;">
					<button style="text-align: center" type="submit">下载日志报告</button>
				</div>
			</form>
						<div style="text-align: left;margin-top: 10px;margin-bottom: 10px;width:60%;float: right;">
							<a href="javascript:void(0)" class="usBtn" onclick="mySubmit(1)" style="text-align: center">搜索</a>
						</div>
				</div>
			
			
			<table id="table1" style="text-align: center;margin-top: 10px;">
				<tbody>
					<tr class="cTitle">
						<td width="3%">序号</td>
						<td width="5%">用户行为</td>
						<td width="6%">用户名</td>
						<td width="8%">用户ip地址</td>
						<td width="8%">时间</td>
						<td width="10%">检索内容</td>
						<td width="6%">检索数量</td>
						<td width="10%">访问资源</td>
						<td width="10%">文章标题</td>
					</tr>
				</tbody>
				<c:forEach var="log" items="${pagedLogs.result}" varStatus="status">
					<tr>
						<td >${(pagedLogs.currentPageNo-1)*10+status.index+1}</td>
						<td  style="width: 130px; white-space: pre-wrap;">${log.logType}</td>
						<td >${log.userName}</td>
						<td >${log.userIp}</td>
						<td >
							<c:if test = "${not empty log.logTime}">
								${fn:substring(log.logTime, 0, 16)}
							</c:if>
						</td>
						<td >${log.input}
							
						</td>
						<td >${log.output}</td>
						<td >${log.logRes}</td>
						<td title="${log.logResTitle}">
							<c:if test = "${log.logResTitle.length() <= 6}">${log.logResTitle}</c:if>
							<c:if test = "${log.logResTitle.length() > 6}">${fn:substring(log.logResTitle, 0, 6)}..</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div class="notePage">
				<div class="page">
					共<span>${pagedLogs.totalCount}</span>条记录&nbsp;&nbsp; <span>${pagedLogs.currentPageNo}/${pagedLogs.totalPageCount}</span>页

					<c:if test="${pagedLogs.currentPageNo <=1}">首页</c:if>
					<c:if test="${pagedLogs.currentPageNo >1 }">
						<a href="javascript:void(0)" onclick="mySubmit(1)" style="margin-right: 5px;">首页</a>
					</c:if>

					<c:if test="${!pagedLogs.hasPreviousPage}">上一页</c:if>
					<c:if test="${pagedLogs.hasPreviousPage}">
						<a	href="javascript:void(0)" onclick="mySubmit(${pagedLogs.currentPageNo -1 })"
							style="margin-right: 5px;">上一页</a>
					</c:if>

					<c:if test="${!pagedLogs.hasNextPage}">下一页</c:if>
					<c:if test="${pagedLogs.hasNextPage}">
						<a	href="javascript:void(0)" onclick="mySubmit(${pagedLogs.currentPageNo +1 })"
							style="margin-right: 5px;">下一页</a>
					</c:if>

					<c:if test="${pagedLogs.currentPageNo >= pagedLogs.totalPageCount}">尾页</c:if>
					<c:if test="${pagedLogs.currentPageNo < pagedLogs.totalPageCount}">
						<a	href="javascript:void(0)" onclick="mySubmit(${pagedLogs.totalPageCount })"
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