package edu.geekhub.homework.hw1;

import edu.geekhub.homework.hw1.EvenIndexIterable;

public class ApplicationStarter {


    public static void main(String[] args) {
        EvenIndexIterable<Integer> integers = new EvenIndexIterable<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);

        for (Integer integer : integers)
            System.out.println(integer);
    }
    // Write code here :)
}
