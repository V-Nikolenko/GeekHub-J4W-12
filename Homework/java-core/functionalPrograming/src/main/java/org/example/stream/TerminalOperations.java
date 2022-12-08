package org.example.stream;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TerminalOperations {
    public static void main(String[] args) {
        //Counting
//        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
//        System.out.println(s.count());// 3
//
//        Stream<String> infinitStream = Stream.generate(() -> "Some");
//        System.out.println(infinitStream.count());// not finished

//        Finding the Minimum and Maximum
//        Stream<String> minStream = Stream.of("monkey", "ape", "bonobo");
//        Optional<String> min = minStream.min((s1, s2) -> s1.length()-s2.length());
//        min.ifPresent(System.out::println); // ape

        //Finding a Value
//        Stream<String> findStream = Stream.of("monkey", "gorilla", "bonobo");
//        Stream<String> infinite = Stream.generate(() -> "chimp");

//        findStream.findAny().ifPresent(System.out::println);// monkey (usually)
//        infinite.findAny().ifPresent(System.out::println);
//
        //Matching
//        var list = List.of("monkey", "2", "chimp");
//        Stream<String> infiniteMatch = Stream.generate(() -> "chimp");
//        Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
//
//        System.out.println(list.stream().anyMatch(pred));//true
//        System.out.println(list.stream().allMatch(pred));//false
//        System.out.println(list.stream().noneMatch(pred));//false
//        System.out.println(infiniteMatch.anyMatch(pred));//true
//
        //Iterating
//        Stream<String> iteratingStream = Stream.of("Monkey", "Gorilla", "Bonobo");
//        iteratingStream.forEach(System.out::print); // MonkeyGorillaBonobo
//
        //Reducing
//        var array = new String[] { "w", "o", "l", "f" };
//        var result = "";
//        for (var ch: array) result = result + ch;
//        System.out.println(result); // wolf

//        Stream<String> streamReducing = Stream.of("w", "o", "l", "f");
//        String word = streamReducing.reduce("", (a, b) -> a + b);
//        System.out.println(word); // wolf
//
        //Collecting
        Stream<String> streamCollecting = Stream.of("w", "o", "l", "f");
        StringBuilder collectionResult = streamCollecting.collect(
                StringBuilder::new,
                StringBuilder::append,
                StringBuilder::append);
        System.out.println(collectionResult); // wolf
    }
}
