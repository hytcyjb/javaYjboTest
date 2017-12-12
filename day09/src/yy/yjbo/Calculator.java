package yy.yjbo;

/**
 * @describe ������
 * @author yjbo
 * @date 2017��12��11�� ����11:13:46
 */
public class Calculator {
	private double firstNum;// ����ĵ�һ������
	private double secondNum;// ����ĵڶ�������
	private String operator = "+";// +-*/������
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

	// ��������
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
				this.result =  "tip:�ڶ������ֲ���Ϊ0";
				break;
			}
			this.result =  String.valueOf((firstNum / secondNum));
			break;
		default:
			this.result = "��";
			break;
		}
	}
}
