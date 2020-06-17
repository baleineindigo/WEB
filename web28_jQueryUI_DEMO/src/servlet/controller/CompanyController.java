package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;


public class CompanyController implements Controller{
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("CompanyController 진입...");
		String result = "company controller result";
		request.setAttribute("result", result);
		return new ModelAndView("result.jsp");
	}
}
