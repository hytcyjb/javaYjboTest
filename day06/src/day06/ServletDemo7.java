package day06;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @describe include拦截其他网页的Servlet数据在当前页面显示
 * @author yjbo
 * @date 2017年12月8日 下午7:46:31
 */
//http://localhost:8080/day06/ServletDemo7
@WebServlet("/ServletDemo7")
public class ServletDemo7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {      
		request.getRequestDispatcher("/ServletTest1").include(request, response);
		response.getOutputStream().write("<h1>Served at: ServletDemo7</h1>".getBytes());
		request.getRequestDispatcher("/ServletTest2").include(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}