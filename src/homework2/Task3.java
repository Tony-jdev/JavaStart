package homework2;

import java.util.ArrayList;
import java.util.Scanner;

//Создайте класс «Страна». Необходимо хранить в полях
//класса: название страны, название континента, количество жителей в стране, телефонный код страны, название
//столицы, название городов страны. Реализуйте методы
//класса для ввода данных, вывода данных, реализуйте
//доступ к отдельным полям через методы класса.

public class Task3 {

    public static class Country {
        private String countryName;
        private String continent;
        private int population;
        private String phoneCode;
        private String capitalCity;
        private ArrayList<String> cities;

        private boolean isValidPopulation(String input) {
            try {
                int population = Integer.parseInt(input);
                return population >= 0;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        public void inputDetails() {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Введіть назву країни: ");
            setCountryName(scanner.nextLine());

            System.out.print("Введіть назву континента: ");
            setContinentName(scanner.nextLine());

            String populationInput;
            do {
                System.out.print("Введіть кількість жителів: ");
                populationInput = scanner.nextLine();
            } while (!isValidPopulation(populationInput));
            setPopulation(Integer.parseInt(populationInput));

            System.out.print("Введіть телефонний код: ");
            setPhoneCode(scanner.nextLine());

            System.out.print("Введіть назву столиці: ");
            setCapitalCity(scanner.nextLine());

            cities = new ArrayList<>();
            System.out.println("Введіть назви міст (для завершення введіть '0'):");
            while (true) {
                String cityName = scanner.nextLine();
                if (cityName.equals("0")) {
                    break;
                }
                cities.add(cityName);
            }
        }

        public void showDetails() {
            System.out.println("Назва країни: " + getCountryName());
            System.out.println("Назва континента: " + getContinentName());
            System.out.println("Кількість жителів: " + getPopulation());
            System.out.println("Телефонний код: " + getPhoneCode());
            System.out.println("Столиця: " + getCapitalCity());
            System.out.println("Міста: " + getCities());
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        public void setContinentName(String continentName) {
            this.continent = continentName;
        }

        public void setPopulation(int population) {
            this.population = population;
        }

        public void setPhoneCode(String phoneCode) {
            this.phoneCode = phoneCode;
        }

        public void setCapitalCity(String capitalCity) {
            this.capitalCity = capitalCity;
        }

        public void setCities(ArrayList<String> cities) {
            this.cities = cities;
        }

        public String getCountryName() {
            return countryName;
        }

        public String getContinentName() {
            return continent;
        }

        public int getPopulation() {
            return population;
        }

        public String getPhoneCode() {
            return phoneCode;
        }

        public String getCapitalCity() {
            return capitalCity;
        }

        public ArrayList<String> getCities() {
            return cities;
        }
    }

    public static void main(String[] args) {
        Country country = new Country();
        country.inputDetails();

        System.out.println("\nВведені дані:");
        country.showDetails();
    }
}
