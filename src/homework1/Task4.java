package homework1;
import java.util.Scanner;

//Пользователь вводит шестизначное число. Необходимо
//поменять в этом числе первую и шестую цифры, а также
//вторую и пятую цифры.
//Например, 723895 должно превратиться в 593827.
//Если пользователь ввел не шестизначное число требуется вывести сообщение об ошибке

public class Task4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть шестизначне число: ");
        String input = scanner.nextLine();

        if (input.length() != 6) {
            System.out.println("Помилка: введіть шестизначне число.");
        } else {
            char[] digits = input.toCharArray();

            char temp = digits[0];
            digits[0] = digits[5];
            digits[5] = temp;

            temp = digits[1];
            digits[1] = digits[4];
            digits[4] = temp;

            String newNumber = new String(digits);

            System.out.println("Результат: " + newNumber);
        }
    }
}