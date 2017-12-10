package day07;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;
import sun.security.provider.MD5;
/**
 * @describe ����cookie 
 * @author yjbo
 * @date 2017��12��8�� ����9:54:21
 */
//http://localhost:8080/day07/CookieDemo1
@WebServlet("/CookieDemo1")
public class CookieDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡcookie
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			Cookie cookie = cookies[i];
			BASE64Encoder encoder = new BASE64Encoder();
			String value = cookie.getValue();
			try {
				MessageDigest md =  MessageDigest.getInstance("md5");
				byte[] digest = md.digest(value.getBytes());
				value = encoder.encode(digest);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("i="+cookie.getValue()+";==>"+value);
			if("yjbo".equals(cookie.getName())){
				response.getWriter().print(cookie.getValue());
			}
		}
		//����cookie
		response.addCookie(new Cookie("yjbo", System.currentTimeMillis()+""));
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
