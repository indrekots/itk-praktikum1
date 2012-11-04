package ee.itcollege.i377.praktikum1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloName
 */
@WebServlet("/helloName")
public class HelloName extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.write("<html><head></head><body>");
		out.write("<p>Sisesta enda nimi</p>");
		out.write("<form id='hello' method='post'><input type='text' name='myName' />" +
				"<input type='submit' /></form>");
		out.write("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("myName");
		response.getWriter().write("Tere, " + name);
	}

}
