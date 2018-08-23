package cn.bdqn.sessionListener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class User implements HttpSessionListener {

	public User() {
		System.out
				.println("User implements HttpSessionListener ʵ����**************");
	}

	/**
	 * ����ʱ��
	 * ���û�����������Ŀ��ʱ��
	 */
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("������  sessionCreated  ����+1   ");
		// ��������ȡֵ
		Integer num = (Integer) event.getSession().getServletContext()
				.getAttribute("ONLINE_NUM");
		// ��һ�ν��� num==null
		if (num == null) {
			num = 1;
		} else {
			num++;
		}
		// ��ֵ�Ž�������
		event.getSession().getServletContext().setAttribute("ONLINE_NUM", num);
	}

	/**
	 * ����ʱ����
	 * 01.sessionʧЧ  session.invalidate();
	 * 02.session��ʱ  
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("������  sessionDestroyed  ����-1   ");
		// ��������ȡֵ
		Integer num = (Integer) event.getSession().getServletContext()
				.getAttribute("ONLINE_NUM");
		// ��һ�ν��� num==null
		if (num == null) {
			num = 0;
		} else {
			num--;
		}
		// ��ֵ�Ž�������
		event.getSession().getServletContext().setAttribute("ONLINE_NUM", num);
	}

}
