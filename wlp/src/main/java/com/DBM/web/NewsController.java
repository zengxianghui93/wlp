package com.DBM.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.DBM.cons.CommonConstant;
import com.DBM.dao.Page;
import com.DBM.dao.Pagination;
import com.DBM.domain.ColumnInfo;
import com.DBM.domain.NewsInfo;
import com.DBM.domain.ResFldInfo;
import com.DBM.domain.ResInfo;
import com.DBM.domain.TextDownload;
import com.DBM.domain.TextLink;
import com.DBM.domain.User;
import com.DBM.service.DBMService;
import com.DBM.service.NewsService;
import com.DBM.service.ResDataService;

import org.apache.commons.io.FileUtils;



@Controller
public class NewsController extends BaseController{
	@Autowired
	private NewsService newsService;
	
	@Autowired
	private DBMService dbmService;

	@Autowired
	private  ResDataService resDataService;
	
	/**
	 *  跳到添加新闻的页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/manage/addNewsPage", method = RequestMethod.GET)
	public ModelAndView addBoardPage() {
		ModelAndView view =new ModelAndView();
		//查询所有的新闻分类,根据id排序
		List<ColumnInfo> columnInfoList = newsService.ListSubCol("01");
		
		view.addObject("columnInfoList", columnInfoList);
		
		view.setViewName("/manage/addNewsInfo");
		 return view;
	}
	
	/**
	 * 后台列出所有新闻
	 * @param request
	 * @param response
	 * @param board
	 * @return
	 */
	@RequestMapping(value = "/manage/listAll")
	public ModelAndView listAllNews(HttpServletRequest request,@RequestParam(value = "pageNo", required = false) Integer pageNo) {
		ModelAndView view =new ModelAndView();
		HttpSession session = request.getSession();
		
		String keyword = (String) session.getAttribute("keyword");
		String columnid = (String) session.getAttribute("columnid");
		if(null==columnid){
			columnid="0";
		}
		pageNo = pageNo==null?1:pageNo;
		String where ="";
		

		if(null==keyword||keyword.replace(" ", "").length()<=0){
			if(columnid.equals("0")){
				where = "";
			}else{
				where =" and b.column_id like '%"+columnid+"%' ";
			}
		}else{
			keyword=keyword.replace(" ", "");
			if(columnid.equals("0")){
				//where =" and (a.content like '%"+keyword+"%' or a.title like '%"+keyword+"%')";
				where =" and ( a.title like '%"+keyword+"%')";
			}else{
				//where =" and ( a.content like '%"+keyword+"%' or a.title like '%"+keyword+"%') and b.column_id like '%"+columnid+"%' ";
				where =" and ( a.title like '%"+keyword+"%') and b.column_id like '%"+columnid+"%' ";
			}
		}
		Page pagedNews = newsService.getPageNewsBySearch(where, pageNo, CommonConstant.PAGE_SIZE);
		
		//pagedNews =newsService.getSearchPagedNews("",pageNo,CommonConstant.PAGE_SIZE);
		
		List<ColumnInfo> subCol = newsService.ListSubCol("01");
		
		view.addObject("keyword", keyword);
		view.addObject("columnid", columnid);
		view.addObject("subCol", subCol);
		view.addObject("pageNo", pageNo);
		view.addObject("pagedNews", pagedNews);
		view.setViewName("/manage/listAll");
		return view;
	}
	
