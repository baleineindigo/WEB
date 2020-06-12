package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

/**
 * Servlet implementation class CountServlet
 */
@WebServlet("/CountServlet")
public class CountServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	private int count= 0;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		count += 1;
		out.print(id+" "+pass+"<br/> Count ::"+ count);
		
		//Ajax02
/*		PrintWriter out = response.getWriter();
		String nick = request.getParameter("nickname");
		out.print(nick);*/
	}

}
