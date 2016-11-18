package day12;

import java.util.ArrayList;
import java.util.List;

public class GenericWildcards {

	public static void main(String[] args) {
		ArrayList<? super Parent> list1 = new ArrayList<>();

		list1.add(new Child());
		list1.add(new Parent());
		// list1.add(new GrandParent()); does not add

		ArrayList<Parent> list2 = new ArrayList<>();
		ArrayList<Child> list3 = new ArrayList<>();

		// extends will take whole list of certain type satisfying is a relation
		// with Type
		fun(list2);
		fun(list3);

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
