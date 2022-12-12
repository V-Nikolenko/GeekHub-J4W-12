package org.example.stream;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperations {
    public static void main(String[] args) {
        //Filtering
//        Stream<String> filteringStream = Stream.of("monkey", "gorilla", "bonobo");
//        filteringStream.filter(x -> x.startsWith("m")).forEach(System.out::print); // monkey

//        //Distinct
//        Stream<String> streamDuplicates = Stream.of("duck", "duck", "duck", "goose");
//        streamDuplicates.distinct().forEach(System.out::print); // duckgoose

//        //Restricting
//        Stream<Integer> streamRestricting = Stream.iterate(1, n -> n + 1);
//        streamRestricting.skip(5)
//                .limit(2)
//                .forEach(System.out::print); // 67
//
//        //Mapping
//        Stream<String> steamMapping = Stream.of("monkey", "gorilla", "bonobo");
//        steamMapping.map(String::length)
//                .forEach(System.out::print); // 676
//
//        //Flat mapping
//        List<String> zero = List.of();
//        var one = List.of("Bonobo");
//        var two = List.of("Mama Gorilla", "Baby Gorilla");
//        Stream<List<String>> animals = Stream.of(zero, one, two);
//        animals.flatMap(Collection::stream)
//                .forEach(System.out::println);
//
//        //Sorting
//        Stream<String> sortStream = Stream.of("brown bear-", "grizzly-");
//        sortStream.sorted(Comparator.reverseOrder())
//                        .forEach(System.out::print);
//
//
//        //Peek
//        var streamPeek = Stream.of("black bear", "brown bear", "grizzly");
//        long count = streamPeek.filter(s -> s.startsWith("g"))
//                .peek(System.out::println)
//                .count();
//        System.out.println(count);
    }
}
