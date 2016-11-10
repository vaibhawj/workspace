package day4.shoppingCart;

import java.util.List;

public interface IVerifiable {

	public boolean validate();

	public List<Validation> getValidationMessages();

}
