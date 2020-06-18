package controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import model.ItemDao;

public class ItemInfoController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int itemnum = Integer.parseInt(request.getParameter("itemNumber"));

		
		
		boolean flag=ItemDao.getInstance().getItem(itemnum);
		PrintWriter out=  response.getWriter();		
		return null;
	}
}
