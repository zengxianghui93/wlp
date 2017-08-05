<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% 
    String context = request.getContextPath();
    request.setAttribute("context",context);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改数据库属性</title>
</head>
<body>
	<form action="${context}/DBM/EditResC.html" method="get"
		onsubmit="return mySubmit()" enctype="multipart/form-data">
		<table>
			<tr>
				<td>资源库名称</td>
				<td><input type="text" name="resName" style="width: 60%;"
					value="${rInfo.resName}" /></td>
			</tr>
			<tr>
				<td>物理表名称</td>
				<td><input type="text" name="resTblName" style="width: 60%;"
					value="${rInfo.resTblName}" /></td>
			</tr>
			<tr>
				<td>资源库描述</td>
				<td><input type="text" name="resDesc" style="width: 60%;"
					value="${rInfo.resDesc}" /></td>
			</tr>
			<tr>
				<td>发布流程</td>
				<td><input type="radio" name="resFlow" checked="true" value="0" />直接发布
					<input type="radio" name="resFlow" value="1" />需要审核</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="保存"> <input
					type="reset" value="重置"> <input type="button" value="取消"
					onclick="history.go('-1')"></td>
			</tr>
		</table>
	</form>
</body>
</html>