package day06;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * day06-02.avi
 * @describe 绘制图片
 * @author yjbo
 * @date 2017年12月4日 下午10:36:03
 */
@WebServlet("/ServletDemo3")
public class ServletDemo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("content-type", "image/jpeg");
		BufferedImage bufferedImage = new BufferedImage(180, 30, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics graphics = bufferedImage.getGraphics();
		graphics.setColor(Color.red);
		graphics.setFont(new Font(null,Font.BOLD,20));
		graphics.drawString("148562", 20,20);
		ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
