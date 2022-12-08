package org.example.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
//        //Empty Stream
//        var stringStream = streamOf(Collections.emptyList());
//
//        //Stream of Collection
//        Collection<String> collection = Arrays.asList("a", "b", "c");
//        Stream<String> streamOfCollection = collection.stream();
//
//        //Stream of Array
//        String[] arr = new String[]{"a", "b", "c"};
//        Stream<String> streamOfArrayFull = Arrays.stream(arr);
//        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
//
//        //Stream.builder()
//        Stream<String> streamBuilder = Stream.<String>builder()
//                .add("a")
//                .add("b")
//                .add("c")
//                .build();
//
//        //Stream.generate()
//        Stream<String> streamGenerated =
//                Stream.generate(() -> "element").limit(10);
//
//        //Stream.iterate()
//        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);
//
//        //Stream of Primitives
//        IntStream intStream = IntStream.range(1, 3);
//        LongStream longStream = LongStream.rangeClosed(1, 3);

        //--------------------------------------------------------------------------------------------------------------
        List<String> collect = Stream.of("a", "b", "c").filter(element -> element.contains("b")).collect(Collectors.toList());
        Optional<String> anyElement = collect.stream().findAny();
        System.out.println(anyElement);

        Optional<String> firstElement = collect.stream().findFirst(); //IllegalStateException
    }

    public static Stream<String> streamOf(List<String> list) {
        return list == null || list.isEmpty() ? Stream.empty() : list.stream();
    }
}
