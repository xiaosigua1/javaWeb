package cn.bdqn.sessionListener;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sessionLogin")
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
		Integer num = (Integer) req.getSession().getServletContext()
				.getAttribute("ONLINE_NUM");
		// �ѵ�ǰ��¼���û������������� �Ž���������
		req.getSession().setAttribute("name", userName);
		req.getSession().setAttribute("num", num);
		resp.sendRedirect("sessionMain.jsp");
	}
}
