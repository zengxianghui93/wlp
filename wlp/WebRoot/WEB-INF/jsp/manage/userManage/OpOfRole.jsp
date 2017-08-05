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
<title>用户管理_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<link rel="stylesheet" type="text/css" href="${context}/css/mainHT.css">
<link type="text/css" rel="stylesheet" href="${context}/css/zhuanti1.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script language="JavaScript" src="${context}/js/authority.js?20070509"></script>
</head>
<body>
	<!-- 引入头部 -->
	<%-- <jsp:include page="../include/top.jsp"></jsp:include>
    <div class="YJ2016_HTRote">
    	<a href="${context}/DBM/resourceManage.html">首页</a>&nbsp;&nbsp;&gt;&nbsp;&nbsp;<span>资源管理</span>
    </div> --%>
	<div class="YJ2016_HTmain YJ2016_clearfix ">
		<!-- 左侧菜单 -->
		<%-- <jsp:include page="../include/leftMenu.jsp"></jsp:include> --%>
		<div class="con userCon">
			<form id="form1" method="post" action="setRoleOP.html">
				<input type="hidden" name="roleId" value="${roleId}" />
				<div style="text-align: center">
					<div align="center" style="font-size: 25px;">
						<br />
						<h1>指定角色的功能</h1>
						<br />
					</div>
					<table>
						<tr style="background-color: #cccccc"><td>系统的全部功能</td><td></td><td>当前角色的功能</td></tr>
						<tr>
<!-- 							<td nowrap><legend>系统的功能</legend></td>
 -->							<td>
								<div>
									<select id="listSysOp" multiple="multiple"
										style="height: 360px; width: 200px">
										<c:forEach var="op" items="${OpList}">
											<option id="${op.opId}" value="${op.opId}">${op.opId}--${op.opName}</option>
										</c:forEach>
									</select>
								</div>
							</td>
							<td>
								<input type="button" OnClick="addSrcToDestList(listSysOp,listRoleOp)" value=" 添加到当前角色  >> " /><br />
								<br /> 
								<input type="button" OnClick="deleteFromDestList(listRoleOp)" value=" 从当前角色移除  << "   />

							</td>
							<td>
								<div>
									<select id="listRoleOp" name="listRoleOp" multiple="multiple"
										style="height: 360px; width: 200px">
										<c:forEach var="op" items="${roleOpList}">
											<option id="${op[0].opId}" value="${op[0].opId}">${op[0].opId}${op[0].opName}</option>
										</c:forEach>
									</select>
								</div></td>
						</tr>
					</table>
					<table width="90%" align=center>
						<tr>
							<td width="*" align="center" style="height:50px;">
								<input class="HDZJ2016ht_button2" type="submit" onClick="selectall(listRoleOp)" value="确认" /> 
								<input class="HDZJ2016ht_button2" type="button" onClick="history.go(-1)" value="取消" />
							</td>
						</tr>
					</table>
				</div>
			</form>
		</div>

	</div>
	<!--con-->
	</div>
	<!--YJ2016_HTmain-->
</body>
</html>