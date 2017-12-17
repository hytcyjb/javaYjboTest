package good.service;

import java.util.HashMap;
import java.util.Map;

import good.bean.Good;
import good.db.GoodDB;

/**
 * @describe ��Ʒ����
 * @author yjbo
 * @date 2017��12��17�� ����12:00:12
 */
public class GoodService {

	// ��ȡ������Ʒ��Ϣ�б�
	public HashMap getAllGoods() {
		GoodDB goodDB = new GoodDB();
		return goodDB.map;
	}

	// ͨ����Ʒ�����Ի�ȡ����Ʒ����ϸ��Ϣ
	public Good findGood(String key) {
		GoodDB goodDB = new GoodDB();
		Good good = (Good) goodDB.map.get(key);
		return good;
	}

	/**
	 * @deprecated ���¹��ﳵ��Ʒ�ܼ�
	 * @param flag
	 *            1 ���Ӳ�Ʒ���� ��ʱnumΪ1�� -1 ���ٲ�Ʒ������ʱnumΪ��ǰ��ѡ������ 0 �޸�������ʱnumΪ���ǵĲ�ֵ��
	 * @date 2017��12��17�� ����5:09:55
	 */
	public double updateMoney(int flag, double oldTotalMoney, int num,int goodId) {
		GoodService goodService = new GoodService();
		Map allGoods = goodService.getAllGoods();
		Good good = (Good) allGoods.get(goodId+"");//������int��֮ǰ��String���ͷŽ�ȥ�ġ�
		double totalMoney = 0.0;
		if (flag == 1) {//���һ����Ʒ�е���Ŀ��һ
			totalMoney = oldTotalMoney + good.getGoodPrice();
		} else if (flag == -1) {//ɾ��һ����Ʒ
			totalMoney = oldTotalMoney - good.getGoodPrice()* num;
		} else if (flag == 0) {//�޸�����
			totalMoney = oldTotalMoney + good.getGoodPrice() * num;
		} else {
		}
		return totalMoney;
	}

}
