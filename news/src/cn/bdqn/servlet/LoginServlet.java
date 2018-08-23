package cn.bdqn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.bean.News_User;
import cn.bdqn.service.impl.user.UserServiceImpl;
import cn.bdqn.service.user.UserService;

/**
 * �����¼��  servlet
 * 
 * 01.��ȡlogin.jspҳ���û�������
 * 02.���ö�Ӧservice��Ĵ���
 * 03.���бȶ�,���û���Ӧ
 *    001.�ȶԳɹ�������main.jsp
 *    002.ʧ�ܣ�����login.jsp
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp); // �����û���ʲô����ʽ ��ִ��doPost();
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ���post�������������
		request.setCharacterEncoding("utf-8");
		// ��ȡloginҳ���û�������û���������
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		UserService service = new UserServiceImpl();
		News_User user = service.loginUser(userName, password);

		// �ж��û��Ƿ�Ϊ��
		if (user == null) {
			response.sendRedirect("login.jsp"); // �ض���login.jsp
		} else { // �û���¼�ɹ�����������
			// ͨ�������ȡsession
			request.getSession().setAttribute("loginUser", user); // ���û�����Ϣ����session��������
			response.sendRedirect("main.jsp");// �ض�����ȥweb.xml�ļ��в�ѯurl-parttern
		}

	}

}
