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
 * @describe ��¼��֤
 * @author yjbo
 * @date 2017��12��14�� ����8:46:29
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name =  request.getParameter("name")+"";
		request.getSession().setAttribute("login_tip", "��ϲ"+name+"��¼�ɹ�");
		try {
			XMLParseUtil xmlParseUtil = new XMLParseUtil();
			if(xmlParseUtil.isExist(name)){//��¼�ɹ����Բ鿴�����˵��б�
				request.setAttribute("tip", "(����Ϊ����˾�µ�������Ա)");
				List<Person> pList = xmlParseUtil.findAllPersons();
				request.setAttribute("pList", pList);
				this.getServletContext().getRequestDispatcher("/loginsuccess.jsp").forward(request, response);
			}else{
				request.setAttribute("tip", "��¼ʧ��---û��"+name+"�û�������");
				
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
