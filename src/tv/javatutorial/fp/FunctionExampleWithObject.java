package tv.javatutorial.fp;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FunctionExampleWithObject {
    public static void main(String[] args) {
        List<Dog> dogs = Arrays.asList(
                new Dog("Mowgli", 5, 50),
                new Dog("Fly", 7, 20),
                new Dog("Fido", 12, 8),
                new Dog("Simba", 2, 90)
        );

        System.out.println("\n\nAll Dogs");
        print(dogs, d -> true);

        System.out.println("Dogs older 7 or older");
        print(dogs, d -> d.age >= 7);

        System.out.println("Dogs heavier than 20 pounds or more");
        print(dogs, d -> d.weight >= 20);
    }

    private static void print(List<Dog> dogs, Predicate<Dog> selector) {
        for (Dog dog : dogs) {
            if (selector.test(dog))
                System.out.println(dog);
        }
    }

}

class Dog {
    String name;
    int age;
    int weight;

    Dog(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return  age + "\t\t" + name + "\t\t" + weight;
    }
}
