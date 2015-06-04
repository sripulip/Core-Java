package oopsConcepts;

public class LambdaExpressionsExample2 {

	@FunctionalInterface
	interface IntegerMath {
		int math(int a, int b);

		default IntegerMath swap() {
			return (a, b) -> math(b, a);
		}
	}

	private static int apply(int a, int b, IntegerMath op) {
		return op.math(a, b);
	}

	public static void main(String... args) {

		IntegerMath addition = (a, b) -> a + b;
		IntegerMath subtraction = (a, b) -> a - b;
		IntegerMath multiplication = (a, b) -> a * b;
		IntegerMath division = (a, b) -> a / b;

		System.out.println(apply(40, 2, addition));
		System.out.println(apply(20, 10, subtraction));
		System.out.println(apply(20, 10, subtraction.swap()));
		System.out.println(apply(20, 10, multiplication));
		System.out.println(apply(20, 10, division));
	}
}
