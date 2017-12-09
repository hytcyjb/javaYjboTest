package day06;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @describe 获取表单数据
 * @author yjbo
 * @date 2017年12月5日 下午9:18:47
 */
// 访问：http://localhost:8080/day06/ServletDemo5
@WebServlet("/ServletDemo5")
public class ServletDemo5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @describe
	 * 	post 请求，设置编码只需要在request上设置编码的格式，response不需要设置，网页也不需要设置了。
	 * 	get请求，设置request编码是没有效果的，使用new String(data.getBytes("iso8859-1"),"utf-8")转译即可
	 * @author yjbo
	 * @date 2017年12月5日 下午10:11:07
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String city = request.getParameter("city");
		String info = request.getParameter("info");
		String[] parameterValues = request.getParameterValues("like");
		
		response.setCharacterEncoding("UTF-8");
		for (int i = 0;parameterValues != null && i < parameterValues.length; i++) {
			System.out.println("===="+parameterValues[i]);
		}
		System.out.println("输入了===" + name + "===" + password + "===" + sex + "===" + city+"==info="+info);
		response.getWriter().write("输入了===" + name + "===" + password + "===" + sex + "===" + city+"==info="+info);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
