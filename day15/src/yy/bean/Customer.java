package yy.bean;

/**
 * @describe 客户的单例
 * @author yjbo
 * @date 2018年1月7日 下午8:09:36
 */
public class Customer {

	private int id;// 唯一标识
	private String name;// 姓名
	private String sex;// 男、女
	private String birthday;// 1992-02-08
	private String phone;// 手机号，通过正则匹配一下
	private String email;// 邮箱号，通过正则匹配一下
	private String hobby;// 爱好，格式：唱歌,跳舞,看电影,学习,逛街,演讲（可多选）
	private String kind;// 客户类型，格式：非客户,普通客户,重要客户（不可多选）
	private String remarks;// 备注。格式，文字（最多50字）

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
		return "Customer客户 [id=" + id + ", name=" + name + ", sex=" + sex + ", birthday=" + birthday + ", phone=" + phone
				+ ", email=" + email + ", hobby=" + hobby + ", kind=" + kind + ", remarks=" + remarks + "]";
	}


}
