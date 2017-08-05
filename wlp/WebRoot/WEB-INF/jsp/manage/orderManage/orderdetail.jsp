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
<link rel="stylesheet" type="text/css" href="${context}/css/mainHT.css">
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript" src="${context}/js/WdatePicker.js"></script>
</head>
<body>

	<!-- 引入头部 -->
	<%-- <jsp:include page="../include/top.jsp"></jsp:include> --%>
<%-- 	<div class="YJ2016_HTRote">
		<a href="${context}/DBM/resourceManage.html">首页</a>&nbsp;&nbsp;&gt;&nbsp;&nbsp;<span>订单管理</span>
	</div> --%>
	<div class="YJ2016_HTmain YJ2016_clearfix ">
		<!-- 左侧菜单引入 -->
		<%-- <jsp:include page="../include/leftMenu.jsp"></jsp:include> --%>
		<div class="con orderCon">
		<form name="form1" action="${context}/manage/updateorder-${order.f_id}.html" method="post" >
			<table class="OrderTable">
				<tr style="background:#cccccc">
					<td class="ct2">商品名称：</td>
					<td  class="ct2">商品数量：</td><td  class="ct2">商品单价：</td>
					<c:forEach var="shangpin"
								    items="${order.order_Deil}">
                                    <tr>
                                    <td class="ct1">《${shangpin.e_fid.wf_title}》</td>
                                    <td class="ct1">${shangpin.number}本</td>
                                    <td class="ct1">${shangpin.e_fid.wf_afterDiscountPrice*shangpin.e_fid.wf_price}</td></tr>
                                    </c:forEach>
				</tr>
				<tr>
					<td class="ct1" style="background:#cccccc">订单号：</td>
					<td class="ct2" colspan=3>${order.wf_ordernumber}</td>
				</tr>
				<tr>
					<td class="ct1" style="background:#cccccc">用户名：</td>
					<td class="ct2" colspan=3>${order.user}</td>
				</tr>
				<tr>
					<td class="ct1" style="background:#cccccc">订单时间：</td>
					<td class="ct2" colspan=3>${order.wf_ideaDate}</td>
				</tr>
				<tr>
					<td class="ct1" style="background:#cccccc">地址：</td>
					<td class="ct2" colspan=3>${order.wf_orderAddress}</td>
				</tr>
				<tr>
					<td class="ct1" style="background:#cccccc">发票抬头：</td>
					<td class="ct2" colspan=3>${order.wf_fapiao}</td>
				</tr>
				<tr>
					<td class="ct1" style="background:#cccccc">发票类型：</td>
					<td class="ct2" colspan=3>${order.wf_fapiaotype}</td>
				</tr>
				<tr>
					<td class="ct1" style="background:#cccccc">支付方式：</td>
					<td class="ct2" colspan=3>${order.wf_termsofdelivery}</td>
				</tr>
				<tr>
					<td class="ct1" style="background:#cccccc">补充说明：</td>
					<td class="ct2" colspan=3>${order.wf_by2}</td>
				</tr>
				<tr>
					<td class="ct1" style="background:#cccccc">总价：</td>
					<td class="ct2" colspan=3>${order.money}</td>
				</tr>
				<tr>
					<td class="ct1" style="background:#cccccc">订单状态：</td>
					<td class="ct2" colspan=3><select name="zhuantai">
							  <c:forEach var="status" items="${orderstatus}" >
							  <c:if test="${status.wf_orderstatus==order.wf_orderstatus}"> 
							  <option selected="selected" value="${status.wf_orderstatus}">${status.wf_orderstatustype}</option>
							  </c:if>
							  <c:if test="${status.wf_orderstatus!=order.wf_orderstatus}"> 
							  <option value="${status.wf_orderstatus}">${status.wf_orderstatustype}</option>
							  </c:if>
						      </c:forEach>
						</select></td>
				</tr>
				<tr>
						<td  colspan="4" class="ct1" align="center">
						    <input type="submit" class="HDZJ2016ht_button1" value="保存"> 
						    <input type="button" class="HDZJ2016ht_button1"  value="取消" onclick="history.go('-1')"></td>
					</tr>
			</table>
			</form>
			<div class="notePage">
			</div>
		</div>
		<!--con-->
	</div>
	<!--YJ2016_HTmain-->
	<%-- <jsp:include page="../include/bottom.jsp"></jsp:include> --%>
</body>
</html>