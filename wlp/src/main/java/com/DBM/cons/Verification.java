package com.DBM.cons;

import java.io.IOException;
import java.io.UnsupportedEncodingException;


import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;


public class Verification {

	/**
	 * 发送短信（成功true、失败false）
	 * @param phone	手机号码
	 * @param code	验证码
	 * @param uid	接口用户名
	 * @param key	接口密码
	 * @param desc	短信内容
	 * @return
	 */
	public static final boolean sendMail(String phone,String desc,String uid,String key){
		boolean b ;
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod("http://utf8.sms.webchinese.cn/");
		post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");// 在头文件中设
		NameValuePair[] data = { new NameValuePair("Uid", uid), new NameValuePair("Key", key),
				new NameValuePair("smsMob", phone), new NameValuePair("smsText", desc) };
		post.setRequestBody(data);
		try {
			client.executeMethod(post);
			b = true;
		} catch (HttpException e1) {
			e1.printStackTrace();
			b = false;
		} catch (IOException e1) {
			e1.printStackTrace();
			b = false;
		}
		Header[] headers = post.getResponseHeaders();
		int statusCode = post.getStatusCode();
		System.out.println("statusCode:" + statusCode);
		for (Header h : headers) {
			System.out.println(h.toString());
		}
		String result;
		try {
			result = new String(post.getResponseBodyAsString().getBytes("utf-8"));
			System.out.println("返回消息:"+result); // 打印返回消息状态
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		post.releaseConnection();
		return b;
	}
}
