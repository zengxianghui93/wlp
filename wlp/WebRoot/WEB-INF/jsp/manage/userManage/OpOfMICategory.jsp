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
<title>MI权限设置_冶金信息网后台</title>
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
	var zNodepro = [];//系统拥有的所有产品的分类
	var uNodepro = [];//用户拥有的所有产品的分类
	//1.全部产品分类赋值
	<c:forEach var="item" items="${MIproList}">
		var id = "${item.wf_categoryCode}";
		var pId = id.substring(0,id.length-4);
		if(id != "0001"){
			zNodepro.push({id:id,pId:pId,name:"${item.wf_categoryName}"});
		}
		
		<c:forEach var="item11" items="${proCategorys}">
			if(id == "${item11}"){
				uNodepro.push({id:id,pId:pId,name:"${item.wf_categoryName}"});
			}
		</c:forEach>
	</c:forEach>
	/* //国家和地区赋值
	<c:forEach var="item" items="${MInaList}">
		var id = "${item.wf_categoryCode}";
		var pId = id.substring(0,id.length-4);
		if(id != "0001"){
			zNode.push({id:id,pId:pId,name:"${item.wf_categoryName}"});
		}
		
		<c:forEach var="item11" items="${naCategorys}">
			if(id == "${item11}"){
				uNode.push({id:id,pId:pId,name:"${item.wf_categoryName}"});
			}
		</c:forEach>
	</c:forEach>
	//企业和机构赋值
	<c:forEach var="item" items="${MIcomList}">
		var id = "${item.wf_categoryCode}";
		var pId = id.substring(0,id.length-4);
		if(id != "0001"){
			zNode.push({id:id,pId:pId,name:"${item.wf_categoryName}"});
		}
		
		<c:forEach var="item11" items="${comCategorys}">
			if(id == "${item11}"){
				uNode.push({id:id,pId:pId,name:"${item.wf_categoryName}"});
			}
		</c:forEach>
	</c:forEach> */

	//2.国家和地区

	var zNodena = [];//系统拥有的所有国家和地区的分类
	var uNodena = [];//用户拥有的所有国家和地区的分类
	//国家和地区赋值
	<c:forEach var="item" items="${MInaList}">
		var id = "${item.wf_categoryCode}";
		var pId = id.substring(0,id.length-4);
		if(id != "0001"){
			zNodena.push({id:id,pId:pId,name:"${item.wf_categoryName}"});
		}
		
		<c:forEach var="item11" items="${naCategorys}">
			if(id == "${item11}"){
				uNodena.push({id:id,pId:pId,name:"${item.wf_categoryName}"});
			}
		</c:forEach>
	</c:forEach>
	
	//3.企业和机构 
	var zNodecom = [];//系统拥有的所有企业和机构 的分类
	var uNodecom = [];//用户拥有的所有企业和机构 的分类
	//企业和机构赋值
	<c:forEach var="item" items="${MIcomList}">
		var id = "${item.wf_categoryCode}";
		var pId = id.substring(0,id.length-4);
		if(id != "0001"){
			zNodecom.push({id:id,pId:pId,name:"${item.wf_categoryName}"});
		}
		
		<c:forEach var="item11" items="${comCategorys}">
			if(id == "${item11}"){
				uNodecom.push({id:id,pId:pId,name:"${item.wf_categoryName}"});
			}
		</c:forEach>
	</c:forEach>
	
	//4.MI数据来源 
	var zNodedata = [];//系统拥有的所有MI数据来源
	var uNodedata = [];//用户拥有的所有MI数据来源
	//企业和机构赋值
	<c:forEach var="item" items="${MIdataList}">
		var id = "${item.f_id}";
		var pId = 0;
		
		zNodedata.push({id:id,pId:pId,name:"${item.wf_MIdatabaseName}"});
		
		<c:forEach var="item11" items="${dataCategorys}">
			if(id == "${item11}"){
				uNodedata.push({id:id,pId:pId,name:"${item.wf_MIdatabaseName}"});
			}
		</c:forEach>
	</c:forEach>
	
	//公共调用方法
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
		//zTree初始化
		$.fn.zTree.init($("#treeDemoPro"), setting, zNodepro);
		$.fn.zTree.init($("#treeDemoProu"), setting, uNodepro);
		$.fn.zTree.init($("#treeDemoNa"), setting, zNodena);
		$.fn.zTree.init($("#treeDemoNau"), setting, uNodena);
		$.fn.zTree.init($("#treeDemoCom"), setting, zNodecom);
		$.fn.zTree.init($("#treeDemoComu"), setting, uNodecom);
		$.fn.zTree.init($("#treeDemoData"), setting, zNodedata);
		$.fn.zTree.init($("#treeDemoDatau"), setting, uNodedata);
	});
	function selCategory(n){
		var isHave = false;
		if(n==1){
			//全部产品分类
			var treeObj = $.fn.zTree.getZTreeObj("treeDemoPro");
		    var nodes=treeObj.getCheckedNodes(true);
		 	for(var i=0;i<nodes.length;i++){
		 		isHave=false;
		   		//判断是否存在，不存在则增加
		    	for(var j=0;j<uNodepro.length;j++){
		       		if(nodes[i].id==uNodepro[j].id){
		       			isHave = true;
		       		};
		        } 
			   	if(isHave==false){
			   		uNodepro.push({id:nodes[i].id,pId:nodes[i].pId,name:nodes[i].name});
			   	}
		    }
			
		 	//重新初始化用户的zTree
		 	$.fn.zTree.init($("#treeDemoProu"), setting, uNodepro);
		}
		if(n==2){
			//国家和地区
		 	var treeObj = $.fn.zTree.getZTreeObj("treeDemoNa");
		    var nodes=treeObj.getCheckedNodes(true);
		 	for(var i=0;i<nodes.length;i++){
		 		isHave=false;
		   		//判断是否存在，不存在则增加
		    	for(var j=0;j<uNodena.length;j++){
		       		if(nodes[i].id==uNodena[j].id){
		       			isHave = true;
		       		};
		        } 
			   	if(isHave==false){
			   		uNodena.push({id:nodes[i].id,pId:nodes[i].pId,name:nodes[i].name});
			   	}
		    }
		 	$.fn.zTree.init($("#treeDemoNau"), setting, uNodena);
		}
		if(n==3){
			//企业和机构
		 	var treeObj = $.fn.zTree.getZTreeObj("treeDemoCom");
		    var nodes=treeObj.getCheckedNodes(true);
		 	for(var i=0;i<nodes.length;i++){
		 		isHave=false;
		   		//判断是否存在，不存在则增加
		    	for(var j=0;j<uNodecom.length;j++){
		       		if(nodes[i].id==uNodecom[j].id){
		       			isHave = true;
		       		};
		        } 
			   	if(isHave==false){
			   		uNodecom.push({id:nodes[i].id,pId:nodes[i].pId,name:nodes[i].name});
			   	}
		    }
		 	$.fn.zTree.init($("#treeDemoComu"), setting, uNodecom);
		}
		if(n==4){
			//MI库来源
		 	var treeObj = $.fn.zTree.getZTreeObj("treeDemoData");
		    var nodes=treeObj.getCheckedNodes(true);
		 	for(var i=0;i<nodes.length;i++){
		 		isHave=false;
		   		//判断是否存在，不存在则增加
		    	for(var j=0;j<uNodedata.length;j++){
		       		if(nodes[i].id==uNodedata[j].id){
		       			isHave = true;
		       		};
		        } 
			   	if(isHave==false){
			   		uNodedata.push({id:nodes[i].id,pId:nodes[i].pId,name:nodes[i].name});
			   	}
		    }
		 	$.fn.zTree.init($("#treeDemoDatau"), setting, uNodedata);
		}
	 
	}
	
	function delCategory(n){
		if(n==1){
			var treeObj = $.fn.zTree.getZTreeObj("treeDemoProu");
		    var nodes=treeObj.getCheckedNodes(true);
		 	for(var i=0;i<nodes.length;i++){
		 		for(var j=0;j<uNodepro.length;j++){
		 			if(nodes[i].id==uNodepro[j].id){
		 				if(nodes[i].check_Child_State!=1){
		 					uNodepro.splice(j, 1);
		 				}else{
		 					uNodepro[j].open = nodes[i].open;
		 				}
		 			}
		 		}
		    }
		 	$.fn.zTree.init($("#treeDemoProu"), setting, uNodepro);
		}
		if(n==2){
			var treeObj = $.fn.zTree.getZTreeObj("treeDemoNau");
		    var nodes=treeObj.getCheckedNodes(true);
		 	for(var i=0;i<nodes.length;i++){
		 		for(var j=0;j<uNodena.length;j++){
		 			if(nodes[i].id==uNodena[j].id){
		 				if(nodes[i].check_Child_State!=1){
		 					uNodena.splice(j, 1);
		 				}else{
		 					uNodena[j].open = nodes[i].open;
		 				}
		 			}
		 		}
		    }
		 	$.fn.zTree.init($("#treeDemoNau"), setting, uNodena);
		}
		if(n==3){
			var treeObj = $.fn.zTree.getZTreeObj("treeDemoComu");
		    var nodes=treeObj.getCheckedNodes(true);
		 	for(var i=0;i<nodes.length;i++){
		 		for(var j=0;j<uNodecom.length;j++){
		 			if(nodes[i].id==uNodecom[j].id){
		 				if(nodes[i].check_Child_State!=1){
		 					uNodecom.splice(j, 1);
		 				}else{
		 					uNodecom[j].open = nodes[i].open;
		 				}
		 			}
		 		}
		    }
		 	$.fn.zTree.init($("#treeDemoComu"), setting, uNodecom);
		}
		if(n==4){
			var treeObj = $.fn.zTree.getZTreeObj("treeDemoDatau");
		    var nodes=treeObj.getCheckedNodes(true);
		 	for(var i=0;i<nodes.length;i++){
		 		for(var j=0;j<uNodedata.length;j++){
		 			if(nodes[i].id==uNodedata[j].id){
		 				if(nodes[i].check_Child_State!=1){
		 					uNodedata.splice(j, 1);
		 				}else{
		 					uNodedata[j].open = nodes[i].open;
		 				}
		 			}
		 		}
		    }
		 	$.fn.zTree.init($("#treeDemoDatau"), setting, uNodedata);
		}
		
	}
	
	//提交表单做准备
	function subForm(){
		$("#proCategoryId").val("${proCategoryId}");
		$("#naCategoryId").val("${naCategoryId}");
		$("#comCategoryId").val("${comCategoryId}");
		$("#dataCategoryId").val("${dataCategoryId}");
		$("#userId").val("${userId}");
		var ids = "";
		for(var i=0;i<uNodepro.length;i++){
			ids += "," + uNodepro[i].id;
		}
		$("#proAutContext").val(ids.substring(1,ids.length));
		ids = "";
		for(var i=0;i<uNodena.length;i++){
			ids += "," + uNodena[i].id;
		}
		$("#naAutContext").val(ids.substring(1,ids.length));
		ids = "";
		for(var i=0;i<uNodecom.length;i++){
			ids += "," + uNodecom[i].id;
		}
		$("#comAutContext").val(ids.substring(1,ids.length));
		ids = "";
		for(var i=0;i<uNodedata.length;i++){
			ids += "," + uNodedata[i].id;
		}
		$("#dataAutContext").val(ids.substring(1,ids.length));
		
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
			<form id="form1" method="post" action="${context}/manage/authority/updateOpOfMICategory.html">
				<input type="hidden" name="proCategoryId" id="proCategoryId"/>
				<input type="hidden" name="proAutContext" id="proAutContext"/>
				<input type="hidden" name="naCategoryId" id="naCategoryId"/>
				<input type="hidden" name="naAutContext" id="naAutContext"/>
				<input type="hidden" name="comCategoryId" id="comCategoryId"/>
				<input type="hidden" name="comAutContext" id="comAutContext"/>
				<input type="hidden" name="dataCategoryId" id="dataCategoryId"/>
				<input type="hidden" name="dataAutContext" id="dataAutContext"/>
				<input type="hidden" name="userId" id="userId" />
				<input type="hidden" name="pageNo" value="${pageNo}"/>
				
				<div style="text-align: center">
					<div align="center" style="font-size: 25px;">
						<br />
						<h1>指定用户全部产品分类的权限</h1>
						<br />
					</div>
					<table>
						<tr style="background-color: #cccccc"><td>系统的全部产品分类</td><td></td><td>用户拥有的全部产品分类</td></tr>
						<tr  style="background: #f4f4f4">
							<td align="center">
								<div style="width: 250px;height: 360px;overflow: auto;background: white;border: 1px solid;" >
									<ul id="treeDemoPro" class="ztree"></ul>
								</div>
							</td>
							<td>
								<input type="button" OnClick="selCategory(1)" value=" 添加至用户  >> "  /><br />
								<br /> 
								<input type="button" OnClick="delCategory(1)" value=" 从用户移除  << "   />

							</td>
							<td align="center">
								<div style="width: 250px;height: 360px;overflow: auto;background: white;border: 1px solid;" >
									<ul id="treeDemoProu" class="ztree"></ul>
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
				<div style="text-align: center">
					<div align="center" style="font-size: 25px;">
						<br />
						<h1>指定用户国家和地区的权限</h1>
						<br />
					</div>
					<table>
						<tr style="background-color: #cccccc"><td>系统的国家和地区分类</td><td></td><td>用户拥有的国家和地区分类</td></tr>
						<tr  style="background: #f4f4f4">
							<td align="center">
								<div style="width: 250px;height: 360px;overflow: auto;background: white;border: 1px solid;" >
									<ul id="treeDemoNa" class="ztree"></ul>
								</div>
							</td>
							<td>
								<input type="button" OnClick="selCategory(2)" value=" 添加至用户  >> "  /><br />
								<br /> 
								<input type="button" OnClick="delCategory(2)" value=" 从用户移除  << "   />

							</td>
							<td align="center">
								<div style="width: 250px;height: 360px;overflow: auto;background: white;border: 1px solid;" >
									<ul id="treeDemoNau" class="ztree"></ul>
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
				<div style="text-align: center">
					<div align="center" style="font-size: 25px;">
						<br />
						<h1>指定用户企业和机构的权限</h1>
						<br />
					</div>
					<table>
						<tr style="background-color: #cccccc"><td>系统的企业和机构分类</td><td></td><td>用户拥有的企业和机构分类</td></tr>
						<tr  style="background: #f4f4f4">
							<td align="center">
								<div style="width: 250px;height: 360px;overflow: auto;background: white;border: 1px solid;" >
									<ul id="treeDemoCom" class="ztree"></ul>
								</div>
							</td>
							<td>
								<input type="button" OnClick="selCategory(3)" value=" 添加至用户  >> "  /><br />
								<br /> 
								<input type="button" OnClick="delCategory(3)" value=" 从用户移除  << "   />

							</td>
							<td align="center">
								<div style="width: 250px;height: 360px;overflow: auto;background: white;border: 1px solid;" >
									<ul id="treeDemoComu" class="ztree"></ul>
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
				<div style="text-align: center">
					<div align="center" style="font-size: 25px;">
						<br />
						<h1>指定用户MI来源的权限</h1>
						<br />
					</div>
					<table>
						<tr style="background-color: #cccccc"><td>系统的MI来源</td><td></td><td>用户拥有的MI来源</td></tr>
						<tr  style="background: #f4f4f4">
							<td align="center">
								<div style="width: 250px;height: 360px;overflow: auto;background: white;border: 1px solid;" >
									<ul id="treeDemoData" class="ztree"></ul>
								</div>
							</td>
							<td>
								<input type="button" OnClick="selCategory(4)" value=" 添加至用户  >> "  /><br />
								<br /> 
								<input type="button" OnClick="delCategory(4)" value=" 从用户移除  << "   />

							</td>
							<td align="center">
								<div style="width: 250px;height: 360px;overflow: auto;background: white;border: 1px solid;" >
									<ul id="treeDemoDatau" class="ztree"></ul>
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