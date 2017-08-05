package com.DBM.cons;

/**
 *整个应用通用的常量 
 *<br><b>类描述:</b>
 *<pre>|</pre>
 *@see
 *@since
 */
public class CommonConstant
{
   /**
    * 用户对象放到Session中的键名称
    */
   public static final String USER_CONTEXT = "USER_CONTEXT";
   /**
    * 经纪人信息
    */
   public static final String JJR_CONTEXT = "JJR_CONTEXT";
   
   /**
    * 将登录前的URL放到Session中的键名称
    */
   public static final String LOGIN_TO_URL = "toUrl";
   
   /**
    * 当前登录用户的所有菜单
    */
   public static final String ALL_MANU = "ALL_MANU";
   
   /**
    * 每页的记录数
    */
   public static final int PAGE_SIZE = 10;
   
   /**
   * 附件上传地址
   */
  public static final String UPLOAD_PATH = "/WEB-INF/upload/newsFile/";
  
  /**
   * 编辑器中内嵌图片上传地址
   */
  public static final String IMAGE_PATH = "/images/upload/newsImage/";
  
  /**
   * 
   * 用户头像上传地址
   */
  public static final String USER_IMAGE = "/images/upload/userPhoto";
  /**
   * 用户预览pdf原文时，产生临时文件的目录
   */
  public static final String TEMP_PDF = "/PdfShow/web";
  
  /**
   * 原文传递上传文件的路径
   */
  public static final String ARTICLETRANS_PATH = "/articleTrans";
  /**
   * 知识发布用户上传
   */
  public static final String USER_SHAREDOC = "/sharedocs";
  
  /**
   * 知识中心查询数据需要查的资源库
   */
  public static final String RESOURCE_KU = "wf_b_chinesejournal,wf_b_chinesemeeting,wf_b_chinesepatent,wf_b_dissertation,wf_b_libraryabstract,wf_b_meetingreport,wf_b_elepublication";
}
