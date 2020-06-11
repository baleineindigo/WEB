package servlet.function;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class RegisterComp implements Component {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		MemberVO pvo  = new MemberVO(id, password, name, address);
		String path = "register_ok.jsp";
		try {
			MemberDAOImpl.getInstance().registerMember(pvo);			
		}catch(SQLException e) {
			
		}
		return path;
	}
}
