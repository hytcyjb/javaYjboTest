package day05;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @describe �����ļ� 
 * //����http://localhost:8080/day05/ServletDemo5
 * @author yjbo
 * @date 2017��12��2�� ����4:55:54
 */
/**
 * WebContent�µ�"1.jpg"�ļ�λ�� D:\work\eclipse-SDK-4.5-win32-x86_64\eclipse\1.jpg �ٵ�
 * G:\android\eclipsecode\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\
 * wtpwebapps\day05\1.jpg ������λ��
 */
public class ServletDemo5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		test1(request, response);

	}

	/**
	 * @describe ��ѯͼƬ·��
	 * @author yjbo
	 * @date 2017��12��3�� ����4:59:20
	 */
	private void test1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File file = new File("1.jpg");
		String absolutePath = file.getAbsolutePath();
		System.out.println(absolutePath);
		String realPath = this.getServletContext().getRealPath("1.jpg");
		response.getOutputStream()
				.write(("<h1>��ӡͼƬ����λ��" + "==</br>==" + absolutePath + "==</br>==" + realPath + "</h1>").getBytes());
	}

	/**
	 * @describe ����ͼƬ
	 * @author yjbo
	 * @date 2017��12��3�� ����4:59:20
	 */
	private void test2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String realPath = this.getServletContext().getRealPath("1.jpg");
		FileInputStream in = new FileInputStream(realPath);
		byte buffer[] = new byte[1024];
		FileOutputStream out = new FileOutputStream("G:/5.jpg");
		int len = 0;
		while ((len = in.read(buffer)) > 0) {
			System.out.println("�������:" + len + "====" + buffer);
			out.write(buffer, 0, len);
		}
		out.close();
		in.close();
		response.getOutputStream().write(("<h1>��ӡͼƬ�洢λ��" + "==</br>==" + realPath + "</h1>").getBytes());
	}

	/**
	 * @describe ������Ƶ
	 * @author yjbo
	 * @date 2017��12��3�� 17:05:20
	 */
	private void test3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String realPath = this.getServletContext().getRealPath("02.avi");
		FileInputStream in = new FileInputStream(realPath);
		byte buffer[] = new byte[1024];
		FileOutputStream out = new FileOutputStream("G:/02.avi");
		int i= 0;
		int len = 0;
		while ((len = in.read(buffer)) > 0) {
			i += len;
			System.out.println("�������:" + len + "====" + buffer+"===="+i);
			out.write(buffer, 0, len);
		}
		out.close();
		in.close();
		response.getOutputStream().write(("<h1>��ӡ��Ƶλ��" + "==</br>==" + realPath + "</h1>").getBytes());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
