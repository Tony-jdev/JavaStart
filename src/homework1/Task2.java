package homework1;
import java.util.Scanner;

//Пользователь вводит с клавиатуры два числа. Первое
//число — это значение, второе число процент, который
//необходимо посчитать. Например, мы ввели с клавиатуры
//50 и 10. Требуется вывести на экран 10 процентов от 50.
//Результат: 5

public class Task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть значення: ");
        double value = scanner.nextDouble();

        System.out.print("Введіть відсоток: ");
        double percent = scanner.nextDouble();

        double result = value * (percent / 100);

        System.out.println("Результат: " + result);
    }
}