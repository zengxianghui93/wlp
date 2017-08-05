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
<link rel="stylesheet" type="text/css" href="${context}/css/mainHT.css">
<link type="text/css" rel="stylesheet" href="${context}/css/zhuanti1.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript" src="${context}/js/WdatePicker.js"></script>
</head>
<body>
    <!-- 引入头部 -->
  <%--   <jsp:include page="../include/top.jsp"></jsp:include> --%>
  <%--   <div class="YJ2016_HTRote">
    	<a href="${context}/DBM/resourceManage.html">首页</a>&nbsp;&nbsp;&gt;&nbsp;&nbsp;<span>资源管理</span>
    </div> --%>
    <div class="YJ2016_HTmain YJ2016_clearfix ">
    	<!-- 左侧菜单 -->
	<%-- 	<jsp:include page="../include/leftMenu.jsp"></jsp:include> --%>
        <div class="con userCon">
        	<div class="HDZJ2016ht_MBX">
				现在的位置：&nbsp;<a href="subOp-00.html">功能管理</a>
				<c:forEach var="OpInfo" items="${supList}">    
			       &nbsp;&gt;&gt;&nbsp;<a href="subOp-${OpInfo.opId}.html">${OpInfo.opName}</a>
			   </c:forEach>&nbsp;&gt;&gt;&nbsp;编辑
			</div>
			<div align="center">
				<c:if test="${!empty errorMsg}">
				   <div class="HDZJ2016ht_h2">${errorMsg}</div>
				</c:if>
			</div>
			<div align="center" style="font-size: 25px;">
				<br />
				<h1>信息修改</h1>
				<br />
			</div>
			<form id="saveCol"  action="updateOp.html" method="post" style="p">
				<table  class="HDZJ2016ht_TB1" style="width: 70%">
					<tr style="display:none">
						<td>opId:</td>
						<td><input type="text" name="opId" value="${opInfo.opId}"/></td>
					</tr>
					<tr style="display:none">
						<td>opType:</td>
						<td><input type="text" name="opType" value="${opInfo.opType}"/></td>
					</tr>
					<tr style="display:none">
						<td>opEnable:</td>
						<td><input type="text" name="opEnable:" value="${opInfo.opEnable}"/></td>
					</tr>
					<tr>
						<td class="td1">名称:</td>
						<td><input  class="input1" type="text" name="opName" value="${opInfo.opName}" ></td>
					</tr>
					<tr>
						<td class="td1">描述:</td>
						<td><input  class="input1" type="text" name="opDesc" value="${opInfo.opDesc}" ></td>
					</tr>
					<tr>
						<td class="td1">url:</td>
						<td><input  class="input1" type="text" name="opUrl" value="${opInfo.opUrl}" ></td>
					</tr>
					<tr>
						<td class="td1">是否启用:</td>
						<td><input type="radio" name="opEnable" value="1" <c:if test="${opInfo.opEnable==1}">checked="true"</c:if> >是
							<input type="radio" name="opEnable" value="0" <c:if test="${opInfo.opEnable==0}">checked="true"</c:if> >否
						</td>
					</tr>
				</table>
				<div style="text-align: center;margin-bottom: 10px;margin-top: 10px;">	
					<input class="HDZJ2016ht_button2" type="submit"  value="确认"/>
				</div>
				
			</form>


        </div><!--con-->
    </div><!--YJ2016_HTmain-->              
</body>
</html>