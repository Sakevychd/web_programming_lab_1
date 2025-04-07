import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

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
