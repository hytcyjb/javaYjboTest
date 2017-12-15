package user.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

import user.bean.Person;

/**
 * 用户 <b>Date:</b>2017-12-15<br>
 * 
 * @author：yjbo@yonyou.com
 */
public class PersonUtil {
	// 登录功能，不需要使用密码验证了，没必要。
	public void login(Person newPerson) {
		XMLParseUtil xmlParseUtil = new XMLParseUtil();
		try {
			boolean exist = xmlParseUtil.isExist(newPerson.getName());
			if (exist) {// 用户名存在，则让其进入
			} else {// 登录失败
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 注册账号，返回系统信息
	public String registerPerson(Person newPerson) throws Exception {
		String reasonStr = "";
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("ssSSS");// 可以方便地修改日期格式
		String dateStr = dateFormat.format(now);
		String personid = dateStr + new Random().nextInt(10);
		Integer personidInt = Integer.valueOf(personid);
		Person person = new Person(personidInt, newPerson.getName(), newPerson.getTel(), newPerson.getEmail());
		XMLParseUtil xmlParseUtil = new XMLParseUtil();
		reasonStr = xmlParseUtil.addPerson(person);
		return reasonStr;
	}

	// 随机生成n个人---以后注意了唯一id用String类型的久没有数量限制了
	public void addPerson(int num) throws Exception {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("ssSSS");// 可以方便地修改日期格式
		String dateStr = dateFormat.format(now);
		System.out.println("当前生成的随机数" + dateStr);
		XMLParseUtil xmlParseUtil = new XMLParseUtil();
		List<Person> pList = new ArrayList<Person>();
		for (int j = 0; j < num; j++) {
			String personid = dateStr + j;
			Integer personidInt = Integer.valueOf(personid);
			pList.add(new Person(personidInt, "yjbo" + personid, Integer.valueOf("1851001" + j),
					"400520" + j + "@qq.com"));
		}
		xmlParseUtil.addMore(pList);
	}

	@Test
	public void testId() {
		XMLParseUtil xmlParseUtil = new XMLParseUtil();
		try {
			xmlParseUtil.updatePerson(new Person(15173, "abc", 1582002, "yjbo@qq.com"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
