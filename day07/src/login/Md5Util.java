package login;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.junit.Test;

import sun.misc.BASE64Encoder;

/**
 * @describe md5����
 * @author yjbo
 * @date 2017��12��10�� ����12:48:35
 */
public class Md5Util {
	// ��ȡmd5�������
	public static String getMd5Str() {
		String value = System.currentTimeMillis() + new Random().nextInt(9999999) + "";
		BASE64Encoder encoder = new BASE64Encoder();
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("md5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] digest = md.digest(value.getBytes());
		String result = encoder.encode(digest);
		System.out.println("==="+value+"===>"+result);
		return value;
	}
}
