package cn.bdqn.service.user;

import cn.bdqn.bean.News_User;

public interface UserService {
	/**
	 *  �û���¼�ķ���
	 * 
	 * @param userName  �û���
	 * @param password    ����
	 * @return    ��¼�ɹ����û���Ϣ
	 */
	News_User loginUser(String userName, String password);
}
