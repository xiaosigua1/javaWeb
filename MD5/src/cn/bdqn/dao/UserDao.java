package cn.bdqn.dao;

import cn.bdqn.bean.User;

public interface UserDao {

	/**
	 * @param user  ע������û�
	 * @return  �Ƿ�ע��ɹ�
	 */
	int register(User user);

	/**
	 * @param user �û� ��¼
	 * @return
	 */
	User login(User user);
}
