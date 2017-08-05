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
<title>修改字段属性</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript">
	function changeFld(obj){
		var tagType = $("#fldTagType");
		if(obj.value == "input"){
			$("#fldTagTypeTR").show();
			$("#tagdefaultValueTR").show();
			tagType.html('');
			tagType.html('<option value="text">文本</option>');
		}else if(obj.value == "textarea"){
			$("#fldTagTypeTR").hide();
			$("#tagdefaultValueTR").hide();
		}else if(obj.value == "select"){
			$("#fldTagTypeTR").show();
			$("#tagdefaultValueTR").hide();
			tagType.html('');
			tagType.html('<option value="language">语种</option><option value="origin">MI库来源</option><option value="other">其他</option>');
		}
	}
	function changeOption(obj){
		if(obj.value=="other"){
			$("#tagAdditionalTR").show();
		}else{
			$("#tagAdditionalTR").hide();	
		}
	}
	function toTop(obj){
		//obj.checked=true;
		obj.value = Math.round(new Date().getTime()/1000);
	}
	$(function(){
		var obj = "${resFldInfo.fldHtmlTag}";
		var tagType = $("#fldTagType");
		if(obj == "input"){
			$("#fldTagTypeTR").show();
			$("#tagdefaultValueTR").show();
			tagType.html('');
			tagType.html('<option value="text">文本</option>');
		}else if(obj == "textarea"){
			$("#fldTagTypeTR").hide();
			$("#tagdefaultValueTR").hide();
		}else if(obj == "select"){
			$("#fldTagTypeTR").show();
			$("#tagdefaultValueTR").hide();
			tagType.html('');
			var html = "";
			if("${resFldInfo.fldTagType}" == 'language' ){
				html+='<option value="language" selected="selected">语种</option>';
			}else{
				html+='<option value="language">语种</option>';
			}
			if("${resFldInfo.fldTagType}" == 'origin' ){
				html+='<option value="origin" selected="selected">MI库来源</option>';
			}else{
				html+='<option value="origin">MI库来源</option>';
			}
			if("${resFldInfo.fldTagType}" == 'other' ){
				html+='<option value="other" selected="selected">其他</option>';
			}else{
				html+='<option value="other">其他</option>';
			}
			tagType.html(html);
		}
	})
</script>
<style type="text/css">
.leftmenu-zhao {
	border: 1px solid #ccc;
	height: 780px;
	width: 765px;
	overflow: scroll;
	overflow-x: hidden;
}

