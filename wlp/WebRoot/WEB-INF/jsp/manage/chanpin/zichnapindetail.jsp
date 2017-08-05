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
<title>子商品团队管理_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript" src="${context}/js/WdatePicker.js"></script>
<script>
function checkwf_datetmies() {
	if (document.form1.wf_title.value == "") {
		alert("请输入题名");
		document.form1.wf_title.focus();
		return false;
	}
}
function checkjine() {
	if (document.form1.wf_price.value == "") {
		alert("请输入价格");
		document.form1.wf_price.focus();
		return false;
	}
	//以字母或数字开头，跟上@,   /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/
	var expr = /^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/;
	var re = new RegExp(expr)
	if (!re.test(document.form1.wf_price.value)) {
		alert("输入的价格格式有误！");
		document.form1.wf_price.focus();
		return false;
	}
}
function checkzekou() {
	if (document.form1.wf_afterDiscountPrice.value == "") {
		alert("请输入金额");
		document.form1.wf_afterDiscountPrice.focus();
		return false;
	}
	//以字母或数字开头，跟上@,   /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/
	var expr = /^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/;
	var re = new RegExp(expr)
	if (!re.test(document.form1.wf_afterDiscountPrice.value)) {
		alert("输入的价格格式有误！");
		document.form1.wf_afterDiscountPrice.focus();
		return false;
	}
}
function checkyeshu() {
	if (document.form1.wf_totalpage.value == "") {
		alert("请输入页数");
		document.form1.wf_totalpage.focus();
		return false;
	}
	//以字母或数字开头，跟上@,   /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/
	var expr = /^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/;
	var re = new RegExp(expr)
	if (!re.test(document.form1.wf_totalpage.value)) {
		alert("输入的页数格式有误！");
		document.form1.wf_totalpage.focus();
		return false;
	}
}
function checkyear() {
	if (document.form1.wf_year.value == "") {
		alert("请输入出版年");
		document.form1.wf_year.focus();
		return false;
	}
	//以字母或数字开头，跟上@,   /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/
	var expr = /^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/;
	var re = new RegExp(expr)
	if (!re.test(document.form1.wf_year.value)) {
		alert("输入的出版年格式有误！");
		document.form1.wf_year.focus();
		return false;
	}
}
function checkzuozhe() {
	if (document.form1.wf_author.value == "") {
		alert("请输入作者");
		document.form1.wf_author.focus();
		return false;
	}
}
	function checkform() { 
		if(checkwf_datetmies()==false){ return false };
		if(checkjine()==false){ return false };
		if(checkzekou()==false){ return false };
		if(checkyeshu()==false){ return false };
		if(checkzuozhe()==false){ return false };
		if(checkyear()==false){ return false };
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
			<div class="HTnd1" style="width:950px; display: inline-block;"
				style="margin-right: 100%;">
				<span class="setTit">子商品修改</span>
				<div class="HTnd_gdmod">
					<form name="form1"
						action="${context}/Chanpins/zichanpindetail.html"
						method="post" enctype="multipart/form-data">
					<h4 style="text-align: center; color: red">
						<c:if test="${!empty errorMsg}">
							<div id="error " style="color: red">${errorMsg}</div>
						</c:if>
					</h4>

		<div class="YJ2016_UserMain_form">
			<table class="form_tb1">
				<tr>
					<td class="td1">商品题名：</td>
					<td><input  type="text" name="wf_title" value="${elepub.wf_title}" /></td>
				</tr>
				<tr>
					<td class="td1">商品图片：</td>
					<td class="YJ2016_clearfix">
						<img class="default" src="${context}/images/upload/userPhoto/${elepub.wf_coverPicture}" />
						<input class="input1" type="file" name="wf_photo" />
					</td>
				</tr>
				<tr>
					<td class="td1">pdf上传：</td>
					<td class="YJ2016_clearfix">
						<input class="input1" type="file" name="wf_photo" />
					</td>
				</tr>
				<tr>
					<td class="td1">期：</td>
					<td>
					<select name="wf_issue" style="padding: 0 10px; height: 30px;">
			            <c:forEach  var="aa" items="${type}">
			              <c:if test="${aa.id==elepub.wf_issue}">
			              <option selected="selected" value="${aa.id}">${aa.type}</option>
			              </c:if>
			              <c:if test="${aa.id!=elepub.wf_issue}">
			              <option  value="${aa.id}">${aa.type}</option>
			              </c:if>
			            </c:forEach>
					</select>
				</td>
				</tr>
				<tr>
					<td class="td1">价格：</td>
					<td><input type="text" name="wf_price"
						value="${elepub.wf_price}" /></td>
				</tr>
				<tr>
					<td class="td1">折扣：</td>
					<td>
					<c:if test="${elepub.wf_afterDiscountPrice==1}">
					<select name="wf_afterDiscountPrice" style="padding: 0 10px; height: 30px;">
					<option selected="selected" value="1">无折扣</option>
								<option value="0.9">九折</option>
								<option value="0.8">八折</option>
								<option value="0.7">七折</option>
								<option value="0.6">六折</option>
								<option value="0.5">五折</option>
					</select>
					</c:if>
					<c:if test="${elepub.wf_afterDiscountPrice==0.9}">
					<select name="wf_afterDiscountPrice" style="padding: 0 10px; height: 30px;">
					<option value="1">无折扣</option>
								<option value="0.9"  selected="selected" >九折</option>
								<option value="0.8">八折</option>
								<option value="0.7">七折</option>
								<option value="0.6">六折</option>
								<option value="0.5">五折</option>
					</select>
					</c:if>
					<c:if test="${elepub.wf_afterDiscountPrice==0.8}">
					<select name="wf_afterDiscountPrice" style="padding: 0 10px; height: 30px;">
					<option  value="1">无折扣</option>
								<option value="0.9">九折</option>
								<option value="0.8"  selected="selected" >八折</option>
								<option value="0.7">七折</option>
								<option value="0.6">六折</option>
								<option value="0.5">五折</option>
					</select>
					</c:if>
					<c:if test="${elepub.wf_afterDiscountPrice==0.7}">
					<select name="wf_afterDiscountPrice" style="padding: 0 10px; height: 30px;">
					<option value="1">无折扣</option>
								<option value="0.9">九折</option>
								<option value="0.8">八折</option>
								<option value="0.7"  selected="selected" >七折</option>
								<option value="0.6">六折</option>
								<option value="0.5">五折</option>
					</select>
					</c:if>
					<c:if test="${elepub.wf_afterDiscountPrice==0.6}">
					<select name="wf_afterDiscountPrice" style="padding: 0 10px; height: 30px;">
					<option value="1">无折扣</option>
								<option value="0.9">九折</option>
								<option value="0.8">八折</option>
								<option value="0.7">七折</option>
								<option value="0.6"  selected="selected" >六折</option>
								<option value="0.5">五折</option>
					</select>
					</c:if>	
					<c:if test="${elepub.wf_afterDiscountPrice==0.5}">
					<select name="wf_afterDiscountPrice" style="padding: 0 10px; height: 30px;">
					<option value="1">无折扣</option>
								<option value="0.9">九折</option>
								<option value="0.8">八折</option>
								<option value="0.7">七折</option>
								<option value="0.6">六折</option>
								<option  selected="selected"  value="0.5">五折</option>
					</select>
					</c:if>	
					</td>
				</tr>
				<tr>
					<td class="td1">页数：</td>
					<td><input type="text" name="wf_totalpage"
						value="${elepub.wf_totalpage}" /></td>
				</tr>
					<tr>
					<td class="td1">出版频率：</td>
					<td><input type="text" name="wf_pubFrequency"
						value="${elepub.wf_pubFrequency}" /></td>
				</tr>
					<tr>
					<td class="td1">出版年：</td>
					<td><input type="text" name="wf_year"
						value="${elepub.wf_year}" /></td>
				</tr>
					<tr>
					<td class="td1">开本：</td>
					<td>
					<c:if test="${elepub.wf_booksize=='十六开'}">
					<select id="wf_booksize" name="wf_booksize" style="padding: 0 10px; height: 30px;">
								<option selected="selected" value="十六开">十六开</option>
								<option value="三十二开">三十二开</option>
								<option value="六十四开">六十四开</option>
					</select>
					</c:if>	
					<c:if test="${elepub.wf_booksize=='三十二开'}">
					<select id="wf_booksize" name="wf_booksize" style="padding: 0 10px; height: 30px;">
								<option value="十六开">十六开</option>
								<option selected="selected" value="三十二开">三十二开</option>
								<option value="六十四开">六十四开</option>
					</select>
					</c:if>	
					<c:if test="${elepub.wf_booksize=='六十四开'}">
					<select id="wf_booksize" name="wf_booksize" style="padding: 0 10px; height: 30px;">
								<option value="十六开">十六开</option>
								<option value="三十二开">三十二开</option>
								<option selected="selected" value="六十四开">六十四开</option>
					</select>
					</c:if>	
					</td>
				</tr>
					<tr>
					<td class="td1">是否连续出版：</td>
					<td><c:if test="${elepub.wf_continuousPub=='1'}">
					<input  type="radio" name="wf_continuousPub" checked="checked" value="1"/>是
					<input  type="radio" name="wf_continuousPub" value="2"/>否
				    </c:if>
				    <c:if test="${elepub.wf_continuousPub=='2'}">
					<input  type="radio" name="wf_continuousPub"  value="1"/>是
					<input  type="radio" name="wf_continuousPub" checked="checked" value="2"/>否
				    </c:if></td>
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
					<td class="td1">产品介绍：</td>
					<td><textarea name="wf_doccontent" class="ckeditor textarea1">${elepub.wf_authorUnit}</textarea></td>
				</tr>
				<tr>
					<td class="td1">简介：</td>
				    <td><textarea name="wf_doccontent" class="ckeditor textarea1">${elepub.wf_doccontent}</textarea>
						</td>
				</tr>
				<tr>
					<td class="td1">目录：</td>
					<td><textarea name="wf_by1" class="ckeditor textarea1">${elepub.wf_by1}</textarea>
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
               <input type="hidden" name ="id" value="${elepub.f_id}"/>
               <input type="hidden" name ="eid" value="${id}"/>
				</form>
				</div>
			</div>
		</div>
	</div>
	<!--con-->
	<!--YJ2016_HTmain-->
</body>
</html>