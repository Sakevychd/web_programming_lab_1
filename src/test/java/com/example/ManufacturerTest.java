package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ManufacturerTest {

    @Test
    public void testConstructorAndGetters() {
        Manufacturer m = new Manufacturer("Boeing", "USA");
        assertEquals("Boeing", m.getName());
        assertEquals("USA", m.getCountry());
    }

    @Test
    public void testSetters() {
        Manufacturer m = new Manufacturer("Test", "TestLand");
        m.setName("Airbus");
        m.setCountry("France");
        assertEquals("Airbus", m.getName());
        assertEquals("France", m.getCountry());
    }

    @Test
    public void testEqualsTrue() {
        Manufacturer m1 = new Manufacturer("Airbus", "France");
        Manufacturer m2 = new Manufacturer("Airbus", "France");
        assertEquals(m1, m2);
    }

    @Test
    public void testEqualsFalse() {
        Manufacturer m1 = new Manufacturer("Boeing", "USA");
        Manufacturer m2 = new Manufacturer("Airbus", "France");
        assertNotEquals(m1, m2);
    }

    @Test
    public void testHashCodeConsistency() {
        Manufacturer m1 = new Manufacturer("Boeing", "USA");
        Manufacturer m2 = new Manufacturer("Boeing", "USA");
        assertEquals(m1.hashCode(), m2.hashCode());
    }

    @Test
    public void testToStringContainsName() {
        Manufacturer m = new Manufacturer("Boeing", "USA");
        String result = m.toString();
        assertTrue(result.contains("Boeing"));
        assertTrue(result.contains("USA"));
    }

    @Test
    public void testNullNameOrCountry() {
        assertThrows(NullPointerException.class, () -> {
            new Manufacturer(null, "USA");
        });

        assertThrows(NullPointerException.class, () -> {
            new Manufacturer("Boeing", null);
        });
    }
}
