package homework5;

import java.util.*;

public class zadanie9 {
    private Map<String, Set<String>> contacts;

    public zadanie9() {
        contacts = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        if (contacts.containsKey(name)) {
            contacts.get(name).add(phoneNumber);
        } else {
            Set<String> phoneNumbers = new HashSet<>();
            phoneNumbers.add(phoneNumber);
            contacts.put(name, phoneNumbers);
        }
    }

    public void printAllContacts() {
        List<Map.Entry<String, Set<String>>> list = new ArrayList<>(contacts.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Set<String>>>() {
            @Override
            public int compare(Map.Entry<String, Set<String>> o1, Map.Entry<String, Set<String>> o2) {
                return o2.getValue().size() - o1.getValue().size();
            }
        });
        for (Map.Entry<String, Set<String>> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            zadanie9 phoneBook = new zadanie9();
            while (true) {
                System.out.println("1) Добавить контакт");
                System.out.println("2) Вывести всех");
                System.out.println("3) Выход");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Введите имя:");
                        String name = scanner.next();
                        System.out.println("Введите номер телефона:");
                        String phoneNumber = scanner.next();
                        phoneBook.addContact(name, phoneNumber);
                        break;
                    case 2:
                        phoneBook.printAllContacts();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Неверный выбор");
                        break;
                }
            }
        }
    }
}