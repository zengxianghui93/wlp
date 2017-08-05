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
<title>IP权限管理_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script src="${context}/js/jquery.artDialog.source.js" type="text/javascript"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript">
	 $(function() {
		/* //选择页数的跳转
		var options = '';
		for(var i=0;i<"${pagedCategory.totalPageCount}"*1;i++){
			if((i+1) == "${pagedCategory.currentPageNo}"){
				options += '<option selected="selected" value="${context}/manage/categoryManage/toCategory.html?pageNo='+(i+1)+'&categoryCode=${categoryCodeNOW}">'+(i+1)+'</option>';
			}else{
				options += '<option value="${context}/manage/categoryManage/toCategory.html?pageNo='+(i+1)+'&categoryCode=${categoryCodeNOW}">'+(i+1)+'</option>';
			}
		}
		$("#currentPageNoSelect").html(options); */
	}); 
	 
	function toCategory(wf_categoryCode){
		window.location.href = "${context}/manage/categoryManage/toCategory.html?categoryCode="+wf_categoryCode;
	}
	
	function add(wf_categoryCode,type){
		window.location.href = "${context}/manage/categoryManage/toAddOrUpdate.html?categoryCode="+wf_categoryCode+"&type="+type;
	}
	
	function deleteCate(wf_categoryCode){
		if(confirm('是否要删除此类及其子分类？')){
			//后台删除
			 $.post("${context}/manage/categoryManage/delete.html", {wf_categoryCode:wf_categoryCode}, 
					 function(data) {
				 window.location.href = "${context}/manage/categoryManage/toCategory.html?categoryCode="+wf_categoryCode.substring(0,wf_categoryCode.length-4);
			 }, "text");
		};
	}
</script>
</head>
<body>
	<!-- 引入头部 -->
	<div class="YJ2016_HTRote">
		<a href="javascript:void(0)" onclick="toCategory('0000')">首页</a>&nbsp;&nbsp;&gt;&nbsp;&nbsp; 
		<c:forEach var="item" items="${supCateList}">
			<a href="javascript:void(0)" onclick="toCategory('${item.wf_categoryCode}')">${item.wf_categoryName}</a>&nbsp;&nbsp;&gt;&nbsp;&nbsp;
		</c:forEach>
		<span>分类列表</span>
	</div>
	<div class="YJ2016_HTmain YJ2016_clearfix ">
		<!-- 左侧菜单引入 -->
		<div class="con userCon" style="float: left;margin-left: 4%">
			<div class="userbtn">
				<a href="javascript:void(0)" onclick="add('${categoryCodeNOW}','add')" class="useradd">新增</a>
				<a href="javascript:void(0)" onclick="toCategory('${categoryCodeNOW}')" class="userfresh">刷新</a>
			</div>
			<table class="userTable" style="margin-top: 1%;margin-left: 2%;width: 90%">
				<tbody>
					<tr class="cTitle">
						<td class="ct1">序号</td>
						<td class="ct1">名称</td>
						<td class="ct2">检索表达式</td>
						<td class="ct3">编辑</td>
						<td class="ct3">删除</td>
					</tr>
				</tbody>
				<c:forEach var="item" items="${pagedCategory.result}" varStatus="status">
					<tr>
						<td class="ct1" style="width:10%">${status.index+1}</td>
						<td class="ct4" style="width:10%"><a href = "javascript:void(0)" onclick="toCategory('${item.wf_categoryCode}')">${item.wf_categoryName}</a></td>
						<td class="ct2" style="width:45%">${item.wf_searchStrategy}</td>
						<td class="ct3" style="width:10%"><a href="javascript:void(0)" onclick="add('${item.wf_categoryCode}','update')">编辑&nbsp;</a></td>
						<td  class="ct3" style="width:10%"><a href="javascript:void(0)" onclick="deleteCate('${item.wf_categoryCode}')">删除</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<%-- <div class="notePage">
				 <div class="page">
                                     共<span>${pagedCategory.totalCount}</span>条记录&nbsp;&nbsp; <span>${pagedCategory.currentPageNo}/${pagedCategory.totalPageCount}</span>页
                    
                   	<c:if test="${pagedCategory.currentPageNo <=1}">首页</c:if>
                   	<c:if test="${pagedCategory.currentPageNo >1 }">
						<a href="${context}/manage/categoryManage/toCategory.html?pageNo=1&categoryCode='${categoryCodeNOW}'" style="margin-right:5px;">首页</a>
					</c:if>
                   	
                   	<c:if test="${!pagedCategory.hasPreviousPage}">上一页</c:if>
					<c:if test="${pagedCategory.hasPreviousPage}">
				    	  <a href="${context}/manage/categoryManage/toCategory.html?pageNo=${pagedCategory.currentPageNo -1 }&categoryCode='${categoryCodeNOW}'" style="margin-right:5px;">上一页</a>
				    </c:if>
				    
					<c:if test="${!pagedCategory.hasNextPage}">下一页</c:if>
					<c:if test="${pagedCategory.hasNextPage}">
				   		<a href="${context}/manage/categoryManage/toCategory.html?pageNo=${pagedCategory.currentPageNo +1 }&categoryCode='${categoryCodeNOW}'" style="margin-right:5px;">下一页</a>
				    </c:if>
                   
                   	<c:if test="${pagedCategory.currentPageNo >= pagedCategory.totalPageCount}">尾页</c:if>
					<c:if test="${pagedCategory.currentPageNo < pagedCategory.totalPageCount}">
						<a href="${context}/manage/categoryManage/toCategory.html?pageNo=${pagedCategory.totalPageCount }&categoryCode='${categoryCodeNOW}'" style="margin-right:5px;">尾页</a>
					</c:if>
                    
                   	 第
                    <select onchange="self.location.href= options[selectedIndex].value" id="currentPageNoSelect"></select>页              
            </div> --%>
			</div>
		</div>
    </div>
	<!--con-->
	<!-- 引入头部 -->
	<%-- <jsp:include page="../include/top.jsp"></jsp:include> --%>
	
	<!--YJ2016_HTmain-->
</body>
</html>