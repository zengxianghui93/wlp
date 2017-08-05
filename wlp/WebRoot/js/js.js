var localObj = window.location;

var contextPath = localObj.pathname.split("/")[1];

var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;

var server_context=basePath;

$(function(){
	$('.YJ2016_search h1').click(function(){
		window.location.href=server_context+"/index.html";
	});
			
	/***************************二维码显示************************************/	
	$('.bottom .bottomBtn2').hover(function(){
		$('#erweima').show();
	},function(){
		$('#erweima').hide();
	});
	/***************************关注冶金************************************/	
	$("#guanzhu").hover(function(){
		$('#erweima1').show();
	},function(){
		$('#erweima1').hide();
	});
	/***************************建议显示************************************/	
	$('.YJ2016_fastNav .bottomBtn1').click(function(){
		$('.YJ2016_floginWrap2 .flogin1').show();
	});
	$('.YJ2016_floginWrap2 .flogin1_title p').click(function(){
		$('.YJ2016_floginWrap2 .flogin1').hide();
	});
	var userVal = $('.YJ2016_floginWrap2 .flog_item .flog_user').val();
	$('.YJ2016_floginWrap2 .flog_item .flog_user').click(function(){
		var uV = $('.YJ2016_floginWrap2 .flog_item .flog_user').val();
		if(uV == userVal){
			$(this).val("");
			$(this).css('color','#000');
		}else{
			$(this).val(uV);
		}
	});
	$('.YJ2016_floginWrap2 .flog_item .flog_user').blur(function(){
		var uV = $('.YJ2016_floginWrap2 .flog_item .flog_user').val();
		if(uV == ""){
			$(this).val(userVal);
			$(this).css('color','#ccc');
		}else{
			$(this).val(uV);
			
		}
	});
	var pwdVal = $('.YJ2016_floginWrap2 .flog_item .flog_pwd').val();
	$('.YJ2016_floginWrap2 .flog_item .flog_pwd').click(function(){
		var uV = $('.YJ2016_floginWrap2 .flog_item .flog_pwd').val();
		if(uV == pwdVal){
			$(this).val("");
			$(this).css('color','#000');
			$(".flog_pwd[type='text']").attr('type','password');
		}else{
			$(this).val(uV);
			$(".flog_pwd[type='text']").attr('type','password');
		}
	});
	$('.YJ2016_floginWrap2 .flog_item .flog_pwd').blur(function(){
		var uV = $('.YJ2016_floginWrap2 .flog_item .flog_pwd').val();
		if(uV == ""){
			$(this).val(pwdVal);
			$(this).css('color','#ccc');
			$(".flog_pwd[type='password']").attr('type','text');
		}else{
			$(this).val(uV);
			$(".flog_pwd[type='text']").attr('type','password');
			
		}
	});	
/***************************词云div************************************/	
	
/***************************2016-11-18结束************************************/	
	/**************2016-11-16右侧登录添加开始****************/
	$('.YJ2016_fastNav .topBtn1').click(function(){
		$('.YJ2016_floginWrap').show();
	});
	$('.YJ2016_floginWrap .flogin_title p').click(function(){
		$('.YJ2016_floginWrap').hide();
	});
	var userVal = $('.YJ2016_floginWrap .flog_item .flog_user').val();
	$('.YJ2016_floginWrap .flog_item .flog_user').click(function(){
		var uV = $('.YJ2016_floginWrap .flog_item .flog_user').val();
		if(uV == userVal){
			$(this).val("");
			$(this).css('color','#000');
		}else{
			$(this).val(uV);
		}
	});
	$('.YJ2016_floginWrap .flog_item .flog_user').blur(function(){
		var uV = $('.YJ2016_floginWrap .flog_item .flog_user').val();
		if(uV == ""){
			$(this).val(userVal);
			$(this).css('color','#ccc');
		}else{
			$(this).val(uV);
			
		}
	});
	var pwdVal = $('.YJ2016_floginWrap .flog_item .flog_pwd').val();
	$('.YJ2016_floginWrap .flog_item .flog_pwd').click(function(){
		var uV = $('.YJ2016_floginWrap .flog_item .flog_pwd').val();
		if(uV == pwdVal){
			$(this).val("");
			$(this).css('color','#000');
			$(".flog_pwd[type='text']").attr('type','password');
		}else{
			$(this).val(uV);
			$(".flog_pwd[type='text']").attr('type','password');
		}
	});
	$('.YJ2016_floginWrap .flog_item .flog_pwd').blur(function(){
		var uV = $('.YJ2016_floginWrap .flog_item .flog_pwd').val();
		if(uV == ""){
			$(this).val(pwdVal);
			$(this).css('color','#ccc');
			$(".flog_pwd[type='password']").attr('type','text');
		}else{
			$(this).val(uV);
			$(".flog_pwd[type='text']").attr('type','password');
			
		}
	});
	/**************2016-11-16添加开始****************/
	
	//网站导航栏-知识中心弹出框控制
	/*var nav = $('.YJ2016_navWrap .nav .navCurr').index();
	$('.YJ2016_navWrap .nav li').hover(function(){
		var ind = $(this).index();
		alert("22");
		if(ind == 2){
			$(this).children('.knoChilNav').stop().slideDown();
			//$(this).addClass('navCurr').siblings().removeClass('navCurr');
		}else{
			$('.YJ2016_navWrap .nav li').children('.knoChilNav').stop().slideUp();
			//$('.YJ2016_navWrap .nav li').eq(nav).addClass('navCurr').siblings().removeClass('navCurr');
		}
	},function(){
		$('.YJ2016_navWrap .nav li').children('.knoChilNav').stop().slideUp();
	});
	
	$('.knoChilNav .chilPro .currCommon').hover(function(){
		$(this).children('h2').addClass('titCurr');
		$(this).children('.childList').addClass('listCurrbg');
		$(this).siblings().children().removeClass('listCurrbg');
		$(this).siblings().children().removeClass('titCurr');
	});*/
	
	//知识中心导航栏弹出框 一级节点控制
	/*$('.knoChilNav .chilPro .left .childList p').hover(function(){
		var ind1 = $(this).index();
		$(this).addClass('listCurr').siblings().removeClass('listCurr');
		if(ind1 == 1){
			$('.list2Child').stop().show();
		}else{
			$('.list2Child').stop().hide();
		}
	},function(){
		$(this).removeClass('listCurr');
		
	});
	$('.knoChilNav .chilPro .childList .list2Child .txt a').hover(function(){
		$(this).css('color','red');
	},function(){
		$(this).css('color','#666');
	});
	$('.knoChilNav .chilPro .center .childList p').hover(function(){
		$(this).addClass('listCurr').siblings().removeClass('listCurr');
	},function(){
		$(this).removeClass('listCurr');
		
	});
	$('.knoChilNav .chilPro .right .childList p').hover(function(){
		$(this).addClass('listCurr').siblings().removeClass('listCurr');
	},function(){
		$(this).removeClass('listCurr');
		
	});
	$('.knoChilNav .chilPro .childList .com a').hover(function(){
		$(this).css('color','red');
	},function(){
		$(this).css('color','#000');
	});*/
	
	
	$('.YJ2016_knowledge .list li a').hover(function(){
		$(this).children('.text').addClass('textCurr');
	},function(){
		$('.YJ2016_knowledge .list li a').children().removeClass('textCurr');
	});
	$('.YJ2016_advice .list li a').hover(function(){
		$(this).children('.text').addClass('textCurr');
	},function(){
		$('.YJ2016_advice .list li a').children().removeClass('textCurr');
	});
	/*//首页--产品图片轮播
	var Linshi = $('.YJ2016_product .pro .firBook li').eq(0).clone(true);
	$('.YJ2016_product .pro .firBook').append(Linshi);
	
	myFn = setInterval(function(){
		timer();
	},2000);//自动开启定时器
	
	var loginNum = 0;//用于图片循环
	var loginNum1 = 0;//用户ol间循环
	function timer(){
		loginNum++;
		loginNum1++;
		if(loginNum1 > 2){
			loginNum1 = 0;
		}
		$('.YJ2016_product .pro ol li').eq(loginNum1).addClass('olCurr').siblings().removeClass('olCurr');
		if(loginNum > 3){
			$('.YJ2016_product .pro .firBook').css('left','0px');
			loginNum = 1;
		}
			var IWZ = loginNum * -399;
			$('.YJ2016_product .pro .firBook').css('left',IWZ);
		
		
	};//图片进行自动轮播
	
	$('.YJ2016_product .pro .firBook').hover(function(){
		clearInterval(myFn);
	},function(){
		myFn = setInterval(function(){
			timer();
		},2000);
	});//鼠标划上图片，关闭定时器。移出图片重新开启定时器
	
	$('.YJ2016_product .pro ol li').hover(function(){
		var ind = $(this).index();
		var WZ = ind * -399;
		$(this).addClass('olCurr').siblings().removeClass();
		$('.YJ2016_product .pro .firBook').stop().css('left',WZ);
	});*/
	
	$('.YJ2016_product .book1 li').hover(function(){
		$(this).addClass('commShadow').siblings().removeClass('commShadow');
	},function(){
		$('.YJ2016_product .book1 li').removeClass('commShadow');
	});
	$('.YJ2016_product .book2 li').hover(function(){
		$(this).addClass('commShadow').siblings().removeClass('commShadow');
	},function(){
		$('.YJ2016_product .book2 li').removeClass('commShadow');
	});
	
	$('.YJ2016_literature .litList li a').hover(function(){
		console.log(1);
		$(this).children('.default').stop().hide();
		$(this).children('.hide').stop().slideDown();
	},function(){
		$('.YJ2016_literature .litList li a').children('.default').stop().slideDown();
		$('.YJ2016_literature .litList li a').children('.hide').stop().hide();
	});
	//知识中心
	$('.YJ2016_nWrap .n .item li').click(function(){
		$(this).addClass('itemCurr').siblings().removeClass('itemCurr');
	});
	$('.YJ2016_nmWrap .page b span').click(function(){
		$(this).addClass('numCurr').siblings().removeClass('numCurr');
	});
	$('.YJ2016_nmWrap .page b span').hover(function(){
		$(this).addClass('numCurr1').siblings().removeClass('numCurr1');
	},function(){
		$(this).removeClass('numCurr1');
	});
	var s1num = 0;
	$('.YJ2016_nmWrap .nm .nmRight .s1 .s1Right a').click(function(){
		var ind = $(this).index();
		if(ind == 0){
			$(this).addClass('s1Curr').siblings().removeClass('s1Curr');
			$('.YJ2016_nmWrap .nm .nmRight .s1 .s1Right a i').removeClass('iCurr');
		}else if(ind == 1){
			if(s1num == 0){
				$(this).addClass('s1Curr').siblings().removeClass('s1Curr');;
				$(this).children('i').addClass('iCurr');
				$(this).siblings().children('i').removeClass('iCurr');
				s1num = 1;
			}else{
				$(this).children('i').removeClass('iCurr');
				s1num = 0;
			}
		}else{
			if(s1num == 0){
				$(this).addClass('s1Curr').siblings().removeClass('s1Curr');;
				$(this).children('i').addClass('iCurr');
				$(this).siblings().children('i').removeClass('iCurr');
				s1num = 1;
			}else{
				$(this).children('i').removeClass('iCurr');
				s1num = 0;
			}
		}
	});
	/*$('.YJ2016_nmWrap .nm .nmLeft .auto_List .menu').mouseenter(function(){
		var ind = $(this).index();
		$(this).addClass('menuCurr').siblings().removeClass('menuCurr');
		$('.YJ2016_nmWrap .nm .nmLeft .subList .subMenu').eq(ind).show().siblings().hide();
		$('.YJ2016_nmWrap .nm .nmLeft .subList .subMenu').parent('.subList').show();
	});*/
	$('.YJ2016_nmWrap .nm .nmLeft').mouseleave(function(){
		$('.YJ2016_nmWrap .nm .nmLeft .subList').hide();
	});
	$('.YJ2016_nmWrap .writer .wTab h3').click(function(){
		var ind = $(this).index();
		if(ind == 0){
			$('.YJ2016_nmWrap .writer .t').show();
			$('.YJ2016_nmWrap .writer .t2').hide();
		}else{
			$('.YJ2016_nmWrap .writer .t2').show();
			$('.YJ2016_nmWrap .writer .t').hide();
		}
		$(this).addClass('wCurr').siblings().removeClass('wCurr');
	});
	var adNum = 0;
	$('.nmLeft .ad').click(function(){
		if(adNum == 0){
			$(this).html('-');
			adNum++;
		}else{
			$(this).html('+');
			adNum = 0;
		}
	});
	//产品中心
	var pro = $('.YJ2016_nmWrap .nm .pro_center .bookList ul li').eq(0).clone(true);
	$('.YJ2016_nmWrap .nm .pro_center .bookList ul').append(pro);
	
	myFn1 = setInterval(function(){
		timer1();
	},2000);//自动开启定时器
	var proNum = 0;//用于图片循环
	var proNum1 = 0;//用户ol间循环
	function timer1(){
		proNum++;
		proNum1++;
		if(proNum1 > 1){
			proNum1 = 0;
		}
		$('.YJ2016_nmWrap .nm .pro_center .bookList ol li').eq(proNum1).addClass('pro_olcurr').siblings().removeClass('pro_olcurr');
		if(proNum > 2){
			$('.YJ2016_nmWrap .nm .pro_center .bookList ul').css('left','0px');
			proNum = 1;
		}
			var IWZ = proNum * -525;
			$('.YJ2016_nmWrap .nm .pro_center .bookList ul').css('left',IWZ);
	};//图片进行自动轮播
	
	$('.YJ2016_nmWrap .nm .pro_center .bookList ul').hover(function(){
		clearInterval(myFn1);
	},function(){
		myFn1 = setInterval(function(){
			timer1();
		},2000);
	});//鼠标划上图片，关闭定时器。移出图片重新开启定时器
	$('.YJ2016_nmWrap .nm .pro_center .bookList ol li').hover(function(){
		var ind = $(this).index();
		var WZ = ind * -525;
		$(this).addClass('pro_olcurr').siblings().removeClass('pro_olcurr');
		$('.YJ2016_nmWrap .nm .pro_center .bookList ul').stop().css('left',WZ);
		proNum = ind;
		proNum1 = ind;
	});
	$('.YJ2016_nmWrap .nm .pro_center .pro_new .newBook .newTab p').hover(function(){
		$(this).addClass('pro_pCurr').siblings().removeClass('pro_pCurr'); 
		var tabInd = $(this).index();
		$('.YJ2016_nmWrap .nm .pro_center .pro_new .newBook .pro_book').eq(tabInd).show().siblings().hide();
	});
	var book = $('.YJ2016_nmWrap .pro_right .cover ul li').eq(0).clone(true);
	$('.YJ2016_nmWrap .pro_right .cover ul').append(book);
	
	myFn2 = setInterval(function(){
		timer2();
	},2000);//自动开启定时器
	var bookNum = 0;//用于图片循环
	var bookNum1 = 0;//用户ol间循环
	function timer2(){
		bookNum++;
		bookNum1++;
		if(bookNum1 > 4){
			bookNum1 = 0;
		}
		$('.YJ2016_nmWrap .pro_right .cover ol li').eq(bookNum1).addClass('m1_olCurr').siblings().removeClass('m1_olCurr');
		if(bookNum > 5){
			$('.YJ2016_nmWrap .pro_right .cover ul').css('left','0px');
			bookNum = 1;
		}
			var IWZ = bookNum * -225;
			$('.YJ2016_nmWrap .pro_right .cover ul').css('left',IWZ);
	};//图片进行自动轮播
	
	$('.YJ2016_nmWrap .pro_right .cover ul').hover(function(){
		clearInterval(myFn2);
	},function(){
		myFn2 = setInterval(function(){
			timer2();
		},2000);
	});//鼠标划上图片，关闭定时器。移出图片重新开启定时器
	
	$('.YJ2016_nmWrap .pro_right .cover ol li').hover(function(){
		var ind = $(this).index();
		var WZ = ind * -225;
		$(this).addClass('m1_olCurr').siblings().removeClass('m1_olCurr');
		$('.YJ2016_nmWrap .pro_right .cover ul').stop().css('left',WZ);
		proNum = ind;
		proNum1 = ind;
	});
	var switchBookNum = 1;
	$('.YJ2016_InfoRec .bookWrap .switchBtn .bookLeft').click(function(){
			if(switchBookNum == 0){
				$('.YJ2016_InfoRec .Bookswitch .infoBook').eq(0).show().siblings().hide();
				switchBookNum = 1;
			}else{
				$('.YJ2016_InfoRec .Bookswitch .infoBook').eq(1).show().siblings().hide();
				switchBookNum = 0;
			}
		});
		$('.YJ2016_InfoRec .bookWrap .switchBtn .bookRight').click(function(){
			if(switchBookNum == 0){
				$('.YJ2016_InfoRec .Bookswitch .infoBook').eq(0).show().siblings().hide();
				switchBookNum = 1;
			}else{
				$('.YJ2016_InfoRec .Bookswitch .infoBook').eq(1).show().siblings().hide();
				switchBookNum = 0;
			}
		});
		//后台系统---资源管理
		$('.YJ2016_HTmain .page b span').click(function(){
		$(this).addClass('numCurr').siblings().removeClass('numCurr');
	});
	$('.YJ2016_HTmain .page b span').hover(function(){
		$(this).addClass('numCurr1').siblings().removeClass('numCurr1');
	},function(){
		$(this).removeClass('numCurr1');
	});
	$('.YJ2016_HTmain .list ul li').click(function(){
		$(this).addClass('HTListcurr').siblings().removeClass('HTListcurr');
		$(this).children('.l3_child').show();
		$(this).siblings('li').children('.l3_child').hide();
	});
	$('.YJ2016_HTmain .con .addBtn .addBtn2').click(function(){
		$('.YJ2016_selfResWrap').show();
	});
	$('.YJ2016_selfResWrap .resmess .closeBtn').click(function(){
		$('.YJ2016_selfResWrap').hide();
	});
	$('.YJ2016_selfResWrap .resmess .setBtn .cancelBtn').click(function(){
		$('.YJ2016_selfResWrap').hide();
	});
	$('.YJ2016_HTmain .con .addBtn .addBtn1').click(function(){
		$('.YJ2016_HTmain .con .HTc1').hide()
		$('.YJ2016_HTmain .con .HTnd1').show();
	});
	$('.YJ2016_HTmain .con .HTnd .HTnd_mod .mod_btn .back').click(function(){
		$('.YJ2016_HTmain .con .HTc1').show()
		$('.YJ2016_HTmain .con .HTnd').hide();
	});
	$('.YJ2016_HTmain .con .HTnd .HTnd_mod p .radio').click(function(){
		$(this).parent().addClass('radiocurr');
		$(this).parent().siblings().removeClass('radiocurr');
	});
	$('.YJ2016_HTmain .con .HTnd .HTnd_mod .mod_btn .next').click(function(){
		var ind = $('.YJ2016_HTmain .con .HTnd .HTnd_mod .radiocurr').index();
		if(ind == 0){
			$('.YJ2016_HTmain .con .HTnd1').show()
			$('.YJ2016_HTmain .con .HTnd').hide();
		}else{
			//未添加
		}
	});
	$('.YJ2016_HTmain .con .HTnd1 .mod_btn .pre').click(function(){
		$('.YJ2016_HTmain .con .HTnd1').hide();
		$('.YJ2016_HTmain .con .HTnd').show();
	});
	$('.YJ2016_HTmain .con .HTnd1 .mod_btn .creat').click(function(){
		var c = $('.YJ2016_HTmain .con .HTnd1 .HTnd_gdmod input').val();
		if(c == ""){
			alert("表名不能为空");
		}else{
			$('.YJ2016_HTmain .con .HTnd2').show();
			$('.YJ2016_HTmain .con .HTnd1').hide();
		}
	});
	$('.YJ2016_HTmain .con .HTnd2 .HTnd_addFiled .mod_btn .canele').click(function(){
		$('.YJ2016_HTmain .con .HTnd2').hide();
		$('.YJ2016_HTmain .con .HTc1').show();
	});
	$('.YJ2016_HTmain .con .HTnd2 .HTnd_addFiled .filed_btn .pre').click(function(){
		$('.YJ2016_HTmain .con .zfc').show();
	});
	$('.YJ2016_HTmain .con .HTnd2 .zfc .offzfc').click(function(){
		$('.YJ2016_HTmain .con .zfc').hide();
	});
	$('.YJ2016_dateCenter .date_con .dcl .zb h2').click(function(){
		var tf = $(this).hasClass('zbBg');
		if(tf == false){
			$(this).addClass('zbBg');
			$(this).siblings().hide();
		}else{
			$(this).removeClass('zbBg');
			$(this).siblings().show();
		}
	});
	var zbNum = 0;
	$('.YJ2016_dateCenter .date_con .mt_s1').click(function(){
		if(zbNum == 0){
			$('.YJ2016_dateCenter .date_con  .swd').show();	
			zbNum = 1;
		}else{
			$('.YJ2016_dateCenter .date_con  .swd').hide();
			zbNum = 0;
		}
	});
	$('.YJ2016_dateCenter .date_con  .tab span').click(function(){
		var tabInd = $(this).index();
		$(this).addClass('dcrTab').siblings().removeClass('dcrTab');
		$('.YJ2016_dateCenter .date_con  .tabConCurr').eq(tabInd).show().siblings().hide();
	});
	//---2016.12.14添加
	var indown = 0;
	$('.YJ2016_search .sr .inDown').click(function(){
		if(indown == 0){
			$('.YJ2016_search .sr .sr-child').show();
			$(this).addClass('inDown1');
			indown =1;
			
		}else{
			$('.YJ2016_search .sr .sr-child').hide();
			$(this).removeClass('inDown1');
			indown =0;
		}
		
	});
	
	//---2016.12.15-数据中心
	$('.YJ2016_dateCenter .date_con .dcl .zb h2').click(function(){
		var tf = $(this).hasClass('zbBg');
		if(tf == false){
			$(this).addClass('zbBg');
			$(this).siblings().hide();
		}else{
			$(this).removeClass('zbBg');
			$(this).siblings().show();
		}
	});
	/*var zbNum = 0;
	$('.YJ2016_dateCenter .date_con .mt_s1').click(function(){
		if(zbNum == 0){
			$('.YJ2016_dateCenter .date_con .dcr .swd').show();	
			zbNum = 1;
		}else{
			$('.YJ2016_dateCenter .date_con .dcr .swd').hide();
			zbNum = 0;
		}
	});*/
	$('.YJ2016_dateCenter .date_con  .tab span').click(function(){
		var tabInd = $(this).index();
		$(this).addClass('dcrTab').siblings().removeClass('dcrTab');
		$('.YJ2016_dateCenter .date_con  .tabConCurr').eq(tabInd).show().siblings().hide();
	});
	//详情页
	$('.YJ2016_nmWrap .bookDet .nmLeft .auto_List .menu').mouseenter(function(){
		var ind = $(this).index();
		$(this).addClass('menuCurr').siblings().removeClass('menuCurr');
		$('.YJ2016_nmWrap .bookDet .nmLeft .subList .subMenu').eq(ind).show().siblings().hide();
		$('.YJ2016_nmWrap .bookDet .nmLeft .subList .subMenu').parent('.subList').show();
	});
	$('.YJ2016_nmWrap .bookDet .nmLeft').mouseleave(function(){
		$('.YJ2016_nmWrap .bookDet .nmLeft .subList').hide();
	});
	//2016-12-19
	$('.YJ2016_proDet .prodetab ul li').click(function(){
		$(this).children('a').addClass('acurr');
		$(this).siblings().children('a').removeClass('acurr');
	});
	//购物车详情页
	var cartBox = $('.YJ2016_cash .cart_List .p_checkbox input[type="checkbox"]').is(':checked');
	if(cartBox == true){
		$('.YJ2016_cash .cart_List .list1').addClass('cartList_curr');
	}
	var cartListLeng = $('.YJ2016_cash .cart_List .list1').length;
	$(document).ready(function(){
		for(var cartListNum = 1 ; cartListNum <= cartListLeng; cartListNum ++){
			if(cartListNum > 0 && cartListNum < cartListLeng){
				$('.YJ2016_cash .cart_List .list1').eq(cartListNum).css('border-top','1px solid #A9A9A9');
			}
		}	
	});
	$('.YJ2016_cash .cart_List .list1 .p_checkbox input').click(function(){
		var b1 = $('.YJ2016_cash .cart_List .p_checkbox input[type="checkbox"]').is(':checked');
		if(b1 == true){
		$(this).parents('.list1').addClass('cartList_curr');
	}else{
		$(this).parents('.list1').removeClass('cartList_curr');
		}
	});
	var cartVal = $('.YJ2016_cash .cart_List .p_num input').val();
	$('.YJ2016_cash .cart_List .p_num strong').click(function(){
		var cartVal = parseInt($(this).siblings('input').val());
		var ind = $(this).index();			
		if(ind == 0 && cartVal >= 1 && cartVal <= 998){
			cartVal = cartVal + 1;
			$(this).siblings('input').val(cartVal);
		}
		if(ind == 2 && cartVal <= 999 && cartVal >= 2 ){
			cartVal = cartVal - 1;
			$(this).siblings('input').val(cartVal);
		}
	});
	$('.YJ2016_cash .cart_List .p_num input').blur(function(){
		var cartVal = parseInt($(this).val());
		if(cartVal > 999){
			cartVal = 1;
			alert('商品数量超限（不得大于999件商品）');
			$(this).val(cartVal);
		}else if(cartVal < 1){
			cartVal = 1;
			alert('商品数量必须大于0');
			$(this).val(cartVal);
		}
	});
	//首页tab切换
	 $('.YJ2016_literature .tab li').click(function(){
		$(this).addClass('tabcurr').siblings().removeClass('tabcurr'); 
	 }); 
	//情报系统
	 	$('.YJ2016_MIMain .nmLeft .MI_List .menu').eq(0).addClass('MI_menuList');
		$('.YJ2016_MIMain .nmLeft .MI_List .menu').mouseenter(function(){
			var ind = $(this).index();
			$(this).addClass('MI_menuList').siblings().removeClass('MI_menuList');
			$(this).children('i').addClass('MI_right');
			$(this).siblings().children('i').removeClass('MI_right');
			$('.YJ2016_nmWrap .nm .nmLeft .subList .subMenu').eq(ind).show().siblings().hide();
			$('.YJ2016_nmWrap .nm .nmLeft .subList .subMenu').parent('.subList').show();
		});
		
		$('.YJ2016_MIMain .t1 .MI_quick input').focus(function(){
			var uV = $(this).val();
			if(uV == "快速查找"){
				$(this).val("");
				$(this).css('color','#000');
			}else{
				$(this).val(uV);
			}
		});
		$('.YJ2016_MIMain .t1 .MI_quick input').blur(function(){
			var uV = $(this).val();
			if(uV == ""){
				$(this).val("快速查找");
				$(this).css('color','#ccc');
			}else{
				$(this).val(uV);
			}
		});
		$('.YJ2016_MIMain .t1 .MI_Date input').click(function(){
			var uV = $(this).val();
			if(uV == ""){
				$(this).css('color','#000');
			}
		});
		$('.YJ2016_MIMain .MI_main .conTit .titright a').click(function(){
			$(this).addClass('MITiCurr').siblings().removeClass('MITiCurr');
		});
		$('.YJ2016_MIMain .MI_right .MI_main .bc span').hover(function(){
			$(this).css({'color':'#fc0000'});
		},function(){
			$(this).css({'color':'#000'});
		});
		$('.YJ2016_MIMain .MI_right .MI_main .bc input').hover(function(){
			$(this).css({'background':'#23619D'});
		},function(){
			$(this).css({'background':'#316fab'});
		});
		//专题数据库
		$('.YJ2016_dbNav .dbfl').mouseenter(function(){
			$(this).children('.db_child').show();
		});
		$('.YJ2016_dbNav .db').mouseleave(function(){
			$('.YJ2016_dbNav .db .dbfl .db_child').hide();
			$('.YJ2016_dbNav .dbfl .s1_btn a').eq(0).show().siblings().hide();
			$('.YJ2016_dbNav .dbfl .s1_logos ul').css('height','98px');
			$('.YJ2016_dbNav .dbfl .s1_logos ul').css('overflow','hidden');
		});
		$('.YJ2016_dbNav .dbfl .s1_btn a').click(function(){
			var ind =$(this).index();
			if(ind == 0){
				$(this).hide().siblings().css('display','inline-block');
			}else{
				$(this).css('display','none').siblings().show();
			}
		});
		$('.YJ2016_dbNav .dbfl .s1_btn a').hover(function(){
			var ind =$(this).index();
			if(ind == 0){
				$(this).addClass('s1_btn1');
			}else{
				$(this).addClass('s1_btn2');
			}
		},function(){
			$('.YJ2016_dbNav .dbfl .s1_btn a').removeClass('s1_btn1 s1_btn2');
		});
		$('.YJ2016_dbNav .dbfl .s1_value ul li').hover(function(){
			$(this).addClass('liCurr').siblings().removeClass('liCurr');
		});
		$('.YJ2016_dbNav .dbfl .s1_logos ul li').hover(function(){
			$('.YJ2016_dbNav .dbfl .s1_logos ul li').removeClass('liCurr');
			var fi = $(this).children('a').children().hasClass('spans');
			if(fi == true){
				$(this).children('a').children('img').hide();
				$(this).children('a').children('span').show();
			}else{
				$(this).children('a').children('img').show();
			}
			$(this).css('border','1px solid #fc0000');
			$(this).children('a').css({'border':'2px solid #fc0000','height':'43px','width':'112px','border-bottom':'3px solid #fc0000'});
		},function(){
			$(this).children('a').children('img').show();
			$(this).children('a').children('span').hide();
			$(this).children('a').css({'border':'none','height':'48px','width':'116px'});
			$(this).css('border','1px solid #ccc');
		});
		$('.YJ2016_dbNav .dbfl .s1_btn a').click(function(){
			var ind =$(this).index();
			if(ind == 0){
				$('.YJ2016_dbNav .dbfl .s1_logos ul').css({'height':'196px','overflow-y':'auto','overflow-x':'hidden'});
			}else{
				$('.YJ2016_dbNav .dbfl .s1_logos ul').css('height','98px');
				$('.YJ2016_dbNav .dbfl .s1_logos ul').css('overflow','hidden');
			}
		});
		var lw = $('.YJ2016_dbMain .tit .wx_list').width();
		var minlw = 0;
		for(var i=1;i<11;i++){//最多循环10次取大于0的最小值
			if(lw-870*i>0){
				minlw = lw-870*i;
			}else{
				break;
			}
		}
		var num = 0;
		$('.YJ2016_dbMain .wx .wx_b2').click(function(){
		var le = $('.YJ2016_dbMain .tit .wx_list').position().left;
			le= le - 870;
			var val = lw + le;
			if( val > minlw){
				$('.YJ2016_dbMain .tit .wx_list').stop().animate({left:+le+'px'},500);
			}
		});
		$('.YJ2016_dbMain .wx .wx_b1').click(function(){
			var le1 = $('.YJ2016_dbMain .tit .wx_list').position().left;
			le1= le1 + 870;
			var val = lw + le1;
			if( le1 <= 0){
				$('.YJ2016_dbMain .tit .wx_list').stop().animate({left:+le1+'px'},500);
			}else{
				$('.YJ2016_dbMain .tit .wx_list').stop().css({left:'0px'});
				le = 0;
			}
		});
		//高级检索
		/*$('.YJ2016_Experts .ext_tab li').click(function(){
			var ind = $(this).index();
			$(this).addClass('extTabCurr').siblings().removeClass('extTabCurr');
			$('.YJ2016_Experts .ext_lists .item').eq(ind).show().siblings().hide();
		});*/
		/*$('.YJ2016_Experts .ext_lists .tj h2 .zd1 strong').click(function(){
			var length = $('.YJ2016_Experts .ext_lists .tj h2 .zd1').length;
			var Linshi = $('.YJ2016_Experts .ext_lists .tj h2 .zd1:last').clone(true);
			if(length < 10){
				$('.YJ2016_Experts .ext_lists .tj h2').append(Linshi);
			}else{
				alert('不能超过10个字段哦！！！');
			}
		});
		$('.YJ2016_Experts .ext_lists .tj h2 .zd1 em').click(function(){
			var length = $('.YJ2016_Experts .ext_lists .tj h2 .zd1').length;
			if(length <= 10 && length > 4){
				$('.YJ2016_Experts .ext_lists .tj h2 .zd1:last').remove();
			}else{
				alert('默认至少4个字段');
			}
		});*/
		var extNum = 0;
		$('.YJ2016_Experts .s1 .s1Right a').click(function(){
			var ind = $(this).index();
			if(ind == 0){
				$(this).addClass('s1Curr').siblings().removeClass('s1Curr');
				$('.YJ2016_Experts .s1 .s1Right a i').removeClass('iCurr');
			}else if(ind == 1){
				if(extNum == 0){
					$(this).addClass('s1Curr').siblings().removeClass('s1Curr');;
					$(this).children('i').addClass('iCurr');
					$(this).siblings().children('i').removeClass('iCurr');
					extNum = 1;
				}else{
					$(this).children('i').removeClass('iCurr');
					extNum = 0;
				}
			}else{
				if(extNum == 0){
					$(this).addClass('s1Curr').siblings().removeClass('s1Curr');;
					$(this).children('i').addClass('iCurr');
					$(this).siblings().children('i').removeClass('iCurr');
					extNum = 1;
				}else{
					$(this).children('i').removeClass('iCurr');
					extNum = 0;
				}
			}
		});
		//后台分类管理(点击新建分类后展开页面)
		$('.zb li a').click(function(){
			var tf = $(this).children('strong').hasClass('sminu');
			if(tf == false){
				$(this).children('strong').addClass('sminu');
				$(this).siblings('.zb_child').show();
			}else{
				$(this).children('strong').removeClass('sminu');
				$(this).siblings('.zb_child').hide();
			}
		});
		$('.YJ2016_newfl .fl .addlist li .zb_child .p').mouseenter(function(){
			var ind = $(this).index();
			var le2 = $(this).parent('.zb_child').siblings('.zb_childList').children('.zb_childTwo').length;
			console.log(le2);
			if(ind < le2){
				$('.YJ2016_newfl li .zb_childList').show();
				$('.YJ2016_newfl li .zb_childList .zb_childTwo').eq(ind).show().siblings().hide();
			}else{
				$('.YJ2016_newfl li .zb_childList').hide();
			}
			
		});
		$('.YJ2016_newfl .fl .addlist li').mouseleave(function(){
			var ind = $(this).index();
			$('.YJ2016_newfl li .zb_childList').hide();
		});
		$('.YJ2016_newfl .fl .closeBtn').click(function(){
			$('.YJ2016_nl').hide();
		});
		$('.YJ2016_HTmain .con h3').click(function(){
			$('.YJ2016_nl').show();
		});
		/*//后台分类管理-自定义的分类管理
		$('.dataTable .ct1').click(function(){
			var tf = $('.oldfl .addlist .zb li a').children('strong').hasClass('sminu');
			if(tf == false){
				$('.oldfl .addlist .zb li a').children('strong').addClass('sminu');
				$('.oldfl .addlist .zb li a').siblings('.zb_child').show();
			}else{
				$('.oldfl .addlist .zb li a').children('strong').removeClass('sminu');
				$('.oldfl .addlist .zb li a').siblings('.zb_child').hide();
			}
		});
		$('.YJ2016_oldfl .oldfl .addlist li .zb_child .p').mouseenter(function(){
			var ind = $(this).index();
			var le2 = $(this).parent('.zb_child').siblings('.zb_childList').children('.zb_childTwo').length;
			console.log(le2);
			if(ind < le2){
				$('.YJ2016_oldfl oldfl .zb_childList').show();
				$('.YJ2016_oldfl oldfl .zb_childList .zb_childTwo').eq(ind).show().siblings().hide();
			}else{
				$('.YJ2016_oldfl oldfl .zb_childList').hide();
			}
			
		});
		$('.YJ2016_oldfl .oldfl .addlist li').mouseleave(function(){
			var ind = $(this).index();
			$('.YJ2016_oldfl li .zb_childList').hide();
		});
		$('.YJ2016_oldfl .oldfl .closeBtn').click(function(){
			$('.YJ2016_oldfl').hide();
		});
		$('.YJ2016_oldfl .con h3').click(function(){
			$('.YJ2016_oldfl').show();
		});*/
		
		//科技查新
		$('.YJ2016_kjcx .leftCon ul li').click(function(){
			var ind = $(this).index();
			$('.YJ2016_kjcx .rote span').html($(this).html());
			console.log(ind);
			$(this).addClass('kjcx_curr').siblings().removeClass('kjcx_curr');
			$('.YJ2016_kjcx .rightCon .kjcxTxt').eq(ind).show().siblings().hide();
		});
		//产品中心二级页面
		$('.YJ2016_proMain .sList .s1_btn a').click(function(){
			var ind =$(this).index();
			if(ind == 0){
				$(this).hide().siblings().css('display','inline-block');
			}else{
				$(this).css('display','none').siblings().show();
			}
		});
		$('.YJ2016_proMain .sList .s1_btn a').hover(function(){
			var ind =$(this).index();
			if(ind == 0){
				$(this).addClass('s1_btn1');
			}else{
				$(this).addClass('s1_btn2');
			}
		},function(){
			$('.YJ2016_proMain .sList .s1_btn a').removeClass('s1_btn1 s1_btn2');
		});
		$('.YJ2016_proMain .sList .s1_value .ul li').hover(function(){
			$(this).addClass('liCurr').siblings().removeClass('liCurr').len;
		});
		
		$('.YJ2016_proMain .sList .s1_btn a').click(function(){
			var ind =$(this).index();
			if(ind == 0){
				$(this).parent().siblings('.s1_logos').children('ul').css({'max-height':'165px','overflow-y':'auto','overflow-x':'hidden'});
				$(this).parents('.sList').css('background','#f3f3f3');
			}else{
				$(this).parent().siblings('.s1_logos').children('ul').css({'max-height':'70px','overflow':'hidden'});
				$(this).parents('.sList').css('background','#fff');
			}
		});
		$('.YJ2016_proNav .profl h2').hover(function(){
			$(this).siblings('.childList').show();
			$(this).addClass('upcurr').siblings().removeClass('upcurr');
		});
		$('.YJ2016_proNav .profl .childList p').mouseenter(function(){
			$(this).addClass('liCurr').siblings().removeClass('liCurr');
			$('.YJ2016_proNav .profl .listmain').show();
			var ind = $(this).index();
			var le = $('.YJ2016_proNav .profl .listmain .listTxt').length;
			
			if(ind < le){
				$('.YJ2016_proNav .profl .listmain .listTxt').eq(ind).show().siblings().hide();
			}else{
				$('.YJ2016_proNav .profl .listmain').hide();
			}
		});
		$('.YJ2016_proNav .proTwo .profl').mouseleave(function(){
			$('.YJ2016_proNav .profl .listmain').hide();
			$(this).children('.childList').hide();
			$('.YJ2016_proNav .profl .childList p').removeClass('liCurr');
			$('.YJ2016_proNav .profl h2').removeClass('upcurr');
		});
		$('.YJ2016_proMain .pro_line .px_left a').click(function(){
			$(this).addClass('pxcurr').siblings().removeClass('pxcurr');
		});
		$('.YJ2016_proMain .pro_line .page_right .p_disabled').click(function(){
			var stxt = parseInt($(this).siblings('span').children('strong').text());
			var itxt = parseInt($(this).siblings('span').children('i').text());
				stxt = stxt - 1;
			if(stxt < itxt && stxt > 1){
				$(this).siblings('span').children('strong').html(stxt);
				$(this).siblings('.pd1').css({'background':'#fff'});
			}else{
				stxt = 1;
				$(this).siblings('span').children('strong').html(1);
				$(this).css({'background':'#f2f2f2'});
			}
		});
		$('.YJ2016_proMain .pro_line .page_right .pd1').click(function(){
			var stxt = parseInt($(this).siblings('span').children('strong').text());
			var itxt = parseInt($(this).siblings('span').children('i').text());
				stxt = stxt + 1;
			if(stxt < itxt){
				$(this).siblings('span').children('strong').html(stxt);
				$(this).siblings('.p_disabled').css({'background':'#fff'});
			}else{
				$(this).siblings('span').children('strong').html(stxt);
				$(this).css({'background':'#f2f2f2'});
			}
		});
		$('.YJ2016_proMain .pro_list li').hover(function(){
			$(this).addClass('PLshadow').siblings().removeClass('PLshadow');
		},function(){
			$('.YJ2016_proMain .pro_list li').removeClass('PLshadow');
		});
		$('.YJ2016_proMain .pro_list li .btn .pr_gz').hover(function(){
			$(this).addClass('pr_gzcurr').siblings().removeClass('pr_gzcurr');
		},function(){
			$('.YJ2016_proMain .pro_list li .btn .pr_gz').removeClass('pr_gzcurr');
		});
		$('.YJ2016_proMain .pro_list li .btn .pr_cart').hover(function(){
			$(this).css({'border':'1px solid #fc0000','color':'#fc0000'});
		},function(){
			$(this).css({'border':'1px solid #ccc','color':'#999'});
		});
		//完成订单
		//完成订单
		$('.YJ2016_shoppingWrap .order1 .o_address').hover(function(){
			$(this).css({'background':'rgb(255, 244, 245)'});
		},function(){
			$(this).css({'background':'#fff'});
		});
		$('.YJ2016_shoppingWrap .order1 h3 span').click(function(){
			$('.YJ2016_addplace').show();
		});
		$('.YJ2016_addplace .placeMain h3 i').click(function(){
			$('.YJ2016_addplace').hide();
		});
		$('.YJ2016_shoppingWrap .payWay li').click(function(){
			$(this).addClass('pwCurr').siblings().removeClass('pwCurr');
		});
		var order4 = 0;
		$('.YJ2016_shoppingWrap .order4 h3 span').click(function(){
			
			var txt = $(this).html();
			if(txt == "新增发票"){
				$(this).html('取消发票');
				$('.YJ2016_shoppingWrap .bill').show();
				
			}else if(txt == "取消发票"){
				$(this).html('新增发票');
				$('.YJ2016_shoppingWrap .bill').hide();
				
			}
			
		});
		$('.YJ2016_addplace .placecon h2 p #city').click(function(e){
			SelCity(this,e);
		});
		
		
		$('.billsave button').click(function(){
		   var selectId = $('#selectId>option:selected');
		   
		   var radiolength = $('.o4_bill .billRadio label').length;

		   var tait = $('.bill p .compay').val();
		   var pm = $('.bill p .tit').val();
			console.log(tait);
			if(tait == "" || pm == ""){
				alert('请检查您的填写方式是否正确');
			}else{
				if(radiolength < 4){
			 		var linshi = $('.o4_bill label:last').clone(true);
		   			$('.o4_bill .billRadio').append(linshi);
		   			$('.o4_bill .billRadio label:last').children('input').attr('checked',true);
					selectId.val(function(){
						var va = $(this).text();
						$('.o-receive label:last').children('span').eq(0).html(va);
					});
				}else{
					alert('不能超过3个');
				}
				$('.o-receive label:last').children('span').eq(1).html(tait);
				$('.o-receive label:last').children('span').eq(2).html(pm);
				$(this).parent('.billsave').parent('.bill').hide();
				$('.YJ2016_shoppingWrap .order4 h3 span').html('新增发票');
			}
		});
		//知识中心二级页
		$('.YJ2016_knochild .kc_right .bd li h2 span').hover(function(){
			$(this).css({'color':'#fc0000','text-decoration':'underline'});
		},function(){
			$(this).css({'color':'#333','text-decoration':'none'});
		});
		$('.YJ2016_knochild .kc_right .kc_onload a').hover(function(){
			$(this).addClass('kc_btnCurr');
		},function(){
			$(this).removeClass('kc_btnCurr');
		});
		$('.YJ2016_HTmain .con table td a').click(function(){
			$('.YJ2016_oldfl').show();
		});
		$('.YJ2016_oldfl .closeBtn').click(function(){
			$('.YJ2016_oldfl').hide();
		});
		$().click(function(){
			
		});
		
		/******资源库******/
		$('.YJ2016_zyk .left .t1 ul li h4').click(function(){
			var tf = $(this).children('strong').hasClass('down');
			if(tf == false){
				$(this).children('strong').addClass('down');
				$(this).parent().siblings().children('strong').removeClass('down');
				$(this).parent().css('height','auto');
				$(this).parent().children('.listCon').show();
			}else{
				$(this).children('strong').removeClass('down');
				$(this).parent().css('height','39px');
				$(this).parent().children('.listCon').hide();
			}
		});
		$('.YJ2016_zyk .left .t1 ul li .listCon .two').click(function(){
			var tf = $(this).children('strong').hasClass('down');
			if(tf == false){
				$(this).children('strong').addClass('down');
			}else{
				$(this).children('strong').removeClass('down');
			}
			$(this).children('.three').slideToggle();
		});
		$('.YJ2016_zyk .page b span').click(function(){
			$(this).addClass('numCurr').siblings().removeClass('numCurr');
		});
		$('.YJ2016_zyk .page b span').hover(function(){
			$(this).addClass('numCurr1').siblings().removeClass('numCurr1');
		},function(){
			$(this).removeClass('numCurr1');
		});
		$('.YJ2016_Experts .s2 .s2Right a').hover(function(){
			$(this).css({'color':'#fc0000'});
		},function(){
			$(this).css({'color':'#000'});
		});
		
		if (typeof String.prototype.startsWith != 'function') {
			String.prototype.startsWith = function(prefix) {
				return this.slice(0, prefix.length) === prefix;
			};
		}
		if (typeof String.prototype.endsWith != 'function') {
			String.prototype.endsWith = function(suffix) {
				return this.indexOf(suffix, this.length - suffix.length) !== -1;
			};
		}
		/*#######################2016-05-27搜索设置#######################*/
		var topTop3Num = 0;
		$('.YJ2016_rightNav ul .toTop3').click(function(){
			if(topTop3Num == 0){
				$('.YJ2016_rightNav .set').css('border','1px solid rgba(55,138,221,1)');
				$('.YJ2016_rightNav .set').animate({'width':'950px'},1000);
				topTop3Num = 1;
			}else{
				$('.YJ2016_rightNav .set').animate({'width':'0'},1000);
				setTimeout(function(){
					$('.YJ2016_rightNav .set').css('border','1px solid rgba(55,138,221,0)');
				},1000);
				topTop3Num = 0;
			}
		});
		$('.YJ2016_Experts .respanel .dragCon li').hover(function(){
			$(this).addClass('textCurr').siblings().removeClass('textCurr');
			
		},function(){
			$(this).removeClass('textCurr');
		});
		$('.YJ2016_Experts .respanel .dragCon li').click(function(){
			var ind = $(this).index();
			$(this).addClass('tabCurr').siblings().removeClass('tabCurr');
			$('.YJ2016_Experts .respanel .dconWrap .dcon').eq(ind).show().siblings().hide();
		});
		
		$(document).ready(function(){ 
			$(".YJ2016_Experts .respanel .drag").mousedown(function(e){//e鼠标事件 
	 			$(this).css("cursor","default");//改变鼠标指针的形状 
				var offset = $(this).offset();//DIV在页面的位置 
				var x = e.pageX - offset.left;//获得鼠标指针离DIV元素左边界的距离 
				var y = e.pageY - offset.top;//获得鼠标指针离DIV元素上边界的距离 
				$(document).bind("mousemove",function(ev){//绑定鼠标的移动事件，因为光标在DIV元素外面也要有效果，所以要用doucment的事件，而不用DIV元素的事件 
					$(".YJ2016_Experts .respanel").stop();//加上这个之后 
					var _x = ev.pageX - x;//获得X轴方向移动的值 
					var _y = ev.pageY - y;//获得Y轴方向移动的值 
					$(".YJ2016_Experts .respanel").animate({left:_x+"px",top:_y+"px"},10); 
				}); 
			}); 
			$(document).mouseup(function(){ 
				$(".YJ2016_Experts .respanel .drag").css("cursor","default"); 
				$(this).unbind("mousemove"); 
			}); 
		}); 
		$('.YJ2016_Experts .ext_lists button').click(function(){
			$('.YJ2016_Experts .respanel').show();
		});
		$('.YJ2016_Experts .respanel .drag span').click(function(){
			$('.YJ2016_Experts .respanel').hide();
		});
		
});