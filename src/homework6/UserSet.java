package homework6;

import homework6.models.User;

import java.util.HashSet;

public class UserSet {
    public static void main(String[] args) {
        //b. Создать userSet (HashSet<User> )
        HashSet<User> userSet = new HashSet<>();

        //c. Создать 2 экземпляра класса User с одинаковыми полями и 1 экземпляр отличающийся возрастом
        User user1 = new User("Ivan", 25, "1234567890");
        User user2 = new User("Ivan", 25, "1234567890");
        User user3 = new User("Petr", 26, "1234567890");

        //d. Добавить пользователей в userSet
        userSet.add(user1);
        userSet.add(user2);
        userSet.add(user3);

        //e. Вывести пользователей на экран
        System.out.println("До переопределения метода hashcode:");
        for (User user : userSet) {
            System.out.println(user);
        }

        //g Вывести пользователей на экран
        System.out.println("После переопределения метода hashcode, Указав в нем все поля класса:");
        for (User user : userSet) {
            System.out.println(user);
        }

        //i Вывести пользователей на экран
        System.out.println("После переопределения метода hashcode, Указав в нем все поля класса:");
        for (User user : userSet) {
            System.out.println(user);
        }
    }
}
