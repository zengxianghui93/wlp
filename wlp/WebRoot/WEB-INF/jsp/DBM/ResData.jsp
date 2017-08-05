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
<title>维护数据_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<style type="text/css">
.leftmenu-zhao {
	border: 1px solid #ccc;
	height: 530px;
	width: 98%;
	overflow: scroll;
	overflow-y: hidden;
}
</style>
<script type="text/javascript">
var html = '';//可检索字段
var DIV_NUM = 2;//检索条件的id后缀
	$(function(){
		if("${deleted}"=="0"){
			$("#zhixingCon").html("<option value='3'>批量恢复</option>");
		}else if("${deleted}"=="1"){
			if("${resInfo.resFlow}"==1){
				$("#zhixingCon").html("<option value='0'>批量审核通过</option><option value='1'>批量审核不通过</option><option value='2'>批量删除</option>");
			}else{
				$("#zhixingCon").html("<option value='2'>批量删除</option>");
			}
		}
		
		//拼接可检索字段
		<c:forEach var="fld" items="${searchFldList}">
			html += '<option value="${fld.getFldName()}">${fld.getFldDesc()}</option>'; 
		</c:forEach>
		var fldNames2 = "${fldNames}".split(",");
		var keyword2s2 = "${keyword2s}".split(",");
		var andORor2 = "${andORor}".split(",");
		
		$("#searchList1").find("select").html(getHtml(fldNames2[0]));
		$("#searchList1").find("input").val(keyword2s2[0]);
		for(var i=1;i<fldNames2.length;i++){
			var html1 = getHtml(fldNames2[i]);
			addSeach(i,andORor2[i],html1,keyword2s2[i]);
		}
		setCheckbox(0);
	})


	function getHtml(value){
		var html3 = ""; 
		<c:forEach var="fld" items="${searchFldList}">
			if("${fld.getFldName()}"==value){
				html3 += '<option value="${fld.getFldName()}" selected="selected"> ${fld.getFldDesc()}</option>'; 
			}else{
				html3 += '<option value="${fld.getFldName()}">${fld.getFldDesc()}</option>'; 
			}
		</c:forEach>
		return html3;
	}

	function setCheckbox(value){
		if(value==0||value==1){
			$(".talbleTr").each(function(){
				if($(this).children("td").last().prev().text().trim()=='审核通过'){
					$(this).children("td").eq(0).children().hide();
				};
			});
		}else{
			$(".talbleTr").each(function(){
				$(this).children("td").eq(0).children().show();
			});
		}
	}
	
	function search111Style(){
		var px = 150 + 34*$(".searchList").length;
		$("#search111").attr("style","margin-top: 20px;height: "+px+"px");
	}
	
	function setContext(addr){
		addr += "?pubFlag="+$("#pubFlag").val();
		addr += "&isGather="+$("#isGather").val();
		addr += "&fldName="+$("#fldName").val();
		addr += "&keyword2="+$("#keyword2").val();
		addr += "&resFlow=${resInfo.resFlow}";
		addr += "&deleted=${deleted}";
		addr += "&currentPage=${page.currentPage}";
		window.location.href = addr;
	}
	function changeCheckbox(){
		var boxes = document.getElementsByName("checkBoxs");
		if($("#changeCheckbox").is(':checked')){
			for(var i=0;i<boxes.length;i++){
	             boxes[i].checked = true;
		    }
		}else{
			for(var i=0;i<boxes.length;i++){
	             boxes[i].checked = false;
		    }
		};
	}
	
	function piliang(){
		var ids = "";
		var boxes = document.getElementsByName("checkBoxs");
		for(var i=0;i<boxes.length;i++){
			if(boxes[i].style.display!='none'){
	            if(boxes[i].checked){
	            	if(ids != ""){
	            		ids += ","+boxes[i].value;
	            	}else{
	            		ids += boxes[i].value;
	            	}
	            }
            }
	    }
		if(ids==""){
			alert("没有选择数据");
			return;
		}
		if(confirm("确定执行？")){
			var addr="${context}/DBM/piliang-${ResId}.html?talName=${resInfo.resTblName}&zhixingCon="+$("#zhixingCon").val()+"&ids="+ids;
			addr += "&pubFlag="+$("#pubFlag").val();
			addr += "&isGather="+$("#isGather").val();
			addr += "&fldName="+$("#fldName").val();
			addr += "&keyword2="+$("#keyword2").val();
			addr += "&resFlow=${resInfo.resFlow}";
			addr += "&currentPage=${page.currentPage}";
			addr += "&deleted=${deleted}";
			window.location.href = addr;
		}
	}
	function tiaozhuan(){
		var currenPage2 = $("#currenPage2").val().trim();
		if(!/^[0-9]{1,}$/.test(currenPage2)){
			alert("请输入正确数字");
			$("#currenPage2").val("${page.currentPage}");
			return false;
		}
		if(currenPage2*1==0){
			alert("请输入有效数字");
			$("#currenPage2").val("${page.currentPage}");
			return false;
		}
		if(currenPage2*1>"${page.get('totalPage')}"*1){
			alert("请输入不大于总页数的数字");
			$("#currenPage2").val("${page.currentPage}");
			return false;
		}
		$("#tiaozhuan1").text("跳转中..");
		$("#tiaozhuan1").attr("href","${context}/DBM/PageData-${ResId}.html?currentPage="+currenPage2+"&numPerPage=10");
		return true;
	}
	
	function addSeach(num,andORor,html1,keyword2){
		if($(".searchList").length*1==5){
			alert("最多为5条");
			return;
		} 
		var divs = '<div class="search userSearch searchList" style="width:100%;border: 0px;height:40px;margin:-10px" id ="searchList'+DIV_NUM+'"><h2><select style="width: 60px; text-align: center; padding-left: 10px;" name="andORor">';
		
		if(andORor=="or"){
			divs += '<option value="and">与</option><option value="or" selected="selected">或</option></select><select name="fldNames">'; 
		}else{
			divs += '<option value="and">与</option><option value="or">或</option></select><select name="fldNames">'; 
		}
		
		if(html1==""){
			divs += html;
		}else{
			divs += html1;
		}
		
		divs += '</select> <input type="text" value="'+keyword2+'" name="keyword2s"/><em onclick="addSeach('+DIV_NUM+',\'\',\'\',\'\')"></em><strong onclick="delSearch('+DIV_NUM+')"></strong></h2></div>'; 
		$("#searchList"+num).after(divs);
		DIV_NUM = DIV_NUM*1+1;
		search111Style()
	}
	function delSearch(num){
		if(num==1){
			alert("第一条不允许删除");
			return;
		}
		$("#searchList"+num).remove();
		search111Style()
	}
	
	//导出检索结果
	function exportjg(){
		con = confirm("你确定要导出当前结果(仅限前10000条)？");
		if(con){
			return true;
		}else{
			return false;
		}
	}
	/*------将MI情报库中的检索结果导入到数据中心的数据报道-------*/
	function dataToSJBD(){
		$.ajax({
			type:"get",
			url:"${context}/datacenter/import/News.html",
			success:function(msg){
				
				if(msg.status==1){
					alert("导入成功！");
					//alert("导入"+msg.count+" 条！");
				}
				if(msg.status==0){
					alert("导入失败！");
				}
			}
		});
	}
	
	/* function check(){
		var input = document.getElementsByName("keyword2s");
		for(var i=0;i<input.length;i++){
			if(input[i].value.trim()==""){
				alert("请输入查询内容")
				return false;
			}
		}
		return true;
	} */
