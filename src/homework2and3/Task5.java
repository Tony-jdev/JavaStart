package homework2and3;

import java.util.Objects;
import java.util.Scanner;

//Реализуйте класс «Книга». Необходимо хранить в полях класса: название книги, ФИО автора, год выпуска,
//название издательства, жанр книги, количество страниц.
//Реализуйте конструкторы и методы класса для ввода
//данных, вывода данных, реализуйте доступ к отдельным
//полям через методы класса. Используйте механизм перегрузки методов.

public class Task5 {

    public static class Book {
        private String name;
        private String author;
        private int year;
        private String publisher;
        private String genre;
        private int pages;

        public Book() {}

        public Book(String name) {
            this.name = name;
        }

        public Book(String name, String author) {
            this(name);
            this.author = author;
        }

        public Book(String name, String author, int year) {
            this(name, author);
            this.year = year;
        }
        public Book(String name, String author, int year, String publisher) {
            this(name, author, year);
            this.publisher = publisher;
        }
        public Book(String name, String author, int year, String publisher, String genre) {
            this(name, author, year, publisher);
            this.genre = genre;
        }
        public Book(String name, String author, int year, String publisher, String genre, int pages) {
            this(name, author, year, publisher, genre);
            this.pages = pages;
        }

        private boolean isValidNumber(String input) {
            try {
                int number = Integer.parseInt(input);
                return number >= 0;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        public void inputDetails() {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Введіть назву книги: ");
            setName(scanner.nextLine());

            System.out.print("Введіть автора книги: ");
            setAuthor(scanner.nextLine());

            String yearInput;
            do {
                System.out.print("Введіть рік видання книги: ");
                yearInput = scanner.nextLine();
            } while (!isValidNumber(yearInput));
            setYear(Integer.parseInt(yearInput));

            System.out.print("Введіть назву видавництва книги: ");
            setPublisher(scanner.nextLine());

            System.out.print("Введіть жанр книги: ");
            setGenre(scanner.nextLine());

            String pagesInput;
            do {
                System.out.print("Введіть кількість сторінок книги: ");
                pagesInput = scanner.nextLine();
            } while (!isValidNumber(pagesInput));
            setPages(Integer.parseInt(pagesInput));
        }

        public void showDetails() {
            System.out.println("Назва книги: " + this.name);
            System.out.println("Автор книги: " + this.author);
            System.out.println("Рік видання книги: " + this.year);
            System.out.println("Назва видавництва книги: " + this.publisher);
            System.out.println("Жанр книги: " + this.genre);
            System.out.println("Кількість сторінок книги: " + this.pages);
        }

        @Override
        public String toString() {
            return "Book{" +
                    "name='" + name + '\'' +
                    ", author='" + author + '\'' +
                    ", year=" + year +
                    ", publisher='" + publisher + '\'' +
                    ", genre='" + genre + '\'' +
                    ", pages=" + pages +
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
            Book book = (Book) o;
            return name.equals(book.name) &&
                    author.equals(book.author) &&
                    year == book.year &&
                    publisher.equals(book.publisher) &&
                    genre.equals(book.genre) &&
                    pages == book.pages;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, author, year, publisher, genre, pages);
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public String getName() {
            return this.name;
        }

        public String getAuthor() {
            return this.author;
        }

        public int getYear() {
            return this.year;
        }

        public String getPublisher() {
            return this.publisher;
        }

        public String getGenre() {
            return this.genre;
        }

        public int getPages() {
            return this.pages;
        }
    }

    public static void main(String[] args) {
        Book book = new Book();
        book.inputDetails();

        System.out.println("\nВведені дані:");
        System.out.println(book);
        System.out.println();

        Book book1 = new Book();
        book1.inputDetails();

        System.out.println("\nЧи об'єкти однакові:");
        System.out.println(book.equals(book1));
    }
}
