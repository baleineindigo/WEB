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

public class MusinsaController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Document document = Jsoup.connect("https://store.musinsa.com/app/product/detail/577636/0").get();
		System.out.println(document);
		System.out.println("------------------------");
		document.select("p").forEach(System.out::println);
		Elements imageParentNode = document.select("ul[class=product_thumb]");
		for (Element image : imageParentNode) {
			System.out.println(image);
		}
		return null;
	}
}
