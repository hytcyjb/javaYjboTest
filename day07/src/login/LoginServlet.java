package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String s_code = (String) request.getSession().getAttribute("yjboCode");
		String client_code = request.getParameter("code");
		//重置
		request.getSession().setAttribute("yjboCode", "");
		System.out.println("code="+s_code+"==="+client_code+"==="+Md5Util.getMd5Str());
		if(s_code != null && client_code != null && s_code.equals(client_code) && !s_code.equals("")){
			out.print("<br/><br/><br/>验证码验证成功,<a href='/day07/login.html'>点我跳转到登录页面</a>");
		}else{
			out.print("<br/><br/><br/>验证码验证失败,<a href='/day07/login.html'>点我跳转到登录页面</a>");
//			response.sendRedirect("/day07/login.html");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
