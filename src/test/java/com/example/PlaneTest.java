package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlaneTest {

    @Test
    public void testFlyEnoughFuel() {
        Plane plane = new Plane("A320", new Manufacturer("Airbus", "France"), 500.0, 0);
        plane.fly(100);
        assertEquals(50.0, plane.getFuelLevel()); // 100 км * 0.5 = 50 витрачено
        assertEquals(100, plane.getMileage());
    }

    @Test
    public void testFlyNotEnoughFuel() {
        Plane plane = new Plane("B737", new Manufacturer("Boeing", "USA"), 10.0, 0);
        plane.fly(100);
        assertEquals(10.0, plane.getFuelLevel()); // нічого не змінилось
        assertEquals(0, plane.getMileage());
    }

    @Test
    public void testRefuelLimit() {
        Plane plane = new Plane("B777", new Manufacturer("Boeing", "USA"), 14900.0, 0);
        plane.refuel(500);
        assertEquals(15000.0, plane.getFuelLevel()); // максимум
    }

    @Test
    public void testEqualsPlanes() {
        Manufacturer m = new Manufacturer("Boeing", "USA");
        Plane p1 = new Plane("737", m, 1000.0, 0);
        Plane p2 = new Plane("737", m, 2000.0, 100);
        assertEquals(p1, p2); // бо модель і виробник однакові
    }
}

