package cn.bdqn.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * shift +alt +s  ��д ����ķ���
 */
public class MyServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("MyServlet������ init��ʼ��**********************");
		/**
		 * userName ����������������ǵ�ǰ��servletʹ��
		 * ���⣿
		 *  �������е�servlet�����õ����userName������
		 *  ��ô�죿
		 *  ����ȫ�ֵĳ�ʼ��������������servlet����
		System.out.println("��ʼ���Ĳ���ֵ�ǣ�" + config.getInitParameter("userName"));
		 */
		System.out.println(config.getServletContext().getInitParameter(
				"userName"));
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("MyServlet������ service�ɷ���**********************");
		super.service(req, resp); // �����ǵ��ø����service
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("MyServlet������ doGet**********************");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("MyServlet������ doPost**********************");
	}

	@Override
	public void destroy() {
		System.out.println("MyServlet������ destroy ����**********************");
	}

}