</script>
</head>
<body>
	<!-- 顶部样式引入 -->
	<div class="YJ2016_HTmain YJ2016_clearfix ">
		<!-- 左侧功能菜单引入 -->
		<div class="con">
			<div class="userbtn">
				<a href="${context}/DBM/AddData-${ResId}.html" class="useradd"
					style="width: 70px;">添加数据</a>
				<%-- <c:if test="${resInfo.resFlow==1}">
					<a href="${context}/DBM/CheckData-${ResId}.html" class="userfresh"
						style="width: 80px; padding-left: 35px; background: url(../images/htCreate.png) no-repeat 7px center;">待审核数据</a>
				</c:if> --%>
				<a href="javascript:history.go('-1')" class="userfresh ResBack"
					style="background: url(../images/hrefRight.png) no-repeat 7px center;">返回</a>
			</div>

			<%-- <table class="resBtn" style="margin-top: 20px;">
				<tr>
					<td
						style="text-align: center; line-height: 35px; background: #3575b5; width: 33%">
						<a href="${context}/DBM/AddData-${ResId}.html"
						style="color: #fff;">添加数据</a>
					</td>
					<c:if test="${resInfo.resFlow==1}">
						<td
							style="text-align: center; line-height: 35px; background: #3575b5; width: 33%">
							<a href="${context}/DBM/CheckData-${ResId}.html"
							style="color: #fff;">待审核数据</a>
						</td>
					</c:if>
					<td
						style="text-align: center; line-height: 35px; background: #3575b5; width: 33%">
						<a href="javascript:history.go('-1')" class="ResBack"
						style="color: #fff;">返回</a>
					</td>
				</tr>
			</table> --%>
			<div class="search" style="margin-top: 20px; height: 150px"
				id="search111" align="center">
				<form action="${context}/DBM/searchData-${ResId}.html" method="post">
					<input type="hidden" value="${resInfo.resFlow}" name="resFlow" />
					<c:if test="${resInfo.resFlow==1}">审核状态： <select
							name="pubFlag" id="pubFlag">
							<option value=""
								<c:if test="${pubFlag==''}">selected="selected"</c:if>>所有</option>
							<option value="0"
								<c:if test="${pubFlag=='0'}">selected="selected"</c:if>>未审核</option>
							<option value="1"
								<c:if test="${pubFlag=='1'}">selected="selected"</c:if>>审核通过</option>
							<option value="2"
								<c:if test="${pubFlag=='2'}">selected="selected"</c:if>>审核未通过</option>
						</select>
						审核人： <select name="checkUsersNo" id="checkUsersNo">
							<option value=""
								<c:if test="${checkUsersNo==''}">selected="selected"</c:if>>所有</option>
							<c:forEach var="item" items="${checkUsers}">
								<option value="${item.userId}"
									<c:if test="${checkUsersNo==item.userId}">selected="selected"</c:if>>${item.userName}</option>
							</c:forEach>
						</select>

					</c:if>
					<c:if test="${resInfo.resTblName=='wf_b_mi'}">数据类型： 
							<select name="isGather" id="isGather">
							<option value=""
								<c:if test="${isGather==''}">selected="selected"</c:if>>所有</option>
							<option value="0"
								<c:if test="${isGather=='0'}">selected="selected"</c:if>>采集数据</option>
							<option value="1"
								<c:if test="${isGather=='1'}">selected="selected"</c:if>>本地数据</option>
						</select>
					</c:if>
					<c:if test="${isAdmin=='true'}">
						删除类型： 
							<select name="deleted" id="deleted">
							<option value=""
								<c:if test="${deleted==''}">selected="selected"</c:if>>所有</option>
							<option value="0"
								<c:if test="${deleted=='0'}">selected="selected"</c:if>>已删除</option>
							<option value="1"
								<c:if test="${deleted=='1'}">selected="selected"</c:if>>未删除</option>
						</select>
					</c:if>
					<%-- <br>检索字段： <select name="fldName" id="fldName" style="margin-top: 2px">
							<c:forEach var="fld" items="${searchFldList}">
								<option value="${fld.getFldName()}"
									<c:if test="${fld.getFldName()==searchfld}">selected="selected"</c:if>>${fld.getFldDesc()}
								</option>
							</c:forEach>
						</select> 关键字： <input style="width: 320px;"
							type="text" name="keyword2" value="${keyword2}" id="keyword2"/> --%>
					<div class="search userSearch searchList"
						style="width: 100%; border: 0px; margin-bottom: 0px;"
						id="searchList1">
						<h2>
							<select name="fldNames">
							</select> <input type="text" name="keyword2s" /> <em
								onclick="addSeach('1','','','')"></em><strong
								onclick="delSearch(1)"></strong>
						</h2>
					</div>
					<input
						style="display: inline-block; width: 90px; height: 36px; background: url(../images/HTSearch.png) no-repeat 6px center #3575b5; line-height: 30px; color: #fff; padding-left: 10px; vertical-align: middle; margin-top: 10px"
						type="submit" value="检索" /> <input type="hidden" name="resId"
						value="${ResId}" />
					<c:if test="${isAdmin=='true'}">
						<c:if test="${resInfo.resId==25}">
							<c:if test="${deleted=='1'}">
								<c:if test="${pubFlag=='1'}">
									<input type="button"
										style="margin-left: 20px; display: inline-block; width: 150px; height: 36px; background: no-repeat 6px center #3575b5; line-height: 30px; color: #fff; vertical-align: middle; margin-top: 10px"
										value="将结果导入到数据中心" onclick="dataToSJBD();" />
								</c:if>
							</c:if>
						</c:if>
					</c:if>
				</form>
			</div>
			<div class="userbtn">
				<select id="zhixingCon"
					onchange="setCheckbox(options[selectedIndex].value)">
					<c:if test="${resInfo.resFlow==1}">
						<option value="0">批量审核通过</option>
						<option value="1">批量审核不通过</option>
					</c:if>
					<option value="2">批量删除</option>
					<option value="3">批量恢复</option>
				</select>
				<button onclick="piliang()">执行</button>

			</div>
			<div>
				<table>
					<tr class="tit">
						<td><input type="checkbox" onclick="changeCheckbox()"
							id="changeCheckbox" /></td>
						<td>序号</td>
						<c:if test="${resInfo.resTblName!='zhuantiDB'}">
							<td>文章id</td>
						</c:if>
						<c:forEach var="fld" items="${lstFld}">
							<c:if test="${fld.getFldList()==1}">
								<td>${fld.getFldDesc()}</td>
							</c:if>
						</c:forEach>
						<c:if test="${resInfo.resTblName=='zhuantiDB'}">
							<td>修改模板</td>
						</c:if>
						<c:if test="${resInfo.resFlow==1}">
							<td>审核状态</td>
							<td>审核人</td>
						</c:if>
						<c:if test="${resInfo.resTblName=='wf_b_mi'}">
							<td>任务编号</td>
						</c:if>
						<td>操作</td>
					</tr>

					<c:forEach var="datamap" items="${dataList}" varStatus="status">
						<c:choose>
							<c:when test="${datamap.get(fld.getFldName()) =='1'}">
								<tr style="display: none;"></tr>
							</c:when>
							<c:otherwise>
								<tr class="talbleTr">
									<td align="center"><input type="checkbox" name="checkBoxs"
										value="<c:if test="${datamap.get('id')!=null}">${datamap.get('id')}</c:if>
								<c:if test="${datamap.get('f_id')!=null}">${datamap.get('f_id')}</c:if>" /></td>
									<td class="td1">${(page.currentPage-1)*10+status.index+1}</td>
									<c:if test="${resInfo.resTblName!='zhuantiDB'}">
										<td><c:if test="${datamap.get('id')!=null}">${datamap.get('id')}</c:if>
											<c:if test="${datamap.get('f_id')!=null}">${datamap.get('f_id')}</c:if></td>
									</c:if>
									<c:forEach var="fld" items="${lstFld}">
										<c:if test="${fld.getFldList()==1}">
											<c:choose>
												<c:when test="${fld.getFldId()=='822'}">
													<c:if test="${datamap.get(fld.getFldName())=='1'}">
														<td>男</td>
													</c:if>
													<c:if test="${datamap.get(fld.getFldName())=='0'}">
														<td>女</td>
													</c:if>
												</c:when>
												<c:when test="${fld.getFldId()=='825'}">
													<c:if test="${datamap.get(fld.getFldName())=='1'}">
														<td>第一届专家团队</td>
													</c:if>
													<c:if test="${datamap.get(fld.getFldName())=='2'}">
														<td>第二届专家团队</td>
													</c:if>
													<c:if test="${datamap.get(fld.getFldName())=='3'}">
														<td>第三届专家团队</td>
													</c:if>
												</c:when>
												<c:when test="${fld.getFldId()=='301'}">
													<c:if test="${datamap.get(fld.getFldName())=='1'}">
														<td>新书上架1首页显示产品</td>
													</c:if>
													<c:if test="${datamap.get(fld.getFldName())=='2'}">
														<td>新书预售首页滚动图书</td>
													</c:if>
													<c:if test="${datamap.get(fld.getFldName())=='3'}">
														<td>MetalInfo推荐第一页</td>
													</c:if>
													<c:if test="${datamap.get(fld.getFldName())=='4'}">
														<td>新书上架2</td>
													</c:if>
													<c:if test="${datamap.get(fld.getFldName())=='5'}">
														<td>新书预售</td>
													</c:if>
													<c:if test="${datamap.get(fld.getFldName())=='6'}">
														<td>新书上架4</td>
													</c:if>
													<c:if test="${datamap.get(fld.getFldName())=='7'}">
														<td>新书上架5</td>
													</c:if>
													<c:if test="${datamap.get(fld.getFldName())=='8'}">
														<td>MetalInfo推荐第一页</td>
													</c:if>
												</c:when>
												<c:otherwise>
													<c:if test="${fld.getFldName() == 'wf_title' }">
														<td><a name="titles"
															href="${context}/MI/Read-${ResId}-${datamap.get('id')}.html?isYL=yes"
															target="_blank" style="color: #333;"
															title="${datamap.get(fld.getFldName())}"> <c:if
																	test="${datamap.get(fld.getFldName()).length()>25}">${fn:substring(datamap.get(fld.getFldName()),0,25)}..</c:if>
																<c:if
																	test="${datamap.get(fld.getFldName()).length()<=25}">${datamap.get(fld.getFldName())}</c:if>
														</a></td>
													</c:if>
													<c:if test="${fld.getFldName() != 'wf_title' }">
														<td>${datamap.get(fld.getFldName())}</td>
													</c:if>
												</c:otherwise>
											</c:choose>
										</c:if>
									</c:forEach>
									<c:if test="${resInfo.resTblName=='zhuantiDB'}">
										<td><a
											href="${context}/zhuanTiMo/toZhuanTiMo.html?zhuanTiId=${datamap.get('id')}">修改模板</a></td>
									</c:if>
									<c:if test="${resInfo.resFlow==1}">
										<td><c:if
												test="${datamap.get('pubFlag')=='0'||datamap.get('pubFlag')==null}">未审核</c:if>
											<c:if test="${datamap.get('pubFlag')=='1'}">审核通过</c:if> <c:if
												test="${datamap.get('pubFlag')=='2'}">审核未通过</c:if></td>
										<td>${datamap.get('checkedUserName')}</td>
									</c:if>
									<c:if test="${resInfo.resTblName=='wf_b_mi'}">
										<td><c:if test="${datamap.get('taskId')==null}">无</c:if>
											<c:if test="${datamap.get('taskId')!=null}">${datamap.get('taskId')}</c:if>
										</td>
									</c:if>
									<td class="td1"><c:if
											test="${datamap.get('deleted')=='1'}">
											<c:if test="${resInfo.resFlow==1}">
												<c:if
													test="${datamap.get('pubFlag')=='0'||datamap.get('pubFlag')==null}">
													<c:if
														test="${datamap.get('checkedUserId')==USER_CONTEXT.userId||isAdmin=='true'}">
														<a href="javascript:void(0)"
															onclick="setContext('${context}/DBM/CheckDataDetail-${ResId}-${datamap.get('id')}.html')">审核</a>
											&nbsp;&nbsp;</c:if>
													<c:if
														test="${datamap.get('updatedUserId')==USER_CONTEXT.userId||isAdmin=='true'||datamap.get('userId')==USER_CONTEXT.userId}">
														<a
															href="${context}/DBM/EditData-${ResId}-${datamap.get('id')}.html?currentPage=${page.currentPage}">修改</a>
											&nbsp;&nbsp;</c:if>
													<c:if test="${isAdmin=='true'}">
														<a
															href="${context}/DBM/delData-${ResId}-${datamap.get('id')}.html"
															onClick="return confirm('确实想删除吗？')">删除</a>
													</c:if>
													<%-- <a href="${context}/DBM/delData-${ResId}-${datamap.get('id')}.html"
											onClick="return confirm('确实想删除吗？')">删除</a> --%>
												</c:if>
												<c:if test="${datamap.get('pubFlag')=='1'}">
													<c:if test="${isAdmin=='true'}">
														<a
															href="${context}/DBM/EditData-${ResId}-${datamap.get('id')}.html?currentPage=${page.currentPage}">修改</a>
											&nbsp;&nbsp;</c:if>
													<%-- <a href="${context}/DBM/delData-${ResId}-${datamap.get('id')}.html"
											onClick="return confirm('确实想删除吗？')">删除</a> --%>
												</c:if>
												<c:if test="${datamap.get('pubFlag')=='2'}">
													<c:if
														test="${datamap.get('updatedUserId')==USER_CONTEXT.userId||isAdmin=='true'}">
														<a href="javascript:void(0)"
															onclick="setContext('${context}/DBM/CheckDataDetail-${ResId}-${datamap.get('id')}.html')">审核</a>
											&nbsp;&nbsp;</c:if>
													<c:if
														test="${datamap.get('updatedUserId')==USER_CONTEXT.userId||isAdmin=='true'||datamap.get('userId')==USER_CONTEXT.userId}">
														<a
															href="${context}/DBM/EditData-${ResId}-${datamap.get('id')}.html?currentPage=${page.currentPage}">修改</a>
											&nbsp;&nbsp;</c:if>
													<c:if test="${isAdmin=='true'}">
														<a
															href="${context}/DBM/delData-${ResId}-${datamap.get('id')}.html"
															onClick="return confirm('确实想删除吗？')">删除</a>
													</c:if>
												</c:if>
											</c:if>
											<c:if test="${resInfo.resFlow==0}">
												<c:if
													test="${datamap.get('updatedUserId')==USER_CONTEXT.userId||isAdmin=='true'||datamap.get('userId')==USER_CONTEXT.userId}">
													<a
														href="${context}/DBM/EditData-${ResId}-${datamap.get('id')}.html?currentPage=${page.currentPage}">修改</a>
										&nbsp;&nbsp;</c:if>
												<c:if test="${isAdmin=='true'}">
													<a
														href="${context}/DBM/delData-${ResId}-${datamap.get('id')}.html"
														onClick="return confirm('确实想删除吗？')">删除</a>
												</c:if>
											</c:if>
										</c:if> <c:if test="${datamap.get('deleted')=='0'}">
											<a
												href="${context}/DBM/recoverData-${ResId}-${datamap.get('id')}.html?talName=${resInfo.resTblName}"
												onClick="return confirm('确实想恢复吗？')">恢复</a>
										</c:if></td>
								</tr>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</table>
				<div class="page">
					${page.get("resName")} 共${page.get("totalRows")}条数据 <span>${page.currentPage}/${page.totalPage}</span>页
					<a
						href="${context}/DBM/PageData-${ResId}.html?currentPage=1&numPerPage=10">首页</a>
					<a
						href="${context}/DBM/PageData-${ResId}.html?currentPage=${page.get('prePage')}&numPerPage=10">上一页</a>
					<a
						href="${context}/DBM/PageData-${ResId}.html?currentPage=${page.get('nextPage')}&numPerPage=10">下一页</a>
					<a
						href="${context}/DBM/PageData-${ResId}.html?currentPage=${page.get('totalPage')}&numPerPage=10">末页</a>
					第<input type="text" value="${page.currentPage}"
						style="width: 70px; border: 1px solid #4f84ec; text-align: center; line-height: 29px"
						id="currenPage2" />页 <a href="javscript:void(0)"
						onclick="return tiaozhuan()" id="tiaozhuan1">跳转</a>
				</div>
			</div>

		</div>
		<!--con-->
	</div>
	<!--YJ2016_HTmain-->
</body>
</html>