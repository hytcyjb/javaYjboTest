package day06;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @describe ��ȡͷ��Ϣ��
 * @author yjbo
 * @date 2017��12��5�� ����8:31:00
 */
// ���ʣ�http://localhost:8080/day06/ServletDemo4
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
		// ��ȡһ������http://localhost:8080/day06/ServletDemo4?name=102
		String parameter = request.getParameter("name");
		System.out.println("parameter==" + parameter);
		// ��ȡһ��������� http://localhost:8080/day06/ServletDemo4?name=102&name=103&name=1055
		String[] parameterValues = request.getParameterValues("name");
		for (int i = 0; i < parameterValues.length; i++) {
			System.out.println("parameter==" + i + "==" + parameterValues[i]);
		}
		//��ȡ���в��� http://localhost:8080/day06/ServletDemo4?name=102&name=103&name=1055&liks=aa
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {//�ظ��Ĳ������ֻ���name��liks
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
