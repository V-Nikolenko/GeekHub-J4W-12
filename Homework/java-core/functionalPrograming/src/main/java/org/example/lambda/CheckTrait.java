package org.example.lambda;

@FunctionalInterface
public interface CheckTrait {
    boolean test(Animal a);
    default boolean test1(Animal a) {
        return false;
    };
}
