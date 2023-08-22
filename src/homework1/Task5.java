package homework1;

import java.util.Scanner;

//Пользователь вводит с клавиатуры номер месяца (от
//1 до 12). В зависимости от полученного номера месяца
//программа выводит на экран надпись: Winter (если введено
//значение 1,2 или 12), Spring (если введено значение от 3
//до 5), Summer (если введено значение от 6 до 8), Autumn
//(если введено значение от 9 до 11).
//Если пользователь ввел значение не в диапазоне от 1
//до 12 требуется вывести сообщение об ошибке.

public class Task5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть номер місяця: ");
        int month = scanner.nextInt();

        if (month >= 1 && month <= 12) {
            String season;

            if (month == 1 || month == 2 || month == 12) {
                season = "Winter";
            } else if (month <= 5) {
                season = "Spring";
            } else if (month <= 8) {
                season = "Summer";
            } else {
                season = "Autumn";
            }

            System.out.println("Пора року: " + season);
        } else {
            System.out.println("Помилка: введіть номер місяця від 1 до 12.");
        }
    }
}
