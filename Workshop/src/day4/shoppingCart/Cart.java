package day4.shoppingCart;

import java.util.List;

public class Cart {

	private List<Item> items;

	public Order generateOrder() {
		Order order = new Order(this);
		return order;
	}

	public List<Item> getItems() {
		return items;
	}

}
