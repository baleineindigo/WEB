package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;


public class SubjectController implements Controller{
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("getSubjectController 진입...");
		String result = "Algorithm | Big Data | Deep Learning | Restful API";
		request.setAttribute("result", result);
		System.out.println(result);
		return new ModelAndView("result.jsp");	
		
/*		String path = "login_fail.jsp";
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
		}*/
	}
}
