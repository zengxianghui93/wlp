<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String context = request.getContextPath();
	request.setAttribute("context", context);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑角色预览原文页数</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script src="${context}/js/jquery.artDialog.source.js" type="text/javascript"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
</head>
<body>
	<div class="YJ2016_HTmain YJ2016_clearfix ">
		
		<div class="con userCon" style="float: left;margin-left: 4%">
			<form onsubmit="return checkForm();" action="${context}/roleOriginal/add.html" method="post">
				<table class="userTable" style="margin-top: 1%;margin-left: 2%;width: 90%">
					<tr class="cTitle">
						<td class="ct1">角色</td>
						<td class="ct3">原文可预览页数</td>
					</tr>
					<tr>
						<td class="ct1" style="width:10%">${role.roleName}<input type="hidden" name="roleId" value="${role.roleId}"/></td>
						<td class="ct4" style="width:10%"><input style="border: 1px solid;height:25px" type="text" name="number" value="${roleOriginal.number}"/></td>
					</tr>
				</table>
				<div style="text-align: center;margin-bottom: 10px;margin-top: 10px;">
					<input class="HDZJ2016ht_button2" type="submit"  value="确认"/>
				</div>
			</form>
		</div>
		
    </div>

</body>
</html>