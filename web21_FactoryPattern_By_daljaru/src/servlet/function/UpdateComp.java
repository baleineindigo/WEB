package servlet.function;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class UpdateComp implements Component {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		MemberVO pvo = new MemberVO(id, password, name, address);
		String path = "index.jsp";
		try {
			MemberDAOImpl.getInstance().updateMember(pvo);
			
			HttpSession session  = request.getSession();
			if(session.getAttribute("vo") !=null) {
				session.setAttribute("vo", pvo); //중요
				path = "update_result.jsp";
			}
			
			request.getRequestDispatcher(path).forward(request, response);
		}catch(Exception e) {
			
		}		
		return path;
	}

}
