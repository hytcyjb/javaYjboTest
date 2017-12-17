package good.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import good.bean.Good;
import good.service.GoodService;

/**
 * @describe ��Ʒ�б�
 * @author yjbo
 * @date 2017��12��16�� ����11:39:35
 */
//���ʵ�ַ http://localhost:8080/day10_demo/GoodsListServlet
@WebServlet("/GoodsListServlet")
public class GoodsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		GoodService goodService = new GoodService();
		Map allGoods = goodService.getAllGoods();
		request.setAttribute("goodsMap", allGoods);// ���е���Ʒ�б�
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
