package yy.bean;

/**
 * @describe �ͻ��ĵ���
 * @author yjbo
 * @date 2018��1��7�� ����8:09:36
 */
public class Customer {

	private int id;// Ψһ��ʶ
	private String name;// ����
	private String sex;// �С�Ů
	private String birthday;// 1992-02-08
	private String phone;// �ֻ��ţ�ͨ������ƥ��һ��
	private String email;// ����ţ�ͨ������ƥ��һ��
	private String hobby;// ���ã���ʽ������,����,����Ӱ,ѧϰ,���,�ݽ����ɶ�ѡ��
	private String kind;// �ͻ����ͣ���ʽ���ǿͻ�,��ͨ�ͻ�,��Ҫ�ͻ������ɶ�ѡ��
	private String remarks;// ��ע����ʽ�����֣����50�֣�

	public Customer() {
		super();
	}

	public Customer(String name, String sex, String birthday, String phone, String email, String hobby, String kind,
			String remarks) {
		super();
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.phone = phone;
		this.email = email;
		this.hobby = hobby;
		this.kind = kind;
		this.remarks = remarks;
	}

	public Customer(int id, String name, String sex, String birthday, String phone, String email, String hobby,
			String kind, String remarks) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.phone = phone;
		this.email = email;
		this.hobby = hobby;
		this.kind = kind;
		this.remarks = remarks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "Customer�ͻ� [id=" + id + ", name=" + name + ", sex=" + sex + ", birthday=" + birthday + ", phone=" + phone
				+ ", email=" + email + ", hobby=" + hobby + ", kind=" + kind + ", remarks=" + remarks + "]";
	}


}
