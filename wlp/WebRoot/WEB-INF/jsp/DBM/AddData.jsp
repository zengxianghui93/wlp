<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	String context = request.getContextPath();
	request.setAttribute("context", context);
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据库中添加数据</title>
<link rel="stylesheet" type="text/css" href="${context}/css/mainHT.css">
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript" src="${context}/js/WdatePicker.js"></script>
<script type="text/javascript" src="${context}/js/ckeditor/ckeditor.js"></script>
<script type="text/javascript">
	function onchange1() {
		var xmlhttp;
		var value = document.getElementById("areal").value;

		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.open("get", "${context}/DBM/area.html?area1=" + value, true);
		xmlhttp.send();
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				var data = xmlhttp.responseText;
				var result = eval("(" + data + ")");

				for (i = 0; i < result.length; i++) {
					citys = document.getElementById("area")
					citys.options[i + 1] = new Option();
					citys.options[i + 1].text = result[i].column_name;
					citys.options[i + 1].value = result[i].columid;
				}
			}
		}
	}
	function mySubmit() {
		<c:forEach items="${FldList}" var="fld">
		var fldId = "${fld.fldId}";
		var fldName = "${fld.fldName}";
		var fldDesc = "${fld.fldDesc}";
		var fldType = "${fld.fldType}";
		var fldLength = "${fld.fldLength}";
		var isNull = "${fld.fldIsNull}";

		var element = document.getElementById(fldId);
		var value = document.getElementById(fldId).value;

		if (fldType == "varchar") {
			if (isNull == "0") {
				if (value == null || isKong(value)) {
					alert(fldDesc + "不能为空！");
					element.focus();
					return false;
				}
				if (value.length > fldLength) {
					alert(fldDesc + "长度过长！(只能输入" + fldLength + "个字符或"
							+ fldLength / 2 + "个汉字。)");
					element.focus();
					return false;
				}
			}
		}

		if (fldType == "longtext") {
			if (isNull == "0") {
				if (value == null || isKong(value)) {
					alert(fldDesc + "不能为空！");
					element.focus();
					return false;
				}
			}
		}
		if (fldType == "double") {
			if (isNull == "0") {
				if (value == null || isKong(value)) {
					alert(fldDesc + "不能为空！");
					element.focus();
					return false;
				}
			}
		}
		if (fldType == "int") {
			if (isNull == "0") {
				if (value == null || isKong(value)) {
					alert(fldDesc + "不能为空！");
					element.focus();
					return false;
				}
			}
		}
		if (fldType == "datetime") {

			if (value == null || isKong(value)) {
				alert(fldDesc + "不能为空！");
				element.focus();
				return false;
			}

			if (!isDate(value)) {
				alert(fldDesc + "格式不正确！请参照xxxx-xx-xx格式填写。");
				element.focus();
				return false;
			}
		}
		</c:forEach>
		return true;
	}
	function isKong(str) {
		if (str == "")
			return true;
		var regu = "^[ ]+$";
		var re = new RegExp(regu);
		return re.test(str);
	}

	function isDate(str) {
		var re2 = /^\d{4}(\-|\/|\.)\d{1,2}\1\d{1,2}$/;
		var regu = new RegExp(re2);
		return regu.test(str);
	}
		
</script>
<style type="text/css">
.leftmenu-zhao {
	border: 1px solid #ccc;
	height: 780px;
	width: 765px;
	overflow: scroll;
	overflow-x: hidden;
}

.leftmenu-zhao form table tr td input[type=text] {
	width: 550px;
	height: 30px;
	padding-left: 5px;
	border: 1px solid #a9a9a9;
	"
}

