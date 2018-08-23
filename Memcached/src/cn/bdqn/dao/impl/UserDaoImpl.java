package cn.bdqn.dao.impl;

import java.io.Serializable;

import org.apache.log4j.Logger;

import cn.bdqn.bean.User;
import cn.bdqn.dao.UserDao;
import cn.bdqn.util.BaseDao;
import cn.bdqn.util.MemcachedUtil;
import cn.bdqn.util.ResultSetUtil;

public class UserDaoImpl extends BaseDao implements UserDao {

	// ����memcached����
	private MemcachedUtil mc = MemcachedUtil.getInstance();
	Logger log = Logger.getLogger(UserDaoImpl.class);

	@Override
	public User findById(Serializable id) {
		User user = (User) mc.get("user" + id); // �ȴӻ����в�ѯ
		if (user == null) { // ֤��������û�ж���
			log.debug("������û�д˶��󣡣�");
			String sql = "select * from user where id=?";
			Object[] params = { id };
			rs = executeQuery(sql, params);
			user = ResultSetUtil.findT(rs, User.class);
			// ���õ������ݷ��뻺����
			mc.add("user" + user.getId(), user);
		}
		return user;
	}

}
