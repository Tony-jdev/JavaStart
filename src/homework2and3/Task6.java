package homework2and3;

import java.util.Objects;
import java.util.Scanner;

//Реализуйте класс «Автомобиль». Необходимо хранить
//в полях класса: название автомобиля, название производителя, год выпуска, объём двигателя. Реализуйте конструкторы и методы класса для ввода данных, вывода данных,
//реализуйте доступ к отдельным полям через методы класса.
//Используйте механизм перегрузки методов.

public class Task6 {

    public static class Car {
        private String name;
        private String manufacturer;
        private int year;
        private double engine;

        public Car() {
            this("", "", 0, 0);
        }

        public Car(String name) {
            this(name, "", 0, 0);
        }

        public Car(String name, String manufacturer) {
            this(name, manufacturer, 0, 0);
        }

        public Car(String name, String manufacturer, int year) {
            this(name, manufacturer, year, 0);
        }

        public Car(String name, String manufacturer, int year, int engine) {
            this.name = name;
            this.manufacturer = manufacturer;
            this.year = year;
            this.engine = engine;
        }

        private boolean isValidYear(String input) {
            try {
                int number = Integer.parseInt(input);
                return number >= 0;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        private boolean isValidEngine(String input) {
            try {
                double number = Double.parseDouble(input);
                return number >= 0;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        public void inputDetails() {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Введіть назву автомобіля: ");
            setName(scanner.nextLine());

            System.out.print("Введіть назву виробника автомобіля: ");
            setManufacturer(scanner.nextLine());

            String yearInput;
            do {
                System.out.print("Введіть рік випуску автомобіля: ");
                yearInput = scanner.nextLine();
            } while (!isValidYear(yearInput));
            setYear(Integer.parseInt(yearInput));

            String engineInput;
            do {
                System.out.print("Введіть об'єм двигуна автомобіля: ");
                engineInput = scanner.nextLine();
            } while (!isValidEngine(engineInput));
            setEngine(Double.parseDouble(engineInput));
        }

        public void showDetails() {
            System.out.println("Назва автомобіля: " + this.name);
            System.out.println("Назва виробника автомобіля: " + this.manufacturer);
            System.out.println("Рік випуску автомобіля: " + this.year);
            System.out.println("Об'єм двигуна автомобіля: " + this.engine);
        }

        @Override
        public String toString() {
            return "Car{" +
                    "name='" + name + '\'' +
                    ", manufacturer='" + manufacturer + '\'' +
                    ", year=" + year +
                    ", engine=" + engine +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Car car = (Car) o;
            return name.equals(car.name) &&
                    manufacturer.equals(car.manufacturer) &&
                    year == car.year &&
                    engine == car.engine;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, manufacturer, engine, year);
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public void setEngine(double engine) {
            this.engine = engine;
        }

        public String getName() {
            return this.name;
        }

        public String getManufacturer() {
            return this.manufacturer;
        }

        public int getYear() {
            return this.year;
        }

        public double getEngine() {
            return this.engine;
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.inputDetails();

        System.out.println("\nВведені дані:");
        System.out.println(car);
        System.out.println();

        Car car1 = new Car();
        car1.inputDetails();

        System.out.println("\nЧи об'єкти однакові:");
        System.out.println(car.equals(car1));
    }
}
