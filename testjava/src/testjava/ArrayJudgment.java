package testjava;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @describe �����п�
 * @author yjbo
 * @date 2017��12��5�� ����9:01:25
 */
public class ArrayJudgment {

	@Test
	public void testArrAll() {
		String[] testArr = new String[] { "name", "age", "area", null, "centre" };
		//�������Ԫ��
		for (int i = 0; i < testArr.length; i++) {
			System.out.println("���ÿ�������Ԫ��==" + testArr[i]);
		}
	}
	@Test
	public void testArrNoNUll() {
		String[] testArr = new String[] { "name", "age", "area", null, "centre" };
		//������пմ����գ��Լ�֮���Ԫ�ض��޷�����ˣ����Ƽ�ʹ�ã�
		for (int i = 0; testArr[i] != null & i < testArr.length; i++) {
			System.out.println("���ÿ�������Ԫ�أ��пգ�==" + testArr[i]);
		}
	}
	//�Ƽ�ʹ��
	@Test
	public void testArrNoNUll2() {
		String[] testArr = null;
		//������пմ����գ��Լ�֮���Ԫ�ض��޷�����ˣ��Ƽ�ʹ�ã�
		for (int i = 0; testArr != null && i < testArr.length; i++) {
			System.out.println("���ÿ�������Ԫ�أ��пգ�==" + testArr[i]);
		}
	}
	
}
