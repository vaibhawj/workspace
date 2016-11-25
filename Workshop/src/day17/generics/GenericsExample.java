package day17.generics;

import java.util.List;

public class GenericsExample<T> {

	/* static */List<T> listG1 = null;
	static List<? extends Parent> listG2 = null;

	public static void main(String[] args) {

		List<Parent> listOfParent = null;
		List<GrandParent> listOfGrandParent = null;
		List<Child> listOfChild = null;

		superFun(listOfParent);
		superFun(listOfGrandParent);
		// superFun(list3);

		extendsFun(listOfParent);
		// extendsFun(list2);
		extendsFun(listOfChild);
	}

	public static void superFun(List<? super Parent> list) {
		list.add(new Parent());
		list.add(new Child());
		// list.add(new GrandParent());
	}

	public static void extendsFun(List<? extends Parent> list) {

		// list.add(new Parent());
		// list.add(new Child());
		// list.add(new GrandParent());

	}

	static class GrandParent {

	}

	static class Parent extends GrandParent {

	}

	static class Child extends Parent {

	}

}
