<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="YJ2016_hrefWrap">
   	<div class="href">
       	<h2>友情链接</h2>
           <div class="line"></div>
		   
		   <div class="YJ2016_Flink">
				<div class="more" onclick="getMore()">
					<a>展开更多↓</a>
				</div>
				<c:forEach items="${links}" var="link">
					<a href="${link.to_url}" target="_blank"><img alt="${link.name}" src="${context}/images/${link.image}"/></a>
				</c:forEach>
				<%-- <a href="http://www.sasac.gov.cn/" target="_blank"><img alt="国务院国有资产监督管理委员会" src="${context}/images/flink_01.jpg"/></a>
				<a href="http://www.chinaisa.org.cn/" target="_blank"><img alt="中国钢铁工业协会" src="${context}/images/flink_02.jpg"/></a>
				<a href="http://www.sdpc.gov.cn/" target="_blank"><img alt="国家发展和改革委员会" src="${context}/images/flink_03.jpg"/></a>
				<a href="http://www.miit.gov.cn/" target="_blank"><img alt="工业和信息化部" src="${context}/images/flink_04.jpg"/></a>
				<a href="http://www.most.gov.cn/" target="_blank"><img alt="科学技术部" src="${context}/images/flink_05.jpg"/></a>
				<a href="http://www.nstl.gov.cn/" target="_blank"><img alt="国家科技图书文献中心" src="${context}/images/flink_06.jpg"/></a>
				<a href="http://www.csm.org.cn/" target="_blank"><img alt="中国金属学会" src="${context}/images/flink_07.jpg"/></a>
				<a href="http://www.cmisi.com.cn/" target="_blank"><img alt="冶金工业信息标准研究院" src="${context}/images/flink_08.jpg"/></a>
				<a href="http://www.baowugroup.com" target="_blank"><img alt="中国宝武钢铁集团有限公司" src="${context}/images/flink_09.jpg"/></a>
				<a href="http://www.ceri.com.cn/" target="_blank"><img alt="中冶京诚工程技术有限公司" src="${context}/images/flink_10.jpg"/></a>
				<a href="http://www.chinametaldigest.cn/" target="_blank"><img alt="中国冶金文摘" src="${context}/images/flink_11.jpg"/></a>
				<a href="http://www.neu.edu.cn/" target="_blank"><img alt="东北大学" src="${context}/images/flink_12.jpg"/></a>
				<a href="http://www.worldmetals.com.cn" target="_blank"><img alt="世界金属导报" src="${context}/images/flink_13.jpg"/></a>
				<a href="http://www.mireview.cn/" target="_blank"><img alt="冶金信息导刊" src="${context}/images/flink_14.jpg"/></a>
				<a href="http://www.cmsi.org.cn/" target="_blank"><img alt="钢铁标准网" src="${context}/images/flink_15.jpg"/></a>
				<a href="http://www.metalsq.cn/" target="_blank"><img alt="冶金标准化与质量" src="${context}/images/flink_16.jpg"/></a>
				<a href="http://www.steelcmn.com/" target="_blank"><img alt="China Metallurgical Newsletter" src="${context}/images/flink_17.jpg"/></a>
				<a href="http://www.chinametalsweekly.com/" target="_blank"><img alt="China Metals Weekly" src="${context}/images/flink_18.jpg"/></a>
				<a href="http://www.lnmonet.com.cn/" target="_blank"><img alt="辽宁非金属矿工业协会" src="${context}/images/flink_19.jpg"/></a>
				<a href="http://www.nhcl.com.cn/" target="_blank"><img alt="耐火材料网" src="${context}/images/flink_20.jpg"/></a>
				<a href="http://vpcs.cqvip.com/" target="_blank"><img alt="维普论文检测系统" src="${context}/images/flink_21.jpg"/></a>
				<a href="http://www.emuc.cn/" target="_blank"><img alt="热处理商务网" src="${context}/images/flink_22.jpg"/></a>
				<a href="http://www.mysteel.com/" target="_blank"><img alt="我的钢铁网" src="${context}/images/flink_23.jpg"/></a>
				<a href="http://www.custeel.com/" target="_blank"><img alt="中国联合钢铁网" src="${context}/images/flink_24.jpg"/></a>
				<a href="http://www.bsteel.com.cn/" target="_blank"><img alt="东方钢铁在线网" src="${context}/images/flink_25.jpg"/></a>
				<!--<a href="http://www.steelmy.com/" target="_blank"><img alt="钢铁贸易网" src="${context}/images/flink_26.jpg"/></a>-->
				<a href="http://www.steelhome.cn/" target="_blank"><img alt="钢之家网" src="${context}/images/flink_27.jpg"/></a>
				<a href="http://www.lgmi.com/" target="_blank"><img alt="兰格钢铁网" src="${context}/images/flink_28.jpg"/></a>
				<a href="http://www.ctia.com.cn/" target="_blank"><img alt="中国钨业新闻网" src="${context}/images/flink_29.jpg"/></a>
				<a href="http://www.cisri.com/" target="_blank"><img alt="中国钢研科技集团有限公司" src="${context}/images/flink_30.jpg"/></a>
				<a href="http://www.tangsteel.com.cn/" target="_blank"><img alt="唐山钢铁集团有限责任公司" src="${context}/images/flink_31.jpg"/></a>
				<a href="http://www.istic.ac.cn/" target="_blank"><img alt="中国科学技术信息研究所" src="${context}/images/flink_32.jpg"/></a>
				<a href="http://www.las.ac.cn/" target="_blank"><img alt="中国科学院国家科学图书馆" src="${context}/images/flink_33.jpg"/></a>
				<a href="http://www.cast.org.cn/" target="_blank"><img alt="中国科学技术学会" src="${context}/images/flink_34.jpg"/></a>
				<a href="http://www.nfsoc.org.cn/" target="_blank"><img alt="中国有色金属学会" src="${context}/images/flink_35.jpg"/></a>
				<a href="http://www.ciia.org.cn/" target="_blank"><img alt="中国信息协会" src="${context}/images/flink_36.jpg"/></a> --%>
				<!--<a href="" target="_blank"><img alt="中国金属学会情报分会" src="${context}/images/flink_37.jpg"/></a>-->
				
			</div>
				
			<script type="text/javascript">
				/* $(function(){
					var moreflag=true;
					$('.YJ2016_Flink .more a').click(function(){
						 
						//打开更多
						if(moreflag){
							$('.YJ2016_Flink').css('height','auto');
							$('.YJ2016_Flink .more a').text('收起↑');
							moreflag=false;
						}else{//收起更多
							$('.YJ2016_Flink').css('height','170px');
							$('.YJ2016_Flink .more a').text('展开更多↓');
							$("html,body").animate({scrollTop:'3500px'},"fast");
							moreflag=true;
						}
					});
				}); */
				var moreflag=true;
				function getMore(){
						 
						//打开更多
						if(moreflag){
							$('.YJ2016_Flink').css('height','auto');
							$('.YJ2016_Flink .more a').text('收起↑');
							moreflag=false;
						}else{//收起更多
							$('.YJ2016_Flink').css('height','170px');
							$('.YJ2016_Flink .more a').text('展开更多↓');
							$("html,body").animate({scrollTop:'3500px'},"fast");
							moreflag=true;
						}
					}
			</script>
           
		   
    </div>
</div>
<div class="YJ2016_footerWrap">
	<div class="footer">
    	<div class="ftLeft">
            <!--################  2017-03-03  ####################-->        	
        	<a href="${context}/index.html">首页</a><span>|</span><a href="${context}/abount/topabount-1.html">关于我们</a>
        	<br/><a href="http://www.miibeian.gov.cn/">京ICP备11022607号-7</a>
        </div>
        <div class="ftRight">
        	Copyright © 1997- 冶金工业信息标准研究院 All Rights Reserved
        	<br/>客户服务热线：010-65250592&nbsp;&nbsp;&nbsp;咨询服务热线：010-65265341，010-65251353
        </div>
    </div>
	<%-- <div class="footer">
    	<div class="ftLeft">
        	<a href="${context}/index.html">首页</a><span>|</span><a href="#">统计数据</a>
        </div>
        <div class="ftRight">
        	<p>冶金工业信息标准研究院</p>
            <P><span>冶金知识服务平台</span><span>备案号XXXX</span></P>
        </div>
    </div> --%>
</div>