package day05;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//���ʷ�ʽ
//http://localhost:8080/day05/servlet/ServletDemo3
@SuppressWarnings("serial")
public class ServletDemo3 extends HttpServlet{
	int i = 0;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.getOutputStream().write("��������".getBytes());
		ServletConfig servletConfig = this.getServletConfig();
		ServletContext servletContext = servletConfig.getServletContext();
		System.out.println("==ServletDemo3=1==="+servletContext.getAttribute("xxx"));
		i++;
		System.out.println("==ServletDemo3=="+i);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
