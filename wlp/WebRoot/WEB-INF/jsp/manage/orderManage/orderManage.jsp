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
<title>订单管理_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript" src="${context}/js/WdatePicker.js"></script>
<script type="text/javascript" >
function checked(){
	var Startdate = document.getElementById("startdate");
	var enddate = document.getElementById("enddate");
	var phone = document.getElementById("bianhao");
	var phoneexp = /^[0-9]+$/;
	if(phone.value!=""&&!phoneexp.test(phone.value)){
		alert("编号需输入数字");
		phone.value="";
		return;
	}
	if(Startdate.value.trim()!=""&&enddate.value.trim()!=""&&(Startdate.value>enddate.value)){
		alert("注册开始日期不能大于结束日期");
		Startdate.value = "";
		enddate.value = "";
		return;
	}
	document.select.submit();
}
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
		<form name="select" action="${context}/manage/selectorder.html" method="post" >
			<div class="search orderSearch">
				<div class="os_left" style="width: 340px">
					<p>
						<span style="width:110px">订单编号：</span><input type="text" id="bianhao" name="bianhao" class="osTxt1" value="${bianhao}"/>
					</p>
					<p>
						<span style="width:110px">用户名：</span><input type="text" name="name" class="osTxt1" value="${dingdan}"/>
					</p>
					<p>
						<span style="width:110px">开始时间：</span><input
							class="Wdate" type="text" name="startdate" id="startdate"
							onClick="WdatePicker()" value="${startdate}">
					</p>
				</div>
				<div class="os_right">
					<p>
						<span style="width:110px">订单状态：</span> <select name="zhuangtai">
							    <c:forEach var="status" items="${orderstatus}" >
								 <c:if test="${status.wf_orderstatus==zhuangtai}"> 
								 <option selected="selected" value="${status.wf_orderstatus}">${status.wf_orderstatustype}</option>
								 </c:if>
								  <c:if test="${status.wf_orderstatus!=zhuangtai}"> 
								  <option value="${status.wf_orderstatus}">${status.wf_orderstatustype}</option>
								  </c:if>
							    </c:forEach>
						</select>
					</p>
					<p>
						<span style="width:110px">地址：</span><input style="width: 200px;margin: 0;" type="text" name="address" value="${address}"/>
					</p>
					<p>
					<span style="width:110px">结束时间：</span><input
							class="Wdate" style="width: 200px;margin: 0;" type="text" name="enddate" id="enddate"
							onClick="WdatePicker()" value="${enddate}">
					</p>
				</div>
				<div style="text-align: center;">
					<a href="javascript:void(0)" onclick="checked()" class="osBtn">搜索</a>
				</div>
			</div>
			</form>
			
			<table class="OrderTable">
				<tr class="cTitle">
					<td class="ct1">用户名</td>
					<td class="ct2">订单号</td>
					<td class="ct2">订单时间</td>
					<!-- <td class="ct3">商品简介</td> -->
					<td class="ct3">订单地址</td>
					<td class="ct4">费用(元)</td>
					<td class="ct5">服务状态</td>
					<td class="ct6">处理订单</td>
					<!-- <td class="ct6">删除订单</td> -->
				</tr>
				<c:forEach var="ddan" items="${pagedNews.result}">
					<tr>
						<td class="ct1">${ddan.user}</td>
						<td class="ct2">${ddan.wf_ordernumber}</td>
						<td class="ct2">${ddan.wf_ideaDate}</td>
						<%-- <td class="ct3"><c:forEach var="shangpin"
								items="${ddan.order_Deil}">
                      ${shangpin.e_fid.wf_title}
                    </c:forEach></td> --%>
                    <td class="ct3">${ddan.wf_orderAddress}</td>
						<td class="ct4">${ddan.money}</td>
						<td>
						                 <c:if test="${ddan.wf_orderstatus ==1||ddan.wf_orderstatus ==2}">未处理</c:if>
							             <c:if test="${ddan.wf_orderstatus ==3}">正在处理</c:if> 
							             <c:if test="${ddan.wf_orderstatus ==4}">已处理</c:if>
						</td>
						<td class="ct6"><a href="${context}/manage/orderdetail-${ddan.f_id}.html">修改</a></td>
						<%-- <td class="ct6"><a href="${context}/manage/orderdelete-${ddan.f_id}.html" onClick="return confirm('确实想删除吗？')">删除</a></td> --%>
					</tr>
				</c:forEach>
			</table>
			<div class="notePage">
				<div class="page">
					共<span>${pagedNews.totalCount}</span>条记录&nbsp;&nbsp; <span>${pagedNews.currentPageNo}/${pagedNews.totalPageCount}</span>页

					<c:if test="${pagedNews.currentPageNo <=1}">首页</c:if>
					<c:if test="${pagedNews.currentPageNo >1 }">
						<a href="${context}/manage/selectorders-${dingdan}-${address}-${bianhao}-${zhuangtai}-${startdate}-${enddate}.html?pageNo=1"
							style="margin-right: 5px;">首页</a>
					</c:if>

					<c:if test="${!pagedNews.hasPreviousPage}">上一页</c:if>
					<c:if test="${pagedNews.hasPreviousPage}">
						<a
							href="${context}/manage/selectorders-${dingdan}-${address}-${bianhao}-${zhuangtai}-${startdate}-${enddate}.html?pageNo=${pagedNews.currentPageNo -1 }"
							style="margin-right: 5px;">上一页</a>
					</c:if>

					<c:if test="${!pagedNews.hasNextPage}">下一页</c:if>
					<c:if test="${pagedNews.hasNextPage}">
						<a
							href="${context}/manage/selectorders-${dingdan}-${address}-${bianhao}-${zhuangtai}-${startdate}-${enddate}.html?pageNo=${pagedNews.currentPageNo +1 }"
							style="margin-right: 5px;">下一页</a>
					</c:if>

					<c:if test="${pagedNews.currentPageNo >= pagedNews.totalPageCount}">尾页</c:if>
					<c:if test="${pagedNews.currentPageNo < pagedNews.totalPageCount}">
						<a
							href="${context}/manage/selectorders-${dingdan}-${address}-${bianhao}-${zhuangtai}-${startdate}-${enddate}.html?pageNo=${pagedNews.totalPageCount }"
							style="margin-right: 5px;">尾页</a>
					</c:if>
					第 <select
						onchange="self.location.href= options[selectedIndex].value">
						<option
							value="${context}/manage/selectorders-${dingdan}-${address}-${bianhao}-${zhuangtai}-${startdate}-${enddate}?pageNo=${pagedNews.currentPageNo}.html">${pagedNews.currentPageNo}</option>
						<c:if
							test="${pagedNews.currentPageNo+1 <= pagedNews.totalPageCount}">
							<option
								value="${context}/manage/selectorders-${dingdan}-${address}-${bianhao}-${zhuangtai}-${startdate}-${enddate}.html?pageNo=${pagedNews.currentPageNo+1}">${pagedNews.currentPageNo+1}</option>
						</c:if>
						<c:if
							test="${pagedNews.currentPageNo+2 <= pagedNews.totalPageCount}">
							<option
								value="${context}/manage/selectorders-${dingdan}-${address}-${bianhao}-${zhuangtai}-${startdate}-${enddate}.html?pageNo=${pagedNews.currentPageNo+2}">${pagedNews.currentPageNo+2}</option>
						</c:if>
						<c:if
							test="${pagedNews.currentPageNo+3 <= pagedNews.totalPageCount}">
							<option
								value="${context}/manage/selectorders-${dingdan}-${address}-${bianhao}-${zhuangtai}-${startdate}-${enddate}.html?pageNo=${pagedNews.currentPageNo+3}">${pagedNews.currentPageNo+3}</option>
						</c:if>
						<c:if
							test="${pagedNews.currentPageNo+4 <= pagedNews.totalPageCount}">
							<option
								value="${context}/manage/selectorders-${dingdan}-${address}-${bianhao}-${zhuangtai}-${startdate}-${enddate}.html?pageNo=${pagedNews.currentPageNo+4}">${pagedNews.currentPageNo+4}</option>
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