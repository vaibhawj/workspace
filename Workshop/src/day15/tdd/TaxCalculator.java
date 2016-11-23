package day15.tdd;

public class TaxCalculator {

	public double calculateTax(long monthlySalary, int age) {
		if (monthlySalary < 0 || age < 0) {
			throw new InvalidInputException("Monthly Salary/Age cannot be negative");
		}

		double tax = 0;
		double taxableSalary = monthlySalary + 0.0d;
		if (age >= 50) {
			taxableSalary = taxableSalary - percentageOf(taxableSalary, 10);
		}
		if (taxableSalary >= 10_001 && taxableSalary <= 50_000) {
			tax = percentageOf(taxableSalary, 10);
		} else if (taxableSalary >= 50_001 && taxableSalary <= 1_00000) {
			tax = percentageOf(taxableSalary, 15);
		} else if (taxableSalary > 1_00000) {
			tax = percentageOf(taxableSalary, 20);
		}

		return tax;

	}

	private double percentageOf(double monthlySalary, double percentage) {
		return (monthlySalary * percentage) / 100d;
	}

}
