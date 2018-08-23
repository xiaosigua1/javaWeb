package cn.bdqn.bean;

import java.util.Date;

/**
 * ��������ʵ����
 * @author С����
 */
public class News_Category {
	private Integer id; // ���ı��
	private String name; // ��������
	private Date createDate; // ����ʱ��

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public News_Category(Integer id, String name, Date createDate) {
		super();
		this.id = id;
		this.name = name;
		this.createDate = createDate;
	}

	public News_Category() {
		super();
	}

	@Override
	public String toString() {
		return "News_Category [id=" + id + ", name=" + name + ", createDate="
				+ createDate + "]";
	}

}
