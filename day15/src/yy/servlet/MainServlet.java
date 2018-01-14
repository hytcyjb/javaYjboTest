package yy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yy.bean.Customer;
import yy.util.JDBCUtil;

/**
 * @describe 主页面
 * @author yjbo
 * @date 2018年1月9日 下午9:44:00
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
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
		JDBCUtil jdbcUtil = new JDBCUtil();
		boolean insertCustomer = jdbcUtil.insertCustomer(new Customer(name, sex, year+"-"+month+"-"+day, phone, email,hobbyStr, kind,remarks));
		if(insertCustomer){
			request.getSession().setAttribute("tip", "添加客户成功");
		}else{
			request.getSession().setAttribute("tip", "添加客户失败");
		}
		response.sendRedirect(request.getContextPath()+"/message.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
