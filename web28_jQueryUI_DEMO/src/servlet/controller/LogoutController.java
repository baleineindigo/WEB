package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;


public class LogoutController implements Controller{
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) {
		String path = "index.jsp";
		request.getSession().invalidate();
		return new ModelAndView(path);
	}
}
