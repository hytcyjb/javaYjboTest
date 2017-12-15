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
 * @describe 注册功能
 * @author yjbo
 * @date 2017年12月16日 00:00
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 新注册的用户没有id。注册完才会分配id的
		/* int personid = Integer.valueOf(request.getParameter("personid")); */
		String name = request.getParameter("name");
		int tel = Integer.valueOf(request.getParameter("tel"));
		String email = request.getParameter("email");
		PersonUtil personUtil = new PersonUtil();
		XMLParseUtil xmlParseUtil = new XMLParseUtil();
		try {
			String reasonStr = personUtil.registerPerson(new Person(0, name, tel, email));
			if ("ok".equals(reasonStr)) {// 注册成功
				request.setAttribute("tip", name + "用户，注册成功，欢迎使用");
				request.getSession().setAttribute("login_tip", "恭喜"+name+"登录成功");
				List<Person> pList = xmlParseUtil.findAllPersons();
				request.setAttribute("pList", pList);
				this.getServletContext().getRequestDispatcher("/loginsuccess.jsp").forward(request, response);
			} else {// 注册失败
				request.setAttribute("registerError", "用户名已存在！");
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
