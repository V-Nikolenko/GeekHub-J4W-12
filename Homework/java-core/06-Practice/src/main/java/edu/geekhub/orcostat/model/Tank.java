package edu.geekhub.orcostat.model;

public class Tank {
    private final TrivialCollection equipage;

    public Tank(TrivialCollection equipage) {
        if (equipage.count() > 6) {
            throw new IllegalArgumentException("Too many orcs");
        }

        this.equipage = equipage;
    }

    public Tank() {
        this(new TrivialCollection());
    }

    public TrivialCollection getEquipage() {
        return equipage;
    }

    public int getPrice() {
        return 3_000_000;
    }
}
