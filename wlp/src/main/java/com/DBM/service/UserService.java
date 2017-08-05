package com.DBM.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DBM.dao.LoginLogDao;
import com.DBM.dao.OperationInfoDao;
import com.DBM.dao.Page;
import com.DBM.dao.ResInfoDao;
import com.DBM.dao.RoleDao;
import com.DBM.dao.RolepermissionDao;
import com.DBM.dao.UserDao;
import com.DBM.dao.UsergroupDao;
import com.DBM.dao.UserroleDao;
import com.DBM.domain.LoginLog;
import com.DBM.domain.Permission;
import com.DBM.domain.Role;
import com.DBM.domain.User;
import com.DBM.domain.User_group;
import com.DBM.domain.User_role;
import com.DBM.exception.UserExistException;

/**
 * 用户管理服务器，负责查询用户、注册用户、锁定用户等操作
 *
 */
@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private LoginLogDao loginLogDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private UserroleDao userroleDao;
	
	@Autowired
	private RolepermissionDao rolePerDao;
	
	@Autowired
	private OperationInfoDao operationInfoDao;
	
	@Autowired
	private UsergroupDao usergroupDao;
//	@Autowired
//	private PermissionDao permissionDao;
	
	 /**
	  * 获取用户，加入置顶，按照条件查询
	  * @return
	  */
    public Page getPageUsers(int pageNo,int pageSize,Date StartDate,Date endDate){
    	return userDao.getPagedUsers(pageNo, pageSize,StartDate,endDate);
    }
    
    /**
     * 根据条件查询用户信息
     * @param pageNo
     * @param pageSize
     * @param where
     * @return
     */
   public Page getPagedUsers1(int pageNo,int pageSize,String where){
	   return userDao.getPagedUsers1(pageNo, pageSize, where);
   }
	    /**
		  * 完善用户
		  * @return
		  */
	  public void getwanshan(User user){
		   userDao.save(user);
	  }
    /**
	  * 给新注册用户自动赋予角色
	  * @return
	  */
   public void getPageuserrole(User_role roleid){
	   userroleDao.save(roleid);
   }
   
    /**
	  * 获取用户，加入置顶，以修改时间时间降序排列(分页)
	  * @return
	  */
   public Page getPageUser(int pageNo,int pageSize){
   	
   	return userDao.getPagedUser(pageNo, pageSize);
   }
	/**
	 * 注册一个新用户,如果用户名已经存在此抛出UserExistException的异常
	 * @param user 
	 * @return 
	 */
	public int register(User user){
		User u = this.getUserByUserName(user.getUserName());
		User uu = this.getUserByemail(user.getEmail());
		if(u != null){
		    return 0;
		}else if(uu!=null){
	    	  return 1;	
		    }
		else{
		    user.setCredit(100);
            userDao.save(user);
            return 2;
		}
	}
	
	
	/**
     * 定时专用用户
     * @param user 
     */
    public List<User> dingshi(){
        return userDao.getdingshi();
    }
    
    
	/**
     * 更新用户
     * @param user 
     */
    public void update(User user){
    	
        userDao.update(user);
    }
	

	   /**
     * 根据用户名/密码查询 User对象
     * @param userName 用户名
     * @return User
     */
    public User getUserByUserName(String userName){
        return userDao.getUserByUserName(userName);
    }
    
    /**
     * 根据邮件查询 User对象
     * @param userName 用户名
     * @return User
     */
    public User getUserByemail(String email){
        return userDao.getUserByemail(email);
    }
	
	/**
	 * 根据userId加载User对象
	 * @param userId
	 * @return
	 */
	public User getUserById(int userId){
		return userDao.get(userId);
	}
	
	/**
	 * 根据userId加载User对象
	 * @param userId
	 * @return
	 */
	public void delUserById(int userId){
		User user = getUserById(userId);
		 userDao.remove(user);
	}
	
	/**
	 * 将用户锁定，锁定的用户不能够登录
	 * @param userName 锁定目标用户的用户名
	 */
	public void lockUser(String userName){
		User user = userDao.getUserByUserName(userName);
		user.setLocked(User.USER_LOCK);
	    userDao.update(user);
	}
	
	/**
	 * 解除用户的锁定
	 * @param userName 解除锁定目标用户的用户名
	 */
	public void unlockUser(String userName){
		User user = userDao.getUserByUserName(userName);
		user.setLocked(User.USER_UNLOCK);
		userDao.update(user);
	}
	
	
	/**
	 * 根据用户名为条件，执行模糊查询操作 
	 * @param userName 查询用户名
	 * @return 所有用户名前导匹配的userName的用户
	 */
	public List<User> queryUserByUserName(String userName){
		return userDao.queryUserByUserName(userName);
	}
	
	/**
	 * 获取所有用户
	 * @return 所有用户      联带板块查询
	 */
	public List<User> getAllUsers(){
		return userDao.loadAll();
	}
	
	
	/**
	 * 登陆成功 记入登录日志
	 * @param user
	 */
	public void loginSuccess(User user) {
		user.setCredit( 5 + user.getCredit());
		LoginLog loginLog = new LoginLog();
		loginLog.setUser(user);
		loginLog.setIp(user.getLastIp());
		loginLog.setLoginDate(new Date());
        userDao.update(user);
        loginLogDao.save(loginLog);
	}
	
	/**
	 * 判断该用户当天是否登录
	 * @return
	 */
	public int getLoginlog(int id){
	    return loginLogDao.Loginselect(id);
	}
	
	/**
	 * 判断该用户连续五天是否登录
	 * @return
	 */
	public int getLoginlogs(int id){
	    return loginLogDao.Loginselects(id);
	}
	/**
	 * 获取所有角色。
	 * @return
	 */
	public List<Role> getAllRole(){
		
		return roleDao.loadAll();
	}
	/**
	 * 添加角色。
	 * @return
	 */
	public void addRole (Role role){
		roleDao.save(role);
	}
	/**
	 * 删除角色。
	 * @return
	 */
	public void delRole (Role role){
		roleDao.remove(role);
	}
	
	/**
	 * 更新角色
	 * @param role
	 */
	public void updateRole(Role role){
		roleDao.update(role);
	}
	/**
	 * 根据角色id查询角色权限中间表
	 * @param roleid
	 * @return
	 */
	public List getRoleperlinkByRolid(Integer roleid){
		return rolePerDao.getrolepermissionByroleid(roleid);
	}
	/**
	 * 根据用户id获取当前用户的所有菜单路径
	 * @author maxiaocheng
	 */
	public List getAllManuByUserId(Integer userId){
		return operationInfoDao.getAllManuByUserId(userId);
	}
	
