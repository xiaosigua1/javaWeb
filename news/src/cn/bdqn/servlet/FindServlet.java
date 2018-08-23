package cn.bdqn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.bean.News_Detail;
import cn.bdqn.service.ServiceFactory;
import cn.bdqn.service.newsdetail.NewsDetailService;

/**
 * ����id��ȡָ����������Ϣ
 */
@WebServlet("/findByIdServlet")
public class FindServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {

		NewsDetailService service = (NewsDetailService) ServiceFactory
				.getServiceImpl("NewsDetailService");

		// ��ȡa��ǩ���ݹ����� id
		String id = request.getParameter("id");
		News_Detail detail = service.findById(id);
		/**
		 * �Ѿ��õ�detail����
		 * Ϊ�����ݵĻ��ԣ� ����Ѷ���Ž�������
		 */
		request.setAttribute("detail", detail);
		// ת�����������޸�ҳ��
		request.getRequestDispatcher("update.jsp").forward(request, resp);
	}

}
