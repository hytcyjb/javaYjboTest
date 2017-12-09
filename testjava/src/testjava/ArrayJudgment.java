package testjava;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @describe 数组判空
 * @author yjbo
 * @date 2017年12月5日 下午9:01:25
 */
public class ArrayJudgment {

	@Test
	public void testArrAll() {
		String[] testArr = new String[] { "name", "age", "area", null, "centre" };
		//输出所有元素
		for (int i = 0; i < testArr.length; i++) {
			System.out.println("输出每个数组的元素==" + testArr[i]);
		}
	}
	@Test
	public void testArrNoNUll() {
		String[] testArr = new String[] { "name", "age", "area", null, "centre" };
		//添加了判空处理，空，以及之后的元素都无法输出了（不推荐使用）
		for (int i = 0; testArr[i] != null & i < testArr.length; i++) {
			System.out.println("输出每个数组的元素（判空）==" + testArr[i]);
		}
	}
	//推荐使用
	@Test
	public void testArrNoNUll2() {
		String[] testArr = null;
		//添加了判空处理，空，以及之后的元素都无法输出了（推荐使用）
		for (int i = 0; testArr != null && i < testArr.length; i++) {
			System.out.println("输出每个数组的元素（判空）==" + testArr[i]);
		}
	}
	
}
