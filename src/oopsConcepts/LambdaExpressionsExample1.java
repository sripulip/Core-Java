package oopsConcepts;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaExpressionsExample1 {

    public static int calculateSomething(List<Integer> values,
                                         Predicate<Integer> selector) {

        return values.stream()
                .filter(selector)
                .map(num -> num * 2)
                .reduce(0, (num, sum) -> num + sum);

    }

    public static void main(String[] args) {

        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6);

        System.out.println(calculateSomething(values, num -> true));
        System.out.println(calculateSomething(values, num -> num % 2 == 0));
        System.out.println(calculateSomething(values, num -> num % 2 != 0));
    }

}
