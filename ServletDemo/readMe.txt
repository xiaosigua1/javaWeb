Servlet�Ķ��壺

01. ������˵ javax.servlet.Servlet�Ľӿڣ�
02. ͨ����Ϊ һ����ʵ����Servlet�ӿڣ���ô��������servlet��

Servlet�����ã�

01.��ȡ�û�������  ===�����Ǿ�֪���û�����ʲô
02.������Ӧ��service�㷽��  ===������û���Ҫ�Ĳ���
03.���ݽ�������ظ��û���Ӧ

ע��㣺 servlet������ҵ���߼�����

Servlet��ʵ�֣�

01.ʵ��Servlet�ӿ�
02.�̳�GenericServlet
03.�̳�HttpServlet       ���õģ�

HttpServlet==��GenericServlet==��Servlet�ӿ�


Servlet����������         �������߳�

01.�ͻ��˷�������Servlet
02.�����ж����Servlet��ʵ���Ƿ���ڣ����û�д�����Servlet���ص��ڴ���
03.Servletʵ����==��init()��ʼ��Servlet
04.�ٸ����û�������ʽ����service()���ɷ�����ͬ�ķ�����������doGet(),doPost()��
05.�������رգ�ִ��destroy()����servlet


 ע��㣺 ����ʼ����ʱ����
    01. ����ͨ����Ϊ�û�������servlet�����Ͳ����ʼ����
    02. ��������ʱ����servlet�� 



	<!-- �������Ǵ�����servlet  -->
	<servlet>
	  <servlet-name>s</servlet-name>
	  <servlet-class>cn.bdqn.servlet.MyServlet1</servlet-class>
	</servlet>
	
	
	<!-- �û����ʵ����� -->
	<servlet-mapping>
	   <servlet-name>s</servlet-name>
	   <url-pattern>/MyServlet1</url-pattern>
	</servlet-mapping>
	<servlet-mapping>
	   <servlet-name>s</servlet-name>
	   <url-pattern>/MyServlet2</url-pattern>
	</servlet-mapping>


ע��㣺
01.servlet�ڵ������servlet-name�������ظ���
02.һ��servlet�ڵ���Ա����servlet-mapping����Ӧ��


load-on-startup  ���÷�����������ʱ��������ǵ�servlet
ֵ������һ���������� ֵԽС���ȼ�Խ�ߣ�
���ֵ��ȣ����ȼ��ǰ���servlet-mapping��˳��ִ�У�


serlvet3.0 �������ṩ��ע�⣡���������web.xml�ļ�������servlet�����⣡
���ǰ�����web.xml�е����÷ŵ��� ���Ե�servlet�У�




