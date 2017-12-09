package day05;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @describe 描述
 * @author yjbo
 * @date 2017年12月2日 下午4:12:04
 */
@WebServlet("/ServletDemo4")
public class ServletDemo4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletDemo4() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ServletConfig servletConfig = this.getServletConfig();// 获取<init-param>
		ServletContext servletContext = servletConfig.getServletContext();// 获取<context-param>
																			// -->
																			// servletContext.getInitParameter("xxx")
		System.out.println(
				"==1===" + servletContext.getAttribute("xxx") + "===" + servletContext.getInitParameter("xxx"));
		servletContext.setAttribute("xxx", "yyysssss");// 设置全局参数
		System.out.println("==2===" + servletContext.getAttribute("xxx"));
		// 转到别的类中处理，效果很好。
		RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/servlet/ServletDemo3");
		requestDispatcher.forward(request, response);

		System.out.println("=还可以继续执行=3===" + servletContext.getAttribute("xxx"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("xxx===" + config.getInitParameter("xxx"));
	}

}
