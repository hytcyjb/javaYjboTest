package user.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import user.bean.Person;
import user.except.PersonExistException;

/***
 * 解析xml文件
 * ***在该数据库中personid和name都是唯一标识，暂不做太深入地修改。以现在的技术越改越乱。
 * @author yjbo
 * @time 2017年12月14日13:45:14
 */
public class XMLParseUtil {
	// 知识点一：2者比较
	String fileStr = "persons.xml";
	DocumentBuilder builder = null;
	Document document = null;
	Element element = null;
	Person person = null;
	List<Person> pList = new ArrayList<Person>();

	// 判断该用户名是否存在---主要是登录时验证用户名是否正确
	public boolean isExist(String editName)
			throws ParserConfigurationException, SAXException, IOException {
		if (editName == null || "".equals(editName)
				|| "".equals(editName.trim())) {
			new PersonExistException("请输入用户名！！！");
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
				new PersonExistException("该用户名已存在，请重新填写！！！");
				return true;
			}
		}
		new PersonExistException("该用户的用户名不存在，正在注册中。。。");
		return false;
	}

	// 判断用户的id是否存在---主要是注册，以及获取时的唯一标识
	public boolean isExistId(int personid) throws ParserConfigurationException,
			SAXException, IOException {
		if (personid == 0) {
			new PersonExistException("该用户id为空！！！");
			return false;
		}
		initDocument();
		// 测试1：找出所有name标签，返回NodeList
		NodeList pList = document.getElementsByTagName("person");
		// 对符合条件的所有节点进行遍历
		for (int i = 0; i < pList.getLength(); i++) {
			// 获得一个元素
			String personidStr = ((Element) pList.item(i))
					.getAttribute("personid");
			if ((personid + "").equals(personidStr)) {
				new PersonExistException("该id已存在，请重新生成！！！");
				return true;
			}
		}
		new PersonExistException("该用户的id不存在!!!");
		return false;
	}

	// 【查】查找出所有的用户
	public List<Person> findAllPersons() throws ParserConfigurationException,
			SAXException, IOException {
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
						person.setTel(Integer.valueOf(textContent));
					} else if ("email".equals(nodeName)) {
						person.setEmail(textContent);
					}
				}
			}
			pList.add(person);
		}
		return pList;
	}

	// 【增】添加用户
	public String addPerson(Person newPerson) throws Exception {
		String editName = newPerson.getName();
		int personid = newPerson.getPersonid();

		if (isExist(editName) || isExistId(personid)) {// 此处应该判断id和name，2个同时判断
			return "该用户名已经被注册，请重新设置！！！";
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
		return "ok";
	}

	// 【增】 添加列表用户
	public void addMore(List<Person> pList) throws Exception {
		for (Person person : pList) {
			addPerson(person);
		}
	}

	// 【删】删除某用户
	public boolean deletePerson(String editName) throws Exception {
		if (editName == null || "".equals(editName)
				|| "".equals(editName.trim())) {
			new PersonExistException("请输入用户名！！！");
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
				nodeList.item(i).getParentNode().getParentNode()
						.removeChild(item.getParentNode());
				saveShowInfo();
				new PersonExistException("该用户已经删除");
				return true;
			}
		}
		return false;
	}

	// 【删】 删除多个用户
	public void deleteMore(List<Person> pList) throws Exception {
		for (int i = 0; i < pList.size(); i++) {
			deletePerson(pList.get(i).getName());
		}
	}

	// 【改】 修改某个用户---根据id进行修改（同时用户名不能与已有用户名重复--这个暂时不限制，需要用不同页面才能判断，比较复杂）
	public boolean updatePerson(Person person) throws Exception {
		int editPId = person.getPersonid();
		String editPName = person.getName();
		if (!isExistId(editPId)) {
			new PersonExistException("该用户id有问题，不能修改！！！");
		}
		if (editPName == null || "".equals(editPName)
				|| "".equals(editPName.trim())) {
			new PersonExistException("请输入用户的用户名！！！");
			return false;
		}
		initDocument();
		NodeList nodeList = document.getElementsByTagName("person");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			Element element = (Element) node;
			String personid = element.getAttribute("personid");
			if ((editPId + "").equals(personid)) {
				NodeList childNodes = element.getChildNodes();
				for (int j = 0; j < childNodes.getLength(); j++) {
					Node item = childNodes.item(j);
					String nodeName = item.getNodeName();
					if ("name".equals(nodeName)) {
						if (!isNull(person.getName())) {
							item.setTextContent(person.getName());
						}
					} else if ("tel".equals(nodeName)) {
						if (person.getTel() != 0) {
							item.setTextContent(person.getTel() + "");
						}
					} else if ("email".equals(nodeName)) {
						if (!isNull(person.getEmail())) {
							item.setTextContent(person.getEmail());
						}
					}
				}
				saveShowInfo();
				return true;
			}
		}

		return false;
	}

	// 初始化document
	private void initDocument() throws ParserConfigurationException,
			SAXException, IOException {
		fileStr = "persons.xml";// 每次都重新赋值
		URL url = getClass().getClassLoader().getResource(fileStr);
		fileStr = url.getPath();
		System.out.println("当前路径" + fileStr);
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

	// 判断字符是否为空
	private boolean isNull(String str) {
		if (str == null || "".equals(str) || "".equals(str.trim())
				|| "null".equals(str.trim())) {
			return true;
		}
		return false;
	}
}
