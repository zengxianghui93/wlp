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
<title>数据任务添加_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script src="${context}/js/jquery.artDialog.source.js" type="text/javascript"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript" src="${context}/js/WdatePicker.js"></script>
<script type="text/javascript">
var checkUsers = "";//待审核的资源库
var updateUsers = "";//所有资源库
var taskCheckUsers = "";//所有的数据审核员
var taskUpdateUsers = "";//所有的数据编辑员
var dataNum = 0;//统计的数量
$(function(){
	//初始化资源库信息
	<c:forEach items="${resChecks}" var="item" varStatus="status">
		checkUsers += '<option value="${item.resTblName}">${item.resName}</option>';
	</c:forEach>
	<c:forEach items="${resAll}" var="item" varStatus="status">
		updateUsers += '<option value="${item.resTblName}">${item.resName}</option>';
	</c:forEach>
	$("#taskTableName").html(checkUsers);
	
	//初始化用户信息
	<c:forEach items="${taskCheckUsers}" var="item" varStatus="status">
		taskCheckUsers += '<option value="${item.userId}">${item.userName}</option>';
	</c:forEach> 
	<c:forEach items="${taskUpdateUsers}" var="item" varStatus="status">
		taskUpdateUsers += '<option value="${item.userId}">${item.userName}</option>';
	</c:forEach> 
	$("#taskUserId").html(taskCheckUsers);
	
	//初始化用户名称
	var obj = document.getElementById("taskUserId"); 
	selTaskUserName(obj.options[obj.selectedIndex].text);
	
	//初始化资源库
	var obj2 = document.getElementById("taskTableName"); 
	selFld(obj2.options[obj2.selectedIndex].value);
	
	//初始化方式
	var obj3 = document.getElementById("taskWay"); 
	selTypeType(obj3.options[obj3.selectedIndex].value);
});

function selFld(resTblName){
	var resId;
	<c:forEach items="${resAll}" var="item" varStatus="status">
		if(resTblName=="${item.resTblName}"){
			resId = "${item.resId}";
		}
	</c:forEach>
	$.ajax({
		async:true,
		//dataType:"",
		type:"get",
		url:"${context}/manage/taskData/getFldByresId.html",
		data:{"resId":resId},
		success:function(data){
			if(data.length==0){
				$("#taskResFldName").html("<option value=''>无列</option>");
				$("#taskResKeyword").attr("disabled",true);
			}else{
				var options = "";
				for(var i=0;i<data.length;i++){
					options += "<option value='"+data[i].fldName+"'>"+data[i].fldDesc+"</option>";
				}
				$("#taskResFldName").html(options);
				$("#taskResKeyword").attr("disabled",false);
			}
		}
	});
	getNoCheckNum();
}

//选择不同任务类型时显示相应的资源库和用户
function selTableName(typeId){
	if(typeId=='1'){
		$("#taskTableName").html(checkUsers);
		if(taskCheckUsers==""){
			$("#taskUserId").html('<option value="">无</option>');
		}else{
			$("#taskUserId").html(taskCheckUsers);
		}
	}else if(typeId=='2'){
		$("#taskTableName").html(updateUsers);
		if(taskUpdateUsers==""){
			$("#taskUserId").html('<option value="">无</option>');
		}else{
			$("#taskUserId").html(taskUpdateUsers);
		}
	}
}

function selTaskUserName(taskUserName){
	$("#taskUserName").val(taskUserName);
}



function submitForm(){
	if(!checkForm()){
		return false;
	};
	document.form1.submit();
}

function checkForm(){
	var taskWay = $("#taskWay").val();
	var taskName = $("#taskName").val().trim();
	var resBegin = $("#resBegin").val();
	var resEnd = $("#resEnd").val();
	var handBeginTime2 = $("#handBeginTime2").val();
	var handEndTime2 = $("#handEndTime2").val();
	var taskUser = $("#taskUserId").val();
	var taskResNums = $("#taskResNums").val().trim();
	var exp = /^[0-9]{1,}$/;
	if(taskUser==""){
		alert("请添加处理人");
		return false;
	}
	if(taskName==""){
		alert("请输入任务名称");
		return false;
	}
	
	if(taskWay=="1"){
		if(resBegin==""){
			alert("请输入文章开始id");
			return false;
		}
		if(resEnd==""){
			alert("请输入文章结束id");
			return false;
		}
		if(resBegin*1==0||resEnd*1==0){
			alert("请输入大于0的数量");
			return false;
		}
		if(!exp.test(resBegin)||!exp.test(resEnd)){
			alert("请输入正确文章id");
			return false;
		}
		if(resBegin*1>resEnd*1){
			alert("文章开始id不能大于结束id");
			return false;
		}
		
	}else{
		if(!exp.test(taskResNums)){
			alert("请输入正确数量");
			return false;
		}
		if(taskResNums*1==0){
			alert("请输入大于0的数量");
			return false;
		}
	}
	
	if(handBeginTime2==""){
		alert("请输入处理开始日期");
		return false;
	}
	
	if(handEndTime2==""){
		alert("请输入处理结束日期");
		return false;
	}
	if(handBeginTime2>handEndTime2){
		alert("处理开始日期不能大于结束日期");
		return false;
	}
	return true;
}

