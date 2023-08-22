package homework2;

import java.util.Scanner;

//Создайте класс «Дробь». Необходимо хранить в полях
//класса: числитель и знаменатель. Реализуйте методы класса для ввода данных, вывода данных, реализуйте доступ
//к отдельным полям через методы класса. Также создайте
//методы класса для выполнения арифметических операций
//(сложение, вычитание, умножение, деление, и т.д.).
public class Task4 {

    public static class Fraction {
        private int numerator;
        private int denominator;

        public void inputFraction() {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Введіть чисельник: ");
            setNumerator(scanner.nextInt());

            System.out.print("Введіть знаменник: ");
            int denominatorInput = scanner.nextInt();
            while (denominatorInput == 0) {
                System.out.println("Знаменник не може бути рівний нулю. Введіть знову: ");
                denominatorInput = scanner.nextInt();
            }
            setDenominator(denominatorInput);
        }

        public void showFraction() {
            System.out.println(getNumerator() + "/" + getDenominator());
        }

        public Fraction add(Fraction other) {
            int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
            int newDenominator = this.denominator * other.denominator;
            return simplifyFraction(newNumerator, newDenominator);
        }

        public Fraction subtract(Fraction other) {
            int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
            int newDenominator = this.denominator * other.denominator;
            return simplifyFraction(newNumerator, newDenominator);
        }

        public Fraction multiply(Fraction other) {
            int newNumerator = this.numerator * other.numerator;
            int newDenominator = this.denominator * other.denominator;
            return simplifyFraction(newNumerator, newDenominator);
        }

        public Fraction divide(Fraction other) {
            if (other.numerator == 0) {
                throw new ArithmeticException("Ділення на нуль");
            }
            int newNumerator = this.numerator * other.denominator;
            int newDenominator = this.denominator * other.numerator;
            return simplifyFraction(newNumerator, newDenominator);
        }

        private int gcd(int a, int b) {
            if (b == 0) {
                return a;
            }
            return gcd(b, a % b);
        }

        private Fraction simplifyFraction(int numerator, int denominator) {
            int gcd = gcd(numerator, denominator);
            numerator /= gcd;
            denominator /= gcd;

            if (denominator < 0) {
                numerator = -numerator;
                denominator = -denominator;
            }

            Fraction simplifiedFraction = new Fraction();
            simplifiedFraction.setNumerator(numerator);
            simplifiedFraction.setDenominator(denominator);
            return simplifiedFraction;
        }

        public void setNumerator(int numerator) {
            this.numerator = numerator;
        }

        public void setDenominator(int denominator) {
            if (denominator == 0) {
                throw new IllegalArgumentException("Знаменник не може бути рівний нулю");
            }
            this.denominator = denominator;
        }

        public int getNumerator() {
            return numerator;
        }

        public int getDenominator() {
            return denominator;
        }
    }

    public static void main(String[] args) {
        Fraction fraction1 = new Fraction();
        Fraction fraction2 = new Fraction();

        System.out.println("Введіть першу дріб:");
        fraction1.inputFraction();

        System.out.println("Введіть другу дріб:");
        fraction2.inputFraction();

        System.out.println("\nПерша дріб: ");
        fraction1.showFraction();

        System.out.println("Друга дріб: ");
        fraction2.showFraction();

        Fraction sum = fraction1.add(fraction2);
        System.out.println("Сума дріб: ");
        sum.showFraction();

        Fraction difference = fraction1.subtract(fraction2);
        System.out.println("Різниця дріб: ");
        difference.showFraction();

        Fraction product = fraction1.multiply(fraction2);
        System.out.println("Добуток дріб: ");
        product.showFraction();

        Fraction divide = fraction1.divide(fraction2);
        System.out.println("Частка дріб: ");
        divide.showFraction();
    }
}
