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
 * @describe �鿴�����û�
 * @author yjbo
 * @date 2018��1��14�� ����4:29:19
 */
@WebServlet("/ReadCustomerServlet")
public class ReadCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JDBCUtil jdbcUtil = new JDBCUtil();
		ArrayList<Customer> allCustomers = jdbcUtil.findAllCustomers();
		if (allCustomers == null || allCustomers.size() ==0) {
			request.getSession().setAttribute("tip", "��ʱû���û��������");
			response.sendRedirect(request.getContextPath()+"/message.jsp");
		}else{
			request.getSession().setAttribute("allCustomer", allCustomers);
			response.sendRedirect(request.getContextPath()+"/readCustomer.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
