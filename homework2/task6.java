package homework2;

// К калькулятору из предыдущего ДЗ добавить логирование.

import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class task6 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String expression = sc.nextLine();
        sc.close();

        Logger logger = Logger.getLogger("CalculatorLog");
        logger.setLevel(Level.INFO);
        logger.addHandler(new FileHandler("calculator.log"));

        logger.info("Выражение: " + expression);

        String[] parts;
        if (expression.contains("+")) {
            parts = expression.split("\\+");
            double result = Double.parseDouble(parts[0].trim()) + Double.parseDouble(parts[1].trim());
            logger.info("Результат: " + result);
            System.out.println("Результат: " + result);
        } else if (expression.contains("-")) {
            parts = expression.split("-");
            double result = Double.parseDouble(parts[0].trim()) - Double.parseDouble(parts[1].trim());
            logger.info("Результат: " + result);
            System.out.println("Результат: " + result);
        } else if (expression.contains("*")) {
            parts = expression.split("\\*");
            double result = Double.parseDouble(parts[0].trim()) * Double.parseDouble(parts[1].trim());
            logger.info("Результат: " + result);
            System.out.println("Результат: " + result);
        } else if (expression.contains("/")) {
            parts = expression.split("/");
            double result = Double.parseDouble(parts[0].trim()) / Double.parseDouble(parts[1].trim());
            logger.info("Результат: " + result);
            System.out.println("Результат: " + result);
        } else {
            logger.warning("Некорректное выражение");
            System.out.println("Некорректное выражение");
        }
    }
}