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
<title>刊名维护_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript" src="${context}/js/WdatePicker.js"></script>
<script type="text/javascript">
$(function(){
	var option = "";
	for(var i=0;i<"${pagedNews.totalPageCount}"*1;i++){
		if("${pagedNews.currentPageNo}"*1==(i+1)){
			option += "<option value='"+(i+1)+"' selected='selected'>"+(i+1)+"</option>";
		}else{
			option += "<option value='"+(i+1)+"'>"+(i+1)+"</option>";
		}
	}
	$("#yeshu").html(option);
	
	//查询后用户名命中部分高亮显示
	var name = "${name}";
	$(".name1").each(function(){
		var name2 = $(this).html();
		var startP = name2.indexOf(name);
		var name3 = name2.substring(0,startP);
		name3 += "<span style='color:red'>"+name+"</span>"+name2.substring(startP+name.length,name2.length);
		$(this).html(name3)
		
	});
});


function toList(pageNo){
	document.getElementById("pageNo").value = pageNo;
	document.form2.submit();
}

function checked(){
	document.from1.submit()
}
function AUJournal(id){
	if(id=='0'){
		document.getElementById("id333").value = null;
	}else{
		document.getElementById("id333").value = id;
	}
	document.form3.submit();
}
function delJournal(id){
	if(!confirm('确实想删除吗？')){
		return;
	}
	document.getElementById("id444").value = id;
	document.form4.submit();
}
</script>
</head>
<body>
	<!-- 引入头部 -->
	<%-- <jsp:include page="../include/top.jsp"></jsp:include> --%>
	<%-- <div class="YJ2016_HTRote">
		<a href="${context}/DBM/resourceManage.html">首页</a>&nbsp;&nbsp;&gt;&nbsp;&nbsp;<span>资源管理</span>
	</div> --%>
	<div class="YJ2016_HTmain YJ2016_clearfix ">
		<!-- 左侧菜单引入 -->
		<%-- <jsp:include page="../include/leftMenu.jsp"></jsp:include> --%>
		<div class="con userCon" style="float: left;margin-left: 10px;">
			<div class="search userSearch" style="width:100%">
				<form action="${context}/manage/JournalMaintain/listJournalMaintain.html" method="get" name="from1">
				 <h2>
					<!-- <em></em><strong></strong> -->名称：<input type="text" name="name" style="width: 500px"  value="${name}"/> <!-- <select
						style="width: 60px; text-align: center; padding-left: 10px;">
						<option>与</option>
						<option>或</option> 
					</select>-->
				</h2>
				<h2>
					类型：&nbsp;<select style="width: 520px" name="type">
						<option value="" <c:if test="${type==''}">selected='selected'</c:if>>所有</option>
						<option value="1" <c:if test="${type=='1'}">selected='selected'</c:if>>外文期刊</option>
						<option value="2" <c:if test="${type=='2'}">selected='selected'</c:if>>外文会议</option>
					</select>
				</h2>
				<div style="text-align: center;">
					<a href="javascript:void(0)" onclick="checked()" class="usBtn">搜索</a>
				</div> 
				</form>
			</div>
			<form action="${context}/manage/JournalMaintain/listJournalMaintain.html" method="get" name="form2">
				<input type="hidden" name="pageNo" id="pageNo" value="${pagedNews.currentPageNo}">
				<input type="hidden" name="name" value="${name}"/>
				<input type="hidden" name="type" value="${type}"/>
			</form>
			<form action="${context}/manage/JournalMaintain/toAUJournalMaintain.html" method="get" name="form3">
				<input type="hidden" name="id" id="id333"/>
				<input type="hidden" name="pageNo" id="pageNo" value="${pagedNews.currentPageNo}">
				<input type="hidden" name="name" value="${name}"/>
				<input type="hidden" name="type" value="${type}"/>
			</form>
			<form action="${context}/manage/JournalMaintain/delJournalMaintain.html" method="get" name="form4">
				<input type="hidden" name="id" id="id444"/>
				<input type="hidden" name="pageNo" id="pageNo" value="${pagedNews.currentPageNo}">
				<input type="hidden" name="name" value="${name}"/>
				<input type="hidden" name="type" value="${type}"/>
			</form>
			<div class="userbtn">
				<a href="javascript:AUJournal('0')" class="useradd">添加</a> <a
					href="javascript:toList(${pagedNews.currentPageNo})" class="userfresh">刷新</a>
			</div>
			<table class="userTable" style="margin-top: 20px;">
				<tr class="cTitle">
					<td style="width: 10%;">序号</td>
					<td style="width: 15%;">库</td>
					<td style="width: 15%;">刊名</td>
					<td style="width: 10%;">编辑</td>
					<td style="width: 10%;">删除</td>
				</tr>
				<c:forEach var="item" items="${pagedNews.result}" varStatus="status">
					<tr>
						<td>${(pagedNews.currentPageNo-1)*10+status.count}</td>
						<td><c:if test="${item.type=='1'}">外文期刊</c:if>
							<c:if test="${item.type=='2'}">外文会议</c:if>
							<c:if test="${item.type!=null&&item.type!='1'&&item.type!='2'}">其他</c:if></td>
						<td  class="name1" title="${item.name}">${fn:substring(item.name, 0, 80)}..</td>
						<td><a href="javascript:AUJournal('${item.id}')" style="color:#3575b5;">编辑</a></td>
						<td><a href="javascript:delJournal('${item.id}')" style="color:red;">删除</a></td>
					</tr>
				</c:forEach>
			</table>
			<div class="notePage">
				<div class="page">
					共<span>${pagedNews.totalCount}</span>条记录&nbsp;&nbsp; <span>${pagedNews.currentPageNo}/${pagedNews.totalPageCount}</span>页

					<c:if test="${pagedNews.currentPageNo <=1}">首页</c:if>
					<c:if test="${pagedNews.currentPageNo >1 }">
						<a href="javascript:void(0)" onclick="toList(1)"
							style="margin-right: 5px;">首页</a>
					</c:if>

					<c:if test="${!pagedNews.hasPreviousPage}">上一页</c:if>
					<c:if test="${pagedNews.hasPreviousPage}">
						<a  href="javascript:void(0)" onclick="toList(${pagedNews.currentPageNo -1 })"
							style="margin-right: 5px">上一页</a>
					</c:if>

					<c:if test="${!pagedNews.hasNextPage}">下一页</c:if>
					<c:if test="${pagedNews.hasNextPage}">
						<a	href="javascript:void(0)" onclick="toList(${pagedNews.currentPageNo + 1 })"
							style="margin-right: 5px">下一页</a>
					</c:if>

					<c:if test="${pagedNews.currentPageNo >= pagedNews.totalPageCount}">尾页</c:if>
					<c:if test="${pagedNews.currentPageNo < pagedNews.totalPageCount}">
						<a	href="javascript:void(0)" onclick="toList(${pagedNews.totalPageCount })"
							style="margin-right: 5px">尾页</a>
					</c:if>

					第 <select
						onchange="toList(options[selectedIndex].value)" id="yeshu">
					</select>页
				</div>
			</div>


		</div>
		<!--con-->
	</div>
	<!--YJ2016_HTmain-->

	
</body>
</html>