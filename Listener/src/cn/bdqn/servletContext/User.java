package cn.bdqn.servletContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class User implements ServletContextListener {

	public User() {
		System.out
				.println("User implements ServletContextListener ʵ����**************");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("�ڷ����� ������ʱ��  ִ��.........");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("�ڷ����� �رյ�ʱ��  ִ��.........");
	}

}
