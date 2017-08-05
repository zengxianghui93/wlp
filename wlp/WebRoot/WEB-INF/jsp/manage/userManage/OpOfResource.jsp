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
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>用户管理_冶金信息网后台</title>
<link type="text/css" rel="stylesheet" href="${context}/css/index.css" />
<link rel="stylesheet" type="text/css" href="${context}/css/mainHT.css">
<link type="text/css" rel="stylesheet" href="${context}/css/jquery-ui.css" />
<script type="text/javascript" src="${context}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${context}/js/js.js"></script>
<script language="JavaScript" src="${context}/js/authority.js?20070509"></script>
<script type="text/javascript" src="${context}/js/jquery-ui.js"></script>


<script type="text/javascript" src="${context}/js/Ztree/jquery.ztree.core.js"></script>
<script type="text/javascript" src="${context}/js/Ztree/jquery.ztree.excheck.min.js"></script>
<link rel="stylesheet" href="${context}/js/Ztree/zTreeStyle.css" type="text/css">

<script type="text/javascript">
var zNode = [{id:3,pId:0,name:'馆藏文摘'},{id:1,pId:0,name:'外文期刊'},{id:2,pId:0,name:'外文会议'}];//初始化的馆藏文摘
var DATA;//查询出来的刊名数据
var libIds=[];//用户的资源库馆藏文摘下内容的的数组集合，用于刊名的权限的操作

var ELEPUBS1 = [];//系统所有的电子出版物
var ELEPUBS2 = [];//用户有权限的电子出版物
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
    	chkboxtype:{ "Y" : "ps", "N" : "ps" }
    }
};

$(function(){
	$.ajax({
		async:false,
		//dataType:"",
		type:"get",
		url:"${context}/manage/JournalMaintain/getAllJournalMaintain.html",
		//data:{"resId":resId},
		success:function(data){
			DATA = data;
			for(var i = 0;i<data.length;i++){
				zNode.push({id:data[i].id,pId:data[i].type,name:data[i].name});
			}
		}
	});
	var ids111 = [];
	<c:forEach var="op" items="${resOpList}">
		//馆藏文摘
		if("${op.userResource.resId}"=='8'){
			if("${op.userResource.resSourceId}"=='1'){
				libIds.push({id:1,pId:0,name:'外文期刊',open:true});
			}else if("${op.userResource.resSourceId}"=='2'){
				libIds.push({id:2,pId:0,name:'外文会议',open:true});
			}else if("${op.userResource.resSourceId}"=='3'){
				libIds.push({id:3,pId:0,name:'馆藏文摘',open:true});
			}else{
				for(var i=0;i<DATA.length;i++){
					if("${op.userResource.resSourceId}"==DATA[i].id){
						libIds.push({id:DATA[i].id,pId:DATA[i].type,name:DATA[i].name});
						ids111.push(DATA[i].id);
					}
				}
			}
		}
		
		//电子出版物
		if("${op.userResource.resId}"=='9'){
			ELEPUBS2.push({value:"${op.userResource.resSourceId}",name:""});
		}
	</c:forEach>
	$("#libIds").val(ids111);
	
	
	
	
	//电子出版物
	$.ajax({
		async:false,
		//dataType:"",
		type:"get",
		url:"${context}/product/getAllElepub.html",
		//data:{"resId":resId},
		success:function(data){
			for(var i = 0;i<data.length;i++){
				ELEPUBS1.push({value:data[i].id,name:data[i].wf_title});
				for(var j=0;j<ELEPUBS2.length;j++){
					if(ELEPUBS2[j].value == data[i].id){
						ELEPUBS2[j].name = data[i].wf_title;
						break;
					}
				}
			}
		}
	});
})