//	/**
//	 * 获取所有的权限信息
//	 * @return
//	 */
//	public List getAllPermission(){
//		return permissionDao.loadAll();
//	}
//	/**
//	 * 根据权限id查询权限信息
//	 * @param roleid
//	 * @return
//	 */
//	public Permission getPermissionByid(Integer perid){
//		
//		return permissionDao.getpermissionByid(perid);
//	}
	
	////////////////新项目用户登录//////////////////
	/**
	 * 登陆成功
	 * @param user
	 * @return 
	 */
	public User loginSuccessuser(String userName) {
		User user = userDao.getUserByUserName(userName);
        return user;
	}
	
	/**
	 * 根据菜单的路径获取所有的拥有者
	 * @param opUrl
	 * @return
	 */
	public List<User> getUsersByOPURL(String opUrl){
		return userDao.getUsersByOPURL(opUrl);
	}
	
	
	/**
	 * 根据角色id获取所有的用户
	 * @param opUrl
	 * @return
	 */
	public List<User> getUsersByRoleId(Integer roleId){
		return userDao.getUsersByRoleId(roleId);
	}
	
	/**
	 * 根据用户组id获取userGroup对象
	 */
	public List<User_group> getUserGroupById(String id){
		return usergroupDao.find("from User_group where groupid = "+id);
	}
}
