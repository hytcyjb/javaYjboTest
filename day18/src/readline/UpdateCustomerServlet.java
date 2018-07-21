package readline;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @describe �޸�ĳһ�û�
 * @author yjbo
 * @date 2018��1��14��19:01:39
 */
@WebServlet("/UpdateCustomerServlet")
public class UpdateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id = Integer.valueOf(request.getParameter("id") + "");
			request.getSession().setAttribute("tip", "���û���Ϣ����");
			response.sendRedirect(request.getContextPath() + "/message.jsp");
		} catch (Exception ex) {
			ex.printStackTrace();
			request.getSession().setAttribute("tip", "���û���Ϣ����");
			response.sendRedirect(request.getContextPath() + "/message.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}