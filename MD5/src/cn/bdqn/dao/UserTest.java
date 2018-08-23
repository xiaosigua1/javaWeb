package cn.bdqn.dao;

import cn.bdqn.bean.User;
import cn.bdqn.util.Md5Util;

public class UserTest {

	public static void main(String[] args) throws Exception {
		// ģ��ע�Ṧ��
		UserDao dao = new UserDaoImpl();
		// ��ǰ̨��ȡ�û�������
		User user = new User();
		user.setUserName("����Ա");
		user.setPassword(Md5Util.getEncryptedPwd("admin"));// ����֮�������

		// ע���û�
		int num = dao.register(user);
		if (num > 0) {
			System.out.println("ע��ɹ���");
		} else {
			System.out.println("ע��ʧ�ܣ�");
		}

		// ģ���û���¼
		User loginUser = dao.login(new User("����Ա", "admin"));
		if (loginUser.getUserName().equals("����Ա")
				&& Md5Util.validPassword("admin", loginUser.getPassword())) {
			System.out.println("��¼�ɹ���");
		} else {
			System.out.println("��¼ʧ��");
		}
	}
}
