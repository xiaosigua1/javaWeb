package cn.bdqn.dao.user;

import cn.bdqn.bean.News_User;

public interface UserDao {
	/**
	 *  �û���¼�ķ���
	 * 
	 * @param userName  �û���
	 * @param password    ����
	 * @return    ��¼�ɹ����û���Ϣ
	 */
	News_User loginUser(String userName, String password);

}
