package good.db;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import good.bean.Good;

/**
 * @describe ��Ʒ�����ݿ⣬�˴���ʹ��map�ṹ�����
 * @author yjbo
 * @date 2017��12��16�� ����11:49:46
 */
public class GoodDB {
	public HashMap map = new LinkedHashMap() {
		private static final long serialVersionUID = 1L;

		{
			put("1", new Good(1, "android����", "yjbo1", 20.00, 1));
			put("2", new Good(2, "java����", "yjbo2", 10.00, 1));
			put("3", new Good(3, "jsp����", "yjbo3", 25.00, 1));
			put("4", new Good(4, "html����", "yjbo4", 28.00, 1));
			put("5", new Good(5, "html5����", "yjbo5", 30.00, 1));
			put("6", new Good(6, "Servlet����", "yjbo6", 60.00, 1));
			put("7", new Good(7, "React Native����", "yjbo7", 50.00, 1));
			put("8", new Good(8, "FFmage����", "yjbo8", 40.00, 1));
			put("9", new Good(9, "��Ƶ��Ƶ����", "yjbo9", 80.00, 1));
		}
	};


}
