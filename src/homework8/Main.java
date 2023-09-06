package homework8;

import homework8.models.Car;
import homework8.models.Employee;
import homework8.models.Student;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Car> cars = Car.generateCars(100);

        Car fastestCar = (Car) cars.stream()
                .max(Comparator.comparingInt(Car::getMaxSpeed))
                .get();

        if (fastestCar != null) {
            System.out.println("Найшвидший автомобіль: " + fastestCar.getName());
        } else {
            System.out.println("Не знайдено найшвидшого автомобіля");
        }


        List<Student> students = Student.generateStudents(100);
        List<String> studentsUnder16 = students.stream()
                .filter(student -> student.getAge() < 16)
                .map(student -> student.getFullName().split(" ")[1])
                .collect(Collectors.toList());
        System.out.println("Прізвища всіх студентів молодших 16 років: " + studentsUnder16);


        List<Student> studentsWithPoints = Student.generateStudentsWithPoints(100);
        double averagePoints = studentsWithPoints.stream()
                .mapToInt(student -> student.getPoints())
                .average()
                .getAsDouble();
        System.out.println("Середній бал всіх студентів: " + averagePoints);


        List<Employee> employees = studentsWithPoints.stream()
                .map(student -> new Employee(student.getFullName().split(" ")[0], student.getFullName().split(" ")[1], "", student.getAge()))
                .collect(Collectors.toList());
        System.out.println("Список працівників: " + employees);
    }
}
