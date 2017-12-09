package day06;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @describe ��ȡ������
 * @author yjbo
 * @date 2017��12��5�� ����9:18:47
 */
// ���ʣ�http://localhost:8080/day06/ServletDemo5
@WebServlet("/ServletDemo5")
public class ServletDemo5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @describe
	 * 	post �������ñ���ֻ��Ҫ��request�����ñ���ĸ�ʽ��response����Ҫ���ã���ҳҲ����Ҫ�����ˡ�
	 * 	get��������request������û��Ч���ģ�ʹ��new String(data.getBytes("iso8859-1"),"utf-8")ת�뼴��
	 * @author yjbo
	 * @date 2017��12��5�� ����10:11:07
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
		System.out.println("������===" + name + "===" + password + "===" + sex + "===" + city+"==info="+info);
		response.getWriter().write("������===" + name + "===" + password + "===" + sex + "===" + city+"==info="+info);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
