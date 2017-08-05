package com.DBM.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

import com.DBM.domain.User;

import javassist.expr.NewArray;

/**
 * User对象Dao
 */
@Repository
public class UserDao extends BaseDao<User> {
	private final String GET_USER_BY_USERNAME = "from User u where u.userName = ?";
	private final String GET_USER_BY_EMAIL = "from User u where u.email = ?";
	private final String GET_USER = "from User";
	private final String QUERY_USER_BY_USERNAME = "from User u where u.userName like ?";
	private final String GET_USER_DINGHSI = "from User u where u.email !=''";
	private final String GET_USER_ROLES = " from User a,User_group b where a.userId=b.userid and b.groupid = ?";

	public List<User> getgroupu(int groupId) {
		List<User> user = find(GET_USER_ROLES, groupId);
		return user;
	}
	/**
	 * 查询所有注册成功的用户
	 * @param groupId
	 * @return
	 */
	public List<User> getdingshi() {
		List<User> user = find(GET_USER_DINGHSI);
		return user;
	}
	public List<User> getgroupuu(int groupId) {
		List userandgroup = find(GET_USER_ROLES, groupId);
		List<User> user = new ArrayList<>();
		if(null!=userandgroup){
			for(int i=0;i<userandgroup.size();i++){
				Object object = userandgroup.get(i);
				Object[] obj = (Object[]) object;
				User u = (User) obj[0];
				user.add(u);
			}
		}
		return user;
	}

	/*
	 * 完善用户信息(执行修改操作)
	 
	public int updateUser(String name,String department,String groups,String enterprisename,String birthday,String duty,
	String professional,String industry,String education,String user_address){
		List<User> user=find(GET_USER_ROLES,groupId);
		return user;
	}*/
	/**
	 * 查询所有用户
	 */
	public List<User> select(){
		List<User> users=this.find(GET_USER);
		return users;
	}
	/**
	 * 用户分页查询
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page getPagedUser(int pageNo, int pageSize) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String sql1 = "select a.user_id from t_user a";
		SQLQuery sqlQuery1 = session.createSQLQuery(sql1);
		int size = sqlQuery1.list().size();
		String sql = "( select * from t_user order by last_visit DESC limit 0," + size + ")";
		SQLQuery sqlQuery = session.createSQLQuery(sql).addEntity(User.class);
		int totalCount = sqlQuery.list().size();
		if (totalCount < 1)
			return new Page();
		// 实际查询返回分页对象
		int startIndex = Page.getStartOfPage(pageNo, pageSize);
		List list = sqlQuery.setFirstResult(startIndex).setMaxResults(pageSize).list();
		return new Page(startIndex, totalCount, pageSize, list);
	}

	/*
	 * 用户按条件分页查询
	 */
	public Page getPagedUsers(int pageNo, int pageSize, Date StartDate, Date endDate) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String sql1 = "select * from t_user where  last_visit > " + StartDate + " and last_visit < " + endDate + "";
		SQLQuery sqlQuery1 = session.createSQLQuery(sql1);
		int size = sqlQuery1.list().size();
		String sql = "( select * from t_user where  last_visit > " + StartDate + " and last_visit < " + endDate
				+ " and limit 0," + size + ")";
		SQLQuery sqlQuery = session.createSQLQuery(sql).addEntity(User.class);
		int totalCount = sqlQuery.list().size();
		if (totalCount < 1)
			return new Page();
		// 实际查询返回分页对象
		int startIndex = Page.getStartOfPage(pageNo, pageSize);
		List list = sqlQuery.setFirstResult(startIndex).setMaxResults(pageSize).list();
		return new Page(startIndex, totalCount, pageSize, list);
	}
	
	/**
	 * 根据条件查询用户列表
	 * @param pageNo
	 * @param pageSize
	 * @param where
	 * @return
	 */
	public Page getPagedUsers1(int pageNo,int pageSize,String where ){
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String sql1 = "select count(1) from t_user where "+where; 
		String sql2 = "select * from t_user where "+where; 
		SQLQuery sqlQuery1 = session.createSQLQuery(sql1);
		SQLQuery sqlQuery2 = session.createSQLQuery(sql2).addEntity(User.class);
		int totalCount = Integer.parseInt(sqlQuery1.uniqueResult().toString());
		if (totalCount < 1)
			return new Page();
		// 实际查询返回分页对象
		int startIndex = Page.getStartOfPage(pageNo, pageSize);
		List list = sqlQuery2.setFirstResult(startIndex).setMaxResults(pageSize).list();
		return new Page(startIndex, totalCount, pageSize, list);
		
	}

	/**
	 * 根据用户名查询User对象
	 * 
	 * @param userName
	 *            用户名
	 * @return 对应userName的User对象，如果不存在，返回null。
	 */
	public User getUserByUserName(String userName) {
		List<User> users = getHibernateTemplate().find(GET_USER_BY_USERNAME, userName);
		if (users.size() == 0) {
			return null;
		} else {
			return users.get(0);
		}
	}
	
	/**
	 * 根据邮箱查询User对象
	 * 
	 * @param email
	 *            邮箱
	 * @return 对应email的User对象，如果不存在，返回null。
	 */
	public User getUserByemail(String email) {
		List<User> users = getHibernateTemplate().find(GET_USER_BY_EMAIL, email);
		if (users.size() == 0) {
			return null;
		} else {
			return users.get(0);
		}
	}
	/**
	 * 根据用户名为模糊查询条件，查询出所有前缀匹配的User对象
	 * 
	 * @param userName
	 *            用户名查询条件
	 * @return 用户名前缀匹配的所有User对象
	 */
	public List<User> queryUserByUserName(String userName) {
		return getHibernateTemplate().find(QUERY_USER_BY_USERNAME, userName + "%");
	}
	
	/**
	 * 根据菜单的路径获取所有的拥有者
	 * @param opUrl
	 * @return
	 */
	public List<User> getUsersByOPURL(String opUrl){
		if (opUrl == null) {
			return null;
		}
		String sql = "SELECT * FROM t_user WHERE user_id in (SELECT user_id FROM tb_user_role WHERE role_id in (SELECT role_id FROM tb_role_op WHERE op_id in (SELECT op_id FROM tb_operation WHERE op_url = '"+opUrl+"')))";
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(sql).addEntity(User.class);
		return sqlQuery.list();
	}

	/**
	 * 根据角色id获取所有的用户
	 * @param opUrl
	 * @return
	 */
	public List<User> getUsersByRoleId(Integer roleId){
		if (roleId == null) {
			return null;
		}
		String sql = "SELECT * FROM t_user WHERE user_id in (SELECT user_id FROM tb_user_role WHERE role_id = "+roleId+")";
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(sql).addEntity(User.class);
		return sqlQuery.list();
	}
}
