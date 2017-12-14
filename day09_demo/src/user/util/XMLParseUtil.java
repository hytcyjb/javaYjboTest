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
 * 解析xml文件
 * 
 * @author yjbo
 * @time 2017年12月14日13:45:14
 */
public class XMLParseUtil implements IPersonInterface {
	// 知识点一：2者比较
	String fileStr = "persons.xml";
	DocumentBuilder builder = null;
	Document document = null;
	Element element = null;
	Person person = null;
	List<Person> pList = new ArrayList<Person>();

	// 查找出所有的用户
	/**
	 * {方法功能中文描述}
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
		// 测试1：找出所有person标签，返回NodeList
		NodeList nodeList0 = document.getElementsByTagName("person");
		// 对符合条件的所有节点进行遍历
		for (int i = 0; i < nodeList0.getLength(); i++) {
			person = new Person();
			// 获得一个元素
			element = (Element) nodeList0.item(i);
			// 输出这个元素的personid属性
			// 此元素有子节点，获取所有子节点，返回一个personList
			NodeList nodeList = element.getChildNodes();
			person.setPersonid(Integer.valueOf(element.getAttribute("personid")));// 这边就是和它并列节点，取数还是很好取的
			// 遍历所有子节点
			for (int j = 0; j < nodeList.getLength(); j++) {// nodeList是以[#text:
															// ]等元素组成的
				// 若子节点的名称不为#text，则输出，#text为反／标签
				if (!nodeList.item(j).getNodeName().equals("#text")) {
					// 节点名称、节点值
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

	// 判断用户是否存在
	/**
	 * {方法功能中文描述}
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
			new PersonExistException("请输入账号！！！");
			return false;
		}

		initDocument();
		// 测试1：找出所有name标签，返回NodeList
		NodeList nameList = document.getElementsByTagName("name");
		// 对符合条件的所有节点进行遍历
		for (int i = 0; i < nameList.getLength(); i++) {
			// 获得一个元素
			String textContent = nameList.item(i).getTextContent();
			if (editName.equals(textContent)) {
				new PersonExistException("该账号已存在，请重新填写！！！");
				return true;
			}
		}
		new PersonExistException("该账号不存在，正在注册中。。。");
		return false;
	}

	// 添加用户
	/**
	 * {方法功能中文描述}
	 * 
	 * @param newPerson
	 * @throws Exception
	 * @author: xulink@yonyou.com
	 */

	@Override
	public void addPerson(Person newPerson) throws Exception {
		String editName = newPerson.getName();
		if (editName == null || "".equals(editName) || "".equals(editName.trim())) {
			new PersonExistException("请输入账号！！！");
			return;
		}
		if (isExist(editName)) {
			return;
		}
		initDocument();
		// 4.追加节点
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

	// 添加列表用户
	/**
	 * {方法功能中文描述}
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

	// 删除某用户
	/**
	 * {方法功能中文描述}
	 * 
	 * @param editName
	 * @return
	 * @throws Exception
	 * @author: xulink@yonyou.com
	 */

	@Override
	public boolean deletePerson(String editName) throws Exception {
		if (editName == null || "".equals(editName) || "".equals(editName.trim())) {
			new PersonExistException("请输入账号！！！");
			return false;
		}
		if (!isExist(editName)) {
			return false;
		}
		initDocument();
		NodeList nodeList = document.getElementsByTagName("name");
		// 如果获取的是id，那么只要删除getParentNode即可，此处删除了getParentNode的getParentNode；
		for (int i = 0; i < nodeList.getLength(); i++) {
			Element item = (Element) nodeList.item(i);
			if (editName.equals(nodeList.item(i).getTextContent())) {
				nodeList.item(i).getParentNode().getParentNode().removeChild(item.getParentNode());
				saveShowInfo();
				new PersonExistException("该用户已经删除");
				return true;
			}
		}
		return false;
	}

	// 删除多个用户
	/**
	 * {方法功能中文描述}
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

	// 修改某个用户
	/**
	 * {方法功能中文描述}
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
			new PersonExistException("您的账号有问题！！！");
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

	// 初始化document
	private void initDocument() throws ParserConfigurationException, SAXException, IOException {
		fileStr = "persons.xml";//每次都重新赋值
		 URL url = getClass().getClassLoader().getResource(fileStr);  
		 fileStr = url.getPath();
		 System.out.println("当前路径"+fileStr);
		// 指定File文件
		File file = new File(fileStr);
		// 建立DocumentBuilderFactory对象
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// 建立DocumentBuilder对象
		builder = dbf.newDocumentBuilder();
		// 用DocumentBuilder对象的parse方法引入文件建立Document对象
		document = builder.parse(file);
	}

	// 保存文件的方法
	private void saveShowInfo() throws TransformerException {
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		Source xmlSource = new DOMSource(document);
		Result outputTarget = new StreamResult(fileStr);
		transformer.transform(xmlSource, outputTarget);

	}
}