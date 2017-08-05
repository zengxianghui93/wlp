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
<title>用户管理_冶金信息网后台</title>
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
	var Startdate = document.getElementById("Startdate");
	var enddate = document.getElementById("enddate");
	var phone = document.getElementById("phone");
	var phoneexp = /^[0-9]+$/;
	if(phone.value!=""&&!phoneexp.test(phone.value)){
		alert("电话需输入数字");
		phone.value="";
		return;
	}
	if(Startdate.value.trim()!=""&&enddate.value.trim()!=""&&(Startdate.value>enddate.value)){
		alert("注册开始日期不能大于结束日期");
		Startdate.value = "";
		enddate.value = "";
		return;
	}
	document.from1.submit()
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
				<form action="${context}/manage/userList1.html" method="get" name="from1">
				 <h2>
					<!-- <em></em><strong></strong> -->用户名：<input type="text" name="name" style="width: 500px"  value="${name}"/> <!-- <select
						style="width: 60px; text-align: center; padding-left: 10px;">
						<option>与</option>
						<option>或</option> 
					</select>-->
				</h2>
				<h2>
					电话：&nbsp;&nbsp; <input type="text" name="phone" id="phone" style="width: 500px"  value="${phone}"/>
				</h2>
				<h2>
					分组类型：<select style="width: 520px" name="group"><option value="">所有</option>
						<c:forEach items="${groups}" var="item" varStatus="status">
							<c:if test="${item.groupId==group}"><option value="${item.groupId}" selected="selected">${item.groupName}</option></c:if>
							<c:if test="${item.groupId!=group}"><option value="${item.groupId}">${item.groupName}</option></c:if>
						</c:forEach>
					</select>
				</h2>
				<div class="userDate">
				<h2>
						<span>注册日期：</span><input
							class="Wdate" type="text" name="Startdate" id="Startdate" style="width: 240px" value="${Startdate}"
							onClick="WdatePicker()"><b>~</b><input class="Wdate" style="width: 240px" id="enddate"
							name="enddate" type="text" onClick="WdatePicker()" value="${enddate}">
					</h2>
				</div>
				<h2>
					用户名：&nbsp;&nbsp;<select name="orderByUserName">
						<option value="" <c:if test="${orderByUserName==''}">selected="selected"</c:if>>无序</option>
						<option value="asc" <c:if test="${orderByUserName=='asc'}">selected="selected"</c:if>>升序</option>
						<option value="desc" <c:if test="${orderByUserName=='desc'}">selected="selected"</c:if>>降序</option></select>
					注册时间：<select name="orderByCreateTime">
						<option value="" <c:if test="${orderByCreateTime==''}">selected="selected"</c:if>>无序</option>
						<option value="asc" <c:if test="${orderByCreateTime=='asc'}">selected="selected"</c:if>>升序</option>
						<option value="desc" <c:if test="${orderByCreateTime=='desc'}">selected="selected"</c:if>>降序</option></select>
					授权结束时间：<select name="orderByAuthEndTime">
						<option value="" <c:if test="${orderByAuthEndTime==''}">selected="selected"</c:if>>无序</option>
						<option value="asc" <c:if test="${orderByAuthEndTime=='asc'}">selected="selected"</c:if>>升序</option>
						<option value="desc" <c:if test="${orderByAuthEndTime=='desc'}">selected="selected"</c:if>>降序</option></select>
				</h2>
				<div style="text-align: center;">
					<a href="javascript:void(0)" onclick="checked()" class="usBtn">搜索</a>
				</div> 
				</form>
			</div>
			<form action="${context}/manage/userList1.html" method="get" name="form2">
				<input type="hidden" name="pageNo" id="pageNo" value="${pagedNews.currentPageNo}">
				<input type="hidden" name="name" value="${name}"/>
				<input type="hidden" name="phone" value="${phone}"/>
				<input type="hidden" name="email" value="${email}"/>
				<input type="hidden" name="Startdate" value="${Startdate}"/>
				<input type="hidden" name="group" value="${group}"/>
				<input type="hidden" name="orderByUserName" value="${orderByUserName}"/>
				<input type="hidden" name="orderByCreateTime" value="${orderByCreateTime}"/>
				<input type="hidden" name="orderByAuthEndTime" value="${orderByAuthEndTime}"/>
				<input type="hidden" name="enddate" value="${enddate}"/>
			</form>
			<div class="userbtn">
				<a href="${context}/HTregister.jsp" class="useradd">添加</a> <a
					href="javascript:toList(${pagedNews.currentPageNo})" class="userfresh">刷新</a>
			</div>
			<table class="userTable" style="margin-top: 20px;">
				<tr class="cTitle">
					<td style="width: 15%;">用户名</td>
					<td style="width: 5%;">角色</td>
					<td style="width: 10%;">MI权限</td>
					<td style="width: 10%;">资源库权限</td>
					<td style="width: 10%;">分类的权限</td>
					<td style="width: 15%;">电话</td>
					<td style="width: 20%;">邮箱</td>
					<td style="width: 5%;">是否生效</td>
					<td style="width: 8%;">编辑</td>
					<td style="width: 8%;">删除</td>
				</tr>
				<c:forEach var="user" items="${pagedNews.result}">
					<tr>
						<td class="name1">${user.userName}</td>
						<td><a href="${context}/manage/authority/roleOfUser-${user.userId}.html" style="color:#3575b5;">编辑</a></td>
						<td><a href="${context}/manage/authority/setMI.html?userId=${user.userId}&pageNo=${pagedNews.currentPageNo}" style="color:#3575b5;">设置</a></td>
						<td><a href="${context}/manage/authority/toUserResource.html?userId=${user.userId}&pageNo=${pagedNews.currentPageNo}" style="color:#3575b5;">设置</a></td>
						<td style="width: 15%;"><a href="${context}/manage/authority/toOpOfCategory.html?userId=${user.userId}&&pageNo=${pagedNews.currentPageNo}" style="color:#3575b5;">设置</a></td>
						<td>${user.phone}</td>
						<td>${user.email}</td>
						<td>是</td>
						<td><a href="${context}/manage/editUser-${user.userId}.html" style="color:#3575b5;">编辑</a></td>
						<td><a href="${context }/manage/delUser-${user.userId}.html"
							onClick="return confirm('确实想删除吗？')" style="color:red;">删除</a></td>
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