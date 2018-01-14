package yy.yjbo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @describe 文件的上传与下载
 * @author yjbo
 * @date 2017年12月25日 下午6:37:02
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String fileName = request.getParameter("fileName");
		System.out.println(
				"=====" + fileName + "====" + fileName.substring(fileName.lastIndexOf("\\") + 1, fileName.length()));
		String saveFilename = this.getServletContext().getRealPath("/WEB-INF/upload/")
				+ fileName.substring(fileName.lastIndexOf("\\") + 1, fileName.length());
		File file = new File(saveFilename);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdir();// 如果父文件夹不存在则创建文件夹
		}

		/************************ 存文件 start ************************/
		FileOutputStream out = new FileOutputStream(file);
		FileInputStream in = new FileInputStream(new File(fileName));
		int length = 0;
		byte[] buffer = new byte[1024];
		while ((length = in.read(buffer)) > 0) {
			out.write(buffer, 0, length);
		}
		in.close();
		out.close();
		response.getWriter().write("上传成功" + saveFilename);
		/************************ 存文件 end ************************/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
