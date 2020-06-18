package controller;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import model.Item;
import model.ItemDao;

public class CartController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int itemnum = Integer.parseInt(request.getParameter("itemNumber"));
		Item item = ItemDao.getInstance().getItem(itemnum);

		Cookie cookie = new Cookie("fruitsshop"+itemnum, item.getUrl());
		cookie.setMaxAge(24*60*60);
		response.addCookie(cookie);
		System.out.println("ItemDetailController ::: "+item);
		request.setAttribute("item", item);
		return new ModelAndView("itemDetail.jsp");
	}
}
