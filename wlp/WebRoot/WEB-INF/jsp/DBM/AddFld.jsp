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
<title>添加字段</title>
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
</script>
<style type="text/css">
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
			<h2 align="center" style="margin-top: 20px;">添加一个字段</h2>
			<br />
			<form action="${context}/DBM/addResFld.html" method="post"
				onsubmit="return mySubmit()" enctype="multipart/form-data">
				<table>
					<tr>
						<td class="aname">字段英文名称</td>
						<td><input type="text" name="fldName"
							style="width: 500px; height: 30px; border: 1px solid #a9a9a9;" /></td>
					</tr>
					<tr>
						<td class="aname">字段中文名称</td>
						<td><input type="text" name="fldDesc"
							style="width: 500px; height: 30px; border: 1px solid #a9a9a9;" /></td>
					</tr>
					<tr>
						<td class="aname">字段类型</td>
						<td><select name="fldType" style="height: 30px;">
								<option value="varchar">文字</option>
								<option value="int">数字</option>
								<option value="longtext">大段文字</option>
								<option value="datetime">日期时间</option>
						</select></td>
					</tr>
					<tr>
						<td class="aname">字段长度</td>
						<td><input type="text" name="fldLength"
							style="width: 500px; height: 30px; border: 1px solid #a9a9a9;" /></td>
					</tr>
					<tr>
						<td class="aname">是否可检索</td>
						<td><input type="radio" name="fldSearch" checked="true"
							value="1" />是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio"
							name="fldSearch" value="0" />否</td>
					</tr>
					<tr>
						<td class="aname">是否为空</td>
						<td><input type="radio" name="fldIsNull" checked="true"
							value="1" />是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio"
							name="fldIsNull" value="0" />否</td>
					</tr>
					<tr>
						<td class="aname">是否列表页显示</td>
						<td><input type="radio" name="fldList" value="1" />是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="fldList" checked="true" value="0" />否
						</td>
					</tr>
					<tr>
						<td class="aname">是否详细页显示</td>
						<td><input type="radio" name="fldDetail" checked="true"
							value="1" />是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio"
							name="fldDetail" value="0" />否</td>
					</tr>
					<tr>
						<td class="aname">输入方式</td>
						<td><input type="text" name="fldInputType"
							style="width: 500px; height: 30px; border: 1px solid #a9a9a9;" /></td>
					</tr>
					<tr>
						<td class="aname">标签</td>
						<td><select name="fldHtmlTag" style="height: 30px;"
							onchange="changeFld(this);">
								<option value="input">文本框</option>
								<option value="textarea">大文本框</option>
								<option value="select">下拉选择框</option>
						</select></td>
					</tr>
					<tr id="fldTagTypeTR">
						<td class="aname">标签类型</td>
						<td><select name="fldTagType" id="fldTagType"
							onchange="changeOption(this);" style="height: 30px;">
								<option value="text">文本</option>
						</select></td>
					</tr>
					<tr id="tagAdditionalTR" style="display: none;">
						<td class="aname">标签补充</td>
						<td><textarea rows="5" cols="30" name="tagAdditional"></textarea>
						</td>
					</tr>
					<tr id="tagdefaultValueTR">
						<td class="aname">标签默认值</td>
						<td><input type="text" name="tagdefaultValue" /></td>
					</tr>
					<tr id="topTR">
						<td class="aname">置顶</td>
						<td><input type="radio" name="top" onclick="toTop(this)"
							value="1" />是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio"
							name="top" value="0" checked="checked" />否</td>
					</tr>
					<tr id="fldIsEnterTR">
						<td class="aname">是否录入显示</td>
						<td><input type="radio" name="fldIsEnter" value="1"
							checked="checked" />是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
							type="radio" name="fldIsEnter" value="0" />否</td>
					</tr>
					<tr>
						<td colspan="2" class="btnGroup" align="center"><input
							type="submit" value="保存"
							style="display: inline-block; width: 120px; height: 35px; text-align: center; line-height: 35px; margin-right: 10px; color: #fff; background: #5cb819;">
							<input type="reset" value="重置"
							style="display: inline-block; width: 120px; height: 35px; text-align: center; line-height: 35px; margin-right: 10px; color: #fff; background: #0D4DA5;">
							<input type="button" value="取消" onclick="history.go('-1')"
							style="display: inline-block; width: 120px; height: 35px; text-align: center; line-height: 35px; margin-right: 10px; color: #fff; background: #666666;"></td>
					</tr>
				</table>
				<input type="hidden" name="resId" value="${ResId}" />
			</form>
		</div>
		<!--con-->
	</div>
	<!--YJ2016_HTmain-->
</body>
</html>