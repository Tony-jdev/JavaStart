package wrappers;

import java.util.Scanner;

public class StringTest {

    public static void main(String[] args) {
        // Створення різних рядків
        String str1 = "Hello, world!";
        String str2 = new String("Java programming");
        char[] charArray = {'H', 'e', 'l', 'l', 'o'};
        String str3 = new String(charArray);
        byte[] byteArray = {65, 66, 67, 68};
        String str4 = new String(byteArray);
        StringBuilder stringBuilder = new StringBuilder("StringBuilder");

        // Робота з рядками
        String fruits = "Апельсин,Яблоко,Гранат,Груша";
        String[] fruitArray = fruits.split(",");
        String longestFruit = "";
        for (String fruit : fruitArray) {
            if (fruit.length() > longestFruit.length()) {
                longestFruit = fruit;
            }
        }
        System.out.println("Найдовший фрукт: " + longestFruit.toLowerCase());

        for (String fruit : fruitArray) {
            String shortName = fruit.substring(0, 3);
            System.out.println("Скорочене назва фрукту: " + shortName);
        }

        String spacedString = "   Я_нова_строка      ";
        spacedString = spacedString.trim();
        spacedString = spacedString.replace('_', ' ');
        System.out.println(spacedString);

        // Робота з Scanner
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть текст: ");
        String userInput = scanner.nextLine();
        System.out.println("Ви ввели: " + userInput);

        if (userInput.startsWith("Запуск")) {
            System.out.println("Запускаємо процес");
        }
        if (userInput.endsWith("завершен")) {
            System.out.println("Процес завершений");
        }
        if (userInput.toLowerCase().contains("ошибка")) {
            System.out.println("Сталася помилка");
        }

        // Робота з StringBuilder
        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append(str1).append("\n");
        resultBuilder.append(str2).append("\n");
        resultBuilder.append(str3).append("\n");
        resultBuilder.append(str4).append("\n");
        resultBuilder.append(stringBuilder).append("\n");

        StringBuilder finalBuilder = new StringBuilder();
        String[] resultLines = resultBuilder.toString().split("\n");
        for (int i = 0; i < resultLines.length; i++) {
            finalBuilder.append(resultLines[i]);
            if ((i + 1) % 3 == 0) {
                finalBuilder.append("\n");
            }
        }

        String reversedResult = finalBuilder.reverse().toString();
        System.out.println(reversedResult);
    }
}
