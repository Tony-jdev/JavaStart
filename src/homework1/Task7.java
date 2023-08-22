package homework1;

import java.util.Scanner;

//Пользователь вводит с клавиатуры два числа. Нужно
//показать все нечетные числа в указанном диапазоне. Если
//границы диапазона указаны неправильно требуется произвести нормализацию границ. Например, пользователь
//ввел 20 и 11, требуется нормализация, после которой
//начало диапазона станет равно 11, а конец 20.

public class Task7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть перше число: ");
        int number1 = scanner.nextInt();

        System.out.print("Введіть друге число: ");
        int number2 = scanner.nextInt();

        int start = Math.min(number1, number2);
        int end = Math.max(number1, number2);

        System.out.println("Непарні числа в діапазоні " + start + " - " + end + ":");

        for (int i = start; i <= end; ++i) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }
}
