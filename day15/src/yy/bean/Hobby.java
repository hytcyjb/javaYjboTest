package yy.bean;

/**
 * @describe ���õ���
 * @author yjbo
 * @date 2018��1��14��21:39:10
 */
public class Hobby {

	private String name;// ���õ�����

	public Hobby() {
		super();
	}

	public Hobby(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Hobby [name=" + name + "]";
	}



}
