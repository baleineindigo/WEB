package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;


public class UpdateController implements Controller{
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) {
		String path = "index.jsp";
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		MemberVO vo = new MemberVO(id, password, name, address);
			try {
				if (MemberDAOImpl.getInstance().updateMember(vo)) {
					request.setAttribute("vo", vo);
					return new ModelAndView("update_result.jsp");
				} else {
					return new ModelAndView(path);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ModelAndView(path);
			}
			
			
		}
		
}

