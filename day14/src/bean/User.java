package bean;
/**
 * @describe �û�javabean 
 * @author yjbo
 * @date 2018��1��6�� ����12:57:10
 */
public class User {

	private int id;
	private String name;
	private String password;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "user [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
	
}
