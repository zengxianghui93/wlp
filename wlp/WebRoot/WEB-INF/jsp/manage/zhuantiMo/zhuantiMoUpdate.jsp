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
<title>专题模板修改_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/jquery-ui.css" />
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script type="text/javascript" src="${context}/js/jquery-ui.js"></script>
<script type="text/javascript" src="${context}/js/ckeditor/ckeditor.js"></script>

<script type="text/javascript">
var NUMBER = 1;//初始化当前文献的个数
$(function(){
	//获取文献内容有几个
	var knowCenterC1 = "${zhuanTiMo.knowCenterC}".split(";");
	for(var i=0;i<knowCenterC1.length;i++){
		if(i==0){
			$("#sorceC1").val(knowCenterC1[i]);
		}else{
			addKnow(knowCenterC1[i]);
		}
	}
});

//增加一条文献中心
function addKnow(knowC){
	if(knowC=='1'){
		knowC = "";
	}
	var pHTML = '<p><input type="button" value="文献内容" id="know'+(NUMBER+1)+'">';
	pHTML += '&nbsp;<button onclick="return setKnowContext('+(NUMBER+1)+');">设置</button>&nbsp;<button onclick="return addKnow(1);">添加</button>';
	pHTML += '&nbsp;<button onclick="return delKnow('+(NUMBER+1)+');">删除</button><input type="hidden" value="'+knowC+'" id="sorceC'+(NUMBER+1)+'" name="sorceC"/></p>';
	$("#know"+NUMBER).parent().after(pHTML);
	NUMBER = NUMBER+1;
	return false;
}

//删除一条文献中心
function delKnow(num){
	if(num==1){
		alert("第一条不能删");
		return false;
	}
	$("#know"+num).parent().remove();
	return false;
}

//设置文献显示内容
function setKnowContext(num){
	
	//设置资源库显示初始值
	$("#selAllCeckBox").prop("checked",false);
	$(".checkBox1").each(function(){
		$(this).prop("checked",false);
	});
	
	var sources = $("#sorceC"+num).val().split(",");
	for(var i=0;i<sources.length;i++){
		$(".checkBox1").each(function(){
			if($(this).val()==sources[i]){
				$(this).prop("checked",true);
			};
		});
	}
	
	$("#setKnowContext").dialog({
		bgiframe: true,
	    resizable: false,
	    height:"500",
	 	width:"300",
	    modal: true,
	    /* overlay: {
	        backgroundColor: 'red',
	        opacity: 0.5
	    }, */
		title:"显示资源库：",
        buttons:{
        "确定":function(){
        	var knowC = "";
        	$(".checkBox1").each(function(){
    			if($(this).prop("checked")){
    				if(knowC==""){
    					knowC = $(this).val();
    				}else{
    					knowC += ","+$(this).val();
    				}
    			};
    		});
        	$("#sorceC"+num).val(knowC);
        	$(this).dialog('close');
        },
	 	"取消":function(){$(this).dialog('close');}
        }
    });
	return false;
}

//设置显示还是隐藏
function setShowOrHide(id,context){
	//初始化
	$("#setShowOrHide").find("input:radio").each(function(){
   		if($(this).val()==$("#"+id).val()){
   			$(this).prop("checked",true);
   		}else{
   			$(this).prop("checked",false);
   		}
   	});
	
	$("#setShowOrHide").dialog({
		bgiframe: true,
	    resizable: false,
	    height:"200",
	 	width:"300",
	    modal: true,
	    /* overlay: {
	        backgroundColor: 'red',
	        opacity: 0.5
	    }, */
		title:context+"显示控制：",
        buttons:{
        "确定":function(){
        	$("#setShowOrHide").find("input:radio").each(function(){
        		if($(this).prop("checked")){
        			$("#"+id).val($(this).val());
        		}
        	});
        	$(this).dialog('close');
        },
	 	"取消":function(){$(this).dialog('close');}
        }
    });
	return false;
}

