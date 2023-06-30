package homework6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class task10 {
    static NoteBook notebook1 = new NoteBook("HP", 8, 512, "Windows 10", "silver");
    static NoteBook notebook2 = new NoteBook("Dell", 16, 256, "Ubuntu", "black");
    static NoteBook notebook3 = new NoteBook("Lenovo", 4, 1024, "Windows 7", "red");
    static NoteBook notebook4 = new NoteBook("Apple", 8, 256, "macOS", "gold");
    static NoteBook notebook5 = new NoteBook("Asus", 16, 512, "Windows 10", "blue");

    public static void filterNotebooks(Set<NoteBook> notebooks) {
        try (Scanner scanner = new Scanner(System.in)) {
            Map<String, String> filters = new HashMap<>();
            System.out.println("Введите цифру, соответствующую необходимому критерию: ");
            System.out.println("1 - ОЗУ");
            System.out.println("2 - Объем ЖД");
            System.out.println("3 - Операционная система");
            System.out.println("4 - Цвет");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Введите минимальный объем ОЗУ:");
                    int ram = scanner.nextInt();
                    filters.put("ram", String.valueOf(ram));
                    break;
                case 2:
                    System.out.println("Введите минимальный объем ЖД:");
                    int hdd = scanner.nextInt();
                    filters.put("hdd", String.valueOf(hdd));
                    break;
                case 3:
                    System.out.println("Введите название операционной системы:");
                    String os = scanner.next();
                    filters.put("os", os);
                    break;
                case 4:
                    System.out.println("Введите цвет:");
                    String color = scanner.next();
                    filters.put("color", color);
                    break;
                default:
                    System.out.println("Некорректный выбор.");
                    return;
            }
            Set<NoteBook> filteredNotebooks = new HashSet<>();
            for (NoteBook notebook : notebooks) {
                boolean match = true;
                for (Map.Entry<String, String> entry : filters.entrySet()) {
                    switch (entry.getKey()) {
                        case "ram":
                            if (notebook.getRam() < Integer.parseInt(entry.getValue())) {
                                match = false;
                            }
                            break;
                        case "hdd":
                            if (notebook.getHdd() < Integer.parseInt(entry.getValue())) {
                                match = false;
                            }
                            break;
                        case "os":
                            if (!notebook.getOs().equals(entry.getValue())) {
                                match = false;
                            }
                            break;
                        case "color":
                            if (!notebook.getColor().equals(entry.getValue())) {
                                match = false;
                            }
                            break;
                    }
                }
                if (match) {
                    filteredNotebooks.add(notebook);
                }
            }

            System.out.println("Подходящие ноутбуки:");
            for (NoteBook notebook : filteredNotebooks) {
                System.out
                        .println(notebook.getBrand() + " " + notebook.getRam() + "GB RAM " + notebook.getHdd()
                                + "GB HDD " +
                                notebook.getOs() + " " + notebook.getColor());
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Set<NoteBook> notebooks = new HashSet<>();
        notebooks.add(notebook1);
        notebooks.add(notebook2);
        notebooks.add(notebook3);
        notebooks.add(notebook4);
        notebooks.add(notebook5);
        filterNotebooks(notebooks);
    }
}