package user.interfac;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import user.bean.Person;

public interface IPersonInterface {

	// ���ҳ����е��û�
	public abstract List<Person> findAllPersons()
			throws ParserConfigurationException, SAXException, IOException;

	// �ж��û��Ƿ����
	public abstract boolean isExist(String editName)
			throws ParserConfigurationException, SAXException, IOException;

	// ����û�
	public abstract void addPerson(Person newPerson) throws Exception;

	// ����б��û�
	public abstract void addMore(List<Person> pList) throws Exception;

	// ɾ��ĳ�û�
	public abstract boolean deletePerson(String editName) throws Exception;

	// ɾ������û�
	public abstract void deleteMore(List<Person> pList) throws Exception;

	// �޸�ĳ���û�
	public abstract boolean updatePerson(Person person) throws Exception;

}