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
	private int pageNum = 10;//ÿҳ��������
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageNo = 1;
		try {
			pageNo = Integer.valueOf(request.getParameter("pageNo"));// ��ǰ�����ҳ��
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
			request.getSession().setAttribute("tip", "��ʱû���û��������");
			response.sendRedirect(request.getContextPath() + "/message.jsp");
		} else {
			request.getSession().setAttribute("allCustomer", allCustomers);
			request.getSession().setAttribute("totalNum", totalNum);//���ݿ���һ���ж���������
			request.getSession().setAttribute("pageNo", pageNo);//�ڼ�ҳ
			request.getSession().setAttribute("pageNum", pageNum);//һҳ��������
			request.getSession().setAttribute("totalPage", (int) Math.ceil((double)totalNum / (double)pageNum));//һ���ж���ҳ
			request.getRequestDispatcher("/readCustomer.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
