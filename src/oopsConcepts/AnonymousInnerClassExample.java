package oopsConcepts;

public class AnonymousInnerClassExample implements MyInterface {

	public static void main(String[] args) {

		MyInterface myClass = new MyInterface() {
			public void print() {
				System.out.println("Anonymous Inner Class");
			}
		};
		myClass.print();
	}

	@Override
	public void print() {
		System.out.println("Outside the inner class");

	}
}
