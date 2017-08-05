package com.DBM.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.DBM.cons.CommonConstant;

@Controller
public class Ckeditor extends BaseController{
	private File upload;  
    private String uploadContentType;  
    private String uploadFileName;  
  
    public File getUpload() {  
        return upload;  
    }  
  
    public void setUpload(File upload) {  
        this.upload = upload;  
    }  
  
    public String getUploadContentType() {  
        return uploadContentType;  
    }  
  
    public void setUploadContentType(String uploadContentType) {  
        this.uploadContentType = uploadContentType;  
    }  
  
    public String getUploadFileName() {  
        return uploadFileName;  
    }  
  
    public void setUploadFileName(String uploadFileName) {  
        this.uploadFileName = uploadFileName;  
    }
    
    /**
     * ckeditor中图片上传，，
     * @param request
     * @param response
     * @param upload
     * @return
     * @throws Exception
     */
    @RequestMapping(value="uploadImage", method = RequestMethod.POST)
    public String upload(HttpServletRequest request,HttpServletResponse response,@RequestParam MultipartFile upload) throws Exception {  
    	
    	String uri = request.getRequestURI();
    	System.out.println(uri);
    	
    	
        response.setCharacterEncoding("UTF-8");  
        PrintWriter out = response.getWriter();
        
        uploadContentType=upload.getContentType();
  
        //CKEditor提交的很重要的一个参数  
        String callback = request.getParameter("CKEditorFuncNum");  
  
        String expandedName = ""; // 文件扩展名  
        if (uploadContentType.equals("image/pjpeg") || uploadContentType.equals("image/jpeg")) {  
            // IE6上传jpg图片的headimageContentType是image/pjpeg，而IE9以及火狐上传的jpg图片是image/jpeg  
            expandedName = ".jpg";  
        } else if (uploadContentType.equals("image/png") || uploadContentType.equals("image/x-png")) {  
            // IE6上传的png图片的headimageContentType是"image/x-png"  
            expandedName = ".png";  
        } else if (uploadContentType.equals("image/gif")) {  
            expandedName = ".gif";  
        } else if (uploadContentType.equals("image/bmp")) {  
            expandedName = ".bmp";  
        } else {  
            out.println("<script type=\"text/javascript\">");  
            out.println("window.parent.CKEDITOR.tools.callFunction(" + callback  
                    + ",'','文件格式不正确（必须为.jpg/.gif/.bmp/.png文件）');");  
            out.println("</script>");  
            return null;  
        }  
  
        if (upload.getSize() > 1000 * 1024) {  
            out.println("<script type=\"text/javascript\">");  
            out.println("window.parent.CKEDITOR.tools.callFunction(" + callback  
                    + ",''," + "'文件大小不得大于1M');");  
            out.println("</script>");  
            return null;  
        }  
       
        InputStream is = upload.getInputStream();  
        String uploadPath = request.getSession().getServletContext().getRealPath(CommonConstant.IMAGE_PATH);  
        String fileName = DateFormatUtils.format(new Date(), "yyyyMMddHHmmssSSS");//采用时间，避免重复
        
        fileName += expandedName;  
        File toFile = new File(uploadPath, fileName);  
        OutputStream os = new FileOutputStream(toFile);  
          
        // 文件复制到指定位置  
        byte[] buffer = new byte[1024];  
        int length = 0;  
        while ((length = is.read(buffer)) > 0) {  
            os.write(buffer, 0, length);  
        }  
        is.close();  
        os.close();  
        
        String fileaddress=uploadPath+fileName;
        String imageContextPath = request.getContextPath() + CommonConstant.IMAGE_PATH + fileName;
        
        // 返回“图像”选项卡并显示图片  
        out.println("<script type=\"text/javascript\">");  
        out.println("window.parent.CKEDITOR.tools.callFunction(" + callback  
                + ",'" + imageContextPath + "','')"); // 相对路径用于显示图片  
        out.println("</script>");  
        return null;  
    }  
    
