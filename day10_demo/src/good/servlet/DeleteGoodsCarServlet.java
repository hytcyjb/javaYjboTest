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
 * @describe ɾ��ĳ����Ʒ���ﳵ�������б�
 * @author yjbo
 * @date 2017��12��17�� 11:15
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
		HashMap buySessionMap = new HashMap<>();// ��ѡ����
		if("true".equals(deleteFlag)){//��չ��ﳵ
			request.getSession().setAttribute("goodsChoosedMap", buySessionMap);// ��ѡ����Ʒ�б�
			request.getSession().setAttribute("totalMoney", 0.0);
		}else{//ɾ��ĳ����Ʒ
			Good good = (Good) allGoods.get(goodId);
			// ��ѡ����
			buySessionMap = (HashMap) request.getSession().getAttribute("goodsChoosedMap");
			if (buySessionMap == null) {
			} else {
				Good good1 = (Good) buySessionMap.get(goodId);
				if (good1 != null) {
					buySessionMap.remove(goodId);
					Object totalMonObj = request.getSession().getAttribute("totalMoney");
					double totalMonDouble = 0.0;
					if(totalMonObj != null){//�жϷǿ�
						totalMonDouble = Double.valueOf(totalMonObj+"");
					}
					double resultMoneyDouble = goodService.updateMoney(-1,Double.valueOf(totalMonDouble),good1.getGoodAllowance(),Integer.valueOf(goodId+""));
					request.getSession().setAttribute("totalMoney", resultMoneyDouble);
				} else {}
			}
		}
		request.setAttribute("goodsMap", allGoods);// ���е���Ʒ�б�
		request.getSession().setAttribute("goodsChoosedMap", buySessionMap);// ��ѡ����Ʒ�б�
		
		request.getRequestDispatcher("/bugGoods.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
