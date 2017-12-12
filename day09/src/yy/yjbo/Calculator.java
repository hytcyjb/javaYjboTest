package yy.yjbo;

/**
 * @describe 计算器
 * @author yjbo
 * @date 2017年12月11日 下午11:13:46
 */
public class Calculator {
	private double firstNum;// 输入的第一个参数
	private double secondNum;// 输入的第二个参数
	private String operator = "+";// +-*/操作符
	private String result;
	public double getFirstNum() {
		return firstNum;
	}

	public void setFirstNum(double firstNum) {
		this.firstNum = firstNum;
	}

	public double getSecondNum() {
		return secondNum;
	}

	public void setSecondNum(double secondNum) {
		this.secondNum = secondNum;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	// 计算数据
	public void calculatatorData() {
		switch (operator) {
		case "+":
			this.result = String.valueOf((this.firstNum + this.secondNum));
			break;
		case "-":
			this.result =  String.valueOf((this.firstNum - this.secondNum));
			break;
		case "*":
			this.result =  String.valueOf((firstNum * secondNum));
			break;
		case "/":
			if(secondNum == 0){
				this.result =  "tip:第二个数字不能为0";
				break;
			}
			this.result =  String.valueOf((firstNum / secondNum));
			break;
		default:
			this.result = "空";
			break;
		}
	}
}
