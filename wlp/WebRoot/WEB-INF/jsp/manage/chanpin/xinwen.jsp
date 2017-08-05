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
<title>商品管理_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript" src="${context}/js/WdatePicker.js"></script>
<script type="text/javascript" >
function checked(){
	var Startdate = document.getElementById("startdate");
	var enddate = document.getElementById("enddate");
	if(Startdate.value.trim()!=""&&enddate.value.trim()!=""&&(Startdate.value>enddate.value)){
		alert("注册开始日期不能大于结束日期");
		Startdate.value = "";
		enddate.value = "";
		return;
	}
	document.select.submit();
}
</script>
<script type="text/javascript">
$(function() {
	    //选择页数的跳转
		var options = '';
		for(var i=0;i<"${pagedNews.totalPageCount}"*1;i++){
			if((i+1) == "${pagedNews.currentPageNo}"){
				options += '<option selected="selected" value="${context}/Chanpins/fenyexinwen-${sname}-${weizhi}.html?pageNo='+(i+1)+'">'+(i+1)+'</option>';
			}else{
				options += '<option value="${context}/Chanpins/fenyexinwen-${sname}-${weizhi}.html?pageNo='+(i+1)+'">'+(i+1)+'</option>';
			}
		}
		$("#currentPageNoSelect").html(options);
	}); 
</script>
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
		<form name="select" action="${context}/Chanpins/fyxinwen.html" method="post" >
			<div class="search orderSearch">
				<div class="os_left" style="width: 340px">
					<p>
						<span style="width:110px">新闻名称：</span><input type="text" name="sname" class="osTxt1" value="${sname}"/>
					</p>
					<p>
						<span style="width:110px">开始时间：</span><input
							class="Wdate" type="text" name="startdate" id="startdate"
							onClick="WdatePicker()" value="${startdate}">
					</p>
				</div>
				<div class="os_right">
					<p>
						<span style="width:110px">新闻地点：</span>
						<input style="width:200px;margin:-3px;" type="text" name="weizhi" class="osTxt1" value="${weizhi}"/>
					</p>
					<p>
					<span style="width:110px">结束时间：</span><input
							class="Wdate" style="width:200px;" type="text" name="enddate" id="enddate"
							onClick="WdatePicker()" value="${enddate}">
					</p>
				</div>
				<div style="text-align: center;">
					<a href="javascript:void(0)" onclick="checked()" class="osBtn">搜索</a>
				</div>
			</div>
			</form>
			<div class="userbtn">
			     <a href="${context}/Chanpins/xwinsert.html" class="useradd"
					style="width: 70px;">添加新闻</a>
			</div>
			<table class="OrderTable">
				<tr class="cTitle">
					<td class="ct1">编号</td>
					<td class="ct2">新闻标题</td>
					<td class="ct2">录入时间</td>
					<td class="ct6">操作</td>
					<td class="ct6">删除</td>
				</tr>
				<c:forEach var="item" items="${pagedNews.result}" varStatus="status">
					<tr>
					    <td class="ct1">${(pagedNews.currentPageNo-1)*10+status.index+1}</td>
						<td class="ct2">${item.wf_newtitle}</td>
						<td class="ct2">${item.wf_newDate}</td>
						<td class="ct6"><a href="${context}/Chanpins/xwdetail-${item.f_id}.html">修改</a></td>
						<td class="ct6"><a href="${context}/Chanpins/xwupdate-${item.f_id}.html" onClick="return confirm('确实想删除吗？')">删除</a></td>
					</tr>
				</c:forEach>
			</table>
			<div class="notePage">
				<div class="page">
					共<span>${pagedNews.totalCount}</span>条记录&nbsp;&nbsp; <span>${pagedNews.currentPageNo}/${pagedNews.totalPageCount}</span>页

					<c:if test="${pagedNews.currentPageNo <=1}">首页</c:if>
					<c:if test="${pagedNews.currentPageNo >1 }">
						<a href="${context}/Chanpins/fenyexinwen-${sname}-${weizhi}.html?pageNo=1"
							style="margin-right: 5px;">首页</a>
					</c:if>

					<c:if test="${!pagedNews.hasPreviousPage}">上一页</c:if>
					<c:if test="${pagedNews.hasPreviousPage}">
						<a
							href="${context}/Chanpins/fenyexinwen-${sname}-${weizhi}.html?pageNo=${pagedNews.currentPageNo -1 }"
							style="margin-right: 5px;">上一页</a>
					</c:if>

					<c:if test="${!pagedNews.hasNextPage}">下一页</c:if>
					<c:if test="${pagedNews.hasNextPage}">
						<a
							href="${context}/Chanpins/fenyexinwen-${sname}-${weizhi}.html?pageNo=${pagedNews.currentPageNo +1 }"
							style="margin-right: 5px;">下一页</a>
					</c:if>

					<c:if test="${pagedNews.currentPageNo >= pagedNews.totalPageCount}">尾页</c:if>
					<c:if test="${pagedNews.currentPageNo < pagedNews.totalPageCount}">
						<a
							href="${context}/Chanpins/fenyexinwen-${sname}-${weizhi}.html?pageNo=${pagedNews.totalPageCount }"
							style="margin-right: 5px;">尾页</a>
					</c:if>
					 第
                    <select onchange="self.location.href= options[selectedIndex].value" id="currentPageNoSelect"></select>页              
				</div>
			</div>
		</div>
		<!--con-->
	</div>
	<!--YJ2016_HTmain-->
	<%-- <jsp:include page="../include/bottom.jsp"></jsp:include> --%>
</body>
</html>