//判断数量是否正确输入
function isNum(){
	var exp = /^[0-9]{1,}$/;
	var str = $("#taskResNums").val().trim();
	if(str=="")	return;
	if(!exp.test(str)){
		alert("请输入数字");
		$("#taskResNums").val("");
	}
	if(str*1>dataNum){
		alert("请输入小于统计数量的数字");
		$("#taskResNums").val("");
	}
}

//根据信息获取未审核的总数
function getNoCheckNum(){
	$("#allNums").text("(总数:统计中)");
	var taskType = $("#taskType").val();
	var resTalbeName = $("#taskTableName").val();
	var isGather = $("#taskIsGather").val();
	var keyword = $("#taskResKeyword").val().trim();
	var fldName = $("#taskResFldName").val();
	$.ajax({
		async:true,
		//dataType:"",
		type:"get",
		url:"${context}/manage/taskData/getNoCheckNum.html",
		data:{"resTalbeName":resTalbeName,"isGather":isGather,"keyword":keyword,"fldName":fldName,"taskType":taskType},
		success:function(data){
			dataNum = data;
			$("#allNums").text("(总数:"+data+")");
		}
	});
}

//判断方式
function selTypeType(value){
	if(value=="2"){
		$("#p1").show();
		$("#p2").show();
		$("#p3").show();
		$("#p4").hide();
	}else if(value=="1"){
		$("#p1").hide();
		$("#p2").hide();
		$("#p3").hide();
		$("#p4").show();
	}
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
            	<span class="setTit">数据任务添加</span>
                <div class="HTnd_gdmod">
                <form name="form1" action="${context}/manage/taskData/taskDataAdd.html"
					method="post" enctype="multipart/form-data">
               		<p><span style="margin-left: -5%;width:20%">任务名称：</span><input type="text" name="taskName" id="taskName" value="${article.orderNumber}" /></p>
               		<p><span style="margin-left: -5%;width:20%">任务类型：</span>
               			<select name="taskType" id="taskType" style="width: 420px" onchange="selTableName(options[selectedIndex].value)">
							<c:forEach items="${taskTypes}" var="item" varStatus="status">
								<option value="${item.typeId}">${item.typeName}</option>
							</c:forEach> 
						</select></p>
                	<p><span style="margin-left: -5%;width:20%">任务描述：</span><textarea name="taskDesc" cols="57" rows="5" >${article.articlAbstract}</textarea></p>
                	<p><span style="margin-left: -5%;width:20%">资源库：</span><select style="width: 420px"  name="taskTableName" id="taskTableName" onchange="selFld(options[selectedIndex].value)"></select></p>
                	<p><span style="margin-left: -5%;width:20%">方式：</span><select style="width: 420px" name="taskWay" id="taskWay" onchange="selTypeType(options[selectedIndex].value)"><option value="1">范围</option><option value="2">数量</option></select></p>
                	<p id="p1"><span style="margin-left: -5%;width:20%">采集类型：</span><select style="width: 420px"  name="taskIsGather" id="taskIsGather" onchange="getNoCheckNum()">
                			<option value="">所有数据</option>
                			<option value="0">采集数据</option>
                			<option value="1">本地数据</option>
                		</select></p>
                	<p id="p2"><span style="margin-left: -5%;width:20%"><select name="taskResFldName" id="taskResFldName"><option>标题</option><option>正文</option></select></span><input name="taskResKeyword" id="taskResKeyword" onblur="getNoCheckNum()"/></p>
                	<p id="p3"><span style="margin-left: -5%;width:20%">数量：</span><input type="text" style="width: 307px" name="taskResNums" id="taskResNums" onkeyup="isNum()"/><span id="allNums" style="width:100px">(总数:统计中)</span></p>
                	<p><span style="margin-left: -5%;width:20%">处理人：</span>
						<select name="taskUserId" id="taskUserId" style="width: 420px" onchange="selTaskUserName(options[selectedIndex].text)">
						</select>
						<input type="hidden" name="taskUserName" id="taskUserName"/>
						</p>
                	<p id="p4"><span style="margin-left: -5%;width:20%">id范围：</span><input style="width: 185px" type="text" name="resBegin" id="resBegin"/>&nbsp;至&nbsp;<input style="width: 185px" name="resEnd" type="text" id="resEnd"/></p>
                	<p><span style="margin-left: -5%;width:20%">处理时间：</span><input style="width: 185px" type="text" onClick="WdatePicker()" class="Wdate" name="handBeginTime2" id="handBeginTime2"/>&nbsp;至&nbsp;<input style="width: 185px" name="handEndTime2" id="handEndTime2" type="text" onClick="WdatePicker()" class="Wdate"/></p>
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