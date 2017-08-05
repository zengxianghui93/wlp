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
<script type="text/javascript" src="${context}/js/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript" src="${context}/js/WdatePicker.js"></script>
<script>
function checkwf_title() {
	if (document.form1.wf_title.value == "") {
		alert("书名不能为空！");
		document.form1.wf_title.focus();
		return false;
	}
}
	function checkform() { 
		if(checkwf_title()==false){ return false };
	 	return true;     
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
		<div class="con" align="center" style="float: left; margin-left: 4%">
			<div class="HTnd1" style="display: inline-block;"
				style="margin-right: 100%;">
				<span class="setTit">商品修改</span>
				<div class="HTnd_gdmod">
					<form name="form1"
						action="${context}/Chanpins/chanpindetail.html"
						method="post" enctype="multipart/form-data">
					<h4 style="text-align: center; color: red">
						<c:if test="${!empty errorMsg}">
							<div id="error " style="color: red">${errorMsg}</div>
						</c:if>
					</h4>

		<div class="YJ2016_UserMain_form">
			<table class="form_tb1">
				<tr>
					<td class="td1">商品名称：</td>
					<td><input  type="text" name="wf_title" value="${elepub.wf_title}" /></td>
				</tr>
					<tr>
					<td class="td1">是否有纸本：</td>
					<td><c:if test="${elepub.wf_paper_no==1}">
					<input  type="radio" name="wf_paper_no" checked="checked" value="1"/>是
					<input  type="radio" name="wf_paper_no" value="0"/>否
				    </c:if>
				    <c:if test="${elepub.wf_paper_no==0}">
					<input  type="radio" name="wf_paper_no"  value="1"/>是
					<input  type="radio" name="wf_paper_no" checked="checked" value="0"/>否
				    </c:if></td>
				</tr>
				<tr>
					<td class="td1">商品展示位置：</td>
					<td><c:forEach var="item" items="${etype}" varStatus="st">
						<c:if test="${fn:contains(elepub.wf_by1,item.id)}">
							<c:if test="${st.count%3==0}"><input type="checkbox" checked="checked" name="fenlei" value="${item.id}"/>${item.name}<br></c:if>
							<c:if test="${st.count%3!=0}"><input type="checkbox" checked="checked" name="fenlei" value="${item.id}"/>${item.name}</c:if>
						</c:if>
						<c:if test="${!fn:contains(elepub.wf_by1, item.id)}">
							<c:if test="${st.count%3==0}"><input type="checkbox"  name="fenlei" value="${item.id}"/>${item.name}<br></c:if>
							<c:if test="${st.count%3!=0}"><input type="checkbox"  name="fenlei" value="${item.id}"/>${item.name}</c:if>
						</c:if>
					    </c:forEach>
				    </td>
				</tr>
				<tr>
					<td class="td2" colspan="2">
						<input class="btn1" type="submit" onclick=" return checkform()" name="submit"	value="保存" />
					    <input class="btn1" type="button" onclick="history.go('-1')" value="返回" />
					</td>
				</tr>
			</table>
		</div>
               <input type="hidden" name ="id" value="${elepub.id}"/>
				</form>
				</div>
			</div>
		</div>
	</div>
	<!--con-->
	<!--YJ2016_HTmain-->
</body>
</html>