function caidan(){
	var a = $("#listSysOp option:selected").val();
	
	if(a!=8&&a!=9) return;
	
	//电子出版物
	if(a == 9){
		var HTML = "";
		var CHECKED = false;
		for(var i=0;i<ELEPUBS1.length;i++){
			for(var j=0;j<ELEPUBS2.length;j++){
				if(ELEPUBS2[j].value == ELEPUBS1[i].value){
					CHECKED = true;
					break;
				}
			}
			if(CHECKED){
				HTML += "<input type='checkbox' style='height:20px;width:20px' checked='checked' value='"+ELEPUBS1[i].value+"'/>&nbsp;&nbsp;"+ELEPUBS1[i].name+"<br>";
			}else{
				HTML += "<input type='checkbox' style='height:20px;width:20px' value='"+ELEPUBS1[i].value+"'/>&nbsp;&nbsp;"+ELEPUBS1[i].name+"<br>";
			}
			CHECKED = false;
		}
		$("#caidan3").html(HTML);
		
		$("#caidan3").dialog({
			bgiframe: true,
		    resizable: false,
		    height:"500",
		 	width:"500",
		    modal: true,
		    /* overlay: {
		        backgroundColor: 'red',
		        opacity: 0.5
		    }, */
			title:"电子出版物：",
	        buttons:{
	        "增加":function(){
	        	 $("#caidan3").find("input:checkbox").each(function(){
	        		 if($(this).prop("checked")){
		        		var isHave = false;
	        			for(var i=0;i<ELEPUBS2.length;i++){
							if(ELEPUBS2[i].value == $(this).val()){
								isHave = true;
								break;
							}
	        			}
	        			
	        			if(!isHave){
		        			 for(var i=0;i<ELEPUBS1.length;i++){
								if(ELEPUBS1[i].value == $(this).val()){
									ELEPUBS2.push({value:ELEPUBS1[i].value,name:ELEPUBS1[i].name});
									break;
								}
		        			}
		        		 }
	        		 }
	        	 });
	             $(this).dialog('close');
	        },
		 	"取消":function(){$(this).dialog('close');}
	        }
	    });
		return;
	}
	
	$.fn.zTree.init($("#treeDemo"), setting, zNode);
	var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
	
	//默认选中已拥有的权限
	var idss = $("#libIds").val().split(",");
	for(var i=0;i<idss.length;i++){
		var node = treeObj.getNodeByParam("id", idss[i], null);
		
		//如果为空，开始下一次循环
		if(idss[i] == ""){
			continue;
		}
		
		if(idss[i]!=1&&idss[i]!=2&&idss[i]!=3){
			treeObj.checkNode(node.getParentNode(),true);
		}
		treeObj.checkNode(node); 
	}
	
	$("#caidan").dialog({
		bgiframe: true,
	    resizable: false,
	    height:"500",
	 	width:"500",
	    modal: true,
	    /* overlay: {
	        backgroundColor: 'red',
	        opacity: 0.5
	    }, */
		title:"馆藏文摘：",
        buttons:{
        "增加":function(){
        	 var isHave = false;
             var nodes=treeObj.getCheckedNodes(true);
          	 for(var i=0;i<nodes.length;i++){
          		isHave=false;
            	//判断是否存在，不存在则增加
                for(var j=0;j<libIds.length;j++){
                	 if(nodes[i].id==libIds[j].id){
                		 isHave = true;
                	 };
                 } 
            	if(isHave==false){
            		libIds.push({id:nodes[i].id,pId:nodes[i].pId,name:nodes[i].name,open:true});
            	}
             }
          	 
          	 var ids = [];
          	 for(var j=0;j<libIds.length;j++){
           	 	ids.push(libIds[j].id);
             } 
          	 $("#libIds").val(ids);
             $(this).dialog('close');
        },
	 	"取消":function(){$(this).dialog('close');}
        }
    });
}

