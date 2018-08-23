package cn.bdqn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.bean.User;

import com.google.gson.Gson;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// ������Ӧͷ��Ϣ
		resp.setHeader("Content-type", "text/html;charset=utf-8");
		// ģ������ݿ��л�ȡ����
		User user1 = new User("admin1", "a1");
		User user2 = new User("admin2", "a2");
		User user3 = new User("admin3", "a3");
		User user4 = new User("admin4", "a4");
		User user5 = new User("admin5", "a5");

		List<User> users = new ArrayList<User>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		users.add(user5);

		// ��Ϊǰ̨��dataType��json ������Ҫ�Ѽ���ת����json��ʽ ֮���ٷ���
		Gson gson = new Gson();
		String json = gson.toJson(users);
		System.out.println(json);

		// ���û���Ӧ
		PrintWriter pw = resp.getWriter();
		pw.print(json);
		pw.close();

	}

}
