package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;


public class FindController implements Controller{
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) {
		String path = "find_fail.jsp";
		MemberVO vo = null;
		String id = request.getParameter("id");
		if(id!=null) {
			try {
				vo=MemberDAOImpl.getInstance().findByIdMember(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("vo", vo);
			path = "find_ok.jsp";
			return new ModelAndView(path);
		}else {
			return new ModelAndView(path);
		}
		
	}
}
