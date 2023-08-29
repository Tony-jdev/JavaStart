package homework5.models;

import homework5.exceptions.atm.ATMException;
import homework5.exceptions.atm.operation.ATMNotEnoughBanknotesException;
import homework5.exceptions.atm.operation.ATMNotEnoughMoneyException;
import homework5.exceptions.user.ATMWrongAmountException;
import homework5.exceptions.user.ATMWrongNominalException;

import java.util.*;
import java.util.stream.Collectors;

public class ATM {
    private Map<Integer, Integer> banknotes;
    private int minAmount;
    private int maxCount;

    public ATM(int minAmount, int maxCount) {
        this.banknotes = new HashMap<>();
        this.minAmount = minAmount;
        this.maxCount = maxCount;
    }

    public void initialize() {
        Random random = new Random();
        List<Banknote> banknotes = Arrays.asList(
                new Banknote(500),
                new Banknote(100),
                new Banknote(50),
                new Banknote(20),
                new Banknote(10),
                new Banknote(5),
                new Banknote(2),
                new Banknote(1)
        );
        for (Banknote banknote : banknotes) {
            this.banknotes.put(banknote.getNominal(), random.nextInt(0, 5));
        }
    }

    public void depositBanknote(int nominal) throws ATMWrongNominalException {
        if (nominal == 1 || nominal == 5) {
            throw new ATMWrongNominalException("Не можна вносити купюри номіналом 1 або 5");
        }

        this.banknotes.put(nominal, this.banknotes.getOrDefault(nominal, 0) + 1);
    }

    public void withdraw(int amount) throws ATMException {
        int balance = getBalance();
        if (amount < minAmount) {
            throw new ATMWrongAmountException("Неправильна сума для зняття. Мінімальна сума: " + minAmount);
        }
        else if (amount > balance) {
            throw new ATMNotEnoughMoneyException("Недостатньо грошей у банкоматі. Необхідна сума: " + amount + ", а доступно: " + balance);
        }

        Map<Integer, Integer> withdrawnBanknotes = new HashMap<>();
        List<Integer> sortedNominals = this.banknotes.keySet().stream().sorted(Collections.reverseOrder()).toList();

        int zalishok = amount;
        int countForWithdraw = 0;
        for (int nominal : sortedNominals) {
            if (zalishok > 0) {
                int count = Math.min(this.banknotes.get(nominal), zalishok / nominal);

                countForWithdraw += count;
                if(count > 0 && countForWithdraw > maxCount){
                    throw new ATMNotEnoughBanknotesException("Перевищено максимальну кількість купюр, яку може видати банкомат. Максимальна кількість купюр: " + maxCount + ", а фактично вийшло: " + countForWithdraw);
                }
                if(count > 0){
                    withdrawnBanknotes.put(nominal, withdrawnBanknotes.getOrDefault(nominal, 0) + count);
                }
                zalishok -= count * nominal;
            } else {
                break;
            }
        }

        if (zalishok > 0) {
            throw new ATMNotEnoughBanknotesException("Недостатньо купюр, щоб видати суму " + amount);
        }

        for (int nominal : withdrawnBanknotes.keySet()) {
            this.banknotes.put(nominal, this.banknotes.get(nominal) - withdrawnBanknotes.get(nominal));
        }

        System.out.println("Купюри до видачі: ");
        withdrawnBanknotes.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));
    }

    public int getBalance() {
        int balance = 0;
        for (int nominal : this.banknotes.keySet()) {
            balance += nominal * this.banknotes.get(nominal);
        }
        return balance;
    }

    @Override
    public String toString() {
        return "ATM{" +
                "\nbanknotes= " + banknotes.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> entry.getKey() + " - " + entry.getValue())
                .collect(Collectors.joining(", ")) +
                "\nminAmount=" + minAmount +
                "\nmaxCount=" + maxCount +
                "}\n";
    }

    public int getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(int minAmount) {
        this.minAmount = minAmount;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }
}