package ru.clevertec.sptreamApi;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApi {

    public static void main(String[] args) {

/* Find all words"HighLight" and Count they*/
        long count = Arrays.asList("Highlight", "High", "Light", "Highlight").stream()
                .filter(word -> word.equals("Highlight"))   // .filter("Highlight"::equals)
                .count();
        System.out.println("Quantity of words: " + count);

/* Find the first element and return it or Return "Zero"*/
        String maybeFirstElement = Stream.of("Highlight", "High", "Light", "Highlight")
                .findFirst()
                .orElse("Zero");
        System.out.println("The 1st element: " + maybeFirstElement);

/* Return string stream to integer stream, print all these integers, find max number and if it exists print it*/
        Stream.of("Highlight", "High", "Light", "Highlight")
                .map(word -> word.getBytes(StandardCharsets.UTF_8).length)
                .peek(element -> System.out.print(element + " "))
                .max(Integer::compare)
                .ifPresent(max -> System.out.println("\nMax: " + max));

/* Convert any word to char array and Print each array by the letters, and separate letters by spaces.*/
        Stream.of("Highlight", "High", "Light", "Highlight")
                .flatMap(element -> Stream.of(element.toCharArray()))
                .forEach(charArray -> {
                    for (int i=0; i<charArray.length; i++) {
                        System.out.print(charArray[i] + " " + (i==charArray.length-1? "\n" : ""));
                    }
                });

/* Skip 2 elements, limit the quantity of elements to 2, print the result*/
        Stream.of("Highlight", "High", "Light", "Highlight")
                .skip(2)
                .limit(2)
                .forEach(System.out::println);

/* Sort elements by the length, skip 2 elements, limit the quantity of elements to 2, print all, find min by lexico*/
        String maybeMinLengthWord = Stream.of("One", "Highlight", "High", "Light", "Two", "Highlight")
//                .sorted(String::compareTo)   // by the length // High Highlight Highlight Light One Two
//                .skip(2)
//                .limit(2)
//                .dropWhile(string -> string.equals("High"))   // ? didn't understand ? http://espressocode.top/stream-dropwhile-method-in-java-with-examples/
//                .takeWhile(string -> string.equals("High"))   // ? didn't understand ? http://espressocode.top/stream-takewhile-method-in-java-with-examples/
//                .distinct()
                .peek(System.out::println)
                .min(String::compareTo)
                .orElse("*** None ***");// by lexicographic
        System.out.println(maybeMinLengthWord);

/* Create intStream, convert it to new intStream with smaller scale (-50), print a new stream */
        IntStream.of(100, 200, 300, 400)
                .flatMap(value -> IntStream.of(value-50, value))
                .forEach(value -> System.out.print(value + " "));
    }
}
