package homework5.exceptions.atm.operation;

public class ATMNotEnoughBanknotesException extends ATMOperationException  {

    public ATMNotEnoughBanknotesException(String message) {
        super(message);
    }
}
