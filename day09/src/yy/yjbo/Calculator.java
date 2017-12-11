package yy.yjbo;

/**
 * @describe ������
 * @author yjbo
 * @date 2017��12��11�� ����11:13:46
 */
public class Calculator {
	private double firstNum;// ����ĵ�һ������
	private double secondNum;// ����ĵڶ�������
	private String operator;// +-*/������

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

	// ��������
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
				return "tip:�ڶ������ֲ���Ϊ0";
			}
			return String.valueOf((firstNum / secondNum));
		default:
			break;
		}
		return "";
	}
}
