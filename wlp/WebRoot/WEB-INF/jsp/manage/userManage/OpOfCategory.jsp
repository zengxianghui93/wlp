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
<title>用户管理_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<link rel="stylesheet" type="text/css" href="${context}/css/mainHT.css">
<link type="text/css" rel="stylesheet" href="${context}/css/zhuanti1.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script language="JavaScript" src="${context}/js/authority.js?20070509"></script>

<script type="text/javascript" src="${context}/js/Ztree/jquery.ztree.core.js"></script>
<script type="text/javascript" src="${context}/js/Ztree/jquery.ztree.excheck.min.js"></script>
<link rel="stylesheet" href="${context}/js/Ztree/zTreeStyle.css" type="text/css">

<script type="text/javascript">
	var zNode = [];//系统拥有的所有知识导航的分类
	var uNode = [];//用户拥有的所有知识导航的分类
	
	//分别赋值
	<c:forEach var="item" items="${categoryList}">
		var id = "${item.wf_categoryCode}";
		var pId = id.substring(0,id.length-4);
		if(id != "0001"){
			zNode.push({id:id,pId:pId,name:"${item.wf_categoryName}"});
		}
		
		<c:forEach var="item11" items="${categorys}">
			if(id == "${item11}"){
				uNode.push({id:id,pId:pId,name:"${item.wf_categoryName}"});
			}
		</c:forEach>
	</c:forEach>
	
	
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
		    	chkboxType:{ "Y" : "s", "N" : "ps" }
		    }
		};
$(function(){
	$.fn.zTree.init($("#treeDemo"), setting, zNode);
	$.fn.zTree.init($("#treeDemo1"), setting, uNode);
});

function selCategory(){
	var isHave = false;
	var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
    var nodes=treeObj.getCheckedNodes(true);
 	for(var i=0;i<nodes.length;i++){
 		isHave=false;
   		//判断是否存在，不存在则增加
    	for(var j=0;j<uNode.length;j++){
       		if(nodes[i].id==uNode[j].id){
       			isHave = true;
       		};
        } 
	   	if(isHave==false){
	   		uNode.push({id:nodes[i].id,pId:nodes[i].pId,name:nodes[i].name});
	   	}
    }
 	$.fn.zTree.init($("#treeDemo1"), setting, uNode);
}

function delCategory(){
	var uNode11 = [];
	var treeObj = $.fn.zTree.getZTreeObj("treeDemo1");
    var nodes=treeObj.getCheckedNodes(true);
 	for(var i=0;i<nodes.length;i++){
 		for(var j=0;j<uNode.length;j++){
 			if(nodes[i].id==uNode[j].id){
 				if(nodes[i].check_Child_State!=1){
	 				uNode.splice(j, 1);
 				}else{
 					uNode[j].open = nodes[i].open;
 				}
 			}
 		}
    }
 	//uNode = uNode11;
 	$.fn.zTree.init($("#treeDemo1"), setting, uNode);
}

//提交表单做准备
function subForm(){
	$("#categoryId").val("${categoryId}");
	$("#userId").val("${userId}");
	var ids = "";
	for(var i=0;i<uNode.length;i++){
		ids += "," + uNode[i].id;
	}
	$("#autContext").val(ids.substring(1,ids.length));
	return true;
}
</script>
</head>
<body>
	<!-- 引入头部 -->
	<%-- <jsp:include page="../include/top.jsp"></jsp:include>
    <div class="YJ2016_HTRote">
    	<a href="${context}/DBM/resourceManage.html">首页</a>&nbsp;&nbsp;&gt;&nbsp;&nbsp;<span>资源管理</span>
    </div> --%>
	<div class="YJ2016_HTmain YJ2016_clearfix ">
		<!-- 左侧菜单 -->
		<%-- <jsp:include page="../include/leftMenu.jsp"></jsp:include> --%>
		<div class="con userCon">
			<form id="form1" method="post" action="${context}/manage/authority/updateOpOfCategory.html">
				<input type="hidden" name="categoryId" id="categoryId" />
				<input type="hidden" name="userId" id="userId" />
				<input type="hidden" name="autContext" id="autContext"/>
				<input type="hidden" name="pageNo" value="${pageNo}"/>
				
				<div style="text-align: center">
					<div align="center" style="font-size: 25px;">
						<br />
						<h1>指定用户的知识导航分类的权限</h1>
						<br />
					</div>
					<table>
						<tr style="background-color: #cccccc"><td>系统的知识导航分类</td><td></td><td>用户的的知识导航分类</td></tr>
						<tr  style="background: #f4f4f4">
							<td align="center">
								<div style="width: 250px;height: 360px;overflow: auto;background: white;border: 1px solid;" >
									<ul id="treeDemo" class="ztree"></ul>
								</div>
							</td>
							<td>
								<input type="button" OnClick="selCategory()" value=" 添加至用户  >> "  /><br />
								<br /> 
								<input type="button" OnClick="delCategory()" value=" 从用户移除  << "   />

							</td>
							<td align="center">
								<div style="width: 250px;height: 360px;overflow: auto;background: white;border: 1px solid;" >
									<ul id="treeDemo1" class="ztree"></ul>
								</div>
								</td>
						</tr>
					</table>
					<table width="90%" align=center>
						<tr>
							<td width="*" align="center" style="height:50px;background: white;">
								<input class="HDZJ2016ht_button2" type="submit" onClick="return subForm()" value="确认" /> 
								<input class="HDZJ2016ht_button2" type="button" onClick="history.go(-1)" value="取消" />
							</td>
						</tr>
					</table>
				</div>
			</form>
		</div>

	</div>
	<!--con-->
	</div>
	<!--YJ2016_HTmain-->
</body>
</html>