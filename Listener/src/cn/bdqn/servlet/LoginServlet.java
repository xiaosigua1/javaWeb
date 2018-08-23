package cn.bdqn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.bindingListener.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// ����post����
		req.setCharacterEncoding("utf-8");
		String userName = req.getParameter("userName");
		// �ж��û��Ƿ�����
		if (userName == null || userName == "") {
			resp.sendRedirect("login.jsp");
		} else {
			// �û�����ֵ ���ǻ�ȡ�û�
			// ʵ�������ǵ��û�
			User user = new User(userName);
			// ���Ұ��û����浽session��
			System.out.println("----------------------------------------");
			req.getSession().setAttribute("user", user);
			System.out.println("----------------------------------------");
			// ��ת����ҳ��
			resp.sendRedirect("main.jsp");
		}

	}

}