    @RequestMapping(value="/DBM/uploadImage", method = RequestMethod.POST)
    public String uploadImage(HttpServletRequest request,HttpServletResponse response,@RequestParam MultipartFile upload) throws Exception {  
    	
    	String uri = request.getRequestURI();
    	System.out.println(uri);
    	
    	
        response.setCharacterEncoding("UTF-8");  
        PrintWriter out = response.getWriter();
        
        uploadContentType=upload.getContentType();
  
        //CKEditor提交的很重要的一个参数  
        String callback = request.getParameter("CKEditorFuncNum");  
  
        String expandedName = ""; // 文件扩展名  
        if (uploadContentType.equals("image/pjpeg") || uploadContentType.equals("image/jpeg")) {  
            // IE6上传jpg图片的headimageContentType是image/pjpeg，而IE9以及火狐上传的jpg图片是image/jpeg  
            expandedName = ".jpg";  
        } else if (uploadContentType.equals("image/png") || uploadContentType.equals("image/x-png")) {  
            // IE6上传的png图片的headimageContentType是"image/x-png"  
            expandedName = ".png";  
        } else if (uploadContentType.equals("image/gif")) {  
            expandedName = ".gif";  
        } else if (uploadContentType.equals("image/bmp")) {  
            expandedName = ".bmp";  
        } else {  
            out.println("<script type=\"text/javascript\">");  
            out.println("window.parent.CKEDITOR.tools.callFunction(" + callback  
                    + ",'','文件格式不正确（必须为.jpg/.gif/.bmp/.png文件）');");  
            out.println("</script>");  
            return null;  
        }  
  
        if (upload.getSize() > 1000 * 1024) {  
            out.println("<script type=\"text/javascript\">");  
            out.println("window.parent.CKEDITOR.tools.callFunction(" + callback  
                    + ",''," + "'文件大小不得大于1M');");  
            out.println("</script>");  
            return null;  
        }  
       
        InputStream is = upload.getInputStream();  
        String uploadPath = request.getSession().getServletContext().getRealPath(CommonConstant.IMAGE_PATH);  
        String fileName = DateFormatUtils.format(new Date(), "yyyyMMddHHmmssSSS");//采用时间，避免重复
        
        fileName += expandedName;  
        File toFile = new File(uploadPath, fileName);  
        OutputStream os = new FileOutputStream(toFile);  
          
        // 文件复制到指定位置  
        byte[] buffer = new byte[1024];  
        int length = 0;  
        while ((length = is.read(buffer)) > 0) {  
            os.write(buffer, 0, length);  
        }  
        is.close();  
        os.close();  
        
        String fileaddress=uploadPath+fileName;
        String imageContextPath = request.getContextPath() + CommonConstant.IMAGE_PATH + fileName;
        
        // 返回“图像”选项卡并显示图片  
        out.println("<script type=\"text/javascript\">");  
        out.println("window.parent.CKEDITOR.tools.callFunction(" + callback  
                + ",'" + imageContextPath + "','')"); // 相对路径用于显示图片  
        out.println("</script>");  
        return null;  
    }  
    
    /**
     * 超链接上传文件
     * @param request
     * @param response
     * @param upload
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/uploadFile", method = RequestMethod.POST)
    public String uploadFile(HttpServletRequest request,HttpServletResponse response,@RequestParam MultipartFile upload) throws Exception {
    	
    	response.setCharacterEncoding("UTF-8");  
        PrintWriter out = response.getWriter();
        
        uploadContentType=upload.getContentType();
        String originalFilename = upload.getOriginalFilename();
        //originalFilename = originalFilename.toUpperCase();
        //CKEditor提交的很重要的一个参数  
        String callback = request.getParameter("CKEditorFuncNum");  
        
  
        String expandedName = ""; 
        if (originalFilename.endsWith("doc")) {  
            expandedName = ".doc";
        } else if (originalFilename.endsWith("docx")) {  
            expandedName = ".docx";
        } else if (originalFilename.endsWith("xls")) {  
            expandedName = ".xls";
        } else if (originalFilename.endsWith("xlsx")) {  
            expandedName = ".xlsx";
        } else if (originalFilename.endsWith("ppt")) {  
            expandedName = ".ppt";    
        } else if (originalFilename.endsWith("pdf")) {  
            expandedName = ".pdf";
        } else {  
            out.println("<script type=\"text/javascript\">");  
            out.println("window.parent.CKEDITOR.tools.callFunction(" + callback  
                    + ",'','文件格式不正确（必须为/.doc/.pdf/.docx/.xls/.xlsx/.ppt文件）');");  
            out.println("</script>");  
            return null;  
        }  
  
        if (upload.getSize() > 1024 * 1024 *5) {  
            out.println("<script type=\"text/javascript\">");  
            out.println("window.parent.CKEDITOR.tools.callFunction(" + callback  
                    + ",''," + "'文件大小不得大于5M');");  
            out.println("</script>");  
            return null;  
        }  
  
        InputStream is = upload.getInputStream();  
        String uploadPath = request.getSession().getServletContext().getRealPath(CommonConstant.IMAGE_PATH);  
        String fileName = DateFormatUtils.format(new Date(), "yyyyMMddHHmmssSSS");//采用时间加随机数，避免重复
        
        fileName += expandedName;  
        File toFile = new File(uploadPath, fileName);  
        OutputStream os = new FileOutputStream(toFile);  
          
        // 文件复制到指定位置  
        byte[] buffer = new byte[1024];  
        int length = 0;  
        while ((length = is.read(buffer)) > 0) {  
            os.write(buffer, 0, length);  
        }  
        is.close();  
        os.close();  
        
        String fileaddress=uploadPath+fileName;
        String imageContextPath = request.getContextPath() + CommonConstant.IMAGE_PATH + fileName;
        
        // 返回“图像”选项卡并显示图片  
        out.println("<script type=\"text/javascript\">");  
        out.println("window.parent.CKEDITOR.tools.callFunction(" + callback  
                + ",'" + imageContextPath + "','')"); // 文件相对路径用于绑定超链接  
        out.println("</script>");  
        return null;
    	
    }
    
    
    
    
}  
    
    
    
    

