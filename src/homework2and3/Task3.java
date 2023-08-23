package homework2and3;

import java.util.ArrayList;
import java.util.Objects;
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

        public Country() {}

        public Country(String countryName) {
            this.countryName = countryName;
        }

        public Country(String countryName, String continent) {
            this(countryName);
            this.continent = continent;
        }

        public Country(String countryName, int population) {
            this(countryName);
            this.population = population;
        }

        public Country(String countryName, String continent, int population) {
            this(countryName, continent);
            this.population = population;
        }

        public Country(String countryName, String continent, int population, String phoneCode) {
            this(countryName, continent, population);
            this.phoneCode = phoneCode;
        }

        public Country(String countryName, String continent, int population, String phoneCode, String capitalCity) {
            this(countryName, continent, population, phoneCode);
            this.capitalCity = capitalCity;
        }

        public Country(String countryName, String continent, int population, String phoneCode, String capitalCity, ArrayList<String> cities) {
            this(countryName, continent, population, phoneCode, capitalCity);
            this.cities = cities;
        }

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

        @Override
        public String toString() {
            return "Country{" +
                    "countryName='" + countryName + '\'' +
                    ", continent='" + continent + '\'' +
                    ", population=" + population +
                    ", phoneCode='" + phoneCode + '\'' +
                    ", capitalCity='" + capitalCity + '\'' +
                    ", cities=" + cities +
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
            Country country = (Country) o;
            return countryName.equals(country.countryName) &&
                    continent.equals(country.continent) &&
                    population == country.population &&
                    phoneCode.equals(country.phoneCode) &&
                    capitalCity.equals(country.capitalCity) &&
                    cities.equals(country.cities);
        }

        @Override
        public int hashCode() {
            return Objects.hash(countryName, continent, population, phoneCode, capitalCity, cities);
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
        System.out.println(country);

        Country country1 = new Country();
        country1.inputDetails();

        System.out.println("\nЧи об'єкти однакові:");
        System.out.println(country.equals(country1));
    }
}
