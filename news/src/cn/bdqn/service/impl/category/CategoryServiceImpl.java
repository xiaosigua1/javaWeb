package cn.bdqn.service.impl.category;

import java.io.Serializable;
import java.util.List;

import cn.bdqn.bean.News_Category;
import cn.bdqn.dao.DaoFactory;
import cn.bdqn.dao.category.CategoryDao;
import cn.bdqn.service.category.CategoryService;
import cn.bdqn.util.PageUtil;

public class CategoryServiceImpl implements CategoryService {

	private CategoryDao dao;

	public CategoryServiceImpl() {
		// ʵ������Ҫ��dao�����
		dao = (CategoryDao) DaoFactory.getDaoImpl("CategoryDao");
	}

	@Override
	public List<News_Category> getList() {
		return dao.getList();
	}

	@Override
	public int deleteById(Serializable id) {
		return dao.deleteById(id);
	}

	@Override
	public int update(News_Category t) {
		return dao.update(t);
	}

	@Override
	public int findPageCounts() {
		return dao.findPageCounts();
	}

	@Override
	public List<News_Category> findPageList(PageUtil util) {
		return dao.findPageList(util);
	}

	@Override
	public News_Category findById(Serializable id) {
		return dao.findById(id);
	}

	@Override
	public int add(News_Category t) {
		return dao.add(t);
	}
}
