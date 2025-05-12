package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Airline {
    private String name;
    private List<Plane> planes;

    public Airline(String name) {
        this.name = name;
        this.planes = new ArrayList<>();
    }

    public void addPlane(Plane plane) {
        planes.add(plane);
    }

    public void removePlane(Plane plane) {
        planes.remove(plane);
    }

    public List<Plane> getPlanes() {
        return planes;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airline airline)) return false;
        return Objects.equals(name, airline.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
