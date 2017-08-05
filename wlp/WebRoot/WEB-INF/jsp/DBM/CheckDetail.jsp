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
<title>审核数据</title>
<link rel="stylesheet" type="text/css" href="${context}/css/mainHT.css">
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript" src="${context}/js/WdatePicker.js"></script>
<script type="text/javascript" src="${context}/js/ckeditor/ckeditor.js"></script>

<script type="text/javascript"
	src="${context}/js/Ztree/jquery.ztree.core.js"></script>
<script type="text/javascript"
	src="${context}/js/Ztree/jquery.ztree.excheck.min.js"></script>
<link rel="stylesheet" href="${context}/js/Ztree/zTreeStyle.css"
	type="text/css">

<script type="text/javascript">
	var BIAOYIN0008;
	var BIAOYIN0009;
	var BIAOYIN0010;
	var BIAOYIN0008Code = [];
	var BIAOYIN0009Code = [];
	var BIAOYIN0010Code = [];
	var setting = {
			view:{
				showIcon: false,
		        dblClickExpand: true,//双击节点时，是否自动展开父节点的标识  
		        showLine: false,//显示下划线  
		        expandSpeed: 300,//"slow"//节点展开速度
		        addHoverDom: null,
		        fontCss:{"font-size":"10"}
		    },
		    data:{
		        simpleData : {  
		            enable : true,  
		            idKey : "id",
		            pIdKey : "pId",
		            rootPId : 0
		        }
		    },
		    check:{
		    	enable:true,
		    	chkstyle:"checkbox",
		    	chkboxType:{ "Y" : "ps", "N" : "ps" },
		    },
		    callback:{
		    	onCheck:function(event, treeId, treeNode){
		    		var zTree = $.fn.zTree.getZTreeObj(treeId);//获取ztree
		            var nodes = zTree.getChangeCheckedNodes();//获取选中的节点
		            var text = "";//显示内容
		            var ids = "";//code的集合
		            for (var i=0, l=nodes.length; i<l; i++) {  
		            	if(text!=""&&nodes[i].isParent){
		            		text += "<br>";//拼接换行符
		            	}
		            	if(!nodes[i].isParent){//判断是否为父节点
		            		text += "  "+nodes[i].name;//拼接显示内容
		            		if(ids == ""){
		            			ids = nodes[i].id;
		            		}else{
		            			ids += ","+nodes[i].id;
		            		}
		            	}
			            if(text.substring(text.lastIndexOf("<br>"),text.length).length>64){
			            	text += "<br>";
			            }; 
		            } 
		            document.getElementById(treeId.substring(0,treeId.length-1)+"2").innerHTML = text;
		            document.getElementById(treeId.substring(0,treeId.length-1)+"3").value = ids;
		    	}
		    }
		};
	$(function(){
		//如果是情报库
		if("${resId}" == "25"){
		$.ajax({
			async:true,
			//dataType:"",
			type:"get",
			url:"${context}/manage/categoryManage/getMIBIAOYIN.html",
			data:{},
			success:function(data){
				var value8 = "${dataMap.get('wf_newfl')}".split(",");
				var value9 = "${dataMap.get('wf_countryName_cn')}".split(",");
				var value10 = "${dataMap.get('wf_companyName_cn')}".split(",");
				BIAOYIN0008 = data.B0008;
				BIAOYIN0009 = data.B0009;
				BIAOYIN0010 = data.B0010;
				
				//产品分类赋值
				for(var i=0;i<BIAOYIN0008.length;i++){
					if(BIAOYIN0008[i].wf_categoryCode.length>4){
						BIAOYIN0008Code.push({id:BIAOYIN0008[i].wf_categoryCode,pId:BIAOYIN0008[i].wf_categoryCode.substring(0,BIAOYIN0008[i].wf_categoryCode.length-4),name:BIAOYIN0008[i].wf_categoryName});
					}
				}
				
				//国家和地区赋值
				for(var i=0;i<BIAOYIN0009.length;i++){
					if(BIAOYIN0009[i].wf_categoryCode.length > 4){
						BIAOYIN0009Code.push({id:BIAOYIN0009[i].wf_categoryCode,pId:BIAOYIN0009[i].wf_categoryCode.substring(0,BIAOYIN0009[i].wf_categoryCode.length-4),name:BIAOYIN0009[i].wf_categoryName});
					}
				}
				
				//企业和机构赋值
				for(var i=0;i<BIAOYIN0010.length;i++){
					if(BIAOYIN0010[i].wf_categoryCode.length > 4){
						BIAOYIN0010Code.push({id:BIAOYIN0010[i].wf_categoryCode,pId:BIAOYIN0010[i].wf_categoryCode.substring(0,BIAOYIN0010[i].wf_categoryCode.length-4),name:BIAOYIN0010[i].wf_categoryName});
					}				
				}
				
				$.fn.zTree.init($("#wf_newfl1"), setting, BIAOYIN0008Code);
				$.fn.zTree.init($("#wf_countryName_cn1"), setting, BIAOYIN0009Code);
				$.fn.zTree.init($("#wf_companyName_cn1"), setting, BIAOYIN0010Code);
				
				//初始化ztree
				var treeObj8 = $.fn.zTree.getZTreeObj("wf_newfl1");
				var treeObj9 = $.fn.zTree.getZTreeObj("wf_countryName_cn1");
				var treeObj10 = $.fn.zTree.getZTreeObj("wf_companyName_cn1");
				var text8 = "";
				var text9 = "";
				var text10 = "";
				for(var i=0;i<value8.length;i++){
					if(value8[i] != ""){
						var node8 = treeObj8.getNodeByParam("id", value8[i], null);
						treeObj8.checkNode(node8); 
						text8 += " "+node8.name+" ";
			            if(text8.substring(text8.lastIndexOf("<br>"),text8.length).length>64){
			            	text8 += "<br>";
			            };
					}
				}
				for(var i=0;i<value9.length;i++){
					if(value9[i] != ""){
						var node9 = treeObj9.getNodeByParam("id", value9[i], null);
						treeObj9.checkNode(node9); 
						text9 += " "+node9.name+" ";
			            if(text9.substring(text9.lastIndexOf("<br>"),text9.length).length>64){
			            	text9 += "<br>";
			            };
					}
				}
				for(var i=0;i<value10.length;i++){
					if(value10[i] != ""){
						var node10 = treeObj10.getNodeByParam("id", value10[i], null);
						treeObj10.checkNode(node10); 
						text10 += " "+node10.name+" ";
						if(text10.substring(text10.lastIndexOf("<br>"),text10.length).length>64){
			            	text10 += "<br>";
			            };
					}
				}
				$("#wf_newfl2").html(text8);
				$("#wf_countryName_cn2").html(text9);
				$("#wf_companyName_cn2").html(text10);
		
			}
		});
	}
	});
	
	
	/*
	*设置页面只读，由于目前业务需要，先不设置，以后等客户改完，继续设置（还没写代码）
	*/
	
	var cityid = "${dataMap.area}";
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
				citys = document.getElementById("area")
				citys.length = 0;

				for (i = 0; i < result.length; i++) {
					citys.options[i + 1] = new Option();
					citys.options[i + 1].text = result[i].column_name;
					citys.options[i + 1].value = result[i].columid;

					if (result[i].columid == cityid) {
						citys.options[i + 1].selected = "selected";
					}
					
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
		/* alert(fldDesc + "的值为：" + value); */

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

		if (fldType == "datetime") {
			if (value == null || isKong(value)) {
				alert(fldDesc + "不能为空！");
				element.focus();
				return false;
			}
			if (!isDate(value)) {
				alert(fldDesc + "格式不正确！请依照xxxx-xx-xx格式填写。");
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
	<div class="YJ2016_HTmain YJ2016_clearfix ">
		<h1 align="center">审核数据</h1>
		<div class="con leftmenu-zhao">
			<form
				action='${context}/DBM/EditResData-${resId}-${dataMap.get("id")}.html'
				method="post" onsubmit="return mySubmit()"
				enctype="multipart/form-data">
				<table>
					<input type="hidden" name="resId" value="${resId}" />
					<input type="hidden" name="id" value='${dataMap.get("id")}' />
					<input type="hidden" name="currentPage" value="${currentPage}" />
					<c:choose>
						<c:when test="${ ri.resTemplate eq null || empty ri.resTemplate}">
							<c:forEach var="fld" items="${FldList}">
								<c:choose>
									<c:when test="${fld.fldId==977}">
										<tr>
											<td>${fld.fldDesc}:</td>
											<td><div
													style="float: left; width: 250px; height: 250px; overflow: auto; background: white; border: 1px solid;">
													<ul id="${fld.fldName}1" class="ztree"></ul>
												</div>
												<div>
													<span id="${fld.fldName}2"></span>
												</div> <input type="hidden" value='${dataMap.get(fld.fldName)}'
												name="${fld.fldName}" id="${fld.fldName}3"></td>
										</tr>
									</c:when>
									<c:when test="${fld.fldId==978}">
										<tr>
											<td>${fld.fldDesc}:</td>
											<td><div
													style="float: left; width: 250px; height: 250px; overflow: auto; background: white; border: 1px solid;">
													<ul id="${fld.fldName}1" class="ztree"></ul>
												</div>
												<div>
													<span id="${fld.fldName}2"></span>
												</div> <input type="hidden" value='${dataMap.get(fld.fldName)}'
												name="${fld.fldName}" id="${fld.fldName}3"></td>
										</tr>
									</c:when>
									<c:when test="${fld.fldId==979}">
										<tr>
											<td>${fld.fldDesc}:</td>
											<td><div
													style="float: left; width: 250px; height: 250px; overflow: auto; background: white; border: 1px solid;">
													<ul id="${fld.fldName}1" class="ztree"></ul>
												</div>
												<div>
													<span id="${fld.fldName}2"></span>
												</div> <input type="hidden" value='${dataMap.get(fld.fldName)}'
												name="${fld.fldName}" id="${fld.fldName}3"></td>
										</tr>
									</c:when>
									<c:when test="${fld.fldId==822}">
										<tr>
											<td>${fld.fldDesc}:</td>
											<td><input type="radio" name="${fld.fldName}"
												<c:if test="${dataMap.get(fld.fldName)==1}">checked="checked"</c:if>
												value="1" />男 <input type="radio" name="${fld.fldName}"
												<c:if test="${dataMap.get(fld.fldName)==0}">checked="checked"</c:if>
												value="0">女</td>
									</c:when>
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
									<c:when test="${fld.fldId==306}">
										<tr>
											<td class="aname">${fld.fldDesc}:</td>
											<td><select id="${fld.fldId}" name="${fld.fldName}"
												style="padding: 0 10px; height: 30px;">
													<option value="1">技术经济表</option>
													<option value="2">技术经济表</option>
													<option value="3">技术经济表</option>
											</select></td>
										</tr>
									</c:when>
									<c:when test="${fld.fldId==825}">
										<tr>
											<td class="aname">${fld.fldDesc}:</td>
											<td><select id="${fld.fldId}" name="${fld.fldName}"
												style="padding: 0 10px; height: 30px;">
													<option value="1">第一届专家团队</option>
													<option value="2">第二届专家团队</option>
													<option value="3">第二届专家团队</option>
											</select></td>
										</tr>
									</c:when>

									<c:when test="${fld.fldId==296}">
										<tr>
										<tr>
											<td>${fld.fldDesc}:</td>
											<td><input name="${fld.fldName}" type="${fld.fldType}"
												value="${dataMap.get(fld.fldName)}"
												style="width: 100px; height: 30px; padding-left: 5px; border: 1px solid #a9a9a9;" />
											</td>
										</tr>
									</c:when>
									<c:when test="${fld.fldId==286}">
										<tr>
										<tr>
											<td>${fld.fldDesc}:</td>
											<td><input name="${fld.fldName}" type="${fld.fldType}"
												value="${dataMap.get(fld.fldName)}"
												style="width: 100px; height: 30px; padding-left: 5px; border: 1px solid #a9a9a9;" />
											</td>
										</tr>
									</c:when>
									<c:when test="${fld.fldId==297}">
										<tr>
										<tr>
											<td>${fld.fldDesc}:</td>
											<td><input name="${fld.fldName}" type="${fld.fldType}"
												value="${dataMap.get(fld.fldName)}"
												style="width: 100px; height: 30px; padding-left: 5px; border: 1px solid #a9a9a9;" />
											</td>
										</tr>
									</c:when>
									<c:when test="${fld.fldInputType=='radio'}">
										<tr>
											<td>${fld.fldDesc}:</td>
											<td><input type="radio" name="${fld.fldName}"
												<c:if test="${dataMap.get(fld.fldName)==1}">checked="checked"</c:if>
												value="1" />是 <input type="radio" name="${fld.fldName}"
												<c:if test="${dataMap.get(fld.fldName)==0}">checked="checked"</c:if>
												value="0">否</td>
									</c:when>
									<c:when test="${fld.fldInputType=='datetime'}">
										<tr>
											<td class="aname">${fld.fldDesc}:</td>
											<td><input style="width: 205px; height: 30px;"
												id="${fld.fldId}" class="Wdate" type="text"
												name="${fld.fldName}" onClick="WdatePicker()"></td>
									</c:when>
									<c:when test="${fld.fldInputType=='file'}">
										<tr>
											<td>${fld.fldDesc}:</td>
											<td><div class="image">
													<img class="default"
														style="width: 200px; height: 200px; margin: 0 auto;"
														src="${context}/images/upload/userPhoto/${dataMap.get(fld.fldName)}"
														alt="无${fld.fldDesc}"></img>
												</div>上传新${fld.fldDesc}<input name="myfiles"
												type="${fld.fldInputType}" /></td>
											<td></td>
										</tr>
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
									<%-- <c:when test="${fld.fldInputType=='datetime'}">
								<tr>
									<td class="aname">${fld.fldDesc}:</td>
									<td><input style="width: 205px; height: 30px;"
										id="${fld.fldId}" class="Wdate" type="text" name="Startdate"
										onClick="WdatePicker()"></td>
							</c:when> --%>

									<c:when test="${fld.fldInputType=='textarea'}">
										<tr>
											<td>${fld.fldDesc}:</td>
											<td>
												<%-- <textarea rows="4" cols="80" name="${fld.fldName}">${dataMap.get(fld.fldName)}</textarea>--%>
												<textarea class="ckeditor textarea1" cols="25"
													name="${fld.fldName}" rows="10">
																<c:if test="${ not empty dataMap.get(fld.fldName)}">${dataMap.get(fld.fldName)}</c:if>
																<c:if test="${empty dataMap.get(fld.fldName)}"></c:if>
														</textarea>
											</td>
										</tr>
										<script>
								CKEDITOR.replace("${fld.fldId}");
							</script>
									</c:when>
									<c:when test="${fld.fldId==301}">
										<tr>
											<td class="aname">${fld.fldDesc}:</td>
											<td><select id="${fld.fldId}" name="${fld.fldName}"
												style="padding: 0 10px; height: 30px;">
													<option value="2">新书预售-首页滚动图书</option>
													<option value="1">新书上架-炼钢1-首页显示产品</option>
													<option value="4">新书上架-炼铁2</option>
													<option value="5">新书上架-轧钢3新书预售</option>
													<option value="6">新书上架-稀土4</option>
													<option value="7">新书上架-品种钢5</option>
													<option value="3">MetalInfo推荐第一页</option>
													<option value="8">MetalInfo推荐第二页</option>

											</select></td>
										</tr>
									</c:when>
									<%-- 	<c:when test="${fld.fldId==94}">
								<tr>
									<td>${fld.fldDesc}:</td>
									<td><select name="${fld.fldName}">
											<c:forEach var="cate" items="${cateList}">
												<option value="${cate.id}"
													<c:if test="${dataMap.get(fld.fldName) == cate.id}">selected="selected"</c:if>>${cate.name}</option>
											</c:forEach>
									</select></td>
								</tr>
							</c:when>
						<c:when test="${fld.fldId==102}">
								<tr>
									<td>${fld.fldDesc}:</td>
									<td><select name="${fld.fldName}">
											<c:forEach var="cate" items="${cateList}">
												<option value="${cate.id}"
													<c:if test="${dataMap.get(fld.fldName) == cate.id}">selected="selected"</c:if>>${cate.name}</option>
											</c:forEach>
									</select></td>
								</tr>
							</c:when> --%>
									<c:when test="${fld.fldInputType=='text'}">
										<tr>
										<tr>
											<td>${fld.fldDesc}:</td>
											<td><input name="${fld.fldName}" type="${fld.fldType}"
												value="${dataMap.get(fld.fldName)}"
												style="width: 250px; height: 30px; padding-left: 5px; border: 1px solid #a9a9a9;" />
											</td>
										</tr>
									</c:when>
									<c:when test="${fld.getFldId()=='825'}">
										<td><c:if test="${datamap.get(fld.getFldName())=='1'}">第一届专家团队</c:if>
											<c:if test="${datamap.get(fld.getFldName())=='2'}">第二届专家团队</c:if>
											<c:if test="${datamap.get(fld.getFldName())=='3'}">第三届专家团队</c:if>
										</td>
									</c:when>
									<c:otherwise>
										<tr>
											<td>${fld.fldDesc}:</td>
											<td><input name="${fld.fldName}" type="${fld.fldType}"
												value="${dataMap.get(fld.fldName)}"
												style="width: 550px; height: 30px; padding-left: 5px; border: 1px solid #a9a9a9;" />
											</td>
										</tr>
									</c:otherwise>
								</c:choose>
							</c:forEach>

							<tr>
								<td colspan="2" class="btnGroup" align="center"><input
									type="submit" class="HDZJ2016ht_button1" value="保存"> <input
									type="reset" class="HDZJ2016ht_button1" value="重置"> <input
									type="button" class="HDZJ2016ht_button1" value="取消"
									onclick="window.history.go(-1)"></td>
							</tr>
						</c:when>
						<c:otherwise>
							<%-- ${ri.resTemplate } --%>
							<c:forEach var="Var" items="${list }">
								<c:if test="${Var.fldIsEnter == 1 }">
									<c:choose>
										<c:when test="${Var.fldId==977}">
											<tr>
												<td>${Var.fldDesc}:</td>
												<td><div
														style="float: left; width: 250px; height: 250px; overflow: auto; background: white; border: 1px solid;">
														<ul id="${Var.fldName}1" class="ztree"></ul>
													</div>
													<div>
														<span id="${Var.fldName}2"></span>
													</div> <input type="hidden" value='${dataMap.get(Var.fldName)}'
													name="${Var.fldName}" id="${Var.fldName}3"></td>
											</tr>
										</c:when>
										<c:when test="${Var.fldId==978}">
											<tr>
												<td>${Var.fldDesc}:</td>
												<td><div
														style="float: left; width: 250px; height: 250px; overflow: auto; background: white; border: 1px solid;">
														<ul id="${Var.fldName}1" class="ztree"></ul>
													</div>
													<div>
														<span id="${Var.fldName}2"></span>
													</div> <input type="hidden" value='${dataMap.get(Var.fldName)}'
													name="${Var.fldName}" id="${Var.fldName}3"></td>
											</tr>
										</c:when>
										<c:when test="${Var.fldId==979}">
											<tr>
												<td>${Var.fldDesc}:</td>
												<td><div
														style="float: left; width: 250px; height: 250px; overflow: auto; background: white; border: 1px solid;">
														<ul id="${Var.fldName}1" class="ztree"></ul>
													</div>
													<div>
														<span id="${Var.fldName}2"></span>
													</div> <input type="hidden" value='${dataMap.get(Var.fldName)}'
													name="${Var.fldName}" id="${Var.fldName}3"></td>
											</tr>
										</c:when>
										<c:when
											test="${Var.fldHtmlTag !=null && Var.fldHtmlTag == 'input' }">
											<tr>
												<td class="aname">${Var.fldDesc}:</td>
												<c:choose>
													<c:when test="${Var.fldTagType == 'text' }">
														<c:if
															test="${Var.tagdefaultValue != null && Var.tagdefaultValue != '' }">
															<td><input type="${Var.fldTagType }"
																name="${Var.fldName}" value="${Var.tagdefaultValue}" /></td>
														</c:if>
														<c:if
															test="${Var.tagdefaultValue == null || Var.tagdefaultValue == '' }">
															<td><input type="${Var.fldTagType }"
																name="${Var.fldName}"
																value="${dataMap.get(Var.fldName)}" /></td>
														</c:if>
													</c:when>
													<c:otherwise>
														<c:if
															test="${Var.tagdefaultValue != null && Var.tagdefaultValue != '' }">
															<td><input type="${Var.fldTagType }"
																name="${Var.fldName}" value="${Var.tagdefaultValue}" /></td>
														</c:if>
														<c:if
															test="${Var.tagdefaultValue == null || Var.tagdefaultValue == '' }">
															<td><input type="${Var.fldTagType }"
																name="${Var.fldName}"
																value="${dataMap.get(Var.fldName)}" /></td>
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
														name="${Var.fldName}">${dataMap.get(Var.fldName)}</textarea></td>
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
														<td><select id="${Var.fldName}" name="${Var.fldName}">
																<c:choose>
																	<c:when test="${dataMap.get(Var.fldName) == '1'}">
																		<option value="1" selected="selected">中文</option>
																	</c:when>
																	<c:otherwise>
																		<option value="1">中文</option>
																	</c:otherwise>
																</c:choose>
																<c:choose>
																	<c:when test="${dataMap.get(Var.fldName) == '2'}">
																		<option value="2" selected="selected">英文</option>
																	</c:when>
																	<c:otherwise>
																		<option value="2">英文</option>
																	</c:otherwise>
																</c:choose>
																<c:choose>
																	<c:when test="${dataMap.get(Var.fldName) == '3'}">
																		<option value="3" selected="selected">德文</option>
																	</c:when>
																	<c:otherwise>
																		<option value="3">德文</option>
																	</c:otherwise>
																</c:choose>
																<c:choose>
																	<c:when test="${dataMap.get(Var.fldName) == '4'}">
																		<option value="4" selected="selected">法文</option>
																	</c:when>
																	<c:otherwise>
																		<option value="4">法文</option>
																	</c:otherwise>
																</c:choose>
																<c:choose>
																	<c:when test="${dataMap.get(Var.fldName) == '5'}">
																		<option value="5" selected="selected">意大利文</option>
																	</c:when>
																	<c:otherwise>
																		<option value="5">意大利文</option>
																	</c:otherwise>
																</c:choose>
																<c:choose>
																	<c:when test="${dataMap.get(Var.fldName) == '6'}">
																		<option value="6" selected="selected">日文</option>
																	</c:when>
																	<c:otherwise>
																		<option value="6">日文</option>
																	</c:otherwise>
																</c:choose>
														</select></td>
													</c:when>

													<c:when
														test="${Var.fldTagType!= null && Var.fldTagType == 'origin' }">
														<td><select id="${Var.fldName}" name="${Var.fldName}">
																<c:forEach var="item" items="${MIDataBase}"
																	varStatus="status">
																	<c:if
																		test="${(dataMap.get(Var.fldName)==null || dataMap.get(Var.fldName) !='null')&& status.index==14}">
																		<option value="${item.id}" selected="selected">${item.wf_MIdatabaseName}</option>
																	</c:if>
																	<c:if test="${dataMap.get(Var.fldName)==item.id}">
																		<option value="${item.id}" selected="selected">${item.wf_MIdatabaseName}</option>
																	</c:if>
																	<c:if
																		test="${dataMap.get(Var.fldName)!='null' && dataMap.get(Var.fldName)!=item.id && status.index!=14}">
																		<option value="${item.id}">${item.wf_MIdatabaseName}</option>
																	</c:if>
																</c:forEach>
														</select></td>
													</c:when>
													<c:when
														test="${Var.fldTagType!= null && Var.fldTagType == 'other' }">
														<td><select id="${Var.fldName}" name="${Var.fldName}">
																<c:if test="${Var.tagAdditional != null}">${Var.tagAdditional}</c:if>
														</select></td>
													</c:when>
												</c:choose>
											</tr>
										</c:when>
										<c:otherwise>
											<tr>
												<td class="aname">${Var.fldDesc}:</td>
												<td><input type="text" name="${Var.fldName}"
													value="${dataMap.get(Var.fldName)}" /></td>
											</tr>
										</c:otherwise>
									</c:choose>
								</c:if>
							</c:forEach>
							<c:if test="${resInfo.resFlow=='1'}">
								<tr>
									<td>审核</td>
									<td><input type="radio" name="pubflag"
										<c:if test="${dataMap.get('pubFlag')=='1'}">checked="checked" </c:if>
										value="1" />通过&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio"
										name="pubflag" value="2" checked="checked"
										<c:if test="${dataMap.get('pubFlag')=='2'}">checked="checked" </c:if> />不通过</td>
								</tr>
							</c:if>
							<tr>
								<td colspan="2" class="btnGroup" align="center"><input
									type="submit" class="HDZJ2016ht_button1" value="保存"> <input
									type="button" class="HDZJ2016ht_button1" value="取消"
									onclick="window.history.go(-1)"></td>
							</tr>
						</c:otherwise>
					</c:choose>
				</table>
			</form>
		</div>
		<!--con-->
	</div>
	<!--YJ2016_HTmain-->
	<%-- <jsp:include page="../manage/include/bottom.jsp"></jsp:include> --%>
</body>
</html>