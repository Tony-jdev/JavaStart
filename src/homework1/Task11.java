package homework1;
import java.util.Scanner;

//Напишите метод, который отображает горизонтальную или вертикальную линию из некоторого символа.
//Метод принимает в качестве параметра: длину линии,
//направление, символ.

public class Task11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length;
        char symbol;

        System.out.print("Введіть довжину лінії: ");
        length = scanner.nextInt();

        System.out.print("Введіть символ для лінії: ");
        symbol = scanner.next().charAt(0);

        System.out.println("Оберіть напрямок лінії:");
        System.out.println("1. Горизонтальний");
        System.out.println("2. Вертикальний");
        int choice = scanner.nextInt();

        if (choice == 1) {
            displayLine(length, Direction.HORIZONTAL, symbol);
        } else if (choice == 2) {
            displayLine(length, Direction.VERTICAL, symbol);
        } else {
            System.out.println("Некоректний вибір.");
        }
    }

    enum Direction {
        HORIZONTAL,
        VERTICAL
    }

    public static void displayLine(int length, Direction direction, char symbol) {
        if (length <= 0) {
            System.out.println("Довжина лінії має бути більше 0.");
            return;
        }

        if (direction == Direction.HORIZONTAL) {
            for (int i = 0; i < length; ++i) {
                System.out.print(symbol);
            }
        } else if (direction == Direction.VERTICAL) {
            for (int i = 0; i < length; ++i) {
                System.out.println(symbol);
            }
        }
    }
}