<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% 
    String context = request.getContextPath();
    request.setAttribute("context",context);
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>前台页面_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript" src="${context}/js/WdatePicker.js"></script>
</head>
<body>
    <div class="YJ2016_fastNav">
        <div class="top">
            <a href="#" class="topBtn1"></a>
            <a href="#" class="topBtn2"></a>
            <a href="#" class="topBtn3"></a>
        </div>
        <div class="bottom">
            <i class="bottomBtn1"></i>
            <i class="bottomBtn2"></i>
            <i class="bottomBtn3"></i>
        </div>
    </div>
    <div class="YJ2016_HTHeader">
    	<div class="header">
        	<div class="logo"><img src="${context}/images/htLogo.png" width="141" height="84" /></div>
           <div class="fn">
           <c:if test="${!empty USER_CONTEXT.userName}">
		   	<span>${USER_CONTEXT.userName},欢迎您登录!</span><a href="#">修改密码</a><a href="${context}/index.jsp" class="enter">前台页面入口</a><a href="${context}/login/doLogout.html" class="quit">退出登录</a>
		   </c:if>
		   <c:if test="${empty USER_CONTEXT.userName}">
            <span><a href="${context}/login.jsp">登录</a></span><a href="#">修改密码</a><a href="${context}/index.jsp" class="enter">前台页面入口</a>
           </c:if>
            </div>
        </div>
    </div>
    <div class="YJ2016_HTmain YJ2016_clearfix YJ2016_HTOrder">
    	<div class="preManage">
        	<div class="manList">
            	<a class="m1" href="#">模块<em></em></a>
                <a class="m2" href="#">配色<em></em></a>
                <a class="m3" href="#">页头<em></em></a>
                <a class="m4" href="#">&lt;&frasl;&gt;<br />Css<em></em></a>
            </div>
            <div class="manFun">
                	<div class="funClose"></div>
            	<div class="f1">
                	<div class="explain">选择所需模块，并拖动至相应位置<strong></strong></div>
                    <div class="f1_tab">
                        <span class="tab_curr">所有</span><span>950</span><span>190</span><span>750</span>
                    </div>
                    <div class="modu_tit">基础模块</div>
                    <div class="f1_modu">
                        <ul>
                        	<li><a href="#" class="hp1">产品推荐</a></li>
                            <li><a href="#" class="hp2">排行榜</a></li>
                            <li><a href="#" class="hp3">信息分类</a></li>
                            <li><a href="#" class="hp4">广告栏</a></li>
                            <li><a href="#" class="hp5">个性分类</a></li>
                            <li><a href="#" class="hp6">知识导航</a></li>
                            <li><a href="#" class="hp7">自定义区</a></li>
                            <li><a href="#" class="hp8">图片轮播</a></li>
                            <li><a href="#" class="hp9">友情链接</a></li>
                            <li><a href="#" class="hp10">信息列表</a></li>
                            <li><a href="#" class="hp11">搜索框</a></li>
                            <li><a href="#" class="hp12">二维码</a></li>
                        </ul>
                    </div>
                </div>
                <div class="f1"></div><!--配色-->
                <div class="f1"></div><!--页头-->
                <div class="f1"></div><!--css-->
            </div>
        </div>
        <div class="precon">
        	<div class="pc_head">
            	<select>
                	<option>首页</option><option>知识中心</option><option>产品中心</option><option>文献中心</option><option>数据中心</option><option>专家团队</option>
                </select>
                <div class="pc_tab"><span class="pctab_curr">页面编辑</span><span>布局管理</span></div>
                <span class="pc_btn"><a href="#" class="pc_btn1">预览</a><a href="#" class="pc_btn2">发布站点</a></span>
            </div>
            <div class="pc_modu">
                <div class="m1 m">页头</div>
                <div class="m2 m">水平菜单</div>
                <div class="m3 m">图片轮播</div>
                <div class="m4 m">信息列表</div>
                <div class="m5 m"><a href="#" class="mc5">添加布局单元</a></div>
                <div class="m6 m">尾部</div>
            </div>
                <div class="pc_edit">
                	<span class="ed1"></span><span class="ed2"></span><span class="ed3"></span>
                </div>
            </div>
            
        </div><!--precon-->
    </div><!--YJ2016_HTmain-->
    
    
    
    
    
                 
    <div class="YJ2016_hrefWrap YJ2016_clearfix">
    	<div class="href">
        	<h2>友情链接</h2>
            <div class="line"></div>
            <ul>
            	<li><a href="#">金属报价网</a></li>
                <li><a href="#">中国金属网</a></li>
                <li><a href="#">中华压铸网</a></li>
                <li><a href="#">中国有色金属加工工业网</a></li>
                <li><a href="#">中国有色金属信息网</a></li>
                <li><a href="#">中国选矿技术网</a></li>
                <li><a href="#">钢铁价格网</a></li>
                <li><a href="#">中国物流网</a></li>
                <li><a href="#">环球金属信息网</a></li>
                <li><a href="#">钢铁论坛</a></li>
                <li><a href="#">中国铜加工网</a></li>
                <li><a href="#">中国不锈钢交易网</a></li>
                <li><a href="#">中国钨业网</a></li>
                <li><a href="#">中国矿业信息网</a></li>
                <li><a href="#">中国选矿设备网</a></li>
                <li><a href="#">全锌网</a></li>
                <li><a href="#">铁矿网</a></li>
            </ul>
        </div>
    </div>
    <div class="YJ2016_footerWrap">
    	<div class="footer">
        	<div class="ftLeft">
            	<a href="#">首页</a><span>|</span><a href="#">统计数据</a>
            </div>
            <div class="ftRight">
            	<p>冶金工业信息标准研究院</p>
                <P><span>冶金知识服务平台</span><span>备案号XXXX</span></P>
            </div>
        </div>
    </div>
</body>
</html>
