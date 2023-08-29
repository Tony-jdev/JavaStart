package homework5.exceptions.atm.operation;

public class ATMNotEnoughMoneyException extends ATMOperationException  {

    public ATMNotEnoughMoneyException(String message) {
        super(message);
    }
}
