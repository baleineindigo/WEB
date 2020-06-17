package servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.java2d.pipe.OutlineTextRenderer;

/**
 * Servlet implementation class HelloAjaxServlet
 */
@WebServlet("/HelloAjaxServlet")
public class HelloAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
//		try {
//			Thread.sleep(1000);
//		} catch (Exception e) {
//			
//		}
		String name = request.getParameter("name");
		out.print(name+" --------name");
		out.close();
	}

}
