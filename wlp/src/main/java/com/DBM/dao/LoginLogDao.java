package com.DBM.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

import com.DBM.domain.LoginLog;
import com.DBM.domain.User;


/**
 * Post的DAO类
 *
 */
@Repository
public class LoginLogDao extends BaseDao<LoginLog> {
	private final String GET_LOGINLOG = "from LoginLog u where u.user.userId=? and u.loginDate > curdate()";
	
	private final String GET_LOGINLOG1 = "from LoginLog u where u.user.userId=? and u.loginDate > curdate() ";
	
	@Override
	public void save(LoginLog loginLog) {
		this.getHibernateTemplate().save(loginLog);
	}
    /**
     * 查询某个用户当天是否登录
     */
	public int Loginselect(int id){
		List<LoginLog> list =this.find(GET_LOGINLOG,id);
		if(list.size()>0){
			return 0;
		}else{
			return 1;
		}
	}
	  /**
     * 查询某个用户是否连续五天登陆
     */
	@SuppressWarnings("unchecked")
	public int Loginselects(int id){
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String sql1 = "(select * from t_login_log u where u.user_id="+id+" and u.login_datetime between date_sub(curdate(),interval 1 day) and curdate())";
		String sql2 = "(select * from t_login_log u where u.user_id="+id+" and u.login_datetime between date_sub(curdate(),interval 2 day) and date_sub(curdate(),interval 1 day))";
		String sql3 = "(select * from t_login_log u where u.user_id="+id+" and u.login_datetime between date_sub(curdate(),interval 3 day) and date_sub(curdate(),interval 2 day))";
		String sql4 = "(select * from t_login_log u where u.user_id="+id+" and u.login_datetime between date_sub(curdate(),interval 4 day) and date_sub(curdate(),interval 3 day))";
		String sql5 = "(select * from t_login_log u where u.user_id="+id+" and u.login_datetime between date_sub(curdate(),interval 5 day) and date_sub(curdate(),interval 4 day))";
		List<LoginLog> list1 =this.find(GET_LOGINLOG1,id);
		if(list1.size()>0){
			SQLQuery list2 = session.createSQLQuery(sql1).addEntity(LoginLog.class);
			if(list2.list().size()>0){
				SQLQuery list3 = session.createSQLQuery(sql2).addEntity(LoginLog.class);
				if(list3.list().size()>0){
					SQLQuery list4 = session.createSQLQuery(sql3).addEntity(LoginLog.class);
					if(list4.list().size()>0){
						SQLQuery list5 = session.createSQLQuery(sql4).addEntity(LoginLog.class);
						if(list5.list().size()>0){
							SQLQuery list6 = session.createSQLQuery(sql5).addEntity(LoginLog.class);
							if(list6.list().size()>0){
								return 0;
							}else{
								return 1;	
							}
						}else{
							return 0;
						}
					}else{
						return 0;
					}
				}else{
					return 0;
				}
			}else{
				return 0;
			}
		}else{
			return 0;
		}
	}
}
