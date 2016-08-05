package eden.study.response;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RandomImage extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setHeader("refresh", "1");//每1秒刷新一次
		//在内存中创建一张图片
		BufferedImage	image = new BufferedImage(60, 20, BufferedImage.TYPE_INT_RGB);
		
		//得到图片
		Graphics2D g = (Graphics2D) image.getGraphics();
		g.setColor(Color.GRAY);//背景色
		g.fillRect(0, 0, 60, 20);
		
		//向图片上写数据
		g.setColor(Color.WHITE);
		g.setFont(new Font(null, Font.BOLD, 20));
		g.drawString(getNum(), 0, 20);
		
		//设置响应头控制浏览器以图片的方式打开
		resp.setContentType("image/jpeg");
		resp.setHeader("content-type", "image/jpeg");
		
		//不要缓存
		resp.setDateHeader("expires", -1);
		resp.setHeader("Cache-contril", "no-cache");
		resp.setHeader("Pragma", "no-cache");
		
		//将图片写给浏览器
		ImageIO.write(image, "jpg", resp.getOutputStream());
	}

	private String getNum() {
		Random r = new Random();
		String num = r.nextInt(99999) +"";
		StringBuffer sb = new StringBuffer(num);
		for(int i = 0; i < 5 - num.length(); i++){
			sb.append("0");
		}
		return sb.toString();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
