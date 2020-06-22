package controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import model.Item;
import model.ItemDao;

public class ProductViewController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		Document document = Jsoup.connect(request.getParameter("producturl")).get();
		System.out.println(document);
		System.out.println("------------------------");
		Elements imageParentNode = document.select("ul[class=product_thumb]");
		for (Element li : imageParentNode) {
			System.out.println(li.select("img"));
		}
		request.setAttribute("list", imageParentNode);
		return new ModelAndView("productListView.jsp");
	}
}
