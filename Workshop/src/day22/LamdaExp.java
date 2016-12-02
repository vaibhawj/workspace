package day22;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LamdaExp {

	public static void main(String[] args) {

	}

	public static void main3(String[] args) {

		Predicate<String> p = (s) -> s.equals("abc");
		Consumer<String> c = (s) -> System.out.println(s);

		ArrayList<String> list = new ArrayList<String>();
		list.add("pqr");
		list.add("def");
		list.add("abc");
		list.add("xyz");

		list.forEach((t) -> {
			if (!p.test(t)) {
				c.accept(t);
			}
		});

	}

	public static void main1(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().getName());

		ExecutorService ex = Executors.newSingleThreadExecutor();
		CountDownLatch latch = new CountDownLatch(1);
		Runnable r = () -> {
			System.out.println(Thread.currentThread().getName()
					+ " hello lambda");
			latch.countDown();
		};

		ex.submit(r);

		latch.await();

		System.out.println(Thread.currentThread().getName());

	}

	public static void main2(String[] args) {

		Adder<Integer> intAdder = (x, y) -> {
			return x + y;
		};

		System.out.println(intAdder.add(5, 6));

		Adder<String> stringAdder = (s1, s2) -> {
			return s1 + s2;
		};

		System.out.println(stringAdder.add("a", "b"));

	}

	@FunctionalInterface
	interface Adder<T> {

		T add(T a, T b);

		default boolean hey(T o) {
			return this.equals(o);
		}

		boolean equals(Object obj);

		public int hashCode();

	}

}
