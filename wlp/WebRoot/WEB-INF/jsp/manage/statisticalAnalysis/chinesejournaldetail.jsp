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
<title>中文期刊统计_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript">
function returna(){
	/* window.location.href = "${context}/manage/statisticalAnalysis/toJournal.html?pageNo=${pageNo}"; */
	window.history.go(-1);
}
</script>
</head>
<body>
    <div class="YJ2016_HTmain YJ2016_clearfix " >
    	<!-- 左侧菜单引入 -->
        <div class="con" style="float: left">
        	<div class="HTc1"><span class="mod_btn" style="text-align: left">
            	《${name}》详细信息:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            	<a href="javascript:void(0)" onclick="returna()">返回</a>
            </span>
        	<span style="margin: 2%"></span> 
            <table id="table1" style="margin-top: 1%;">
            	<tbody style="width:200px;">
            	<tr class="cTitle">
            		<td class="ct1" style="width:10%">年份</td>
                	<td class="ct2" >期/数量</td>
                </tr>
                </tbody>
               <c:forEach var="res" items="${detailList}">    
				    <tr>
				    	<td>${res.wf_year_Index}</td>
				    	<td>
				    		<table style="width: 100px;margin-left: -10px;" align="left">
				    			<tr>
				    				<td >期数</td>
						    		<c:forEach var="item" items="${res.list}">
						    			<td >${item.wf_issue}</td>
						    		</c:forEach> 
					    		</tr>
					    		<tr>
					    			<td >数量(篇)</td>
						    		<c:forEach var="item" items="${res.list}">
						    			<td >${item.num}</td>
						    		</c:forEach> 
					    		</tr>
				    		</table>
				    	</td>
					</tr>
				</c:forEach>
            </table>
        </div><!--con--></div>
    </div><!--YJ2016_HTmain-->
</body>
</html>