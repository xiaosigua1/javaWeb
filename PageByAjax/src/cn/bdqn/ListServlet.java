package cn.bdqn;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.bean.News_Detail;
import cn.bdqn.dao.NewsDao;
import cn.bdqn.dao.NewsDaoImpl;
import cn.bdqn.util.PageUtil;

import com.google.gson.Gson;

@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		// ����service��Ĵ��� ����ûд ֱ�ӵ���dao
		NewsDao dao = new NewsDaoImpl();

		PageUtil util = new PageUtil();
		// ��ȡ���ݿ���ܼ�¼��
		util.setTotalCount(dao.getPageCounts());
		// ��ȡǰ̨���ݵĲ���
		String num = req.getParameter("pageIndex");
		if (num != null && num != "") {
			util.setPageIndex(Integer.parseInt(num));
		} else {
			util.setPageIndex(1);
		}

		System.out.println("==================>" + num);

		// ���ú�̨���� ��ȡ list����
		List<News_Detail> list = dao.findNewsByPage(util);
		if (list != null) {
			list.get(0).setPageUtil(util); // ����ҳ�����Ը�ֵ
			// ��Ҫ��list����ת����json��ʽ������ ���ݸ�ǰ̨
			Gson gson = new Gson();
			String json = gson.toJson(list);
			System.out.println(json);
			resp.setHeader("content-type", "text/html;charset=utf-8");
			PrintWriter writer = resp.getWriter();
			writer.print(json);
			writer.close();
		}

	}
}
