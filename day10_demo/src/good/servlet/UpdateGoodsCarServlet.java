package good.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import good.bean.Good;
import good.service.GoodService;

/**
 * @describe 更新购物车已买东西列表
 * @author yjbo
 * @date 2017年12月17日 11:15
 */
@WebServlet("/UpdateGoodsCarServlet")
public class UpdateGoodsCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Object goodId = request.getParameter("goodId");
		Object chooseNum = request.getParameter("chooseNum");
		Object oldChooseNum = request.getParameter("oldChooseNum");
		GoodService goodService = new GoodService();
		Map allGoods = goodService.getAllGoods();
		Good good = (Good) allGoods.get(goodId);

		// 已选列表
		HashMap buyMap = new HashMap<>();
		buyMap.put(goodId, good);

		// 已选缓存
		HashMap buySessionMap = new HashMap<>();
		buySessionMap = (HashMap) request.getSession().getAttribute("goodsChoosedMap");
		if (buySessionMap == null) {
			buySessionMap = buyMap;
		} else {
			Good good1 = (Good) buySessionMap.get(goodId);
			if (good1 != null) {
				good1.setGoodAllowance(Integer.valueOf(chooseNum+""));
				
				Object totalMonObj = request.getSession().getAttribute("totalMoney");
				double totalMonDouble = 0.0;
				if(totalMonObj != null){//判断非空
					totalMonDouble = Double.valueOf(totalMonObj+"");
				}
				double resultMoneyDouble = goodService.updateMoney(0,Double.valueOf(totalMonDouble),(Integer.valueOf(chooseNum+"")-Integer.valueOf(oldChooseNum+"")),Integer.valueOf(goodId+""));
				request.getSession().setAttribute("totalMoney", resultMoneyDouble);
			} else {
				buySessionMap.put(goodId, good);
			}
		}

		request.getSession().setAttribute("goodsChoosedMap", buySessionMap);// 已选的商品列表
		request.getRequestDispatcher("/bugGoods.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
