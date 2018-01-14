package testjava;

import org.junit.Test;

/**
 * @describe 看源码replace和replaceAll的区别 
 * @author yjbo
 * @date 2017年12月24日 下午3:55:40
 */
public class Replace_ALL {

	String str = "sasasasafvvdlsasa2121sd";
	@Test
	public void testReplace(){
		System.out.println("1=="+System.currentTimeMillis());
		String replace = str.replace("\\d", "p");
		System.out.println(replace);
		System.out.println("1=="+System.currentTimeMillis());
	}
	@Test
	public void testReplaceAll(){
		System.out.println("2=="+System.currentTimeMillis());
		String replaceAll = str.replaceAll("\\d", "p");
		System.out.println("2=="+replaceAll);
		System.out.println("2=="+System.currentTimeMillis());
	}
}