.leftmenu-zhao form table tr td select {
	width: 556px;
	height: 32px;
	padding-left: 5px;
	border: 1px solid #a9a9a9;
	"
}
</style>
</head>
<body>
	<!-- 顶部样式引入 -->
	<%-- <div class="YJ2016_HTRote">
		<a href="${context}/manage/resourceManage/resourceManage.html">首页</a>&nbsp;&nbsp;&gt;&nbsp;&nbsp;<span>数据加工</span>
	</div> --%>
	<div class="YJ2016_HTmain YJ2016_clearfix ">
		<!-- 左侧功能菜单引入 -->
		<h1 align="center">添加数据</h1>
		<div class="con leftmenu-zhao">
			<form name="form1" action="${context}/DBM/addResData.html"
				method="post" onsubmit="return mySubmit()"
				enctype="multipart/form-data">
				<input type="hidden" name="resId" value="${ResId}" />
				<c:choose>
					<c:when
						test="${ ri.resTemplate eq null || empty ri.resTemplate || ri.resTemplate == 'no' }">
						<table style="position: relative; width: 100%;">
							<c:forEach var="fld" items="${FldList}">
								<%--<c:if test="${fld.fldName!='f_id'}">--%>
								<c:choose>
									<c:when test="${fld.fldId==822}">
										<tr>
											<td class="aname">${fld.fldDesc}:</td>
											<td><input id="${fld.fldId}" type="radio"
												name="${fld.fldName}" checked="true" value="1" />男&nbsp;&nbsp;&nbsp;&nbsp;<input
												type="radio" name="${fld.fldName}" value="0">女</td>
									</c:when>
									<c:when test="${fld.fldInputType=='radio'}">
										<tr>
											<td class="aname">${fld.fldDesc}:</td>
											<td><input id="${fld.fldId}" type="radio"
												name="${fld.fldName}" checked="true" value="1" />是&nbsp;&nbsp;&nbsp;&nbsp;<input
												type="radio" name="${fld.fldName}" value="0">否</td>
									</c:when>
									<c:when test="${fld.fldInputType=='datetime'}">
										<c:if test="${fld.fldIsNull==0}">
											<tr>
												<td class="aname">${fld.fldDesc}:</td>
												<td><input style="width: 205px; height: 30px;"
													id="${fld.fldId}" class="Wdate" type="text"
													name="${fld.fldName}" onclick="WdatePicker()"><span
													style="color: red;">*必填*</span></td>
											</tr>
										</c:if>
										<c:if test="${fld.fldIsNull==1}">
											<tr>
												<td class="aname">${fld.fldDesc}:</td>
												<td><input style="width: 205px; height: 30px;"
													id="${fld.fldId}" class="Wdate" type="text"
													name="${fld.fldName}" onClick="WdatePicker()"></td>
											</tr>
										</c:if>
									</c:when>
									<c:when test="${fld.fldInputType=='textareaA'}">
										<tr>
											<td>${fld.fldDesc}:</td>
											<td><textarea rows="20" cols="80" name="${fld.fldName}">${dataMap.get(fld.fldName)}</textarea></td>
										</tr>
										<tr>
											<td>帮助1:</td>
											<td>wf_title:标题;wf_author:作者;wf_abstract:摘要;wf_keyword:关键字;wf_year:年份;</td>
										</tr>
										<tr>
											<td>帮助2:</td>
											<td>AND&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;表示“ 与”运算<br>
												&nbsp;&nbsp;OR&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;表示“或”运算<br>
												NOT&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;表示“非”（ 不包含）运算<br>
												3个运算符必须大写 <!-- &nbsp;&nbsp;"" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;精确检索;不加代表模糊查询</td> -->
										</tr>
									</c:when>
									<c:when test="${fld.fldInputType=='file'}">
										<c:if test="${fld.fldIsNull==0}">
											<tr>
												<td class="aname">${fld.fldDesc}:</td>
												<td><input id="${fld.fldId}" name="myfiles"
													type="${fld.fldInputType}" /><span style="color: red;">*必填*</span></td>
											</tr>
										</c:if>
										<c:if test="${fld.fldIsNull==1}">
											<tr>
												<td class="aname">${fld.fldDesc}:</td>
												<td><input id="${fld.fldId}" name="myfiles"
													type="${fld.fldInputType}" /></td>
											</tr>
										</c:if>
									</c:when>
									<c:when test="${fld.fldInputType=='textarea'}">
										<tr>
											<td class="aname">${fld.fldDesc}:</td>
											<td>
												<%-- <textarea rows="4" cols="80" name="${fld.fldName}"></textarea>--%>
												<textarea id="${fld.fldId}" class="ckeditor textarea1"
													cols="20" name="${fld.fldName}" rows="15">
												<c:if test="${ not empty dataMap.get(fld.fldName)}">${dataMap.get(fld.fldName)}</c:if>
												<c:if test="${empty dataMap.get(fld.fldName)}"></c:if>
										    </textarea>

											</td>
										</tr>
										<script>
								CKEDITOR.replace("${fld.fldId}");
							</script>
									</c:when>
									<%-- <c:when test="${fld.fldId==94}">
									<tr>
										<td class="aname">${fld.fldDesc}:</td>
										<td><select id="${fld.fldId}" name="${fld.fldName}"
											style="padding: 0 10px; height: 30px;">
												<c:forEach var="cate" items="${cateList}">
													<option value="${cate.id}">${cate.name}</option>
												</c:forEach>
										</select></td>
									</tr>
								</c:when> --%>
									<c:when test="${fld.fldId==291}">
										<tr>
											<td class="aname">${fld.fldDesc}:</td>
											<td><select id="${fld.fldId}" name="${fld.fldName}"
												style="padding: 0 10px; height: 30px;">
													<option value="1">分类一</option>
													<option value="2">分类二</option>
													<option value="3">分类三</option>
											</select></td>
										</tr>
									</c:when>
									<c:when test="${fld.fldId==296}">
										<c:if test="${fld.fldIsNull==0}">
											<tr>
												<td class="aname">${fld.fldDesc}:</td>
												<td><input id="${fld.fldId}" name="${fld.fldName}"
													type="${fld.fldInputType}"
													style="width: 100px; height: 30px; padding-left: 5px; border: 1px solid #a9a9a9;" />(元)<span
													style="color: red;">*必填*</span></td>
											</tr>
										</c:if>
										<c:if test="${fld.fldIsNull==1}">
											<tr>
												<td class="aname">${fld.fldDesc}:</td>
												<td><input id="${fld.fldId}" name="${fld.fldName}"
													type="${fld.fldInputType}"
													style="width: 100px; height: 30px; padding-left: 5px; border: 1px solid #a9a9a9;" />(元)</td>
											</tr>
										</c:if>
									</c:when>
									<c:when test="${fld.fldId==286}">
										<c:if test="${fld.fldIsNull==0}">
											<tr>
												<td class="aname">${fld.fldDesc}:</td>
												<td><input id="${fld.fldId}" name="${fld.fldName}"
													type="${fld.fldInputType}"
													style="width: 100px; height: 30px; padding-left: 5px; border: 1px solid #a9a9a9;" /><span
													style="color: red;">*必填*</span></td>
											</tr>
										</c:if>
										<c:if test="${fld.fldIsNull==1}">
											<tr>
												<td class="aname">${fld.fldDesc}:</td>
												<td><input id="${fld.fldId}" name="${fld.fldName}"
													type="${fld.fldInputType}"
													style="width: 100px; height: 30px; padding-left: 5px; border: 1px solid #a9a9a9;" /></td>
											</tr>
										</c:if>
									</c:when>
									<c:when test="${fld.fldInputType=='text'}">
										<c:if test="${fld.fldIsNull==0}">
											<tr>
												<td class="aname">${fld.fldDesc}:</td>
												<td><input id="${fld.fldId}" name="${fld.fldName}"
													type="${fld.fldInputType}"
													style="width: 200px; height: 30px; padding-left: 5px; border: 1px solid #a9a9a9;" /><span
													style="color: red;">*必填*</span></td>
											</tr>
										</c:if>
										<c:if test="${fld.fldIsNull==1}">
											<tr>
												<td class="aname">${fld.fldDesc}:</td>
												<td><input id="${fld.fldId}" name="${fld.fldName}"
													type="${fld.fldInputType}"
													style="width: 200px; height: 30px; padding-left: 5px; border: 1px solid #a9a9a9;" /></td>
											</tr>
										</c:if>
									</c:when>
									<c:otherwise>
										<c:if test="${fld.fldIsNull==0}">
											<tr>
												<td class="aname">${fld.fldDesc}:</td>
												<td><input id="${fld.fldId}" name="${fld.fldName}"
													type="${fld.fldInputType}"
													style="width: 550px; height: 30px; padding-left: 5px; border: 1px solid #a9a9a9;" /><span
													style="color: red;">*必填*</span></td>
											</tr>
										</c:if>
										<tr>
											<c:if test="${fld.fldIsNull==1}">
												<td class="aname">${fld.fldDesc}:</td>
												<td><input id="${fld.fldId}" name="${fld.fldName}"
													type="${fld.fldInputType}"
													style="width: 550px; height: 30px; padding-left: 5px; border: 1px solid #a9a9a9;" /></td>
											</c:if>
										</tr>
									</c:otherwise>
								</c:choose>
								<%-- </c:if> --%>
								<%-- <tr><td>${fld.fldDesc}:</td><td><input name="${fld.fldName}" type="${fld.fldInputType}"  /></td></tr> --%>
							</c:forEach>
							<tr>
								<td colspan="2" class="btnGroup" align="center"><input
									type="submit" class="HDZJ2016ht_button1" value="保存"> <input
									type="reset" class="HDZJ2016ht_button1" value="重置"> <input
									type="button" class="HDZJ2016ht_button1" value="取消"
									onclick="history.go('-1')"></td>
							</tr>
						</table>
					</c:when>
					<c:otherwise>
						<%-- ${ri.resTemplate } --%>
						<table style="position: relative; width: 100%;">
							<c:forEach var="Var" items="${list }">
								<c:if test="${Var.fldIsEnter == 1 }">
									<c:choose>
										<c:when
											test="${Var.fldHtmlTag !=null && Var.fldHtmlTag == 'input' }">
											<tr>
												<td class="aname">${Var.fldDesc}:</td>
												<c:choose>
													<c:when test="${Var.fldTagType == 'text' }">
														<c:if test="${Var.tagdefaultValue != null}">
															<td><input type="${Var.fldTagType }"
																name="${Var.fldName}" value="${Var.tagdefaultValue}" /></td>
														</c:if>
														<c:if test="${Var.tagdefaultValue == null}">
															<td><input type="${Var.fldTagType }"
																name="${Var.fldName}" /></td>
														</c:if>
													</c:when>
													<c:otherwise>
														<c:if test="${Var.tagdefaultValue != null}">
															<td><input type="${Var.fldTagType }"
																name="${Var.fldName}" value="${Var.tagdefaultValue}" /></td>
														</c:if>
														<c:if test="${Var.tagdefaultValue == null}">
															<td><input type="${Var.fldTagType }"
																name="${Var.fldName}" /></td>
														</c:if>
													</c:otherwise>
												</c:choose>
											</tr>
										</c:when>
										<c:when
											test="${Var.fldHtmlTag !=null && Var.fldHtmlTag == 'textarea' }">
											<tr>
												<td class="aname">${Var.fldDesc}:</td>
												<td><textarea id="${Var.fldName }"
														name="${Var.fldName}"></textarea></td>
											</tr>
											<script>
											CKEDITOR.replace("${Var.fldName}");
										</script>
										</c:when>
										<c:when
											test="${Var.fldHtmlTag !=null && Var.fldHtmlTag == 'select' }">
											<tr>
												<td class="aname">${Var.fldDesc}:</td>
												<c:choose>
													<c:when
														test="${Var.fldTagType!= null && Var.fldTagType == 'language' }">
														<td><select name="${Var.fldName}">
																<c:forEach items="${langList }" var="lang">
																	<option value="${lang.f_id }">${lang.wf_authority_cn }</option>
																</c:forEach>
														</select></td>
													</c:when>
													<c:when
														test="${Var.fldTagType!= null && Var.fldTagType == 'origin' }">
														<td><select name="${Var.fldName}">
																<c:forEach items="${databaseList }" var="database">
																	<option value="${database.f_id }">${database.wf_MIdatabaseName }</option>
																</c:forEach>
														</select></td>
													</c:when>
													<c:when
														test="${Var.fldTagType!= null && Var.fldTagType == 'other' }">
														<td><select name="${Var.fldName}">
																<c:if test="${Var.tagAdditional != null}">${Var.tagAdditional}</c:if>
														</select></td>
													</c:when>
												</c:choose>
											</tr>
										</c:when>
										<c:otherwise>
											<tr>
												<td class="aname">${Var.fldDesc}:</td>
												<td><input type="text" name="${Var.fldName}" /></td>
											</tr>
										</c:otherwise>
									</c:choose>
								</c:if>
							</c:forEach>
							<tr>
								<td colspan="2" class="btnGroup" align="center"><input
									type="submit" class="HDZJ2016ht_button1" value="保存"> <input
									type="reset" class="HDZJ2016ht_button1" value="重置"> <input
									type="button" class="HDZJ2016ht_button1" value="取消"
									onclick="history.go('-1')"></td>
							</tr>
						</table>
					</c:otherwise>
				</c:choose>

			</form>
		</div>
		<!--con-->
	</div>
	<!--YJ2016_HTmain-->
</body>
</html>