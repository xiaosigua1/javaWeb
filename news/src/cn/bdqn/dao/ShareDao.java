package cn.bdqn.dao;

import java.io.Serializable;
import java.util.List;

import cn.bdqn.util.PageUtil;

/**
 *  �����еĹ�����ҵ�� ��������ӿ��У�
 *  
 *  �����ӿ������й����ķ�����
 * 
 */
public interface ShareDao<T> {

	/**
	 * @return  ��ѯ���е�T���͵�����
	 */
	List<T> getList();

	/**
	 * 
	 * @param id  ɾ���ı��
	 * @return  ����0 ɾ���ɹ�
	 */
	int deleteById(Serializable id);

	/**
	 * 
	 * @param id������ѯ�ı��
	 * @return������һ��T����
	 */
	T findById(Serializable id);

	/**
	 * 
	 * @param t  ��Ҫ�޸ĵ�T����
	 * @return ����0 �޸ĳɹ�
	 */
	int update(T t);

	/**
	 * 
	 * @param t  ��Ҫ������T����
	 * @return ����0 �����ɹ�
	 */
	int add(T t);

	/**
	 * @return  ��ѯ���ݿ���ָ�����е���������
	 */
	int findPageCounts();

	/**
	 * 
	 * @param util  ��ҳ�Ĺ�����   ��  ҳ��С  ��ǰҳ
	 * @return
	 */

	List<T> findPageList(PageUtil util);

}
