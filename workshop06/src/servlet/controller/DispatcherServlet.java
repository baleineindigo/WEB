package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import content.vo.Book;
import content.vo.BookDAO;
import content.vo.BookDAOImpl;
import content.vo.User;


@WebServlet(urlPatterns="/front.do",loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDAO dao = null;
	private ArrayList<Book> books = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청이 어디에서 들어온 요청인지를 .....command값 받는다
		String command =request.getParameter("command");
		String path = "index.jsp"; //path초기화
		
		if(command.equals("login")) {
			path = login(request,response);
		}else if (command.equals("registerBook")) {
			path = registerBook(request,response);
		}else if (command.equals("logout")) {
			path = logout(request, response);
		}else if(command.equals("searchBook")) {
			path = searchBook(request, response);
		}
		request.getRequestDispatcher(path).forward(request, response);	
	}
	protected String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String path = "";
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");

		dao = BookDAOImpl.getInstance();
		User user = null;
		try {
			user = dao.login(userId, password);
		} catch (SQLException e) {
			System.out.println("로그인 실패");
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		path = "loginResult.jsp";
		return path;
	}
	protected String registerBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String path = "";
		String isbn1 = request.getParameter("isbn1");
		String isbn2 = request.getParameter("isbn2");
		String isbn3 = request.getParameter("isbn3");
		String isbn = isbn1+"-"+isbn2+"-"+isbn3;
		String title = request.getParameter("title");
		String catalogue = request.getParameter("catalogue");
		String nation = request.getParameter("nation");
		String publish_date = request.getParameter("publish_date");
		String publisher = request.getParameter("publisher");
		String author = request.getParameter("author");
		int price = Integer.parseInt(request.getParameter("price"));
		String currency = request.getParameter("currency");
		String description = request.getParameter("description");
		
		Book book = new Book(isbn, title, catalogue, nation, publish_date, publisher, author, price, currency, description);
		
		dao = BookDAOImpl.getInstance();
		try {
			dao.registerBook(book);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("book", book);
		path = "registerSuccess.jsp";
		return path;
	}
	protected String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String path = "";
		request.getSession().invalidate();
		path = "login_form.jsp";
		return path;
	}
	protected String searchBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String path = "";
		String category = request.getParameter("category");
		String categoryContents = request.getParameter("categoryContents");
		
		dao = BookDAOImpl.getInstance();

		try {
			books = dao.showAllBooks(category, categoryContents);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("books", books);
		path = "bookList_form.jsp";
		return path;
	}
}
