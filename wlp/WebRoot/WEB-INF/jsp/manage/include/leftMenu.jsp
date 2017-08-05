<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- 用户管理的默认展开显示 class="HTListcurr" -->
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
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript" src="${context}/js/WdatePicker.js"></script>
<script type="text/javascript">
</script>
<body>
<div class="YJ2016_HTmain YJ2016_clearfix " style="width:213px;height:auto;float: left; overflow-x:hidden; background-color:#34495E; padding-bottom:0;">
<div class="list " >
	<ul>
		<c:forEach var="list" items="${list}">
			<li>
				<a target="main" href="${context}${list.opUrl}" class="l${list.opDesc}">${list.opName}</a>
				<c:forEach var="list2" items="${list2}">
					<c:if test="${list2.opDesc eq list.opId}">
						<div class="l3_child" style="height:auto;display:none;">
							<dl>
								<dt>
									<a target="main" href="${context}${list2.opUrl}">${list2.opName}</a>
								</dt>
							</dl>
						</div>
					</c:if>
				</c:forEach>
			</li>
		</c:forEach>	
	</ul>
</div>
</div>
</body>