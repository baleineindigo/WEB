package servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xpath.internal.operations.Mod;


@WebServlet("/HandlerMapping")
public class HandlerMapping{
	private static HandlerMapping handler = new HandlerMapping();
	public HandlerMapping() { }
	public static HandlerMapping getInstance() {
		return handler;
	}
	protected Controller createController(String command) throws ServletException, IOException {
		Controller controller = null;
		if(command.equals("itemList")) {
			controller = new ItemListController();
			System.out.println("new itemListController();");
		}
		return controller;
	}
}
