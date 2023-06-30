package homework4;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class zadanie5 {
    public static void main(String[] args) {
        Deque<Integer> num1 = new LinkedList<>();
        num1.add(3);
        num1.add(2);
        num1.add(1);
        Deque<Integer> num2 = new LinkedList<>();
        num2.add(5);
        num2.add(4);
        num2.add(3);
        LinkedList<Integer> prodList = (LinkedList<Integer>) multiply(new LinkedList<>(num1), new LinkedList<>(num2));
        LinkedList<Integer> sumList = add(new LinkedList<>(num1), new LinkedList<>(num2));
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(prodList);
        System.out.println(sumList);
    }

    public static Deque<Integer> multiply(Deque<Integer> deque1, Deque<Integer> deque2) {
        int num1 = 0;
        int num2 = 0;
        int multiplier = 1;
        while (!deque1.isEmpty()) {
            num1 += deque1.removeLast() * multiplier;
            multiplier *= 10;
        }
        multiplier = 1;
        while (!deque2.isEmpty()) {
            num2 += deque2.removeLast() * multiplier;
            multiplier *= 10;
        }
        int result = num1 * num2;
        Deque<Integer> dequeResult = new LinkedList<>();
        while (result > 0) {
            dequeResult.addFirst(result % 10);
            result /= 10;
        }
        return dequeResult;
    }

    private static LinkedList<Integer> add(Deque<Integer> num1, Deque<Integer> num2) {
        Deque<Integer> num1Copy = new LinkedList<>(num1);
        Deque<Integer> num2Copy = new LinkedList<>(num2);
        int sum = toInt(num1Copy) + toInt(num2Copy);
        return toList(sum);
    }

    private static int toInt(Deque<Integer> deque) {
        int num = 0;
        int digit = 1;

        while (!deque.isEmpty()) {
            num += deque.removeLast() * digit;
            digit *= 10;
        }
        return num;
    }

    private static LinkedList<Integer> toList(int num) {
        LinkedList<Integer> list = new LinkedList<>();
        if (num == 0) {
            list.add(0);
        } else if (num < 0) {
            list.add(-1);
            num = -num;
        }
        while (num > 0) {
            list.addFirst(num % 10);
            num /= 10;
        }
        Collections.reverse(list);
        return list;
    }
}