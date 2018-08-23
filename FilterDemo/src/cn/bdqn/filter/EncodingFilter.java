package cn.bdqn.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	/**
	 * ֻ���ڷ�����������ʱ��  ��ʼ��
	 */
	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("EncodingFilter��ʼ��**********init");
	}

	/**
	 * doFilter  �����������ǵ�����
	 * ServletRequest��HttpServletRequest�ĸ��ӿ�
	 * 01.ServletRequest���еķ���HttpServletRequest�ӿ��� ������
	 * 02.HttpServletRequest�ӿ������еķ�����ServletRequest����û�У�
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("���� EncodingFilter**************");
		// ���post������������
		request.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("EncodingFilter����**********destroy");
	}

}
