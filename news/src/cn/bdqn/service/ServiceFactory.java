package cn.bdqn.service;

import cn.bdqn.dao.DaoFactory;
import cn.bdqn.service.impl.category.CategoryServiceImpl;
import cn.bdqn.service.impl.newsdetail.NewsDetailServiceImpl;

public class ServiceFactory { // ����

	// 01.˽�л�����Ķ���
	private static ServiceFactory factory;

	// 02.˽�л�����
	private ServiceFactory() {
	}

	/**
	 * ��̬����� ��������factory��ʵ��
	 */
	static {
		if (factory == null) {
			synchronized (DaoFactory.class) {
				if (factory == null) {
					factory = new ServiceFactory();
				}
			}
		}
	}

	// 03.�ṩ���ⲿ���ʵĽӿ�
	public static ShareService getServiceImpl(String serviceImpl) {
		ShareService service = null;
		switch (serviceImpl) {
		case "NewsDetailService":
			service = new NewsDetailServiceImpl();
			break;
		case "CategoryService":
			service = new CategoryServiceImpl();
			break;
		default:
			break;
		}
		return service;
	}

}
