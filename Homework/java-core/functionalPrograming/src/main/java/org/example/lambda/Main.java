package org.example.lambda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // list of animals
        var animals = new ArrayList<Animal>();
        animals.add(new Animal("fish", false, true));
        animals.add(new Animal("kangaroo", true, false));
        animals.add(new Animal("rabbit", true, false));
        animals.add(new Animal("turtle", false, true));
        animals.add(new Animal("dolphin", true, true));

        // pass class that does check
        print(animals, Animal::canSwim, Animal::canHop);
    }

    private static void print(List<Animal> animals, CheckTrait checker, CheckTrait checke) {
        for (Animal animal : animals) {

            // General check
            if (checker.test(animal) && checke.test(animal))
                System.out.println(animal);
        }
        System.out.println();
    }
}
