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
		var types = "${IPAuthority.authorityType}".split(",");
		var typesHTML = "";
		var checked=""
		<c:forEach items="${typeList}" var="item" varStatus="status">
			for(var i=0;i<types.length;i++){
				if("${item.typeId}" == types[i]){
					checked="checked='true'";
				}
			}
	    	if("${status.index}"%2 == 0){
	    		typesHTML += "<input  type='checkbox' name='authorityType' "+checked+" value='${item.typeId}'/>${item.name}";
	    	}else{
	    		typesHTML += "<input  type='checkbox' name='authorityType' "+checked+" style='margin-left: 10%'  value='${item.typeId}'/>${item.name}<br>";
	    	};
	    	checked="";
		</c:forEach>
		$("#quanxian").append(typesHTML);
	});  
	 
	  function update(){
		 var beginIp = document.getElementById("beginIp").value;
		 var endIp = document.getElementById("endIp").value;
		 var types1 = "";
		 var authorityType = document.getElementsByName("authorityType");
		 for(var i=0;i<authorityType.length;i++){
			 if(authorityType[i].checked){
				types1 += authorityType[i].value+",";
			 };
		 };
		 types1 = types1.substring(0,types1.length-1);
		 
		 if(!check(beginIp,endIp)){
			 return;
		 };
		 
		 //后台修改
		 $.post("${context}/manage/IPAuthority/updateIPAuthority.html", {id:"${IPAuthority.id}",beginIp:beginIp,endIp:endIp,types:types1}, 
				 function(data) {
			 		if(data="success"){
			 			alert("修改成功！");
			 		}else{
			 			alert("修改失败！");
			 		};
			 		window.location.href="${context}/manage/IPAuthority/toList.html";
		 }, "text");
		 
	 }
	 function check(beginIp,endIp){
		 var ip = /^\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}$/;
		 if(!ip.test(beginIp)){
			 alert("请输入正确的开始IP地址");
			 return false;
		 };
		 if(!ip.test(endIp)){
			 alert("请输入正确的结束IP地址");
			 return false;
		 };
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
		<div class="con" align="center"  style="float: left;margin-left: 4%">
			<div class="HTnd1" style="display: inline-block;" style="margin-right: 100%;">
            	<span class="setTit">修改IP用户权限</span>
                <div class="HTnd_gdmod" >
                	<p><span >开始IP：</span><input  type="text" name="beginIp" id="beginIp" value="${IPAuthority.beginIp}" style="width:60%;"/><strong>*</strong></p>
                	<p><span>结束IP：</span><input  type="text" name="endIp" id="endIp" value="${IPAuthority.endIp}" style="width:60%;"/><strong>*</strong></p>
                	<p><span style="width: 30%;hidth:200px">权限设置：</span><span style="width:65%;"><strong>"√"表示选中</strong></span></p>
                	<span id="quanxian"></span>
                	<!-- <input  type="checkbox" name="authorityType"  value="1"/>栏目访问
                	<input  type="checkbox" name="authorityType" style="margin-left: 10%" value="2"/>文件下载<br>
                	<input  type="checkbox" name="authorityType"  value="3"/>栏目访问
                	<input  type="checkbox" name="authorityType" style="margin-left: 10%" value="4"/>文件下载<br> -->
                    <span class="mod_btn" style="text-align: center">
                    	<a href="javascript:update();">完成</a>
                    	<a href="${context}/manage/IPAuthority/toList.html">返回</a>
                    	<input type="hidden" id="types" name="types">
                    </span>
                </div>
            </div>
    </div>
    </div>
	<!--con-->
	<!--YJ2016_HTmain-->
</body>
</html>