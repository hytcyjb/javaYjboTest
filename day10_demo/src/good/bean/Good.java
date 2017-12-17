package good.bean;
/**
 * @describe 商品类 
 * @author yjbo
 * @date 2017年12月16日 下午11:49:28
 */
public class Good {
	private int goodId;// 商品序号
	private String goodName;// 商品名称
	private String goodProducer;// 商品的生产者
	private double goodPrice;// 商品单价
	private int goodAllowance;// 已选购商品数量
	private double totalPrice;//单一商品小计
	public Good() {
	}

	public Good(int goodId, String goodName, String goodProducer, double goodPrice, int goodAllowance) {
		super();
		this.goodId = goodId;
		this.goodName = goodName;
		this.goodProducer = goodProducer;
		this.goodPrice = goodPrice;
		this.goodAllowance = goodAllowance;
	}

	public int getGoodId() {
		return goodId;
	}

	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public String getGoodProducer() {
		return goodProducer;
	}

	public void setGoodProducer(String goodProducer) {
		this.goodProducer = goodProducer;
	}

	public double getGoodPrice() {
		return goodPrice;
	}

	public void setGoodPrice(double goodPrice) {
		this.goodPrice = goodPrice;
	}

	public int getGoodAllowance() {
		return goodAllowance;
	}

	public void setGoodAllowance(int goodAllowance) {
		this.goodAllowance = goodAllowance;
	}

	public double getTotalPrice() {
		return goodPrice * goodAllowance;
	}

	public void setTotalPrice() {
		this.totalPrice = goodPrice * goodAllowance;
	}

}
