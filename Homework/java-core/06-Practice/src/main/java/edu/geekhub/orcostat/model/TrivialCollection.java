package edu.geekhub.orcostat.model;

import java.util.Arrays;
import java.util.Objects;

public class TrivialCollection {
    private Object[] data;

    public TrivialCollection() {
        data = new Object[0];
    }

    public void add(Object orc) {
        if (Objects.isNull(orc)) {
            throw new IllegalArgumentException("Object cannot be null");
        }

        data = Arrays.copyOf(data, data.length + 1);
        data[data.length - 1] = orc;
    }

    public int count() {
        return data.length;
    }

    public Object[] getData() {
        return data;
    }
}
