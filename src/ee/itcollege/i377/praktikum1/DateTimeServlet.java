package ee.itcollege.i377.praktikum1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DateTimeServlet
 */
@WebServlet("/time")
public class DateTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String time = getDateTime();
		RenderedImage timeImage = generateRenderedImage(time);
		
		response.setContentType("image/png");
		
//		File imageFile = new File("/home/indrek/Desktop/time.png");
		try {
			ImageIO.write(timeImage, "png", response.getOutputStream());
//			ImageIO.write(timeImage, "png", imageFile);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
//		FileInputStream fs = new FileInputStream(imageFile);
//		byte[] buffer = new byte[1024];
//		int length;
//		while ((length = fs.read(buffer)) != -1) {
//			response.getOutputStream().write(buffer, 0, length);
//		}
//		response.getOutputStream().flush();
		
		
		
		
	}
	
	private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
	
	private RenderedImage generateRenderedImage(String text) {
		int width = 100;
		int height = 100;
		
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		Graphics2D g2d = bufferedImage.createGraphics();
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, width, height);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("SansSerif", Font.BOLD, 12));
		g2d.drawString(text, 0, 30);
		
		g2d.dispose();
		
		
		return bufferedImage;
	}

}
