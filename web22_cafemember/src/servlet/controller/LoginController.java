package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;


public class LoginController implements Controller{
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) {
		String path = "login_fail.jsp";
		MemberVO vo = null;
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		try {
			vo=MemberDAOImpl.getInstance().login(id, password);
			request.getSession().setAttribute("vo", vo);
			path = "login_result.jsp";
			return new ModelAndView(path);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ModelAndView(path);
		}
	}
}
