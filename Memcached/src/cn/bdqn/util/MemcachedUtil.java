package cn.bdqn.util;

import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

public class MemcachedUtil {
	// ����memcached�ͻ��˶���
	private static MemCachedClient client = new MemCachedClient();
	private static MemcachedUtil memcached = new MemcachedUtil();
	private static Logger log = Logger.getLogger(MemcachedUtil.class);
	static {
		log.debug("����ʵ����");
		// memcached�����ַ����Ϊ�Ƿֲ�ʽ��������Ϊ����,memcachedĬ�϶˿ں�Ϊ11211
		String[] servers = { "127.0.0.1:11211" };
		// Ϊ��servers����Ȩ�أ����ñ�������ȼ��뻺��������б�һ��
		Integer[] weights = { 3 };
		/*
		 * �����������ӳ�,����SchoonerSockIOPool.getInstance()���� �ڵ���getInstance(String
		 * s,boolean flag)s:"default",flag:true �ڵ����ܱ����Ĺ��췽��isTcp=flag
		 */
		// Ĭ�ϲ���TCPЭ��
		SockIOPool pool = SockIOPool.getInstance();
		// SockIOPool����SchoonerSockIOPool���setServers����
		pool.setServers(servers);// ��memcached�����ַ�����ӳ�
		pool.setWeights(weights);// ��memcached����Ȩ�ظ����ӳ�
		// �����Ƿ�������з�������Ĭ��ֵ��true
		pool.setFailover(true);
		// ���ó�ʼ��ʱ��ÿ��������������������Ŀ��ΪSchoonerSockIOPool���е�minConn��ֵ
		pool.setInitConn(5);
		/*
		 * ÿ��������������С�������������Բ��̷߳�����ĳ������������������ĿС�������Ŀʱ���ֲ�ʣ�µ����� Ĭ��ֵΪ8
		 */
		pool.setMinConn(5);
		// ÿ������������������������Ĭ��ֵ32
		pool.setMaxConn(250);
		// ���������ʱ�䣬��λ�����룬Ĭ��1000���룬��������long��
		pool.setMaxIdle(1000 * 60 * 60 * 6);
		// �������߳�˯��ʱ�䣬��λ�����룬Ĭ��30000���룬��������long�����߳������Թ���
		pool.setMaintSleep(30000);
		// Socket�Ĳ����������true��д����ʱ�����壬�������ͳ�ȥ��Ĭ��ֵΪ��false��
		pool.setNagle(false);
		// ���ö�ȡ���ݳ�ʱʱ�䣬Ĭ�ϣ�3000����λ����������
		pool.setSocketTO(3000);
		// �����Ƿ�ÿ�β�ѯ��������Ƿ���ã�Ĭ��false�����
		pool.setAliveCheck(true);
		// ��ʼ����ϣ��ײ����SchoonerSockIOPool���е�initialize����
		pool.initialize();
	}

	private MemcachedUtil() {
	}// ˽�л����췽��

	public static MemcachedUtil getInstance() {// �����ṩ�ӿ�
		return memcached;
	}

	/**
	 *  ����Ļ��������ݵ���ɾ�Ĳ� ���������� ����ʱ��
	 *   �ײ㶼���ṩ��������
	 */
	public boolean set(String key, Object value) {
		log.debug("����set��keyֵ�ǣ�" + key);
		log.debug("�Ƿ�Ž����棺" + client.set(key, value));
		return client.set(key, value);// ���set��key�Ѿ����ڣ���������Ը��¸�key����Ӧ��ԭ�������ݣ�Ҳ����ʵ�ָ��µ����á�
	}

	public boolean add(String key, Object value) {// ��ӻ����ж��󷽷�
		return client.add(key, value);
	}

	public boolean delete(String key) {
		return client.delete(key);
	}

	public boolean replace(String key, Object value) {// �滻�����еĶ��󷽷�
		return client.replace(key, value);
	}

	public Object get(String key) {// ��ȡ�����ж���ķ���
		return client.get(key);
	}

	public boolean flushAll() {
		Map map = client.stats(); // stats �������ڷ���ͳ����Ϣ���� PID(���̺�)���汾�š��������ȡ�
		Set entrySet = map.entrySet();
		for (Object object : entrySet) {
			log.debug(object);
		}
		return client.flushAll();
	}

}
