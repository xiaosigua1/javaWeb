package cn.bdqn.dao;

import java.io.Serializable;

import cn.bdqn.bean.User;

public interface UserDao {

	/**
	 * 
	 * @param id������ѯ�ı��
	 * @return������һ��T����
	 */
	User findById(Serializable id);
}
