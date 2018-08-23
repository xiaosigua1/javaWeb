package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.bean.News_Detail;
import cn.bdqn.util.PageUtil;

public interface NewsDao {
	/**
	 * ��ѯ�ܼ�¼��
	 */
	int getPageCounts();

	/**
	 * ��ҳ��ѯ
	 */
	List<News_Detail> findNewsByPage(PageUtil util);

}
