package day06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @describe 下载文件
 * @author yjbo
 * @date 2017年12月4日 下午10:01:02
 */
@SuppressWarnings("serial")
@WebServlet("/ServletDemo2")
public class ServletDemo2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		test3(response);
		response.getOutputStream().write("已完成".getBytes());
	}

	// 下载图片
	private void test3(HttpServletResponse response) throws FileNotFoundException, IOException {
		 response.setHeader("content-disposition",
		 "attachment;filename="+System.currentTimeMillis()+".jpg");
		String realPath = this.getServletContext().getRealPath("/down/1.jpg");
		FileInputStream in = new FileInputStream(realPath);
		int len = 0;
		FileOutputStream out = new FileOutputStream("C:/1.jpg");
		byte[] butter = new byte[1024];
		while ((len = in.read(butter)) > 0) {
			System.out.println(len);
			out.write(butter, 0, len);
		}
		in.close();
		out.close();
	}

	// 显示图片
	private void test2(HttpServletResponse response) throws FileNotFoundException, IOException {
		response.setHeader("content-type", "image/jpeg");
		String realPath = this.getServletContext().getRealPath("/down/1.jpg");
		FileInputStream in = new FileInputStream(realPath);
		int len = 0;
		ServletOutputStream out = response.getOutputStream();
		byte[] butter = new byte[1024];
		while ((len = in.read(butter)) > 0) {
			System.out.println(len);
			out.write(butter, 0, len);
		}
		in.close();
		out.close();
	}

	// 复制图片
	private void test1(HttpServletResponse response) throws FileNotFoundException, IOException {
		String realPath = this.getServletContext().getRealPath("/down/1.jpg");
		FileInputStream in = new FileInputStream(realPath);
		int len = 0;
		FileOutputStream out = new FileOutputStream("C:/1.jpg");
		byte[] butter = new byte[1024];
		while ((len = in.read(butter)) > 0) {
			System.out.println(len);
			out.write(butter, 0, len);
		}
		in.close();
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
