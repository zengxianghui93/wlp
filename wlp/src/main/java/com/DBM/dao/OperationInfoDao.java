package com.DBM.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.DBM.domain.OperationInfo;


@Repository
public class OperationInfoDao  extends BaseDao<OperationInfo>{
	private final String GET_ROLE_OP = " from OperationInfo a,RoleOpInfo b where a.opId=b.OpId and b.RoleId = ? order by b.OpId";
	
	private final String GET_SUB_OP = "from OperationInfo where opId like ?  and CHAR_LENGTH(opId)=CHAR_LENGTH(?)+2 order by opId ";
	
	public List<OperationInfo> getRolesOP(int role_id) {	
		List<OperationInfo> ops=find(GET_ROLE_OP,role_id);
		return ops;
	}
	/**
	 * 获取子功能列表
	 * @param op_id
	 * @return
	 */
	public List<OperationInfo> getSubOps(String op_id) {
		//return pagedQuery(GET_PAGED_NEWS+"'"+column_id+"%' and NewsInfo.status=1 order by entry_date desc",pageNo,pageSize);//,column_id+"%");
		if(op_id.equals("00")){
			String hql = "from OperationInfo where op_type = 0 order by op_id";
			return find(hql);
		}
		
		return find(GET_SUB_OP,op_id+"%",op_id);
	}
	
	/**
	 * 获取父功能列表
	 * @param op_id
	 * @return
	 */
	public List<OperationInfo> getSupOps(String op_id) {
		//return pagedQuery(GET_PAGED_NEWS+"'"+column_id+"%' and NewsInfo.status=1 order by entry_date desc",pageNo,pageSize);//,column_id+"%");
		
		String sql="from OperationInfo where op_id = '"+op_id+"'";
		int len=op_id.length()/2;
    	//依次两位两位截取分类号
    	for(int i=1;i<len;i++)
    	{    		
    		sql+=" or op_id='"+op_id.substring(0, i*2)+"' ";
    	}
		
		return find(sql+" order by op_id");
	}
	
	/**
	 * 根据用户id获取当前用户的所有菜单路径
	 * @author maxiaocheng
	 */
	public List getAllManuByUserId(Integer userId){
		/*Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String sql = "SELECT op_url FROM tb_operation WHERE op_id in (SELECT op_id FROM tb_role_op WHERE role_id in (SELECT role_id FROM tb_user_role where user_id="+userId+"))";
		SQLQuery query = session.createSQLQuery(sql);
		List list = session.createQuery(sql).list();*/
		String hql = "SELECT opUrl FROM OperationInfo WHERE opId in (SELECT OpId FROM RoleOpInfo WHERE role_id in (SELECT roleid FROM User_role where userid="+userId+"))";
		return find(hql);
	}
	
	
}
