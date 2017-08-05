<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% 
    String context = request.getContextPath();
    request.setAttribute("context",context);
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<link rel="stylesheet" type="text/css" href="${context}/css/mainHT.css">
	<script type="text/javascript">
		function checktosubmit(){
			var column_name = document.getElementById("column_name").value;
			var tag = true;
			if(txt_firstname.length == 0)
			{
				alert(document.getElementById("column_name").name+"不能为空");
				tag = false;
			}
			if(tag == true){
				document.getElementById("saveCol").submit();
			}
		}
	</script>

</head>
<body>
    <!-- 引入头部 -->
    <%-- <jsp:include page="../include/top.jsp"></jsp:include> --%>
  <%--   <div class="YJ2016_HTRote">
    	<a href="${context}/DBM/resourceManage.html">首页</a>&nbsp;&nbsp;&gt;&nbsp;&nbsp;<span>资源管理</span>
    </div> --%>
    <div class="YJ2016_HTmain YJ2016_clearfix ">
    	<!-- 左侧菜单 -->
		<%-- <jsp:include page="../include/leftMenu.jsp"></jsp:include> --%>
        <div class="con userCon">
        		<div class="HDZJ2016ht_MBX">
		现在的位置：&nbsp;<a href="subOp-00.html">功能管理</a>
		<c:forEach var="OpInfo" items="${supList}">    
	       &nbsp;&gt;&gt;&nbsp;<a href="subOp-${OpInfo.opId}.html">${OpInfo.opName}</a>
	   </c:forEach>&nbsp;&gt;&gt;&nbsp;新增功能
	</div>
	<div align="center">
		<c:if test="${!empty errorMsg}">
		   <div class="HDZJ2016ht_h2">${errorMsg}</div>
		</c:if>
	</div>
	
		<form id="saveCol"  action="${context}/manage/authority/saveOp.html" method="post">
			<table class="HDZJ2016ht_TB1" style="width: 70%">
				<tr style="display:none">
					<td>opId:</td>
					<td><input type="text" name="opId" value="${nextId}"/></td>
				</tr>
				<tr style="display:none">
					<td>opType:</td>
					<td><input type="text" name="opType" value="${opType }"/></td>
				</tr>
				<tr>
					<td class="td1">名称:</td>
					<td><input class="input1" type="text" id="column_name" name="opName" ></td>
				</tr>
				<tr>
					<td class="td1">描述:</td>
					<td><input class="input1" type="text" id="column_name" name="opDesc" ></td>
				</tr>
				<tr>
					<td class="td1">url:</td>
					<td><input class="input1" type="text" id="column_name" name="opUrl" ></td>
				</tr>
				<tr>
					<td class="td1">是否启用:</td>
					<td><input  type="radio"  name="opEnable"  value="1"  checked="true" >是
						<input  type="radio"  name="opEnable"  value="0"  >否
					</td>
				</tr>
			</table>
			<div style="text-align: center">
				<input class="HDZJ2016ht_button2" type="submit"  value="确认"/>
			</div>
		</form>
            
            
        </div><!--con-->
    </div><!--YJ2016_HTmain-->
    
    
</body>
</html>