package servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.If;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "index.jsp";
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length()+1);
		ModelAndView mv = null;
		Controller controller = HandlerMapping.getInstance().createController(command);
		boolean isRedirect = false;
		try {
			mv = controller.handle(request, response);
			path = mv.getPath();
			isRedirect = mv.isRedirect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		if (mv!=null) {
			if(mv.isRedirect()==true) {
				System.out.println("redirecting");
				response.sendRedirect(path);
		} else {
			System.out.println("forwarding");
			request.getRequestDispatcher(path).forward(request, response);
		}
		
	}
	}
}
