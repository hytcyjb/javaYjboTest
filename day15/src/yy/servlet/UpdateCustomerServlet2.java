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
 * @describe 修改某一用户的提交数据
 * @author yjbo
 * @date 2018年1月14日22:41:31
 */
@WebServlet("/UpdateCustomerServlet2")
public class UpdateCustomerServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id = Integer.valueOf(request.getParameter("id") + "");
			String name = request.getParameter("name");
			String sex = request.getParameter("sex");
			String year = request.getParameter("year");
			String month = request.getParameter("month");
			String day = request.getParameter("day");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String hobbyStr = request.getParameter("hobby");
			String kind = request.getParameter("kind");
			String remarks = request.getParameter("remarks");
			Customer customer = new Customer(id,name, sex, year+"-"+month+"-"+day, phone, email,hobbyStr, kind,remarks);
			JDBCUtil jdbcUtil = new JDBCUtil();
			boolean updateCustomer = jdbcUtil.updateCustomer(customer);
			if (updateCustomer) {
				ArrayList<Customer> allCustomers = jdbcUtil.findAllCustomers();
				request.getSession().setAttribute("allCustomer", allCustomers);
				response.sendRedirect(request.getContextPath()+"/ReadCustomerServlet");
			} else {
				request.getSession().setAttribute("tip", "该用户信息有误");
				response.sendRedirect(request.getContextPath()+"/message.jsp");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			request.getSession().setAttribute("tip", "该用户信息有误");
			response.sendRedirect(request.getContextPath()+"/message.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
