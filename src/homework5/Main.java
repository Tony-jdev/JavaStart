package homework5;

import homework5.exceptions.atm.ATMException;
import homework5.exceptions.user.ATMWrongNominalException;
import homework5.models.ATM;
import homework5.models.Bank;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank(5);
        bank.initialize();
        System.out.println(bank);

        ATM atm = bank.getAtms().get(0);

        System.out.println("\nМи працюємо з першим ATM:\n" + atm);

        Scanner scanner = new Scanner(System.in);
        int choice;
        int amount;

        do {
            System.out.println("\nМеню банкомату:\n" +
                    "1. Зняти гроші\n" +
                    "2. Внести гроші\n" +
                    "3. Завершити роботу\n");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Введіть суму для зняття: ");
                    amount = scanner.nextInt();
                    try {
                        atm.withdraw(amount);
                    } catch (ATMException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> {
                    boolean finished = false;
                    int totalDeposit = 0;
                    while (!finished) {
                        System.out.println("Внесіть купюру: ");
                        amount = scanner.nextInt();

                        try {
                            atm.depositBanknote(amount);
                            totalDeposit += amount;
                        } catch (ATMWrongNominalException e) {
                            System.out.println(e.getMessage());
                        }

                        System.out.println("Внесено коштів: " + totalDeposit);

                        System.out.println("Бажаєте продовжити внесення коштів? (y/n)");
                        String input = scanner.next();
                        if (input.equals("n")) {
                            finished = true;
                        }
                    }
                }
                case 3 -> System.out.println("Вихід з банкомату.");
                default -> System.out.println("Недопустима дія.");
            }
            System.out.println("\n" + atm);
        } while (choice != 3);
    }
}