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
<title>报告模板管理_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript" src="${context}/js/WdatePicker.js"></script>
<script>
function checkjine() {
	if (document.form1.wf_money.value == "") {
		alert("请输入金额");
		document.form1.wf_money.focus();
		return false;
	}
	//以字母或数字开头，跟上@,   /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/
	var expr = /^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/;
	var re = new RegExp(expr)
	if (!re.test(document.form1.wf_money.value)) {
		alert("输入的金额格式有误！");
		document.form1.wf_money.focus();
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
		if(checkjine()==false){ return false };
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
				<span class="setTit">科技查新处理</span>
				<div class="HTnd_gdmod">
					<form name="form1"
						action="${context}/manage/onlineupdate-${online.id}.html"
						method="post" enctype="multipart/form-data">
						<p>
							<span style="margin-left: -5%; width: 20%">用户名：</span><input
								type="text" readonly="readonly" value="${online.username}" />
						</p>
						<p>
							<span style="margin-left: -5%; width: 20%">项目名称：</span><input
								type="text" readonly="readonly" value="${online.wf_projectname}" />
						</p>
						<p>
							<span style="margin-left: -5%; width: 20%">项目名称(英文)：</span><input
								type="text" readonly="readonly"
								value="${online.wf_projectnameEnglish}" />
						</p>
						<p>
							<span style="margin-left: -5%; width: 20%">机构名称：</span><input
								type="text" readonly="readonly" value="${online.wf_institution}" />
						</p>
						<p>
							<span style="margin-left: -5%; width: 20%">通信地址：</span><input
								type="text" readonly="readonly" value="${online.wf_address}" />
						</p>
						<p>
							<span style="margin-left: -5%; width: 20%">联系人：</span><input
								type="text" readonly="readonly" value="${online.wf_contact}" />
						</p>
						<p>
							<span style="margin-left: -5%; width: 20%">电子邮箱：</span><input
								type="text" readonly="readonly" value="${online.wf_email}" />
						</p>
						<p>
							<span style="margin-left: -5%; width: 20%">电话：</span><input
								type="text" readonly="readonly" value="${online.wf_phone}" />
						</p>
						<p>
							<span style="margin-left: -5%; width: 20%">负责人：</span><input
								type="text" readonly="readonly" value="${online.wf_head}" />
						</p>
						<p>
							<span style="margin-left: -5%; width: 20%">邮政编码：</span><input
								type="text" readonly="readonly" value="${online.wf_zipcode}" />
						</p>
						<p>
							<span style="margin-left: -5%; width: 20%">传真：</span><input
								type="text" readonly="readonly" value="${online.wf_fax}" />
						</p>
						<p>
							<span style="margin-left: -5%; width: 20%">查新范围：</span><input
								type="text" readonly="readonly" value="${online.wf_searchscope}${online.wf_scopeof}" />
						</p>
						<p>
							<span style="margin-left: -5%; width: 20%">其他：</span><input
								type="text" readonly="readonly" value="${online.wf_other}" />
						</p>
						<p>
							<span style="margin-left: -5%; width: 20%">委托人提供的资料：</span><input
								type="text" readonly="readonly" value="${online.wf_data}" />
						</p>
						<p>
							<span style="margin-left: -5%; width: 20%">其他资料：</span><input
								type="text" readonly="readonly" value="${online.wf_weituoother}" />
						</p>
						<p>
							<span style="margin-left: -5%; width: 20%">发表论文：</span><input
								type="text" readonly="readonly" value="${online.wf_fabiao}" />
						</p>
						<p>
							<span style="margin-left: -5%; width: 20%">参考文献：</span><input
								type="text" readonly="readonly" value="${online.wf_cankao}" />
						</p>
						<p>
							<span style="margin-left: -5%; width: 20%">份数：</span><input
								type="text" readonly="readonly" value="${online.wf_share}" />
						</p>
						<p>
							<span style="margin-left: -5%; width: 20%">密级：</span><input
								type="text" readonly="readonly" value="${online.wf_secret}" />
						</p>
						<p>
							<span style="margin-left: -5%; width: 20%">中英文检索词：</span><input
								type="text" readonly="readonly" value="${online.wf_jiansuo}" />
						</p>
						<p>
							<span style="margin-left: -5%; width: 20%">要求完成日期：</span><input
								type="text" readonly="readonly" value="${online.wf_datetmie}" />
						</p>
						<p>
							<span style="margin-left: -5%; width: 20%">备注：</span><input
								type="text" readonly="readonly" value="${online.wf_beizhu}" />
						</p>
						<p>
							<span style="margin-left: -5%; width: 20%">上传时间：</span><input
								id="flag" type="text" readonly="readonly" value="${online.createTime}" />
						</p>
						<div>
							<span style="margin-left: -5%; width: 20%">查新要点：</span>
							<textarea name="aaaa" readonly="readonly" class="ckeditor textarea1">${online.wf_technicalpoints}</textarea>
						</div>
						<div>
							<span style="margin-left: -5%; width: 20%">查新亮点：</span>
							<textarea name="bbbb" readonly="readonly" class="ckeditor textarea1">${online.wf_chaxindian}</textarea>
						</div>
							<p>
							<span style="margin-left: -5%; width: 20%">付费金额：</span><input
								type="text" name="wf_money" value="${online.wf_money}" />
						</p>
							<p>
							<span style="margin-left: -5%; width: 20%">实际完成日期：</span><input
								type="text" name="wf_datetmies" class="Wdate" onClick="WdatePicker()" value="${online.wf_datetmies}" />
						</p>
						<p>
							<span style="margin-left: -5%; width: 20%">付费日期：</span><input
								type="text" name="wf_newdate" class="Wdate" onClick="WdatePicker()" value="${online.wf_newdate}" />
						</p>
						<p>
							<span style="margin-left: -5%; width: 20%">处理状态修改：</span><select name="zhuantai">
								<c:forEach var="status" items="${status}" >
								<c:if test="${status.id==online.wf_kjcxstatus}"> 
								 <option selected="selected" value="${status.id}">${status.wf_kjcxstatus}</option>
								</c:if>
								<c:if test="${status.id!=online.wf_kjcxstatus}">
								 <option value="${status.id}">${status.wf_kjcxstatus}</option>
								</c:if>
							    </c:forEach>
						</select>
						</p>
						<span class="mod_btn" style="text-align: center"> <a
							href="javascript:document:form1.submit();" onclick=" return checkform()">提交</a>
							<a href="javascript:void(0);" onclick="history.go(-1)">返回</a>
						</span>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!--con-->
	<!--YJ2016_HTmain-->
</body>
</html>