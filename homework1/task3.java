package homework1;

import java.util.Scanner;

// Реализовать простой калькулятор (+-/*)

public class task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String expression = sc.nextLine();
        sc.close();

        String[] parts;
        if (expression.contains("+")) {
            parts = expression.split("\\+");
            double result = Double.parseDouble(parts[0].trim()) + Double.parseDouble(parts[1].trim());
            System.out.println("Результат: " + result);
        } else if (expression.contains("-")) {
            parts = expression.split("-");
            double result = Double.parseDouble(parts[0].trim()) - Double.parseDouble(parts[1].trim());
            System.out.println("Результат: " + result);
        } else if (expression.contains("*")) {
            parts = expression.split("\\*");
            double result = Double.parseDouble(parts[0].trim()) * Double.parseDouble(parts[1].trim());
            System.out.println("Результат: " + result);
        } else if (expression.contains("/")) {
            parts = expression.split("/");
            double result = Double.parseDouble(parts[0].trim()) / Double.parseDouble(parts[1].trim());
            System.out.println("Результат: " + result);
        } else {
            System.out.println("Некорректное выражение");
        }
    }
}