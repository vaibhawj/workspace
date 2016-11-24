package day15.tdd;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TaxCalculatorTest {

	private TaxCalculator calculator;

	@Before
	public void setUp() throws Exception {
		calculator = new TaxCalculator();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = InvalidInputException.class)
	public void testCalculateTaxForNegativeSalary() {
		long monthlySalary = -5000;
		int age = 23;
		calculator.calculateTax(monthlySalary, age);
	}

	@Test(expected = InvalidInputException.class)
	public void testCalculateTaxForNegativeAge() {
		long monthlySalary = 5000;
		int age = -23;
		calculator.calculateTax(monthlySalary, age);
	}

	@Test(expected = InvalidInputException.class)
	public void testCalculateTaxForBothNegativeInput() {
		long monthlySalary = -5000;
		int age = -23;
		calculator.calculateTax(monthlySalary, age);
	}

	@Test()
	public void testCalculateTaxForSalaryLessThan10ThousandAndAgeLessThan50() {
		long monthlySalary = 5000;
		int age = 23;
		double tax = calculator.calculateTax(monthlySalary, age);

		Assert.assertEquals(0.0d, tax, 0.0d);
	}

	@Test()
	public void testCalculateTaxForSalaryLessThan10ThousandAndAgeMoreThan50() {
		long monthlySalary = 5000;
		int age = 53;
		double tax = calculator.calculateTax(monthlySalary, age);

		Assert.assertEquals(0.0d, tax, 0.0d);
	}

	@Test()
	public void testCalculateTaxForSalaryBetween10001And50000AndAgeLessThan50() {
		long monthlySalary = 15000;
		int age = 23;
		double expectedTax = (monthlySalary * 10) / 100;
		double tax = calculator.calculateTax(monthlySalary, age);

		Assert.assertEquals(expectedTax, tax, 0.0d);
	}

	@Test()
	public void testCalculateTaxForSalaryBetween10001And50000AndAgeMoreThan50() {
		long monthlySalary = 15000;
		int age = 53;
		double effectiveMonthlySalary = monthlySalary
				- ((monthlySalary * 10) / 100);
		double expectedTax = (effectiveMonthlySalary * 10) / 100;
		double tax = calculator.calculateTax(monthlySalary, age);

		Assert.assertEquals(expectedTax, tax, 0.0d);
	}

	@Test()
	public void testCalculateTaxForSalaryBetween10001And50000AndAgeEqualTo50() {
		long monthlySalary = 15000;
		int age = 50;
		double effectiveMonthlySalary = monthlySalary
				- ((monthlySalary * 10) / 100);
		double expectedTax = (effectiveMonthlySalary * 10) / 100;
		double tax = calculator.calculateTax(monthlySalary, age);

		Assert.assertEquals(expectedTax, tax, 0.0d);
	}

	@Test()
	public void testCalculateTaxForSalaryBetween50001And100000AndAgeLessThan50() {
		long monthlySalary = 50001;
		int age = 23;
		double effectiveMonthlySalary = monthlySalary;
		double expectedTax = (effectiveMonthlySalary * 15) / 100;
		double tax = calculator.calculateTax(monthlySalary, age);

		Assert.assertEquals(expectedTax, tax, 0.0d);
	}

	@Test()
	public void testCalculateTaxForSalaryBetween50001And100000AndAgeMoreThan50() {
		long monthlySalary = 50_001;
		int age = 53;
		double effectiveMonthlySalary = monthlySalary
				- ((monthlySalary * 10) / 100d);
		double expectedTax = (effectiveMonthlySalary * 10) / 100;
		double tax = calculator.calculateTax(monthlySalary, age);

		Assert.assertEquals(expectedTax, tax, 0.5d);
	}

	@Test()
	public void testCalculateTaxForSalaryGreaterThanOneLakhAndAgeMoreThan50() {
		long monthlySalary = 1_00001;
		int age = 53;
		double effectiveMonthlySalary = monthlySalary
				- ((monthlySalary * 10) / 100d);
		double expectedTax = (effectiveMonthlySalary * 15) / 100;
		double tax = calculator.calculateTax(monthlySalary, age);

		Assert.assertEquals(expectedTax, tax, 0.5d);
	}

	@Test()
	public void testCalculateTaxForSalaryGreaterThanTwoLakhAndAgeMoreThan50() {
		long monthlySalary = 2_00001;
		int age = 53;
		double effectiveMonthlySalary = monthlySalary
				- ((monthlySalary * 10) / 100d);
		double expectedTax = (effectiveMonthlySalary * 20) / 100;
		double tax = calculator.calculateTax(monthlySalary, age);

		Assert.assertEquals(expectedTax, tax, 0.5d);
	}

	@Test()
	public void testCalculateTaxForSalaryGreaterThanTwoLakhAndAgeEqual50() {
		long monthlySalary = 2_00001;
		int age = 50;
		double effectiveMonthlySalary = monthlySalary
				- ((monthlySalary * 10) / 100d);
		double expectedTax = (effectiveMonthlySalary * 20) / 100;
		double tax = calculator.calculateTax(monthlySalary, age);

		Assert.assertEquals(expectedTax, tax, 0.5d);
	}

	@Test()
	public void testCalculateTaxForSalaryGreaterThanTwoLakhAndAgeLessThan50() {
		long monthlySalary = 2_00001;
		int age = 23;
		double effectiveMonthlySalary = monthlySalary;
		double expectedTax = (effectiveMonthlySalary * 20) / 100;
		double tax = calculator.calculateTax(monthlySalary, age);

		Assert.assertEquals(expectedTax, tax, 0.5d);
	}

}
