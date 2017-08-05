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
<script type="text/javascript">
$(function() {
	    //选择页数的跳转
		var options = '';
		for(var i=0;i<"${pagedNews.totalPageCount}"*1;i++){
			if((i+1) == "${pagedNews.currentPageNo}"){
				options += '<option selected="selected" value="${context}/manage/specialistsql-${name}-${zhuanjia}-${wf_unit}-${wf_by1}.html?pageNo='+(i+1)+'">'+(i+1)+'</option>';
			}else{
				options += '<option value="${context}/manage/specialistsql-${name}-${zhuanjia}-${wf_unit}-${wf_by1}.html?pageNo='+(i+1)+'">'+(i+1)+'</option>';
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
		<form name="select" action="${context}/manage/specialistsqlselect.html" method="post" >
			<div class="search orderSearch">
				<div class="os_left">
					<p>
						<span>专家姓名：</span><input type="text" name="name" class="osTxt1" value="${name}" />
					</p>
					<p>
						<span>专家单位：</span><input type="text" name="wf_unit" class="osTxt1" value="${wf_unit}" />
					</p>
				</div>
				<div class="os_right">
					<p>
						<span>专家团队：</span> <select name="zhuanjia">
						        <c:if test="${zhuanjia==0}"> 
								 <option selected="selected" value="0">请选择</option>
								</c:if>
								<c:if test="${zhuanjia!=0}"> 
								 <option value="0">请选择</option>
								</c:if>
							    <c:forEach var="status" items="${specialistteamstatus}" >
								<c:if test="${status.id==zhuanjia}"> 
								 <option selected="selected" value="${status.id}">${status.specialistteam}</option>
								</c:if>
								<c:if test="${status.id!=zhuanjia}">
								 <option value="${status.id}">${status.specialistteam}</option>
								</c:if>
							    </c:forEach>
						</select>
					</p>
					<p>
						<span>专家职称：</span><input type="text" name="wf_by1" class="osTxt1" value="${wf_by1}" />
					</p>
				</div>
				<div style="text-align: center;">
					<a href="javascript:document:select.submit();" class="osBtn">搜索</a>
				</div>
			</div>
			</form>
			<div class="userbtn">
			     <a href="${context}/manage/zhuanjiainsert.html" class="useradd"
					style="width: 70px;">添加专家</a>
				<a href="${context}/manage/zjtd.html" class="useradd"
				style="width: 110px;">专家团队分类</a>
				 <a href="${context}/manage/specialistsqlselect.html" class="userfresh">刷新</a>
			</div>
			<table class="OrderTable">
				<tr class="cTitle">
				    <td class="ct1">序号</td>
					<td class="ct1">专家姓名</td>
					<td class="ct1">性别</td>
					<td class="ct3">单位</td>
					<td class="ct4">职称</td>
					<td class="ct4">专家团队</td>
					<td class="ct4">顺序</td>
					<td class="ct4">修改</td>
					<td class="ct4">删除</td>
				</tr>
				<c:forEach var="zj" items="${pagedNews.result}" varStatus="status">
					<tr>
					    <td class="ct1">${(pagedNews.currentPageNo-1)*10+status.index+1}</td>
						<td class="ct1">${zj.wf_name}</td>
						<td class="ct1">
						<c:if test="${zj.wf_sex=='1'}">男</c:if>
				        <c:if test="${zj.wf_sex=='2'}">女</c:if>
						</td>
						<td class="ct3">${zj.wf_unit}</td>
						<td class="ct4">${zj.wf_by1}</td>
						<td class="ct5">
						<c:forEach var="item1" items="${specialistteamstatus}" varStatus="st">
						<c:if test="${fn:contains(zj.wf_by2,item1.id)}">
							<c:if test="${st.count%2==0}">${item1.specialistteam}&nbsp<br></c:if>
							<c:if test="${st.count%2!=0}">${item1.specialistteam}&nbsp</c:if>
						</c:if>
					    </c:forEach>
				        </td>
						<td class="ct6">${zj.p_id}</td>
						<td class="ct6"><a href="${context}/manage/zhuanjiaupdate-${zj.f_id}.html">修改</a></td>
						<td class="ct6"><a href="${context}/manage/specialistdelete-${zj.f_id}.html" onClick="return confirm('确实想删除吗？')">删除</a></td>
					</tr>
				</c:forEach>
			</table>

			<div class="notePage">
				<div class="page">
					共<span>${pagedNews.totalCount}</span>条记录&nbsp;&nbsp; <span>${pagedNews.currentPageNo}/${pagedNews.totalPageCount}</span>页

					<c:if test="${pagedNews.currentPageNo <=1}">首页</c:if>
					<c:if test="${pagedNews.currentPageNo >1 }">
						<a href="${context}/manage/specialistsql-${name}-${zhuanjia}-${wf_unit}-${wf_by1}.html?pageNo=1"
							style="margin-right: 5px;">首页</a>
					</c:if>

					<c:if test="${!pagedNews.hasPreviousPage}">上一页</c:if>
					<c:if test="${pagedNews.hasPreviousPage}">
						<a
							href="${context}/manage/specialistsql-${name}-${zhuanjia}-${wf_unit}-${wf_by1}.html?pageNo=${pagedNews.currentPageNo -1 }"
							style="margin-right: 5px;">上一页</a>
					</c:if>

					<c:if test="${!pagedNews.hasNextPage}">下一页</c:if>
					<c:if test="${pagedNews.hasNextPage}">
						<a
							href="${context}/manage/specialistsql-${name}-${zhuanjia}-${wf_unit}-${wf_by1}.html?pageNo=${pagedNews.currentPageNo +1 }"
							style="margin-right: 5px;">下一页</a>
					</c:if>

					<c:if test="${pagedNews.currentPageNo >= pagedNews.totalPageCount}">尾页</c:if>
					<c:if test="${pagedNews.currentPageNo < pagedNews.totalPageCount}">
						<a
							href="${context}/manage/specialistsql-${name}-${zhuanjia}-${wf_unit}-${wf_by1}.html?pageNo=${pagedNews.totalPageCount }"
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