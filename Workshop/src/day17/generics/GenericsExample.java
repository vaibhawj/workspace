package day17.generics;

import java.util.List;

public class GenericsExample<T> {

	/* static */List<T> listG1 = null;
	static List<? extends Parent> listG2 = null;

	public static void main(String[] args) {

		List<Parent> list = null;
		List<GrandParent> list2 = null;
		List<Child> list3 = null;
		superFun(list);
		superFun(list2);
		// superFun(list3);

		extendsFun(list);
		// extendsFun(list2);
		extendsFun(list3);
	}

	public static void superFun(List<? super Parent> list) {
		list.add(new Parent());
		list.add(new Child());

	}

	public static void extendsFun(List<? extends Parent> list) {
		/*
		 * list.add(new Parent()); list.add(new Child()); list.add(new
		 * GrandParent());
		 */

	}

	static class GrandParent {

	}

	static class Parent extends GrandParent {

	}

	static class Child extends Parent {

	}

}
