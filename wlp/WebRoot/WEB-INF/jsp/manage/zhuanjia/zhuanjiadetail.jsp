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
<title>专家团队管理_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript" src="${context}/js/WdatePicker.js"></script>
<script>
function checkpaixu() {
	var expr = /^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/;
	var re = new RegExp(expr)
	if (!re.test(document.form1.p_id.value)) {
		alert("输入的排序格式有误！");
		document.form1.p_id.focus();
		return false;
	}
}
function checkwf_datetmies() {
	if (document.form1.wf_datetmies.value == "") {
		alert("请输入实际完成日期");
		document.form1.wf_datetmies.focus();
		return false;
	}
}
function checkwf_newdate() {
	if (document.form1.wf_newdate.value == "") {
		alert("请输入付费日期");
		document.form1.wf_newdate.focus();
		return false;
	}
}
	function checkform() { 
		if(checkpaixu()==false){ return false };
		if(checkwf_datetmies()==false){ return false };
		if(checkwf_newdate()==false){ return false };
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
				<span class="setTit">专家修改</span>
				<div class="HTnd_gdmod">
					<form name="form1"
						action="${context}/manage/specialistupdate.html"
						method="post" enctype="multipart/form-data">
					<h4 style="text-align: center; color: red">
						<c:if test="${!empty errorMsg}">
							<div id="error " style="color: red">${errorMsg}</div>
						</c:if>
					</h4>

		<div class="YJ2016_UserMain_form">
			<table class="form_tb1">
				<tr>
					<td class="td1">专家照片：</td>
					<td class="YJ2016_clearfix">
						<img class="default" src="${context}/images/upload/userPhoto/${specialistTeam.wf_photo}" />
						<input class="input1" type="file" name="wf_photo" />
					</td>
				</tr>
				<tr>
					<td class="td1">专家排序：</td>
					<td><input  type="text" name="p_id" value="${specialistTeam.p_id}" /></td>
				</tr>
				<tr>
					<td class="td1">专家姓名：</td>
					<td><input  type="text" name="wf_name" value="${specialistTeam.wf_name}" /></td>
				</tr>
				<tr>
					<td class="td1">专家性别：</td>
					<td><c:if test="${specialistTeam.wf_sex=='1'}">
					<input  type="radio" name="wf_sex" checked="checked" value="1"/>男
					<input  type="radio" name="wf_sex" value="2"/>女
				    </c:if>
				    <c:if test="${specialistTeam.wf_sex=='2'}">
					<input  type="radio" name="wf_sex"  value="1"/>男
					<input  type="radio" name="wf_sex" checked="checked" value="2"/>女
				    </c:if></td>
				</tr>
				<tr>
					<td class="td1">专家职称：</td>
					<td><input  type="text" name="wf_by1" value="${specialistTeam.wf_by1}" /></td>
				</tr>
				<tr>
					<td class="td1">专家单位：</td>
					<td><input type="text" name="wf_unit"
						value="${specialistTeam.wf_unit}" /></td>
				</tr>
				<tr>
					<td class="td1">专家团队：</td>
					<td><c:forEach var="item" items="${specialistteamstatus}" varStatus="st">
						<c:if test="${fn:contains(specialistTeam.wf_by2,item.id)}">
							<c:if test="${st.count%3==0}"><input type="checkbox" checked="checked" name="wf_by2" value="${item.id}"/>${item.specialistteam}<br></c:if>
							<c:if test="${st.count%3!=0}"><input type="checkbox" checked="checked" name="wf_by2" value="${item.id}"/>${item.specialistteam}</c:if>
						</c:if>
						<c:if test="${!fn:contains(specialistTeam.wf_by2, item.id)}">
							<c:if test="${st.count%3==0}"><input type="checkbox"  name="wf_by2" value="${item.id}"/>${item.specialistteam}<br></c:if>
							<c:if test="${st.count%3!=0}"><input type="checkbox"  name="wf_by2" value="${item.id}"/>${item.specialistteam}</c:if>
						</c:if>
					    </c:forEach>
				    </td>
					<%-- <td>
					<c:if test="${specialistTeam.wf_by2=='1'}">
					<input type="checkbox" name="wf_by2" checked="checked" value="1"/>第一届<input type="checkbox" name="wf_by2" value="2"/>第二届<input type="checkbox" name="wf_by2" value="3"/>第三届
				    </c:if>
				    <c:if test="${specialistTeam.wf_by2=='2'}">
					<input type="checkbox" name="wf_by2"  value="1"/>第一届<input type="checkbox" name="wf_by2" checked="checked" value="2"/>第二届<input type="checkbox" name="wf_by2" value="3"/>第三届
				    </c:if>
				    <c:if test="${specialistTeam.wf_by2=='3'}">
					<input type="checkbox" name="wf_by2"  value="1"/>第一届<input type="checkbox" name="wf_by2" value="2"/>第二届<input type="checkbox" name="wf_by2" checked="checked" value="3"/>第三届
				    </c:if>
				    <c:if test="${specialistTeam.wf_by2=='12'}">
					<input type="checkbox" name="wf_by2" checked="checked" value="1"/>第一届<input type="checkbox" name="wf_by2" checked="checked" value="2"/>第二届<input type="checkbox" name="wf_by2" value="3"/>第三届
				    </c:if>
				    <c:if test="${specialistTeam.wf_by2=='13'}">
					<input type="checkbox" name="wf_by2" checked="checked" value="1"/>第一届<input type="checkbox" name="wf_by2" value="2"/>第二届<input type="checkbox" name="wf_by2" checked="checked"  value="3"/>第三届
				    </c:if>
				    <c:if test="${specialistTeam.wf_by2=='23'}">
					<input type="checkbox" name="wf_by2"  value="1"/>第一届<input type="checkbox" name="wf_by2" checked="checked" value="2"/>第二届<input type="checkbox" name="wf_by2" checked="checked" value="3"/>第三届
				    </c:if>
				    <c:if test="${specialistTeam.wf_by2=='123'}">
					<input type="checkbox" name="wf_by2" checked="checked" value="1"/>第一届<input type="checkbox" name="wf_by2" checked="checked" value="2"/>第二届<input type="checkbox" name="wf_by2" checked="checked" value="3"/>第三届
				    </c:if>
				    </td> --%>
				</tr>
				<tr>
					<td class="td1">专家简介：</td>
					<td><textarea name="wf_abstract" class="ckeditor textarea1">${specialistTeam.wf_abstract}</textarea>
						</td>
				</tr>
				<tr>
					<td class="td2" colspan="2">
						<input class="btn1" type="submit" name="submit"	onclick=" return checkform()" value="保存" />
						<input class="btn1" type="button" onclick="history.go('-1')" value="返回" />
					</td>
				</tr>
			</table>
		</div>
               <input type="hidden" name ="id" value="${specialistTeam.f_id}"/>
               <input type="hidden" name ="update_pid" value="${specialistTeam.p_id}"/>
				</form>
				</div>
			</div>
		</div>
	</div>
	<!--con-->
	<!--YJ2016_HTmain-->
</body>
</html>