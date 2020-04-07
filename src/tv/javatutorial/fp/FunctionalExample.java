package tv.javatutorial.fp;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FunctionalExample {
    public static int sum(List<Integer> numbers, Predicate<Integer> selector) {
        return numbers.stream()
                .filter(selector)
                .reduce(0, Math::addExact);
    }

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 3, 7, 4, 8, 2, 9, 12);
        System.out.println(sum(values, e -> true));
        System.out.println(sum(values, e -> e % 2 == 0));
    }

}

