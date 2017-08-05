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
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- ###### 2017-03-26 ###### -->
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<link type="text/css" rel="stylesheet" href="${context}/css/ciyun.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript" src="${context}/js/miaov.js"></script>
<script type="text/javascript" src="${context}/js/WdatePicker.js"></script>
<script type="text/javascript" src="${context}/js/calendar.js"></script>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />

<script>
$(function() {
	var aa = $("#jianyi").val();
	if (aa == 1) {
		alert("建议提交成功");
	}else if(aa == 2){
		alert("请登录后在提交建议！");
	}
});
</script>
<!-- 判断errorMsg是否为空  -->
<script>
	$(function() {
		var aa = $("#aa").val();
		if (aa == 1) {
			// 显示隐藏
			$('#showAndView').show();
		}
	});
</script>
<!-- 词云  -->
<script>
	if (typeof (HTMLElement) != "undefined") {
		HTMLElement.prototype.contains = function(obj) {
			while (obj != null && typeof (obj.tagName) != "undefined") {
				if (obj == this)
					return true;
				obj = obj.parentNode;
			}
			return false;
		};
	}
	$(function() {
		$('.YJ2016_fastNav .topBtn3').hover(function() {
			$('#ciyun').show();
		});
		$("#ciyun").mouseleave(function(e){ 
			var s =e.relatedTarget ||window.event.toElement; 
			console.info("duixiang",s,e)
			if (!this.contains(s)) {
				$('#ciyun').hide();
			}
		});
	});
</script>
<!-- 导航栏悬浮  -->
<script>
	var name = "#floatMenu";
	var name1 = "#floatMenu1";
	var menuYloc = null;
	$(document).ready(
			function() {
				if($(name).css("top") != undefined){
					menuYloc = parseInt($(name).css("top").substring(0,
							$(name).css("top").indexOf("px")))	
				}else{
					menuYloc=0;
				}
				
				$(window).scroll(function() {
					offset = menuYloc + $(document).scrollTop() + "px";
					$(name).animate({
						top : offset
					}, {
						duration : 400,
						queue : false
					});
				});
			});
	
	
</script>

<script>
//返回顶部
$(function() {
	$("#topaa").click(function(){
	    $("html,body").animate({scrollTop:0},"slow");
	    return false;
	}); 
});
</script>
</head>

<div class="YJ2016_fastNav">
	<div class="top">
		<a href="#" class="topBtn1"></a>
		<a class="topBtn2">
			<div class="right_QQ">
				<div class="main">
					<div class="one">
						<div class="tt"><img src="${context}/images/right_QQ_ico1.png" onclick="window.open('http://wpa.qq.com/msgrd?v=3&uin=2837125473&site=qq&menu=yes')"/>
						<span onclick="window.open('http://wpa.qq.com/msgrd?v=3&uin=2837125473&site=qq&menu=yes')">客服</span></div>
						<div class="txt"><span onclick="window.open('http://wpa.qq.com/msgrd?v=3&uin=2837125473&site=qq&menu=yes')">客服QQ：2837125473</span></div>
					</div>
					<div class="one">
						<div class="tt"><img src="${context}/images/right_QQ_ico2.png"/>工作时间</div>
						<div class="txt">周一至周五：8:30 ~ 17:30</div>
					</div>
					<div class="one">
						<div class="tt"><img src="${context}/images/right_QQ_ico3.png"/>联系方式</div>
						<div class="txt">客服热线：010-65250592<br/><span onclick="window.location.href='mailto:metalinfo@cmisi.cn'">邮箱：metalinfo@cmisi.cn</span></div>
					</div>
				</div>
			</div>
		</a>
		<a href="#" class="topBtn3"></a>
	</div>
	<div class="bottom">
		<a href="#"><i class="bottomBtn1"></i></a>
		<a href="#" class="a_EWM"><i class="bottomBtn2"></i>
			<div class="EWM_bottom">
				<div class="main YJ2016_clearfix">
					<div class="one">
						<img src="${context}/images/New_EWM_SJ_small.png"/>
						<div>手机metalinfo</div>
					</div>
					<div class="one">
						<img src="${context}/images/New_EWM_GZ_small.png"/>
						<div>关注metalinfo</div>
					</div>				
				</div>
			</div>
		</a>
		<a><i id="topaa" class="bottomBtn3"></i></a>
	</div>
</div>


<!-- 新加的代码弹出登录的登陆框 -->
<form name="form1" action="${context}/login/doLogin.html" method="post">
	<div class="YJ2016_floginWrap" id="showAndView">
		<div class="flogin">
			<div class="flogin_title">
				<span>冶金信息网</span>
				<p></p>
			</div>
			<div class="flog_form YJ2016_clearfix">
				<div class="flog_mc">
					<dl>
						<dt>用户登录</dt>
						<dd>
							<a href="${context}/register.jsp"><b></b>用户注册</a>
						</dd>
					</dl>
				</div>
				<div class="flog_item">
					<input name="userName" type="text" value="用户名" class="flog_user" />
					<input name="password" type="text" value="密码" class="flog_pwd" />
				</div>
				<c:if test="${!empty errorMsg}">
					<input type="hidden" name="aa" id="aa" value="${aa}"></input>
					<div style="color: red">${errorMsg}</div>
				</c:if>
				<div class="flog_forget">
					<a href="${context}/login/zhaohuimima.html">忘记密码？</a>
				</div>
				<div class="flog_btn">
					<a href="javascript:document.form1.submit()">登录</a>
				</div>
			</div>
		</div>
	</div>
