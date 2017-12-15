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
 * @describe ����û��Ĳ���
 * @author yjbo
 * @date 2017��12��15�� 21:18
 */
@WebServlet("/AddPersonServlet")
public class AddPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int addNum = Integer.valueOf(request.getParameter("addnum"));
		System.out.println("==���==" + addNum);
		PersonUtil personUtil = new PersonUtil();
		try {
			personUtil.addPerson(addNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		XMLParseUtil xmlParseUtil = new XMLParseUtil();
		request.setAttribute("tip", "���"+addNum+"����Ա�������ɹ�");
		try {
			List<Person> pList = xmlParseUtil.findAllPersons();
			request.setAttribute("pList", pList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/loginsuccess.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
