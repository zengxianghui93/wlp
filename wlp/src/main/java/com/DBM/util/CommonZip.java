package com.DBM.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

public class CommonZip {
	
	//解压压缩文件
	@SuppressWarnings("rawtypes")
	public void unzip(File file,String unzipDir) throws ZipException, IOException{
		@SuppressWarnings("resource")
		ZipFile zipFile = new ZipFile(file,Charset.forName("GBK"));
		Enumeration entries = zipFile.entries();
		
		while(entries.hasMoreElements()){
			
			ZipEntry entry = (ZipEntry) entries.nextElement();
	        String name = entry.getName();
	        String path = unzipDir + name;
	        System.out.println(path);
	        File file2 = new File(path);

            if (entry.isDirectory()) {//是目录，就直接创建目录
                file2.mkdirs();
            }else{//是文件，模拟上传
            	InputStream is = zipFile.getInputStream(entry);
                byte[] buf1 = new byte[1024];
                int len;
                if (!file2.exists()) {
                    file2.getParentFile().mkdirs();
                    file2.createNewFile();
                }
                OutputStream out = new FileOutputStream(file2);
                while ((len = is.read(buf1)) > 0) {
                    out.write(buf1, 0, len);
                }
                out.close();
                is.close();
            }
		}
		zipFile.close();
	}
		
}
