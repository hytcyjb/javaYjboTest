package user.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import sun.net.www.content.text.plain;
import user.bean.Person;
import user.except.PersonExistException;
import user.interfac.IPersonInterface;

/***
 * ����xml�ļ�
 * 
 * @author yjbo
 * @time 2017��12��14��13:45:14
 */
public class XMLParseUtil implements IPersonInterface {
	// ֪ʶ��һ��2�߱Ƚ�
	String fileStr = "persons.xml";
	DocumentBuilder builder = null;
	Document document = null;
	Element element = null;
	Person person = null;
	List<Person> pList = new ArrayList<Person>();

	// ���ҳ����е��û�
	/**
	 * {����������������}
	 * 
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * @author: xulink@yonyou.com
	 */

	@Override
	public List<Person> findAllPersons() throws ParserConfigurationException, SAXException, IOException {

		initDocument();
		// ����1���ҳ�����person��ǩ������NodeList
		NodeList nodeList0 = document.getElementsByTagName("person");
		// �Է������������нڵ���б���
		for (int i = 0; i < nodeList0.getLength(); i++) {
			person = new Person();
			// ���һ��Ԫ��
			element = (Element) nodeList0.item(i);
			// ������Ԫ�ص�personid����
			// ��Ԫ�����ӽڵ㣬��ȡ�����ӽڵ㣬����һ��personList
			NodeList nodeList = element.getChildNodes();
			person.setPersonid(Integer.valueOf(element.getAttribute("personid")));// ��߾��Ǻ������нڵ㣬ȡ�����Ǻܺ�ȡ��
			// ���������ӽڵ�
			for (int j = 0; j < nodeList.getLength(); j++) {// nodeList����[#text:
															// ]��Ԫ����ɵ�
				// ���ӽڵ�����Ʋ�Ϊ#text���������#textΪ������ǩ
				if (!nodeList.item(j).getNodeName().equals("#text")) {
					// �ڵ����ơ��ڵ�ֵ
					String nodeName = nodeList.item(j).getNodeName();
					String textContent = nodeList.item(j).getTextContent();
					if ("name".equals(nodeName)) {
						person.setName(textContent);
					} else if ("tel".equals(nodeName)) {
						person.setPersonid(Integer.valueOf(textContent));
					} else if ("email".equals(nodeName)) {
						person.setEmail(textContent);
					}
				}
			}
			System.out.println(person.toString());
			pList.add(person);
		}
		return pList;
	}

	// �ж��û��Ƿ����
	/**
	 * {����������������}
	 * 
	 * @param editName
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * @author: xulink@yonyou.com
	 */

	@Override
	public boolean isExist(String editName) throws ParserConfigurationException, SAXException, IOException {
		if (editName == null || "".equals(editName) || "".equals(editName.trim())) {
			new PersonExistException("�������˺ţ�����");
			return false;
		}

		initDocument();
		// ����1���ҳ�����name��ǩ������NodeList
		NodeList nameList = document.getElementsByTagName("name");
		// �Է������������нڵ���б���
		for (int i = 0; i < nameList.getLength(); i++) {
			// ���һ��Ԫ��
			String textContent = nameList.item(i).getTextContent();
			if (editName.equals(textContent)) {
				new PersonExistException("���˺��Ѵ��ڣ���������д������");
				return true;
			}
		}
		new PersonExistException("���˺Ų����ڣ�����ע���С�����");
		return false;
	}

	// ����û�
	/**
	 * {����������������}
	 * 
	 * @param newPerson
	 * @throws Exception
	 * @author: xulink@yonyou.com
	 */

	@Override
	public void addPerson(Person newPerson) throws Exception {
		String editName = newPerson.getName();
		if (editName == null || "".equals(editName) || "".equals(editName.trim())) {
			new PersonExistException("�������˺ţ�����");
			return;
		}
		if (isExist(editName)) {
			return;
		}
		initDocument();
		// 4.׷�ӽڵ�
		Element personEle = document.createElement("person");
		personEle.setAttribute("personid", newPerson.getPersonid() + "");
		Element name = document.createElement("name");
		name.setTextContent(newPerson.getName() + "");
		Element tel = document.createElement("tel");
		tel.setTextContent(newPerson.getTel() + "");
		Element email = document.createElement("email");
		email.setTextContent(newPerson.getEmail());

		personEle.appendChild(name);
		personEle.appendChild(tel);
		personEle.appendChild(email);

		document.getElementsByTagName("persons").item(0).appendChild(personEle);

		saveShowInfo();

		System.out.println("haole");

	}

