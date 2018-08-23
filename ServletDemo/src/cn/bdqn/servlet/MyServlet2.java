package cn.bdqn.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ����
 *  ȫ�ֳ�ʼ������
 */
public class MyServlet2 extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("MyServlet2������ init��ʼ��**********************");
		System.out.println(config.getServletContext().getInitParameter(
				"userName"));
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("MyServlet2������ service�ɷ���**********************");
		super.service(req, resp); // �����ǵ��ø����service
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("MyServlet2������ doGet**********************");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("MyServlet2������ doPost**********************");
	}

	@Override
	public void destroy() {
		System.out.println("MyServlet2������ destroy ����**********************");
	}

}
