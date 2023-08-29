package homework5.models;

public class Banknote {
    private final int nominal;

    public Banknote(int nominal) {
        this.nominal = nominal;
    }

    public int getNominal() {
        return nominal;
    }

    @Override
    public String toString() {
        return "" + nominal;
    }
}
