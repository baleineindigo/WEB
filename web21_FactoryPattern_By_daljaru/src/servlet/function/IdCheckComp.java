package servlet.function;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;

public class IdCheckComp implements Component {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "idcheck.jsp";
		String id = request.getParameter("id");
		try {
			boolean flag=MemberDAOImpl.getInstance().idExist(id);
			request.setAttribute("flag", flag);
			request.getRequestDispatcher(path).forward(request, response);
		}catch(Exception e) {
			System.out.println(e);
		}
		return path;
	}
}
