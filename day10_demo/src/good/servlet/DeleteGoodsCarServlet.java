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
 * @describe 删除某个商品购物车已买东西列表
 * @author yjbo
 * @date 2017年12月17日 11:15
 */
@WebServlet("/DeleteGoodsCarServlet")
public class DeleteGoodsCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object goodId = request.getParameter("goodId");
		String deleteFlag = request.getParameter("deleteFlag")+"";
		GoodService goodService = new GoodService();
		Map allGoods = goodService.getAllGoods();
		HashMap buySessionMap = new HashMap<>();// 已选缓存
		if("true".equals(deleteFlag)){//清空购物车
			request.getSession().setAttribute("goodsChoosedMap", buySessionMap);// 已选的商品列表
			request.getSession().setAttribute("totalMoney", 0.0);
		}else{//删除某个商品
			Good good = (Good) allGoods.get(goodId);
			// 已选缓存
			buySessionMap = (HashMap) request.getSession().getAttribute("goodsChoosedMap");
			if (buySessionMap == null) {
			} else {
				Good good1 = (Good) buySessionMap.get(goodId);
				if (good1 != null) {
					buySessionMap.remove(goodId);
					Object totalMonObj = request.getSession().getAttribute("totalMoney");
					double totalMonDouble = 0.0;
					if(totalMonObj != null){//判断非空
						totalMonDouble = Double.valueOf(totalMonObj+"");
					}
					double resultMoneyDouble = goodService.updateMoney(-1,Double.valueOf(totalMonDouble),good1.getGoodAllowance(),Integer.valueOf(goodId+""));
					request.getSession().setAttribute("totalMoney", resultMoneyDouble);
				} else {}
			}
		}
		request.setAttribute("goodsMap", allGoods);// 所有的商品列表
		request.getSession().setAttribute("goodsChoosedMap", buySessionMap);// 已选的商品列表
		
		request.getRequestDispatcher("/bugGoods.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
