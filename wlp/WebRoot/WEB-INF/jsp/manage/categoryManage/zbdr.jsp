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
<title>指标导入_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<link rel="stylesheet" type="text/css" href="${context}/css/mainHT.css">
	<script type="text/javascript">
		function checktosubmit(){
			
			var tag=true;
			var filename = document.getElementById("zbfile").value;
			
			if(null==filename||filename=="")
			{
				alert("请选择上传文件！");
				tag = false ;
				return tag;
			}else{
				var strname = filename.substring(filename.lastIndexOf("."));
				if(strname==".zip"){
					document.getElementById("saveCol").submit();
					return true;
				}else{
					alert("请上传.zip文件！");
					tag = false;
					return tag;
				}
			}
			
		}
	</script>

</head>
<body>
    
    <div class="YJ2016_HTmain YJ2016_clearfix ">
    	
		
		<c:if test="${not empty errormsg}">
			<div style="text-align: center">${errorMsg}</div>
		</c:if>
		<form id="saveCol" onsubmit="return checktosubmit()" enctype="multipart/form-data"  action="${context}/datacenter/zblist/upload.html" method="post">
			<div style="text-align: center;font-size: 25px">指标数据导入</div>
			<table class="HDZJ2016ht_TB1" style="width: 70%">
				
				<tr>
					<td class="td1">指标数据文件:</td>
					<td><input class="input1" type="file" id="zbfile" name="zbfile" >
					注意：请上传.zip文件</td>
				</tr>
				
			</table>
			<div style="text-align: center">
				<input class="HDZJ2016ht_button2" type="submit"  value="上传"/>
			</div>
		</form>
        
	</div>        
        
 
</body>
</html>