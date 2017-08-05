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
<title>资源库价格管理_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script src="${context}/js/jquery.artDialog.source.js" type="text/javascript"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript">
	 $(function() {
		//选择页数的跳转
		var options = '';
		for(var i=0;i<"${pagesList.totalPageCount}"*1;i++){
			if((i+1) == "${pagesList.currentPageNo}"){
				options += '<option selected="selected" value="${context}/manage/ArticleTrans/toResBalanceList.html?pageNo='+(i+1)+'">'+(i+1)+'</option>';
			}else{
				options += '<option value="${context}/manage/ArticleTrans/toResBalanceList.html?pageNo='+(i+1)+'">'+(i+1)+'</option>';
			}
		}
		$("#currentPageNoSelect").html(options);
	}); 
	function getList(pageNo){
		window.location.href =  "${context}/manage/ArticleTrans/toResBalanceList.html?pageNo="+pageNo;
	}
	function updateRes(resId,resBalance){
		var balTest = /^[0-9]+(.[0-9]{2})?$/;
		if(resBalance==''){
			resBalance='0.0';
		}
		var balance=prompt("修改后价格：",resBalance);
		if(balance==null){
			return;
		}
		if(!balTest.test(balance)){
			alert("请输入正确数字");
		}else{
			 //后台修改
			 $.post("${context}/manage/ArticleTrans/updateResBalance.html", {resId:resId,resBalance:balance},
					 function(data) {
				 if(data=="error"){
					 alert("修改失败");
				 }else{
					 window.location.href =  "${context}/manage/ArticleTrans/toResBalanceList.html?pageNo=${pagesList.currentPageNo}";
				 }
			 }, "text");
		};
	}
</script>
</head>
<body>
	<!-- 引入头部 -->
	<%-- <div class="YJ2016_HTRote">
		<a href="${context}/DBM/resourceManage.html">首页</a>&nbsp;&nbsp;&gt;&nbsp;&nbsp;<span>IP权限管理</span>
	</div> --%>
	<div class="YJ2016_HTmain YJ2016_clearfix ">
		<!-- 左侧菜单引入 -->
		<div class="con" style="float: left;margin-left: 1%;margin-top: 5%">
        	<div class="HTc1">
			<table id="table1" style="text-align: center;margin-top: 10px;">
				<tbody style="width: 200px;">
					<tr class="cTitle">
						<td class="ct1">序号</td>
						<td class="ct1">资源库</td>
						<td class="ct2">价格</td>
						<td class="ct2">修改</td>
					</tr>
				</tbody>
				<c:forEach var="item" items="${pagesList.result}" varStatus="status">
					<tr>
						<td class="ct1" style="width:10%">${(pagesList.currentPageNo-1)*10+status.index+1}</td>
						<td class="ct1" style="width:15%">${item.resName}</td>
						<td class="ct2" style="width:15%"><c:if test="${item.resBalance==''}">0.0</c:if>
							<c:if test="${item.resBalance!=''}">${item.resBalance}</c:if>
							</td>
						<td class="ct3" style="width:15%"><a href="#" onclick="updateRes('${item.resId}','${item.resBalance}')">修改</a></td>
					</tr>
				</c:forEach>
			</table>
			<div class="notePage">
				 <div class="page">
                                     共<span>${pagesList.totalCount}</span>条记录&nbsp;&nbsp; <span>${pagesList.currentPageNo}/${pagesList.totalPageCount}</span>页
                    
                   	<c:if test="${pagesList.currentPageNo <=1}">首页</c:if>
                   	<c:if test="${pagesList.currentPageNo >1 }">
						<a href="javascript:void(0)" onclick="getList(1)" style="margin-right:5px;">首页</a>
					</c:if>
                   	
                   	<c:if test="${!pagesList.hasPreviousPage}">上一页</c:if>
					<c:if test="${pagesList.hasPreviousPage}">
				    	  <a href="javascript:void(0)" onclick="getList(${pagesList.currentPageNo -1 })" style="margin-right:5px;">上一页</a>
				    </c:if>
					<c:if test="${!pagesList.hasNextPage}">下一页</c:if>
					<c:if test="${pagesList.hasNextPage}">
				   		<a href="javascript:void(0)" onclick="getList(${pagesList.currentPageNo +1 })"  style="margin-right:5px;">下一页</a>
				    </c:if>
                   
                   	<c:if test="${pagesList.currentPageNo >= pagesList.totalPageCount}">尾页</c:if>
					<c:if test="${pagesList.currentPageNo < pagesList.totalPageCount}">
						<a href="javascript:void(0)" onclick="getList(${pagesList.totalPageCount})" style="margin-right:5px;">尾页</a>
					</c:if>
                   	 第<select onchange="self.location.href= options[selectedIndex].value" id="currentPageNoSelect"></select>页              
            </div>
			</div>
		</div>
    </div>
	</div>
	<!--con-->
	<!--YJ2016_HTmain-->
</body>
</html>