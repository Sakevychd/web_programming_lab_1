import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
// test Plane
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


// test AirLine
public class AirlineTest {

    @Test
    public void testAddPlane() {
        Airline airline = new Airline("SkyHigh");
        Plane p = new Plane("A320", new Manufacturer("Airbus", "France"), 1000, 0);
        airline.addPlane(p);
        assertTrue(airline.getPlanes().contains(p));
    }

    @Test
    public void testRemovePlane() {
        Airline airline = new Airline("SkyHigh");
        Plane p = new Plane("A320", new Manufacturer("Airbus", "France"), 1000, 0);
        airline.addPlane(p);
        airline.removePlane(p);
        assertFalse(airline.getPlanes().contains(p));
    }

    @Test
    public void testSortPlanesByMileage() {
        Airline airline = new Airline("SkyHigh");
        Plane p1 = new Plane("B737", new Manufacturer("Boeing", "USA"), 1000, 30000);
        Plane p2 = new Plane("A320", new Manufacturer("Airbus", "France"), 1200, 10000);
        airline.addPlane(p1);
        airline.addPlane(p2);

        List<Plane> sorted = airline.getPlanes().stream()
            .sorted((a, b) -> Integer.compare(a.getMileage(), b.getMileage()))
            .toList();

        assertEquals(p2, sorted.get(0));
    }
}


// test Manufacturer

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
