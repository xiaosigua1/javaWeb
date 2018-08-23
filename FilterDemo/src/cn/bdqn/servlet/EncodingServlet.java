package cn.bdqn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class EncodingServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("������LoginServlet====��session�б����û���Ϣ");
		String name = request.getParameter("userName");
		if (name == null) { // û�д��û�
			response.sendRedirect("login.jsp");
		} else { // ���û�
			request.getSession().setAttribute("user", name);
			response.sendRedirect("main.jsp");
		}

	}

}
