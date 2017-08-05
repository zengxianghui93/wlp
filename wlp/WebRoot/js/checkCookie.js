//获取指定cookie
function getCheckCookie(c_name) {
	if (document.cookie.length > 0) {
		c_start = document.cookie.indexOf(c_name + "=")
		if (c_start != -1) {
			c_start = c_start + c_name.length + 1
			c_end = document.cookie.indexOf(";", c_start)
			if (c_end == -1)
				c_end = document.cookie.length
			return unescape(document.cookie.substring(c_start, c_end), "UTF-8");  
		}
	}
	return ""
}
// 设置cookie
function setCheckCookie(c_name, value, expiredays) {
	var exdate = new Date()
	exdate.setDate(exdate.getDate() + expiredays)
	document.cookie = c_name + "=" + escape(value)
			+ ((expiredays == null) ? "" : "; expires=" + exdate.toGMTString())
}
//删除cookie 
function delCheckCookie(cookieName,fs,fq){
	if(getCheckCookie(cookieName).indexOf(fs+"|"+fq)>-1){
		var cookieName = getCheckCookie(cookieName);
		cookieName = cookieName.replace(fs+"|"+fq,'');
		if(cookieName.trim().startsWith(",")){
			cookieName = cookieName.replace(cookieName.indexOf(","),cookieName.length);
		}
		if(cookieName.trim().endsWith(",")){
			cookieName = cookieName.substring(0,cookieName.lastIndexOf("OR"));
		}
		document.cookie=cookieName+"="+escape(cookieName);
	}
}
