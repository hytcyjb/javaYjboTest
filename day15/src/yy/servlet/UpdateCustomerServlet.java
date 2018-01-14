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
 * @describe 修改某一用户
 * @author yjbo
 * @date 2018年1月14日19:01:39
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
