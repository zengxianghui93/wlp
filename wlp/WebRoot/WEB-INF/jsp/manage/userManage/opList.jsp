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
<script type="text/javascript" src="${context}/js/WdatePicker.js"></script>
</head>
<body>
    <!-- 引入头部 -->
   <%--  <jsp:include page="../include/top.jsp"></jsp:include> --%>
   <%--  <div class="YJ2016_HTRote">
    	<a href="${context}/DBM/resourceManage.html">首页</a>&nbsp;&nbsp;&gt;&nbsp;&nbsp;<span>资源管理</span>
    </div> --%>
     <div class="YJ2016_HTmain YJ2016_clearfix ">
    	<!-- 左侧菜单 -->
		<%-- <jsp:include page="../include/leftMenu.jsp"></jsp:include> --%>
        <div class="con userCon">
        	<div class="">
        		<div class="HDZJ2016ht_MBX">
				现在的位置：&nbsp;<a href="subOp-00.html">功能管理</a>
				<c:forEach var="OpInfo" items="${supList}">    
			       &nbsp;&gt;&gt;&nbsp;<a href="subOp-${OpInfo.opId}.html">${OpInfo.opName}</a>
			   	</c:forEach>&nbsp;&gt;&gt;&nbsp;列表
				</div>
        	<div class="userbtn">
            	<a href="${context}/manage/authority/addOp-${supId}.html" class="useradd">添加</a>
         	</div>
        <table class="userTable" style="margin-top: 10px;">
            	<tr class="cTitle">
                	<td class="ct1">功能</td>
                    <td class="ct4">url</td>
                    <td class="ct1">编辑</td>
                    <td class="ct1">删除</td>
                </tr>
                <c:forEach var="OpInfo" items="${subList}">
	                <tr>
					<td class="ct1"><a style="width:100%;color:#3875b8;" href="${context}/manage/authority/subOp-${OpInfo.opId}.html">${OpInfo.opName}</a></td>								
					<td class="ct4">${OpInfo.opUrl}</td>				
					<td class="ct1"><a href="editOp-${OpInfo.opId}.html" style="color:#3875b8;">编辑</a></td>
					<td class="ct1"><a href="delOp-${OpInfo.opId}.html" onClick="return confirm('确实想删除吗？')" style="color:red;">删除</a></td>
				    </tr>
			    </c:forEach>        
         </table>	
         </div>
        </div><!--con-->
    </div><!--YJ2016_HTmain-->          
</body>
</html>