package homework2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

//Реализуйте класс «Человек». Необходимо хранить
//в полях класса: ФИО, дату рождения, контактный телефон, город, страну, домашний адрес. Реализуйте методы
//класса для ввода данных, вывода данных, реализуйте
//доступ к отдельным полям через методы класса.

public class Task1 {

    public static class Person {
        private String fullName;
        private Date birthDate;
        private String phone;
        private String city;
        private String country;
        private String address;

        private boolean isValidPhoneNumber(String phoneNumber) {
            String phonePattern = "\\+380\\d{9}";
            return Pattern.matches(phonePattern, phoneNumber);
        }

        private boolean isValidBirthDate(String birthDate) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            dateFormat.setLenient(false);
            try {
                Date date = dateFormat.parse(birthDate);
                setBirthDate(date);
                return true;
            } catch (ParseException e) {
                return false;
            }
        }

        public void inputDetails() {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Введіть ПІБ: ");
            setFullName(scanner.nextLine());

            String phoneNumber;
            do {
                System.out.print("Введіть номер телефону (+380xxxxxxxxx): ");
                phoneNumber = scanner.nextLine();
            } while (!isValidPhoneNumber(phoneNumber));
            setContactPhone(phoneNumber);

            String birthDate;
            do {
                System.out.print("Введіть дату народження (dd.MM.yyyy): ");
                birthDate = scanner.nextLine();
            } while (!isValidBirthDate(birthDate));

            System.out.print("Введіть місто: ");
            setCity(scanner.nextLine());

            System.out.print("Введіть країну: ");
            setCountry(scanner.nextLine());

            System.out.print("Введіть домашню адресу: ");
            setHomeAddress(scanner.nextLine());
        }

        public void showDetails() {
            System.out.println("ПІБ: " + getFullName());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            System.out.println("Дата народження: " + dateFormat.format(getBirthDate()));
            System.out.println("Контактний телефон: " + getContactPhone());
            System.out.println("Місто: " + getCity());
            System.out.println("Країна: " + getCountry());
            System.out.println("Домашня адреса: " + getHomeAddress());
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public void setBirthDate(Date birthDate) {
            this.birthDate = birthDate;
        }

        public void setContactPhone(String contactPhone) {
            this.phone = contactPhone;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public void setHomeAddress(String homeAddress) {
            this.address = homeAddress;
        }

        public String getFullName() {
            return fullName;
        }

        public Date getBirthDate() {
            return birthDate;
        }

        public String getContactPhone() {
            return phone;
        }

        public String getCity() {
            return city;
        }

        public String getCountry() {
            return country;
        }

        public String getHomeAddress() {
            return address;
        }
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.inputDetails();

        System.out.println("\nВведені дані:");
        person.showDetails();
    }
}
