package pattern.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pattern.model.DAO;
import pattern.model.NoteBook;

public class FindController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String model = request.getParameter("model");
		NoteBook nb = DAO.getInstance().findNoteBook(model);
		request.setAttribute("nb", nb);
		String path = "find_result.jsp";
		return path;
	}
	
}
