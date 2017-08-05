package com.DBM.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchEscape {
	
	/**
	 *  过滤特殊字符
	 */
	public  String escape(String search){
		String regEx="[`~!@#$%^&+=|{}\\\\':;',\\[\\].<>/?~！@#￥%……&（）——+|{}【】‘；：”“’。，、？]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(search);
		return m.replaceAll("").trim();
	}
	
	/*public static void main(String[] args) {
		SearchEscape se = new SearchEscape();
		String str = se.escape("宝钢大事件Nieuwe arbo-en/ *milieuregels[]Blik op\\// $(){}  de &&toekomst van het lassen");
		System.out.println(str);
	}*/
}
