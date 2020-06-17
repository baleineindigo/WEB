package servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddressAjax")
public class AddressAjax extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private HashMap map = new HashMap();
    
	public void init() throws ServletException {
		map.put("A", "AAAA");
		map.put("B", "BBB");
		map.put("C", "CCC");
		map.put("D", "DDDDD");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		
		out.print(map.get(name));
	}

}
