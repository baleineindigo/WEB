package controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import model.ItemDao;

public class ItemListController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<String> fruits = new ArrayList<>();
		System.out.println(request.getParameter("redirect"));
		Cookie[] cs = request.getCookies();
		
		if (cs!=null) {
			for (Cookie c :cs) {
				if(c.getName().startsWith("fruitsshop")) {
					fruits.add(c.getValue());
				}
			}
		}
		request.setAttribute("fruits", fruits);
		ArrayList<Item> list=ItemDao.getInstance().getAllItem();
		request.setAttribute("list", list);
		return new ModelAndView("itemList.jsp");
	}
}
