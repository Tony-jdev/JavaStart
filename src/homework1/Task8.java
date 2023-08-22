package homework1;
import java.util.Scanner;

//Показать на экран таблицу умножения в диапазоне,
//указанном пользователем. Например, если пользователь
// указал 3 и 5, таблица может выглядеть так:
//        3*1 = 3 3*2 = 6 3*3 = 9 ………… 3* 10 = 30
//        ……………………………………………………
//        5*1 = 5 5 *2 = 10 5 *3 = 15 ………….

public class Task8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть початок діапазону: ");
        int number1 = scanner.nextInt();

        System.out.print("Введіть кінець діапазону: ");
        int number2 = scanner.nextInt();

        int start = Math.min(number1, number2);
        int end = Math.max(number1, number2);

        for (int i = start; i <= end; ++i) {
            for (int j = 1; j <= 10; j++) {
                System.out.print(i + " * " + j + " = " + (i * j) + "\t");
            }
            System.out.println();
        }
    }
}