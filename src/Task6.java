import java.util.Scanner;

//Пользователь вводит с клавиатуры количество метров. В зависимости от выбора пользователя программа
//переводит метры в мили, дюймы или ярды.

public class Task6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кількість метрів: ");
        double meters = scanner.nextDouble();

        System.out.println("Оберіть одиницю вимірювання для переводу:");
        System.out.println("1. Милі");
        System.out.println("2. Дюйми");
        System.out.println("3. Ярди");
        int choice = scanner.nextInt();

        double result;

        switch (choice) {
            case 1:
                result = meters * 0.000621371;
                System.out.println("Кількість миль: " + result);
                break;
            case 2:
                result = meters * 39.3701;
                System.out.println("Кількість дюймів: " + result);
                break;
            case 3:
                result = meters * 1.09361;
                System.out.println("Кількість ярдів: " + result);
                break;
            default:
                System.out.println("Помилка: оберіть коректний варіант.");
                break;
        }
    }
}
