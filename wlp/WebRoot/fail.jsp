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
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<title>稍等一下...</title>
<script>
    window.onload=function(){
        window.setTimeout(function(){
        	window.history.go(-1);
        },3000);
    }
</script>
</head>
<body>
	<h3 style="position:absolute; left:50%; top:80px;"></h3>
    <div class="scr-body">
         <img style="max-width:400px;margin:0 auto;display:block; margin-top:-40px;" src="images/error.jpg" >
    </div>
</body>
</html>
