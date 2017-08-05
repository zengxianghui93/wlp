package com.DBM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DBM.cons.IPAuthorityEnum;
import com.DBM.dao.IPAuthorityDao;
import com.DBM.dao.Page;
import com.DBM.domain.IPAuthority;

/**
 * ip权限service层
 * @author maxiaocheng
 * 20170226
 */
@Service
public class IPAuthorityService {
	@Autowired
	IPAuthorityDao iPAuthorityDao;
	
	/**
	 * 添加ip权限控制
	 * @param IPAuthority
	 */
	public void addIPAuthority(IPAuthority iPAuthority){
		iPAuthorityDao.save(iPAuthority);
	}
	
	/**
	 * 修改ip权限控制
	 * @param IPAuthority
	 */
	public String updateIPAuthority(IPAuthority iPAuthority){
		IPAuthority ip = getIPAuthorityById(iPAuthority.getId());
		if(ip!=null){
			ip.setBeginIp(iPAuthority.getBeginIp());
			ip.setEndIp(iPAuthority.getEndIp());
			ip.setAuthorityType(iPAuthority.getAuthorityType());
			ip.setEditTime(iPAuthority.getEditTime());
			iPAuthorityDao.update(ip);
			return "success";
		};
		return "error";
	}
	
	/**
	 * 删除ip权限控制
	 * @param IPAuthority
	 */
	public void deleteIPAuthority(IPAuthority iPAuthority){
		IPAuthority ip = getIPAuthorityById(iPAuthority.getId());
		if(ip!=null){
			iPAuthorityDao.remove(ip);
		};
	}
	
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @return 
	 */
	public Page pageIPAuthority(int pageNo,int pageSize){
		return iPAuthorityDao.pageIPAuthorities(pageNo, pageSize);
	}
	
	/**
	 * 根据id获取IP权限实体类
	 * @param id
	 * @return 
	 */
	public IPAuthority getIPAuthorityById(Integer id){
		
		return iPAuthorityDao.getIPAuthorityById(id);
	}
	
	
	/**
	 * 根据用户IP和某个权限类型判断：用户是否有这个权限(此方法仅针对IPV4的比较判断)
	 * @param userIP
	 * @param authorityType(权限中文名称)
	 * @return true  or  false
	 */
	public boolean IPCompare(String userIP,String authorityType) {
		
		String[] ipv4 = userIP.split("\\.");
		//	转换为数字
		long ip4 = Long.parseLong(ipv4[0].trim());
		long ip3 = Long.parseLong(ipv4[1].trim());
		long ip2 = Long.parseLong(ipv4[2].trim());
		long ip1 = Long.parseLong(ipv4[3].trim());
		
		long num = (ip4<<24)| (ip3<<16) | (ip2<<8) | ip1;
		long begin = 0L;
		long end = 0L;
		
		IPAuthorityEnum iPAuthorityEnum = IPAuthorityEnum.valueOf(authorityType);
		if (iPAuthorityEnum == null) {
			return false;
		}
		
		List<IPAuthority> list = iPAuthorityDao.getIPAuthoritiesByAuthorityType(iPAuthorityEnum.getTypeId());
		
		for (IPAuthority ipAuthority : list) {
			String beginip = ipAuthority.getBeginIp();
			String endip = ipAuthority.getEndIp();
			
			String[] bip = beginip.split("\\.");
			String[] eip = endip.split("\\.");
			
			begin = Long.parseLong(bip[0].trim())<<24 | Long.parseLong(bip[1].trim())<<16|Long.parseLong(bip[2].trim())<<8|Long.parseLong(bip[3].trim());
			end = Long.parseLong(eip[0].trim())<<24 | Long.parseLong(eip[1].trim())<<16|Long.parseLong(eip[2].trim())<<8|Long.parseLong(eip[3].trim());
			//	远程IP允许访问		
			if(num >= begin && num <= end){
				
				return true;
			}
		}
		return false;
	}

	
}
