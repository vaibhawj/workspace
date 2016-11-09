package day4.shoppingCart;

import java.util.List;

public interface Verifiable {

	public boolean validate();

	public List<Validation> getValidationMessages();

}
