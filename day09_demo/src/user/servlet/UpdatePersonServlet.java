package user.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.bean.Person;
import user.util.PersonUtil;
import user.util.XMLParseUtil;

/**
 * @describe �޸��û�����Ϣ
 * @author yjbo
 * @date 2017��12��15�� 21:50
 */
@WebServlet("/UpdatePersonServlet")
public class UpdatePersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int personid = Integer.valueOf(request.getParameter("personid"));
		String name = request.getParameter("name");
		int tel = Integer.valueOf(request.getParameter("tel"));
		String email = request.getParameter("email");

		XMLParseUtil xmlParseUtil = new XMLParseUtil();
		try {
			boolean isSuccessed = xmlParseUtil.updatePerson(new Person(personid, name, tel, email));
			if (isSuccessed) {
				request.setAttribute("tip", "�޸�" + name + "��Ϣ�������ɹ�");
				List<Person> pList = xmlParseUtil.findAllPersons();
				request.setAttribute("pList", pList);
				this.getServletContext().getRequestDispatcher("/loginsuccess.jsp").forward(request, response);
			} else {// �޸�ʧ��
				request.setAttribute("tip", "�޸�" + name + "��Ϣ������ʧ��");
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
