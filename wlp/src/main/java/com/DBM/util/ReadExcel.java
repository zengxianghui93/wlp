package com.DBM.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.DBM.domain.ShareDoc;

public class ReadExcel {
    
    @SuppressWarnings("static-access")
    private String getValue(XSSFCell xssfRow) {
    	if(xssfRow != null){
	        if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
	            return String.valueOf(xssfRow.getBooleanCellValue());
	        } else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
	            return String.valueOf(xssfRow.getNumericCellValue());
	        } else {
	            return String.valueOf(xssfRow.getStringCellValue());
	        }
    	}
    	return null;
    }

    @SuppressWarnings("static-access")
    private String getValue(HSSFCell hssfCell) {
    	if(hssfCell != null){
    		 if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
    	          return String.valueOf(hssfCell.getBooleanCellValue());
    	      } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
    	          return String.valueOf(hssfCell.getNumericCellValue());
    	      } else {
    	          return String.valueOf(hssfCell.getStringCellValue());
    	      }
    	}
    	return null;
       
    }
    /**
     * Read the Excel 2003-2007
     * @param is 文件流
     * @param userId 用户id
     * @return
     * @throws IOException
     */
    public List<ShareDoc> readXls(InputStream is,int userId) throws IOException {
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        List<ShareDoc> list = new ArrayList<ShareDoc>();
        // Read the Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // Read the Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                	 ShareDoc shareDoc = new ShareDoc();
                	 HSSFCell title = hssfRow.getCell(0);
                     HSSFCell docType = hssfRow.getCell(1);
                     HSSFCell author = hssfRow.getCell(2);
                     HSSFCell abstracts = hssfRow.getCell(3);
                     HSSFCell keyword = hssfRow.getCell(4);
                     HSSFCell docLan = hssfRow.getCell(5);
                     HSSFCell issue = hssfRow.getCell(6);
                     HSSFCell journalName = hssfRow.getCell(7);
                     HSSFCell pubYear = hssfRow.getCell(8);
                     HSSFCell publisher = hssfRow.getCell(9);
                     HSSFCell volume = hssfRow.getCell(10);
                     HSSFCell description = hssfRow.getCell(11);
                     HSSFCell share = hssfRow.getCell(12);
                     HSSFCell attachment = hssfRow.getCell(13);
                     if(getValue(title)== null || getValue(title).equals("")){
                     	continue;
                     }
                     shareDoc.setTitle(getValue(title));
                     shareDoc.setDocType(getValue(docType));
                     shareDoc.setAuthor(getValue(author));
                     shareDoc.setAbstracts(getValue(abstracts));
                     shareDoc.setKeyword(getValue(keyword));
                     String docLanString = getValue(docLan);
                     if(docLanString != null){
                    	 if("英语".equals(docLanString)){
                    		 shareDoc.setDocLan("2");
                    	 }else if("德语".equals(docLanString)){
                    		 shareDoc.setDocLan("3");
                    	 }else if("法语".equals(docLanString)){
                    		 shareDoc.setDocLan("4");
                    	 }else if("意大利语".equals(docLanString)){
                    		 shareDoc.setDocLan("5");
                    	 }else if("中文".equals(docLanString)){
                    		 shareDoc.setDocLan("1");
                    	 }else if("日文".equals(docLanString)){
                    		 shareDoc.setDocLan("6");
                    	 }
                     }
                     shareDoc.setIssue(getValue(issue));
                     shareDoc.setJournalName(getValue(journalName));
                     shareDoc.setPubYear(getValue(pubYear));
                     shareDoc.setPublisher(getValue(publisher));
                     shareDoc.setVolume(getValue(volume));
                     shareDoc.setDescription(getValue(description));
                     shareDoc.setShare(Boolean.parseBoolean(getValue(share)));
                     shareDoc.setAttachment(getValue(attachment));
                     //	添加上传信息
                     shareDoc.setCreateTime(new Date());
                     shareDoc.setUserID(userId);
                     list.add(shareDoc);
                }
            }
        }
        return list;
    }

    /**
     * Read the Excel 2010
     * @param path the path of the excel file
     * @return
     * @throws IOException
     */
    public List<ShareDoc> readXlsx(InputStream is,int userId) throws IOException {
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        List<ShareDoc> list = new ArrayList<ShareDoc>();
        // Read the Sheet
        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }
            // Read the Row
            for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow != null) {
                	ShareDoc shareDoc = new ShareDoc();
                    XSSFCell title = xssfRow.getCell(0);
                    XSSFCell docType = xssfRow.getCell(1);
                    XSSFCell author = xssfRow.getCell(2);
                    XSSFCell abstracts = xssfRow.getCell(3);
                    XSSFCell keyword = xssfRow.getCell(4);
                    XSSFCell docLan = xssfRow.getCell(5);
                    XSSFCell issue = xssfRow.getCell(6);
                    XSSFCell journalName = xssfRow.getCell(7);
                    XSSFCell pubYear = xssfRow.getCell(8);
                    XSSFCell publisher = xssfRow.getCell(9);
                    XSSFCell volume = xssfRow.getCell(10);
                    XSSFCell description = xssfRow.getCell(11);
                    XSSFCell share = xssfRow.getCell(12);
                    XSSFCell attachment = xssfRow.getCell(13);
                    if(getValue(title)== null || getValue(title).equals("")){
                    	continue;
                    }
                    shareDoc.setTitle(getValue(title));
                    shareDoc.setDocType(getValue(docType));
                    shareDoc.setAuthor(getValue(author));
                    shareDoc.setAbstracts(getValue(abstracts));
                    shareDoc.setKeyword(getValue(keyword));
                    String docLanString = getValue(docLan);
                    if(docLanString != null){
                   	 if("英语".equals(docLanString)){
                   		 shareDoc.setDocLan("2");
                   	 }else if("德语".equals(docLanString)){
                   		 shareDoc.setDocLan("3");
                   	 }else if("法语".equals(docLanString)){
                   		 shareDoc.setDocLan("4");
                   	 }else if("意大利语".equals(docLanString)){
                   		 shareDoc.setDocLan("5");
                   	 }else if("中文".equals(docLanString)){
                   		 shareDoc.setDocLan("1");
                   	 }else if("日文".equals(docLanString)){
                   		 shareDoc.setDocLan("6");
                   	 }
                    }
                    shareDoc.setIssue(getValue(issue));
                    shareDoc.setJournalName(getValue(journalName));
                    shareDoc.setPubYear(getValue(pubYear));
                    shareDoc.setPublisher(getValue(publisher));
                    shareDoc.setVolume(getValue(volume));
                    shareDoc.setDescription(getValue(description));
                    shareDoc.setShare(Boolean.parseBoolean(getValue(share)));
                    shareDoc.setAttachment(getValue(attachment));
                    list.add(shareDoc);
                }
            }
        }
        return list;
    }

}