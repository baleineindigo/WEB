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

		if (command.equals("find.do")) {
			controller = new FindController();
			System.out.println("FindController() ::: 생성");
		}else if (command.equals("login.do")) {
			controller = new LoginController();
			System.out.println("LoginController() ::: 생성");
		}else if (command.equals("logout.do")) {
			controller = new LogoutController();
			System.out.println("LoginController() ::: 생성");
		}else if (command.equals("allview.do")) {
			controller = new AllViewController();
			System.out.println("AllViewController() ::: 생성");
		}else if (command.equals("update.do")) {
			controller = new UpdateController();
			System.out.println("UpdateController() ::: 생성");
		}else if (command.equals("register.do")) {
			controller = new RegisterController();
			System.out.println("RegisterController() ::: 생성");
		}else {
			return controller;
		}
		return controller;
	}


}
