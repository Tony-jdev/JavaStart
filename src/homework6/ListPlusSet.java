package homework6;

import java.util.*;

public class ListPlusSet {

    public static void main(String[] args) {
        //1. _______Базовая работа с List________

        //a. Создать ArrayList<String> (list1)
        ArrayList<String> list1 = new ArrayList<>();

        //b. Создать массив строк. Добавить в список все элементы массива (одним методом)
        String[] strings = {"a", "b", "c", "d", "e"};
        list1.addAll(Arrays.asList(strings));

        //c. Создать новый (list2) ArrayList<String>, принициализировав его предыдущим списком
        ArrayList<String> list2 = new ArrayList<>(list1);

        //d. Создать список (list3) используя Arrays.asList(…)
        String[] strings2 = {"f", "g", "h"};
        List<String> list3 = Arrays.asList(strings2);

        //e. Вставить list3 в середину list2
        list2.addAll(list2.size() / 2, list3);

        //f. Отсортировать список по убыванию
        Collections.sort(list2, Collections.reverseOrder());

        //g. Удалить каждый второй элемент списка используя listiterator
        int count = 0;
        System.out.println("list2 до видалення: " + list2);
        ListIterator<String> listIterator = list2.listIterator();
        while (listIterator.hasNext()) {
            listIterator.next();
            ++count;
            if (count == 2) {
                listIterator.remove();
                count = 0;
            }
        }

        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);

        //2. ________Базовая работа с Set________

        //a. Создать HashSet<String> (set1)
        Set<String> set1 = new HashSet<>();

        //b. Вставить в set 2 произвольные строки
        set1.add("a");
        set1.add("b");

        //c. Вставить в set все элементы из list1 и list2
        set1.addAll(list1);
        set1.addAll(list2);

        //d. Вывести на экран значения set-a
        System.out.println("set1: " + set1);

        //e. Создать LinkedHashSet<String> (set2)
        Set<String> set2 = new LinkedHashSet<>();

        //f. Вставить в set все элементы из list2 и list3
        set2.addAll(list2);
        set2.addAll(list3);

        //g. Вывести на экран значения set-a
        System.out.println("set2: " + set2);
    }
}
