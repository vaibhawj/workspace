package day22;

public class LambdaAndThis implements MyInt {

	public static void main(String[] args) {
		LambdaAndThis cont = new LambdaAndThis();
		cont.lambdaCall();
		cont.anonClassCall();
		cont.impClassCall();

	}

	private void impClassCall() {
		this.hello();

	}

	private void anonClassCall() {
		MyInt m = new MyInt() {

			@Override
			public void hello() {
				System.out.println(this + "says hello to anon inner class");

			}
		};

		m.hello();

	}

	private void lambdaCall() {
		MyInt m = () -> {
			System.out.println(this + "says hello to lambda");
		};
		m.hello();

	}

	@Override
	public void hello() {
		System.out.println(this + "says hello to impl class");

	}

}

@FunctionalInterface
interface MyInt {

	void hello();

}
