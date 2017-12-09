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
 * @describe 复制文件 
 * //访问http://localhost:8080/day05/ServletDemo5
 * @author yjbo
 * @date 2017年12月2日 下午4:55:54
 */
/**
 * WebContent下的"1.jpg"文件位置 D:\work\eclipse-SDK-4.5-win32-x86_64\eclipse\1.jpg 假的
 * G:\android\eclipsecode\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\
 * wtpwebapps\day05\1.jpg 真正的位置
 */
public class ServletDemo5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		test1(request, response);

	}

	/**
	 * @describe 查询图片路径
	 * @author yjbo
	 * @date 2017年12月3日 下午4:59:20
	 */
	private void test1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File file = new File("1.jpg");
		String absolutePath = file.getAbsolutePath();
		System.out.println(absolutePath);
		String realPath = this.getServletContext().getRealPath("1.jpg");
		response.getOutputStream()
				.write(("<h1>打印图片地理位置" + "==</br>==" + absolutePath + "==</br>==" + realPath + "</h1>").getBytes());
	}

	/**
	 * @describe 拷贝图片
	 * @author yjbo
	 * @date 2017年12月3日 下午4:59:20
	 */
	private void test2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String realPath = this.getServletContext().getRealPath("1.jpg");
		FileInputStream in = new FileInputStream(realPath);
		byte buffer[] = new byte[1024];
		FileOutputStream out = new FileOutputStream("G:/5.jpg");
		int len = 0;
		while ((len = in.read(buffer)) > 0) {
			System.out.println("复制完成:" + len + "====" + buffer);
			out.write(buffer, 0, len);
		}
		out.close();
		in.close();
		response.getOutputStream().write(("<h1>打印图片存储位置" + "==</br>==" + realPath + "</h1>").getBytes());
	}

	/**
	 * @describe 拷贝视频
	 * @author yjbo
	 * @date 2017年12月3日 17:05:20
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
			System.out.println("复制完成:" + len + "====" + buffer+"===="+i);
			out.write(buffer, 0, len);
		}
		out.close();
		in.close();
		response.getOutputStream().write(("<h1>打印视频位置" + "==</br>==" + realPath + "</h1>").getBytes());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
