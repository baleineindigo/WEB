package domain;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Food {

	private String maker;
	private int price;
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Food [maker=" + maker + ", price=" + price + "]";
	}
	public Food(String maker, int price) {
		super();
		this.maker = maker;
		this.price = price;
	}
	
}
