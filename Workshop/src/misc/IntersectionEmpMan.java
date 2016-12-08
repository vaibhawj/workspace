package misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class IntersectionEmpMan {

	public static void main(String[] args) {

		List<Employee> listOfEmployees = new ArrayList<Employee>();
		listOfEmployees.add(new Employee("Vaibhaw"));
		listOfEmployees.add(new Employee("Kaushal"));
		listOfEmployees.add(new Employee("Bharat"));
		listOfEmployees.add(new Employee("Jenny"));
		listOfEmployees.add(new Employee("Rita"));

		List<Employee> listOfManagers = new ArrayList<Employee>();
		listOfManagers.add(new Employee("Kaushal"));
		listOfManagers.add(new Employee("Jenny"));

		Predicate<Employee> p = (t) -> {
			return !listOfManagers.contains(t);
		};
		Set<Employee> set = listOfEmployees.parallelStream().filter(p)
				.collect(Collectors.toSet());

		System.out.println(set);

	}

	static class Employee {

		String name;

		public Employee(String name) {
			this.name = name;
		}

		@Override
		public int hashCode() {
			return this.name.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if (null == obj)
				return false;

			if (!(obj instanceof Employee)) {
				return false;
			}

			return this.name.equals(((Employee) obj).name);
		}

		@Override
		public String toString() {
			return this.name;
		}

	}

}
