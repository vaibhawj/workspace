package day4.shoppingCart;

public class Customer {

	private Cart cart;

	public Order createOrder() {
		return cart.generateOrder();
	}

	public boolean checkOut() {
		Order order = this.createOrder();
		boolean orderStatus = order.validate();
		if (!orderStatus) {
			for (Validation v : order.getValidationMessages()) {
				v.print();
			}
			return orderStatus;
		}

		Payment payment = new Payment(this, order);
		boolean paymentStatus = payment.doPayment();
		if (!paymentStatus) {
			for (Validation v : payment.getValidationMessages()) {
				v.print();
			}
			return paymentStatus;

		}
		return paymentStatus;

	}

}
