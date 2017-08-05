<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>冶金信息网后台</title>
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<link type="text/css" rel="stylesheet" href="${context}/css/styles.css" />
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript"
	src="${context}/scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${context}/scripts/function.js"></script>
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<style type="text/css">
	.YJ2016_UserMain_form .form_tb1 td select{
		background-color: #FFFFFF;
	    border: 1px #DDDDDD solid;
	    font-size: 15px;
	    height: 40px;
	    padding: 8px;
	    min-width: 338px;
	    border-radius: 2px;
	}
	.YJ2016_UserMain_form .form_tb1 td input[type='file']{
		margin-top: 0px;
	}
</style>
</head>
<body>
	<div id="main" class="wrap">
		<div class="main" style="width:1000px;">
			<h2>知识发布管理</h2>
			<div class="manage">
				<div class="search"></div>
				<div class="spacer"></div>
					<form name="form1" action="${context }/ShareDoc/update4Admin.html" method="post" enctype="multipart/form-data">
					<%-- <h4 style="text-align: center; color: red">
						<c:if test="${!empty errorMsg}">
							<div id="error " style="color: red">${errorMsg}</div>
						</c:if>
					</h4> --%>
					<c:if test="${shareDoc != null}">
						<input type="hidden" name="id" value="${shareDoc.id }" />
					</c:if>
					<c:if test="${shareDoc != null && shareDoc.attachment != null}">
						<input type="hidden" name="attachment" value="${shareDoc.attachment }"/>
					</c:if>
					<div class="YJ2016_UserMain_form">
						<table class="form_tb1">
							<tr>
								<td class="td1">文献类型：</td>
								<td>
									<select name="docType">
										<c:choose>
											<c:when test="${shareDoc.docType !=null && shareDoc.docType eq '文献' }">
												<option value="文献" selected="selected">文献</option>
											</c:when>
											<c:otherwise>
												<option value="文献">文献</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${shareDoc.docType !=null && shareDoc.docType eq '报告' }">
												<option value="报告" selected="selected">报告</option>
											</c:when>
											<c:otherwise>
												<option value="报告">报告</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${shareDoc.docType !=null && shareDoc.docType eq '演示文档' }">
												<option value="演示文档" selected="selected">演示文档</option>
											</c:when>
											<c:otherwise>
												<option value="演示文档">演示文档</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${shareDoc.docType !=null && shareDoc.docType eq '工作文件' }">
												<option value="工作文件" selected="selected">工作文件</option>
											</c:when>
											<c:otherwise>
												<option value="工作文件">工作文件</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${shareDoc.docType !=null && shareDoc.docType eq '科学数据' }">
												<option value="科学数据" selected="selected">科学数据</option>
											</c:when>
											<c:otherwise>
												<option value="科学数据">科学数据</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${shareDoc.docType !=null && shareDoc.docType eq '词条' }">
												<option value="词条" selected="selected">词条</option>
											</c:when>
											<c:otherwise>
												<option value="词条">词条</option>
											</c:otherwise>
										</c:choose>
								</select>
								</td>
							</tr>
							<tr>
								<td class="td1">文献标题：</td>
								<td><input type="text" name="title" value="${shareDoc.title}"  readonly="readonly"/></td>
							</tr>
							<tr>
								<td class="td1">作者：</td>
								<td><input type="text" name="author"
									value="${shareDoc.author}"  readonly="readonly"/></td>
							</tr>
							<tr>
								<td class="td1">出版社：</td>
								<td><input type="text" name="publisher" value="${shareDoc.publisher}" readonly="readonly" /></td>
							</tr>
							<tr>
								<td class="td1">摘要：</td>
								<td><input type="text" name="abstracts"
									value="${shareDoc.abstracts}"  readonly="readonly"/></td>
							</tr>
							<tr>
								<td class="td1">关键字：</td>
								<td><input type="text" name="keyword"
									value="${shareDoc.keyword}" readonly="readonly" /></td>
							</tr>
							<tr>
								<td class="td1">刊名：</td>
								<td><input type="text" name="journalName" value="${shareDoc.journalName}" readonly="readonly" /></td>
							</tr>
							<tr>
								<td class="td1">出版年：</td>
								<td><input type="text" name="pubYear"
									value="${shareDoc.pubYear}" readonly="readonly" /></td>
							</tr>
							<tr>
								<td class="td1">卷：</td>
								<td><input type="text" name="volume"
									value="${shareDoc.volume}" readonly="readonly"/></td>
							</tr>
							<tr>
								<td class="td1">版次：</td>
								<td><input type="text" style="" name="issue"
									value="${shareDoc.issue}" readonly="readonly" /></td>
							</tr>
							<tr>
								<td class="td1">语种：</td>
								<td>
									<select name="docLan">
										<c:choose>
											<c:when test="${shareDoc.docLan != null && shareDoc.docLan eq '1' }">
												<option value="1" selected="selected">中文</option>
											</c:when>
											<c:otherwise>
												<option value="1">中文</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${shareDoc.docLan != null && shareDoc.docLan eq '2' }">
												<option value="2" selected="selected">英文</option>
											</c:when>
											<c:otherwise>
												<option value="2">英文</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${shareDoc.docLan != null && shareDoc.docLan eq '3' }">
												<option value="3" selected="selected">德文</option>
											</c:when>
											<c:otherwise>
												<option value="3">德文</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${shareDoc.docLan != null && shareDoc.docLan eq '4' }">
												<option value="4" selected="selected">法文</option>
											</c:when>
											<c:otherwise>
												<option value="4">法文</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${shareDoc.docLan != null && shareDoc.docLan eq '5' }">
												<option value="5" selected="selected">意大利文</option>
											</c:when>
											<c:otherwise>
												<option value="5">意大利文</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${shareDoc.docLan != null && shareDoc.docLan eq '6' }">
												<option value="6" selected="selected">日文</option>
											</c:when>
											<c:otherwise>
												<option value="6">日文</option>
											</c:otherwise>
										</c:choose>
								</select>
								</td>
							</tr>
							<tr>
								<td class="td1">共享：</td>
								<td>
									<select name="share">
										<c:choose>
											<c:when test="${shareDoc !=null && shareDoc.share == true }">
												<option value="1" selected="selected">是</option>
											</c:when>
											<c:otherwise>
												<option value="1">是</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${shareDoc !=null && shareDoc.share == false }">
												<option value="0" selected="selected">否</option>
											</c:when>
											<c:otherwise>
												<option value="0">否</option>
											</c:otherwise>
										</c:choose>
									</select>
								</td>
							</tr>
							<tr>
								<td class="td1">描述：</td>
								<td class="YJ2016_clearfix"><input type="text" name="description" value="${shareDoc.description }"></input> </td>
							</tr>
							<tr>
								<td class="td1">审核结果：</td>
								<td class="YJ2016_clearfix">
									<input type="radio" name="check" value="true" />通过
									<input type="radio" name="check" value="false" checked="checked"/>不通过
								</td>
							</tr>
							<tr>
								<td class="td2" colspan="2"><input class="btn1"
									type="submit" name="submit" value="保存" /></td>
							</tr>
						</table>
					</div>

				</form>
			</div>
		</div>
		<div class="clear"></div>
	</div>
</body>
</html>
