package tv.javatutorial.fp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream --> filter, sort, map..  --> forEach or Sum..
 */
public class StreamsExample {
    public static void main(String[] args) throws IOException {

        System.out.println("\n\n**Print 1 to 9");
        IntStream
            .range(1, 10)
            .forEach(System.out::println);


        System.out.println("\n\n**Sum elements");
        int sum = IntStream
                    .range(1, 10)
                    .sum();

        System.out.println("\n\n**Dog names start with F");
        String [] dogs = {"Mowgli", "Fly", "Fido", "Simba", "Archie", "Bear"};
        Arrays.stream(dogs)
                .filter(d -> d.startsWith("F"))
                .sorted()
                .forEach(System.out::println);


        System.out.println("\n\n**Print all cities from file");
        Stream<String> lines = Files.lines(Paths.get("citystate.csv"));
        lines.map(row -> row.split(","))
                .forEach(cols -> System.out.println(cols[1] + "\t" + cols[0]));


        System.out.println("\n\n**Print all cities from OH");
        Stream<String> lines1 = Files.lines(Paths.get("citystate.csv"));
        lines1.map(row -> row.split(","))
                .filter(cols -> cols[1].equals("OH"))
                .forEach(cols -> System.out.println(cols[1] + "\t" + cols[0]));

    }
}
