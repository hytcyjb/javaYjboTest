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
 * @describe 已买商品列表---相当于add添加
 * @author yjbo
 * @date 2017年12月17日 00:58
 */
@WebServlet("/BuyGoodsServlet")
public class BuyGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Object goodId = request.getParameter("goodId");
		GoodService goodService = new GoodService();
		Map allGoods = goodService.getAllGoods();
		Good good = (Good) allGoods.get(goodId);

		// 已选列表
		HashMap buyMap = new HashMap<>();
		buyMap.put(goodId, good);

		// 已选缓存
		HashMap buySessionMap = new HashMap<>();
		buySessionMap = (HashMap) request.getSession().getAttribute("goodsChoosedMap");
		int num = 1;
		if (buySessionMap == null) {
			buySessionMap = buyMap;
		} else {
			Good good1 = (Good) buySessionMap.get(goodId);
			if (good1 != null) {
				good1.setGoodAllowance(good1.getGoodAllowance() + 1);
				num = good1.getGoodAllowance() + 1;
			} else {
				buySessionMap.put(goodId, good);
			}
		}
		double AddMonDouble = good.getGoodPrice() * num;
		Object totalMonObj = request.getSession().getAttribute("totalMoney");
		double totalMonDouble = 0.0;
		if(totalMonObj != null){
			totalMonDouble = Double.valueOf(totalMonObj+"");
		}
		double resultMoneyDouble = goodService.updateMoney(1,totalMonDouble,num,Integer.valueOf(goodId+""));//此时不取num，默认为1；
		request.getSession().setAttribute("totalMoney", resultMoneyDouble);
		
		request.getSession().setAttribute("goodsChoosedMap", buySessionMap);// 已选的商品列表
		request.getRequestDispatcher("/bugGoods.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
