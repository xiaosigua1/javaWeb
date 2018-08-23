package cn.bdqn.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.bean.News_User;

@WebFilter("/*")
public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// ���post������������
		request.setCharacterEncoding("utf-8");
		// ����ת��
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		// ��ȡ�û�ǰ̨�����·��
		String path = req.getRequestURI();
		// ��session��ȡ�Ƿ����û�
		News_User user = (News_User) req.getSession().getAttribute("loginUser");

		if (path.indexOf("login") > -1
				|| user != null
				|| (path.contains(".css") || path.contains(".js")
						&& (!path.contains(".jsp")))) {
			// ����
			chain.doFilter(request, response);
		} else {
			resp.sendRedirect("login.jsp");
		}

	}

	@Override
	public void destroy() {

	}

}
