package day05;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//����http://localhost:8080/day05/2.html
@SuppressWarnings("serial")
public class ServletDemo1 extends GenericServlet {

	@Override
	public void init() throws ServletException {
		super.init();
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH��MM��ss SSS");
		Date date = new Date();
		System.out.print(dateFormater.format(date));
		System.out.println("init��ʼ������--ֻ�е�һ�η���ʱ����=" + dateFormater.format(date));
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {

		// ����һ��ͼƬ
		arg1.setContentType("image/jpeg");
		InputStream in = this.getServletContext().getResourceAsStream("/1.jpg");
		byte buffer[] = new byte[1024];
		int len = 0;
		OutputStream out = arg1.getOutputStream();
		while ((len = in.read(buffer)) > 0) {
			out.write(buffer, 0, len);
		}

		// ����һ������
		// arg1.getOutputStream().write("hello yjbo yy 1".getBytes());

	}

}
