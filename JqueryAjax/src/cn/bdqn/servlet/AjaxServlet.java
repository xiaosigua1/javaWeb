package cn.bdqn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AjaxServlet")
public class AjaxServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// �����post����
		req.setCharacterEncoding("utf-8");
		// ��ȡǰ̨�û�������
		String name = req.getParameter("userName");
		boolean flag = false;
		/**
		 * admin�����ǴӺ�̨���ݿ��л�ȡ��ֵ
		 */
		if (name.equals("admin")) {
			flag = true; // ���ݿ��д���
		}
		// ��Ӧ���ݸ��ͻ���
		PrintWriter pw = resp.getWriter();
		pw.print(flag); // �����ǰ̨
		pw.close();
		/**
		 * û�п���ת��   Ҳû�п����ض���
		 * ���ǻ����Ǹ�ҳ�棬ֻ�Ǿֲ���ˢ�£�
		 */
	}

}