	/**
	 * 后台分类检索新闻信息
	 * @param request
	 * @param response
	 * @param board
	 * @return
	 */
	@RequestMapping(value = "/manage/searchNews")
	public ModelAndView listNewsBySearch(HttpServletRequest request) {
		ModelAndView view =new ModelAndView();
		HttpSession session = request.getSession();
		
		String keyword = request.getParameter("keyword");
		String columnid = request.getParameter("columnid");
		
		session.setAttribute("keyword", keyword);
		session.setAttribute("columnid", columnid);
		
		view.setViewName("forward:/manage/listAll.html");
		return view;
	}
	
	
	
	
	/**
	 * 添加一个新闻
	 * @param request
	 * @param response
	 * @param board
	 * @return
	 */
	@RequestMapping(value = "/manage/addNews", method = RequestMethod.POST)
	public String addBoard(NewsInfo news,HttpServletRequest request,@RequestParam MultipartFile[] myfiles,@RequestParam(value ="cate",required=false) String cate) throws IOException{
		news.setModify_date(new Date());
		news.setEntry_date(new Date());
		news.setPerson_id(555);
		news.setStatus(1);
		//news.setAuthor(author);
		news.setViewnum(1);
		newsService.addNews(news);
		
		//增加分类关联表
		TextLink tLink=new TextLink();
		tLink.setInfoId(news.getInfoId());
		tLink.setColumnId(cate);
		newsService.addTextLink(tLink);
		/*//是否添加至图片
		String isimage = request.getParameter("isimage");
		if(isimage=="1"&&cate!="0106"){
			//增加图片关联表
			TextLink Link=new TextLink();
			Link.setInfoId(news.getInfoId());
			Link.setColumnId("0106");
			newsService.addTextLink(Link);
		}*/
		//增加文件上传
		for(MultipartFile myfile : myfiles){  
            if(myfile.isEmpty()){  
                System.out.println("文件未上传");  
            }else{  
                System.out.println("文件长度: " + myfile.getSize());  
                System.out.println("文件类型: " + myfile.getContentType());  
                System.out.println("文件名称: " + myfile.getName());  
                System.out.println("文件原名: " + myfile.getOriginalFilename());  
                System.out.println("========================================");  
                //如果用的是Tomcat服务器，则文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\WEB-INF\\upload\\文件夹中  
                String realPath = request.getSession().getServletContext().getRealPath(CommonConstant.UPLOAD_PATH);  
                //以时间为文件名
                String datename = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()).toString()+myfile.getOriginalFilename().substring(myfile.getOriginalFilename().indexOf("."));
                
                //这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉，我是看它的源码才知道的  
                FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(realPath, datename)); 
                //写入文件关联表
                TextDownload td=new TextDownload();
                td.setInfo_id(news.getInfoId());
                td.setFilename(myfile.getOriginalFilename());
                td.setDatename(datename);
        		newsService.addTextFiles(td);
            }  
        }
		
		
		return "redirect:/manage/listAll.html";
	}
	
	
	
	
	
	
	
	
	/**
	 * 修改更新一个新闻
	 * @param request
	 * @param response
	 * @param board
	 * @return
	 */
	@RequestMapping(value = "/manage/UpdateNews", method = RequestMethod.POST)
	public String UpdateNews(NewsInfo news,HttpServletRequest request,@RequestParam MultipartFile[] myfiles,@RequestParam(value ="cate",required=false) String cate) throws IOException{
		//获取原有新闻
		NewsInfo oNewsInfo=newsService.getInfoById(news.getInfoId());
		
		oNewsInfo.setModify_date(new Date());
		oNewsInfo.setAuthor(news.getAuthor());
		oNewsInfo.setTitle(news.getTitle());
		oNewsInfo.setContent(news.getContent());
		oNewsInfo.setWebaddress(news.getWebaddress());
		oNewsInfo.setIstop(news.getIstop());
		
		/*获取新闻中第一张图片的地址
		 * //String image = news.getContent().substring(news.getContent().indexOf("<img "), news.getContent().indexOf("<img>"));
		System.out.println(news.getContent());
		int indexOf = news.getContent().indexOf("<img");
		String othercontent = news.getContent().substring(indexOf);
		String image = news.getContent().substring(indexOf, indexOf+othercontent.indexOf("/>")+2);
		System.out.println(image);
		String srcstr = image.substring(image.indexOf("src=\"")+5);
		String imagepath = srcstr.substring(0, srcstr.indexOf("\""));
		System.out.println(imagepath);
		*/
		newsService.updateNews(oNewsInfo);

		//修改分类关联表
		//查询原有分类
		TextLink tLink = newsService.selectTextLinkByInfoId(oNewsInfo.getInfoId());
		
		tLink.setInfoId(news.getInfoId());
		tLink.setColumnId(cate);
		newsService.updateTextLink(tLink);
		/*//是否添加至图片
		String isimage = request.getParameter("isimage");
		if(isimage.equals("1")&&!cate.equals("0106")){
			//增加图片关联表
			TextLink Link=new TextLink();
			Link.setInfoId(news.getInfoId());
			Link.setColumnId("0106");
			newsService.addTextLink(Link);
		}*/
		
		//增加文件上传
		for(MultipartFile myfile : myfiles){  
            if(myfile.isEmpty()){  
                System.out.println("文件未上传");  
            }else{  
                System.out.println("文件长度: " + myfile.getSize());  
                System.out.println("文件类型: " + myfile.getContentType());  
                System.out.println("文件名称: " + myfile.getName());  
                System.out.println("文件原名: " + myfile.getOriginalFilename());  
                System.out.println("========================================");  
              //如果用的是Tomcat服务器，则文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\WEB-INF\\upload\\文件夹中  
                String realPath = request.getSession().getServletContext().getRealPath(CommonConstant.UPLOAD_PATH);  
                //以时间为实际存贮名
                String datename = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()).toString()+myfile.getOriginalFilename().substring(myfile.getOriginalFilename().indexOf("."));
                
                //这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉，我是看它的源码才知道的  
                FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(realPath, datename)); 
                //写入文件关联表
                TextDownload td=new TextDownload();
                td.setInfo_id(news.getInfoId());
                td.setFilename(myfile.getOriginalFilename());
                td.setDatename(datename);
        		newsService.addTextFiles(td);
            }  
        }
		
		
		return "redirect:/manage/listAll.html";
	}
	
	
	/**
	 * 网站首页
	 * 
	 * @param 
	 * @param request
	 * @param response
	 * @return
	 */
	//@RequestMapping(value = "/index", method = RequestMethod.GET)
	@RequestMapping(value = "aa/index")
	public ModelAndView showIndex() {
		ModelAndView view =new ModelAndView();
		
		Page pagedNews01 =newsService.getPagedNewsAndtop("0101",1,5);
		Page pagedNews02 =newsService.getPagedNewsAndtop("0102",1,5);
		Page pagedNews04 =newsService.getPagedNewsAndtop("0104",1,5);
		Page pagedNews03 =newsService.getPagedNewsAndtop("0103",1,5);
		Page pagedNews05 =newsService.getPagedNewsAndtop("0105",1,5);
		Page pagedNews06 =newsService.getPagedNewsAndtop("0106",1,3);
		
		view.addObject("pagedNews0106", pagedNews06);
		view.addObject("pagedNews0101", pagedNews01);
		view.addObject("pagedNews0102", pagedNews02);
		view.addObject("pagedNews0104", pagedNews04);
		view.addObject("pagedNews0103", pagedNews03);
		view.addObject("pagedNews0105", pagedNews05);
		
		
		Pagination paginationkjxq = queryDataByPage(11,1,3);
		Pagination paginationkjcg = queryDataByPage(12,1,3);
		Pagination paginationjjr = queryDataByPage(13,1,2);
		//Pagination paginationtsk = queryDataByPage(16,1,3);
		ResInfo resInfo = dbmService.getResInfo(16);
		List catelist = resDataService.queryDataCheckedCate(resInfo.getResTblName());
		Pagination paginationtc_farm = queryDataByPage(19,1,10);
		Pagination paginationtc_factory = queryDataByPage(21,1,10);
		Pagination meet = queryDataByPage(22,1,1);
		Pagination joinmeet = queryDataByPage(23,1,10);
		String where = " createTime like '"+new SimpleDateFormat("yyyy-MM-dd").format(new Date())+"%'";
		Pagination todayjoin = resDataService.queryPageDataByWhere("meet_join",where,1,CommonConstant.PAGE_SIZE,true);
		view.addObject("todayjoin", todayjoin);
		view.addObject("joinmeet", joinmeet);
		view.addObject("meet", meet);
		view.addObject("factory", paginationtc_factory);
		view.addObject("farm", paginationtc_farm);
		view.addObject("kjxq", paginationkjxq);
		view.addObject("kjcg", paginationkjcg);
		view.addObject("jjr", paginationjjr);
		view.addObject("tsklist", catelist);
		
		view.setViewName("/index");
		return view;
	}
	
	/**
	 * 分页获取自建库数据
	 * @param ResId
	 * @param request
	 * @param response
	 * @return
	 */
	public Pagination queryDataByPage(int ResId,Integer pageNum, Integer pageSize){
		
		ResInfo resInfo =dbmService.getResInfo(ResId);
		Integer resFlow = resInfo.getResFlow();
		boolean flag;
		if(resFlow==0){
			flag=false;
		}else{
			flag=true;
		}
		Pagination pagination = resDataService.queryPageData(resInfo.getResTblName(), pageNum, pageSize,flag);
		return pagination;
	}
	
	/**
	 * 分页获取自建库数据,并和字段进行匹配拼装
	 * @param ResId
	 * @param request
	 * @param response
	 * @return
	 
	public List<Map<String ,Object>> queryDataResource(int ResId,Integer pageNum, Integer pageSize){
		
		String message = "";
		String status = ""; 
		
		List<ResFldInfo> lstFld = dbmService.ListResFld(ResId);
		//获取要查询的表名
		ResInfo resInfo =dbmService.getResInfo(ResId);
		
		List<Map<String, Object>> businessList =null;
		Pagination page=null; 
 		Map<String, Object> map = new HashMap<String, Object>();
		try {
			//out = response.getWriter();
			
			page =resDataService.queryPageBusiness(resInfo.getResTblName(),pageNum, pageSize);  
			
			List list=page.getResultList();
			businessList=new ArrayList<Map<String,Object>>(); 
			for (int i = 0,len=list.size();i<len; i++) {
				Map<String, Object> maps=new HashMap<String, Object>();
				Map mapRe=(Map)list.get(i); 
				maps.put("id", mapRe.get("id"));
				
				//获取该库的所有字段，把列表可显示字段存入Map					
				for (ResFldInfo resFldInfo : lstFld) {
					if(resFldInfo.getFldList()==1)
						maps.put(resFldInfo.getFldName(), mapRe.get(resFldInfo.getFldName()));
						
				}
				businessList.add(maps); 
			}
			message="success"; 
			status = "0";
		} catch (Exception e1) { 
			e1.printStackTrace();
			message="failure";
			status = "1";
		}finally{ 
			int nextPage=1;int prePage=1;
			if(page.getCurrentPage()!=1)
				prePage=page.getCurrentPage()-1;
			
			if(page.getCurrentPage()<page.getTotalPages())
				nextPage=page.getCurrentPage()+1;
			else
				nextPage=page.getTotalPages();
			
			map.put("message", message); 
			map.put("totalPage", page.getTotalPages());  
			map.put("currentPage", page.getCurrentPage());  
			map.put("totalRows", page.getTotalRows());  
			map.put("numPerPage", page.getNumPerPage());  
			map.put("status", status);  
			map.put("prePage", prePage);
			map.put("nextPage", nextPage);
			map.put("resName", resInfo.getResName());

		}
		
		return businessList;
	}
	*/
	
	
	
	/**
	 * 列出分页的文章列表
	 * 
	 * @param 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/forum/listNews-{ColumnId}", method = RequestMethod.GET)
	public ModelAndView listNews(@PathVariable String ColumnId,@RequestParam(value = "pageNo", required = false) Integer pageNo) {
		ModelAndView view =new ModelAndView();
		//Board board = forumService.getBoardById(boardId);
		pageNo = pageNo==null?1:pageNo;
		Page pagedNews =newsService.getPagedNews(ColumnId,pageNo,CommonConstant.PAGE_SIZE);
		//view.addObject("board", board);
		
		view.addObject("pagedNews", pagedNews);
		view.addObject("Cid",ColumnId);
		ColumnInfo ci= newsService.getColById(ColumnId);
		view.addObject("Colname",ci);
		//获取该栏目的子栏目列表
		List<ColumnInfo> subcols=newsService.ListSubCol(ColumnId);
		//获取该栏目的父栏目列表
		List<ColumnInfo> supcols=newsService.ListSupCol(ColumnId);
		view.addObject("ColList",subcols); 
		view.addObject("SupColList",supcols);
		view.setViewName("/listNews");
		return view;
	}
	
	
	/**
	 * 关键词检索的文章列表
	 * 
	 * @param 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/forum/listSearchNews")
	public ModelAndView listSearchNews(@RequestParam(value ="keyword",required=false) String keyword,@RequestParam(value = "pageNo", required = false) Integer pageNo) {
		ModelAndView view =new ModelAndView();
		//HttpServletRequest requst;
		pageNo = pageNo==null?1:pageNo;
		Page pagedNews =newsService.getSearchPagedNews(keyword,pageNo,CommonConstant.PAGE_SIZE);
		
		view.addObject("pagedNews", pagedNews);
		view.addObject("keyword",keyword);

		view.setViewName("/SearchNews");
		return view;
	}
	
	
	/**
	 * 列出某一篇新闻
	 * 
	 * @param topicId
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/Info/ViewInfo-{ColumnId}-{infoId}", method = RequestMethod.GET)
	public ModelAndView listTopicPosts(@PathVariable String ColumnId,@PathVariable int infoId) {
		ModelAndView view =new ModelAndView();
		
		//获取该栏目的父栏目列表
		List<ColumnInfo> supcols=newsService.ListSupCol(ColumnId);
		view.addObject("SupColList",supcols);
		
		NewsInfo ninfo = newsService.getInfoById(infoId);
		
		//查询附件情况
		Page filesList = newsService.selectFiles(infoId);
		view.addObject("filesList", filesList);
		view.addObject("Info", ninfo);
		view.setViewName("ViewInfo");
		return view;
	}
	
	/**
	 * 编辑某一篇新闻
	 * 
	 * @param topicId
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/Info/Edit-{infoId}", method = RequestMethod.GET)
	public ModelAndView editNews(@PathVariable int infoId) {
		ModelAndView view =new ModelAndView();
		NewsInfo ninfo = newsService.getInfoById(infoId);
		
		//查询所有的新闻分类,根据id排序
		List<ColumnInfo> columnInfoList = newsService.ListSubCol("01");
		view.addObject("columnInfoList", columnInfoList);
		
		//获取文章对应的columnid
		TextLink textLink = newsService.selectTextLinkByInfoId(ninfo.getInfoId());
		view.addObject("initialColumnId", textLink.getColumnId());
		
		//查询附件情况
		Page filesList = newsService.selectFiles(infoId);
		view.addObject("filesList", filesList);
		
		view.addObject("Info", ninfo);
		view.setViewName("/manage/EditNews");
		return view;
	}
	
	/**
	 * 删除某一篇新闻
	 * 
	 * @param topicId
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value = "/Info/del-{infoId}", method = RequestMethod.GET)
	public ModelAndView DeleteNews(@PathVariable int infoId,@RequestParam(value = "pageNo", required = false) Integer pageNo) throws IOException {
		ModelAndView view =new ModelAndView();
		newsService.DeleteNews(infoId);
		
		if(pageNo.equals("")){
			view.setViewName("redirect:/manage/listAll.html");
		}else{
			view.setViewName("redirect:/manage/listAll.html?pageNo="+pageNo);
		}
		return view;
	}
	/**
	 * 删除一个新闻的附件
	 * @param infoId
	 * @param fileId
	 * @return
	 */
	@RequestMapping(value = "/Info/delfile-{infoId}-{fileId}", method = RequestMethod.GET)
	public ModelAndView delfile(@PathVariable int infoId,@PathVariable int fileId,HttpServletRequest request) {
		ModelAndView view =new ModelAndView();
		//先删除附件文件
		TextDownload textDownload = newsService.queryById(fileId);
		String realPath = request.getSession().getServletContext().getRealPath(CommonConstant.UPLOAD_PATH);
		String filePath = realPath+"\\"+textDownload.getDatename();
		FileUtils.deleteQuietly(new File(filePath));
		//再删除附件记录
		newsService.delTextFiles(textDownload);
		
		view.setViewName("redirect:/Info/Edit-"+infoId+".html");
		return view;
	}
	/**
	 * 下载附件
	 * @param fileId
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/upload/{fileId}", method = RequestMethod.GET)
	public void downloadfile(@PathVariable int fileId,HttpServletRequest request,HttpServletResponse response) throws IOException {
		//获取目标文件的绝对路径
		TextDownload textDownload = newsService.queryById(fileId);
		String realPath = request.getSession().getServletContext().getRealPath(CommonConstant.UPLOAD_PATH);
		String filePath = realPath+textDownload.getDatename();
		//设置文件MIME类型
		response.setContentType(request.getSession().getServletContext().getMimeType(textDownload.getFilename()));
		//设置Content-Disposition  
		String file_name = new String(textDownload.getFilename().getBytes(), "ISO-8859-1");
        response.setHeader("Content-Disposition", "attachment;filename="+file_name); 
        
        
        //读取文件  
        InputStream in = new FileInputStream(filePath);  
        OutputStream out = response.getOutputStream();  
        //写文件  
        int b;  
        while((b=in.read())!= -1)  
        {  
            out.write(b);  
        }  
        in.close();  
        out.close(); 
        
	}
	
	
	/**
	 * 后台管理页面
	 * 
	 * @param topicId
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/manage", method = RequestMethod.GET)
	public ModelAndView adminManage(HttpServletRequest request) {
		ModelAndView view =new ModelAndView();
		User user = (User) request.getSession().getAttribute(CommonConstant.USER_CONTEXT);
		//判断登录用户是否是管理员
		if(user.getUserType()>=2){
			view.setViewName("/manage/main");
		}else{
			view.setViewName("forward:/index.html");
		}
		return view;
	}
	
	/**
	 * 后台管理页面Top
	 * 
	 * @param topicId
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/manage/top", method = RequestMethod.GET)
	public ModelAndView manageTop() {
		ModelAndView view =new ModelAndView();
		view.setViewName("/manage/top");
		return view;
	}
	
	/**
	 * 后台管理页面menu
	 * 
	 * @param topicId
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/manage/menu", method = RequestMethod.GET)
	public ModelAndView manageMenu() {
		ModelAndView view =new ModelAndView();
		view.setViewName("/manage/menu");
		return view;
	}
	
	
	/**
	 * 获取所有的子类别
	 * @return
	 */
	@RequestMapping(value = "/manage/colList-{ColumnId}", method = RequestMethod.GET)
	public ModelAndView colList(@PathVariable String ColumnId){
		
		ModelAndView view =new ModelAndView();
		//获取该栏目的子栏目列表
		List<ColumnInfo> subcols=newsService.ListSubCol(ColumnId);
		view.addObject("subcols",subcols);
		//获取该栏目的父栏目列表
		List<ColumnInfo> supcols=newsService.ListSupCol(ColumnId);
		view.addObject("SupColList",supcols);
		
		
		view.addObject("ColumnId", ColumnId);
		/*List<ColumnInfo> list = newsService.getAllColumnInfo();
		view.addObject("colList",list);*/
		
		view.setViewName("/manage/colList");
		return view;
	}
	
	/**
	 * 跳转到添加类别页面，同时返回新建类别的id
	 * @param ColumnId
	 * @return
	 */
	@RequestMapping(value = "/manage/addCol-{ColumnId}", method = RequestMethod.GET)
	public ModelAndView addCol(@PathVariable String ColumnId){
		ModelAndView view =new ModelAndView();
		
		
		
		if(ColumnId.equals("00")){
			view.addObject("ismenu",1);
		}else{
			view.addObject("ismenu",0);
		}
		
		String nextid;
		//获取该栏目的子栏目列表
		List<ColumnInfo> subcols=newsService.ListSubCol(ColumnId);
		if(subcols.isEmpty()){
			nextid=ColumnId+"01";
		}else{
			//获取该栏目的最后子栏目
			ColumnInfo columnInfo = subcols.get(subcols.size()-1);
			String columnid =columnInfo.getColumid();
			String ss = columnid.substring(columnid.length()-2, columnid.length());
			nextid = String.valueOf(Integer.parseInt(ss)+1);
			if(ss.startsWith("0")){
				nextid = "0"+nextid;
			}
			nextid = columnid.substring(0,columnid.length()-2)+nextid;
		
		}
		//获取该栏目的父栏目列表
		List<ColumnInfo> supcols=newsService.ListSupCol(nextid);
		view.addObject("SupColList",supcols);
		
		view.addObject("nextid", nextid);
		view.setViewName("/manage/addCol");
		return view;
	}
	/**
	 * 新增类别的保存
	 * @param req
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/manage/saveCol", method = RequestMethod.POST)
	public ModelAndView saveCol(ColumnInfo col){
		ModelAndView view = new ModelAndView();
		newsService.saveColumnInfo(col);
		
		String columid = col.getColumid();
		//view.setViewName("redirect:/manage/colList-00.html");
		if(columid.length()==2){
			view.setViewName("redirect:/manage/colList-00.html"); 
			return view;
		}
		String temp=columid.substring(0,columid.length()-2);
		view.setViewName("redirect:/manage/colList-"+temp+".html");
		return  view;
	}
	
	/**
	 * 跳转到修改类别页面
	 * @param columnId
	 * @return
	 */
	@RequestMapping(value = "/manage/editCol-{columnId}", method = RequestMethod.GET)
	public ModelAndView editCol(@PathVariable String columnId){
		ModelAndView view =new ModelAndView();
		
		ColumnInfo columnInfo = newsService.getColById(columnId);
		
		view.addObject("columnInfo",columnInfo);
		view.setViewName("/manage/editCol");
		return view;
	}
	
	/**
	 * 修改之后保存
	 * @param col
	 * @param req
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/manage/updateCol", method = RequestMethod.POST)
	public ModelAndView  updateCol(ColumnInfo col) throws ServletException, IOException{
		ModelAndView view = new ModelAndView();
		
		newsService.updateColumnInfo(col);
		String columid = col.getColumid();
		
		/*//获取该栏目的父栏目列表
		List<ColumnInfo> supcols=newsService.ListSupCol(columid);
		String supercolumid = supcols.get(0).getColumid();
		*/
		if(columid.length()==2){
			view.setViewName("redirect:/manage/colList-00.html"); 
			return view;
		}
		String temp=columid.substring(0,columid.length()-2);
		view.setViewName("redirect:/manage/colList-"+temp+".html");
		return view;
	}
	
	@RequestMapping(value = "/manage/delCol-{columnId}", method = RequestMethod.GET)
	public ModelAndView delCol(@PathVariable String columnId){
		ModelAndView view = new ModelAndView();
		List<ColumnInfo> listSubCol =newsService.ListSubCol(columnId);
    	if(listSubCol.isEmpty()){
    		
    		newsService.delColById(columnId);
    		if(columnId.length()==2){
    			view.setViewName("redirect:/manage/colList-00.html");
    			return view;
    		}
    		String temp=columnId.substring(0,columnId.length()-2);
    		view.setViewName("redirect:/manage/colList-"+temp+".html");
    		return view;
    	}else{
    		
    		view.addObject("errorMsg", "请先删除子项目");
    		view.setViewName("forward:/manage/colList-"+columnId+".html");
    		return view;
    	}
		
	}
	/**
	 * 
	 * 跳转科技信息页面
	 * @param ColumnId
	 * @param pageNo
	 * @return
	 */
	@RequestMapping(value = "/kjxx/listNews-{ColumnId}", method = RequestMethod.GET)
	public ModelAndView kjxx(@PathVariable String ColumnId,@RequestParam(value = "pageNo", required = false) Integer pageNo) {
		ModelAndView view =new ModelAndView();
		
		pageNo = pageNo==null?1:pageNo;
		Page pagedNews =newsService.getPagedNewsAndtop(ColumnId,pageNo,CommonConstant.PAGE_SIZE);
		
		view.addObject("pagedNews", pagedNews);
		view.addObject("Cid",ColumnId);
		ColumnInfo ci= newsService.getColById(ColumnId);
		view.addObject("Colname",ci);
		
		//获取该栏目的父栏目列表
		List<ColumnInfo> supcols=newsService.ListSupCol(ColumnId);
		view.addObject("SupColList",supcols);
		
		view.setViewName("/kjxx");
		return view;
	}
	
	/**
	 * 获取详细信息
	 * @param ColumnId
	 * @param infoId
	 * @return
	 */
	@RequestMapping(value = "/kjxx/NewsInfo-{ColumnId}-{infoId}", method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable String ColumnId,@PathVariable int infoId) {
		ModelAndView view =new ModelAndView();
		
		NewsInfo ninfo = newsService.getInfoById(infoId);
		//该篇文档浏览次数加1
		ninfo.setViewnum(ninfo.getViewnum()+1);
		newsService.updateNews(ninfo);
		
		//查询附件情况
		Page filesList = newsService.selectFiles(infoId);
		view.addObject("filesList", filesList);
		
		
		view.addObject("Info", ninfo);
		view.setViewName("/detail");
		return view;
	}
	
	/**
	 * 分页获取技术供需下的自建库数据
	 * @param ResId
	 * @param pageNo
	 * @return
	 */
	@RequestMapping(value="/jsgx/resource-{ResId}", method=RequestMethod.GET)
	public ModelAndView getResourceData(@PathVariable int ResId,@RequestParam(value = "pageNo", required = false) Integer pageNo){
		ModelAndView view =new ModelAndView();
		
		pageNo = pageNo==null?1:pageNo;
		Pagination pagination = queryDataByPage(ResId,pageNo,CommonConstant.PAGE_SIZE );
		
		ResInfo resInfo = dbmService.getResInfo(ResId);
		
		view.addObject("resInfo", resInfo);
		view.addObject("pagination", pagination);
		view.setViewName("/jsgx");
		return view;
	}
	
	/**
	 *技术共需下
	 * @param ResId 自建库id
	 * @param dataId 记录id
	 * @return
	 */
	@RequestMapping(value = "/jsgx/resource/{ResId}/{dataId}", method = RequestMethod.GET)
	public ModelAndView jsgxDetail(@PathVariable String ResId,@PathVariable String dataId) {
		ModelAndView view =new ModelAndView();
		
		ResInfo resInfo = dbmService.getResInfo(Integer.valueOf(ResId).intValue());
		
		List list = resDataService.queryDataById(resInfo.getResTblName(),new Integer(dataId));
		Map datamap = (Map) list.get(0);
		
		view.addObject("resInfo", resInfo);
		view.addObject("datamap", datamap);
		view.setViewName("/jsgxDetail");
		return view;
	}
	
	/**
	 * 技术经济人页面
	 * @param ResId
	 * @param pageNo
	 * @return
	 */
	@RequestMapping(value="/jjr/{ResId}", method=RequestMethod.GET)
	public ModelAndView jjrData(@PathVariable int ResId,@RequestParam(value = "pageNo", required = false) Integer pageNo,HttpServletRequest request){
		ModelAndView view =new ModelAndView();
		
		ResInfo resInfo = dbmService.getResInfo(ResId);
		//拿到检索的条件
		HttpSession session = request.getSession();
		String cate = (String) session.getAttribute("cate");//检索项
		String word = (String) session.getAttribute("word");//检索关键字
		
		//拼接查询条件
		String tj="";
		if(null==cate||""==cate){
			cate="0";
		}
		//如果关键字为空，默认查所有
		if(null==word||word.replaceAll(" ", "").length()<0){
			tj="1=1";
			cate="0";
		}else{
			word=word.replaceAll(" ", "");
			if(cate.equals("1")){
				tj=" realname like '%"+word+"%'";
			}
			if(cate.equals("2")){
				tj=" company like '%"+word+"%'";
			}
			if(cate.equals("3")){
				tj=" goodAt like '%"+word+"%'";
			}
			if(cate.equals("4")){
				tj=" work like '%"+word+"%'";
			}
			if(cate.equals("0")){
				tj=" work like '%"+word+"%' or realname like '%"+word+"%' or company like '%"+word+"%' or goodAt like '%"+word+"%'";
			}
		}
		pageNo = pageNo==null?1:pageNo;
		
		boolean flag;
		if(resInfo.getResFlow()==0){
			flag=false;
		}else{
			flag=true;
		}
		
		Pagination pagination = resDataService.queryPageDataByWhere(resInfo.getResTblName(), tj, pageNo, CommonConstant.PAGE_SIZE, flag);
		
		
		//回显检索项
		view.addObject("cate", cate);
		view.addObject("word", word);
		
		view.addObject("pagination", pagination);
		view.setViewName("/jjrList");
		return view;
	}
	
	/**
	 * 经纪人列表页搜索
	 * @param ResId
	 * @param cate
	 * @param word
	 * @param pageNo
	 * @return
	 */
	@RequestMapping(value="/jjr/{ResId}/searchJjr")
	public ModelAndView jjrSearch(@PathVariable int ResId,HttpServletRequest request){
		ModelAndView view =new ModelAndView();
		HttpSession session = request.getSession();
		
		String cate = request.getParameter("cate");
		String word = request.getParameter("word");
		
		session.setAttribute("cate", cate);
		session.setAttribute("word", word);
		
		view.setViewName("redirect:/jjr/"+ResId+".html");
		return view;
	}
	/**
	 * 获取经纪人详情
	 * @param ResId
	 * @param jjrId
	 * @return
	 */
	@RequestMapping(value="/jjrDetail/{ResId}-{jjrId}" ,method=RequestMethod.GET)
	public ModelAndView jjrDetail(@PathVariable int ResId,@PathVariable int jjrId){
		ModelAndView view =new ModelAndView();
		
		ResInfo resInfo = dbmService.getResInfo(ResId);
		List list = resDataService.queryDataById(resInfo.getResTblName(),jjrId);
		Map datamap = (Map) list.get(0);
		
		
		view.addObject("datamap", datamap);
		view.setViewName("/jjrDetail");
		return view;
	}
	
	@RequestMapping(value="/tsData" )
	public ModelAndView tskData(){
		ModelAndView view =new ModelAndView();
		//类别信息的显示
		ResInfo info = dbmService.getResInfo(16);
		//所有已审核的类别信息
		List cate_list = resDataService.queryDataCheckedCate(info.getResTblName());
		Integer cateid=1;
		if(cate_list.size()>0){
			Map<String, Object> map1 = (Map<String, Object>) cate_list.get(0);
			cateid = (Integer) map1.get("id");
		}
		view.addObject("cate_list", cate_list);
		view.setViewName("forward:/tsData/"+cateid+".html");
		return view;
	}
	/**
	 * 特色数据库中的类别转换+搜索
	 * @return
	 */
	@RequestMapping(value="/tsData/{cate_id}" )
	public ModelAndView tsData(@PathVariable int cate_id, HttpServletRequest request,@RequestParam(value = "pageNo", required = false) Integer pageNo){ 
		ModelAndView view = new ModelAndView();
		//类别信息的显示
		ResInfo info = dbmService.getResInfo(16);
		//所有已审核类别
		List cate_list = resDataService.queryDataCheckedCate(info.getResTblName());
		view.addObject("cate_list", cate_list);
		
		ApplicationContext context = (ApplicationContext) request.getSession().getServletContext().getAttribute("org.springframework.web.context.WebApplicationContext.ROOT");
		JdbcTemplate jt = (JdbcTemplate)context.getBean("jdbcTemplate");
		Map<String, Object> map = dbmService.getData(jt, info.getResTblName(),Integer.toString(cate_id));
		view.addObject("map", map);
		
		HttpSession session = request.getSession();
		
		String  resid = (String) session.getAttribute("resid");
		if(resid == null || resid.length()<=0){
			resid="18";		//默认检索文献库
		}
		String  words = (String) session.getAttribute("words");
		String where = " cate_id="+cate_id;
		if(words == null || words.replace("[\\s()]","").length()<=0){
			where+="";
		}else{
			words=words.replaceAll(" ", "");
			if(resid.equals("17")){
				where+=" and (patent_name like '%"+words+"%' or proposer like '%"+words+"%' or patent_number like '%"+words+"%' or digest like '%"+words+"%')";
			}else{
				where+=" and (title like '%"+words+"%' or author like '%"+words+"%' or keyword like '%"+words+"%' or digest like '%"+words+"%')";
			}
		}
		ResInfo resInfo = dbmService.getResInfo(Integer.parseInt(resid));
		boolean flag;
		if(resInfo.getResFlow()==0){
			flag=false;
		}else{
			flag=true;
		}
		pageNo = pageNo==null?1:pageNo;
		Pagination pagination = resDataService.queryPageDataByWhere(resInfo.getResTblName(), where, pageNo, CommonConstant.PAGE_SIZE, flag);
		
		view.addObject("resid", resid);
		view.addObject("words",words);
		view.addObject("cate_id",cate_id);
		view.addObject("pagination", pagination);
		
		view.setViewName("/tsData");
		return view;
	}
	/**
	 * 特色数据库中搜索
	 * @return
	 */
	@RequestMapping(value = "/tskData/search/{cate_id}")
	public ModelAndView tskDataSearch(@PathVariable String cate_id,HttpServletRequest request) {
		ModelAndView view =new ModelAndView();
		HttpSession session = request.getSession();
		
		String words = request.getParameter("words");
		String resid = request.getParameter("resid");
		
		session.setAttribute("words", words);
		session.setAttribute("cate_id", cate_id);
		session.setAttribute("resid", resid);
		
		view.setViewName("forward:/tsData/"+cate_id+".html");
		return view;
	}
	/**
	 * 特色数据库中数据库转换
	 * @return
	 */
	@RequestMapping(value = "/tskData/{cate_id}/{resid}",method=RequestMethod.GET)
	public ModelAndView getDataByresid(@PathVariable int cate_id,@PathVariable String resid,HttpServletRequest request){
		ModelAndView view =new ModelAndView();
		HttpSession session = request.getSession();
		session.setAttribute("cate_id", cate_id);
		session.setAttribute("resid", resid);
		
		view.setViewName("forward:/tsData/"+cate_id+".html");
		return view;
	}
	
	/**
	 * 特色数据详情
	 * @return
	 */
	@RequestMapping(value = "/tsData/{cate_id}/{resid}/{resDataid}",method=RequestMethod.GET)
	public ModelAndView gettsData(@PathVariable int cate_id,@PathVariable int resid,@PathVariable int resDataid){
		ModelAndView view =new ModelAndView();
		
		
		
		ResInfo resInfo = dbmService.getResInfo(resid);
		
		//所有已审核类别
		ResInfo cateInfo = dbmService.getResInfo(16);
		List cate_list = resDataService.queryDataCheckedCate(cateInfo.getResTblName());
		view.addObject("cate_list", cate_list);
		
		List list = resDataService.queryDataById(resInfo.getResTblName(), resDataid);
		Map datamap = (Map) list.get(0);
		view.addObject("datamap", datamap);
		
		view.addObject("cate_id", cate_id);
		if(resid==17){
			view.setViewName("/ts_zhuanli");
		}else{
			view.setViewName("/ts_wenxian");
		}
		return view;
	}
	
	/**
	 * 分页获取特色产品数据 清空session
	 */
	@RequestMapping(value="/techan/{resid}")
	public ModelAndView tsProductList(@PathVariable int resid,HttpServletRequest request){
		ModelAndView view =  new ModelAndView ();
		HttpSession session = request.getSession();
		session.setAttribute("product", "");
		view.setViewName("forward:/tsProduct/"+resid+".html");
		return view;
	}
	
	/**
	 * 分页获取特色产品数据 
	 * @param resid
	 * @param pageNo
	 * @return
	 */
	@RequestMapping(value="/tsProduct/{resid}")
	public ModelAndView tsProduct(@PathVariable int resid,@RequestParam(value = "pageNo", required = false) Integer pageNo, HttpServletRequest request){
		ModelAndView view =  new ModelAndView ();
		HttpSession session = request.getSession();
		String words = (String) session.getAttribute("product");
		ResInfo resInfo = dbmService.getResInfo(resid);
		boolean flag;
		if(resInfo.getResFlow()==0){
			flag=false;
		}else{
			flag=true;
		}
		pageNo = pageNo==null?1:pageNo;
		Pagination pageData;
		if(words == null || words.replace("[\\s()]","").length()<=0){
			pageData = resDataService.queryPageData(resInfo.getResTblName(), pageNo, 12, flag);
		}else{
			words=words.replaceAll(" ", "");
			String where =" name like '%"+words+"%' ";
			pageData = resDataService.queryPageDataByWhere(resInfo.getResTblName(), where, pageNo, 12, flag);
		}
		view.addObject("product",words);
		view.addObject("resid", resid);
		view.addObject("pageData", pageData);
		view.setViewName("/tsProduct");
		return view;
	}
	
	@RequestMapping(value="/tsProduct/{resid}/{id}")
	public ModelAndView tsProductDetail(@PathVariable int resid,@PathVariable int id){
		ModelAndView view =  new ModelAndView ();
		ResInfo resInfo = dbmService.getResInfo(resid);
		
		List list = resDataService.queryDataById(resInfo.getResTblName(), id);
		
		Map datamap = (Map) list.get(0);
		
		view.addObject("resid", resid);
		view.addObject("datamap", datamap);
		view.setViewName("/tsProDetail");
		return view;
	}
	
	@RequestMapping(value="/tsProduct/search")
	public ModelAndView tsProductSearch(HttpServletRequest request){
		ModelAndView view =  new ModelAndView ();
		HttpSession session = request.getSession();
		String resid = request.getParameter("resid");
		if(null==resid ||resid.replaceAll(" ","").length()<0){
			resid="19";
		}
		String product = request.getParameter("product");
		session.setAttribute("product", product);
		
		view.setViewName("forward:/tsProduct/"+resid+".html");
		return view;
	}
	
	
	@RequestMapping(value="/meet/{resid}/{cateid}")
	public ModelAndView meetList(@PathVariable int resid,@PathVariable int cateid,@RequestParam(value = "pageNo", required = false) Integer pageNo){
		ModelAndView view = new ModelAndView();
		//查询展会流程
		ResInfo resInfo = dbmService.getResInfo(resid);
		boolean flag;
		if(resInfo.getResFlow()==0){
			flag=false;
		}else{
			flag=true;
		}
		String where;
		String nowTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		if(cateid==1){
			where =" time > '"+nowTime+"'";
		}else{
			where =" time < '"+nowTime+"'";
		}
		pageNo = pageNo==null?1:pageNo;
		Pagination pagination = resDataService.queryPageDataByWhere(resInfo.getResTblName(), where, pageNo, 2, flag);
		
		//查询经纪人信息
		Pagination paginationjjr = queryDataByPage(13,1,4);
		
		view.addObject("jjrlist", paginationjjr);
		view.addObject("cateid", cateid);
		view.addObject("pagination", pagination);
		view.setViewName("/meet");
		return view;
	}
	
	
	
	@RequestMapping(value="/person-{username}")
 	public ModelAndView personDetail(@PathVariable String username,HttpServletRequest request){
		ModelAndView view = new ModelAndView();
		//查询经纪人库中信息
		String sql = "select * from tech_brokers where username = '" +username+"'";
		ServletContext servletContext = request.getSession().getServletContext();
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		JdbcTemplate jt = (JdbcTemplate) context.getBean("jdbcTemplate");
		List<Map<String, Object>> list = jt.queryForList(sql);
		Map<String, Object> map = new HashMap<>();
		if(null !=list){
			map = list.get(0);
		}
		
		
		view.addObject("datamap", map);
		view.setViewName("/personDetail");
		return view;
	}
	
	@RequestMapping(value="/personEdit-{resid}")
 	public ModelAndView personEdit(@PathVariable int resid,HttpServletRequest request){
		ModelAndView view = new ModelAndView();
		//查询经纪人库中信息
		String sql = "select * from tech_brokers where id = '" +resid+"'";
		ServletContext servletContext = request.getSession().getServletContext();
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		JdbcTemplate jt = (JdbcTemplate) context.getBean("jdbcTemplate");
		List<Map<String, Object>> list = jt.queryForList(sql);
		Map<String, Object> map = list.get(0);
		
		view.addObject("datamap", map);
		view.setViewName("/personEdit");
		return view;
	}
	
	
	
	
}
