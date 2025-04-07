import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class DataManagerTest {

    @Test
    public void testExportImport() throws Exception {
        List<Plane> planes = List.of(
            new Plane("737", new Manufacturer("Boeing", "USA"), 8000, 10000),
            new Plane("A320", new Manufacturer("Airbus", "France"), 10000, 30000)
        );

        File temp = File.createTempFile("planes", ".json");
        DataManager.exportToFile(planes, temp);

        List<Plane> imported = DataManager.importFromFile(temp);
        assertEquals(planes.size(), imported.size());
        assertEquals(planes.get(0).getModel(), imported.get(0).getModel());
    }
}