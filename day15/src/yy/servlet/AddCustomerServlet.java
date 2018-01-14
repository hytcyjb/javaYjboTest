package yy.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.Global;

import yy.bean.HobbyList;
import yy.util.GlobalUtil;

/**
 * @describe ��ҳ�� 
 * @author yjbo
 * @date 2018��1��7�� ����9:59:42
 */
//�����ַ��http://localhost:8080/day15/login.html
@WebServlet("/login.html")
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().setAttribute("items", new HobbyList().getList());//֮ǰ��GlobalUtil.gHobby,�����[���� ���� ����Ӱ �ݽ�] ---->�ո��Լ�������������
		request.getRequestDispatcher("/main.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
