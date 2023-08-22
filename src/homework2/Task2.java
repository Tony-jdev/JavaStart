package homework2;

import java.util.Scanner;

//Создайте класс «Город». Необходимо хранить в полях класса: название города, название региона, название
//страны, количество жителей в городе, почтовый индекс
//города, телефонный код города. Реализуйте методы класса для ввода данных, вывода данных, реализуйте доступ
//к отдельным полям через методы класса.

public class Task2 {

    public static class City {
        private String cityName;
        private String region;
        private String country;
        private int population;
        private String postalCode;
        private String phoneCode;

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

            System.out.print("Введіть назву міста: ");
            setCityName(scanner.nextLine());

            System.out.print("Введіть назву регіону: ");
            setRegionName(scanner.nextLine());

            System.out.print("Введіть назву країни: ");
            setCountryName(scanner.nextLine());

            String populationInput;
            do {
                System.out.print("Введіть кількість жителів: ");
                populationInput = scanner.nextLine();
            } while (!isValidPopulation(populationInput));
            setPopulation(Integer.parseInt(populationInput));

            System.out.print("Введіть поштовий індекс: ");
            setPostalCode(scanner.nextLine());

            System.out.print("Введіть телефонний код: ");
            setPhoneCode(scanner.nextLine());
        }

        public void showDetails() {
            System.out.println("Назва міста: " + getCityName());
            System.out.println("Назва регіону: " + getRegionName());
            System.out.println("Назва країни: " + getCountryName());
            System.out.println("Кількість жителів: " + getPopulation());
            System.out.println("Поштовий індекс: " + getPostalCode());
            System.out.println("Телефонний код: " + getPhoneCode());
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public void setRegionName(String regionName) {
            this.region = regionName;
        }

        public void setCountryName(String countryName) {
            this.country = countryName;
        }

        public void setPopulation(int population) {
            this.population = population;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

        public void setPhoneCode(String phoneCode) {
            this.phoneCode = phoneCode;
        }

        public String getCityName() {
            return cityName;
        }

        public String getRegionName() {
            return region;
        }

        public String getCountryName() {
            return country;
        }

        public int getPopulation() {
            return population;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public String getPhoneCode() {
            return phoneCode;
        }
    }

    public static void main(String[] args) {
        City city = new City();
        city.inputDetails();

        System.out.println("\nВведені дані:");
        city.showDetails();
    }
}
