package yy.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yy.bean.Customer;
import yy.util.JDBCUtil;

/**
 * @describe ɾ��ĳһ�û�
 * @author yjbo
 * @date 2018��1��14��18:05:47
 */
@WebServlet("/DeleteCustomerServlet")
public class DeleteCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id = Integer.valueOf(request.getParameter("id") + "");
			JDBCUtil jdbcUtil = new JDBCUtil();
			boolean isDeleteFlag = jdbcUtil.deleteCustomer(id);
			if (!isDeleteFlag) {
				request.getSession().setAttribute("tip", "���û���Ϣ��ȡ������");
				response.sendRedirect(request.getContextPath()+"/message.jsp");
			} else {
				ArrayList<Customer> allCustomers = jdbcUtil.findAllCustomers();
				if (allCustomers == null || allCustomers.size() ==0) {
					request.getSession().setAttribute("tip", "��ʱû���û��������");
					response.sendRedirect(request.getContextPath()+"/message.jsp");
				}else{
					request.getSession().setAttribute("allCustomer", allCustomers);
					response.sendRedirect(request.getContextPath()+"/readCustomer.jsp");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			request.getSession().setAttribute("tip", "ɾ������");
			response.sendRedirect(request.getContextPath()+"/message.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
