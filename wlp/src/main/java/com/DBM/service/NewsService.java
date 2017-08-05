package com.DBM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DBM.dao.ColumnInfoDao;
import com.DBM.dao.DownloadDao;
import com.DBM.dao.NewsInfoDao;
import com.DBM.dao.Page;
import com.DBM.dao.TextLinkDao;
import com.DBM.domain.*;


@Service
public class NewsService {
	
	@Autowired
	private NewsInfoDao newsDao;
	@Autowired
	private ColumnInfoDao colDao;
	@Autowired
	private TextLinkDao  textLinkDao;
	@Autowired
	private DownloadDao textDownload ;
	
	/*
	 * 添加一篇新闻
	 */
	public void addNews(NewsInfo news){
		newsDao.save(news);
	}	
	
	/*
	 * 修改一篇新闻
	 */
	public void updateNews(NewsInfo news){
		newsDao.update(news);
	}
	
	/*
	 * 添加一篇新闻和分类的关联
	 */
	public void addTextLink(TextLink tl){
		textLinkDao.save(tl);
	}
	/*
	 * 修改一篇新闻和分类的关联
	 */
	public void updateTextLink(TextLink tl){
		textLinkDao.update(tl);
	}
	
	/**
	 * 根据新闻id，查询分类表记录
	 * @param info_id
	 * @return
	 */
	public TextLink selectTextLinkByInfoId(int info_id){
		
		 List<TextLink> list = textLinkDao.find("from TextLink where infoId = "+info_id);
		
		 TextLink textLink = (TextLink) list.get(0);
		 	return textLink;
		 
	}
	
	/*
	 * 添加一篇新闻和附件的关联
	 */
	public void addTextFiles(TextDownload  td){
		textDownload.save(td);
	}
	
	/**
	 * 根据新闻id查询附件
	 */
	public Page selectFiles(int info_id){
		return textDownload.ListFileByNews(info_id);
	}
	/**
	 * 根据附件id查询附件
	 * @param fileId
	 * @return
	 */
	public TextDownload queryById(int fileId){
		
		return textDownload.get(fileId);
	}
	/**
	 * 删除一篇新闻和附件的关联
	 */
	public void delTextFiles(TextDownload  td){
		textDownload.remove(td);
	}
	
	/**
     * 获取所有新闻文章
     * @return
     */
    public List<NewsInfo> getAllNews(){
        return newsDao.loadAll(); 
    }	
    
    /**
     * 获取所有子分类
     * @return
     */
    public List<ColumnInfo> ListSubCol(String column_id){
        return colDao.getSubCols(column_id);
    }
    
    /**
     * 获取所有父分类
     * @return
     */
    public List<ColumnInfo> ListSupCol(String column_id){
    	//循环的次数是该分类ID长度的一半
    	String sql="from ColumnInfo where column_id = '"+column_id+"'";
    	String tmpid="";
    	int len=column_id.length()/2;
    	//依次两位两位截取分类号
    	for(int i=1;i<len;i++)
    	{    		
    		sql+=" or column_id='"+column_id.substring(0, i*2)+"' ";
    	}
        return colDao.getSupCols(sql+" order by column_id");
    }
    
    
    
    /**
	 * 分页获取文章，以最后时间降序排列
	 * @param columnId
	 * @return
	 */
    public Page getPagedNews(String columnId,int pageNo,int pageSize){
		return newsDao.getPagedNews(columnId,pageNo, pageSize);
    }
    /**
	 * 分页获取文章，加入置顶，以修改时间时间降序排列
	 * @param columnId
	 * @return
	 */
    public Page getPagedNewsAndtop(String columnId,int pageNo,int pageSize){
    	
    	return newsDao.getPagedNewsAndTop(columnId, pageNo, pageSize);
    }
    /**
	 * 根据关键词，类别分页查找
	 * @param key
	 * @param column_id
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
    public Page getPageNewsBySearch(String where,int pageNo,int pageSize){
    	return newsDao.getPageNewsBySearch(where, pageNo, pageSize);
    }
    
    
    /**
	 * 检索获取文章，以最后时间降序排列
	 * @param keyword
	 * @return
	 */
    public Page getSearchPagedNews(String keyword,int pageNo,int pageSize){
		return newsDao.getSearchPagedNews(keyword,pageNo, pageSize);
    }
    
    /**
	 * 根据ID获取单篇文章
	 * @param boardId
	 * @return
	 */
    public NewsInfo getInfoById(int infoId){
    	return newsDao.get(infoId);
    }
    
    /**
	 * 根据ID删除单篇文章
	 * @param boardId
	 * @return
	 */
    public void  DeleteNews(int infoId){
    	newsDao.remove(newsDao.get(infoId));
    }
    
    /**
	 * 根据ID获取栏目
	 * @param cid
	 * @return
	 */
    public ColumnInfo getColById(String cid){
    	return colDao.get(cid);
    	
    }
   
    
    public void delColById(String cid){
	
		ColumnInfo columnInfo = getColById(cid);
		colDao.remove(columnInfo);
	
    }
    
    public List<ColumnInfo> getAllColumnInfo(){
    	
		return colDao.loadAll();
    }
    //查询所有的类别分类,根据id排序
    public List<ColumnInfo> allColumnInfoOrderById(){
    	
    	return colDao.allColOrderByid();
    }
    
    
    public void saveColumnInfo(ColumnInfo col){
    	colDao.save(col);
    }
    
    public void updateColumnInfo(ColumnInfo col){
    	colDao.update(col);
    }
    
    
    
    
    
}
