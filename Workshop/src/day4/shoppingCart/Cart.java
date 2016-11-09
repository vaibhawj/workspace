package day4.shoppingCart;

public class Cart {

	public Order generateOrder() {
		Order order = new Order(this);
		return order;
	}

}
