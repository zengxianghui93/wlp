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
<title>外文期刊统计_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript">
	$(function(){
		//选择页数的跳转
		var options = '';
		for(var i=0;i<"${pagedNews.totalPageCount}"*1;i++){
			if((i+1) == "${pagedNews.currentPageNo}"){
				options += '<option selected="selected" value="${context}/manage/statisticalAnalysis/toForeignJournal.html?pageNo='+(i+1)+'">'+(i+1)+'</option>';
			}else{
				options += '<option value="${context}/manage/statisticalAnalysis/toForeignJournal.html?pageNo='+(i+1)+'">'+(i+1)+'</option>';
			}
		}
		$("#currentPageNoSelect").html(options);
	});
</script>
</head>
<body>
    <div class="YJ2016_HTmain YJ2016_clearfix " >
    	<!-- 左侧菜单引入 -->
        <div class="con" style="float: left">
        	<div class="HTc1">
        	<span style="margin: 2%">外文期刊内容统计:</span>
            <table id="table1" style="margin-top: 1%;text-align: center;">
            	<tbody style="width:200px;">
            	<tr class="cTitle">
            		<td class="ct1" style="width:10%">序号</td>
                	<td class="ct1" style="width:20%">期刊刊名</td>
			        <td class="ct2" style="width:15%">数据总量</td>
			        <td class="ct3" style="width:15%">查看</td>
                </tr>
                </tbody>
               <c:forEach var="res" items="${pagedNews.result}">    
				    <tr>
				    	<td class="ct1" >${res.id}</td>
				    	<td class="ct1" >《${res.name}》</td>
			        	<td class="ct2" >${res.number}</td>
			        	<td class="ct3"><a href="${context}/manage/statisticalAnalysis/foreignJournalDetail.html?name=${res.name}&pageNo=${pagedNews.currentPageNo}" >查看</a></td>
					</tr>
				</c:forEach>
            </table>
            <div class="notePage">
            <div class="page">
                                     共<span>${pagedNews.totalCount}</span>条记录&nbsp;&nbsp; <span>${pagedNews.currentPageNo}/${pagedNews.totalPageCount}</span>页
                    
                   	<c:if test="${pagedNews.currentPageNo <=1}">首页</c:if>
                   	<c:if test="${pagedNews.currentPageNo >1 }">
						<a href="${context}/manage/statisticalAnalysis/toForeignJournal.html?pageNo=1" style="margin-right:5px;">首页</a>
					</c:if>
                   	
                   	<c:if test="${!pagedNews.hasPreviousPage}">上一页</c:if>
					<c:if test="${pagedNews.hasPreviousPage}">
				    	  <a href="${context}/manage/statisticalAnalysis/toForeignJournal.html?pageNo=${pagedNews.currentPageNo -1 }" style="margin-right:5px;">上一页</a>
				    </c:if>
				    
					<c:if test="${!pagedNews.hasNextPage}">下一页</c:if>
					<c:if test="${pagedNews.hasNextPage}">
				   		<a href="${context}/manage/statisticalAnalysis/toForeignJournal.html?pageNo=${pagedNews.currentPageNo +1 }" style="margin-right:5px;">下一页</a>
				    </c:if>
                   
                   	<c:if test="${pagedNews.currentPageNo >= pagedNews.totalPageCount}">尾页</c:if>
					<c:if test="${pagedNews.currentPageNo < pagedNews.totalPageCount}">
						<a href="${context}/manage/statisticalAnalysis/toForeignJournal.html?pageNo=${pagedNews.totalPageCount }" style="margin-right:5px;">尾页</a>
					</c:if>
                    
                   	 第
                    <select onchange="self.location.href= options[selectedIndex].value" id="currentPageNoSelect">
                    	<option value="${context}/manage/statisticalAnalysis/toForeignJournal.html?pageNo=${pagedNews.currentPageNo}.html" >${pagedNews.currentPageNo}</option>
                    </select>页              
            </div></div>
            </div>
        </div><!--con-->
    </div><!--YJ2016_HTmain-->
</body>
</html>