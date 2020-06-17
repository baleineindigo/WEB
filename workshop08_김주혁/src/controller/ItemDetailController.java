package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import model.ItemDao;

public class ItemDetailController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int itemnum = Integer.parseInt(request.getParameter("itemNumber"));
		Item item = ItemDao.getInstance().getItem(itemnum);
		request.setAttribute("item", item);
		return new ModelAndView("itemDetail.jsp");
	}
}
