package homework2;

// Пусть дан произвольный список целых чисел.
// 1) Нужно удалить из него чётные числа
// 2) Найти минимальное значение
// 3) Найти максимальное значение
// 4) Найти среднее значение

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class zadanie3 {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(8, 2, 3, 6, 9, 5));
        List<Integer> arrCopy = new ArrayList<>(arr);
        removeEvenNumbers(arrCopy);
        System.out.println("Список после удаления четных чисел: " + arrCopy);
        int min = findMin(arr);
        System.out.println("Минимальное значение: " + min);
        int max = findMax(arr);
        System.out.println("Максимальное значение: " + max);
        double average = findAverage(arr);
        System.out.println("Среднее значение: " + average);
    }

    // 1. Функция удаления четных чисел:
    public static void removeEvenNumbers(final List<Integer> list) {
        list.removeIf(n -> n % 2 == 0);
    }

    // 2. Функция нахождения минимального значения в списке:
    public static int findMin(final List<Integer> list) {
        int min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < min) {
                min = list.get(i);
            }
        }
        return min;
    }

    // 3. Функция нахождения максимального значения в списке:

    public static int findMax(final List<Integer> list) {
        int max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }

    // 4. Функция нахождения среднего значения:

    public static double findAverage(final List<Integer> list) {
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum / list.size();
    }
}