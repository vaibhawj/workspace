package day22;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Stream {

	public static void main(String[] args) {
		Predicate<Transaction> p = (t) -> {
			return t.type.equals("Grocery");
		};

		Comparator<Transaction> c = (t1, t2) -> {
			return t2.value.compareTo(t1.value);
		};

		List<Transaction> list = new ArrayList<Stream.Transaction>();
		list.add(new Transaction(3, "Grocery", 26.5));
		list.add(new Transaction(6, "Grocery", 16.5));
		list.add(new Transaction(4, "Drinks", 86.5));
		list.add(new Transaction(2, "Grocery", 96.5));
		list.add(new Transaction(5, "Food", 156.5));
		list.add(new Transaction(1, "Grocery", 56.5));

		ArrayList<Transaction> resList = list.parallelStream().filter(p)
				.sorted(c).collect(Collectors.toCollection(ArrayList::new));

		System.out.println(list);
		System.out.println(resList);

		list.parallelStream().forEach((t) -> {
			System.out.println(t);
		});
	}

	static class Transaction {

		long id;

		String type;

		Double value;

		public Transaction(long id, String type, double v) {
			this.id = id;
			this.type = type;
			this.value = v;
		}

		@Override
		public String toString() {
			return "id=" + id + " type=" + type + " value=" + value.toString();
		}

	}

}
