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
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>建议_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript" src="${context}/js/WdatePicker.js"></script>
<script type="text/javascript">
function updateRes(resId,resBalance){
	var balance=prompt("请输入回复内容：",resBalance);
	if(balance==null){
		return;
	}
	if(balance==null||balance==""){
		alert("回复不能为空");
	}else{
		 //后台修改
		 $.post("${context}/manage/updateidea.html", {resId:resId,resBalance:balance},
				 function(data) {
			 if(data=="error"){
				 alert("回复失败");
			 }
		 }, "text");
	};
}
</script>
</head>
<body>
    <!-- 引入头部 -->
    <%-- <jsp:include page="include/top.jsp"></jsp:include> --%>
    <%-- <div class="YJ2016_HTRote">
    	<a href="${context}/DBM/resourceManage.html">首页</a>&nbsp;&nbsp;&gt;&nbsp;&nbsp;<span>资源管理</span>
    </div> --%>
    <div class="YJ2016_HTmain YJ2016_clearfix ">
    	<!-- 左侧菜单引入 -->
    	<%-- <jsp:include page="include/leftMenu.jsp"></jsp:include> --%>
        <div class="con userCon">
            <div class="userbtn">
            <a href="${context}/manage/idea.html" class="userfresh">刷新</a>
            </div>
            <table class="userTable" style="margin-top: 10px;">
            	<tr class="cTitle">
                	<td class="ct5">建议编号</td>
                    <td class="ct2">建议类型</td> 
                    <td class="ct1">建议内容</td>
                    <td class="ct1">建议回复</td>
                    <td class="ct6">建议人</td>                    
                    <td class="ct6">建议状态</td>
                    <td class="ct6">编辑</td>
                    <td class="ct6">修改</td>
                    <td class="ct7">删除</td>
                </tr>
                <c:forEach var="sp" items="${pagedNews.result}" varStatus="status">
                <tr>
                	<td class="ct5">${(pagedNews.currentPageNo-1)*10+status.index+1}</td>
                    <td class="ct2"><c:if test="${sp.wf_ideaType == 1}">体验问题</c:if>
                    <c:if test="${sp.wf_ideaType == 2}">数据问题</c:if>
                    <c:if test="${sp.wf_ideaType == 3}">改进意见</c:if></td>
                    <td class="ct1">${fn:substring(sp.wf_ideaContent, 0, 10)}</td>
                    <td class="ct1">${fn:substring(sp.wf_by2, 0, 10)}</td>
                    <td class="ct6">${sp.username}</td>
                    <td class="ct6"><c:if test="${sp.wf_by1==0}">未处理</c:if>
                                    <c:if test="${sp.wf_by1==1}">已处理</c:if></td>
                    <td class="ct6"><a href="" onclick="updateRes('${sp.f_id}','${sp.wf_by2}')">回复</a></td>
                    <td class="ct6"><a href="${context}/manage/oneidea-${sp.f_id}.html">查看</a></td>
                    <td class="ct7"><a href="${context}/manage/deleteidea-${sp.f_id}.html" onClick="return confirm('确实想删除吗？')">删除</a></td>
                </tr>
                </c:forEach>               
            </table>
            	<div class="notePage">
            <div class="page">
                                     共<span>${pagedNews.totalCount}</span>条记录&nbsp;&nbsp; <span>${pagedNews.currentPageNo}/${pagedNews.totalPageCount}</span>页
                    
                   	<c:if test="${pagedNews.currentPageNo <=1}"><a class="none">首页</a></c:if>
                   	<c:if test="${pagedNews.currentPageNo >1 }">
						<a href="${context}/manage/idea.html?pageNo=1">首页</a>
					</c:if>
                   	
                   	<c:if test="${!pagedNews.hasPreviousPage}"><a class="none">上一页</a></c:if>
					<c:if test="${pagedNews.hasPreviousPage}">
				    	  <a href="${context}/manage/idea.html?pageNo=${pagedNews.currentPageNo -1 }">上一页</a>
				    </c:if>
				    
					<c:if test="${!pagedNews.hasNextPage}"><a class="none">下一页</a></c:if>
					<c:if test="${pagedNews.hasNextPage}">
				   		<a href="${context}/manage/idea.html?pageNo=${pagedNews.currentPageNo +1 }">下一页</a>
				    </c:if>
                   
                   	<c:if test="${pagedNews.currentPageNo >= pagedNews.totalPageCount}"><a class="none">尾页</a></c:if>
					<c:if test="${pagedNews.currentPageNo < pagedNews.totalPageCount}">
						<a href="${context}/manage/idea.html?pageNo=${pagedNews.totalPageCount }">尾页</a>
					</c:if>
                    
                   	 第
                    <select onchange="self.location.href= options[selectedIndex].value">
                    	<option value="${context}/manage/idea.html?pageNo=${pagedNews.currentPageNo}.html">${pagedNews.currentPageNo}</option>
                        <c:if test="${pagedNews.currentPageNo+1 <= pagedNews.totalPageCount}"><option value="${context}/manage/idea.html?pageNo=${pagedNews.currentPageNo+1}">${pagedNews.currentPageNo+1}</option></c:if>
                        <c:if test="${pagedNews.currentPageNo+2 <= pagedNews.totalPageCount}"><option value="${context}/manage/idea.html?pageNo=${pagedNews.currentPageNo+2}">${pagedNews.currentPageNo+2}</option></c:if>
                        <c:if test="${pagedNews.currentPageNo+3 <= pagedNews.totalPageCount}"><option value="${context}/manage/idea.html?pageNo=${pagedNews.currentPageNo+3}">${pagedNews.currentPageNo+3}</option></c:if>
                        <c:if test="${pagedNews.currentPageNo+4 <= pagedNews.totalPageCount}"><option value="${context}/manage/idea.html?pageNo=${pagedNews.currentPageNo+4}">${pagedNews.currentPageNo+4}</option></c:if>                        
                    </select>页              
            </div></div>
        </div><!--con-->
    </div><!--YJ2016_HTmain-->
</body>
</html>