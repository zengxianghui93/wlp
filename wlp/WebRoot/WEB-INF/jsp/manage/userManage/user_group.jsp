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
<script type="text/javascript" src="${context}/js/authority.js?20070509"></script>
</head>
<body>
  <%--   <div class="YJ2016_HTRote">
    	<a href="${context}/DBM/resourceManage.html">首页</a>&nbsp;&nbsp;&gt;&nbsp;&nbsp;<span>资源管理</span>
    </div> --%>
	<div class="YJ2016_HTmain YJ2016_clearfix ">
		<!-- 左侧菜单 -->
		<div class="con userCon">
			<form id="form1" method="post"
				action="${context}/manage/authority/setgroup.html">
				<input type="hidden" name="groupId" value="${groupId}" />
				<div style="text-align: center">
					<div align="center" style="font-size: 25px;">
						<br /><h1>设置用户组的用户</h1><br/>
					</div>
					<table>
						<tr>
							<td style="width: 80px;"><legend>系统用户</legend></td>
							<td>
								<div>
									<select id="listusergroup" multiple="multiple"
										style="height: 200px; width: 100px">
										<c:forEach var="uu" items="${UList}">
											<option id="${uu.userId}" value="${uu.userId}">${uu.userName}</option>
										</c:forEach>
									</select>
								</div></td>
							<td><input type="button" value=">>"
								OnClick="addSrcToDestList(listusergroup,listgroupuser)"
								alt="添加到用户角色" /><br /> <br /> <input type="button"
								value="<<"  OnClick="
								deleteFromDestList(listgroupuser)"  alt="从用户角色删除" /></td>
							<td style="width: 80px;"><legend>用户组用户</legend></td>
							<td>
								<div>
									<select id="listgroupuser" name="listgroupuser"
										multiple="multiple" style="height: 200px; width: 100px">
										<c:forEach var="uu" items="${UserList}">
											<option id="${uu.userId}" value="${uu.userId}">${uu.userName}</option>
										</c:forEach>
									</select>
								</div></td>
						</tr>
					</table>
					<table width="90%" align=center>
						<tr>
							<td width="*" align=center style="height:70px;">
								<input type="submit" onClick="selectall(listgroupuser)" value="确认" style="border: 0; background-color: #1377B3; padding: 7px 25px 9px 25px; font-family: Microsoft YaHei; font-size: 17px; color: #FFFFFF;"/> 
								<input type="button" onClick="history.go(-1)" value="取消" style="border: 0; background-color: #59A833; padding: 7px 25px 9px 25px; font-family: Microsoft YaHei; font-size: 17px; color: #FFFFFF;"/>
							</td>
						</tr>
					</table>
				</div>
			</form>
		</div>
	</div>
	<!--con-->
    </div><!--YJ2016_HTmain-->                
    <!-- 引入底部样式 -->
</body>
</html>