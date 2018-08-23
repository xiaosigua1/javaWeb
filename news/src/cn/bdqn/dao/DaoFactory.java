package cn.bdqn.dao;

import cn.bdqn.dao.impl.category.CategoryDaoImpl;
import cn.bdqn.dao.impl.newsdetail.NewsDetailDaoImpl;

/**
 * DaoFactory����
 */
public class DaoFactory {

	// 01.˽�л�����Ķ���
	private static DaoFactory factory;

	// 02.˽�л�����
	private DaoFactory() {
	}

	/**
	 * ��̬����� ��������factory��ʵ��
	 */
	static {
		if (factory == null) {
			synchronized (DaoFactory.class) {
				if (factory == null) {
					factory = new DaoFactory();
				}
			}
		}
	}

	// 03.�ṩ���ⲿ���ʵĽӿ�
	public static ShareDao getDaoImpl(String daoImpl) {
		ShareDao dao = null;
		switch (daoImpl) {
		case "NewsDetailDao":
			dao = new NewsDetailDaoImpl();
			break;
		case "CategoryDao":
			dao = new CategoryDaoImpl();
			break;
		default:
			break;
		}
		return dao;
	}

}
