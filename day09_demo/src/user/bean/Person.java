package user.bean;

public class Person {

	/**
	 * {Person用户类}
	 * 
	 * @param 2017年12月14日13:55:28
	 * @author: yjbo
	 */
	private int personid;
	private String name;
	private int tel;
	private String email;
	public Person(){
		
	}
	public Person(int personid, String name, int tel, String email) {
		super();
		this.personid = personid;
		this.name = name;
		this.tel = tel;
		this.email = email;
	}

	public int getPersonid() {
		return personid;
	}

	public void setPersonid(int personid) {
		this.personid = personid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Person [personid=" + personid + ", name=" + name + ", tel="
				+ tel + ", email=" + email + "]";
	}

}

