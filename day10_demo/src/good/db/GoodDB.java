package good.db;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import good.bean.Good;

/**
 * @describe 商品的数据库，此处是使用map结构保存的
 * @author yjbo
 * @date 2017年12月16日 下午11:49:46
 */
public class GoodDB {
	public HashMap map = new LinkedHashMap() {
		private static final long serialVersionUID = 1L;

		{
			put("1", new Good(1, "android开发", "yjbo1", 20.00, 1));
			put("2", new Good(2, "java开发", "yjbo2", 10.00, 1));
			put("3", new Good(3, "jsp开发", "yjbo3", 25.00, 1));
			put("4", new Good(4, "html开发", "yjbo4", 28.00, 1));
			put("5", new Good(5, "html5开发", "yjbo5", 30.00, 1));
			put("6", new Good(6, "Servlet开发", "yjbo6", 60.00, 1));
			put("7", new Good(7, "React Native开发", "yjbo7", 50.00, 1));
			put("8", new Good(8, "FFmage开发", "yjbo8", 40.00, 1));
			put("9", new Good(9, "视频音频开发", "yjbo9", 80.00, 1));
		}
	};


}
