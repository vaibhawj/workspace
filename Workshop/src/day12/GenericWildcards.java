package day12;

import java.util.ArrayList;

public class GenericWildcards {

	public static void main(String[] args) {
		ArrayList<? super Child> list1 = new ArrayList<>();
		ArrayList<? extends GrandParent> list2 = new ArrayList<>();

		list1.add(new Child());
		list1.add(new Parent());
		list1.add(new GrandParent());

		list2.add(new Child());
		list2.add(new Parent());
		list2.add(new GrandParent());

	}

	static class GrandParent {

	}

	static class Parent extends GrandParent {

	}

	static class Child extends Parent {

	}

}
