package edu.geekhub.orcostat.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TrivialCollectionTest {
    @Test
    void can_create() {
        new TrivialCollection();
    }

    @Test
    void can_add_element() {
        TrivialCollection orcs = new TrivialCollection();

        orcs.add(new Orc());

        assertEquals(1, orcs.count());
    }

    @Test
    void can_add_two_elements() {
        TrivialCollection orcs = new TrivialCollection();

        orcs.add(new Orc());
        orcs.add(new Orc());

        assertEquals(2, orcs.count());
    }

    @Test
    void cannot_add_undefined_element() {
        TrivialCollection orcs = new TrivialCollection();

        IllegalArgumentException thrown = assertThrows(
            IllegalArgumentException.class,
            () -> orcs.add(null)
        );
        assertEquals("Object cannot be null", thrown.getMessage());
    }
}