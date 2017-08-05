package com.DBM.web;

import static com.DBM.cons.CommonConstant.*;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.DBM.cons.CommonConstant;
import com.DBM.domain.User;

public class ForumFilter implements Filter {
	private static final String FILTERED_REQUEST = "@@session_context_filtered_request";
	
	// ① 不需要登录即可访问的URI资源
	private static final String[] INHERENT_ESCAPE_URIS = { "/index.jsp", "halloword.jsp", "/indexciyun.html",
			"/specialistsqlselect.html", "/index.html", "/login.jsp", "/login/doLogin", "/login/yanzheng","forum/index",
			"specialistTeam.html", "/register.jsp", "/register.html", "knowcenter/toHelloWorld.html","/login/doLogout.html",
			"knowcenter/kc_index","knowcenter/getFacet1","knowcenter/getFacet2","knowcenter/getFacet3","knowcenter/getFacet4","knowcenter/getFacet5","knowcenter/getFacet6",
			"knowcenter/getDataFacet","knowcenter/getCategory", "knowcenter/SearchInfo", "knowcenter/toIndex.html",
			"knowcenter/advancedSearch", "/product/ts_product.html", "literaturecenter/SearchInfo.html","MI/Read","literaturecenter/getlCFacet",
			"literaturecenter/index.html", "getSubcate", "MI/index.html", "manage/totest", "knowcenter/onlineRead","knowcenter/kc_onlineRead","listyear-",
			"knowcenter/toProjectData","literaturecenter/onlineRead","detail/onlineRead","/Productdetails-","advancedSearch/index","/forum/index.html",
			"datacenter/subindex","datacenter/getData","datacenter/getZB","datacenter/getIndex","datacenter/getNews","/datacenter/newsDetail","abount/topabount-",
			"/datacenter/getDates","/datacenter/getValue","/datacenter/getByValAndDate","registeremail.html","registeresuccessmail-","/login/emailmima","/product/ajaxlistEledetails-",
			"MI/getNA","MI/getPro","/specialistTeamDao-","/product/oneselect.html","/product/moreproduct-","producttype-","productDate-","listauthorunit-","/login/emailmimaupdate.html",
			"specialistsql-","/Chanpins/newsinfo-","MI/Read-","getchanpinSubcate.html","knowcenter/onlineRead-","/knowcenter/changeProPage","fenleiselect.html","/login/zhaohui.html","/product/yulan.html",
			"/Navigation/","/manage/categoryManage/getSubCategory.html","/Cloud/login.html","ideaoption.html","/knowcenter/hqyw-","/literaturecenter/hqyw-","/Recommend/list.html","/login/zhaohuimima.html",
			"detail/set/tourl","knowcenter/yulan-","PdfShow/web/viewer2","literaturecenter/Pdfshow/web/viewer2","/phone/index.html","/phone/specialistTeam.html","/phone/specialistTeamDao.html",
			"advancedSearch/getDataFacet","/phoneduct/oneselect.html","/phoneduct/moreproduct-","/phoneduct/fenleiselect.html","/phoneduct/ajaxlistEledetails-","/dh","/otherbusiness/other.html",
			"/nstlplatform/show.html","nstlplatform/more.html","/nstlplatform/details.html"
	};

