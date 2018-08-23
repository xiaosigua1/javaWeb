package cn.bdqn.bindingListener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * User���� �����仯 ��servlet�����ͻ�ͨ���������User��
 *  ��Ϊ����User implements HttpSessionBindingListener
 *  ���Ի������Ӧ��valueBound ����valueUnbound
 */
public class User implements HttpSessionBindingListener {

	private int ONLINE_NUM = 0; // Ĭ�ϵ���������
	private String userName; // �����˵�����

	/**
	 * ���¼���
	 * ������session�й��� User�����ʱ�� �����ķ���
	 */
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("������   valueBound   ����+1");
		System.out.println("��¼���û����ǣ�" + userName);
		ONLINE_NUM++;
	}

	/**
	 * ����¼���
	 * 01.sessionʧЧ  session.invalidate();
	 * 02.session��ʱ
	 * 03.session���ָ��������ʱ���߸ı�����ʱ
	 */
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("������   valueUnbound   ����-1");
		System.out.println("�˳���¼���û����ǣ�" + userName);
		ONLINE_NUM--;
	}

	public int getONLINE_NUM() {
		return ONLINE_NUM;
	}

	public void setONLINE_NUM(int oNLINE_NUM) {
		ONLINE_NUM = oNLINE_NUM;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public User(String userName) {
		super();
		this.userName = userName;
	}

	public User() {
		super();
	}

}
