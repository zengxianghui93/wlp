<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	String context = request.getContextPath();
	request.setAttribute("context", context);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>冶金信息网后台</title>
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />

<link type="text/css" rel="stylesheet" href="${context }/css/styles.css" />
<link type="text/css" rel="stylesheet" href="${context }/css/index.css" />
<script type="text/javascript" src="${context }/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context }/js/js.js"></script>
<style type="text/css">
	h1{
		padding: 0 10px;
	    font-size: 18px;
	    line-height: 50px;
    }
    h1 select{
    	width: 110px;
   		height: 32px;
	    border: 1px solid #cecece;
	    font-family: "微软雅黑";
	    vertical-align: middle;
	    padding-left: 5px;
    }
    h1 input{
    	width: 417px;
	    height: 30px;
	    border: 1px solid #cecece;
	    margin-left: -6px;
	    margin-right: -6px;
	    vertical-align: middle;
	    padding: 0 10px;
    }
    h1 a{
    	display: inline-block;
	    width: 80px;
	    height: 32px;
	    background: #3575b5;
	    line-height: 30px;
	    color: #fff;
	    background: url(../images/HTSearch.png) no-repeat 10px center #3575b5;
	    padding-left: 10px;
	    vertical-align: middle;
    }
    .manage .YJ2016_UserMain_TB1 a:HOVER {
	   color: blue;
	}
</style>
<script type="text/javascript">
	function toSubmit(){
		$("#myForm").submit();
	}
</script>
</head>
<body>
<div id="main" class="wrap">
	<div class="main" style="width:1000px;">
		<h2>知识发布管理</h2>
		<div class="manage">
			
			<%-- <div class="search" style="text-align: center;border:1px solid #cecece;background-color: #f4f4f4;">
				<form id="myForm" action="${context }/ShareDoc/list4Search.html" method="post">
				<h1 style="border-bottom: none;">
					<select>
						<option value="title">文献标题</option>
					</select>
					<input type="text" name="title"/> <a href="#" onclick="toSubmit();">检索</a>
				</h1>
				</form>				
			</div> --%>
			<div class="spacer"></div>


			<table class="YJ2016_UserMain_TB1">
				<tr>
						<th>序号</th>
						<th>文献标题</th>
						<th>作者</th>
						<th>文献类型</th>
						<th>发布时间</th>
						<th>附件</th>
						<th>操作</th>
					</tr>
				<c:forEach var="sharedoc" items="${list}" varStatus="status">
					<tr>
						<td>${(page-1)*pageSize + status.index +1}</td>
						<td>${sharedoc.title}</td>
						<td>${sharedoc.author}</td>
						<td>${sharedoc.docType}</td>
						<td><fmt:formatDate value="${sharedoc.createTime}"  pattern="yyyy-MM-dd HH:mm:ss"/>
						</td>
						<td>
							<c:choose>
								<c:when test="${sharedoc.attachment != null && sharedoc.attachment != '' }">
									<a href="${context }/sharedocs/${sharedoc.attachment}">下载</a>
								</c:when>
								<c:otherwise>
									<a href="#">暂无</a>
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<a href="${context }/ShareDoc/edit/check.html?id=${sharedoc.id }">审核</a>
						</td>
						<%-- <td title="${log.logResTitle}">
						     <c:if test="${log.logRes=='wf_b_elepublication'}">
							<a href="${context}/Productdetails-${log.getLogResId()}.html">${log.logResTitle}</a>
							</c:if>
							</td> --%>
					</tr>
				</c:forEach>
			</table>




			<div class="notePage">
				<div class="page" align="center">
					共<span>${rowCount}</span>条记录&nbsp;&nbsp; <span>${page}/${pageCount}</span>页

					<c:if test="${page <=1}"><a class="none">首页</a></c:if>
					<c:if test="${page >1 }">
						<c:choose>
							<c:when test="${shareDoc != null }">
								<a href="${servlet}?page=1&title=${shareDoc.title }"
							style="margin-right: 5px;">首页</a>
							</c:when>
							<c:otherwise>
								<a href="${servlet}?page=1"
							style="margin-right: 5px;">首页</a>
							</c:otherwise>
						</c:choose>
					</c:if>

					<c:if test="${!hasPrevious}"><a class="none">上一页</a></c:if>
					<c:if test="${hasPrevious}">
						<c:choose>
							<c:when test="${shareDoc != null }">
								<a href="${servlet}?page=${page-1 }&title=${shareDoc.title }"
							style="margin-right: 5px;">上一页</a>
							</c:when>
							<c:otherwise>
								<a href="${servlet}?page=${page-1}"
							style="margin-right: 5px;">上一页</a>
							</c:otherwise>
						</c:choose>
					</c:if>

					<c:if test="${!hasNext}"><a class="none">下一页</a></c:if>
					<c:if test="${hasNext}">
						<c:choose>
							<c:when test="${shareDoc != null }">
								<a href="${servlet}?page=${page+1 }&title=${shareDoc.title }"
							style="margin-right: 5px;">下一页</a>
							</c:when>
							<c:otherwise>
								<a href="${servlet}?page=${page+1}"
							style="margin-right: 5px;">下一页</a>
							</c:otherwise>
						</c:choose>
					</c:if>

					<c:if test="${page >= pageCount}"><a class="none">尾页</a></c:if>
					<c:if test="${page < pageCount}">
						<c:choose>
							<c:when test="${shareDoc != null }">
								<a href="${servlet}?page=${pageCount }&title=${shareDoc.title }"
							style="margin-right: 5px;">尾页</a>
							</c:when>
							<c:otherwise>
								<a href="${servlet}?page=${pageCount}"
							style="margin-right: 5px;">尾页</a>
							</c:otherwise>
						</c:choose>
					</c:if>

					第 <select
						onchange="self.location.href= options[selectedIndex].value">
							<c:choose>
								<c:when test="${shareDoc != null }">
									<option value="${servlet}?page=${page}&title=${shareDoc.title}">${page}</option>
									<c:if test="${page+1 <= pageCount}">
										<option value="${servlet}?page=${page+1}&title=${shareDoc.title}">${page+1}</option>
									</c:if>
									<c:if test="${page+2 <= pageCount}">
										<option value="${servlet}?page=${page+2}&title=${shareDoc.title}">${page+2}</option>
									</c:if>
									<c:if test="${page+3 <= pageCount}">
										<option value="${servlet}?page=${page+3}&title=${shareDoc.title}">${page+3}</option>
									</c:if>
									<c:if test="${page+4 <= pageCount}">
										<option value="${servlet}?page=${page+4}&title=${shareDoc.title}">${page+4}</option>
									</c:if>
								</c:when>
								<c:otherwise>
									<option value="${servlet}?page=${page}">${page}</option>
									<c:if test="${page+1 <= pageCount}">
										<option value="${servlet}?page=${page+1}">${page+1}</option>
									</c:if>
									<c:if test="${page+2 <= pageCount}">
										<option value="${servlet}?page=${page+2}">${page+2}</option>
									</c:if>
									<c:if test="${page+3 <= pageCount}">
										<option value="${servlet}?page=${page+3}">${page+3}</option>
									</c:if>
									<c:if test="${page+4 <= pageCount}">
										<option value="${servlet}?page=${page+4}">${page+4}</option>
									</c:if>
									
								</c:otherwise>
							</c:choose>
						
					</select>页
				</div>
				</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
</body>
</html>
