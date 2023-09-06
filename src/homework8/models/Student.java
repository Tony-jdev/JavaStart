package homework8.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Student {
    private String fullName;
    private int age;
    private String group;
    private int points;

    public Student(String fullName, int age, String group) {
        this.fullName = fullName;
        this.age = age;
        this.group = group;
    }

    public Student(String fullName, int age, String group, int points) {
        this(fullName, age, group);
        this.points = points;
    }

    public static List<Student> generateStudents(int count) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String[] fullName = new String[]{"Ivan", "Petro", "Oleg", "Sergey", "Anna", "Maria", "Ekaterina", "Yulia"};
            int age = (int) (Math.random() * 20);
            String group = "Group" + i;
            students.add(new Student(fullName[new Random().nextInt(8)] + " " + fullName[new Random().nextInt(8)], age, group));
        }
        return students;
    }

    public static List<Student> generateStudentsWithPoints(int count) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String[] fullName = new String[]{"Ivan", "Petro", "Oleg", "Sergey", "Anna", "Maria", "Ekaterina", "Yulia"};
            int age = (int) (Math.random() * 20);
            String group = "Group" + i;
            int points = (int) (Math.random() * 100);
            students.add(new Student(fullName[new Random().nextInt(8)] + " " + fullName[new Random().nextInt(8)], age, group, points));
        }
        return students;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
