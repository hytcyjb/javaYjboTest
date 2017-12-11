package yy.yjbo;

/**
 * @describe 计算器
 * @author yjbo
 * @date 2017年12月11日 下午11:13:46
 */
public class Calculator {
	private double firstNum;// 输入的第一个参数
	private double secondNum;// 输入的第二个参数
	private String operator;// +-*/操作符

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

	// 计算数据
	public String calculatatorData() {
		switch (operator) {
		case "+":
			return String.valueOf((firstNum + secondNum));
		case "-":
			return String.valueOf((firstNum - secondNum));
		case "*":
			return String.valueOf((firstNum * secondNum));
		case "/":
			if(secondNum == 0){
				return "tip:第二个数字不能为0";
			}
			return String.valueOf((firstNum / secondNum));
		default:
			break;
		}
		return "";
	}
}
