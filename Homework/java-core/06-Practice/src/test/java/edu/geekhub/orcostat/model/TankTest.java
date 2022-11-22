package edu.geekhub.orcostat.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TankTest {
    @Test
    void can_build_tank() {
        new Tank();
    }

    @Test
    void default_tank_price_is_3_000_000() {
        Tank tank = new Tank();

        assertEquals(3_000_000, tank.getPrice());
    }

    @Test
    void empty_tank_has_zero_equipage() {
        Tank tank = new Tank();

        int count = tank.getEquipage().count();

        assertEquals(0, count);
    }

    @Test
    void tank_can_have_some_equipage() {
        TrivialCollection equipage = new TrivialCollection();
        equipage.add(new Orc());
        Tank tank = new Tank(equipage);

        int count = tank.getEquipage().count();

        assertEquals(1, count);
    }

    @Test
    void riding_tank_equipage_is_not_more_than_six_orcs() {
        TrivialCollection equipage = new TrivialCollection();
        for (int i = 0; i < 7; i++) {
            equipage.add(new Orc());
        }

        assertThrows(
            IllegalArgumentException.class,
            () -> new Tank(equipage)
        );
    }
}