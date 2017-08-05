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
<title>数据加工_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
</head>
<body>
	<!-- 顶部样式引入 -->
   <%--  <jsp:include page="../include/top.jsp"></jsp:include> --%>
 <!--    <div class="YJ2016_HTRote">
    	<a href="#">首页</a>&nbsp;&nbsp;&gt;&nbsp;&nbsp;<span>数据加工</span>
    </div> -->
    <div class="YJ2016_HTmain YJ2016_clearfix ">
    	
    	<!-- 左侧功能菜单引入 -->
    	<%-- <jsp:include page="../include/leftMenu.jsp"></jsp:include> --%>
        <div class="con">
        	<div class="search">
            	<h1>分类名称：
                <input type="text" />
                <a href="#">检索</a></h1>
            </div>
            <h3 style="margin-left:20px; margin-top:20px; background:url(${context}/images/htCreate.png) no-repeat 0 center; padding-left:30px;height:30px; line-height:40px; color:#900; text-decoration:underline; display:inline-block; cursor:pointer;" class="sh3">新建分类</h3>
            <table class="dataTable" style="margin-top:0;">
            	<tr class="cTitle">
                	<td class="ct11">分类名称</td>
                    <td class="ct12">分类描述</td>
                    <td class="ct13">分类类型</td>
                    <td class="ct14">操作</td>
                </tr>
                <tr>
                	<td class="ct1">知识导航</td>
                    <td class="ct12"></td>
                    <td class="ct13">资源库</td>
                    <td class="ct14">编辑|删除</td>
                </tr>
                <tr class="gray">
                	<td class="ct11"><a href="#">专题分类</a></td>
                    <td class="ct12"></td>
                    <td class="ct13">信息分类</td>
                    <td class="ct14">编辑|删除</td>
                </tr>
                <tr>
                	<td class="ct11">指标分类</td>
                    <td class="ct12"></td>
                    <td class="ct13">信息分类</td>
                    <td class="ct14"><a href="${context}/datacenter/zblist/dr.html">编辑</a>|删除</td>
                </tr>
                <tr class="gray">
                	<td class="ct11"><a href="#">分类导航</a></td>
                    <td class="ct12"></td>
                    <td class="ct13">信息分类</td>
                    <td class="ct14">编辑|删除</td>
                </tr>
            </table>
            	<div class="notePage">
            <div class="page">
                <a href="javascript:void(0);" style="margin-right:5px;">上一页</a>
                <b class="num"><span class="numCurr">1</span><span>2</span><span>3</span><span>4</span><span>5</span></b>
                <a href="javascript:void(0);">下一页</a>
            </div></div>


        </div><!--con-->
    </div><!--YJ2016_HTmain-->
    <!--新建 分类 -->
    <div class="YJ2016_newfl YJ2016_nl">
        <div class="fl">
        	<h2 class="flTit">新建分类33</h2>
        	<div class="closeBtn"></div>
            <div class="addlist">
            	<div class="zb">
                    <h2 class="">指标</h2>
                    <ul>
                        <li>
                            <a href="#"><input type="checkbox" />价格指数<strong class=""></strong></a>
                            <div class="zb_child">
                                <div class="p">
                                	<input type="checkbox" /><span>居民消费价格分类指数(上年同月)</span><i></i>
                                </div>
                                <div class="p"><input type="checkbox" /><span>居民消费价格分类指数(上年同月)</span><i></i></div>
                                <div class="p"><input type="checkbox" /><span>居民消费价格分类指数(上年同月)</span><i></i></div>
                                <div class="p"><input type="checkbox" /><span>居民零售价格分类指数(上年同月)</span><i></i></div>
                                <div class="p"><input type="checkbox" /><span>居民零售价格分类指数(上年同月)</span><i></i></div>
                            </div>
                            <!-- <div class="zb_childList">
                               <h3 class="zb_childTwo">
                                    <label><input type="checkbox" /><span>二级菜单</span></label>
                                    <label><input type="checkbox" /><span>二级菜单</span></label>
                                    <label><input type="checkbox" /><span>二级菜单</span></label>
                                    <label><input type="checkbox" /><span>二级菜单</span></label>
                                    <label><input type="checkbox" /><span>二级菜单</span></label>
                                </h3>
                            </div> -->
                        </li>
                        <li><a href="#"><input type="checkbox" />工业<strong></strong></a></li>
                    </ul>
                 </div><!--zb结束-->
            </div><!--addlist结束-->
            <div class="listCon"></div>
        </div>
    </div>
    <!--编辑 分类
    <div class="YJ2016_oldfl YJ2016_newfl">
        <div class="fl">
        	<h2 class="flTit">新建分类22</h2>
        	<div class="closeBtn"></div>
            <div class="addlist">
            	<div class="zb">
                    <h2 class="">指标</h2>
                    <ul>
                        <li>
                            <a href="#"><input type="checkbox" />价格指数<strong class=""></strong></a>
                            <div class="zb_child">
                                <div class="p">
                                	<input type="checkbox" /><span>居民消费价格分类指数(上年同月)</span><i></i>
                                </div>
                                <div class="p"><input type="checkbox" /><span>居民消费价格分类指数(上年同月)</span><i></i></div>
                                <div class="p"><input type="checkbox" /><span>居民消费价格分类指数(上年同月)</span><i></i></div>
                                <div class="p"><input type="checkbox" /><span>居民零售价格分类指数(上年同月)</span><i></i></div>
                                <div class="p"><input type="checkbox" /><span>居民零售价格分类指数(上年同月)</span><i></i></div>
                            </div>
                        </li>
                        <li><a href="#"><input type="checkbox" />工业<strong></strong></a></li>
                    </ul>
                 </div>
            </div>
            <div class="listCon"></div>
        </div>
    </div> -->
    
    </div>
   <%--  <jsp:include page="../include/bottom.jsp"></jsp:include> --%>
</body>
</html>