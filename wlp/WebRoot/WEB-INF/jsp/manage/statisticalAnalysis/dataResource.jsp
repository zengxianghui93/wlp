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
<title>资源管理_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript">
	$(function(){
		$("#table1").children("tbody").eq(1).children("tr").each(function(){
			if($(this).children("td").eq(4).text()=='0'){
				$(this).children("td").eq(4).text("中英文")
			}else if($(this).children("td").eq(4).text()=='1'){
				$(this).children("td").eq(4).text("中文")
			}else if($(this).children("td").eq(4).text()=='2'){
				$(this).children("td").eq(4).text("英文")
			}
		});
		
		//选择页数的跳转
		var options = '';
		for(var i=0;i<"${pagedNews.totalPageCount}"*1;i++){
			if((i+1) == "${pagedNews.currentPageNo}"){
				options += '<option selected="selected" value="${context}/manage/statisticalAnalysis/dataResource.html?pageNo='+(i+1)+'">'+(i+1)+'</option>';
			}else{
				options += '<option value="${context}/manage/statisticalAnalysis/dataResource.html?pageNo='+(i+1)+'">'+(i+1)+'</option>';
			}
		}
		$("#currentPageNoSelect").html(options);
	});
	
	function renew(){
		var time = 1;
		$("#table1").children("tbody").children("tr").each(function(){
			if(time != 1){
				$(this).children("td").eq(1).text("更新中..");
				$(this).children("td").eq(2).text("更新中..");
				$(this).children("td").eq(3).text("更新中..");
				$(this).children("td").eq(4).text("更新中..");
			}
			time += 1
		});
		//向后台发送处理数据   
		$.ajax({
			type : "POST",
			dataType : 'text',
			url : "${context}/manage/statisticalAnalysis/updateDataResource.html",
			data : {},
			success : function(data) {
				window.location.href="${context}/manage/statisticalAnalysis/dataResource.html?pageNo=${pagedNews.currentPageNo}";
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				/* alert("error"); */
			},
		});
	}
	function downLoad(){
		window.location.href="${context}/manage/statisticalAnalysis/dataRourceDownload.html";
	}
</script>
</head>
<body>
    <!-- 引入头部 -->
   <%--  <div class="YJ2016_HTRote">
    	<a href="${context}/DBM/resourceManage.html">首页</a>&nbsp;&nbsp;&gt;&nbsp;&nbsp;<span>统计分析</span>&nbsp;&nbsp;&gt;&nbsp;&nbsp;<span>数据资源报告</span>
    </div> --%>
    <div class="YJ2016_HTmain YJ2016_clearfix " >
    	<!-- 左侧菜单引入 -->
        <div class="con" style="float: left">
        	<div class="HTc1">
            <div class="userbtn" style="margin-top: 20px">
            	<a href = "javascript:void(0)"type="button" class="addBtn1" style = "width:130px" onclick="downLoad()">下载数据资源报告</a>
				<a href="javascript:void(0)" onclick="renew()" class="userfresh">更新</a><strong style="color:red">(更新全部资源,需耐心等待)</strong>
			</div>
            <table id="table1">
            	<tbody style="width:200px;">
            	<tr class="cTitle">
                	<td class="ct1" style="width:20%">资源库名称</td>
			        <td class="ct3" style="width:15%">数据总量</td>
			        <td class="ct4" style="width:20%">最后更新数据时间</td>
			        <td class="ct5" style="width:20%">文献类型</td>
			        <td class="ct7" style="width:15%">语种</td>
                </tr>
                </tbody>
                <c:forEach var="res" items="${pagedNews.result}">    
				    <tr>
						<td class="ct1" style="width:130px;white-space:pre-wrap;">${res.resName}</td>
						
						<td class="ct3">${res.resAccount}</td>
						<td class="ct4">${res.resUpdateTime}
							<%-- ${fn:substring(res.resUpdateTime, 0, 10)}<br/>
							${fn:substring(res.resUpdateTime, 10, 16)} --%>
						</td>
						<td class="ct5">
								${res.resDesc}
						</td>
						<td class="ct6">${res.resType}</td>
					</tr>
				</c:forEach>  
            </table>
            <div class="notePage">
            <div class="page">
                                     共<span>${pagedNews.totalCount}</span>条记录&nbsp;&nbsp; <span>${pagedNews.currentPageNo}/${pagedNews.totalPageCount}</span>页
                    
                   	<c:if test="${pagedNews.currentPageNo <=1}">首页</c:if>
                   	<c:if test="${pagedNews.currentPageNo >1 }">
						<a href="${context}/manage/statisticalAnalysis/dataResource.html?pageNo=1" style="margin-right:5px;">首页</a>
					</c:if>
                   	
                   	<c:if test="${!pagedNews.hasPreviousPage}">上一页</c:if>
					<c:if test="${pagedNews.hasPreviousPage}">
				    	  <a href="${context}/manage/statisticalAnalysis/dataResource.html?pageNo=${pagedNews.currentPageNo -1 }" style="margin-right:5px;">上一页</a>
				    </c:if>
				    
					<c:if test="${!pagedNews.hasNextPage}">下一页</c:if>
					<c:if test="${pagedNews.hasNextPage}">
				   		<a href="${context}/manage/statisticalAnalysis/dataResource.html?pageNo=${pagedNews.currentPageNo +1 }" style="margin-right:5px;">下一页</a>
				    </c:if>
                   
                   	<c:if test="${pagedNews.currentPageNo >= pagedNews.totalPageCount}">尾页</c:if>
					<c:if test="${pagedNews.currentPageNo < pagedNews.totalPageCount}">
						<a href="${context}/manage/statisticalAnalysis/dataResource.html?pageNo=${pagedNews.totalPageCount }" style="margin-right:5px;">尾页</a>
					</c:if>
                    
                   	 第
                    <select onchange="self.location.href= options[selectedIndex].value" id="currentPageNoSelect">
                    	<option value="${context}/manage/statisticalAnalysis/dataResource.html?pageNo=${pagedNews.currentPageNo}.html" >${pagedNews.currentPageNo}</option>
                    </select>页              
            </div></div>
            </div>
        </div><!--con-->
    </div><!--YJ2016_HTmain-->
</body>
</html>