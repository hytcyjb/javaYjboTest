package testjava;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class testNum {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		System.out.println("���ѽ");
	}
	@Test
	public void getNumI() {
		Num num = new Num();
		num.setI(50);
		System.out.println(num.toString());
		System.out.println("���ڿ���̨�������ݣ�");
		Scanner input =new Scanner(System.in);
        String instr = input.nextLine();
        System.out.println("��ո������ˣ�"+instr);
	}
}
