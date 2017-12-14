package user.interfac;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import user.bean.Person;

public interface IPersonInterface {

	// 查找出所有的用户
	public abstract List<Person> findAllPersons()
			throws ParserConfigurationException, SAXException, IOException;

	// 判断用户是否存在
	public abstract boolean isExist(String editName)
			throws ParserConfigurationException, SAXException, IOException;

	// 添加用户
	public abstract void addPerson(Person newPerson) throws Exception;

	// 添加列表用户
	public abstract void addMore(List<Person> pList) throws Exception;

	// 删除某用户
	public abstract boolean deletePerson(String editName) throws Exception;

	// 删除多个用户
	public abstract void deleteMore(List<Person> pList) throws Exception;

	// 修改某个用户
	public abstract boolean updatePerson(Person person) throws Exception;

}