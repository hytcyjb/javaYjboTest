package user.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import user.bean.Person;
import user.util.XMLParseUtil;

/**
 * @describe ɾ���û��Ĳ���
 * @author yjbo
 * @date 2017��12��14�� ����8:46:29
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Person person =  new Person(Integer.valueOf(request.getParameter("personid")),request.getParameter("name"),
//				Integer.valueOf(request.getParameter("tel")),request.getParameter("email"));
		String nameStr = request.getParameter("name");
		System.out.println("==="+nameStr);
		try {
			XMLParseUtil xmlParseUtil = new XMLParseUtil();
			if(xmlParseUtil.isExist(nameStr)){//��¼�ɹ����Բ鿴�����˵��б�
				xmlParseUtil.deletePerson(nameStr);
				request.setAttribute("tip", "ɾ���ɹ���ˢ�³ɹ�");
				List<Person> pList = xmlParseUtil.findAllPersons();
				request.setAttribute("pList", pList);
				this.getServletContext().getRequestDispatcher("/loginsuccess.jsp").forward(request, response);
			}else{
				request.setAttribute("tip", "ɾ��ʧ�ܣ�ˢ�³ɹ�");
				List<Person> pList = xmlParseUtil.findAllPersons();
				request.setAttribute("pList", pList);
				this.getServletContext().getRequestDispatcher("/loginsuccess.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
