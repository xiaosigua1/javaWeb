package cn.bdqn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.bean.News_Detail;
import cn.bdqn.service.ServiceFactory;
import cn.bdqn.service.newsdetail.NewsDetailService;
import cn.bdqn.util.PageUtil;

import com.google.gson.Gson;

/**
 * �ڽ���main.jsp֮ǰ �����ȡ��  ����������Ϣ
 * 
 */
@WebServlet("/listServlet")
public class ListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ����service���ȡ���������б�ķ���
		response.setContentType("text/html;charset=utf-8");
		NewsDetailService s = (NewsDetailService) ServiceFactory
				.getServiceImpl("NewsDetailService");
		/**
		 * ��ȻҪ��ҳ������û�ȡ�û������ǵ�pageIndex
		 * ֻ���õ�pageIndex ���ǲ�����дsql��䣡
		 * limit (pageIndex-1)*pageSize,3
		 * 
		 * ��һ�� �û���¼  �ɹ�֮���������ListServlet
		 * pageIndex��ֵ��
		 * û��ֵ�����Ǹ��������ʼֵ
		 */
		String num = request.getParameter("pageIndex");
		// ʵ������ҳ�Ĺ�����
		PageUtil util = new PageUtil();
		if (num != null && !num.equals("")) { // ����ǰҳ��ֵ
			util.setPageIndex(Integer.parseInt(num));
		} else { // ��һ��û��ֵ
			util.setPageIndex(1);
		}
		// ���ܼ�¼����ֵ ��ͬʱ Ҳ�� ��ҳ�� ��ֵ��
		int totalCount = s.findPageCounts();// �ܼ�¼����ֵ
		util.setTotalCount(totalCount);

		// ��ҳ��ʾ ������Ϣ
		List<News_Detail> details = s.findPageList(util);
		if (details != null) {
			details.get(0).setPageUtil(util);
			// ����Gson
			Gson gson = new Gson();
			// ��Ҫ��pageUtil�Ž����ϵ�һ��������
			String json = gson.toJson(details);
			PrintWriter writer = response.getWriter();
			response.setHeader("Content-type", "text/html;charset=utf-8");
			writer.print(json);
			writer.close();
		} else {
			System.out.println("�����쳣��");
		}

	}

}
