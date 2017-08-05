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
<title>订单管理_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript" src="${context}/js/WdatePicker.js"></script>
<style>
.kc{
	width: 400px;
	height:500px;
    border: 1px solid #3388ff;
    position: ;
    left: 215px;
    background: #fff;
    padding: 15px;
    border-left: 1px solid #d5d5d5;
    min-height: 358px;
    z-index:99;
    overflow:-Scroll;
    overflow-y:hidden
}
.kc{
	border: 1px #DDDDDD solid;
	margin: 10px 10px  10px 60px;
}
.kc a{
	display: inline-block;
    margin-right: 15px;
    padding-left: 30px;
    color: #3875b8;
    width: 50px;
    border: 1px solid #ccc;
    box-shadow: 5px 5px 10px #EFEFEF inset;
}
</style>
<script type="text/javascript" >
function save(val){
	var jsonArray = [];
	var json = new Object;
	var objs = document.getElementsByName("kcIndex");
	for(ob in objs){
		if(objs[ob].checked){
			json.resId=objs[ob].value;
			json.indexIfSearch_kc=1;
			jsonArray.push(json);
		}else{
			json.resId=objs[ob].value;
			json.indexIfSearch_kc=0;
			jsonArray.push(json);
		}
	}
	//JSON.stringify(jsonArray);
	for(var i=0;i<jsonArray.length;i++){
		jsonArray[i];
	}
	
	/* var jsonArray = [];
	var json = new Object;
	json.a="";
	json.b="";
	jsonArray.push(json);
	JSON.stringify(jsonArray);
	
	$.ajax({
		 url:"${context}/manage/changeProPage.html?ran="+Math.random(),
		 data:{kl:val,indexList:jsonArray},
		 type:"post",
		 success:function(data){
	   	}
   }); */
}
</script>
</head>
<body>
	<div class="YJ2016_HTmain YJ2016_clearfix ">
		<div class="con1 orderCon1">
				<div class="search1 orderSearch1">
				<table>
				<tr>
				<td>
					<div class="kc">
						<h1>知识中心可检索库设置</h1>
						<c:forEach items="${indexNameKLlist }" var="kc">
							<p><input name="kcIndex" type="checkbox" value="${kc.resId}" <c:if test="${kc.indexIfSearch_kc==1}">checked=checked</c:if>>${kc.resName}</p>
						</c:forEach>
						<a href="javascript:void(0)" onclick="save(1)">保存</a>
					</div>
					</td>
				<td>
					<div class="kc">
						<h1>文献中心可检索库设置</h1>
						<c:forEach items="${indexNameKLlist }" var="lc">
							<p><input name="lcIndex" type="checkbox" value="${lc.resId}" <c:if test="${lc.indexIfSearch_lc==1}">checked=checked</c:if>>${lc.resName}</p>
						</c:forEach>
						<a href="javascript:void(0)" onclick="save(2)">保存</a>
					</div>
				</td>
				</tr>
				</table>
					
					
					<%-- <div class="os_left" style="width: 340px">
						<p>
							<span style="width: 110px">订单编号：</span><input type="text"
								id="bianhao" name="bianhao" class="osTxt1" value="${bianhao}" />
						</p>
					</div>
					<div class="os_right">
						<p>
							<span style="width: 110px">订单状态：</span> <select name="zhuangtai">
								<c:forEach var="status" items="${orderstatus}">
									<c:if test="${status.wf_orderstatus==zhuangtai}">
										<option selected="selected" value="${status.wf_orderstatus}">${status.wf_orderstatustype}</option>
									</c:if>
									<c:if test="${status.wf_orderstatus!=zhuangtai}">
										<option value="${status.wf_orderstatus}">${status.wf_orderstatustype}</option>
									</c:if>
								</c:forEach>
							</select>
						</p>
					</div> --%>
					<!-- <div style="text-align: center;">
						<a href="javascript:void(0)" onclick="checked()" class="osBtn">保存</a>
					</div> -->
				</div>

		</div>
	</div>
</body>
</html>