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
import user.util.PersonUtil;
import user.util.XMLParseUtil;

/**
 * @describe ע�Ṧ��
 * @author yjbo
 * @date 2017��12��16�� 00:00
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ע����û�û��id��ע����Ż����id��
		/* int personid = Integer.valueOf(request.getParameter("personid")); */
		String name = request.getParameter("name");
		int tel = Integer.valueOf(request.getParameter("tel"));
		String email = request.getParameter("email");
		PersonUtil personUtil = new PersonUtil();
		XMLParseUtil xmlParseUtil = new XMLParseUtil();
		try {
			String reasonStr = personUtil.registerPerson(new Person(0, name, tel, email));
			if ("ok".equals(reasonStr)) {// ע��ɹ�
				request.setAttribute("tip", name + "�û���ע��ɹ�����ӭʹ��");
				request.getSession().setAttribute("login_tip", "��ϲ"+name+"��¼�ɹ�");
				List<Person> pList = xmlParseUtil.findAllPersons();
				request.setAttribute("pList", pList);
				this.getServletContext().getRequestDispatcher("/loginsuccess.jsp").forward(request, response);
			} else {// ע��ʧ��
				request.setAttribute("registerError", "�û����Ѵ��ڣ�");
				this.getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
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
