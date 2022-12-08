package org.example.lambda;

public class CheckIfHopper extends Object implements CheckTrait {
    public boolean test(Animal a) {
        return a.canHop();
    }
}
