package com.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class DataManager {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void exportToFile(List<Plane> planes, File file) throws Exception {
        mapper.writeValue(file, planes);
    }

    public static List<Plane> importFromFile(File file) throws Exception {
        return mapper.readValue(file, new TypeReference<List<Plane>>() {});
    }
}
