package edu.geekhub.orcostat.model;

public class Orc {
    private static final int LADA_VESTA_SPORT_PRICE = 10_000;
    private final int price;

    public Orc() {
        this(LADA_VESTA_SPORT_PRICE);
    }

    public Orc(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
