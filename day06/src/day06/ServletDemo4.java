package day06;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @describe 获取头信息等
 * @author yjbo
 * @date 2017年12月5日 下午8:31:00
 */
// 访问：http://localhost:8080/day06/ServletDemo4
@WebServlet("/ServletDemo4")
public class ServletDemo4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Served at: " + request.getRemoteAddr());
		Enumeration<String> headers = request.getHeaders("Accept-Encoding");
		while (headers.hasMoreElements()) {
			System.out.println("headers==" + headers.nextElement());
		}
		// 获取一个参数http://localhost:8080/day06/ServletDemo4?name=102
		String parameter = request.getParameter("name");
		System.out.println("parameter==" + parameter);
		// 获取一个数组参数 http://localhost:8080/day06/ServletDemo4?name=102&name=103&name=1055
		String[] parameterValues = request.getParameterValues("name");
		for (int i = 0; i < parameterValues.length; i++) {
			System.out.println("parameter==" + i + "==" + parameterValues[i]);
		}
		//获取所有参数 http://localhost:8080/day06/ServletDemo4?name=102&name=103&name=1055&liks=aa
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {//重复的不输出，只输出name，liks
			System.out.println("parameterNames====" + parameterNames.nextElement());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
