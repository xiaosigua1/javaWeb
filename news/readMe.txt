����Դ�� DataSource
 �������ӽ������ӳأ�
javax.sql.DataSource���������ݿ�����ӣ�

���ݿ����ӳأ�Connection  Poll
  01.���������ͷ����ݿ����ӵ�һ������ؼ�����
  02.�Զ��������Ӷ��󲢶����õ����Ӷ�����л��գ�
  03.���ӳ����õ�Tomcat�е�conf�ļ��������context.xml�ļ�


JNDI(Java  Naming And  Directory Interface) 
java������Ŀ¼�ӿڣ�


����֮ǰʹ��JDBC�����������ݿ����ʹ��JDBC API��
����ʹ������Դ�������ӳصļ������������ݿ⣬����ʹ�� JNDI��


<Resource  
name="jdbc/news"
auth="Container" 
type="javax.sql.DataSource"
driverClassName="com.mysql.jdbc.Driver"
url="jdbc:mysql://localhost:3306/news?Unicode=true&characterEncoding=utf-8"
username="root"
password=""
/>


name:�Զ�������ӳ����ƣ��ⲿ��Ҫ��������������ӳأ�����ͨ��name����ֵ�ҵ��ģ�
auth�����ӳر�˭����Container������ Tomcat
type�����������
driverClassName �����ݿ����������
url�����ݿ�ĵ�ַ
username:��¼���ݿ���û���
password:��¼���ݿ������
maxActive:���ӳص�������ݿ���������  ����󲢷����ʵ�����
minIdle: ��С��������
maxIdle: ��С��������
maxWait: ��ʱ�ȴ�ʱ���Ժ���Ϊ��λ 

sql������ȷ�����ǿͻ��˵�����ʼ������Ч�����ӣ�








��ҳ��
 01.��ȡ�ܼ�¼��
 02.SELECT * FROM news_detail  LIMIT 0,3
  ��ʾ���ű���  �� ��һ�����ݿ�ʼ  ==��0    ��ʾ 3��   ===��ҳ��С pageSize
  
  ���⣿
  
  01.�û�����
  02.�û�ֻ֪�������һҳ����һҳ...... ��֪�� ���ݵ���ʼλ��
  03.���Ǳ�����û�����ĵ�ǰҳ �� ת���ɲ�ѯ���ݿ������ݿ�ʼ��λ�ã�Ŀ�ģ�
    

������

  01. �û������1ҳ  pageIndex=1
                 ���ǵ�sql�����ôд
                    LIMIT 0,3
 
  02. �û������2ҳ  pageIndex=2
                 ���ǵ�sql�����ôд
                    LIMIT 3,3
                    
  03. �û������3ҳ  pageIndex=3
                 ���ǵ�sql�����ôд
                    LIMIT 6,3
 
  3��ÿҳ��ʾ��������ҳ��С   pageSize
   
  �������ݿ�ʼ��λ��=��pageIndex-1��*pageSize
  
  
  
  






























