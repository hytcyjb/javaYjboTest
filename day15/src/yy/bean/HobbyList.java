package yy.bean;

import java.util.ArrayList;
import java.util.List;

import yy.util.GlobalUtil;

/**
 * @describe 爱好的列表
 * @author yjbo
 * @date 2018年1月14日21:40:21
 */
public class HobbyList {

	private ArrayList<Hobby> list;

	public HobbyList() {
		super();
	}

	public ArrayList<Hobby> getList() {
		list = new ArrayList<>();
		for (int i = 0; i < GlobalUtil.gHobby.size(); i++) {
			list.add(new Hobby(GlobalUtil.gHobby.get(i)+""));
		}
		return list;
	}

	public void setList(ArrayList<Hobby> list) {
		this.list = list;
	}
}
