package day12;

import java.util.List;

public class GenericWildcards<T> {

	public static void main(String[] args) {
		List<Child> listOfChild = null;
		List<Parent> listOfParent = null;
		List<GrandParent> listOfGrandParent = null;

		// run(listOfChild);
		run(listOfParent);
		run(listOfGrandParent);

		fun(listOfChild);
		fun(listOfParent);
		// fun(listOfGrandParent);

	}

	public static void run(List<? super Parent> list) {

	}

	public static void fun(List<? extends Parent> list) {

	}

	static class GrandParent {

	}

	static class Parent extends GrandParent {

	}

	static class Child extends Parent {

	}

}
