package good.service;

import java.util.HashMap;
import java.util.Map;

import good.bean.Good;
import good.db.GoodDB;

/**
 * @describe 商品属性
 * @author yjbo
 * @date 2017年12月17日 上午12:00:12
 */
public class GoodService {

	// 获取所有商品信息列表
	public HashMap getAllGoods() {
		GoodDB goodDB = new GoodDB();
		return goodDB.map;
	}

	// 通过商品的属性获取到商品的详细信息
	public Good findGood(String key) {
		GoodDB goodDB = new GoodDB();
		Good good = (Good) goodDB.map.get(key);
		return good;
	}

	/**
	 * @deprecated 更新购物车商品总价
	 * @param flag
	 *            1 增加产品数量 此时num为1； -1 减少产品数量此时num为当前所选数量； 0 修改数量此时num为它们的差值；
	 * @date 2017年12月17日 下午5:09:55
	 */
	public double updateMoney(int flag, double oldTotalMoney, int num,int goodId) {
		GoodService goodService = new GoodService();
		Map allGoods = goodService.getAllGoods();
		Good good = (Good) allGoods.get(goodId+"");//不能是int，之前是String类型放进去的。
		double totalMoney = 0.0;
		if (flag == 1) {//添加一类商品中的数目加一
			totalMoney = oldTotalMoney + good.getGoodPrice();
		} else if (flag == -1) {//删除一类商品
			totalMoney = oldTotalMoney - good.getGoodPrice()* num;
		} else if (flag == 0) {//修改数量
			totalMoney = oldTotalMoney + good.getGoodPrice() * num;
		} else {
		}
		return totalMoney;
	}

}
