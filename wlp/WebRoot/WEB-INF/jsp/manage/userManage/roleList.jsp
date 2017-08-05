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
<link type="text/css" rel="stylesheet" href="${context}/css/jquery-ui.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/jquery-ui.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript" src="${context}/js/WdatePicker.js"></script>
<script type="text/javascript">
$(function(){})
function caidan(roleId,roleName){
	var tr = "";
	$.ajax({
		async:false,
		//dataType:"",
		type:"get",
		url:"${context}/manage/getUsersByRoleId.html",
		data:{"roleId":roleId},
		success:function(data){
			for(var i=0;i<data.length;i++){
				tr += "<tr style='height:30px'><td>"+(i+1)+"</td><td>"+data[i].userName+"</td><td>"+data[i].email+"</td></tr>";
			}
			if(data.length==0){
				$("#userList").html("<tr style='height:50px'><td colspan='3'>无成员列表!</td></tr>");
			}else{
				$("#userList").html(tr);
			}
			
		}
	});
	$("#caidan").dialog({
		bgiframe: true,
	    resizable: false,
	    height:"500",
	 	width:"500",
	    modal: true,
	    /* overlay: {
	        backgroundColor: 'red',
	        opacity: 0.5
	    }, */
		title:roleName+"成员列表：",
        buttons:{
        "确定":function(){$(this).dialog('close');}
        }
    })
}

</script>
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
			<div style="text-align: center; margin-top: 20px;">
				<h1>
					<span style="font-size: 24px;">角色列表</span>
				</h1>
			</div>

			<div class="userbtn">
				<a href="${context}/manage/authority/addRolePage.html"
					class="useradd">添加</a><a
					href="${context}/manage/authority/roleList.html" class="userfresh">刷新</a>
			</div>
			<table class="userTable" style="margin-top: 20px;">
				<tr class="cTitle">
					<td class="ct1">角色名</td>
					<td class="ct1">功能</td>
					<td class="ct1">原文预览</td>
					<td class="ct1">题录导出</td>
					<td class="ct1">修改</td>
					<td class="ct1">成员列表</td>
					<td class="ct1">删除</td>
				</tr>
				<c:forEach var="role" items="${roleList}">
					<c:choose>
						<c:when test="${role.roleId==1||role.roleId==5||role.roleId==9||role.roleId==10}">
						<tr>
							<td class="ct1">${role.roleName}</td>
							<td class="ct1">
								<a style="width:100px;color:#3575b5;" class="a2"  href="${context}/manage/authority/OpOfRole-${role.roleId}.html">角色功能管理</a>
							</td>
							<td class="ct1">
								<a style="width:50%;color:#3575b5;" class="a2"  href="${context}/roleOriginal/edit-${role.roleId}.html">设置</a>
							</td>
							<td class="ct1">
								<a  class="a1" href="${context}/ExportAuthorization/get/${role.roleId}.html?roleName=${role.roleName}" style="color:#3575b5;">设置</a>
							</td>
							<td class="ct1">
								<a  class="a1" href="${context}/manage/authority/editRolePage-${role.roleId}.html" style="color:#3575b5;">编辑</a>
							</td>
							<td class="ct1">
								<a  class="a1" href="javascript:void(0)" onclick="caidan(${role.roleId},'${role.roleName}')" style="color:#3575b5;">打开</a>
							</td>
							<td class="ct1">
								<%-- <a  class="a2" href="${context}/manage/authority/delRoleC-${role.roleId}.html"
								onClick="return confirm('确实想删除吗？')" style="color:red;">删除</a> --%>
							</td>
						</tr>
						</c:when>
						<c:otherwise>
							<tr>
							<td class="ct1">${role.roleName}</td>
							<td class="ct1">
								<a style="width:100px;color:#3575b5;" class="a2"  href="${context}/manage/authority/OpOfRole-${role.roleId}.html">角色功能管理</a>
							</td>
							<td class="ct1">
								<a style="width:50%;color:#3575b5;" class="a2"  href="${context}/roleOriginal/edit-${role.roleId}.html">设置</a>
							</td>
							<td class="ct1">
								<a  class="a1" href="${context}/ExportAuthorization/get/${role.roleId}.html?roleName=${role.roleName}" style="color:#3575b5;">设置</a>
							</td>
							<td class="ct1">
								<a  class="a1" href="${context}/manage/authority/editRolePage-${role.roleId}.html" style="color:#3575b5;">编辑</a>
							</td>
							<td class="ct1">
								<a  class="a1" href="javascript:void(0)" style="color:#3575b5;" onclick="caidan(${role.roleId},'${role.roleName}')">打开</a>
							</td>
							<td class="ct1">
								<a  class="a2" href="${context}/manage/authority/delRoleC-${role.roleId}.html"
								onClick="return confirm('确实想删除吗？')" style="color:red;">删除</a>
							</td>
						</tr>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</table>
		</div>
		<!--con-->
	</div>
	<!--YJ2016_HTmain-->
	<div  id="caidan" hidden="hidden">
		<table  align="center" style="width:100%;text-align: center;border-style: solid" border="1px">
			<tr style="background-color: #EAEAEA"><td>序号</td><td>用户名</td><td>邮箱</td></tr>
			<tbody id="userList"></tbody>
		</table>
	</div>
</body>
</html>