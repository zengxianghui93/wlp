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
<title>刊名添加_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script src="${context}/js/jquery.artDialog.source.js" type="text/javascript"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript" src="${context}/js/WdatePicker.js"></script>
<script type="text/javascript">
function submitForm(){
	if(document.getElementById("name").value.trim()==''){
		alert("请输入名称");
		return;
	}
	document.form1.submit();
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
		<div class="con" align="center"  style="float: left;margin-left: 4%">
			<div class="HTnd1" style="display: inline-block;" style="margin-right: 100%;">
            	<span class="setTit">刊名添加</span>
                <div class="HTnd_gdmod">
                <form name="form1" action="${context}/manage/JournalMaintain/journalMaintainAu.html"
					method="post" enctype="multipart/form-data">
					<input type="hidden" value = "${journalMaintain.id}" name="id"/>
					<input type="hidden" value = "${pageNo}" name="pageNo"/>
					<input type="hidden" value = "${name1}" name="name1"/>
					<input type="hidden" value = "${type1}" name="type1"/>
               		<p><span style="margin-left: -5%;width:20%">名称：</span><input type="text" name="name" id="name" value="${journalMaintain.name}" /></p>
               		<p><span style="margin-left: -5%;width:20%">所属库：</span>
               			<select name="type" id="type" style="width: 420px">
							 <option value="1" <c:if test="${journalMaintain.type=='1'}">selected='selected'</c:if>>外文期刊</option>
							 <option value="2" <c:if test="${journalMaintain.type=='2'}">selected='selected'</c:if>>外文会议</option>
							 <c:if test="${journalMaintain.type!=null&&journalMaintain.type!='1'&&journalMaintain.type!='2'}"><option value="3" selected='selected'>其他</option></c:if>
						</select></p>
                	<span class="mod_btn" style="text-align: center">
                		<a href="javascript:void(0);" id="subForm" onclick="submitForm()">提交</a>
                    	<a href="javascript:void(0);" onclick="window.history.go(-1)">返回</a>
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