package controller;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MusinsaParser {

	public static void main(String[] args) throws IOException {

		Document document = Jsoup.connect("https://store.musinsa.com/app/product/detail/577636/0").get();
		System.out.println(document);
		System.out.println("------------------------");
		Elements imageParentNode = document.select("ul[class=product_thumb]");
		for (Element li : imageParentNode) {
			System.out.println(li.select("img"));
		}
	}

}


////image.msscdn.net/images/goods_img/20170615/577636/577636_4_60.jpg
