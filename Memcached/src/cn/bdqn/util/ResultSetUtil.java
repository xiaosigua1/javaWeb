package cn.bdqn.util;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *01.�����ݿ��ȡResultSet
 *   ���⣿   �����ڼ� ����֪��ResultSet����ʲô������
 *02.��ResultSet�������  ��ȡT����
 *03.����T���ͣ���ÿ������ ��ֵ
 *04.�Ž�list���� ���ؼ���
 */
public class ResultSetUtil {

	/**
	 * 
	 * @param rs      �����ݿ��ȡ�����ݽ����
	 * @param clazz   T����
	 * @return        T���͵ļ���
	 */
	public static <T> List<T> eachResultSet(ResultSet rs, Class<T> clazz) {
		List<T> list = new ArrayList<>();
		// ѭ��ResultSet 01.�Ȼ�ȡ���� 02.ѭ�����Ը�ֵ 03.�Ž�����
		try {
			T object = null;
			while (rs.next()) {
				object = clazz.newInstance(); // ʵ��������
				Field[] field = clazz.getDeclaredFields(); // ��ȡʵ������������ԣ�����Field����
				for (Field f : field) {
					f.setAccessible(true); // ���Է���˽������ ����ֵ
					f.set(object, rs.getObject(f.getName()));
				}
				list.add(object); // �Ž�����
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 
	 * @param rs      �����ݿ��ȡ�����ݽ����
	 * @param clazz   T����
	 * @return        T����
	 */
	public static <T> T findT(ResultSet rs, Class<T> clazz) {
		T object = null;
		try {
			if (rs.next()) {
				object = clazz.newInstance(); // ʵ��������
				Field[] field = clazz.getDeclaredFields(); // ��ȡʵ������������ԣ�����Field����
				for (Field f : field) {
					f.setAccessible(true); // ���Է���˽������ ����ֵ
					f.set(object, rs.getObject(f.getName()));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return object;
	}

}
