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
		$("#table1").children("tbody").eq(1).children("tr").each(function() {
			//翻译拥有权限
			var allAuthority = "";//定义拥有的权限
			var strs = new Array(); //定义一数组 
			strs = $(this).children("td").eq(3).text().split(","); //字符分割 
			for (i = 0; i < strs.length; i++) {
				<c:forEach items="${typeList}" var="item" varStatus="status">
					if (strs[i] == "${item.typeId}") {
						if(allAuthority != ""){
							allAuthority += ",${item.name}"
						}else{
							allAuthority += "${item.name}"
						}
					}
				</c:forEach>
			}
			$(this).children("td").eq(3).text(allAuthority);
		});
		
		//权限内容
		var typesHTML = "";
		<c:forEach items="${typeList}" var="item" varStatus="status">
	    	if("${status.index}"%2 == 0){
	    		typesHTML += "<input  type='checkbox' name='authorityType' style='margin-left: 30%' value='${item.typeId}'/>${item.name}";
	    	}else{
	    		typesHTML += "<input  type='checkbox' name='authorityType' style='margin-left: 10%'  value='${item.typeId}'/>${item.name}<br>";
	    	};
	    	checked="";
		</c:forEach>
		$("#quanxian").append(typesHTML);
		
		//选择页数的跳转
		var options = '';
		for(var i=0;i<"${pagedIPAuthorities.totalPageCount}"*1;i++){
			if((i+1) == "${pagedIPAuthorities.currentPageNo}"){
				options += '<option selected="selected" value="${context}/manage/IPAuthority/toList.html?pageNo='+(i+1)+'">'+(i+1)+'</option>';
			}else{
				options += '<option value="${context}/manage/IPAuthority/toList.html?pageNo='+(i+1)+'">'+(i+1)+'</option>';
			}
		}
		$("#currentPageNoSelect").html(options);
	}); 
	 
	 function add(){
		 var beginIp = document.getElementById("beginIp").value;
		 var endIp = document.getElementById("endIp").value;
		 var types = "";
		 var authorityType = document.getElementsByName("authorityType");
		 for(var i=0;i<authorityType.length;i++){
			 if(authorityType[i].checked){
				types += authorityType[i].value+",";
			 };
		 };
		 types = types.substring(0,types.length-1);
		 
		 if(!check(beginIp,endIp)){
			 return;
		 };
		 
		 //后台添加
		 $.post("${context}/manage/IPAuthority/addIPAuthority.html", {beginIp:beginIp,endIp:endIp,types:types}, 
				 function(data) {
					window.location.href="${context}/manage/IPAuthority/toList.html";
		 }, "text");
		 
	 }
	 
	 function deleteIP(id){
		 if(confirm("您确定要删除这一条记录吗？")){
			 $.post("${context}/manage/IPAuthority/deleteIPAuthority.html", {id:id}, 
					 function(data) {
						window.location.href="${context}/manage/IPAuthority/toList.html";
			 }, "text");
		 }
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
		<div class="con" style="float: left;margin-left: 4%">
        	<div class="HTc1">
			<div class="addBtn">
            	<a href="javascript:void(0)" class="addBtn1">新增IP权限</a>
            </div>
			<table id="table1" style="text-align: center;margin-top: 10px;">
				<tbody style="width: 200px;">
					<tr class="cTitle">
						<td class="ct1">序号</td>
						<td class="ct1">开始ip</td>
						<td class="ct2">结束ip</td>
						<td class="ct3">拥有权限</td>
						<td class="ct4">操作</td>
					</tr>
				</tbody>
				<c:forEach var="item" items="${pagedIPAuthorities.result}" varStatus="status">
					<tr>
						<td class="ct1" style="width:10%">${(pagedIPAuthorities.currentPageNo-1)*10+status.index+1}</td>
						<td class="ct1" style="width:15%">${item.beginIp}</td>
						<td class="ct2" style="width:15%">${item.endIp}</td>
						<td class="ct3" style="width:45%">${item.authorityType}</td>
						<td class="ct4">
							<a href="${context}/manage/IPAuthority/toIPAuthorityUpdate.html?id=${item.id}" class="addBtn2">修改&nbsp;</a>|
							<a href="javascript:void(0)" onclick="deleteIP(${item.id})">删除</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div class="notePage">
				 <div class="page">
                                     共<span>${pagedIPAuthorities.totalCount}</span>条记录&nbsp;&nbsp; <span>${pagedIPAuthorities.currentPageNo}/${pagedIPAuthorities.totalPageCount}</span>页
                    
                   	<c:if test="${pagedIPAuthorities.currentPageNo <=1}">首页</c:if>
                   	<c:if test="${pagedIPAuthorities.currentPageNo >1 }">
						<a href="${context}/manage/IPAuthority/toList.html?pageNo=1" style="margin-right:5px;">首页</a>
					</c:if>
                   	
                   	<c:if test="${!pagedIPAuthorities.hasPreviousPage}">上一页</c:if>
					<c:if test="${pagedIPAuthorities.hasPreviousPage}">
				    	  <a href="${context}/manage/IPAuthority/toList.html?pageNo=${pagedIPAuthorities.currentPageNo -1 }" style="margin-right:5px;">上一页</a>
				    </c:if>
				    
					<c:if test="${!pagedIPAuthorities.hasNextPage}">下一页</c:if>
					<c:if test="${pagedIPAuthorities.hasNextPage}">
				   		<a href="${context}/manage/IPAuthority/toList.html?pageNo=${pagedIPAuthorities.currentPageNo +1 }" style="margin-right:5px;">下一页</a>
				    </c:if>
                   
                   	<c:if test="${pagedIPAuthorities.currentPageNo >= pagedIPAuthorities.totalPageCount}">尾页</c:if>
					<c:if test="${pagedIPAuthorities.currentPageNo < pagedIPAuthorities.totalPageCount}">
						<a href="${context}/manage/IPAuthority/toList.html?pageNo=${pagedIPAuthorities.totalPageCount }" style="margin-right:5px;">尾页</a>
					</c:if>
                    
                   	 第
                    <select onchange="self.location.href= options[selectedIndex].value" id="currentPageNoSelect"></select>页              
            </div>
			</div>
		</div>
	<div class="HTnd1">
            <form name="xinjian" action="${context}/manage/IPAuthority/addIPAuthority.html" method="post"  enctype="multipart/form-data">
            	<span class="setTit">新建IP用户权限</span>
                <div class="HTnd_gdmod">
                	<p><span>开始IP：</span><input  type="text" name="beginIp" id="beginIp" style="width:60%;"/><strong>*</strong></p>
                	<p><span>结束IP：</span><input  type="text" name="endIp" id="endIp" style="width:60%;"/><strong>*</strong></p>
                	<p><span style="width: 30%;hidth:200px">权限设置：</span><strong>"√"表示选中</strong></p>
                	<span id="quanxian"></span>
                    <span class="mod_btn" style="text-align: center">
                    	<a href="javascript:add();">新增</a>
                    	<a href="${context}/manage/IPAuthority/toList.html">返回</a>
                    	<input type="hidden" id="types" name="types">
                    </span>
                </div>
                </form>
            </div>
    </div>
	</div>
	<!--con-->
	<!--YJ2016_HTmain-->
</body>
</html>