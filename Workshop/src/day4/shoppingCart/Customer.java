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
			printNotification(order);
			return orderStatus;
		}

		Payment payment = new Payment(this, order);
		boolean paymentStatus = payment.doPayment();
		if (!paymentStatus) {
			printNotification(payment);
			return paymentStatus;

		}
		return paymentStatus;

	}

	private void printNotification(IVerifiable verifiableObject) {
		for (Validation v : verifiableObject.getValidationMessages()) {
			v.print();
		}
	}

}