function caidan2(){
	var a = $("#listRoleOp option:selected").val();
	if(a!=8&&a!=9) return;
	
	//电子出版物
	if(a == 9){
		var HTML = "";
		for(var i=0;i<ELEPUBS2.length;i++){
			HTML += "<input type='checkbox' style='height:20px;width:20px' value='"+ELEPUBS2[i].value+"'/>&nbsp;&nbsp;"+ELEPUBS2[i].name+"<br>";
		}
		$("#caidan3").html(HTML);
		
		$("#caidan3").dialog({
			bgiframe: true,
		    resizable: false,
		    height:"500",
		 	width:"500",
		    modal: true,
		    /* overlay: {
		        backgroundColor: 'red',
		        opacity: 0.5
		    }, */
			title:"电子出版物：",
	        buttons:{
	        "移除":function(){
	        	 $("#caidan3").find("input:checkbox").each(function(){
	        		 if($(this).prop("checked")){
	        			for(var i=0;i<ELEPUBS2.length;i++){
							if(ELEPUBS2[i].value == $(this).val()){
								ELEPUBS2.splice(i,1);//删除
								break;
							}
	        			}
	        		 }
	        	 });
	             $(this).dialog('close');
	        },
		 	"取消":function(){$(this).dialog('close');}
	        }
	    });
		return;
	}
	
	
	$("#caidan2").dialog({
		bgiframe: true,
	    resizable: false,
	    height:"500",
	 	width:"500",
	    modal: true,
	    /* overlay: {
	        backgroundColor: 'red',
	        opacity: 0.5
	    }, */
		title:"馆藏文摘：",
        buttons:{
        "移除":function(){
        	 var isHave = false;
        	 var treeObj=$.fn.zTree.getZTreeObj("treeDemo2");
             var nodes=treeObj.getCheckedNodes(true);
          	 for(var i=0;i<nodes.length;i++){
                for(var j=0;j<libIds.length;j++){
                	//判断如果被选中就移出数组
                	 if(nodes[i].id==libIds[j].id&&libIds[j].id!=1&&libIds[j].id!=2){
                		 libIds.splice(j,1);//删除
                	 };
                 } 
             }
          	
          	var ids = [];
         	 for(var j=0;j<libIds.length;j++){
          	 	ids.push(libIds[j].id);
            } 
         	$("#libIds").val(ids);
            $(this).dialog('close');
        },
	 	"取消":function(){$(this).dialog('close');}
        }
    });
	
	$.fn.zTree.init($("#treeDemo2"), setting, libIds);
}


function searchZNode(){
	var search = $("#search111").val();
	var zNode1 = [{id:3,pId:0,name:'馆藏文摘'},{id:1,pId:0,name:'外文期刊',open:true},{id:2,pId:0,name:'外文会议',open:true}];
	if(search.trim()==""){
		$.fn.zTree.init($("#treeDemo"), setting, zNode);
	}else{
		for(var i=0;i<DATA.length;i++){
			if(DATA[i].name.indexOf(search.trim()) >= 0 ){
				zNode1.push({id:DATA[i].id,pId:DATA[i].type,name:DATA[i].name});
			}
		}
		
		$.fn.zTree.init($("#treeDemo"), setting, zNode1);
	}
	
	//默认选中已拥有的权限
	var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
	var idss = $("#libIds").val().split(",");
	for(var i=0;i<idss.length;i++){
		var node = treeObj.getNodeByParam("id", idss[i], null);
		
		//如果为空，结束本次循环，开始下一次循环
		if(idss[i] == ""){
			continue;
		}
		
		if(idss[i]!=1&&idss[i]!=2&&idss[i]!=3){
			treeObj.checkNode(node.getParentNode(),true);
		}
		treeObj.checkNode(node);
	}
}

function searchZNode2(){
	var search = $("#search1112").val();
	var zNode1 = [];
	if(search.trim()==""){
		$.fn.zTree.init($("#treeDemo2"), setting, libIds);
		return;
	}
	for(var i=0;i<libIds.length;i++){
		if(libIds[i].id==1){
			zNode1.push({id:1,pId:0,name:'外文期刊',open:true});
		}else if(libIds[i].id==2){
			zNode1.push({id:2,pId:0,name:'外文会议',open:true});
		}else if(libIds[i].name.indexOf(search.trim()) >= 0 ){
				zNode1.push({id:libIds[i].id,pId:libIds[i].pId,name:libIds[i].name});
		}
	}
	$.fn.zTree.init($("#treeDemo2"), setting, zNode1);
}

