package com.DBM.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLSpirit {
	/**
	 * 去掉html页面的标签
	 * 
	 * @param htmlStr
	 * @return
	 */
	public static String delHTMLTag(String htmlStr) {
		
		String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
		String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
		String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式


		Pattern p_script = Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE);
		Matcher m_script = p_script.matcher(htmlStr);
		htmlStr = m_script.replaceAll(""); // 过滤script标签

		Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
		Matcher m_style = p_style.matcher(htmlStr);
		htmlStr = m_style.replaceAll(""); // 过滤style标签
		
		
		Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
		Matcher m_html = p_html.matcher(htmlStr);
		htmlStr = m_html.replaceAll(""); // 过滤html标签
		
		return htmlStr.trim(); // 返回文本字符串
	}

	/*public static void main(String[] args) {
		String sr = delHTMLTag("<div class=\"c1\">好好玖玖爱</div>");
		System.out.println("结果----："+sr);
	}*/
	/**
	 * 去掉html页面的标签
	 * 
	 * @param htmlStr
	 * @return
	 */
	public static String delDivTag(String htmlStr) {
		
		if (htmlStr.indexOf("</div>") > 0) {
			htmlStr = htmlStr.substring(0, htmlStr.indexOf("</div>"));
		}
		if (htmlStr.indexOf("<div") > 0) {
			htmlStr = htmlStr.substring(0, htmlStr.indexOf("<div"));
		}
		if(htmlStr.indexOf("<a href=\"http://twitter.com/share") > 0){
			htmlStr = htmlStr.substring(0, htmlStr.indexOf("<a href=\"http://twitter.com/share"));
		}
		htmlStr = htmlStr.replace("&lt;", '<' + "");
		htmlStr = htmlStr.replace("&gt;", '>' + "");
		
		htmlStr = htmlStr.replace("&amp;", "&");//替换&
		return htmlStr;
	}

	/**
	 * 解决js中接参 含单双引号转义
	 * @param htmlStr
	 * @return
	 */
	public static String updateYinhao(String search) {
		search = search.replaceAll("\"", "&quot;");
		search = search.replaceAll("'", "&apos;");
		return search;
	}
	
	/**
	 * 删除search中的单双引号
	 * @param htmlStr
	 * @return
	 */
	public static String deleteYinhao(String search) {
		search = search.replaceAll("\"", "");
		search = search.replaceAll("'", "");
		return search;
	}

}