.YJ2016_HTmain form table tr td input[type=text] {
	width: 500px;
	height: 30px;
	border: 1px solid #a9a9a9;
	"
}
</style>
</head>
<body>
	<!-- 顶部样式引入 -->
	<!-- <div class="YJ2016_HTRote">
		<a href="#">首页</a>&nbsp;&nbsp;&gt;&nbsp;&nbsp;<span>数据加工</span>
	</div> -->
	<div class="YJ2016_HTmain YJ2016_clearfix ">
		<!-- 左侧功能菜单引入 -->
		<div class="con">
			<form action="${context}/DBM/editResFld.html" method="post"
				onsubmit="return mySubmit()" enctype="multipart/form-data">
				<table style="margin-top: 20px;">
					<tr>
						<td class="aname">字段名称</td>
						<td><input readonly="true" value="${resFldInfo.fldName}"
							type="text" name="fldName" style="width: 60%;" /></td>
					</tr>
					<tr>
						<td class="aname">字段中文名称</td>
						<td><input value="${resFldInfo.fldDesc}" type="text"
							name="fldDesc" style="width: 60%;" /></td>
					</tr>
					<tr>
						<td class="aname">字段类型</td>
						<td><input value="${resFldInfo.fldType}" type="text"
							name="fldType" style="width: 60%;" /></td>
					</tr>
					<tr>
						<td class="aname">字段长度</td>
						<td><input value="${resFldInfo.fldLength}" type="text"
							name="fldLength" style="width: 60%;" /></td>
					</tr>
					<tr>
						<td class="aname">是否可检索</td>
						<td><c:choose>
								<c:when test="${resFldInfo.getFldSearch()==1}">
									<input type="radio" name="fldSearch" checked="true" value="1" />是
						<input type="radio" name="fldSearch" value="0" />否	
				   </c:when>
								<c:otherwise>
									<input type="radio" name="fldSearch" value="1" />是
						<input type="radio" name="fldSearch" checked="true" value="0" />否	
				   </c:otherwise>
							</c:choose></td>
					</tr>
					<tr>
						<td class="aname">是否为空</td>
						<td><c:choose>
								<c:when test="${resFldInfo.getFldIsNull()==1}">
									<input type="radio" name="fldIsNull" checked="true" value="1" />是
						<input type="radio" name="fldIsNull" value="0" />否	
				   </c:when>
								<c:otherwise>
									<input type="radio" name="fldIsNull" value="1" />是
						<input type="radio" name="fldIsNull" checked="true" value="0" />否	
				   </c:otherwise>
							</c:choose></td>
					</tr>
					<tr>
						<td class="aname">是否列表页显示</td>
						<td><c:choose>
								<c:when test="${resFldInfo.getFldList()==1}">
									<input type="radio" name="fldList" checked="true" value="1" />是
						<input type="radio" name="fldList" value="0" />否	
				   </c:when>
								<c:otherwise>
									<input type="radio" name="fldList" value="1" />是
						<input type="radio" name="fldList" checked="true" value="0" />否	
				   </c:otherwise>
							</c:choose></td>
					</tr>
					<tr>
						<td class="aname">是否详细页显示</td>
						<td><c:choose>
								<c:when test="${resFldInfo.getFldDetail()==1}">
									<input type="radio" name="fldDetail" checked="true" value="1" />是
						<input type="radio" name="fldDetail" value="0" />否	
				   </c:when>
								<c:otherwise>
									<input type="radio" name="fldDetail" value="1" />是
						<input type="radio" name="fldDetail" checked="true" value="0" />否	
				   </c:otherwise>
							</c:choose></td>
					</tr>
					<tr>
						<td class="aname">输入方式</td>
						<td><input value="${resFldInfo.fldInputType}" type="text"
							name="fldInputType" style="width: 60%;" /></td>
					</tr>
					<tr>
						<td class="aname">标签</td>
						<td><select name="fldHtmlTag" style="height: 30px;"
							onchange="changeFld(this);">
								<c:choose>
									<c:when test="${resFldInfo.fldHtmlTag == 'input'}">
										<option value="input" selected="selected">文本框</option>
									</c:when>
									<c:otherwise>
										<option value="input">文本框</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${resFldInfo.fldHtmlTag == 'textarea'}">
										<option value="textarea" selected="selected">大文本框</option>
									</c:when>
									<c:otherwise>
										<option value="textarea">大文本框</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${resFldInfo.fldHtmlTag == 'select'}">
										<option value="select" selected="selected">下拉选择框</option>
									</c:when>
									<c:otherwise>
										<option value="select">下拉选择框</option>
									</c:otherwise>
								</c:choose>
						</select></td>
					</tr>
					<tr id="fldTagTypeTR">
						<td class="aname">标签类型</td>
						<td><select name="fldTagType" id="fldTagType"
							onchange="changeOption(this);" style="height: 30px;">
								<c:choose>
									<c:when test="${resFldInfo.fldTagType == 'text'}">
										<option value="text" selected="selected">文本</option>
									</c:when>
									<c:otherwise>
										<option value="text">文本</option>
									</c:otherwise>
								</c:choose>
						</select></td>
					</tr>
					<tr id="tagAdditionalTR" style="display: none;">
						<td class="aname">标签补充</td>
						<td><textarea rows="5" cols="30" name="tagAdditional">${resFldInfo.tagAdditional}</textarea>
						</td>
					</tr>
					<tr id="tagdefaultValueTR">
						<td class="aname">标签默认值</td>
						<td><input type="text" name="tagdefaultValue"
							value="${resFldInfo.tagdefaultValue}" /></td>
					</tr>
					<tr id="topTR">
						<td class="aname">置顶</td>
						<td><input type="radio" name="top" onclick="toTop(this)"
							value="1" />是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio"
							name="top" value="0" checked="checked" />否</td>
					</tr>
					<tr id="fldIsEnterTR">
						<td class="aname">是否录入显示</td>
						<td><c:choose>
								<c:when test="${resFldInfo.fldIsEnter == 1}">
									<input type="radio" name="fldIsEnter" value="1"
										checked="checked" />是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</c:when>
								<c:otherwise>
									<input type="radio" name="fldIsEnter" value="1"
										checked="checked" />是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</c:otherwise>
							</c:choose> <c:choose>
								<c:when test="${resFldInfo.fldIsEnter == 0}">
									<input type="radio" name="fldIsEnter" value="0"
										checked="checked" />否
								</c:when>
								<c:otherwise>
									<input type="radio" name="fldIsEnter" value="0" />否
								</c:otherwise>
							</c:choose></td>
					</tr>
					<tr>
						<td colspan="2" class="btnGroup" align="center"><input
							type="submit" value="保存"
							style="display: inline-block; width: 120px; height: 35px; text-align: center; line-height: 35px; background: #3575b5; margin-right: 10px; color: #fff;">
							<input type="reset" value="重置"
							style="display: inline-block; width: 120px; height: 35px; text-align: center; line-height: 35px; background: #3575b5; margin-right: 10px; color: #fff;">
						</td>
					</tr>
				</table>
				<input type="hidden" name="resId" value="${resFldInfo.resId}" /> <input
					type="hidden" name="fldId" value="${resFldInfo.fldId}" />
			</form>
		</div>

		<!--con-->
	</div>
	<!--YJ2016_HTmain-->
</body>
</html>