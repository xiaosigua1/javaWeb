package cn.bdqn.servlet;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.bdqn.bean.News_Detail;
import cn.bdqn.service.ServiceFactory;
import cn.bdqn.service.newsdetail.NewsDetailService;

/**
 * �ļ�����   ===���ϴ�
 * 
 * ������
 *01.form���ύ��ʱ��  ���ļ���enctype="multipart/form-data"
 *02.������ļ��ϴ� ������Ҫ����2��jar
 *   fileupload �ļ��ϴ���jar   ������  io.jar
 *03.���ǵ�form����  ��ֻ�����ļ������� ��ͨ�� �ı������
 *   ��ʱ�� ������  ����ͬһ�ַ�ʽ ���д����𣿣���  No!
 *04.���ļ� ���ǰ����ļ��ķ�ʽ ����  
 *     001.������ô֪���û����������ļ��ϴ����ͣ�
 *       ServletFileUpload����һ��isMultipartContent(HttpServletRequest)����
 *         �����û�������  ���ǿ����ж�  �Ƿ����ļ��ϴ����͵����� ���� boolean
 *       
 *       ServletFileUpload�л���һ����Ҫ�ķ���parseRequest(HttpServletRequest)
 *        �����û�������,�������form���е�ÿһ��������ļ�������ͨ�ı�����װ����
 *        һ��FileItem���������������һ������FileItem��List����
 *       
 *     002.��ô�����ļ���
 *      FileItem �ӿ� 
 *          ����һϵ�еķ���   ���Խ����Ƿ����ļ�������ͨ�ı���
 *           getInputStream() ���ϴ��ļ����ص��ڴ���                                       ������
 *           getOutputStream() ���ڴ��е�����д�뵽���������ļ���                �����
 *           
 *           ������ļ����ͣ����ȡ�ļ���ʹ�� getName()
 *           �������ͨ�ı������ȡ�ֶ���ʹ�� getFieldName()
 *          
 *           ��ô֪�� ���ļ� ���� ��ͨ�ֶΣ���
 *            ��һ������ isFormField()  ����boolean
 *            true :��ͨ�ֶ�
 *            false:�ļ�
 *        
 *       DiskFileItemFactory ���ĵ�ʵ����  
 *           �����������ǻ������Ĵ�С setSizeThreshold(int sizeThreshold)  1024*1024          Ĭ�ϴ�С 10kb
 *           �����ļ���ʱ��ŵ�λ��    setRepository(File repository)    new  File("e:\temp")    Ĭ��·��System.getProperty("java.io.temdir")
 *    
 *   ����ͨ���ı������   ���ǰ�����ͨ�ķ�ʽ ����  
 *   
 *   
 *  ʵ���ļ��ϴ��Ĳ��裺
 *  01.����DiskFileItemFactory���� ���û������Ĵ�С  ��ŵ�λ��  �����Բ����� ��Ĭ��ֵ
 *  02.ͨ��DiskFileItemFactory���� ������ ServletFileUpload  ���Ϳ���֪�����ǵ������Ƿ����ļ��ϴ�����
 *  03.ͨ��ServletFileUpload�����  parseRequest���� ��ȡList<FileItem>
 *  04.��list���Ͻ��б�����ÿ����һ�ζ�Ҫʹ��FileItem���е�isFormField�������ж��Ƿ�Ϊ�ļ�
 *      001.��ͨ�ֶ�  ʹ�� getFieldName()  ��getString() ����ȡ�ֶ������ֶ�ֵ
 *      002.�ļ�   ʹ��getInputStream  getName  getOutputStream
 */
@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("��ʱ�ļ���λ�ã�" + System.getProperty("java.io.temdir"));
		// ��Ϊ�������� ��Ҫһ�����Ŷ���
		News_Detail detail = new News_Detail();

		// 01.����DiskFileItemFactory����
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 02.ͨ��DiskFileItemFactory���� ������ ServletFileUpload
		ServletFileUpload upload = new ServletFileUpload(factory);
		// �ж��ǲ��� �ļ��ϴ�����
		boolean flag = upload.isMultipartContent(request);

		if (flag) {
			// 03.ͨ��ServletFileUpload����� parseRequest���� ��ȡList<FileItem>
			try {
				List<FileItem> items = upload.parseRequest(request);
				// 04.��list���Ͻ��б�����ÿ����һ�ζ�Ҫʹ��FileItem���е�isFormField�������ж��Ƿ�Ϊ�ļ�
				Iterator<FileItem> its = items.iterator();
				while (its.hasNext()) {
					// ��ȡÿһ��
					FileItem item = its.next();
					if (item.isFormField()) { // ��ͨ�ֶ�
						// 001.��ͨ�ֶ� ʹ�� getFieldName() ��getString() ����ȡ�ֶ������ֶ�ֵ
						String fieldName = item.getFieldName();
						if (fieldName.equals("title")) {
							detail.setTitle(item.getString("utf-8"));
						} else if (fieldName.equals("author")) {
							detail.setAuthor(item.getString("utf-8"));
						} else if (fieldName.equals("summary")) {
							detail.setSummary(item.getString("utf-8"));
						} else if (fieldName.equals("content")) {
							detail.setContent(item.getString("utf-8"));
						} else if (fieldName.equals("createDate")) {
							detail.setCreateDate(new SimpleDateFormat(
									"MM/dd/yyyy").parse(item.getString("utf-8")));
						} else if (fieldName.equals("categoryId")) {
							detail.setCategoryId(Integer.parseInt(item
									.getString("utf-8")));
						}
					} else { // �ļ��ϴ�
						// ָ���ļ��ϴ���λ��getServletContext() ��ȡ������Ŀ�ڷ�������λ�� ==>
						// E:\apache-tomcat-7.0.77\webapps\news
						String uploadPath = request.getSession()
								.getServletContext().getRealPath("upload/");
						File file = new File(uploadPath);
						if (!file.exists()) {// ������ ���Ǵ���
							file.mkdirs();
						}
						String fileName = item.getName(); // �ļ�����
						if (!fileName.equals("") && fileName != null) { // �ж��û��Ƿ�ѡ�����ļ�
							File uploadFile = new File(fileName); // �ϴ����ļ�
							File saveFile = new File(uploadPath,
									uploadFile.getName());
							// ���������
							item.write(saveFile);
							detail.setPicPath(uploadFile.getName());
						}
					}
				}

				NewsDetailService service = (NewsDetailService) ServiceFactory
						.getServiceImpl("NewsDetailService");
				int num = service.add(detail);
				if (num > 0) { // �����ɹ�
					resp.sendRedirect("listServlet");
				} else {
					resp.sendRedirect("FindCategoryServlet");
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