//全部选择
function selAll(){
	if(confirm("全部选择？")){
		var listSysOpHtml = $("#listSysOp").html();
		$("#listRoleOp").html(listSysOpHtml);
		libIds = zNode;
		var ids = [];
     	 for(var j=0;j<libIds.length;j++){
      	 	ids.push(libIds[j].id);
        } 
     	$("#libIds").val(ids);
     	
     	ELEPUBS2 = ELEPUBS1;
	};
}
//全部取消
function delAll(){
	if(confirm("全部取消？")){
		$("#listRoleOp").html('<option id="8" value="8">馆藏文摘</option><option id="9" value="9">电子出版物</option>');
		libIds = [];
		ELEPUBS2 = [];			
		$("#libIds").val("");
	};
}
//拼接电子出版物
function selectall1(){
	
	var vals = "";
	for(var i=0;i<ELEPUBS2.length;i++){
		if(vals == ""){
			vals = ELEPUBS2[i].value;
		}else{
			vals += ","+ELEPUBS2[i].value;
		}
	}
	$("#eleIds").val(vals);
	selectall(document.getElementById('listRoleOp'));
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
			<form id="form1" method="post" action="${context}/manage/authority/setUserResource.html">
				<input type="hidden" name="userId" value="${userId}" />
				<input type="hidden" name="pageNo" value="${pageNo}" />
				<input type="hidden" name="libIds" value="" id="libIds"/>
				<input type="hidden" name="eleIds" value="" id="eleIds"/>
				<div style="text-align: center">
					<div align="center" style="font-size: 25px;">
						<br />
						<h1>指定用户拥有的资源库权限</h1>
						<br />
					</div>
					<table>
						<tr style="background-color: #cccccc"><td>系统的全部资源库</td><td></td><td>当前用户的资源库</td></tr>
						<tr>
							<td>
								<div>
									<select id="listSysOp" multiple="multiple" onclick="caidan()"
										style="height: 360px; width: 200px">
										<c:forEach var="op" items="${resList}">
											<option id="${op.resId}" value="${op.resId}" >${op.resName}</option>
										</c:forEach>
									</select>
								</div>
							</td>
							<td>
								<input type="button" value="全部选择" onclick="selAll()"><br /><br /> 
								<input type="button" OnClick="addSrcToDestList(listSysOp,listRoleOp)" value=" 添加至用户  >> " /><br />
								<br /> 
								<input type="button" OnClick="deleteFromDestList(listRoleOp)" value=" 从用户移除  << "   /><br /><br /> 
								<input type="button" value="全部取消" onclick="delAll()">
							</td>
							<td>
								<div>
									<select id="listRoleOp" name="listRoleOp" multiple="multiple" onclick="caidan2()"
										style="height: 360px; width: 200px">
										<c:forEach var="op" items="${resOpList}">
											<c:if test="${op.userResource.resId!='8'&&op.userResource.resId!='9'}"><option id="${op.userResource.resId}" value="${op.userResource.resId}">${op.resName}</option></c:if>
										</c:forEach>
										<option id="8" value="8">馆藏文摘</option>
										<option id="9" value="9">电子出版物</option>
									</select>
								</div></td>
						</tr>
					</table>
					<table width="90%" align=center>
						<tr>
							<td width="*" align="center" style="height:50px;">
								<input class="HDZJ2016ht_button2" type="submit" onClick="selectall1()" value="确认" /> 
								<input class="HDZJ2016ht_button2" type="button" onClick="history.go(-1)" value="取消" />
							</td>
						</tr>
					</table>
				</div>
			</form>
		</div>

	</div>
	<!--con-->
	<div  id="caidan" style="display: none;">
		名称：<input type="text" style="border: 1px solid;" id="search111"/>&nbsp;<button onclick="searchZNode()">搜索</button>
		<ul id="treeDemo" class="ztree"></ul>
	</div>
	<div  id="caidan2" style="display: none;">
		名称：<input type="text" style="border: 1px solid;" id="search1112"/>&nbsp;<button onclick="searchZNode2()">搜索</button>
		<ul id="treeDemo2" class="ztree"></ul>
	</div>
	<div  id="caidan3" style="display: none;">
		
	</div>
	<!--YJ2016_HTmain-->
</body>
</html>