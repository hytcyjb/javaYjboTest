package day05;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//���ʷ�ʽ
//http://localhost:8080/day05/servlet/ServletDemo2
public class ServletDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		test2(request,response);
		
		
	}
	//locationͷ��Ӧ��
	public void test1(HttpServletRequest request, HttpServletResponse response){
		response.setStatus(302);
		response.setHeader("location", "/day04-1/1.html");
	}
	
	//����ѹ��
	public void test2(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String data = "abcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcd";
		System.out.println("ԭʼ���ݵĴ�СΪ��" + data.getBytes().length);
		
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		
		GZIPOutputStream gout = new GZIPOutputStream(bout); //buffer
		gout.write(data.getBytes());
		gout.close();
		
		//�õ�ѹ���������
		byte g[] = bout.toByteArray();
		
		
		response.setHeader("Content-Encoding", "gzip");
		response.setHeader("Content-Length",g.length +"");
		
		response.getOutputStream().write(g);
	}
	
	//ָ��������������--ͼƬ
	public void test3(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//C:\apache-tomcat-6.0.20\conf\web.xml 
		response.setHeader("content-type", "image/jpeg");
		
		InputStream in = this.getServletContext().getResourceAsStream("/1.jpg");
		byte buffer[] = new byte[1024];
		int len = 0;
		OutputStream out = response.getOutputStream();
		while((len=in.read(buffer))>0){
			out.write(buffer, 0, len);
		}
		
	}
	
	//ָ���������ʱˢ��
	public void test4(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		response.setHeader("refresh", "3;url='http://www.sina.com'");
		response.getWriter().write("abcd");
		
		
	}
	
	//ָ�����������
	public void test5(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		response.setHeader("content-disposition", "attachment;filename="+System.currentTimeMillis()+".jpg");
		
		InputStream in = this.getServletContext().getResourceAsStream("/2.jpg");
		byte buffer[] = new byte[1024];
		int len = 0;
		OutputStream out = response.getOutputStream();
		while((len=in.read(buffer))>0){
			out.write(buffer, 0, len);
		}
		
	}
	//ָ�����������
	public void test6(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		response.setHeader("content-disposition", "attachment;filename=xxx.txt");
		
		InputStream in = this.getServletContext().getResourceAsStream("/sss.txt");
		byte buffer[] = new byte[1024];
		int len = 0;
		OutputStream out = response.getOutputStream();
		while((len=in.read(buffer))>0){
			out.write(buffer, 0, len);
		}
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
