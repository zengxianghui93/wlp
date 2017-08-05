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
<title>资源管理_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
</head>
<body>
	<!-- 引入头部 -->
	<%-- <jsp:include page="../include/top.jsp"></jsp:include>
	<div class="YJ2016_HTRote">
		<a href="${context}/DBM/resourceManage.html">首页</a>&nbsp;&nbsp;&gt;&nbsp;&nbsp;<span>资源管理</span>
	</div> --%>
	<div class="YJ2016_HTmain YJ2016_clearfix ">
		<!-- 左侧菜单引入 -->
		<%-- <jsp:include page="../include/leftMenu.jsp"></jsp:include> --%>
		<div class="con">
			<div class="HTc1">
				<div class="search">
					<form action="${context}/DBM/resourceManage.html" name= "selForm">
					<h1>
							资源库名称：
						<input type="text" name="resName" value = "${resName}"/> <a href="javascript:void(0)" onclick="document.selForm.submit()">检索</a>
					</h1>
					</form>
				</div>
				<div class="addBtn">
					<a href="javascript:void(0);" class="addBtn1">自建资源</a>
					<!-- <a href="#" class="addBtn2">挂已有资源</a> -->
				</div>
				<table>
					<tbody style="width: 200px;">
						<tr class="cTitle">
							<td class="ct1">资源库名称</td>
							<c:if test="${USER_CONTEXT.userType >2}">
								<td class="ct2">物理表名</td>
							</c:if>
							<td class="ct3" style="width: 130px; white-space: pre-wrap;">描述</td>
							<td class="ct4">创建时间</td>
							<td class="ct5">采编流程</td>
							<%--  <c:if test="${USER_CONTEXT.userType >2}">
			       <td class="ct6">编辑属性</td>
			        </c:if> --%>
							<td class="ct7">维护数据</td>
							<c:if test="${isAdmin == 'true'}">
								<td class="ct7">维护字段</td>
								<td class="ct7">录入模板编辑</td>
								<td class="ct7">展示模板</td>
							</c:if>
						</tr>
					</tbody>
					<c:forEach var="res" items="${pagedNews.result}">
						<tr>
							<td class="ct1" style="width: 130px; white-space: pre-wrap;">${res.resName}</td>
							<c:if test="${USER_CONTEXT.userType >2}">
								<td class="ct2">${fn:substring(res.resTblName, 0, 12)} <span><br></span>
									<c:if test="${fn:length(res.resTblName) > 12}">${fn:substring(res.resTblName, 12, fn:length(res.resTblName))}</c:if>
									<%-- ${res.resTblName} --%>
								</td>
							</c:if>
							<td class="ct3">${res.resDesc}</td>
							<td class="ct4">${fn:substring(res.resDate, 0, 10)}<br />
								${fn:substring(res.resDate, 10, 16)}
							</td>
							<td class="ct5"><c:if test="${res.resFlow==1}">
								需要审核
							</c:if> <c:if test="${res.resFlow==0}">
								直接发布
							</c:if></td>
								<!-- <td class="ct6"><a href="${context}/DBM/editResPage-${res.resId}.html">编辑属性</a></td>-->
								<td class="ct7"><a
									href="${context}/DBM/searchData-${res.resId}.html">维护数据</a></td>
							<c:if test="${isAdmin == 'true'}">
								<c:if test="${USER_CONTEXT.userType >2}">
									<td class="ct7"><a
										href="${context}/DBM/listResFld-${res.resId}.html">维护字段</a></td>
								</c:if>
								<td class="ct7"><a
									href="${context}/Content/editContent/${res.resId}.html">编辑</a></td>
								<td class="ct7"><a
									href="${context}/Show/edit-${res.resId}.html">编辑</a></td>
							</c:if>
						</tr>
					</c:forEach>
				</table>
				<div class="notePage">
					<div class="page">
						共<span>${pagedNews.totalCount}</span>条记录&nbsp;&nbsp; <span>${pagedNews.currentPageNo}/${pagedNews.totalPageCount}</span>页

						<c:if test="${pagedNews.currentPageNo <=1}">首页</c:if>
						<c:if test="${pagedNews.currentPageNo >1 }">
							<a href="${context}/DBM/resourceManage.html?pageNo=1&resName=${resName}"
								style="margin-right: 5px;">首页</a>
						</c:if>
						<c:if test="${!pagedNews.hasPreviousPage}">上一页</c:if>
						<c:if test="${pagedNews.hasPreviousPage}">
							<a
								href="${context}/DBM/resourceManage.html?pageNo=${pagedNews.currentPageNo -1 }&resName=${resName}"
								style="margin-right: 5px;">上一页</a>
						</c:if>

						<c:if test="${!pagedNews.hasNextPage}">下一页</c:if>
						<c:if test="${pagedNews.hasNextPage}">
							<a
								href="${context}/DBM/resourceManage.html?pageNo=${pagedNews.currentPageNo +1 }&resName=${resName}"
								style="margin-right: 5px;">下一页</a>
						</c:if>

						<c:if
							test="${pagedNews.currentPageNo >= pagedNews.totalPageCount}">尾页</c:if>
						<c:if test="${pagedNews.currentPageNo < pagedNews.totalPageCount}">
							<a
								href="${context}/DBM/resourceManage.html?pageNo=${pagedNews.totalPageCount }&resName=${resName}"
								style="margin-right: 5px;">尾页</a>
						</c:if>

						第 <select
							onchange="self.location.href= options[selectedIndex].value">
							<option
								value="${context}/DBM/resourceManage.html?pageNo=${pagedNews.currentPageNo}.html">${pagedNews.currentPageNo}</option>
							<c:if
								test="${pagedNews.currentPageNo+1 <= pagedNews.totalPageCount}">
								<option
									value="${context}/DBM/resourceManage.html?pageNo=${pagedNews.currentPageNo+1}">${pagedNews.currentPageNo+1}</option>
							</c:if>
							<c:if
								test="${pagedNews.currentPageNo+2 <= pagedNews.totalPageCount}">
								<option
									value="${context}/DBM/resourceManage.html?pageNo=${pagedNews.currentPageNo+2}">${pagedNews.currentPageNo+2}</option>
							</c:if>
							<c:if
								test="${pagedNews.currentPageNo+3 <= pagedNews.totalPageCount}">
								<option
									value="${context}/DBM/resourceManage.html?pageNo=${pagedNews.currentPageNo+3}">${pagedNews.currentPageNo+3}</option>
							</c:if>
							<c:if
								test="${pagedNews.currentPageNo+4 <= pagedNews.totalPageCount}">
								<option
									value="${context}/DBM/resourceManage.html?pageNo=${pagedNews.currentPageNo+4}">${pagedNews.currentPageNo+4}</option>
							</c:if>
						</select>页
					</div>
				</div>
			</div>
			<div class="HTnd">
				<span class="setTit">新建关系数据库资源</span>
				<div class="HTnd_mod">
					<p class="radiocurr">
						<input type="radio" name="true" class="radio" checked="checked" />固定模板
					</p>
					<p>
						<input type="radio" name="true" class="radio" />自定义模板
					</p>
					<span class="mod_btn"><a href="javascript:void(0);"
						class="next">下一步</a><a href="javascript:void(0);" class="back">返回</a></span>
				</div>
			</div>
			<!--HTnd结束-->
			<div class="HTnd1">
				<form name="xinjian" action="${context}/DBM/addResC.html"
					method="post" enctype="multipart/form-data">
					<span class="setTit">新建关系数据库资源</span>
					<div class="HTnd_gdmod">
						<p>
							<span>库名：</span><input type="text" name="resName"
								style="width: 60%;" /><strong>*</strong>
						</p>
						<p>
							<span>表名：</span><input type="text" name="resTblName"
								style="width: 60%;" /><strong>*表名必须为英文</strong>
						</p>
						<p>
							<span>描述：</span><input type="text" name="resDesc"
								style="width: 60%;" /><strong>*</strong>
						</p>
						<p>
							<span>状态：</span> <select name="resFlow">
								<option value="0">直接发布</option>
								<option value="1">需要审核</option>
							</select>
						</p>
						<span class="mod_btn"> <a
							href="javascript:document:xinjian.submit();" class="creat">创建</a>
							<a href="${context}/DBM/resourceManage.html">返回</a>
						</span>
					</div>
				</form>
			</div>
			<!--HTnd1结束-->
			<!--  <div class="HTnd1">
            	<span class="setTit">新建关系数据库资源</span>
                <div class="HTnd_gdmod">
                	<p><span>表名：</span><input type="text" /><strong>*表名必须不能包含中文</strong></p>
                    <p><span>模板：</span>
                        <select>
                        	<option>专利</option>
                            <option>会议</option>
                            <option>光盘</option>
                            <option>图书</option>
                            <option>学位</option>
                            <option>成果</option>
                            <option>期刊</option>
                            <option>标准</option>
                            <option>音视频</option>
                        </select>
                    </p>
                    <span class="mod_btn"><a href="javascript:void(0);" class="creat">创建</a><a href="javascript:void(0);" class="pre">上一步</a></span>
                </div>
            </div> -->
			<!--HTnd1结束-->
			<div class="HTnd2">
				<span class="setTit">新建关系数据库资源</span>
				<div class="HTnd_addFiled">
					<span class="filed_btn"><a href="javascript:void(0);"
						class="creat">添加数字型</a><a href="javascript:void(0);" class="pre">添加字符型</a><a
						href="javascript:void(0);" class="creat">添加大文本</a><a
						href="javascript:void(0);" class="pre">添加时间</a></span>
					<p>
						<span>表名：</span><input type="text" />
					</p>
					<span class="mod_btn"><a href="javascript:void(0);"
						class="creat1">创建</a><a href="javascript:void(0);" class="canele">取消</a></span>
				</div>
				<div class="zfc HTnd_addFiled">
					<h2>设置字符类型</h2>
					<p>
						<span>字段名：</span><input type="text" />
					</p>
					<p>
						<span>长度：</span><input type="text" />
					</p>
					<span class="mod_btn zfc_btn"><a href="javascript:void(0);"
						class="addzfc">确定添加</a><a href="javascript:void(0);"
						class="offzfc">取消添加</a></span>
				</div>
			</div>
			<!--HTnd2结束-->
		</div>
		<!--con-->
	</div>
	<!--YJ2016_HTmain-->
	
	<div class="YJ2016_selfResWrap">
		<div class="resmess">
			<div class="closeBtn"></div>
			<a href="#" class="hideBtn">隐藏可选选项</a>
			<div class="set">
				<span class="setTit">资源库信息设置</span>
				<ul>
					<li><span>资源库名称：</span><input type="text" /></li>
					<li><span>资源语种：</span><select><option>汉语</option>
							<option>英语</option>
							<option>德语</option>
							<option>法语</option></select></li>
					<li><span>资源分类：</span><select><option>大宗农产品数据库</option>
							<option>会议</option>
							<option>成果</option>
							<option>汽配新技术</option></select></li>
					<li><span>资源库英文名：</span><input type="text" /></li>
					<li><span>资源库简称：</span><input type="text" /></li>
					<li><span class="st1">资源库简介：</span>
					<textarea></textarea></li>
					<li><span>总量：</span><input type="text" /></li>
					<li><span>更新量：</span><input type="text" /></li>
					<li><span>更新时间：</span><input type="text" /></li>
					<li><span>点击单价：</span><input type="text" /></li>
					<li><span>下载单价：</span><input type="text" /></li>
				</ul>
			</div>
			<div class="set set1">
				<span class="setTit">高级信息</span>
				<ul>
					<li><span>加工处理流程：</span><select><option>请选择流程</option>
							<option>加工</option>
							<option>处理</option>
							<option>加工3</option></select></li>
					<li><span>是否含有原文：</span><input type="radio" name="sex"
						class="radio" /><strong>是</strong><input type="radio" name="sex"
						class="radio" checked="checked" /><strong>否</strong></li>
					<li><span>是否含有摘要：</span><input type="radio" name="sex"
						class="radio" checked="checked" /><strong>是</strong><input
						type="radio" name="sex" class="radio" /><strong>否</strong></li>
					<li><span>全文是否直接下载：</span><input type="radio" name="sex"
						class="radio" checked="checked" /><strong>是</strong><input
						type="radio" name="sex" class="radio" /><strong>否</strong></li>
					<li><span>是否启用同义词检索：</span><input type="radio" name="sex"
						class="radio" /><strong>是</strong><input type="radio" name="sex"
						class="radio" checked="checked" /><strong>否</strong></li>
					<li><span>是否可以更改数据：</span><input type="radio" name="sex"
						class="radio" /><strong>是</strong><input type="radio" name="sex"
						class="radio" checked="checked" /><strong>否</strong></li>
					<li><span>是否可以手动提供全文：</span><input type="radio" name="sex"
						class="radio" /><strong>是</strong><input type="radio" name="sex"
						class="radio" checked="checked" /><strong>否</strong></li>
					<li><span>是否可以组合检索：</span><input type="radio" name="sex"
						class="radio" checked="checked" /><strong>是</strong><input
						type="radio" name="sex" class="radio" /><strong>否</strong></li>
					<li><span>全文实际地址：</span><input type="text" /></li>
					<li><span>文献类型：</span><input type="text" /></li>
					<li><span>学科分类：</span><input type="text" /></li>
					<li><span>揭示深度：</span></li>
					<li><span class="st1">收录范围：</span>
					<textarea></textarea></li>
					<li><span>收录清单：</span><a href="#" class="upBtn">上传</a></li>
					<li><span>排序字段：</span><select><option>请选择</option>
							<option>字段1</option>
							<option>字段2</option>
							<option>字段3</option></select></li>
					<li><span>出版机构：</span><input type="text" /></li>
					<li><span class="st1">记录样例：</span>
					<textarea></textarea></li>
					<li><span>资源库字段类型：</span><select><option>请选择</option>
							<option>字段1</option>
							<option>字段2</option>
							<option>字段3</option></select></li>
					<li><span class="st1">资源库连接地址：</span>
					<textarea></textarea><a href="#" class="linkBtn">连接数据库</a></li>
					<li><span>数据库驱动程序类型：</span><select><option>SQL
								SERVER</option>
							<option>ORACLE</option>
							<option>MY SQL</option></select></li>
					<li><span>资源表名称：</span><select><option>请选择</option>
							<option>字段1</option>
							<option>字段2</option>
							<option>字段3</option></select></li>
				</ul>
			</div>
			<div class="setBtn">
				<a href="#" class="updateBtn">更新</a><a href="#" class="cancelBtn">取消</a>
			</div>
		</div>
	</div>
</body>
</html>