	// ����б��û�
	/**
	 * {����������������}
	 * 
	 * @param pList
	 * @throws Exception
	 * @author: xulink@yonyou.com
	 */

	@Override
	public void addMore(List<Person> pList) throws Exception {
		for (Person person : pList) {
			addPerson(person);
		}
	}

	// ɾ��ĳ�û�
	/**
	 * {����������������}
	 * 
	 * @param editName
	 * @return
	 * @throws Exception
	 * @author: xulink@yonyou.com
	 */

	@Override
	public boolean deletePerson(String editName) throws Exception {
		if (editName == null || "".equals(editName) || "".equals(editName.trim())) {
			new PersonExistException("�������˺ţ�����");
			return false;
		}
		if (!isExist(editName)) {
			return false;
		}
		initDocument();
		NodeList nodeList = document.getElementsByTagName("name");
		// �����ȡ����id����ôֻҪɾ��getParentNode���ɣ��˴�ɾ����getParentNode��getParentNode��
		for (int i = 0; i < nodeList.getLength(); i++) {
			Element item = (Element) nodeList.item(i);
			if (editName.equals(nodeList.item(i).getTextContent())) {
				nodeList.item(i).getParentNode().getParentNode().removeChild(item.getParentNode());
				saveShowInfo();
				new PersonExistException("���û��Ѿ�ɾ��");
				return true;
			}
		}
		return false;
	}

	// ɾ������û�
	/**
	 * {����������������}
	 * 
	 * @param pList
	 * @throws Exception
	 * @author: xulink@yonyou.com
	 */

	@Override
	public void deleteMore(List<Person> pList) throws Exception {
		for (int i = 0; i < pList.size(); i++) {
			deletePerson(pList.get(i).getName());
		}
	}

	// �޸�ĳ���û�
	/**
	 * {����������������}
	 * 
	 * @param person
	 * @return
	 * @throws Exception
	 * @author: xulink@yonyou.com
	 */

	@Override
	public boolean updatePerson(Person person) throws Exception {
		String editPId = person.getPersonid() + "";
		if (editPId == null || "".equals(editPId) || "".equals(editPId.trim())) {
			new PersonExistException("�����˺������⣡����");
			return false;
		}
		initDocument();
		NodeList nodeList = document.getElementsByTagName("person");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			Element element = (Element) node;
			String personid = element.getAttribute("personid");
			if (editPId.equals(personid)) {
				NodeList childNodes = element.getChildNodes();
				for (int j = 0; j < childNodes.getLength(); j++) {
					Node item = childNodes.item(j);
					String nodeName = item.getNodeName();
					if ("name".equals(nodeName)) {
						item.setTextContent(person.getName());
					} else if ("tel".equals(nodeName)) {
						item.setTextContent(person.getTel() + "");
					} else if ("email".equals(nodeName)) {
						item.setTextContent(person.getEmail());
					}
				}
				saveShowInfo();
				return true;
			}
		}

		return false;
	}

	// ��ʼ��document
	private void initDocument() throws ParserConfigurationException, SAXException, IOException {
		fileStr = "persons.xml";//ÿ�ζ����¸�ֵ
		 URL url = getClass().getClassLoader().getResource(fileStr);  
		 fileStr = url.getPath();
		 System.out.println("��ǰ·��"+fileStr);
		// ָ��File�ļ�
		File file = new File(fileStr);
		// ����DocumentBuilderFactory����
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// ����DocumentBuilder����
		builder = dbf.newDocumentBuilder();
		// ��DocumentBuilder�����parse���������ļ�����Document����
		document = builder.parse(file);
	}

	// �����ļ��ķ���
	private void saveShowInfo() throws TransformerException {
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		Source xmlSource = new DOMSource(document);
		Result outputTarget = new StreamResult(fileStr);
		transformer.transform(xmlSource, outputTarget);

	}
}