</form>
<form name="form2" action="${context}/ideaoption.html" method="post">
	<div class="YJ2016_floginWrap2">
		<!-- style="width: 100%; height: 100%; background:rgba(0, 0, 0, 0.5); position:fixed; z-index:999" -->
		<div class="flogin1" style="display: none;">
			<div class="flogin1_title">
				<span>用户建议</span>
				<p></p>
			</div>
			<div class="flog_form YJ2016_clearfix">
				<div class="flog_mc">
					<dl>
						<dt>请选择您的意见类型：</dt>
						<dd>
							<select type="select" style="height: 40px" name="type" id="type">
								<option value="1" selected>体验问题</option>
								<option value="2">数据问题</option>
								<option value="3">改进意见</option>
							</select>
						</dd>
					</dl>
				</div>
				<div class="flog_item" style="margin-top: 20px">
					<textarea style="width: 322px;" class="comments" name="idea"
						rows="6" cols="35"> </textarea>
				</div>

				<div class="flog_forget">
					<a href="" onclick="window.location.href='mailto:metalinfo@cmisi.cn'"
						style="text-decoration: underline">其他方式？</a>
				</div>
				<div class="flog_btn">
					<a href="javascript:document.form2.submit()">提交</a>
				</div>
			</div>
		</div>
	</div>
</form>
<!-- 新加的代码弹出二维码的登陆框 
<div class="YJ2016_floginWrap1" id="erweima" style="z-index: 1000;">
	<span style="float:right"><img width="100px" src="${context}/images/22222.jpg" /></span>
	<span style="float:right"><img width="100px" src="${context}/images/22222.jpg" /></span>
	<p></p>
</div>-->
<!-- 关注冶金弹出二维码
<div class="YJ2016_floginWrap5" id="erweima1" style="z-index: 1000;display: none">
	<span style="float:right"><img width="100px" src="${context}/images/22222.jpg" /></span>
	<span style="float:right"><img width="100px" src="${context}/images/22222.jpg" /></span>
	<p></p>
</div>-->
<div class="ciyun" id="ciyun" style="z-index: 1000;">
	<ciyun style="width: 400px;
    height: 300px;
    right: 35px;
    top: 150px;"></ciyun>
</div>
<div style="width: 100%; height: 45px; background: #f3f3f3;">
	<div class="YJ2016_headerWrap"
		style="position: fixed; top: 0; left: 0; z-index: 999">
		<div class="header">
			<ul>
				<%-- <li><a href="${context}/knowcenter/toHelloWorld.html"
					style="padding-left: 0">研究资源</a>|</li> --%>
				<li><a href="${context}/Navigation/list/28.html">研究资源</a>|</li>
				
				<%-- <li><a href="${context}/Mycenter/orderpp.html">我的订单</a>|</li>
				<li><a href="${context}/Mycenter/topss.html">关注订阅</a>|</li> --%>
				<li><a href="${context}/knowcenter/toHelloWorld.html"
					class="iphone">手机metalinfo</a>|
					<div class="EWM">
						<div class="top"></div>
						<div class="middle">
							<div class="one YJ2016_clearfix">
								<img src="${context}/images/New_EWM_SJ_small.png"/>
								<span class="tt">
									<b>手机</b>
									<br/>metalinfo
								</span>
							</div>
							<div class="one YJ2016_clearfix">
								<img src="${context}/images/New_EWM_GZ_small.png"/>
								<span class="tt">
									<b>关注</b>
									<br/>metalinfo
								</span>
							</div>
						</div>
					</div>
				</li>
				<li><a href="${context}/forum/index.html">社交</a>|</li>
				<li id="guanzhu"><a href="#">关注metalinfo</a>|
					<div class="EWM">
						<div class="top"></div>
						<div class="middle">
							<div class="one YJ2016_clearfix">
								<img src="${context}/images/New_EWM_GZ_small.png"/>
								<span class="tt">
									<b>关注</b>
									<br/>metalinfo
								</span>
							</div>
						</div>
					</div>
				</li>
				<li><a href="${context}/abount/topabount-6.html">客户服务</a>|</li>
				<li><a href="${context}/abount/topabount-7.html">网站导航</a>|</li>
				<li><a href="${context}/abount/topabount-1.html">关于我们</a>|</li>
				<li><a href="${context}/abount/topabount-2.html">加入metalinfo</a>|</li>
				<li><a href="${context}/Mycenter/Personal.html" style="padding-right: 0">个人中心</a></li>
			</ul>
			<div class="rl" style="width: auto">
				<c:if test="${!empty USER_CONTEXT.userName}">
					<c:if test="${USER_CONTEXT.userType >= 1}">
					<input type="hidden" name="username" id="username" value="${USER_CONTEXT.userName}"></input>
						<span>${USER_CONTEXT.userName},欢迎登录!</span>
						<a href="${context}/manage/main.html">后台管理</a>
						<c:if test="${USER_CONTEXT.userType > 2}">
						<a href="${context}/forum/index.html">论坛管理</a>
						</c:if>
						<a href="${context}/login/doLogout.html">退出</a>
					</c:if>
					<c:if test="${USER_CONTEXT.userType ==0}">
						<span>${USER_CONTEXT.userName},欢迎登录!</span>
						<a href="${context}/login/doLogout.html">退出</a>
					</c:if>
				</c:if>
				<c:if test="${empty USER_CONTEXT.userName}">
					<span><a href="${context}/login.jsp">登录</a></span>
					<a href="${context}/register.jsp">注册</a>
				</c:if>
			</div>
		</div>
	</div>
</div>

