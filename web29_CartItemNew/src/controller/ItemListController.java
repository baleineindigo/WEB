package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import model.ItemDao;
public class ItemListController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) {
		String path = "fail.jsp";
		ArrayList<Item> list = new ArrayList<>();
		try {
			list=ItemDao.getInstance().getAllItem();
			System.out.println(list);
			request.getSession().setAttribute("list", list);
			path = "itemList.jsp";
			return new ModelAndView(path);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ModelAndView(path);
		}
	}
}


