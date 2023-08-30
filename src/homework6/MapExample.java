package homework6;

import java.time.Month;
import java.util.*;

public class MapExample {

    public static void main(String[] args) {
        // Базовая работа с Map

        // a. Создать LinkedHashMap<Integer, String> (map1)
        LinkedHashMap<Integer, String> map1 = new LinkedHashMap<>();

        // b. Добавить в map значения всех месяцев года (номер месяца : название)
        for (int i = 1; i <= 12; i++) {
            map1.put(i, Month.of(i).name());
        }

        // c. Вывести на экран первый и последний месяц года (0 и 11)
        System.out.println(map1.get(1));
        System.out.println(map1.get(12));

        // d. Вставить на место 6-го месяца слово ‘ОТПУСК’, вывести на экран
        map1.put(6, "ОТПУСК");
        System.out.println(map1);

        // e. Создать HashMap<Integer, String> (map2)
        HashMap<Integer, String> map2 = new HashMap<>();

        // f. Вставить в map2 все значения map1
        map2.putAll(map1);

        // g. *Создать метод для вывода всех элементов map в консоль
        // (EntrySet< Integer, String >)

        // Вывести на экран map1, map2
        printMap(map1);
        printMap(map2);

        // h. *Создать map3 (ключ – имя студента (String), значение -контакты студента:
        // моб.тел, почта, скайп (Set<String>))
        Map<String, Set<String>> map3 = new HashMap<>();

        Set<String> contacts = new HashSet<>();
        contacts.add("+380951234567");
        contacts.add("example@mail.com");
        contacts.add("skype:example");
        map3.put("Иванов Иван Иванович", contacts);

        System.out.println(map3);
    }

    static void printMap(Map<Integer, String> map) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
