//fn:知识中心左侧“知识导航” upTime：2016-12-11
function showSub(categoryCode,divId){
		$("#"+divId).addClass('menuCurr').siblings().removeClass('menuCurr'); 
		$('.YJ2016_nmWrap .nm .nmLeft .subList .subMenu').show().siblings().hide();
		$('.YJ2016_nmWrap .nm .nmLeft .subList .subMenu').parent('.subList').show(); 
		$('.YJ2016_nmWrap .nm .nmLeft').mouseleave(function(){
			$('.YJ2016_nmWrap .nm .nmLeft .subList').hide();
		});
		$.ajax({
			 url:"${context}/knowcenter/getSubcate.html?a="+Math.random(),
			 data:{cg:categoryCode},
			 type:"post",
			 async:true,
			 dataType:"json",
			 error:function(){
				alert("error occured!!!");
			 },
			 success:function(data){
				 if(data!="0"){
					var trStr ="";
					for(var i=0;i<data.length;i++){
						trStr+='<dl class="YJ2016_clearfix">';
						trStr += "<dt>"+data[i].subCateName+"</dt>";
						trStr += "<dd>"
						for(var j=0;j<data[i].subCate3List.length;j++){
							trStr += data[i].subCate3List[j].wf_categoryName;
						}
						trStr += "</dd>"
						trStr+="</dl>";
					}
					document.getElementById('dt_subCate').innerHTML = trStr; 
				  }else{
					  alert(data);
				  }
		   	}
	   });
}
