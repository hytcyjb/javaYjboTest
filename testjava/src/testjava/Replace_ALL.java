package testjava;

import org.junit.Test;

/**
 * @describe ��Դ��replace��replaceAll������ 
 * @author yjbo
 * @date 2017��12��24�� ����3:55:40
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
