Listener: ������

 ���������ӿڶ��Ǽ̳��� EventListener�ӿ�

01.HttpSessionBindingListener  ==>ָ������
     ���һ����ʵ����HttpSessionBindingListener����ô��������󱻰󶨻���ɾ����ʱ��servlet����
     ��֪ͨ������󣡵�������յ�֪ͨ�Ժ󣬲ſ��Խ���һЩ��ʼ���������ٹ�����

02.HttpSessionListener  ==>session
    ע��㣺  ��Ҫ��web.xml�ļ����������ǵļ�����
     <listener>
          <listener-class>cn.bdqn.sessionListener.User</listener-class>
     </listener>
    
    sessionDestroyedʲôʱ��ִ�еģ�
      001.sessionʧЧ
      002.session��ʱ
     
03.ServletContextListener  ==>application
 ��HttpSessionListener�е����ƣ�
 ��Ϊ 
  01. ������������Ҫ��web.xml�ļ�������==�������ڷ�����������ʱ��ʵ������
  02. ServletContextListener��������   �ڷ������رյ�ʱ��
  