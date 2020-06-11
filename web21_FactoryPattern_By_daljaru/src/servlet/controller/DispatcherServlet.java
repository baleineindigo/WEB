package servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.function.Component;
import servlet.function.ComponentFactory;

@WebServlet(urlPatterns="/front.do",loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;     
	private ComponentFactory componentFactory = null;
	String command = "";
	String path = "";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청이 어디에서 들어온 요청인지를 .....command값 받는다
		command =request.getParameter("command");
		componentFactory = ComponentFactory.getInstance();
		Component component = componentFactory.getComponent(command);
		path = component.execute(request, response);
		request.getRequestDispatcher(path).forward(request, response);	
	}//doProcess
}











