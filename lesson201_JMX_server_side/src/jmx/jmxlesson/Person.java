package jmx.jmxlesson;

import java.io.Serializable;

public class Person implements Serializable {
    private String name = "Alex";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
