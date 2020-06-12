package servlet.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;


public class AllViewController implements Controller{
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) {
		String path = "index.jsp";
		ArrayList<MemberVO> list = null;
		try {
			list = MemberDAOImpl.getInstance().showAllMember();
			request.getSession().setAttribute("list", list);
			path = "allView.jsp";
			return new ModelAndView(path);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ModelAndView(path);
		}
	}
}
