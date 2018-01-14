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
 * @describe 删除某一用户
 * @author yjbo
 * @date 2018年1月14日18:05:47
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
				request.getSession().setAttribute("tip", "该用户信息获取有问题");
				response.sendRedirect(request.getContextPath()+"/message.jsp");
			} else {
				ArrayList<Customer> allCustomers = jdbcUtil.findAllCustomers();
				if (allCustomers == null || allCustomers.size() ==0) {
					request.getSession().setAttribute("tip", "暂时没有用户，请添加");
					response.sendRedirect(request.getContextPath()+"/message.jsp");
				}else{
					request.getSession().setAttribute("allCustomer", allCustomers);
					response.sendRedirect(request.getContextPath()+"/readCustomer.jsp");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			request.getSession().setAttribute("tip", "删除报错");
			response.sendRedirect(request.getContextPath()+"/message.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
