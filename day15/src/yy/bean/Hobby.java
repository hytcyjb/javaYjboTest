package yy.bean;

/**
 * @describe 爱好的类
 * @author yjbo
 * @date 2018年1月14日21:39:10
 */
public class Hobby {

	private String name;// 爱好的名字

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
