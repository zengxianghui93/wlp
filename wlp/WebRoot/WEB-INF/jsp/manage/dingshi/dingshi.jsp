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
<title>IP权限管理_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script src="${context}/js/jquery.artDialog.source.js" type="text/javascript"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript">
function txtonfocus(jine) {
    if (jine.value == '0') {
    	jine.value = '';
    }
}
function txtonblur(jine) {
    if (jine.value == '') {
    	jine.value = '0';
    }
}
</script>
<script>
function checkjine() {
	if (document.chongzhi.shijian.value == "") {
		alert("请输入时间！");
		document.chongzhi.shijian.focus();
		return false;
	}
}
	function checkform() { 
		if(checkjine()==false){ return false };
	 	return true;     
	}
</script>
</head>
<body>
	<!-- 引入头部 -->
	<div class="YJ2016_HTRote">
		<a href="javascript:void(0)" onclick="toCategory('0000')">首页</a>&nbsp;&nbsp;&gt;&nbsp;&nbsp; 
		<span id="addOrUpdate1">定时器设定</span>
	</div>
	<div class="YJ2016_HTmain YJ2016_clearfix ">
		<!-- 左侧菜单引入 -->
		<div class="con" align="center"  style="float: left;margin-left: 4%;margin-bottom: 4%">
			<div class="HTnd1" style="display: inline-block;" align="center" >
			  <form name="chongzhi" action="${context}/manage/dingshikaishi.html" method="get">
            	<span class="setTit" id="addOrUpdate2">定时器设定</span>
                <div class="HTnd_gdmod" align="center">
                    <%-- <p><span style="width: 100px;margin-left:-40px" >推送策略：</span><input  type="text" name="yue" id="wf_searchStrategy" value="${account.wf_balance}" style="width:60%;" readonly/></p> --%>
                	<p><span style="width: 100px;margin-left:-40px" >推送频率：</span>
                	<select name="shijian">
                	<option value="1">一天一次</option>
                	<option value="2">一周一次</option>
                	<option value="3">一月一次</option>
                	</select></p>
                    <div align="center">
                    <span class="mod_btn1"> <a
							href="javascript:document:chongzhi.submit();" onclick=" return checkform()" class="creat">启动</a>
							<a href="${context}/manage/dingshijieshu.html" onClick="return confirm('如果关闭定时器，在执行下次定时任务的时候就必须重启服务器了，您确定关闭吗？')">关闭</a>
							<a href="javascript:void(0);">返回</a>
						</span>
						</div>
                </div>
                 </form>
            </div>
    </div>
    </div>
	<!--con-->
	<!--YJ2016_HTmain-->
</body>
</html>