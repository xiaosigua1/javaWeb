package cn.bdqn.bean;

/**
 *  �û���Ӧ��ʵ����
 *  @author С����
 *
 */
public class News_User {

	private Integer id; // �û�ID
	private String userName; // �û���
	private String password; // ����
	private String email; // ����
	private Integer userType; // �û����� 0������Ա 1����ͨ�û�

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public News_User(Integer id, String userName, String password,
			String email, Integer userType) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.userType = userType;
	}

	public News_User() {
		super();
	}

	@Override
	public String toString() {
		return "News_User [id=" + id + ", userName=" + userName + ", password="
				+ password + ", email=" + email + ", userType=" + userType
				+ "]";
	}

}
