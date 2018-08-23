package cn.bdqn.test;

import org.apache.log4j.Logger;

import cn.bdqn.bean.User;
import cn.bdqn.dao.UserDao;
import cn.bdqn.dao.impl.UserDaoImpl;
import cn.bdqn.util.MemcachedUtil;

public class UserTest {
	public static void main(String[] args) {
		Logger log = Logger.getLogger(UserTest.class);
		UserDao dao = new UserDaoImpl();
		User user = dao.findById(1);
		log.debug("��һ�λ�ȡ �����ݿ�:" + user);
		user = dao.findById(1);
		log.debug("��2�λ�ȡ �߻���:" + user);

		MemcachedUtil mc = MemcachedUtil.getInstance();
		mc.flushAll();
		log.debug("����˻���");
	}

}
