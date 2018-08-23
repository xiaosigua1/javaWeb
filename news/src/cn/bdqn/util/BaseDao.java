package cn.bdqn.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BaseDao {

	/**
	 * ��ȡ���������ԣ�
	 */
	protected Connection connection = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;

	/**
	 * �����������ݿ�ķ���      JDBC  API
	 
	public boolean getConnection() {
		try {
			// 001.��������
			Class.forName(ConfigManager.getValue("jdbc.driverClass"));
			// 002.�������ݿ�
			connection = DriverManager.getConnection(
					ConfigManager.getValue("jdbc.url"),
					ConfigManager.getValue("jdbc.userName"),
					ConfigManager.getValue("jdbc.password"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}*/

	/**
	 * ʹ�� JNDI  ���ӳؼ��� �������ݿ�
	 */
	public boolean getConnection() {
		try {
			// ��ʼ����������Ϣ ��ȡ������
			Context context = new InitialContext();
			DataSource source = (DataSource) context
					.lookup("java:comp/env/jdbc/news");
			connection = source.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * �ͷ���Դ   
	 *   �������ǿ��ж�
	 */
	public void closeConnection() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 *  ��ʼ��ȡ  ������� ��ɾ�� ����  executeUpdate
	 * @param sql  :�û����ݵ�sql���
	 * @param params  :�û�sql����еĲ����� ��Ϊ���ǲ�ȷ����û�в������м�������������
	 *                 ����ʹ��...!
	 *                 
	 *                 update  dog set name=? where id=?��
	 *                  ����������Object�����У�
	 *                 
	 *                 ������ �� params������Ĳ�������
	 *                 delete  from dog��
	 *                 ��ʱ��ֻ��Ҫ���� sql��䣡  ���ò���params��
	 *                 
	 *                 
	 */

	public int executeUpdate(String sql, Object... params) {
		int rowNum = 0; // Ӱ�������
		if (getConnection()) { // ���������
			// ����ִ��sql�Ķ���
			try {
				ps = connection.prepareStatement(sql);
				if (params != null) { // �в����� �м���ѽ��
					for (int i = 0; i < params.length; i++) {
						/**
						 *  �м������� ��ֵ ����
						 *  ֪������������������setObject
						 *  Ϊʲôдi + 1 �� ���Ǵ�1��ʼ�ģ�
						 */
						ps.setObject(i + 1, params[i]);
					}
				}
				rowNum = ps.executeUpdate();// û�в�����
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				// �ͷ���Դ
				closeConnection();
			}
		}

		return rowNum;
	}

	/**
	 * ��ʼ��ȡ  ������� ��ѯ ����  executeQuery
	 * @param sql 
	 * @param params
	 * @return  ResultSet  �����
	 * 
	 *   select * from  dog
	 *   select * from  dog  where id=?
	 *   
	 */
	public ResultSet executeQuery(String sql, Object... params) {
		if (getConnection()) { // ���������
			// ����ִ��sql�Ķ���
			try {
				ps = connection.prepareStatement(sql);
				if (params != null) { // �в����� �м���ѽ��
					for (int i = 0; i < params.length; i++) {
						ps.setObject(i + 1, params[i]);
					}
				}
				rs = ps.executeQuery();// û�в�����
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}

}
