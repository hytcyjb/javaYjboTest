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
 * @describe 查看所有用户
 * @author yjbo
 * @date 2018年1月14日 下午4:29:19
 */
@WebServlet("/ReadCustomerServlet")
public class ReadCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JDBCUtil jdbcUtil = new JDBCUtil();
		ArrayList<Customer> allCustomers = jdbcUtil.findAllCustomers();
		if (allCustomers == null || allCustomers.size() ==0) {
			request.getSession().setAttribute("tip", "暂时没有用户，请添加");
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
