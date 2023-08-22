package homework1;
import java.util.Random;

//В одномерном массиве, заполненном случайными
//числами, определить минимальный и максимальный
//элементы, посчитать количество отрицательных элементов, посчитать количество положительных элементов, посчитать количество нулей. Результаты вывести
//на экран.

public class Task9 {

    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];

        for (int i = 0; i < array.length; ++i) {
            array[i] = random.nextInt(-100, 100);
        }

        int min = array[0];
        int max = array[0];
        int negativeCount = 0;
        int positiveCount = 0;
        int zeroCount = 0;

        for (int num : array) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
            if (num < 0) {
                negativeCount++;
            } else if (num > 0) {
                positiveCount++;
            } else {
                zeroCount++;
            }
        }

        System.out.print("Масив: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println("\nМінімальний елемент: " + min);
        System.out.println("Максимальний елемент: " + max);
        System.out.println("Кількість від'ємних елементів: " + negativeCount);
        System.out.println("Кількість додатніх елементів: " + positiveCount);
        System.out.println("Кількість нульових елементів: " + zeroCount);
    }
}