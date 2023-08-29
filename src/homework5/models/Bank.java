package homework5.models;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private int countOfAtms;
    private List<ATM> atms;

    public Bank(int countOfAtms) {
        this.countOfAtms = countOfAtms;
        this.atms = new ArrayList<>(countOfAtms);
    }

    public void initialize() {
        for (int i = 0; i < countOfAtms; i++) {
            atms.add(new ATM(100, 40));
            atms.get(i).initialize();
        }
    }

    public int getTotalMoney() {
        int totalMoney = 0;
        for (ATM atm : atms) {
            totalMoney += atm.getBalance();
        }
        return totalMoney;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "\ncountOfAtms=" + countOfAtms +
                "\natms=" + atms +
                '}';
    }

    public int getCountOfAtms() {
        return countOfAtms;
    }

    public void setCountOfAtms(int countOfAtms) {
        this.countOfAtms = countOfAtms;
    }

    public List<ATM> getAtms() {
        return atms;
    }

    public void setAtms(List<ATM> atms) {
        this.atms = atms;
    }
}