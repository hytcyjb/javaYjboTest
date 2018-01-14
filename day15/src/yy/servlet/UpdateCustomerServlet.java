package yy.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yy.bean.Customer;
import yy.bean.Hobby;
import yy.bean.HobbyList;
import yy.util.JDBCUtil;

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
			JDBCUtil jdbcUtil = new JDBCUtil();
			Customer customer = jdbcUtil.findCustomerId(id);
			if (customer != null) {
				ArrayList<Hobby> list = new HobbyList().getList();
				request.getSession().setAttribute("hobbylist", list);
				request.getSession().setAttribute("customer", customer);
				response.sendRedirect(request.getContextPath()+"/updateCustomer.jsp");
			} else {
				request.getSession().setAttribute("tip", "���û���Ϣ����");
				response.sendRedirect(request.getContextPath()+"/message.jsp");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			request.getSession().setAttribute("tip", "���û���Ϣ����");
			response.sendRedirect(request.getContextPath()+"/message.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
