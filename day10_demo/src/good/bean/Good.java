package good.bean;
/**
 * @describe ��Ʒ�� 
 * @author yjbo
 * @date 2017��12��16�� ����11:49:28
 */
public class Good {
	private int goodId;// ��Ʒ���
	private String goodName;// ��Ʒ����
	private String goodProducer;// ��Ʒ��������
	private double goodPrice;// ��Ʒ����
	private int goodAllowance;// ��ѡ����Ʒ����
	private double totalPrice;//��һ��ƷС��
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
