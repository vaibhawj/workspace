package day17;

public class AnimalAndHorse {

	public static void main(String[] args) {
		AnimalAndHorse o = new AnimalAndHorse();
		Animal a = new Horse();
		o.doStuff(a);
	}

	public void doStuff(Animal a) {
		System.out.println("Animal");
	}

	public void doStuff(Horse h) {
		System.out.println("Horse");
	}

	static class Animal {

	}

	static class Horse extends Animal {

	}

}
