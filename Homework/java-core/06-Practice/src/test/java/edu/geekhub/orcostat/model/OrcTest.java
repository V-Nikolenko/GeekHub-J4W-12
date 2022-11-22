package edu.geekhub.orcostat.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrcTest {
    @Test
    void default_orc_price_is_lada_vesta_sport() {
        final Orc orc = new Orc();

        assertEquals(10_000, orc.getPrice());
    }

    @Test
    void major_orc_price_can_differ_to_lada_vesta_sport() {
        final Orc orc = new Orc(30_000);

        assertEquals(30_000, orc.getPrice());
    }
}