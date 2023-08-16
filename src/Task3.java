import java.util.Scanner;

//Пользователь вводит с клавиатуры три цифры. Необходимо создать число, содержащее эти цифры. Например,
//если с клавиатуры введено 7, 3, 8, тогда нужно сформировать число 738.

public class Task3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть першу цифру: ");
        int number1 = scanner.nextInt();

        System.out.print("Введіть другу цифру: ");
        int number2 = scanner.nextInt();

        System.out.print("Введіть третю цифру: ");
        int number3 = scanner.nextInt();

        int number = number1 * 100 + number2 * 10 + number3;

        System.out.println("Отримане число: " + number);
    }
}