//点击全选或取消
function selAllCeckBox(){
	if($("#selAllCeckBox").is(':checked')){
		$(".checkBox1").each(function(){
			$(this).prop("checked",true);
		});
	}else{
		$(".checkBox1").each(function(){
			$(this).prop("checked",false);
		});
	}
}
</script>
</head>
<body>
	<!-- 引入头部 -->
	<%-- <div class="YJ2016_HTRote">
		<a href="${context}/DBM/resourceManage.html">首页</a>&nbsp;&nbsp;&gt;&nbsp;&nbsp;<span>IP权限管理</span>
	</div> --%>
	<div class="YJ2016_HTmain YJ2016_clearfix ">
		<!-- 左侧菜单引入 -->
		<div class="con" align="center"  style="float: left;margin-left: 4%">
			<div class="HTnd1" style="display: inline-block;" style="margin-right: 100%;">
            	<span class="setTit">专题数据库模板修改</span>
                <div class="HTnd_gdmod">
                <form name="form1" action="${context}/zhuanTiMo/zhuanTiMoUpdate.html"
					method="post" enctype="multipart/form-data">
					<input type="hidden" value="${zhuanTiId}" name="zhuanTiId111">
					<input type="hidden" value="${zhuanTiMo.zhuantiId}" name="zhuantiId">
               		<p><input type="button" value="文献内容" id="know1">&nbsp;<button onclick="return setKnowContext(1);">设置</button>&nbsp;<button onclick="return addKnow(1);">添加</button>&nbsp;<button onclick="return delKnow(1);">删除</button>
               		<input type="hidden" value="" id="sorceC1" name="sorceC"/>
               		</p>
               		<p><input type="button" value="数据中心">&nbsp;<button onclick="return setShowOrHide('dataCenterC','数据中心');" style="width: 135px" >设置</button><input type="hidden" value="${zhuanTiMo.dataCenterC}" id="dataCenterC" name="dataCenterC"/></p>
               		<p><input type="button" value="产品中心">&nbsp;<button onclick="return setShowOrHide('productCenterC','产品中心');" style="width: 135px">设置</button><input type="hidden" value="${zhuanTiMo.productCenterC}" id="productCenterC" name="productCenterC"/></p>
               		<p><input type="button" value="其他">&nbsp;<button onclick="return setShowOrHide('otherShow','其他界面');" style="width: 135px">设置</button><input type="hidden" value="${zhuanTiMo.otherShow}" id="otherShow" name="otherShow"/></p>
                	<br>
                	
                	<textarea name="otherCon" class="ckeditor">${zhuanTiMo.otherCon}</textarea>
                	
                	<span class="mod_btn" style="text-align: center">
                		<a href="javascript:void(0);" id="subForm" onclick="document.form1.submit()">提交</a>
                    	<a href="javascript:void(0);" onclick="window.history.go(-1)">返回</a>
                    </span>
                    </form>
                </div>
            </div>
    </div>
    </div>
    <div  id="setKnowContext" style="display: none;font-size: 20px" >
    	<table>
    	<tr ><td></td><td width="50%" align="right"><input type="checkbox" onclick="selAllCeckBox()" id="selAllCeckBox"/></td></tr>
    	<tr ><td colspan="2"><div style="width:100%;height:1px;margin:0px auto;padding:0px;background-color:#D5D5D5;overflow:hidden;"></div></td></tr>
    		<tr style="border-top: 1px"><td>&nbsp;&nbsp;&nbsp;所有&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td width="50%" align="right"><input type="checkbox" value="all" class="checkBox1"/></td></tr>
	    	<c:forEach var="item" items="${resourceList}">
	    		<tr><td>&nbsp;&nbsp;&nbsp;${item.resName}</td><td width="50%" align="right"><input type="checkbox" value="${item.indexName}" class="checkBox1"/></td></tr>
	    	</c:forEach>
    	</table>
	</div>
	<div  id="setShowOrHide" style="display: none;font-size: 20px" align="center">
		<input type="radio" name="radio" value="1"/>&nbsp;显示&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="radio" value="2"/>&nbsp;隐藏
	</div>
	<!--con-->
	<!--YJ2016_HTmain-->
</body>
</html>