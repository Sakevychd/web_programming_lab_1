package com.example;

import java.io.File;
import java.util.*;

public class Main {

    
    private static final Scanner scanner = new Scanner(System.in);
    private static final Airline airline = new Airline("My Airline");

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n===== Меню =====");
            System.out.println("1. Додати літак");
            System.out.println("2. Переглянути всі літаки");
            System.out.println("3. Політ (літак по ID)");
            System.out.println("4. Заправити літак");
            System.out.println("5. Експортувати літаки в файл");
            System.out.println("6. Імпортувати літаки з файлу");
            System.out.println("7. Вийти");
            System.out.print("Обери опцію: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addPlane();
                case "2" -> showAllPlanes();
                case "3" -> flyPlane();
                case "4" -> refuelPlane();
                case "5" -> exportPlanes();
                case "6" -> importPlanes();
                case "7" -> running = false;
                default -> System.out.println("Невірна опція.");
            }
        }

        System.out.println("Дякую за використання!");
    }

    private static void addPlane() {
        System.out.print("Модель літака: ");
        String model = scanner.nextLine();
        System.out.print("Назва виробника: ");
        String name = scanner.nextLine();
        System.out.print("Країна виробника: ");
        String country = scanner.nextLine();

        Manufacturer manufacturer = new Manufacturer(name, country);
        Plane plane = new Plane(model, manufacturer, 100.0, 0);
        airline.addPlane(plane);

        System.out.println("Літак додано.");
    }

    private static void showAllPlanes() {
        List<Plane> planes = airline.getPlanes();
        if (planes.isEmpty()) {
            System.out.println("Немає літаків.");
        } else {
            for (int i = 0; i < planes.size(); i++) {
                System.out.println("ID: " + i + " -> " + planes.get(i));
            }
        }
    }

    private static void flyPlane() {
        showAllPlanes();
        System.out.print("Введи ID літака для польоту: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (id >= 0 && id < airline.getPlanes().size()) {
            Plane plane = airline.getPlanes().get(id);
            try {
                plane.fly(100); // 100 км
                System.out.println("Літак пролетів 100 км.");
            } catch (Exception e) {
                System.out.println("Помилка: " + e.getMessage());
            }
        } else {
            System.out.println("Невірний ID.");
        }
    }

    private static void refuelPlane() {
        showAllPlanes();
        System.out.print("Введи ID літака для заправки: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (id >= 0 && id < airline.getPlanes().size()) {
            Plane plane = airline.getPlanes().get(id);
            plane.refuel(50); // заправляємо на 50 літрів
            System.out.println("Літак заправлено.");
        } else {
            System.out.println("Невірний ID.");
        }
    }

    private static void exportPlanes() {
        try {
            DataManager.exportToFile(airline.getPlanes(), new File("planes.json"));
            System.out.println("Експорт виконано.");
        } catch (Exception e) {
            System.out.println("Помилка експорту: " + e.getMessage());
        }
    }

    private static void importPlanes() {
        try {
            File importFile = new File("planesimport.json"); // <-- інший файл
    
            List<Plane> imported = DataManager.importFromFile(importFile);
    
            for (Plane p : imported) {
                airline.addPlane(p);
            }
    
            System.out.println("✅ Імпорт з 'planesimport.json' завершено. Додано " + imported.size() + " літаків.");
        } catch (Exception e) {
            System.out.println("❌ Помилка імпорту: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
}
