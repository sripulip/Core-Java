package oopsConcepts;

import java.lang.reflect.Method;

public class ReflectionExample {

	public static final String testField = "initial value";

	public static void main(String[] args) {
		try {

			String className = "testPackage.ReflectionExample";
			Class<?> myClassObject = Class.forName(className);
			System.out.println(myClassObject);

			Method method = myClassObject
					.getMethod("testMethod", Integer.class);
			System.out.println(method);

			Object newObject = myClassObject.newInstance();
			Integer returnValue = (Integer) method.invoke(newObject, 10);
			System.out.println(returnValue);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public int testMethod(Integer a) {
		int y = 3 * a;
		return y;
	}

}
