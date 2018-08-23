package cn.bdqn.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ΪʲôҪ������� ���óɵ���ģʽ��
 *      ��Ϊ �������е��û�����һ��properties�ļ��Ϳ����ˣ�
 *      
 *     Ŀ�ľ���ֻ����һ�������ļ�!!!
 * 
 * 
 * ʧȥһ������,���û�����;��
 *  
 * @author С�а趹��
 * 2017-7-14����8:46:24
 */
public class ConfigManager {
	// 01.������̬��������� ����
	private static ConfigManager configManager;
	// ����Properties���� ��ȡjdbc.properties�ļ�
	private static Properties properties;

	// 02.˽�л�����
	static {
		String path = "jdbc.properties";
		properties = new Properties();
		// ��������������
		InputStream stream = ConfigManager.class.getClassLoader()
				.getResourceAsStream(path);
		try {
			properties.load(stream); // properties�ļ����ص��ڴ���
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				stream.close(); // �ر���
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 03.�������ⲿ���ʵĽӿ�
	public static synchronized ConfigManager getInstance() {
		return configManager;
	}

	// properties�ļ��Ǽ�ֵ�Ե���ʽ�� �����ṩkey Ŀ�Ļ�ȡvalue
	public static String getValue(String key) {
		return properties.getProperty(key);
	}

}
