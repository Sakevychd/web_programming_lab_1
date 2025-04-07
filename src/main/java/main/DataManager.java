import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DataManager {

    private static final ObjectMapper mapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT); // красивий JSON

    // Експорт списку літаків у JSON-файл
    public static void exportPlanesToFile(List<Plane> planes, File file) throws IOException {
        mapper.writeValue(file, planes);
    }

    // Імпорт списку літаків з JSON-файлу
    public static List<Plane> importPlanesFromFile(File file) throws IOException {
        return List.of(mapper.readValue(file, Plane[].class));
    }
}
