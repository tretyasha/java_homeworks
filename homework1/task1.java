// Задание

// 1) Вычислить n-ое треугольного число (сумма чисел от 1 до n), n!
// (произведение чисел от 1 до n)
// 2) Вывести все простые числа от 1 до 1000
// 3) Реализовать простой калькулятор (+-/*)
// 4) (дополнительное задание) Задано уравнение вида q + w = e, q, w, e >= 0.
// Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69.
// Требуется восстановить выражение до верного равенства. Предложить хотя бы
// одно решение или сообщить, что его нет.
// Под знаком вопроса - всегда одинаковая ЦИФРА.
// Введите уравнение: ?? + ?? = 44
// Решение: 22 + 22 = 44

package homework1;

// Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)

import java.util.Scanner;

public class task1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp866");
        System.out.print("Введите число n: ");
        int n = sc.nextInt();
        int triangularNumber = 0;
        int factorial = 1;

        // Вычисление n-го треугольного числа
        for (int i = 1; i <= n; i++) {
            triangularNumber += i;
        }

        // Вычисление факториала числа n
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }

        System.out.println("n-ое треугольное число: " + triangularNumber);
        System.out.println("n!: " + factorial);
        sc.close();
    }
}