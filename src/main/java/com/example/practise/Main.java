package com.example.practise;

import com.example.practise.service.DeviceService;

import com.model.*;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import java.util.Locale;

@Component
public class Main {

    private final DeviceService service;

    public Main(DeviceService service) {
        this.service = service;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.println("""
            Project structure "practise":
            - Class ComputingMachine: base class, contains fields String serialNumber and double price.
            - Class Computer: extends ComputingMachine, contains fields int storageSize, String operatingSystem, int usbPorts, String brand.
            - Class Laptop: extends Computer, contains field String chassisMaterial, double batteryLife.
            - Class Tablet: extends Laptop, contains fields String screenType (allowed types: IPS, AMOLED, TFT, PLS, Retina, LCD, OLED), int mainCameraResolution.
            All numeric fields cannot be negative.
        """);

        while (true) {
            printMenu();
            if (!scanner.hasNextInt()) {
                System.out.println("You entered incorrect data. The answer should be int type.");
                scanner.nextLine();
                continue;
            }
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> addEmpty(scanner);
                case 2 -> addWithData(scanner);
                case 3 -> deleteObject(scanner);
                case 4 -> printAll();
                case 5 -> compareObjects(scanner);
                case 6 -> { System.out.println("The programme is finished."); return; }
                default -> System.out.println("You entered incorrect data.");
            }
        }
    }

    private void printMenu() {
        System.out.println("""
        Choose what you want to do:
        1. Add empty object.
        2. Add object with your data.
        3. Delete some object.
        4. Print all objects.
        5. Compare 2 objects.
        6. Exit.""");
    }

private void addEmpty(Scanner scanner) {
    if (service.listAll() == null) {
        System.out.println("Internal error: service returned null list.");
        return;
    }

    System.out.println("""
        Choose which object you want to create:
        1. Computer
        2. Laptop
        3. Tablet
    """);

    int type = readInt(scanner, "Enter number 1-3: ");
    ComputingMachine obj;

    switch (type) {
        case 1 -> obj = new Computer();
        case 2 -> obj = new Laptop();
        case 3 -> obj = new Tablet();
        default -> {
            System.out.println("Incorrect type, object not created.");
            return;
        }
    }

    service.add(obj);
    System.out.println("Added object: " + obj);
}


   private void addWithData(Scanner scanner) {
        System.out.println("""
        Choose which object you wanna create:
        1. Computer
        2. Laptop
        3. Tablet
        """);
    int type = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Enter serial number: ");
    String serialNumber = scanner.nextLine();

    double price;
    while (true) {
        System.out.print("Enter price: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Price must be a number.");
            scanner.nextLine();
            continue;
        }
        price = scanner.nextDouble();
        scanner.nextLine();
        if (price < 0) {
            System.out.println("Price cannot be negative.");
        } else {
            break;
        }
    }

    ComputingMachine obj;
    switch (type) {
        case 1 -> { // Computer
            int storageSize = readInt(scanner, "Enter storage size (GB): ");
            System.out.print("Enter operating system: ");
            String os = scanner.nextLine();
            int usbPorts = readInt(scanner, "Enter number of USB ports: ");
            System.out.print("Enter brand: ");
            String brand = scanner.nextLine();
            obj = new Computer(serialNumber, price, storageSize, os, usbPorts, brand);
        }
        case 2 -> { // Laptop
            int storageSize = readInt(scanner, "Enter storage size (GB): ");
            System.out.print("Enter operating system: ");
            String os = scanner.nextLine();
            int usbPorts = readInt(scanner, "Enter number of USB ports: ");
            System.out.print("Enter brand: ");
            String brand = scanner.nextLine();
            System.out.print("Enter chassis material: ");
            String chassis = scanner.nextLine();
            double batteryLife = readDouble(scanner, "Enter battery life (hours): ");
            obj = new Laptop(serialNumber, price, storageSize, os, usbPorts, brand, chassis, batteryLife);
        }
        case 3 -> { // Tablet
            int storageSize = readInt(scanner, "Enter storage size (GB): ");
            System.out.print("Enter operating system: ");
            String os = scanner.nextLine();
            int usbPorts = readInt(scanner, "Enter number of USB ports: ");
            System.out.print("Enter brand: ");
            String brand = scanner.nextLine();
            System.out.print("Enter chassis material: ");
            String chassis = scanner.nextLine();
            double batteryLife = readDouble(scanner, "Enter battery life (hours): ");
            String screenType;
            while (true) {
                System.out.print("Enter screen type (IPS, AMOLED, TFT, PLS, Retina, LCD, OLED): ");
                screenType = scanner.nextLine();
                if (screenType.matches("IPS|AMOLED|TFT|PLS|Retina|LCD|OLED")) break;
                System.out.println("Invalid screen type.");
            }
            int mainCamera = readInt(scanner, "Enter main camera resolution (MP): ");
            obj = new Tablet(serialNumber, price, storageSize, os, usbPorts, brand, chassis, batteryLife, screenType, mainCamera);
        }
        default -> {
            System.out.println("Incorrect type.");
            return;
        }
    }

    service.add(obj);
    System.out.println("Added object: " + obj);
}


private int readInt(Scanner scanner, String prompt) {
    int value;
    while (true) {
        System.out.print(prompt);
        if (!scanner.hasNextInt()) {
            System.out.println("Must be an integer.");
            scanner.nextLine();
            continue;
        }
        value = scanner.nextInt();
        scanner.nextLine();
        if (value < 0) {
            System.out.println("Value cannot be negative.");
        } else {
            break;
        }
    }
    return value;
}

private double readDouble(Scanner scanner, String prompt) {
    double value;
    while (true) {
        System.out.print(prompt);
        if (!scanner.hasNextDouble()) {
            System.out.println("Must be a number.");
            scanner.nextLine();
            continue;
        }
        value = scanner.nextDouble();
        scanner.nextLine();
        if (value < 0) {
            System.out.println("Value cannot be negative.");
        } else {
            break;
        }
    }
    return value;
}


    private void deleteObject(Scanner scanner) {
    var list = service.listAll();
    if (list.isEmpty()) {
        System.out.println("No objects to delete.");
        return;
    }

    int idx = readInt(scanner, "Enter index to delete: ");
    if (idx < 0 || idx >= list.size()) {
        System.out.println("Invalid index.");
        return;
    }

    ComputingMachine removed = (ComputingMachine) service.removeAt(idx);
    System.out.println("Deleted: " + removed);
}

    private void printAll() {
        var list = service.listAll();
        if (list.isEmpty()) { System.out.println("No objects."); return; }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + ": " + list.get(i));
        }
    }

    private void compareObjects(Scanner scanner) {
    System.out.println("Enter index of first object:");
    int idx1 = scanner.nextInt();
    System.out.println("Enter index of second object:");
    int idx2 = scanner.nextInt();
    scanner.nextLine();

    try {
        boolean eq = service.equalsByIndex(idx1, idx2);
        System.out.println("Objects are " + (eq ? "equal." : "not equal."));
    } catch (IndexOutOfBoundsException e) {
        System.out.println("Invalid indices.");
    }
}
}




