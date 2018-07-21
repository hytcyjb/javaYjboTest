package filter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ≤‚ ‘¬“¬Î
 * 
 * @author yjbo
 * @date 2018ƒÍ2‘¬4»’
 */
@WebServlet("/testEncoderServler")
public class testEncoderServler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public testEncoderServler() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String encodeName = request.getParameter("encodeName");

		response.getWriter().append(encodeName + "\r\n" + "Served at:").append(request.getContextPath())
				.append("=-==="+request.getMethod());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
