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
	private int pageNum = 10;//每页几条数据
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageNo = 1;
		try {
			pageNo = Integer.valueOf(request.getParameter("pageNo"));// 当前请求的页码
		} catch (Exception ex) {
			ex.printStackTrace();
			try {
			pageNo = Integer.valueOf(request.getSession().getAttribute("pageNo")+"");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		JDBCUtil jdbcUtil = new JDBCUtil();
		int totalNum = jdbcUtil.findAllNum();
		ArrayList<Customer> allCustomers = jdbcUtil.findCustomersWithPage(pageNum * pageNo-pageNum, pageNum);
		if (allCustomers == null || allCustomers.size() == 0) {
			request.getSession().setAttribute("tip", "暂时没有用户，请添加");
			response.sendRedirect(request.getContextPath() + "/message.jsp");
		} else {
			request.getSession().setAttribute("allCustomer", allCustomers);
			request.getSession().setAttribute("totalNum", totalNum);//数据库中一共有多少条数据
			request.getSession().setAttribute("pageNo", pageNo);//第几页
			request.getSession().setAttribute("pageNum", pageNum);//一页几个数据
			request.getSession().setAttribute("totalPage", (int) Math.ceil((double)totalNum / (double)pageNum));//一共有多少页
			request.getRequestDispatcher("/readCustomer.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
