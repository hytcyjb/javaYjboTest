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
 * @describe 登录验证
 * @author yjbo
 * @date 2017年12月14日 下午8:46:29
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name =  request.getParameter("name")+"";
		request.getSession().setAttribute("login_tip", "恭喜"+name+"登录成功");
		try {
			XMLParseUtil xmlParseUtil = new XMLParseUtil();
			if(xmlParseUtil.isExist(name)){//登录成功可以查看所有人的列表
				request.setAttribute("tip", "(下面为您公司下的所有人员)");
				List<Person> pList = xmlParseUtil.findAllPersons();
				request.setAttribute("pList", pList);
				this.getServletContext().getRequestDispatcher("/loginsuccess.jsp").forward(request, response);
			}else{
				request.setAttribute("tip", "登录失败---没有"+name+"用户！！！");
				
				this.getServletContext().getRequestDispatcher("/loginerror.jsp").forward(request, response);
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
