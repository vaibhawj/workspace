package day4.shoppingCart;

import java.util.List;

public class Order implements IVerifiable {

	private double totalAmount;

	List<Item> orderedItems;

	public Order(Cart cart) {
		orderedItems = cart.getItems();

		double totalAmount = 0;
		for (Item item : orderedItems) {
			totalAmount += item.getQuantity() * item.getProduct().getPrice();
		}
		this.totalAmount = totalAmount;
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Validation> getValidationMessages() {
		// TODO Auto-generated method stub
		return null;
	}

}
