package cn.bdqn.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {

		System.out.println("LoginFilter����**********destroy");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		System.out.println("����   loginFilter");
		// ����ת��
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		// ��ȡ�û�ǰ̨�����·��
		String path = req.getRequestURI();
		System.out.println("getRequestURI===>" + path);
		// ��session��ȡ�Ƿ����û�
		String name = (String) req.getSession().getAttribute("user");

		if (path.indexOf("login") > -1 || name != null) {
			// ����
			chain.doFilter(request, response);
		} else {
			resp.sendRedirect("login.jsp");
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("LoginFilter��ʼ��**********init");

	}

}
