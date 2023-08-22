package homework1;
import java.util.Random;
import java.util.Scanner;

//Напишите метод, сортирующий массив по убыванию
//или возрастанию в зависимости от выбора пользователя.

public class Task12 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int[] originalArray = new int[15];

        for (int i = 0; i < originalArray.length; ++i) {
            originalArray[i] = random.nextInt(-50, 50);
        }

        System.out.println("Оберіть тип сортування:");
        System.out.println("1. Зростання");
        System.out.println("2. Спадання");
        int choice = scanner.nextInt();

        if (choice == 1) {
            sortAscending(originalArray);
        } else if (choice == 2) {
            sortDescending(originalArray);
        } else {
            System.out.println("Некоректний вибір.");
        }

        System.out.println("Відсортований масив:");

        for (int num : originalArray) {
            System.out.print(num + " ");
        }
    }

    public static void sortAscending(int[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            for (int j = 0; j < array.length - i - 1; ++j) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void sortDescending(int[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            for (int j = 0; j < array.length - i - 1; ++j) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}