	// ② 执行过滤
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("----------进入doFilter-------");
		// ②-1 保证该过滤器在一次请求中只被调用一次
		if (request != null && request.getAttribute(FILTERED_REQUEST) != null) {
			chain.doFilter(request, response);
		} else {

			// ②-2 设置过滤标识，防止一次请求多次过滤
			request.setAttribute(FILTERED_REQUEST, Boolean.TRUE);
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			User userContext = getSessionUser(httpRequest);
			System.out.println("-----url------" + httpRequest.getRequestURI());
			System.out.println("--不登录也可以访问--"+isURILogin(httpRequest.getRequestURI(), httpRequest));
			// ②-3 用户未登录, 且当前URI资源需要登录才能访问
			if (userContext == null && !isURILogin(httpRequest.getRequestURI(), httpRequest)) {
				String toUrl = httpRequest.getRequestURL().toString();
				if (!StringUtils.isEmpty(httpRequest.getQueryString())) {
					toUrl += "?" + httpRequest.getQueryString();
				}
				// ②-4将用户的请求URL保存在session中，用于登录成功之后，跳到目标URL
				httpRequest.getSession().setAttribute(LOGIN_TO_URL, toUrl);

				// ②-5转发到登录页面
				httpRequest.getSession().setAttribute("msg", "请登陆后继续浏览！");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				return;
			}else if(userContext != null) {
				/*
				 * 判断用户是否有权限访问此功能
				 */
				//判断权限
				
				String uri = httpRequest.getRequestURI();
				/*//
				if (uri.lastIndexOf("/")==uri.indexOf("/",1)) {
					chain.doFilter(request, response);
					return;
				}*/
				
				//1.判断只有二级路径的路过
				//2.只有一级的路径直接过，类似(/metalinfo/index.html或/metalinfo/)
				if (StringUtils.countMatches(uri, "/")<=2) {
					chain.doFilter(request, response);
					return;
				}
				
				uri = uri.substring(uri.indexOf("/", 1)+1, uri.indexOf("/", uri.indexOf("/", 1)+1));
				if(!isURILogin(httpRequest.getRequestURI(), httpRequest)&&("manage".equals(uri)||"DBM".equals(uri))){
					String uri2 = httpRequest.getRequestURI();
					
					//登录后可直接访问的资源
					uri2 = uri2.substring(uri2.indexOf("/", 1),uri2.length());
					if(uri2.equals("/manage/ArticleTrans/ToArticleTrans2.html")||
							uri2.equals("/manage/ArticleTrans/addArticleTrans.html")||
							uri2.equals("/manage/ArticleTrans/getDetail2.html")||
							uri2.equals("/manage/ArticleTrans/download.html")||
							uri2.equals("/manage/main.html")||
							uri2.equals("/manage/leftMenu.html")||
							uri2.equals("/manage/homePage.html")||
							uri2.equals("/manage/bottom.html")||
							uri2.equals("/manage/topTo.html")||
							uri2.equals("/manage/categoryManage/getMIBIAOYIN.html")){
						chain.doFilter(request, response);
						return;
					}
					
					uri2 = uri2.substring(0,uri2.lastIndexOf("/"));
					//获取当前用户的所有菜单
					List<String> manuList =(List) httpRequest.getSession().getAttribute(CommonConstant.ALL_MANU);
					//权限为空
					if (manuList==null||manuList.size()==0) {
						System.out.println("用户拥有访问权限-：false");
						httpResponse.sendRedirect(httpRequest.getContextPath()+"/index.html");
						return;
					}
					
					//判断权限
					for (String str : manuList) {
						str = str.substring(0, str.lastIndexOf("/"));
						if((uri2).equals(str)){
							System.out.println("用户拥有访问权限-：true");
							chain.doFilter(request, response);
							return;
						};
					}
					System.out.println("用户拥有访问权限-：false");
					//返回主页
					httpResponse.sendRedirect(httpRequest.getContextPath()+"/index.html");
					return;
				}
				
			}
			
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
			
	}

	/**
	 * 当前URI资源是否需要登录才能访问
	 * 
	 * @param requestURI
	 * @param request
	 * @return
	 */
	private boolean isURILogin(String requestURI, HttpServletRequest request) {
		if (request.getContextPath().equalsIgnoreCase(requestURI)
				|| (request.getContextPath() + "/").equalsIgnoreCase(requestURI))
			return true;
		for (String uri : INHERENT_ESCAPE_URIS) {
			if (requestURI != null && requestURI.indexOf(uri) >= 0) {
				return true;
			}
		}
		return false;
	}

	protected User getSessionUser(HttpServletRequest request) {
		return (User) request.getSession().getAttribute(USER_CONTEXT);
	}

	@Override
	public void destroy() {
	}
}
