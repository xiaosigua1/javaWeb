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
 * �������޸Ĳ���
 */
@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ���post��������
		request.setCharacterEncoding("utf-8");

		NewsDetailService service = (NewsDetailService) ServiceFactory
				.getServiceImpl("NewsDetailService");
		// ��ȡa��ǩ���ݹ����� id
		String id = request.getParameter("id");
		// ����һ�����Ŷ���
		News_Detail detail = new News_Detail();
		// ��ȡ���� ��������Ϣ
		detail.setAuthor(request.getParameter("author"));
		detail.setTitle(request.getParameter("title"));
		detail.setContent(request.getParameter("content"));
		detail.setSummary(request.getParameter("summary"));
		detail.setCategoryId(Integer.parseInt(request
				.getParameter("categoryId")));
		detail.setId(Integer.parseInt(id));
		// ��ȡ�޸�ʱ��

		int flag = service.update(detail);
		if (flag > 0) { // �޸ĳɹ�
			response.sendRedirect("listServlet");
		} else {
			response.sendRedirect("update.jsp");
		}

	}

}
