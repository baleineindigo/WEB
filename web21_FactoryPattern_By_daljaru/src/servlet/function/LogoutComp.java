package servlet.function;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutComp implements Component {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String path ="index.jsp";	
		if(session.getAttribute("vo") !=null) {//로그인한 상태라면...
			session.invalidate();
			path ="logout.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}
		return path;
	}

}
